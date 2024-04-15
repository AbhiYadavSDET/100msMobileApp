package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.Element;
import Utils.Elements;
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
    SecurityPinPage securityPinPage;

    P2PPage p2PPage;

    P2MPage p2mPage;


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
        securityPinPage = new SecurityPinPage(driver);
        upiPage=new UpiPage(driver);
        p2PPage = new P2PPage(driver);
        p2mPage = new P2MPage(driver);


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

        if(upiPage.isChoosePaymentModeBottomsheetDisplayed()){

            upiPage.clickOnRestoreUpiInChoosePaymentModeBottomsheet();
            upiPage.clickStartUpiRestoreJourney();
            permissionHelper.permissionAllow();
            upiPage.clickOnConfirmPaymentChoosePaymentModeBottomsheet();
            Thread.sleep(3000);

        }

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

        if(upiPage.isChoosePaymentModeBottomsheetDisplayed()){

            upiPage.clickOnRestoreUpiInChoosePaymentModeBottomsheet();
            upiPage.clickStartUpiRestoreJourney();
            permissionHelper.permissionAllow();
            upiPage.clickOnConfirmPaymentChoosePaymentModeBottomsheet();
            Thread.sleep(3000);

        }

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

        Thread.sleep(2000);

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

        if(upiPage.isChoosePaymentModeBottomsheetDisplayed()){

            upiPage.clickOnRestoreUpiInChoosePaymentModeBottomsheet();
            upiPage.clickStartUpiRestoreJourney();
            permissionHelper.permissionAllow();
            upiPage.clickOnConfirmPaymentChoosePaymentModeBottomsheet();
            Thread.sleep(3000);

        }

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


    public void pocketUPITransferNow(String amount, String message, String expectedReceiverName, String upiId, String amountPageTransferName) throws InterruptedException, IOException{

        upiPage = homePage.navigateAndSelectPocketUpi();

        if(upiPage.isWalletNowPocketUpiBottomsheetPresent()){

            Thread.sleep(1000);
            mbReporter.verifyTrueWithLogging(true, "Wallet UPI is now Pocket Upi bottomsheet shown", false, false);
            mbReporter.verifyTrueWithLogging(true, "Title : "+upiPage.getbottomsheetTitle(), false,false);
            mbReporter.verifyTrueWithLogging(true, "Description : "+upiPage.getbottomsheetDescription(), false,false);
            upiPage.selectContinueCta();

        }

        Element.waitForVisibility(driver, By.id("pocket_upi_header"));
        mbReporter.verifyTrueWithLogging(!(upiPage.getPocketUpiId() ==null), upiPage.getPocketUpiId(), false,false);

        upiPage.selectPocketUpiTransferNowCta();

        upiPage.selectEnterUPI();

        upiPage.enterUpiId(upiId);

        upiPage.selectResultUpi();

        //Amount Page Assertions

        mbReporter.verifyEqualsWithLogging(upiPage.getAmountPageTransferTo(), amountPageTransferName, "Verifying Fetched name", false, false);






        mbReporter.verifyTrueWithLogging(upiPage.isPocketUPIPreSelected(), "Validating if Pocket Upi is Pre-selected", false,true);

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        upiPage.clickOnConfirmPayment();


        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin("121212");
        }

        Thread.sleep(4000);

        permissionHelper.permissionAllow();
        permissionHelper.permissionAllow();
        permissionHelper.permissionAllow();

        Thread.sleep(4000);


        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "You Paid", "Success Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("₹", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        String actualReceiverName = upiPage.getReceiverName().replace("to ", "");

        mbReporter.verifyEqualsWithLogging(actualReceiverName, expectedReceiverName, "Validate Receiver name", false, false);

        mbReporter.verifyTrueWithLogging(upiPage.isPayModeOnSuccessScreenPocketUPI(), "Validating if Pocket Upi is the Pay mode on Success Screen", false,true);


        upiPage.returnToHomePage();

    }

    public void pocketUPIHomePageShowMyQrCode() throws InterruptedException, IOException{

        upiPage = homePage.navigateAndSelectPocketUpi();

        if(upiPage.isWalletNowPocketUpiBottomsheetPresent()){

            Thread.sleep(1000);
            mbReporter.verifyTrueWithLogging(true, "Wallet UPI is now Pocket Upi bottomsheet shown", false, false);
            mbReporter.verifyTrueWithLogging(true, "Title : "+upiPage.getbottomsheetTitle(), false,false);
            mbReporter.verifyTrueWithLogging(true, "Description : "+upiPage.getbottomsheetDescription(), false,false);
            upiPage.selectContinueCta();

        }

        Element.waitForVisibility(driver, By.id("pocket_upi_header"));
        mbReporter.verifyTrueWithLogging(!(upiPage.getPocketUpiId() ==null), upiPage.getPocketUpiId(), false,false);

        upiPage.selectPocketUpiShowMyQRCta();

        mbReporter.verifyTrueWithLogging(!(upiPage.getbottomsheetTitle() ==null), "Pocket UPI Bottomsheet Title Text : "+upiPage.getbottomsheetTitle(), false,false);


        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIID()==null)," User UPI ID : "+upiPage.fetchUPIID(), false, false);

        driver.navigate().back();


    }

    public void manageUpi() throws InterruptedException, IOException {

        homePage.clickOnAllServicesSection();
        upiPage = homePage.clickOnUPITransfers();

        Element.waitForVisibility(driver, By.id("transfer_own_account"));
        upiPage.selectManageCta();

        Element.waitForVisibility(driver, By.id("txtHowToUseUpi"));


        upiPage.clickLinkAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(4000);

        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIIDManageSection()==null)," User UPI ID : "+upiPage.fetchUPIIDManageSection(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPINumberManageSection()==null)," User UPI Number : "+upiPage.fetchUPINumberManageSection(), false, false);

        //how to use upi
        upiPage.clickHowToUseUpi();
        upiPage.selectLanguage();
        Thread.sleep(4000);
        mbReporter.verifyTrueWithLogging(upiPage.isWebsiteOpened(), "Is Website Opened :"+upiPage.isWebsiteOpened(), false, false);

        driver.navigate().back();

        driver.navigate().back();

        //account primary

        upiPage.scrollToBankList();
        mbReporter.verifyTrueWithLogging(upiPage.isPrimaryTagVisible(), "Primary Bank Account Tag Present : "+upiPage.isPrimaryTagVisible(), false, false);


        //upi autopay

        upiPage.clickOnManageUpiAutopay();

        Element.waitForVisibility(driver, By.id("tab_layout"));

        mbReporter.verifyTrueWithLogging(upiPage.verifyPageTitleUpiAutopay(), "is Upi Subscription Page Opened : "+upiPage.verifyPageTitleUpiAutopay(), false, false);

        upiPage.clickOnBackButton();


    }


    public void addNewBankAccountAndCreditCard() throws InterruptedException, IOException {

        homePage.clickOnAllServicesSection();
        upiPage = homePage.clickOnUPITransfers();

        Element.waitForVisibility(driver, By.id("transfer_own_account"));
        upiPage.selectManageCta();

        Element.waitForVisibility(driver, By.id("txtHowToUseUpi"));


        upiPage.clickLinkAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(4000);

        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIIDManageSection()==null)," User UPI ID : "+upiPage.fetchUPIIDManageSection(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPINumberManageSection()==null)," User UPI Number : "+upiPage.fetchUPINumberManageSection(), false, false);

       upiPage.navigateToAddNewBankAccountAndSelect();
       upiPage.selectHdfcBankFromList();

       Thread.sleep(4000);

       mbReporter.verifyTrueWithLogging(upiPage.validateErrorMessage().equals("You don’t seem to have an account in this bank"),"Validating Error Message", false, false);

       upiPage.goBackAddFlow();
       Thread.sleep(1000);
       upiPage.goBackAddFlow();


        upiPage.navigateToAddNewCreditCardAndSelect();

        mbReporter.verifyTrueWithLogging(!(upiPage.getAddCreditCardLandingPageMessage() ==null),"Add Credit Card Landing Page Message : "+upiPage.getAddCreditCardLandingPageMessage(), false, false);


        upiPage.selectHdfcBankCreditCardFromList();

        Thread.sleep(4000);

        mbReporter.verifyTrueWithLogging(upiPage.validateErrorMessage().equals("You don’t seem to have an account in this bank"),"Validating Error Message", false, false);

        upiPage.goBackAddFlow();
        Thread.sleep(1000);
        upiPage.goBackAddFlow();

    }

    public void manageUpiNumber() throws InterruptedException, IOException {


        homePage.clickOnAllServicesSection();
        upiPage = homePage.clickOnUPITransfers();

        Element.waitForVisibility(driver, By.id("transfer_own_account"));
        upiPage.selectManageCta();

        Element.waitForVisibility(driver, By.id("txtHowToUseUpi"));


        upiPage.clickLinkAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(4000);

        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIIDManageSection()==null)," User UPI ID : "+upiPage.fetchUPIIDManageSection(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPINumberManageSection()==null)," User UPI Number : "+upiPage.fetchUPINumberManageSection(), false, false);

        upiPage.selectMenuIconManageUpiPage();

        upiPage.selectManageUpiNumber();

        mbReporter.verifyTrueWithLogging(true, "Primary Number Status : "+upiPage.getPrimaryNumberStatusCtaText(), false, false);

//        mbReporter.verifyTrueWithLogging(true, "Secondary Number Status : "+upiPage.getSecondaryNumberStatusCtaText(), false, false);
//
//        mbReporter.verifyTrueWithLogging(true, "Secondary Number Deregistration Status : "+upiPage.getSecondaryNumberDeregisterStatusCtaText(), false, false);

        if(upiPage.getPrimaryNumberStatusCtaText().equalsIgnoreCase("Deactivate")){
            upiPage.primaryNumberActivateDeactivateCta();
            mbReporter.verifyTrueWithLogging(!(upiPage.getDeactivateConfirmationPopUpTitleText() ==null), "Deactivate Pop UP Title Text Primary Number : "+upiPage.getDeactivateConfirmationPopUpTitleText(), false, false);
            upiPage.deactivateConfirmationPopUpCta();
            Thread.sleep(3000);
        }

//        if(upiPage.getSecondaryNumberStatusCtaText().equalsIgnoreCase("Deactivate")){
//            upiPage.secondaryNumberActivateDeactivateCta();
//            mbReporter.verifyTrueWithLogging(!(upiPage.getDeactivateConfirmationPopUpTitleText() ==null), "Deactivate Pop UP Title Text Secondary Number : "+upiPage.getDeactivateConfirmationPopUpTitleText(), false, false);
//            upiPage.deactivateConfirmationPopUpCta();
//            Thread.sleep(3000);
//        }

        Thread.sleep(2000);

        upiPage.goBackNumberMapperPage();

        mbReporter.verifyTrueWithLogging(upiPage.isActivateCtaPresentUpiNumberManagePage(), "Activate Pop Up Present : "+ upiPage.isActivateCtaPresentUpiNumberManagePage(), false,false);

        if(upiPage.isActivateCtaPresentUpiNumberManagePage()){
            upiPage.clickOnActivateCtaManagePage();
            Thread.sleep(2000);
        }

        upiPage.selectMenuIconManageUpiPage();

        upiPage.selectManageUpiNumber();

        mbReporter.verifyTrueWithLogging(upiPage.getPrimaryNumberStatusCtaText().equalsIgnoreCase("deactivate"), "Primary Number Status : "+upiPage.getPrimaryNumberStatusCtaText(), false, false);

        upiPage.addNewUpiNumberCta();

        Thread.sleep(1000);
        upiPage.enterNewMapperNumber("188698756");

        upiPage.checkAvaibilityCta();

        Thread.sleep(3000);

        mbReporter.verifyTrueWithLogging(upiPage.isMapperNumberAvailable(), "Is new number available : "+upiPage.isMapperNumberAvailable(), false,false);


    }

    public void deregisterUpi() throws InterruptedException, IOException {


        homePage.clickOnAllServicesSection();
        upiPage = homePage.clickOnUPITransfers();

        Element.waitForVisibility(driver, By.id("transfer_own_account"));
        upiPage.selectManageCta();

        Element.waitForVisibility(driver, By.id("txtHowToUseUpi"));


        upiPage.clickLinkAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(4000);

        mbReporter.verifyTrueWithLogging(upiPage.isQRPresent(), "QR Present :"+upiPage.isQRPresent(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPIIDManageSection()==null)," User UPI ID : "+upiPage.fetchUPIIDManageSection(), false, false);
        mbReporter.verifyTrueWithLogging(!(upiPage.fetchUPINumberManageSection()==null)," User UPI Number : "+upiPage.fetchUPINumberManageSection(), false, false);

        upiPage.selectMenuIconManageUpiPage();

        upiPage.selectDeregisterUpi();

        mbReporter.verifyTrueWithLogging(!(upiPage.getDeregisterPopUpTitleText()==null),"Deregister Pop UP Title Text : "+upiPage.getDeregisterPopUpTitleText(), false, false);

        upiPage.clickNoOnDeregisterUpiPopUp();


    }





    public void pocketUPISonuQRTxn(String amount,String amountPageTransferName,String stepName) throws InterruptedException, IOException{

        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Tap on See All Services
        p2PPage.clickAllServices();

        // Click on Scan Any Qr
        p2PPage.clickScanQrOptn();

        //Element.waitForVisibility(driver,By.id("permission_allow_button"));
        // Allow Permission
        p2mPage.clickAllowBtn();

        if(stepName.equals("Direct Txn")) {

           // Click on Gallery
           p2mPage.clickOnGallery();

           p2mPage.clickOnSonuQrCodeGallery();

           Thread.sleep(1000);
       }
       else if (stepName.equals("RecentMerchant")) {

            if(stepName.equals("RecentMerchant") && !p2mPage.checkRecentMerchant()){
                Log.info("There are no recent Merchants Present for the user");
                return;
            }

            p2mPage.clickOnRecentMerchant();

            // Allow the Permission
            //if(p2mPage.checkWhileUsingAppPermission()){ p2mPage.allowPermissionWhileUsingApp();}

           Thread.sleep(1000);
       }


        //Amount Page Assertions
        mbReporter.verifyEqualsWithLogging(upiPage.getAmountPageTransferTo(), amountPageTransferName, "Verifying Fetched name", false, false);

        // Enter the amount
        upiPage.enterAmount(amount);

        Thread.sleep(2000);

        // Click on the Continue CTA
        upiPage.clickOnConfirmPayment();

        upiPage.clickPocketUPIOptn();

        upiPage.clickOnConfirmPaymentChoosePaymentModeBottomsheet();

        permissionHelper.permissionAllow();
        permissionHelper.permissionAllow();
        permissionHelper.permissionAllow();

        Thread.sleep(4000);

        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "You Paid", "Success Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("₹", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

//        String actualReceiverName = upiPage.getReceiverName().replace("to ", "");
//
//     //   mbReporter.verifyEqualsWithLogging(actualReceiverName, expectedReceiverName, "Validate Receiver name", false, false);

        mbReporter.verifyTrueWithLogging(upiPage.isPayModeOnSuccessScreenPocketUPI(), "Validating if Pocket Upi is the Pay mode on Success Screen", false,true);

        upiPage.returnToHomePage();

    }





}


