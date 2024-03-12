package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutHelper {

    AndroidDriver<AndroidElement> driver;
    P2PExtraPage p2PExtraPage;
    MBReporter mbReporter;
    CheckoutPage checkoutPage;

    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    CCPage ccPage;
    RechargePage rechargePage;
    SecurityPinPage securityPinPage;
    SyncEmailBottomSheet syncEmailBottomSheet;

    Screen screen;

    ElectricityPage electricityPage;

    AddMoneyPage addMoneyPage;





    public CheckoutHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        p2PExtraPage=new P2PExtraPage(driver);
        mbReporter = new MBReporter(driver);
        checkoutPage=new CheckoutPage(driver);
        permissionHelper= new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        ccPage = new CCPage(driver);
        rechargePage = new RechargePage(driver);
        securityPinPage = new SecurityPinPage(driver);
        syncEmailBottomSheet = new SyncEmailBottomSheet(driver);
        screen = new Screen(driver);
        electricityPage = new ElectricityPage(driver);
        addMoneyPage=new AddMoneyPage(driver);

    }



    public void validateXtraCheckoutFlow(String expTitle, String bankPageTitleExpected, String expectedAccountNumber, String expectedIFSCNumber, String expectedAccountHolderName, String expectedBankName, String expectedAccountType) throws IOException, InterruptedException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        Thread.sleep(1000);
        if(p2PExtraPage.isBorrowerPreferenceBottomsheetVisible()){
            mbkCommonControlsHelper.pressback();
            //p2PExtraPage.selectBorrowerPreferenceBottomsheet();
        }

        // Click on the Tooltip
       // p2PExtraPage.selectOkfromPlusPopUp();

        // Click Flexi from slider
        p2PExtraPage.selectFlexiFromNavBar();

        if(p2PExtraPage.isBorrowerPreferenceBottomsheetVisible()){
         //   p2PExtraPage.selectBorrowerPreferenceBottomsheet();
            p2PExtraPage.clickGotItCtaBorrowerMappingReport();
        }

//        //Click on Proceed to pay Btn on Amount Summary Page
//        p2PExtraPage.selectInvestMore();

        Log.info("-----Checkout Flow Open-----");

        Log.info("-----NetBanking Check-----");

        //Click Invest Now btn on Xtra FLEXI amount page
        p2PExtraPage.selectInvestMore();

        //Select NetBanking from XTRA checkout screen
        checkoutPage.selectNBOnCheckoutScreen();

        permissionHelper.permissionAllow();

        Thread.sleep(2000);

//        // Get bank page heading
//        String actualTitle = checkoutPage.getBankPageTitleNetbanking();
//
//        Log.info("Bank List Page Title : " + actualTitle);
//
//        // Add the assertions
//        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle, "Xtra Net Banking Flow Bank List Shown", false, false, true);
//
//        checkoutPage.selectKotakBankFromBAnkList();
//
//        Thread.sleep(2000);

       // permissionHelper.permissionAllow();


        String bankPageTitleActual=checkoutPage.getBankPageTitleWeb();

        Log.info("Bank Otp Page Title : " + bankPageTitleActual);

        mbReporter.verifyEqualsWithLogging(bankPageTitleActual, bankPageTitleExpected, "Net Banking Flow Web Page Open", false, false, true);

        checkoutPage.selectBackBtn();

        if(checkoutPage.isCancelTransactionPopUpShown()){
            checkoutPage.yesCancelTransaction();
        }


        Log.info("-----Checkout Flow Open-----");

        Log.info("-----IMPS/NEFT/RTGS Check-----");

        //Click Invest Now btn on Xtra FLEXI amount page
        p2PExtraPage.selectInvestMore();

        checkoutPage.selectIMPSOnCheckoutScreen();
        Thread.sleep(1000);

        mbReporter.verifyTrueWithLogging(checkoutPage.isImpsPageOpened(), "Bank Page opened with 2 Step Process of Transferring Amount", false,false);

        checkoutPage.clickViewBankAccountDetails();

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsAccountNumber(),expectedAccountNumber, "Validate Bank Account Number", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsIFSCNumber(),expectedIFSCNumber, "Validate Bank IFSC Number", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsAccountHolderName(),expectedAccountHolderName, "Validate Bank Account Holder Name", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsBankName(),expectedBankName, "Validate Bank Name", false,false);

        mbReporter.verifyEqualsWithLogging(checkoutPage.getBankDetailsAccountType(),expectedAccountType, "Validate Bank Account Type", false,false);

        checkoutPage.goBackFromBankDetailsPage();

    }


    public void validateXtraCheckoutUpiModeHandling(String amount, String amount2) throws IOException, InterruptedException {

        Log.info("----------- Arguments ---------------");

        // Click on xtra icon on home page.
        p2PExtraPage.selectXtra();

        // Click on Got it to remove referral bottom sheet.
        Thread.sleep(1000);
        if (p2PExtraPage.isBottomSheetPresent()) p2PExtraPage.removeBottomSheet();

        //Click on Invest More button on XTRA dashboard
        p2PExtraPage.selectInvestMore();

        Thread.sleep(1000);
        if(p2PExtraPage.isBorrowerPreferenceBottomsheetVisible()){
            mbkCommonControlsHelper.pressback();
        //    p2PExtraPage.selectBorrowerPreferenceBottomsheet();
        }

        // Click on the Tooltip
        //p2PExtraPage.selectOkfromPlusPopUp();

        // Click Flexi from slider
        p2PExtraPage.selectFlexiFromNavBar();

        if(p2PExtraPage.isBorrowerPreferenceBottomsheetVisible()){
            p2PExtraPage.clickGotItCtaBorrowerMappingReport();
        }

        p2PExtraPage.enterInvestmentAmount(amount);

        //Click on Proceed to pay Btn on Amount Summary Page
        p2PExtraPage.selectInvestMore();

        Log.info("-----Checkout Flow Open-----");

        Log.info("-----UPI Module Check----- Amount : " + amount);

        mbReporter.verifyTrueWithLogging(checkoutPage.isUpiModeVisible(), "Upi Mode should be Visible when amount is =< Rs. 100000", false, false);

        driver.navigate().back();

        p2PExtraPage.enterInvestmentAmount(amount2);

        //Click on Proceed to pay Btn on Amount Summary Page
        p2PExtraPage.selectInvestMore();

        Log.info("-----Checkout Flow Open-----");

        Log.info("-----UPI Module Check----- Amount : " + amount2);

        mbReporter.verifyTrueWithLogging(!checkoutPage.isUpiModeVisible(), "Upi Mode should not be Visible when amount is > Rs. 100000", false, false);

        driver.navigate().back();


    }



    public void wapgCheckoutFlowCCBP(String amount, String cardNumber) throws IOException, InterruptedException {


        Boolean zipModule=false;
        Boolean upiModule=false;
        Boolean DebitCardModule=false;
        Boolean CreditCardModule=false;
        Boolean upiIntentModule=false;
        Boolean netBankingModule=false;


        // scroll to Recharge And PayBills
        ccPage.scrollToRechargeAndPayBills();

        // Click on Recharge And PayBills
        ccPage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        ccPage.clickSwipeLeftBottomRemove();

        // Click on Credit card payment option
        ccPage.clickOnCreditCardPayment();


        //Close Email Sync Bottom sheet
        if(syncEmailBottomSheet.checkEmailSyncBottomSheet()){
            syncEmailBottomSheet.clickSyncEmailBottomSheet();
        }

        if(ccPage.getAddNewCreditCard()){
            //Click Add new credit card
            ccPage.clickAddNewCreditCard();

        }else{
            ccPage.clickOnAddCardButton();
        }

        //Click on Enter card number text box
        ccPage.clickEnterCardNumber();

        ccPage.enterCardNumber(cardNumber);

        //Click Continue CTA
        ccPage.clickContinueCTA();

        //click on enter amount manually
        ccPage.clickEnterAmountManually();

        //Enter amount
        ccPage.clickEnterAmountField();

        //Enter amount
        ccPage.enterCardNumber(amount);

        //click Continue CTA
        ccPage.clickContinueCTA();

        // Verification on the Payment Screen
        String amountOnPaymentScreen = rechargePage.getAmountOnPayment().replace("₹", "").replace(",","");
        Log.info("Amount on Payment Screen : " + amountOnPaymentScreen);
        mbReporter.verifyEquals(amountOnPaymentScreen, amount, "Verify Amount on Payment screen", false, false);

        ccPage.clickOnPay();

        // checking for security pin
        if(securityPinPage.checkSecurityPinPage()){
            securityPinPage.enterSecurityPin("324008");
        }

        Element.waitForVisibility(driver,By.id("header_layout"));

        mbReporter.verifyTrueWithLogging(checkoutPage.isCheckoutPageOpened(), "Is checkout Page Opened", false, false);


        Log.info("-------Checking for Zip Module------");



        if(checkoutPage.isRecommendedSheetOpened()){

            if(checkoutPage.isZipModuleAvailable()){

                checkoutPage.selectZipModule();
                mbReporter.verifyTrueWithLogging(checkoutPage.isZipModuleAvailable(), "Zip Module Visible in Recommended Bottom Sheet", false,false);

                Double convFeeBelowZipModule= checkoutPage.getConvFee();
                Double convFeeInBreakup= checkoutPage.getConvFeeInBreakup();
                Double totalPayableAmount= checkoutPage.getPayableAmountBreakup();

                Double expectedTotalPayableAmount=Double.parseDouble(amount)+convFeeBelowZipModule;

                mbReporter.verifyEqualsWithLogging(convFeeBelowZipModule,convFeeInBreakup, "Matching Conv fee is displayed same on both places", false, false);
                mbReporter.verifyEqualsWithLogging(totalPayableAmount,expectedTotalPayableAmount, "Matching payable amount calculation", false,false);

                zipModule=true;
                checkoutPage.clickMorePaymentOptionsCta();
            }else {

                mbReporter.verifyTrueWithLogging(!checkoutPage.isZipModuleAvailable(), "Zip Module Not Visible in Recommended Bottom Sheet", false,false);

            }
        }else {

            if(checkoutPage.isZipModuleAvailable()) {
                checkoutPage.selectZipModule();
                mbReporter.verifyTrueWithLogging(checkoutPage.isZipModuleAvailable(), "Zip Module Visible in Main Bottom Sheet", false, false);

                Double convFeeBelowZipModule= checkoutPage.getConvFee();
                Double convFeeInBreakup= checkoutPage.getConvFeeInBreakup();
                Double totalPayableAmount= checkoutPage.getPayableAmountBreakup();

                Double expectedTotalPayableAmount=Double.parseDouble(amount)+convFeeBelowZipModule;

                mbReporter.verifyEqualsWithLogging(convFeeBelowZipModule, convFeeInBreakup, "Matching Conv fee is displayed same on both places", false, false);
                mbReporter.verifyEqualsWithLogging(expectedTotalPayableAmount, totalPayableAmount, "Matching payable amount calculation", false, false);
                zipModule=true;
            }
        }


        Log.info("-------Checking for UPI Module------");

        if(checkoutPage.isUPIRestoreModuleAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.isUPIRestoreModuleAvailable(), "Upi Restore Module Shown", false, false);
            upiModule=true;


        }

        Log.info("-------Checking for Debit Cards Module------");

        if(checkoutPage.areMultipleDebitCardsAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.areMultipleDebitCardsAvailable(), "Multiple Debit Cards Available", false, false);
            DebitCardModule=true;

        }




        // Swipe till the bottom
        screen.swipeUpMore(driver);


        Log.info("-------Checking for Credit Cards Module------");

        if(checkoutPage.areMultipleCreditCardsAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.areMultipleCreditCardsAvailable(), "Multiple Credit Cards Available", false, false);
            CreditCardModule=true;

        }




        screen.swipeUpMore(driver);


        Log.info("-------Checking for UPI Intent Module------");

        if(checkoutPage.isUpiIntentoptionAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.isUpiIntentoptionAvailable(), "Upi Intent option available", false, false);
            upiIntentModule=true;

        }

        Log.info("-------Checking for Netbanking Module------");

        if(checkoutPage.isNetbankingOptionAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.isNetbankingOptionAvailable(), "Netbanking option available", false, false);
            netBankingModule=true;


        }

        if(zipModule|DebitCardModule|CreditCardModule|upiModule|upiIntentModule|netBankingModule){
            Log.info("Available Payment option in CCBP Flow are : "+"ZIP :"+zipModule+" ,Debit Cards :"+DebitCardModule+" ,Credit Cards : "+CreditCardModule+" ,Upi Module : "+upiModule+" ,Upi Intent Module : "+ upiIntentModule +" ,Netbanking Module : "+netBankingModule);
            mbReporter.verifyTrueWithLogging(true,"Available Payment option in CCBP Flow are : "+"ZIP :"+zipModule+" ,Debit Cards :"+DebitCardModule+" ,Credit Cards : "+CreditCardModule+" ,Upi Module : "+upiModule+" ,Upi Intent Module : "+ upiIntentModule +" ,Netbanking Module : "+netBankingModule, false,false);
        }



    }



    public void zipAutoPayWidgetValidationBillPayments(String expUserName, String expTitle, String expSubTitle, String brandName, String CA_number, String zipAutoPayToggleTextExpected) throws IOException, InterruptedException {

        // Click on All services
        electricityPage.clickAllServices();

        //Click on Electricity option
        electricityPage.clickElectricity();

        //Click Search Electricity Brand field
        electricityPage.clickSearchElectricityBrand();

        //Enter Brand name in search text box
        electricityPage.enterSearchElectricityBrand(brandName);

        Thread.sleep(2000);

        //Select brand from list
        electricityPage.clickSelectBrand();

        //Click on CA number text box
        electricityPage.clickCaNumber();

        //Enter CA number in text field
        electricityPage.enterCaNumber(CA_number);

        //Click Continue CTA
        electricityPage.clickContinueButton();

        //Check Bill is fetched or not
        if(electricityPage.isBillFetched()) {

            // Verification on Enter amount screen
            String userName = electricityPage.getUserName().trim();
            Log.info("User name electricity bill : " + userName);
            mbReporter.verifyEqualsWithLogging(userName, expUserName, "Verify username on Bill", false, false, true);

            String dueDate = electricityPage.getDueDate();
            Log.info("Due date on Electricity Bill : " + dueDate);
            // mbReporter.verifyEqualsWithLogging(dueDate, expDueDate, "Verify Due date on Electricity Bill", false, false, true);

            //Click on Pay button
            electricityPage.clickPay();

            //Verification on Payment confirmation screen
            String title = electricityPage.getTitle();
            Log.info("CN number on Bill : " + title);
            mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify CN number on Bill", false, false, true);

            String subtitle = electricityPage.getSubTitle();
            Log.info("Brand Name on the Bill: " + subtitle);
            mbReporter.verifyEqualsWithLogging(subtitle, expSubTitle, "Verify Brand name on Bill", false, false, true);

            String amount = electricityPage.getBillPayment();
            Log.info("Amount on the Bill: " + amount);
            mbReporter.verifyTrueWithLogging(!(amount ==null), "Verify amount on Bill", false, false, true);

            electricityPage.clickOnPay();

            // checking for security pin
            if(securityPinPage.checkSecurityPinPage()){
                securityPinPage.enterSecurityPin("324008");
            }

            Element.waitForVisibility(driver,By.id("header_layout"));

            mbReporter.verifyTrueWithLogging(checkoutPage.isCheckoutPageOpened(), "Is checkout Page Opened", false, false);


            Log.info("-------Checking for Zip Module Autopay------");



            if(checkoutPage.isRecommendedSheetOpened()){

                if(checkoutPage.isZipModuleAvailable()){

                    Log.info("-------Checking for Zip AutoPay in Recommended Checkout bottomsheet------");
                    checkoutPage.selectZipModule();
                    mbReporter.verifyTrueWithLogging(checkoutPage.isZipModuleAvailable(), "Zip Module Visible in Recommended Bottom Sheet", false,false);

                    if(checkoutPage.isZipAutopayToggleVisible()){

                        mbReporter.verifyTrueWithLogging(checkoutPage.isZipAutopayToggleVisible(), "Zip Autopay Toggle is visible", false,false);
                        mbReporter.verifyEqualsWithLogging(checkoutPage.getZipAutoPayToggleText(),zipAutoPayToggleTextExpected , "Matchjing Zip Autopay Toglle Text", false,false);

                    }


                    checkoutPage.clickMorePaymentOptionsCta();
                }else {

                    mbReporter.verifyTrueWithLogging(!checkoutPage.isZipModuleAvailable(), "Zip Module Not Visible in Recommended Bottom Sheet", false,false);

                }
            }else {

                Log.info("-------Checking for Zip AutoPay in Main Checkout bottomsheet------");

                if(checkoutPage.isZipModuleAvailable()) {
                    checkoutPage.selectZipModule();
                    mbReporter.verifyTrueWithLogging(checkoutPage.isZipModuleAvailable(), "Zip Module Visible in Main Bottom Sheet", false, false);
                    if(checkoutPage.isZipAutopayToggleVisible()){

                        mbReporter.verifyTrueWithLogging(checkoutPage.isZipAutopayToggleVisible(), "Zip Autopay Toggle is visible", false,false);
                        mbReporter.verifyEqualsWithLogging(checkoutPage.getZipAutoPayToggleText(),zipAutoPayToggleTextExpected , "Matchjing Zip Autopay Toglle Text", false,false);

                    }
                }
            }


            Log.info("-------Checking for Zip AutoPay in Main Checkout bottomsheet------");

            if(checkoutPage.isZipModuleAvailable()) {
                checkoutPage.selectZipModule();
                mbReporter.verifyTrueWithLogging(checkoutPage.isZipModuleAvailable(), "Zip Module Visible in Main Bottom Sheet", false, false);
                if(checkoutPage.isZipAutopayToggleVisible()){

                    mbReporter.verifyTrueWithLogging(checkoutPage.isZipAutopayToggleVisible(), "Zip Autopay Toggle is visible", false,false);
                    mbReporter.verifyEqualsWithLogging(checkoutPage.getZipAutoPayToggleText(),zipAutoPayToggleTextExpected , "Matchjing Zip Autopay Toglle Text", false,false);

                }
            }




        }else{
            Log.info("Bill not present for given CA number");
        }

    }


    public void addMoneyCheckoutCardViewsValidation(String amount) throws InterruptedException, IOException {

        Log.info("START", "Add Money");
        Log.info("-------------------------------------");


        // Click on the profile
        securityPinPage.clickOnProfile();

        // Click on add Money
        addMoneyPage.clickOnAddMoney();

        // Enter amount
        addMoneyPage.enterAmount(amount);

        // Click on Add
        addMoneyPage.clickOnAdd();

        Element.waitForVisibility(driver,By.id("header_layout"));

        mbReporter.verifyTrueWithLogging(checkoutPage.isCheckoutPageOpened(), "Is checkout Page Opened", false, false);


        if(checkoutPage.isRecommendedSheetOpened()){
            mbReporter.verifyTrueWithLogging(checkoutPage.isRecommendedSheetOpened(), "Recommanded BottomSheet is Opened", false,false);
            checkoutPage.clickMorePaymentOptionsCta();
        }

        Log.info("-------Checking for Saved Debit Cards Module------");

        if(checkoutPage.areMultipleDebitCardsAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.areMultipleDebitCardsAvailable(), "Multiple Debit Cards Available", false, false);
            checkoutPage.selectSavedDebitCard();
            checkoutPage.selectCheckoutPayCta();
            mbReporter.verifyTrueWithLogging(checkoutPage.isCardDetailsBottomsheetDisplayed(), "Card Details Bottomsheet opened", false, false);
            driver.navigate().back();
            driver.navigate().back();
        }

        Log.info("-------Checking for New Debit Cards Module------");

        checkoutPage.selectAddNewDebitCard();
        mbReporter.verifyTrueWithLogging(checkoutPage.isCardDetailsBottomsheetDisplayed(), "New Card Details Bottomsheet opened", false, false);
        checkoutPage.enterCardDetails("552260");
        mbReporter.verifyEqualsWithLogging(checkoutPage.getErrorMessage(), "Please enter a valid debit card number", "Validating Valid Debit card error message", false, false);
        driver.navigate().back();
        driver.navigate().back();

        // Swipe till the bottom
        screen.swipeUpMore(driver);


        Log.info("-------Checking for Saved Credit Cards Module : Broken------");

        if(checkoutPage.areMultipleCreditCardsAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.areMultipleCreditCardsAvailable(), "Multiple Credit Cards Available", false, false);
            checkoutPage.selectSavedCreditCard();
            checkoutPage.selectCheckoutPayCta();

            if(checkoutPage.isBrokenCardBottomSheetDisplayed()){
                mbReporter.verifyEqualsWithLogging(checkoutPage.getBrokenCardSubTitleMessage(),"Share complete card details for security purposes", "Validating Broken Card BottomSheet", false,false);
            }

            mbReporter.verifyTrueWithLogging(checkoutPage.isCardDetailsBottomsheetDisplayed(), "Card Details Bottomsheet opened", false, false);
            driver.navigate().back();
            driver.navigate().back();

        }


        // Swipe till the bottom
        screen.swipeUpMore(driver);

        Log.info("-------Checking for New Credit Cards Module------");

        checkoutPage.selectAddNewCreditCard();
        mbReporter.verifyTrueWithLogging(checkoutPage.isCardDetailsBottomsheetDisplayed(), "New Card Details Bottomsheet opened", false, false);
        checkoutPage.enterCardDetails("436393");
        mbReporter.verifyEqualsWithLogging(checkoutPage.getErrorMessage(), "Please enter a valid credit card number", "Validating Valid Credit card error message", false, false);
        driver.navigate().back();
        driver.navigate().back();

    }

    public void addMoneyCheckoutConvFeeValidation(String amount) throws InterruptedException, IOException {

        Log.info("START", "Add Money");
        Log.info("-------------------------------------");


        // Click on the profile
        securityPinPage.clickOnProfile();

        // Click on add Money
        addMoneyPage.clickOnAddMoney();

        // Enter amount
        addMoneyPage.enterAmount(amount);

        // Click on Add
        addMoneyPage.clickOnAdd();

        Element.waitForVisibility(driver,By.id("header_layout"));

        mbReporter.verifyTrueWithLogging(checkoutPage.isCheckoutPageOpened(), "Is checkout Page Opened", false, false);


        if(checkoutPage.isRecommendedSheetOpened()){
            mbReporter.verifyTrueWithLogging(checkoutPage.isRecommendedSheetOpened(), "Recommanded BottomSheet is Opened", false,false);
            checkoutPage.clickMorePaymentOptionsCta();
        }

        screen.swipeUpMore(driver);

        checkoutPage.selectConvFeeInfoIcon();

        mbReporter.verifyTrueWithLogging(checkoutPage.isConvFeeLayoutDisplayed(), "Conv Fee Layout ", false,false);

        String convFeeDetails= checkoutPage.getConvLayoutDetails();
        Log.info(convFeeDetails);
        mbReporter.verifyTrueWithLogging(!(convFeeDetails ==null), "Validating Deatils available in Conv Fee Layout :-- "+convFeeDetails,false,false );

        checkoutPage.clickOnKnowMoreCta();

        mbReporter.verifyEqualsWithLogging(checkoutPage.getKnowMorePageTitle(), "List of Charges", "Validating Know More Page opened", false,false);

        driver.navigate().back();


        Log.info("-------Checking for Saved Credit Cards Module : Broken------");

        if(checkoutPage.areMultipleCreditCardsAvailable()){

            mbReporter.verifyTrueWithLogging(checkoutPage.areMultipleCreditCardsAvailable(), "Multiple Credit Cards Available", false, false);
            checkoutPage.selectSavedCreditCard();
            checkoutPage.selectCheckoutPayCta();

            if(checkoutPage.isBrokenCardBottomSheetDisplayed()){
                mbReporter.verifyEqualsWithLogging(checkoutPage.getBrokenCardSubTitleMessage(),"Share complete card details for security purposes", "Validating Broken Card BottomSheet", false,false);
            mbReporter.verifyTrueWithLogging(checkoutPage.isConvFeeDescriptionDisplayed(),"Validating Conv Fee description is Displayed", false,false);

            }else {
                mbReporter.verifyTrueWithLogging(checkoutPage.isConvFeeDescriptionDisplayed(),"Validating Conv Fee description is Displayed", false,false);
            }
            mbReporter.verifyTrueWithLogging(checkoutPage.isCardDetailsBottomsheetDisplayed(), "Card Details Bottomsheet opened", false, false);
            driver.navigate().back();
            driver.navigate().back();


        }


        // Swipe till the bottom
        screen.swipeUpMore(driver);

        Log.info("-------Checking for New Credit Cards Module------");

        checkoutPage.selectAddNewCreditCard();
        mbReporter.verifyTrueWithLogging(checkoutPage.isCardDetailsBottomsheetDisplayed(), "New Card Details Bottomsheet opened", false, false);
        checkoutPage.enterCardDetails("552260");
        Thread.sleep(1000);
        mbReporter.verifyTrueWithLogging(checkoutPage.isConvFeeDescriptionDisplayed(),"Validating Conv Fee description is Displayed", false,false);
        mbReporter.verifyTrueWithLogging(checkoutPage.isSaveCardConsentDisplayed(),"Validating Save Card Consent is Displayed", false,false);
        driver.navigate().back();
        driver.navigate().back();

    }





}





