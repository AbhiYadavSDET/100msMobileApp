package Helpers;

import PageObject.HomePage;
import PageObject.ImpsPage;
import PageObject.MbkCommonControlsPage;
import PageObject.P2MPage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class ImpsHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    P2MPage p2mPage;
    PermissionHelper permissionHelper;
    ImpsPage impsPage;
    MbkCommonControlsPage mbkCommonControlsPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    Double fee = 0.00;

    public ImpsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        impsPage = new ImpsPage(driver);

    }


    public void verifyImps(String accountName, String accountNo, String ifsc, String amount, String securityPin) throws InterruptedException, IOException, JSONException {
        //driver.navigate().back();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        impsPage.clickOnViaWallet();

        impsPage.clickOnWalletToBank();

        // Swipe the homescreen up
        Thread.sleep(2000);
        screen.swipeUpLess(driver);


        // Enter the bank details
        impsPage.enterBeneficiaryName(accountName);
        impsPage.enterAccountNo(accountNo);
        impsPage.enterIfsc(ifsc);


        impsPage.clickOnCtaContinue();

        impsPage.sendAmount(amount);
        Thread.sleep(5000);

        impsPage.clickOnContinue();

        impsPage.clickOnConfirm();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);
        Thread.sleep(3000);

        // Enter the OTP
        Log.info("Enter the OTP");

        Element.waitForVisibility(driver, By.xpath("//android.widget.EditText[@text = '••••••']"));

        impsPage.clickOnSubmitOtp();

        Thread.sleep(10000);

        //Assertion on the success page
        //fetch the values
        String actualMessage = impsPage.getSuccessMessage();
        String actualAccountNo = impsPage.getSuccessPageAccountNo();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        mbReporter.verifyEqualsWithLogging(actualMessage, "Your Transfer is Successful", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAccountNo, accountNo, "Success Page | Account No", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "₹ 50", "Success Page | Amount", false, false);

        //mbkCommonControlsPage.clickOnBackButtonfromIMPSSucessScreen();

    }
        //Lakshay's entries-

    public void sendMoneyVPA(String vpa, String amount, String securityPin) throws InterruptedException, JSONException, IOException {
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        //Storing Available Balance (Wallet Balance)
        balanceBefore = mbkCommonControlsHelper.getBalance();
        Double beforeBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE))*100;
        System.out.println(beforeBalance);

        //impsPage.clickOnViaWallet();
        impsPage.clickOnWalletToBank();

        // Swipe the homescreen up
        Thread.sleep(2000);
        screen.swipeUpLess(driver);

        impsPage.clickTransferToNewAccount();

        //Click on UPI Radio Button
        impsPage.selectUPIRadioButton();
        impsPage.enterVPA(vpa);

        impsPage.clickUPIContinueButton();

        //impsPage.sendAmount(amount);

        //Entering amount on the page-
        impsPage.clickButton5();
        impsPage.clickButton0();

        Thread.sleep(5000);
        //Capturing Conv Fee
        if (driver.findElementById("convenience_fee_amount").isDisplayed()){
        String convFee = impsPage.getConvFee();
        String substrFee = convFee.substring(2);
         fee = Double.parseDouble(substrFee)*100;}

        impsPage.clickAmountSubmitButton();

        impsPage.clickPay();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);

        impsPage.closeReferralDialogBox();
        Thread.sleep(5000);

        //Assertions
        String actualMessage = impsPage.getSuccessMessage();
        String actualVpa = impsPage.getSuccessPageVPA();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        impsPage.clickBackButton();

        //Comparing Balance
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double remainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE))*100;
        System.out.println(remainBalance);
        Double diff = (beforeBalance-remainBalance-fee);
        String diffBalance = diff.toString();

        mbReporter.verifyEqualsWithLogging(diffBalance, "5000.0", "Amount Deduction | Verification", false, false);
        mbReporter.verifyEqualsWithLogging(actualMessage, "Your Transfer is Successful", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualVpa, vpa, "Success Page | VPA", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "₹ 50", "Success Page | Amount", false, false);

        //mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

    }

    public void sendMoneyBA(String accountName, String accountNo, String ifsc, String amount, String securityPin) throws InterruptedException, IOException, JSONException {
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        //Getting Wallet Balance
        balanceBefore = mbkCommonControlsHelper.getBalance();
        Double beforeBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE))*100;

        impsPage.clickOnWalletToBank();

        Thread.sleep(2000);
        screen.swipeUpLess(driver);

        impsPage.clickTransferToNewAccount();

        //Enter Bank Account Details
        impsPage.enterBeneficiaryName(accountName);
        impsPage.enterAccountNo(accountNo);
        impsPage.enterIfsc(ifsc);
        driver.navigate().back();

        impsPage.clickUPIContinueButton();

        //impsPage.sendAmount(amount);

        //Entering amount on the page-
        impsPage.clickButton5();
        impsPage.clickButton0();
        Thread.sleep(5000);
        //Getting IMPS Fee
        if (driver.findElementById("convenience_fee_amount").isDisplayed()){
            String convFee = impsPage.getConvFee();
            String substrFee = convFee.substring(2);
            fee = Double.parseDouble(substrFee)*100;}


        impsPage.clickAmountSubmitButton();

        impsPage.clickPay();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);

        impsPage.closeReferralDialogBox();
        Thread.sleep(5000);


        //Assertions
        String actualMessage = impsPage.getSuccessMessage();
        String actualAccountNo = impsPage.getSuccessPageAccountNo();
        String actualAmount = impsPage.getSuccessSuccessPageAmount();

        //Comparing Balance
        impsPage.clickBackButton();

        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double remainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE))*100;
        System.out.println(remainBalance);
        Double diff = (beforeBalance-remainBalance-fee);
        String diffBalance = diff.toString();


        mbReporter.verifyEqualsWithLogging(diffBalance, "5000.0", "Amount Deduction | Verification", false, false);
        mbReporter.verifyEqualsWithLogging(actualMessage, "Your Transfer is Successful", "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAccountNo, accountNo, "Success Page | Account No", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, "₹ 50", "Success Page | Amount", false, false);

        //mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

    }
}