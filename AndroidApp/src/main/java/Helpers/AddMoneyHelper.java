package Helpers;

import PageObject.AddMoneyPage;
import PageObject.HomePage;
import PageObject.TransactionHistoryPage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.*;

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
    TransactionHistoryPage transactionHistoryPage;
    PermissionHelper permissionHelper;

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
        permissionHelper = new PermissionHelper(driver);

    }

    public void netbanking(String amount, String bankName, String bankPageLocator, String bankPageLocatorType) throws InterruptedException, IOException, JSONException {
//        Thread.sleep(3000);
//        homePage.clickOnCrossButton();
//        Thread.sleep(1000);

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);
        Thread.sleep(1000);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUpMore(driver);

        if (Element.isElementPresent(driver, By.xpath("//*[@text = 'Net Banking']"))) {

            addMoneyPage.clickOnNetbanking();

            Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = '" + bankName + "']"));
            AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + bankName + "']"));
            Element.selectElement(driver, androidElement, bankName);

            Element.waitForVisibility(driver, addMoneyPage.label_make_payment);

            if (bankPageLocatorType.equalsIgnoreCase("xpath")) {
                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath(bankPageLocator)), "Bank Screen | Verify Locator", false, false);
//            Log.info(bankPageLocator + "in if ");
//            Log.info(bankPageLocatorType + "in if");
            } else {
//            Log.info(bankPageLocator + "in else");
//            Log.info(bankPageLocatorType + "in else");
                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id(bankPageLocator)), "Bank Screen | Verify Locator", false, false);
            }
            mbkCommonControlsHelper.clickUpButton();

            addMoneyPage.clickOnYesButton();

        } else {

            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//*[@text = 'Net Banking']")) == false, "Netbanking feature has been disabled", true, true);

            mbkCommonControlsHelper.clickUpButton();

        }

    }


    public void addMoneyViaNewCard(String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String bankPassword, String successPageStatus, String successPageText) throws InterruptedException, IOException, JSONException {
        Log.info("START", "Add Money");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);
        Log.info("cardNo : " + cardNo);
        Log.info("expiryMonth : " + expiryMonth);
        Log.info("expiryYear : " + expiryYear);
        Log.info("cvv : " + cvv);
        Log.info("bankPassword : " + bankPassword);
        Log.info("successPageStatus : " + successPageStatus);
        Log.info("successPageText : " + successPageText);
        Log.info("-------------------------------------");

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        homePage.clickBalanceDropDown();
        addMoneyPage = homePage.clickOnAddMoneyButton();

        // Click on the text box and Enter amount
        addMoneyPage.clickOnAmountTextBox();
        addMoneyPage.enterAmount(amount);

        Thread.sleep(1000);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUpMore(driver);

        addMoneyPage.clickOnNewDebitCreditCard();

        enterCardDetails(cardNo, expiryMonth, expiryYear, cvv);


        addMoneyPage.clickOnPayNow();

        permissionHelper.permissionAllow();

        handleIndusindWebView(bankPassword);

        boolean condition = false;

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Unfortunately some processing error occurred at the bank and the transaction failed.Please try again.']"))) {
            condition = true;
            mbReporter.verifyTrueWithLogging(condition, "Add Money Failed due to Insufficient Balance in Bank Account", true, false);

        }
        //Assertions
        Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
        Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), successPageText, "Success Screen | Verify Text", false, false);
        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);

        Log.info("END", "Add Money");

    }


    public void addMoneyViaSavedCard(String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String bankPassword, String successPageStatus, String successPageText, Boolean promoCodeStatus, String promoCode) throws InterruptedException, IOException, JSONException {
//        Thread.sleep(1000);
//        homePage.clickOnCrossButton();
//        Thread.sleep(1000);

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUpMedium(driver);

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + cardNo + "']"));
        Element.selectElement(driver, androidElement, "Select Bank");

        addMoneyPage.enterCvv(cvv);

        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeAddMoney(promoCode);
        }

        addMoneyPage.clickOnPayNow();

        permissionHelper.permissionAllow();

        handleIndusindWebView(bankPassword);

        boolean condition = false;

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Unfortunately some processing error occurred at the bank and the transaction failed.Please try again.']"))) {
            condition = true;
            mbReporter.verifyTrueWithLogging(condition, "Add Money Failed due to Insufficient Balance in Bank Account", true, false);

        }
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

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();

        Double expectedMainBalanceAfter;
        Double expectedSuperCashBalanceAfter;

        if (promoCodeStatus) {
            expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
            expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100 + 1 * 100;

        } else {
            expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
            expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        }
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
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

    public void addMoneyViaSavedCardWithinFlow(String amount, String cardNo, String cvv, String bankPassword) throws InterruptedException, IOException, JSONException {
//        Thread.sleep(1000);
//        homePage.clickOnCrossButton();
//        Thread.sleep(1000);

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        Thread.sleep(1000);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUpMedium(driver);

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + cardNo + "']"));
        Element.selectElement(driver, androidElement, "Select Bank");

        addMoneyPage.enterCvv(cvv);

        addMoneyPage.clickOnPayNow();

        permissionHelper.permissionAllow();

        handleIndusindWebView(bankPassword);

        boolean condition = false;

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Unfortunately some processing error occurred at the bank and the transaction failed.Please try again.']"))) {
            condition = true;
            mbReporter.verifyTrueWithLogging(condition, "Add Money Failed due to Insufficient Balance in Bank Account", true, false);

        }


        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

    }

    public void refundAddedMoney(String amount, String cardNo, String expiryMonth, String expiryYear, String cvv, String bankPassword, String successPageStatus, String successPageText, Boolean promoCodeStatus, String promoCode) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUpMedium(driver);

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + cardNo + "']"));
        Element.selectElement(driver, androidElement, "Select Bank");

        addMoneyPage.enterCvv(cvv);

        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeAddMoney(promoCode);
        }

        addMoneyPage.clickOnPayNow();

        permissionHelper.permissionAllow();

        handleIndusindWebView(bankPassword);

        // Success Page Assertions
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), successPageText, "Success Page Text", false, false);

//        if (promoCodeStatus) {
//            String actualBalanceText = addMoneyPage.getSuccessPageWalletBalance().replace(",", "");
//            Double bal = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) + Double.parseDouble(amount);
//            String expectedBalanceText = "New Wallet Balance X" + Helper.formatString(bal).replace(",", "") + ". Coupon " + promoCode.toUpperCase() + " was redeemed successfully for SuperCash of  " + "1";
//            mbReporter.verifyEqualsWithLogging(actualBalanceText, expectedBalanceText, "Success screen | Verify Balance text", false, false);
//        } else {
//            Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
//            Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
//            mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);
//        }

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        balanceBefore = mbkCommonControlsHelper.getBalance();


        transactionHistoryPage = homePage.clickOnBottomBarHistory();


        Element.waitForVisibility(driver, By.id("download_statement"));

        transactionHistoryPage.clickOnAddMoneyTransactionOfSixRupees();

        Element.waitForVisibility(driver, By.id("txt_txn_product"));

        transactionHistoryPage.clickOnRefundCta();

        Element.waitForVisibility(driver, By.id("vertical_button_1"));
        transactionHistoryPage.clickOnIntiateRefundCta();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Refund Initiated']"));

        mbReporter.verifyEqualsWithLogging(transactionHistoryPage.getRefundMessage(), "MobiKwik has initiated the refund to the respective financial instrument (Bank Account/Cards/UPI) used while adding Money. This would take 3 to 7 business days (Excluding Saturdays and Sundays).", "Refund is Succesfull", true, true);

        transactionHistoryPage.navigateBackToHome();

        homePage.clickOnBottomBarHome();

        // POST TRX Assertions


        balanceAfter = mbkCommonControlsHelper.getBalance();

        Double expectedMainBalanceAfter;
        Double expectedSuperCashBalanceAfter;

        if (promoCodeStatus) {
            expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
            expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100 + 1 * 100;

        } else {
            expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
            expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;

        }
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);


    }


    public void addMoneyInsufficientFunds(String cardNo, String cvv, String bankPassword) throws InterruptedException, IOException, JSONException {


        addMoneyPage = new AddMoneyPage(driver);
        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUpMedium(driver);

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + cardNo + "']"));
        Element.selectElement(driver, androidElement, "Select Bank");

        addMoneyPage.enterCvv(cvv);

        addMoneyPage.clickOnPayNow();

        permissionHelper.permissionAllow();

        handleIndusindWebView(bankPassword);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Unfortunately some processing error occurred at the bank and the transaction failed.Please try again.']")), "Add Money Failed due to Insufficient Balance in Bank Account", true, false);


    }

}
