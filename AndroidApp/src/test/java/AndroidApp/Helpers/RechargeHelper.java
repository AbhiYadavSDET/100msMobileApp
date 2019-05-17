package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.RechargePage;

import java.io.IOException;
import java.util.HashMap;

public class RechargeHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    RechargePage rechargePage;
    PermissionHelper permissionHelper;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public RechargeHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }

    public void prepaidRecharge(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin) throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargePage.enterMobileNo(mobileNo);

        rechargePage.clickOnDropDown();

        screen.swipeUp();
        rechargePage.selectOperator();

        rechargePage.selectCircle();

        rechargePage.selectAmount();

        rechargePage.enterAmount(amount);

        rechargePage.clickOnContinue();

        rechargePage.clickOnCtaCotinue();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);

        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageStatus(), trxStatus, "Success Page | Verify Status", false, false);
        mbkCommonControlsHelper.handleCTOverlay();

        // Assertions on the success screen
        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageConnectionNo(), mobileNo, "Success Page | Verify Connection number", false, false);
        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageCategory(), category, "Success Page | Verify category", false, false);
        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageOperator(), operator, "Success Page | Verify operator", false, false);
        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageAmount().replace("₹ ", ""), amount, "Success Page | Verify amount", false, false);
        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageTotalPayment().replace("₹ ", ""), totalPayment, "Success Page | Verify totalPayment", false, false);


        mbkCommonControlsHelper.returnToHomePageFromRechargeSuccessScreen();

        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Post TRX assertions
        Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;

        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);

    }

    public void postpaidPayment(String mobileNo, String popupError, String popupText) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargePage.enterMobileNo(mobileNo);

        rechargePage.clickOnCtaContinue2();

        Element.waitForVisibility(driver, rechargePage.popup);

        // Assertions
        String actualPopupError = rechargePage.getPopupError();
        String actualPopupText = rechargePage.getPopupText();

        mbReporter.verifyEqualsWithLogging(actualPopupError, popupError, "Success Page | Verify Connection number", false, false);
        mbReporter.verifyEqualsWithLogging(actualPopupText, popupText, "Success Page | Verify category", false, false);


        rechargePage.clickOnPopupCross();

        mbkCommonControlsHelper.clickUpButton();
        mbkCommonControlsHelper.clickUpButton();

    }

    public void postpaidPaymentViaSavedConnection(String mobileNo, String popupText, String category, String operator) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();


        if (selectSavedConnection(mobileNo, category, operator)) {

            String actualViewBillText = rechargePage.getViewBillText();
            mbReporter.verifyEqualsWithLogging(actualViewBillText, popupText, "View Bill | Verify text", false, false);
            mbkCommonControlsHelper.clickUpButton();
            mbkCommonControlsHelper.clickUpButton();

        } else {
            Log.info("The saved connection is not present");
            mbkCommonControlsHelper.clickUpButton();
        }


    }

    public void rechargeDthInvalidAmount(String mobileNo, String amount, String securityPin) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();

        rechargePage = homePage.clickOnDthButton();

        permissionHelper.permissionAllow();

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + mobileNo + "']"));
        Element.selectElement(driver, androidElement, "Select Saved Connection");

        rechargePage.enterDthAmount(amount);

        rechargePage.clickOnDthContinueCta();

        rechargePage.clickOnCtaCotinue();


        Thread.sleep(5000);
        mbReporter.screenShot1("toast", "rechargeInvalidAmount");

        // Handle the toast message


    }

    public boolean selectSavedConnection(String mobileNo, String category, String operator) throws InterruptedException {


        for (int i = 0; i < 6; i++) {
            if (Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"))) {
                Log.info("SCROLL", "Screen");
                Screen.swipeUp();

                Log.info("SELECT", "Saved Connection");
                AndroidElement androidElement = element.findElement(driver, By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"));
                Element.selectElement(driver, androidElement, "Select Connection");
                return true;
            } else {
                Log.info("SCROLL", "More");
                Screen.swipeUp();

                Thread.sleep(2000);
            }
        }

        return false;
    }


}
