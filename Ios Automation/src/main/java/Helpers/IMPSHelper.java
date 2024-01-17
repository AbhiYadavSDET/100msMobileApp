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

        Thread.sleep(1000);

        //Click Transfer to a new account
        impsPage.clickOnTransferToAccountButton();

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
//        impsPage.enterAmount(amount);
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

        //Verification on checkout bottom sheet
        String actualAmountOnCheckout = impsPage.getAmountOnCheckout();

        Log.info("Amount on Checkout : " + actualAmountOnCheckout);

        mbReporter.verifyEqualsWithLogging(actualAmountOnCheckout, expAmountOnCheckout,"Verify Amount on checkout", false,false, true);

    }

    public void checkImpsLimit(String expTitle) throws InterruptedException, IOException{

        //Click on Wallet to Bank Transfer
        homePage.clickOnIMPS();

        Thread.sleep(1000);

        //Click Transfer to a new account
        impsPage.clickOnTransferToAccountButton();

        //Click on check limits
        impsPage.clickCheckLimits();

        Thread.sleep(1000);

        //Verification of check limit bottom sheet
        String actualTitle = impsPage.getTransferLimitPageTitle();
        Log.info("Check limit screen title : " + actualTitle);

        mbReporter.verifyEqualsWithLogging(actualTitle, expTitle,"Verify the title of check limit bottom sheet", false, false, true);

        impsPage.clickCloseCheckLimitBottomSheet();
    }

    public void warningMessagesOnUPI(){

    }

    public void warningMessagesOnAccountNumber(){

    }

}
