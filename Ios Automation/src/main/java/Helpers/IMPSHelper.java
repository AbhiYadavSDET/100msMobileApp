package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class IMPSHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MbkCommonControlHelper mbkCommonControlHelper;
    IMPSPage impsPage;
    RechargePage rechargePage;
    CCBPPage ccbpPage;

    public IMPSHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        mbkCommonControlHelper = new MbkCommonControlHelper(driver);
        mbReporter = new MBReporter(driver);
        impsPage = new IMPSPage(driver);
        rechargePage = new RechargePage(driver);
        ccbpPage = new CCBPPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void transferToAccountNumber(String beneficiaryName, String accountNumber, String ifsc, String expName, String expAccountNumber, String amount, String expAmountOnCheckout) throws InterruptedException, IOException{

        //Click on Wallet to Bank Transfer
        homePage.clickOnIMPS();

        Thread.sleep(2000);

        if(impsPage.isTransferNowPagePresent()){

            //Click on Transfer now button
            impsPage.clickOnTransferNowButton();
        }
        else {

            //Click Transfer to a new account
            impsPage.clickOnTransferToAccountButton();
        }

        //Click on beneficiary name
        impsPage.clickBeneficiaryName();

        //Enter beneficiary name
        impsPage.enterBeneficiaryName(beneficiaryName);

        //Click Account number
        impsPage.clickAccountNumber();

        //Enter account number
        impsPage.enterAccountNumber(accountNumber);

        //click on IFSC
        impsPage.clickIfsc();

        //Enter IFSC code
        impsPage.enterIfscCode(ifsc);

        //Click on continue button
        impsPage.clickOnContinue();

        //Verification On Enter Amount Screen
        String actualNameOnEnterAmountScreen = impsPage.getBeneficiaryNameOnEnterAmountScreen();
        String actualAccountNumberOnEnterAmountScreen = impsPage.getAccountNumberOnEnterAmountScreen();

        Log.info("Beneficiary Name on Enter Amount screen : " + actualNameOnEnterAmountScreen);
        Log.info("Account Number on Enter Amount screen : " + actualAccountNumberOnEnterAmountScreen);

        mbReporter.verifyEqualsWithLogging(actualNameOnEnterAmountScreen, expName, "Verify Beneficiary Name", false, false,true);
        mbReporter.verifyEqualsWithLogging(actualAccountNumberOnEnterAmountScreen, expAccountNumber, "Verify Account Number", false, false,true);

        //Enter amount
        ccbpPage.enterCreditCardNumber(amount);

        Thread.sleep(2000);

        //Click Continue button
        impsPage.clickOnContinue();

        Thread.sleep(2000);

        //Click on Pay button
        rechargePage.clickOnPayButton();

        //Security Pin page handling
        if(securityPinPage.isSecurityPinPageShown()){
            securityPinPage.enterSecurityPin();
        }

        Thread.sleep(3000);

//        //Verification on checkout bottom sheet
//        String actualAmountOnCheckout = impsPage.getAmountOnCheckout();
//
//        Log.info("Amount on Checkout : " + actualAmountOnCheckout);
//
//        mbReporter.verifyEqualsWithLogging(actualAmountOnCheckout, expAmountOnCheckout,"Verify Amount on checkout", false,false, true);

    }

    public void checkImpsLimit(String expTitle) throws InterruptedException, IOException{

        //Click on Wallet to Bank Transfer
        homePage.clickOnIMPS();

        Thread.sleep(2000);

        if(impsPage.isTransferNowPagePresent()){

            //Click on Transfer now button
            impsPage.clickOnTransferNowButton();
        }
        else {

            //Click Transfer to a new account
            impsPage.clickOnTransferToAccountButton();
        }

        //Click on check limits
        impsPage.clickCheckLimits();

        Thread.sleep(1000);

        //Verification of check limit bottom sheet
        String actualTitle = impsPage.getTransferLimitPageTitle();
        Log.info("Check limit screen title : " + actualTitle);

        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle,"Verify the title of check limit bottom sheet", false, false, true);

        impsPage.clickCloseCheckLimitBottomSheet();
    }

    public void warningMessagesOnAccountNumber( String expBeneficiaryErrorMessage, String beneficiaryName, String expAccountNumberErrorMessage, String accountNumber, String expIfscFieldErrorMessage) throws InterruptedException, IOException{

        //Click on Wallet to Bank Transfer
        homePage.clickOnIMPS();

        Thread.sleep(2000);

        if(impsPage.isTransferNowPagePresent()){

            //Click on Transfer now button
            impsPage.clickOnTransferNowButton();
        }
        else {

            //Click Transfer to a new account
            impsPage.clickOnTransferToAccountButton();
        }

        //Click on Continue
        impsPage.clickOnContinue();

        //Beneficiary field error message assertion
        String actualBeneficiaryFieldError = impsPage.getBeneficiaryFieldErrorMessage();
        Log.info("Beneficiary Name field error message : " + actualBeneficiaryFieldError);
        mbReporter.verifyEqualsWithLogging(actualBeneficiaryFieldError, expBeneficiaryErrorMessage,"Verify error message on beneficiary field", false, false, true);

        //Click on beneficiary field
        impsPage.clickBeneficiaryName();

        //Enter beneficiary name
        impsPage.enterBeneficiaryName(beneficiaryName);

        //Click on Continue
        impsPage.clickOnContinue();

        //Account Number field error message assertion
        String actualAccountNumberFieldError = impsPage.getAccountNumberFieldErrorMessage();
        Log.info("Beneficiary Name field error message : " + actualAccountNumberFieldError);
        mbReporter.verifyEqualsWithLogging(actualAccountNumberFieldError, expAccountNumberErrorMessage,"Verify error message on account number field", false, false, true);

        //Click on account number field
        impsPage.clickAccountNumber();

        //Enter account number
        impsPage.enterAccountNumber(accountNumber);

        //Click on Continue
        impsPage.clickOnContinue();

        //Ifsc code field error message assertion
        String actualIfscFieldError = impsPage.getIfscFieldErrorMessage();
        Log.info("Beneficiary Name field error message : " + actualIfscFieldError);
        mbReporter.verifyEqualsWithLogging(actualIfscFieldError, expIfscFieldErrorMessage,"Verify error message on Ifsc field", false, false, true);

    }

    public void warningMessagesOnUpi(String expUpiFieldErrorMessage) throws InterruptedException, IOException{

        //Click on Wallet to Bank Transfer
        homePage.clickOnIMPS();

        Thread.sleep(2000);

        if(impsPage.isTransferNowPagePresent()){

            //Click on Transfer now button
            impsPage.clickOnTransferNowButton();
        }
        else {

            //Click Transfer to a new account
            impsPage.clickOnTransferToAccountButton();
        }

        //Click on UPI radio option
        impsPage.clickOnUPIOption();

        //Click on continue button
        impsPage.clickOnContinue();

        //Verification on upi id field error message
        String actualUpiFieldErrorMessage = impsPage.getUpiFieldErrorMessage();
        Log.info("UPI field error message : " + actualUpiFieldErrorMessage);

        mbReporter.verifyEqualsWithLogging(actualUpiFieldErrorMessage, expUpiFieldErrorMessage, "Verify error message on UPI Id field", false, false, true);


    }

    public void transferToUpiId(String upi, String expNameOfReceiver, String expUpiIdOfReceiver, String amount) throws InterruptedException, IOException{

        //Click on Wallet to Bank Transfer
        homePage.clickOnIMPS();

        Thread.sleep(2000);

        if(impsPage.isTransferNowPagePresent()){

            //Click on Transfer now button
            impsPage.clickOnTransferNowButton();
        }
        else {

            //Click Transfer to a new account
            impsPage.clickOnTransferToAccountButton();
        }

        //Click on UPI radio option
        impsPage.clickOnUPIOption();

        //Click on UPI Id text field
        impsPage.clickOnUpiIdField();

        //Enter upi id
        impsPage.enterUPIId(upi);

        //Click on continue button
        impsPage.clickOnContinue();

        Thread.sleep(2000);

        //Verification on Enter amount screen
        String actualNameOfReceiver = impsPage.getBeneficiaryNameOnEnterAmountScreen();
        String actualUpiIdOfReceiver = impsPage.getAccountNumberOnEnterAmountScreen();

        Log.info("Name of Receiver : " + actualNameOfReceiver);
        Log.info("UPI Id of Receiver : " + actualUpiIdOfReceiver);

        mbReporter.verifyEqualsWithLogging(actualNameOfReceiver, expNameOfReceiver, "Verify name of receiver", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualUpiIdOfReceiver, expUpiIdOfReceiver, "Verify UPI Id of receiver", false, false, true);

        //Enter amount
        ccbpPage.enterCreditCardNumber(amount);

        Thread.sleep(2000);

        //Click Continue button
        impsPage.clickOnContinue();

        Thread.sleep(2000);

        //Click on Pay button
        rechargePage.clickOnPayButton();

        //Security Pin page handling
        if(securityPinPage.isSecurityPinPageShown()){
            securityPinPage.enterSecurityPin();
        }

        Thread.sleep(3000);


    }
}
