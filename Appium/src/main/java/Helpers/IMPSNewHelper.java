package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.IMPSNewPage;
import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;

import java.io.IOException;
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

    public IMPSNewHelper(AndroidDriver driver) throws  IOException{
        this.driver = driver;
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Elements(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        impsPage = new IMPSNewPage(driver);
    }

    public void verifyIMPSNewAccountTransferFlow(String accountName, String accountNo, String ifsc, String amount, String securityPin) throws InterruptedException, IOException {

        //Dismiss All Ads
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

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
        if(impsPage.checkSecurityPINPage()==true){
            //Security PIN is there
            //Entering Security PIN
            impsPage.setSecurityPIN(securityPin);

        }


        //Assertion Check on Confirmation Page
        Thread.sleep(3000);
        Log.info("Payment Flow done here, Now checking the status...");

        //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();
        String expectedAmt= "₹"+amount;

        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);

        mbReporter.verifyEquals(actualMessage, "Transfer Successful", "Success Page | Message", false, false);
        mbReporter.verifyEquals(actualAmount, expectedAmt, "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

    }

    public void verifyIMPSNewUPITransferFlow(String upiID, String amount, String securityPin) throws InterruptedException, IOException{

        //Dismiss All Ads
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

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

        //Entering Security PIN
        impsPage.setSecurityPIN(securityPin);

        //Assertion Check on Confirmation Page
        Thread.sleep(3000);
        Log.info("Payment Flow done here, Now checking the status...");

        //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();
        String expectedAmt= "₹"+amount;

        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);

        mbReporter.verifyEquals(actualMessage, "Transfer Successful", "Success Page | Message", false, false);
        mbReporter.verifyEquals(actualAmount, expectedAmt, "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();


    }

    public void verifyIMPSSavedAccountTransfer(String upiID,String amount, String securityPin) throws InterruptedException, IOException {


        //Dismiss All Ads
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

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

        //Entering Security PIN
        impsPage.setSecurityPIN(securityPin);

        //Assertion Check on Confirmation Page
        Thread.sleep(3000);
        Log.info("Payment Flow done here, Now checking the status...");

        //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();
        String expectedAmt= "₹"+amount;

        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);

        mbReporter.verifyEquals(actualMessage, "Transfer Successful", "Success Page | Message", false, false);
        mbReporter.verifyEquals(actualAmount, expectedAmt, "Success Page | Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

    }
}
