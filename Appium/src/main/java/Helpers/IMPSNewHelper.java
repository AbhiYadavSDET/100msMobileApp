package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.IMPSNewPage;
import PageObject.SecurityPinPage;
import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;


//Author - HarshTyagiOMK2165

public class IMPSNewHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Elements element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    IMPSNewPage impsPage;
    SecurityPinPage securityPinPage;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;


    public IMPSNewHelper(AndroidDriver driver) throws  IOException{
        this.driver = driver;
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Elements(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        impsPage = new IMPSNewPage(driver);
        securityPinPage = new SecurityPinPage(driver);
    }

    public void verifyIMPSNewAccount(String accountName, String accountNo, String ifsc, String amount, String expectedMessage, String expectedAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        impsPage.clickOnTransferToNewAccount();

        // Enter the bank details
        impsPage.setBeneficiaryName(accountName);
        impsPage.setAccountNumber(accountNo);
        impsPage.setIFSC_Code(ifsc);
        impsPage.clickOnContinueCTA();

        //Entering Amount Page
        impsPage.setAmount(amount);
        impsPage.clickOnSetAmount();
        impsPage.clickOnContinueToPinCTA();

        //Check Security PIN Page
        if(securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        //Assertion Check on Confirmation Page
        Thread.sleep(3000);
        Log.info("Payment Flow done here, Now checking the status...");

        //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();

        // Display the values
        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, expectedAmount, "Success Page | Amount", false, false);

        // back to home
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransactionWithConvenienceFee(driver, balanceBefore, balanceAfter, amount, 2);

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }

    public void verifyIMPSNewVPA(String upiID, String amount, String expectedMessage, String expectedAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException{

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        //Going to UPI Option
        impsPage.clickOnTransferToNewAccount();
        impsPage.clickOnUPIRadioBtn();

        //Entering UPI ID
        impsPage.setUPIID(upiID);
        impsPage.clickOnContinueToAmtCTA();

        //Entering Amount and Continue to PIN
        impsPage.setAmount(amount);
        impsPage.clickOnSetAmount();
        impsPage.clickOnContinueToPinCTA();

        //Check Security PIN Page
        if(securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        //Assertion Check on Confirmation Page
        Thread.sleep(3000);
        Log.info("Payment Flow done here, Now checking the status...");

        //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();

        // Display the values
        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, expectedAmount, "Success Page | Amount", false, false);

        // back to home
        mbkCommonControlsHelper.handleHomePageLanding();


        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransactionWithConvenienceFee(driver, balanceBefore, balanceAfter, amount, 2);

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);





    }

    public void verifyIMPSSavedVPA(String upiID, String amount, String expectedMessage, String expectedAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        //Computing Dynamic Xpath upiID entered as parameter
        String xpathSavedUPI="//android.widget.TextView[@text = '" +upiID+"']";

        //Select already saved VPA using XPath calculated above
        AndroidElement savedVPA= (AndroidElement) driver.findElementByXPath(xpathSavedUPI);
        impsPage.clickOnSavedVPA(savedVPA);

        //Entering Amount and Continue to PIN
        impsPage.setAmount(amount);
        impsPage.clickOnSetAmount();
        impsPage.clickOnContinueToPinCTA();

        //Check Security PIN Page
        if(securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        //Assertion Check on Confirmation Page
        Thread.sleep(3000);
        Log.info("Payment Flow done here, Now checking the status...");

        //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();

        // Display the values
        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);

        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, expectedAmount, "Success Page | Amount", false, false);

        // back to home
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransactionWithConvenienceFee(driver, balanceBefore, balanceAfter, amount, 2);

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);

    }

    public void verifyIMPSNewAccountWithAutoIfscCode(String accountName, String accountNo, String bankName,String amount) throws InterruptedException, IOException {

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        impsPage.clickOnTransferToNewAccount();

        // Enter the bank details
        impsPage.setBeneficiaryName(accountName);
        impsPage.setAccountNumber(accountNo);
        impsPage.searchBankOnImps(bankName);

        //
        impsPage.clickOnContinueCTA();

        //Entering Amount Page
        impsPage.setAmount(amount);
        impsPage.clickOnSetAmount();
        impsPage.clickOnContinueToPinCTA();

    }
    public void verifyReferAndEarnOnImps() throws InterruptedException, IOException {

        // Click on Imps on home page

        impsPage.clickOnWalletToBank();

       // Click on refer & earn on imps landing page
        impsPage.clickOnReferAndEarn();

        // Add the assertions
        mbReporter.verifyEqualsWithLogging("actualMessage", "expectedMessage", " Imps | Refer & Earn", false, false);

        // back to home
        mbkCommonControlsHelper.handleHomePageLanding();

    }

    public void verifyIMPSErrorMessageOnAddNewProperty(String accountName, String accountNo) throws InterruptedException, IOException {

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Thread.sleep(3000);

        //Click on transfer new account
        impsPage.clickOnTransferToNewAccount();

        //click on continue without adding beneficiary details
        impsPage.clickOnContinueCTA();

        mbReporter.verifyEqualsWithLogging(impsPage.getBeneficiaryMessage(), "Beneficiary Name cannot be empty", "Add new property  Page | continue without beneficiary", false, false);

        // Enter the beneficiary details
        impsPage.setBeneficiaryName(accountName);

        //click on continue without adding account number details
        impsPage.clickOnContinueCTA();
        mbReporter.verifyEqualsWithLogging(impsPage.getAccountNumberMessage(), "Account Number cannot be empty", "Add new property  Page | continue without account number", false, false);


        // Enter the account number details
        impsPage.setAccountNumber(accountNo);


        //click on continue without adding ifsc code  details
        impsPage.clickOnContinueCTA();
        mbReporter.verifyEqualsWithLogging(impsPage.getIfscCodeMessage(), "IFSC Code cannot be empty", "Add new property  Page | continue without ifsc code", false, false);


        //click on upi id button
        impsPage.clickOnUPIRadioBtn();

        //click on continue without adding upi id details
        impsPage.clickOnContinueToAmtCTA();
        mbReporter.verifyEqualsWithLogging(impsPage.getUPIMessage(), "Please enter valid UPI Id", "Add new property  Page | continue without upi id", false, false);

    }


}
