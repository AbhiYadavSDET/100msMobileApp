package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.IMPSNewPage;
import PageObject.SecurityPinPage;
import Utils.Element;
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
import java.util.NoSuchElementException;


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


    public IMPSNewHelper(AndroidDriver driver) throws IOException {
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
        // balanceBefore = mbkCommonControlsHelper.getBalance();

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        try {

            //Element.waitForInvisibility(driver, By.id("prv_progress_bar"));
            //Log.info("Loader Gone");

            Thread.sleep(10000);
            Log.info("Sleep ends");


            Element.waitForVisibilityMultipleElements(driver, By.id("btn_continue"), By.id("btn_new_transfer"));


            if (impsPage.isZeroState()) {
                impsPage.clickOnTransferNowOnZeroState();
            } else {
                impsPage.clickOnTransferToNewAccount();
            }

            // Enter the bank details
            impsPage.setBeneficiaryName(accountName);

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());

            driver.navigate().back();

            if (Element.isElementPresent(driver, By.id("design_bottom_sheet"))) {
                driver.navigate().back();
                Log.info("Closed Feedback bottomSheet");
                driver.navigate().back();
            }
            mbkCommonControlsHelper.handleHomePageLanding();
            impsPage.clickOnWalletToBank();

//            Element.waitForInvisibility(driver, By.id("prv_progress_bar"));
            Element.waitForVisibilityMultipleElements(driver, By.id("btn_continue"), By.id("btn_new_transfer"));


            if (impsPage.isZeroState()) {
                impsPage.clickOnTransferNowOnZeroState();
            } else {
                impsPage.clickOnTransferToNewAccount();
            }

            // Enter the bank details
            impsPage.setBeneficiaryName(accountName);

        }


        impsPage.setAccountNumber(accountNo);
        impsPage.setIFSC_Code(ifsc);
        impsPage.clickOnContinueCTA();

        //Entering Amount Page
        impsPage.setAmount(amount);
        impsPage.clickOnSetAmount();
        // impsPage.clickOnContinueToPinCTA();
        impsPage.clickOnContinueToCheckoutCTA();


        //Check Security PIN Page
        if (securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        //Assertion Check on Confirmation Page
        Log.info("Security pin option is passed...");

        mbkCommonControlsHelper.handle2FADeviceBindingFlow();

    /*    //Storing Actual Message on Screen and Expected Result in String
        String actualMessage = impsPage.getSuccessMessage();
        String actualAmount = impsPage.getSuccessPageAmount();

        // Display the values
        Log.info("Actual Message on Screen is :" + actualMessage);
        Log.info("Actual Amount on Screen is" + actualAmount);*/

     /*   // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Success Page | Message", false, false);
        mbReporter.verifyEqualsWithLogging(actualAmount, expectedAmount, "Success Page | Amount", false, false);

        // back to home
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransactionWithConvenienceFee(driver, balanceBefore, balanceAfter, amount, 2);

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);

    }*/
    }

    public void verifyIMPSNewVPA(String upiID, String amount, String expectedMessage, String expectedAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));
        //Going to UPI Option
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }
        impsPage.clickOnUPIRadioBtn();

        //Entering UPI ID
        impsPage.setUPIID(upiID);
        impsPage.clickOnContinueToAmtCTA();

        //Entering Amount and Continue to PIN
        impsPage.setAmount(amount);
        Thread.sleep(2000);
        impsPage.clickOnSetAmount();
//        impsPage.clickOnArrowButton();


        impsPage.clickOnContinueToCheckoutCTA();

        //Check Security PIN Page
        if (securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        mbkCommonControlsHelper.handle2FADeviceBindingFlow();

        //Assertion Check on Confirmation Page
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

        impsPage.navigateBackFromSuccessPage();

        mbkCommonControlsHelper.handleHomePageLanding();


        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransactionWithConvenienceFee(driver, balanceBefore, balanceAfter, amount, 2);

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);

    }

    public void verifyIMPSSavedVPA(String upiID, String amount, String expectedMessage, String expectedAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        //   Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        //  Going to IMPS Option
        impsPage.clickOnWalletToBank();

        //Computing Dynamic Xpath upiID entered as parameter
        String xpathSavedUPI = "//android.widget.TextView[@text = '" + upiID + "']";

        //Select already saved VPA using XPath calculated above
        AndroidElement savedVPA = (AndroidElement) driver.findElementByXPath(xpathSavedUPI);
        Element.waitForVisibility(driver, savedVPA);
        impsPage.clickOnSavedVPA();

        //Entering Amount and Continue to PIN
        impsPage.setAmount(amount);
        //    impsPage.clickOnSetAmount();
        impsPage.clickOnContinueToPinCTA();
        impsPage.clickOnContinueText();

        //Check Security PIN Page
        if (securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        //Assertion Check on Confirmation Page
        Thread.sleep(5000);
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
        mbkCommonControlsHelper.verifyHistoryDetails(driver, expectedHistoryDescription, expectedHistoryAmount, expectedHistoryStatus);
    }

    public void verifyIMPSNewAccountWithAutoIfscCode(String accountName, String accountNo, String bankName, String amount) throws InterruptedException, IOException {

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }

        // Enter the bank details
        impsPage.setBeneficiaryName(accountName);
        impsPage.setAccountNumber(accountNo);
        impsPage.clickOnFindiFSC();
        impsPage.selectIciciBankOnImps();

        //
        impsPage.clickOnContinueCTA();

    }

    public void verifyIMPSWithInsuranceOption(String accountName, String accountNo, String ifsc, String amount) throws InterruptedException, IOException {

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }

        // Enter the bank details
        impsPage.setBeneficiaryName(accountName);
        impsPage.setAccountNumber(accountNo);
        impsPage.setIFSC_Code(ifsc);
        impsPage.clickOnContinueCTA();

        impsPage.setAmount(amount);
        impsPage.clickOnContinueToPinCTA();

        if (impsPage.isAdvertisementPresent()) {
            impsPage.clickOnAdvertisementCheckBox();
            Log.info(impsPage.getInsuranceMessage());

            String inusuranceAmount = impsPage.getInsuranceMessage().split("₹")[1];
            double totalAmount = Double.parseDouble(inusuranceAmount) + Integer.parseInt(amount);

            Log.info("Total amount =" + amount + " +" + inusuranceAmount + " =" + totalAmount);
        }
    }
/*    public void verifyReferAndEarnOnImps() throws InterruptedException, IOException {

        // Click on Imps on home page

        impsPage.clickOnWalletToBank();

       // Click on refer & earn on imps landing page
        impsPage.clickOnReferAndEarn();

        // back to home
        mbkCommonControlsHelper.handleHomePageLanding();

    }*/

    public void verifyIMPSErrorMessageOnAddNewProperty(String accountName, String accountNo) throws InterruptedException, IOException {

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));

        //Click on transfer new account
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }

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

    public void verifyCheckLimitsOnImps() throws InterruptedException, IOException {

        // Click on Imps on home page

        impsPage.clickOnWalletToBank();

        // Click on check limit on imps landing page
        impsPage.clickOnCheckLimits();
        mbReporter.verifyEqualsWithLogging(impsPage.getTransferLimitsMessage(), "TRANSFER LIMITS", "Check limit on Imps Page", false, false);

        //close the check limit popup
        impsPage.clickOnCloseCheckLimits();
    }

    public void verifyIMPSNewAccountWithManualIfscCode(String accountName, String accountNo, String ifsc, String amount, String expectedMessage, String expectedAmount, String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }

        // Enter the bank details
        impsPage.setBeneficiaryName(accountName);
        impsPage.setAccountNumber(accountNo);
        impsPage.setIFSC_Code(ifsc);
        impsPage.clickOnContinueCTA();

        //Entering Amount Page
        impsPage.setAmount(amount);
        impsPage.clickOnContinueToPinCTA();
        impsPage.clickOnContinueToCheckoutCTA();


        //Check Security PIN Page
        if (securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();

        //Assertion Check on Confirmation Page
        Log.info("Security pin option is passed...");

    }

    public void verifyIMPSInfoMessages(String beneficiaryName, String amount, String accountNumber, String ifscCode) throws InterruptedException, IOException {

        balanceBefore = mbkCommonControlsHelper.getBalance();
        String balance1 = balanceBefore.get("Balance");
        Log.info("Wallet balance :" + balance1);

        Integer balance = StringToInt(balance1);

        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }

        impsPage.setBeneficiaryName(beneficiaryName);
        impsPage.setAccountNumber(accountNumber);
        impsPage.setIFSC_Code(ifscCode);

        impsPage.clickOnContinueToAmtCTA();
        impsPage.setAmount(amount);

        String message = impsPage.getInfoMessage();

        if (balance < Integer.parseInt(amount)) {
            mbReporter.verifyEqualsWithLogging(impsPage.getInfoMessage(), "Convenience fee will be shown on next step", "Check Info message on Imps amount Page when wallet balance is low", false, false);

        } else {
            mbReporter.verifyEqualsWithLogging(impsPage.getInfoMessage(), "No Additional charges for this transfer", "Check Info message on Imps amount Page when wallet balance is greater than amount", false, false);

        }
        String maxAmount = "50000";
        impsPage.setAmount(maxAmount);

        message = impsPage.getInfoMessage();

        if (balance < Integer.parseInt(maxAmount)) {
            mbReporter.verifyEqualsWithLogging(message, "Convenience fee will be shown on next step", "Check Info message on Imps amount Page when wallet balance is low", false, false);

        } else {
            mbReporter.verifyEqualsWithLogging(message, "No Additional charges for this transfer", "Check Info message on Imps amount Page when wallet balance is greater than amount", false, false);

        }
    }


    public void verifyIMPSCheckout(String beneficiaryName, String accountNumber, String ifscCode, String amount, String cvv) throws InterruptedException, IOException {


        //Going to IMPS Option
        impsPage.clickOnWalletToBank();

        Element.waitForVisibilityMultipleElements(driver, By.xpath("//android.widget.Button[contains(@text, 'Transfer now')]"), By.id("com.mobikwik_new.debug:id/btn_new_transfer"));
        if (impsPage.isZeroState()) {
            impsPage.clickOnTransferNowOnZeroState();
        } else {
            impsPage.clickOnTransferToNewAccount();
        }

        impsPage.setBeneficiaryName(beneficiaryName);
        impsPage.setAccountNumber(accountNumber);
        impsPage.setIFSC_Code(ifscCode);


        impsPage.clickOnContinueToAmtCTA();
        impsPage.setAmount(amount);
        impsPage.clickOnArrowButton();
        impsPage.clickOnContinueButtonOnFinalCheckout();

        //Check Security PIN Page
        if (securityPinPage.checkSecurityPinPage()) securityPinPage.enterSecurityPin();
        impsPage.clickOnMorePaymentOptions();
        impsPage.clickOnCheckBox();
        impsPage.clickOnContinueOnCheckout();
        impsPage.setCVV(cvv);
        impsPage.clickOnPayAftercvv();

    }

    public int StringToInt(String val) {

        int n = val.length();
        System.out.println("n = " + n);
        if (n > 2 && val.charAt(n - 3) == '.') {
            val = val.substring(0, n - 3);
        } else if (n > 1 && val.charAt(n - 2) == '.') {
            val = val.substring(0, n - 2);
        }
        return Integer.parseInt(val);
    }
}
