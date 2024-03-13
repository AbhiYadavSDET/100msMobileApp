package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpiHelper {

    AndroidDriver driver;
    OnboardingPage onboardingPage;
    HomePage homePage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    Screen screen;
    UpiPage upiPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AddMoneyPage addMoneyPage;
    MbkCommonControlsPage mbkCommonControlsPage;

    Map<String, String> vpaList;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public UpiHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        // Starting page declaration
        onboardingPage = new OnboardingPage(driver);
        permissionHelper = new PermissionHelper(driver);
        screen = new Screen(driver);
        homePage = new HomePage(driver);
        addMoneyPage = new AddMoneyPage(driver);
        mbkCommonControlsPage=new MbkCommonControlsPage(driver);
        upiPage=new UpiPage(driver);


    }

    public void sendMoneyViaUpi(String upiId, String amount, String message, String amountPageTransferName, String pin, String expectedReceiverName) throws InterruptedException, IOException {


        upiPage = homePage.navigateAndSelectUpiSearch();

        upiPage.selectEnterUPI();

        upiPage.enterUpiId(upiId);

        upiPage.selectResultUpi();

        //Amount Page Assertions

        mbReporter.verifyEqualsWithLogging(upiPage.getAmountPageTransferTo(), amountPageTransferName, "Verifying Fetched name", false, false);

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        if(upiPage.isSetupMessageDisplayed()){

            upiPage.clickOnConfirmPayment();
            permissionHelper.permissionAllow();
            permissionHelper.permissionAllow();
            Thread.sleep(3000);
            mbReporter.verifyTrueWithLogging(!upiPage.isSetupMessageDisplayed(), "Upi Restore Verification", false, false );

        }

        upiPage.clickOnConfirmPayment();

        //2FA Validation Page Assertions

        if(upiPage.is2FAPageDisplayed()){

            upiPage.clickOnContinue2FAPage();
            permissionHelper.permissionAllow();
            Thread.sleep(4000);
            mbReporter.verifyTrueWithLogging(true, "2FA Page Verification", false, false );

        }

        mbkCommonControlsHelper.handleUpiPin(pin);

        Thread.sleep(4000);


        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "You Paid", "Succes Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("₹", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        String actualReceiverName = upiPage.getReceiverName().replace("to ", "");

        mbReporter.verifyEqualsWithLogging(actualReceiverName, expectedReceiverName, "Validate Receiver name", false, false);

        upiPage.returnToHomePage();

    }

    public void sendMoneyToBankViaUpi(String beneficiaryName, String accountNumber, String ifsc, String amount, String message,String amountPageTransferName, String pin, String expectedReceiverName) throws InterruptedException, IOException {


        upiPage = homePage.navigateAndSelectUpiSendToAccountNumber();

//        upiPage.selectTransfertoBank();

        upiPage.enterBeneficiaryName(beneficiaryName);

        upiPage.enterAccountNumber(accountNumber);

        upiPage.enterIfsc(ifsc);

        upiPage.clickConfirmBankDetails();

        //Amount Page Assertions

        mbReporter.verifyEqualsWithLogging(upiPage.getAmountPageTransferTo(), amountPageTransferName, "Verifying Fetched name", false, false);

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        if(upiPage.isSetupMessageDisplayed()){

            upiPage.clickOnConfirmPayment();
            permissionHelper.permissionAllow();
            permissionHelper.permissionAllow();
            Thread.sleep(3000);
            mbReporter.verifyTrueWithLogging(!upiPage.isSetupMessageDisplayed(), "Upi Restore Verification", false, false );

        }

        upiPage.clickOnConfirmPayment();

        //2FA Validation Page Assertions

        if(upiPage.is2FAPageDisplayed()){

            upiPage.clickOnContinue2FAPage();
            permissionHelper.permissionAllow();
            Thread.sleep(4000);
            mbReporter.verifyTrueWithLogging(true, "2FA Page Verification", false, false );

        }

        mbkCommonControlsHelper.handleUpiPin(pin);

        Thread.sleep(4000);


        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "You Paid", "Succes Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("₹", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        String actualReceiverName = upiPage.getReceiverName().replace("to ", "");

        mbReporter.verifyEqualsWithLogging(actualReceiverName, expectedReceiverName, "Validate Receiver name", false, false);

        upiPage.returnToHomePage();


    }



        public void checkAccountBalance(String pin) throws InterruptedException, IOException {


        homePage.navigateAndSelectUpiCheckBalance();

        Thread.sleep(2000);

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Link Your Bank Account']"));

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Link Your Bank Account']")), "Link you bank account bottomsheet shown", false, false);

        upiPage = homePage.clickOnLinkBankAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(7000);

        if(upiPage.is2FAPageDisplayed()){

                upiPage.clickOnContinue2FAPage();
                Thread.sleep(4000);
                mbReporter.verifyTrueWithLogging(true, "2FA Page Verification", false, false );

        }


        mbkCommonControlsHelper.handleUpiPin(pin);

        Boolean isBalanceVisible = Element.isElementPresent(driver, By.id("tv_check_balance"));

        String balance = homePage.getAccountBalance();

        mbReporter.verifyTrueWithLogging(isBalanceVisible, "Avalaible Balance is = " + balance, false, false);

        driver.navigate().back();


    }


    public void requestMoneyViaUpi(String upiId, String amount, String message, String expectedSenderName, String amountPageName) throws InterruptedException, IOException {


        homePage.clickOnAllServicesSection();

        upiPage = homePage.clickOnUPIRequestMoney();

        upiPage.selectEnterUPI();

        upiPage.enterUpiId(upiId);

        upiPage.selectResultUpi();


        //Amount Page Assertions

        mbReporter.verifyEqualsWithLogging(upiPage.getAmountPageTransferTo(), amountPageName, "Verifying Fetched name", false, false);

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        if(upiPage.isSetupMessageDisplayed()){

            upiPage.clickOnConfirmPayment();
            permissionHelper.permissionAllow();
            permissionHelper.permissionAllow();
            Thread.sleep(3000);
            mbReporter.verifyTrueWithLogging(!upiPage.isSetupMessageDisplayed(), "Upi Restore Verification", false, false );

        }

        upiPage.clickOnConfirmPayment();


        Thread.sleep(6000);


        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "You Requested", "Succes Message Validation", false, false);

        String actualTotalAmountAsked = upiPage.getAmountPaid().replace("₹", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountAsked, amount, "Validate Amount", false, false);

        String actualSenderName = upiPage.getReceiverName().replace("from ", "");

        mbReporter.verifyEqualsWithLogging(actualSenderName, expectedSenderName, "Validate Sender name", false, false);

        upiPage.returnToHomePage();




    }

    public void viewUPIQR() throws InterruptedException, IOException {

        homePage.navigateAndSelectMyQRCode();
        mbReporter.verifyTrueWithLogging(!(homePage.getUpiBottomsheetTitle() ==null), "Bottomsheet Title Text : "+homePage.getUpiBottomsheetTitle(), false,false);

        homePage.clickLinkNowUpiQRBottomsheet();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(4000);

        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIID()==null)," User UPI ID : "+upiPage.fetchUPIID(), false, false);

        driver.navigate().back();

    }

    public void viewPocketUPIQR() throws InterruptedException, IOException {

        homePage.navigateAndSelectMyQRCode();
        mbReporter.verifyTrueWithLogging(!(homePage.getUpiBottomsheetTitle() ==null), "Bottomsheet Title Text : "+homePage.getUpiBottomsheetTitle(), false,false);

        homePage.switchTabUpitoPocketUpi();

        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIID()==null)," User UPI ID : "+upiPage.fetchUPIID(), false, false);

        driver.navigate().back();

    }

    public void sendMoneyViaContact(String amount, String message, String amountPageTransferName, String pin, String expectedReceiverName) throws InterruptedException, IOException {


        upiPage = homePage.navigateAndSelectUpiSearch();

        Thread.sleep(4000);

        driver.navigate().back();

        upiPage.clickContinueForContacts1();

        Thread.sleep(1000);

        upiPage.clickContinueForContacts2();

        permissionHelper.permissionAllow();

        Log.info("Waiting for Toast to Disappear");
        Thread.sleep(5000);

        upiPage.selectFirstContactFromList();

        vpaList=upiPage.getAllVpaList();

        for(int i=0;i<vpaList.size();i++){

            if(!(vpaList.get(i) ==null)) {
                Log.info(vpaList.get(i));
            }

        }

        upiPage.selectFirstVpaFromList();

        //Amount Page Assertions

        mbReporter.verifyEqualsWithLogging(upiPage.getAmountPageTransferTo(), amountPageTransferName, "Verifying Fetched name", false, false);

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        if(upiPage.isSetupMessageDisplayed()){

            upiPage.clickOnConfirmPayment();
            permissionHelper.permissionAllow();
            permissionHelper.permissionAllow();
            Thread.sleep(3000);
            mbReporter.verifyTrueWithLogging(!upiPage.isSetupMessageDisplayed(), "Upi Restore Verification", false, false );

        }

        upiPage.clickOnConfirmPayment();

        //2FA Validation Page Assertions

        if(upiPage.is2FAPageDisplayed()){

            upiPage.clickOnContinue2FAPage();
            permissionHelper.permissionAllow();
            Thread.sleep(4000);
            mbReporter.verifyTrueWithLogging(true, "2FA Page Verification", false, false );

        }

        mbkCommonControlsHelper.handleUpiPin(pin);

        Thread.sleep(4000);


        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "You Paid", "Succes Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("₹", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        String actualReceiverName = upiPage.getReceiverName().replace("to ", "");

        mbReporter.verifyEqualsWithLogging(actualReceiverName, expectedReceiverName, "Validate Receiver name", false, false);

        upiPage.returnToHomePage();

    }




//    public void deregisterUpi() throws InterruptedException, IOException {
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        Thread.sleep(100);
//
//        upiPage = homePage.clickOnUpiId();
//
//        upiPage.clickOnUpiSetupCta();
//
//        permissionHelper.permissionAllow();
//
//        permissionHelper.permissionAllow();
//
//        permissionHelper.permissionAllow();
//
//        Thread.sleep(400);
//
//
//        Boolean setup = Element.isElementPresent(driver, By.id("qr_image"));
//
//        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);
//
//        homePage = upiPage.clickOnBackButton();
//
//        sideDrawerPage = homePage.clickHamburgerIcon();
//
//        securitySettingsPage = sideDrawerPage.clickOnSecuritySettings();
//
//        securitySettingsPage.ClickSecurityOptions();
//
//        securitySettingsPage.ClickDeregisterFromOptions();
//
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Deregister Account']"));
//
//        securitySettingsPage.ClickYesDeregisterAccount();
//
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Deregister successful']"));
//
//        boolean deregisterRequest = Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Deregister successful']"));
//
//        mbReporter.verifyTrueWithLogging(deregisterRequest, "Deregister successful", true, true);
//
//        securitySettingsPage.ClickOk();
//
//        homePage = securitySettingsPage.clickBackButton();
//
//        Thread.sleep(100);
//
//        Boolean upiId = Element.isElementPresent(driver, By.id("tx_upi_id"));
//
//        mbReporter.verifyTrueWithLogging(!upiId, "Upi is Deregistered Succesfully", true, true);
//
//
//    }

//    public void registerUpi(String bankName) throws InterruptedException, IOException {
//
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        Thread.sleep(100);
//
//        if (Element.isElementPresent(driver, By.id("tx_bank_balance")) == false) {
//
//            sideDrawerPage= homePage.clickHamburgerIcon();
//            walletPage = sideDrawerPage.clickOnAccountsPage();
//
//            Thread.sleep(5000);
//            for (int i = 0; i < 2; i++) {
//                Screen.swipeDownMore(driver);
//            }
//
//            homePage.clickOnBottomBarHome();
//
//        }
//
//        homePage.clickCheckBalance();
//
//        upiPage = homePage.clickOnLinkBankAccount();
//
//        Element.waitForVisibility(driver, By.id("mkiv_image"));
//
//        upiPage.enterBankName(bankName);
//
//        upiPage.selectBankFromList();
//
//        permissionHelper.permissionAllow();
//
//        permissionHelper.permissionAllow();
//
//        permissionHelper.permissionAllow();
//
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Select the phone number linked with your Kotak Mahindra Bank Account. An SMS will be triggered from the number to verify your bank account.']"));
//
//        upiPage.selectSim1();
//
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Create New VPA']"));
//
//        String randomVpa = Helper.generateRandomAlphaNumericString(5).toLowerCase();
//
////        Thread.sleep(5000);
//
//        upiPage.enterVpa(randomVpa);
//
//        upiPage.submitVpa();
//
//        Element.waitForVisibility(driver, By.id("upi_id_label"));
//
//        String upiId = upiPage.upiIdGenerated();
//
//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("upi_id_text")), "Upi ID generated is:" + upiId, true, true);
//
//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("account_number")), "Account Number is present", true, true);
//
//        homePage = upiPage.clickBackToHomeFromSetupSuccess();
//
//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= '" + upiId + "']")), "Upi Id is Reflected", true, true);
//
//
//    }


}


