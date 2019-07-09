package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import net.sourceforge.tess4j.TesseractException;
import org.json.JSONException;
import org.omg.PortableServer.THREAD_POLICY_ID;
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

    public void prepaidRecharge(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException, IOException, JSONException {
        Thread.sleep(2000);
        homePage.clickOnCrossButton();

        balanceBefore = mbkCommonControlsHelper.getBalance();

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargePage.enterMobileNo(mobileNo);

        rechargePage.clickOnDropDown();

        screen.swipeUp();
        rechargePage.selectOperator();

        rechargePage.selectCircle();
        screen.swipeUp();
        screen.swipeDown();
        screen.swipeUp();
        screen.swipeDown();

        rechargePage.selectAmount();

        rechargePage.enterAmount(amount);

        rechargePage.clickOnContinue();

        // Apply coupon code if applicable
        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeRecharge(promoCode);
        }

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


        // Assert the Success page in case promo code is applied
        if (promoCodeStatus) {
            String actualPromoCodeText = rechargePage.getPromoCodeTextOnSuccessScreen();
            String expectedPromoCodeText = "Congrats! SuperCash worth ₹ " + promoCodeText + " will be credited within 48 hours";
            mbReporter.verifyEqualsWithLogging(actualPromoCodeText, expectedPromoCodeText, "After TRX | Verify Promo Code Text", false, false);

        }

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
        homePage.clickOnCrossButton();

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargePage.enterMobileNo(mobileNo);
        Thread.sleep(3000);
        rechargePage.clickOnPostPaid();


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
        homePage.clickOnCrossButton();

        rechargePage = homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();


        if (selectSavedConnection(mobileNo, category, operator)) {

            String actualViewBillText = rechargePage.getViewBillText();
            mbReporter.verifyEqualsWithLogging(actualViewBillText, popupText, "View Bill | Verify text", false, false);
            mbkCommonControlsHelper.clickUpButton();
            mbkCommonControlsHelper.clickUpButton();

        } else {
            Log.info("The saved connection is not present");
            //mbkCommonControlsHelper.clickUpButton();
        }


    }

    public void rechargeDthInvalidAmount(String mobileNo, String amount, String securityPin, String errorMessage) throws InterruptedException, IOException, JSONException, TesseractException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
        homePage.clickOnCrossButton();

        rechargePage = homePage.clickOnDthButton();

        permissionHelper.permissionAllow();
        Thread.sleep(5000);
        if(Element.isElementPresent(driver,By.xpath("//android.widget.TextView[@text = '1114514100']"))) {
            AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '1114514100']"));
            Element.selectElement(driver, androidElement, "Select Saved Connection");

            rechargePage.enterDthAmount(amount);

            rechargePage.clickOnDthContinueCta();

            rechargePage.clickOnCtaCotinue();

            mbkCommonControlsHelper.handleSecurityPin(securityPin);

            Thread.sleep(3000);
            String path = mbReporter.screenShot1("toast", "rechargeInvalidAmount");
            Log.info(path);
            String[] text = screen.readToastMessage("screenshots/toast", path).split("\\r?\\n");
            int len = text.length;

            for (String e : text) {
                Log.info(e);
            }
            String actualErrorText = text[len - 2] + text[len - 1];
            mbReporter.verifyEqualsWithLogging(actualErrorText, errorMessage, "Verify Error Message", false, false);
        }
        else
        {
            Log.info("Connection not present");
        }

    }

    public boolean selectSavedConnection(String mobileNo, String category, String operator) throws InterruptedException {


        for (int i = 0; i < 3; i++) {
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


    public void viewBillGas(String operator, String mobileNo) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();
        homePage.clickOnCrossButton();

        homePage.clickMoreIcon();
        rechargePage = homePage.clickGasIcon();

        permissionHelper.permissionAllow();

        rechargePage.clickOnDropDown();

        rechargePage.selectOperator(operator);

        rechargePage.enterBpNumber(mobileNo);

        rechargePage.clickOnCtaContinue2();
        Thread.sleep(3000);
        if(!(Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = 'No dues']"))))
        {

        String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
        String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
        String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();

        mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
        mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);

        mbkCommonControlsHelper.clickUpButton();
        mbkCommonControlsHelper.clickUpButton();}
        else
        {
            Log.info("No dues");
        }

    }

    public void viewBillMtnlDelhi(String operator, String telephoneNo) throws InterruptedException, IOException, JSONException {

        //balanceBefore = mbkCommonControlsHelper.getBalance();

        String[] arr = telephoneNo.split("\\|");
        String expectedtelephoneNo = arr[arr.length - 2];
        String expectedCan = arr[arr.length - 1];
        homePage.clickOnCrossButton();

        homePage.clickMoreIcon();
        rechargePage = homePage.clickLandlineIcon();

        permissionHelper.permissionAllow();

        rechargePage.clickOnDropDown();

        rechargePage.selectOperator(operator);

        rechargePage.enterTelephoneNumber(expectedtelephoneNo);

        rechargePage.enterCanNumber(expectedCan);

        rechargePage.clickOnCtaContinue2();

        String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
        String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
        String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();

        mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, expectedCan, "Success Page | Verify Telephone Number", false, false);
        mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);

        mbkCommonControlsHelper.clickUpButton();
        mbkCommonControlsHelper.clickUpButton();

    }

}
