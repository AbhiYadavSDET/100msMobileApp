package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.util.LinkedHashMap;

public class PayRentHelper {

    AndroidDriver<AndroidElement> driver;

    LoginPage loginPage;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;
    PayRentPage payRentPage;
    private String expAmountOnPaymentScreen;


    public PayRentHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        loginPage = new LoginPage(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        payRentPage = new PayRentPage(driver);
    }

    public static String actualDeductedAmount(String amount){

        double deductedAmount = Double.parseDouble(amount);
        double totalDeductedAmount = (101.18 * deductedAmount)/100;

        String newAmount = String.valueOf(totalDeductedAmount);

        return newAmount;
    }

    public void addNewProperty(String AccountNumber, String IfscCode, String Name, String Amount, String cvv) throws IOException, InterruptedException {

        //Click on Pay Rent
        payRentPage.clickPayRent();

        // check for saved Recipient Screen
        boolean isSavedRecipientPresent = payRentPage.checkSavedRecipientScreen();

        mbReporter.verifyTrueWithLogging(isSavedRecipientPresent, "Past Payments Present : "+  isSavedRecipientPresent, false,false );

            //Click on Add new Property
            payRentPage.clickAddNewPropertyButton();

            payRentPage.selectOptionFromPaymentFlowSelectionBottomsheet();

            payRentPage.clickIfscBankSelectionPage();


        //Enter account Number
        payRentPage.enterAccountNumber(AccountNumber);

        //Validate Ifsc code

        mbReporter.verifyTrueWithLogging(payRentPage.isIfscCodePrefilled(), "Is IFSC Code Prefilled : "+  payRentPage.isIfscCodePrefilled(), false,false );


        //Click Continue button
        payRentPage.clickContinueButton();

        //Handle Self Transfer Bottomsheet

        payRentPage.handleSelfTransferBottomsheet();

        //Enter Landlord Name
//        payRentPage.enterLandlordName(Name);
        Name= payRentPage.validateLandlordNamePrefilled();
        mbReporter.verifyTrueWithLogging(!(payRentPage.validateLandlordNamePrefilled() ==null), "Prefilled Name : "+  payRentPage.validateLandlordNamePrefilled(), false,false );

        //Enter Rent Amount
        payRentPage.enterRentAmount(Amount);

        //Click Continue
        payRentPage.clickAmountPageContinueButton();

        // check for Security Pin Page
        if(securityPinPage.checkSecurityPinPage()) { securityPinPage.enterSecurityPin();}

        mbkCommonControlsHelper.handle2FADeviceBindingFlow();

        //Press Back 6 times to go to home screen
        mbkCommonControlsHelper.pressback(5);

        // check for pop up on back
        if(!isSavedRecipientPresent){
            if(payRentPage.checkPopUpOnBack()) {
                payRentPage.clickConitnueToRemovePopUp();
            }
            else {
                mbkCommonControlsHelper.pressback();
                if(payRentPage.checkPopUpOnBack()) {
                    payRentPage.clickConitnueToRemovePopUp();
                }
            }
        }
        else {
            mbkCommonControlsHelper.pressback();
        }

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();
//
//        //Click on Pay Rent
//        payRentPage.clickPayRent();
//
//        // check for saved Recipient Screen
//        isSavedRecipientPresent = payRentPage.checkSavedRecipientScreen();
//
//        if(isSavedRecipientPresent){
//
//            // Verification on the Pay Rent HomeScreen
//            String landlordName = payRentPage.getLandlordName();
//            String accountNumber = payRentPage.getAccountNumber();
//
//            // Display the values
//            Log.info("Landlord Name : " + landlordName);
//            Log.info("Account Number of landlord : " + accountNumber);
//
//            // Add the assertions
//            mbReporter.verifyEqualsWithLogging(landlordName, Name, "Verify Landlord Name", false, false, true);
//            mbReporter.verifyEqualsWithLogging(accountNumber, AccountNumber, "Verify Account Number of landlord", false, false, true);
//
//        }
//        else {
//            mbReporter.verifyTrueWithLogging(isSavedRecipientPresent, "Saved Recipient is not Present", false, false, true);
//        }

    }

    public void payRentViaZIP(String AccountNumber, String IfscCode, String Name, String Amount,String expAmount, String expconvenienceFee, String exptotalPayableAmount) throws IOException, InterruptedException{

        //Click on Pay Rent
        payRentPage.clickPayRent();

        // check for saved Recipient Screen
        if(payRentPage.checkSavedRecipientScreen()){

            //Click on Add new Property
            payRentPage.clickAddNewPropertyButton();
        }
        else {

            //click on Continue with ZIP/Cards button
            payRentPage.clickContinueWithZipAndCards();

        }

        //Enter account Number
        payRentPage.enterAccountNumber(AccountNumber);

        //Enter Ifsc code
//        payRentPage.enterIfscCode(IfscCode);

        //Click Continue button
        payRentPage.clickContinueButton();

        //Enter Landlord Name
//        payRentPage.enterLandlordName(Name);

        Name= payRentPage.validateLandlordNamePrefilled();
        mbReporter.verifyTrueWithLogging(!(payRentPage.validateLandlordNamePrefilled() ==null), "Prefilled Name : "+  payRentPage.validateLandlordNamePrefilled(), false,false );

        //Enter Rent Amount
        payRentPage.enterRentAmount(Amount);

        //Click on Continue button
        payRentPage.clickContinueButton();

        // check for Security Pin Page
        if(securityPinPage.checkSecurityPinPage()) { securityPinPage.enterSecurityPin();}

        // Verification on the PayRent Payment bottom sheet
        String totalAmount = payRentPage.getTotalAmount();
        String convFee = payRentPage.getConvFee();
        String payableAmount = payRentPage.getPayableAmount();

        // Display the values
        Log.info("Total Amount : " + totalAmount);
        Log.info("Convenience Fee : " + convFee);
        Log.info("Payable Amount :" + payableAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(totalAmount, expAmount, "Verify Total Amount", false, false, true);
        mbReporter.verifyEqualsWithLogging(convFee, expconvenienceFee, "Verify Convenience Fee", false, false, true);
        mbReporter.verifyEqualsWithLogging(payableAmount, exptotalPayableAmount, "Verify Payable Amount", false, false, true);



    }
    public void payRentviaCard(String AccountNumber, String IfscCode, String Name, String Amount, String expAmount, String expconvenienceFee, String exptotalPayableAmount) throws IOException, InterruptedException{

        //Click on Pay Rent
        payRentPage.clickPayRent();

        // check for saved Recipient Screen
        if(payRentPage.checkSavedRecipientScreen()){

            //Click on Add new Property
            payRentPage.clickAddNewPropertyButton();
        }
        else {

            //click on Continue with ZIP/Cards button
            payRentPage.clickContinueWithZipAndCards();

        }

        //Enter account Number
        payRentPage.enterAccountNumber(AccountNumber);

        //Enter Ifsc code
//        payRentPage.enterIfscCode(IfscCode);

        //Click Continue button
        payRentPage.clickContinueButton();

        //Enter Landlord Name
//        payRentPage.enterLandlordName(Name);
        Name= payRentPage.validateLandlordNamePrefilled();
        mbReporter.verifyTrueWithLogging(!(payRentPage.validateLandlordNamePrefilled() ==null), "Prefilled Name : "+  payRentPage.validateLandlordNamePrefilled(), false,false );

        //Enter Rent Amount
        payRentPage.enterRentAmount(Amount);

        //Click on Continue button
        payRentPage.clickContinueButton();

        // check for Security Pin Page
        if(securityPinPage.checkSecurityPinPage()) { securityPinPage.enterSecurityPin();}

        // Verification on the PayRent Payment bottom sheet
        String totalAmount = payRentPage.getTotalAmount();
        String convFee = payRentPage.getConvFee();
        String payableAmount = payRentPage.getPayableAmount();

        // Display the values
        Log.info("Total Amount : " + totalAmount);
        Log.info("Convenience Fee : " + convFee);
        Log.info("Payable Amount :" + payableAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(totalAmount, expAmount, "Verify Total Amount", false, false, true);
        mbReporter.verifyEqualsWithLogging(convFee, expconvenienceFee, "Verify Convenience Fee", false, false, true);
        mbReporter.verifyEqualsWithLogging(payableAmount, exptotalPayableAmount, "Verify Payable Amount", false, false, true);


    }
    public void payRentViaUpi(String expRecipientName, String Amount) throws IOException, InterruptedException{

        //Click on Pay Rent
        payRentPage.clickPayRent();

        // check for saved Recipient Screen
        boolean isSavedRecipientPresent = payRentPage.checkSavedRecipientScreen();

        if(isSavedRecipientPresent){

            //Click on saved recipient
            payRentPage.clickRentRecipient();

            //click on Use Upi
            payRentPage.clickUseUpi();

            //Enter Rent Amount
            payRentPage.clickFive();
            payRentPage.clickZero();

            //verify recipient name
            String recipientName = payRentPage.getTransaferToName();
            Log.info("Recipient Name : " + recipientName);
            mbReporter.verifyEqualsWithLogging(recipientName, expRecipientName, "Verify Landlord Name", false, false, true);

//            //Click on Continue button
//            payRentPage.clickCnButton();
//
//            //Click on Continue button
//            payRentPage.clickCtaButton();

        }

        else {

            mbReporter.verifyTrueWithLogging(isSavedRecipientPresent, "Saved Recipient is not Present", false, false, true);

        }

    }

    public void verifyTittleAndFaq(String expTitle, String expFaqTitle) throws IOException, InterruptedException {

        //Click on Pay Rent
        payRentPage.clickPayRent();

        // check for saved Recipient Screen
        if(payRentPage.checkSavedRecipientScreen()){

            //Click on saved recipient
            payRentPage.clickRentRecipient();

        }

        // check for Benefit Screen
        boolean isBenefitScreenPresent = payRentPage.checkBenefitScreen();

        if(isBenefitScreenPresent) {
            //Verify Pay rent description screen
            String title = payRentPage.getTitle();
            Log.info("Title of PayRent Benefits screen : " + title);
            mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify title of PayRent Benefits screen", false, false, true);

            //Click on FAQ Button
            payRentPage.clickFaqButton();

            //Verify Pay rent description screen
            String faqTitle = payRentPage.getFaqScreenTitle();
            Log.info("Title of FQA Screen screen : " + faqTitle);
            mbReporter.verifyEqualsWithLogging(faqTitle, expFaqTitle, "Verify title of FAQ Screen", false, false, true);

        }
        else
        {
            mbReporter.verifyTrueWithLogging(isBenefitScreenPresent, "Benefits of Pay rent through Mobikwik screen is not appearing.", false, false, true);

        }
    }


    public void deleteProperty() throws IOException, InterruptedException {

        //Click on Pay Rent
        payRentPage.clickPayRent();

        // check for saved Recipient Screen
        boolean isSavedRecipientPresent = payRentPage.checkSavedRecipientScreen();

        if(isSavedRecipientPresent){

            //Click on menu button
            payRentPage.clickMenuButton();

            //Click on delete rent details
            payRentPage.clickDeleteRentDetails();

            mbReporter.verifyTrueWithLogging(isSavedRecipientPresent, "Rent details is deleted", false, false, true);

        }
        else {

            mbReporter.verifyTrueWithLogging(isSavedRecipientPresent, "Saved Recipient is not Present", false, false, true);
        }

    }
}





