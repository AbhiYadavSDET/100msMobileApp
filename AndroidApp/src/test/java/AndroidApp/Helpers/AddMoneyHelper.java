package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.*;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.AddMoneyPage;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.util.HashMap;

public class AddMoneyHelper {

    AndroidDriver driver;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public AddMoneyHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");

    }

    public void netbanking(String amount, String bankName, String bankPageLocator) throws InterruptedException, IOException, JSONException {

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        addMoneyPage.clickOnNetbanking();

//        Log.info("Sleeping for 2 seconds");
//        Thread.sleep(2000);

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + bankName + "']"));
        Element.selectElement(driver, androidElement, bankName);


        Element.waitForVisibility(driver, addMoneyPage.label_make_payment);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath(bankPageLocator)), "Bank Screen | Verify Locator", false, false);

        mbkCommonControlsHelper.clickUpButton();

        addMoneyPage.clickOnYesButton();


    }


    public void addMoneyViaNewCard(String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String bankPassword, String successPageStatus, String successPageText) throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        addMoneyPage.clickOnNewDebitCreditCard();

        enterCardDetails(cardNo, expiryMonth, expiryYear, cvv);

        addMoneyPage.clickOnPayNow();

        handleIndusindWebView(bankPassword);

        //Assertions
        Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
        Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), successPageText, "Success Screen | Verify Text", false, false);
        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);

    }


    public void addMoneyViaSavedCard(String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String bankPassword, String successPageStatus, String successPageText, Boolean promoCodeStatus, String promoCode) throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + cardNo + "']"));
        Element.selectElement(driver, androidElement, "Select Bank");

        addMoneyPage.enterCvv(cvv);

        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeAddMoney(promoCode);
        }

        addMoneyPage.clickOnPayNow();

        handleIndusindWebView(bankPassword);

        // Success Page Assertions
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), successPageText, "Success Page Text", false, false);

        if (promoCodeStatus) {
            String actualBalanceText = addMoneyPage.getSuccessPageWalletBalance().replace(",", "");
            Double bal = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) + Double.parseDouble(amount);
            String expectedBalanceText = "New Wallet Balance X" + Helper.formatString(bal).replace(",", "") + ". Coupon " + promoCode.toUpperCase() + " was redeemed successfully for SuperCash of  " + "1";
            mbReporter.verifyEqualsWithLogging(actualBalanceText, expectedBalanceText, "Success screen | Verify Balance text", false, false);
        } else {
            Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
            Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
            mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);
        }

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100 + 1 * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);


    }

    public void fetchDataFromSheet(int rownum) {
        map = new HashMap<String, String>();
        TestDataReader testData = Config.getCachedTestDataReaderObject("addmoney");
        map.put("amount", testData.GetData(rownum, "amount"));
        map.put("bankname", testData.GetData(rownum, "bankname"));
        map.put("bankpagelocator", testData.GetData(rownum, "bankurl"));
        map.put("cardno", testData.GetData(rownum, "cardno"));
        map.put("expirymonth", testData.GetData(rownum, "expirymonth"));
        map.put("expiryyear", testData.GetData(rownum, "expiryyear"));
        map.put("cvv", testData.GetData(rownum, "cvv"));
        map.put("password", testData.GetData(rownum, "password"));
        map.put("successpagestatus", testData.GetData(rownum, "successpagestatus"));
        map.put("successpagetext", testData.GetData(rownum, "successpagetext"));


    }

    public void enterCardDetails(String cardNo, String expiryMonth, String expiryYear, String cvv) throws InterruptedException {
        addMoneyPage.enterCardNo(cardNo);
        addMoneyPage.enterExpiry(expiryMonth + "/" + expiryYear);
        addMoneyPage.enterCvv(cvv);
    }

    public void handleIndusindWebView(String password) throws InterruptedException {
        Element.waitForVisibility(driver, addMoneyPage.label_make_payment);

        addMoneyPage.clickOnBankPageSecurePassword();
        addMoneyPage.clickOnBankPageContinueButton();
        addMoneyPage.enterBankPagePassword(password);
        addMoneyPage.clickOnBankPageSubmitButton();

        Thread.sleep(10000);


    }


}
