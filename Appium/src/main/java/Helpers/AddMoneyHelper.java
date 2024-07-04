package Helpers;

import PageObject.*;
import Helpers.IndusindBankPaymentPageHelper;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import Logger.Log;
import Utils.MBReporter;
import Utils.Screen;
import org.openqa.selenium.By;

import java.io.IOException;

import java.util.HashMap;

public class AddMoneyHelper {

    AndroidDriver driver;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    SecurityPinPage securityPinPage;
    Screen screen;

    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionPage permissionPage;

    PermissionHelper permissionHelper;
    IndusindBankPaymentPageHelper indusindBankPaymentPageHelper;

    UpiPage upiPage;


    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    private Object AndroidElement;


    public AddMoneyHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        addMoneyPage = new AddMoneyPage(driver);
        homePage = new HomePage(driver);
        screen = new Screen(driver);

        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionPage = new PermissionPage(driver);
        indusindBankPaymentPageHelper = new IndusindBankPaymentPageHelper(driver);
        upiPage=new UpiPage(driver);
        permissionHelper=new PermissionHelper(driver);

    }

    /**
     * This method is to Test standalone add money Flow.
     * Flow Can Be "SavedCard" or "NewCard"
     */



    public void addMoneyViaCard(String amount, String cvv , String expTitle, String expSubTitle, String expAmount,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus, String deviceId) throws InterruptedException, IOException {

        Log.info("START", "Add Money");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);
        Log.info("cvv : " + cvv);
        Log.info("-------------------------------------");

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on the profile
        securityPinPage.clickOnProfile();

        // Click on add Money
        addMoneyPage.clickOnAddMoney();

        // Enter amount
        addMoneyPage.enterAmount(amount);

        // Click on Add
        addMoneyPage.clickOnAdd();

        // Select More Payment Options
        addMoneyPage.selectMorePaymentOptions();

        // Click on Indusind Bank
        addMoneyPage.clickOnIndusindBank();

        // Enter CVV
        addMoneyPage.enterCVV(cvv);

        // Click on Pay
        addMoneyPage.clickOnPay();

        Thread.sleep(3000);

        if(permissionPage.isPermissionMessagePresent()){
            permissionPage.allowPermissionMessage();
        }

        indusindBankPaymentPageHelper.paymentPageHelper(deviceId);

        // Verification on the Success Screen
        String title = addMoneyPage.getTitleOnSuccess();
        String subTitle = addMoneyPage.getSubTitleOnSuccess();
        String amountOnSuccess = addMoneyPage.getAmountOnSuccess();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Amount : " + amountOnSuccess);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false,true);
        mbReporter.verifyEqualsWithLogging(amountOnSuccess, expAmount, "Verify Amount", false, false,true);


        mbkCommonControlsHelper.pressback(3);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Add");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);
    }

    public void addMoneyViaUPI(String amount, String expTitle, String expSubTitle, String expAmount,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus, String pin) throws InterruptedException, IOException {

        Log.info("START", "Add Money Via UPI");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);
        Log.info("-------------------------------------");

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on the profile
        securityPinPage.clickOnProfile();

        // Click on add Money
        addMoneyPage.clickOnAddMoney();

        // Enter amount
        addMoneyPage.enterAmount(amount);

        // Click on Add
        addMoneyPage.clickOnAdd();

        // Select More Payment Options
        addMoneyPage.selectMorePaymentOptions();

        if(upiPage.isRestoreUpiCheckoutWidgetShown()) {

            upiPage.clickOnRestoreUpiCheckout();

            permissionHelper.permissionAllow();
            permissionHelper.permissionAllow();
            permissionHelper.permissionAllow();


            Thread.sleep(3000);
            mbReporter.verifyTrueWithLogging(!upiPage.isRestoreUpiCheckoutWidgetShown(), "Upi Restore Verification", false, false );

            upiPage.clickOnUpiAccountInCheckout();

            addMoneyPage.clickOnPay();

            Thread.sleep(3000);

            //2FA Validation Page Assertions
           // Element.waitForVisibility(driver, By.id("btn_verify"));
            mbkCommonControlsHelper.handle2FADeviceBindingFlow();

            mbkCommonControlsHelper.handleUpiPin(pin);

           // Thread.sleep(6000);

            // Verification on the Success Screen
            String title = addMoneyPage.getTitleOnSuccess();
            String subTitle = addMoneyPage.getSubTitleOnSuccess();
            String amountOnSuccess = addMoneyPage.getAmountOnSuccess();

            // Display the values
            Log.info("Title : " + title);
            Log.info("Sub Title : " + subTitle);
            Log.info("Amount : " + amountOnSuccess);

            // Add the assertions
            mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(subTitle, expSubTitle, "Verify Sub Title", false, false, true);
            mbReporter.verifyEqualsWithLogging(amountOnSuccess, expAmount, "Verify Amount", false, false, true);


            mbkCommonControlsHelper.pressback(1);

            // Click on the back button if the bottom sheet is present
            mbkCommonControlsHelper.handleHomePageLanding();

            // Get the Balance if the User Before TRX
            balanceAfter = mbkCommonControlsHelper.getBalance();


            // Assertions on the balance deducted
            mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Add");

            // Verify the History details
            mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);

        }else {

            mbReporter.verifyTrueWithLogging(upiPage.isRestoreUpiCheckoutWidgetShown(), "Upi Restore Widget shown", false, false);

        }



        }





}


