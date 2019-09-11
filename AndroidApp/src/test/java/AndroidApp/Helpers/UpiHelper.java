package test.java.AndroidApp.Helpers;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Config;
import main.java.utils.Element;
import main.java.utils.Screen;
import main.java.utils.TestDataReader;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.*;

import java.io.IOException;
import java.util.HashMap;

public class UpiHelper {

        AndroidDriver driver;
        OnboardingPage onboardingPage;
        LoginPage loginPage;
        ApiCommonControls apiCommonControls;
        HashMap<String, String> apiOtp;
        HomePage homePage;
        MBReporter mbReporter;
        PermissionHelper permissionHelper;
        Screen screen;
        UpiPage upiPage;
        MBKCommonControlsHelper mbkCommonControlsHelper;
    AddMoneyPage addMoneyPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


        public UpiHelper(AndroidDriver driver) throws IOException {
            this.driver = driver;
            apiCommonControls = new ApiCommonControls();
            apiOtp = new HashMap<>();
            mbReporter = new MBReporter(driver, "testScreenshotDir");
            mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
            // Starting page declaration
            onboardingPage = new OnboardingPage(driver);
            permissionHelper = new PermissionHelper(driver);
            screen = new Screen(driver);
            homePage= new HomePage(driver);
            addMoneyPage= new AddMoneyPage(driver);

        }

        public void sendMoneyViaUpi(String upiId, String amount, String message, String pin) throws InterruptedException, IOException, JSONException {


            mbkCommonControlsHelper.dismissAllOnHomePage(driver);

            Thread.sleep(100);


//            Element.waitForVisibility(driver, By.id("tx_upi_id"));

            upiPage=homePage.clickOnUpiId();

            upiPage.clickOnUpiSetupCta();

            permissionHelper.permissionAllow();

            permissionHelper.permissionAllow();

            permissionHelper.permissionAllow();

            Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

            Boolean setup= Element.isElementPresent(driver, By.id("com.mobikwik_new:id/qr_image"));

            mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

            upiPage.clickSendMoney();

            upiPage.selectEnterUPI();

            permissionHelper.permissionAllow();

            upiPage.enterUpiId(upiId);

            upiPage.clickConfrimUpi();

            upiPage.enterAmount(amount);

            upiPage.enterMessage(message);

            upiPage.clickOnConfirmPayment();

            mbkCommonControlsHelper.handleUpiPin(pin);

            Thread.sleep(400);

            mbkCommonControlsHelper.handleGullak();

            mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "Your payment sent successfully", "Succes Message Validation", false, false);

            String actualTotalAmountPaid = upiPage.getAmountPaid().replace("X", "");

            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

            mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

            mbkCommonControlsHelper.handleRatingsPopUp();

        }

    public void sendMoneyToBankViaUpi(String beneficiaryName, String accountNumber, String ifsc, String amount, String message, String pin) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);


//            Element.waitForVisibility(driver, By.id("tx_upi_id"));

        upiPage=homePage.clickOnUpiId();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup= Element.isElementPresent(driver, By.id("com.mobikwik_new:id/qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        upiPage.clickSendMoney();

        upiPage.selectTransfertoBank();

        upiPage.enterBeneficiaryName(beneficiaryName);

        upiPage.enterAccountNumber(accountNumber);

        upiPage.enterIfsc(ifsc);

        upiPage.clickConfirmBankDetails();

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        upiPage.clickOnConfirmPayment();

        mbkCommonControlsHelper.handleUpiPin(pin);

        Thread.sleep(400);

        mbkCommonControlsHelper.handleGullak();

        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "Your payment sent successfully", "Succes Message Validation", false, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("X", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        mbkCommonControlsHelper.handleRatingsPopUp();

    }

    public void requestMoneyViaUpi(String upiId, String amount, String message) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);


//            Element.waitForVisibility(driver, By.id("tx_upi_id"));

        upiPage=homePage.clickOnUpiId();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup= Element.isElementPresent(driver, By.id("com.mobikwik_new:id/qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        upiPage.clickRequestMoney();

        upiPage.selectEnterUPI();

        permissionHelper.permissionAllow();

        upiPage.enterUpiId(upiId);

        upiPage.clickConfrimUpi();

        upiPage.enterAmount(amount);

        upiPage.enterMessage(message);

        upiPage.clickOnConfirmRequest();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/payment_success_msg"));

        mbReporter.verifyEqualsWithLogging(upiPage.getPaymentSuccessMessage(), "Your payment request sent successfully", "Request Message Validation", true, false);

        String actualTotalAmountPaid = upiPage.getAmountPaid().replace("X", "");

        mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Validate Amount", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        mbkCommonControlsHelper.handleRatingsPopUp();

        mbkCommonControlsHelper.handleNPS();

    }

    public void checkAccountBalance(String pin) throws InterruptedException, IOException, JSONException{

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);

        homePage.clickCheckBalance();

        Thread.sleep(200);

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Link Your Bank Account']"));

        upiPage= homePage.clickOnLinkBankAccount();

        upiPage.clickOnUpiSetupCta();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        Thread.sleep(400);

//            Element.waitForVisibility(driver, By.id("qr_image"));

        Boolean setup= Element.isElementPresent(driver, By.id("com.mobikwik_new:id/qr_image"));

        mbReporter.verifyTrueWithLogging(setup, "Setup Done", true, true);

        homePage=upiPage.clickOnBackButton();

        homePage.clickCheckBalance();

        mbkCommonControlsHelper.handleUpiPin(pin);

        Boolean isBalanceVisible= Element.isElementPresent(driver, By.id("com.mobikwik_new:id/balance"));

        String balance= homePage.getAccountBalance();

        mbReporter.verifyTrueWithLogging(isBalanceVisible, "Avalaible Balance is =Rs "+balance, true,true);

        homePage.dismissOverlay();



    }

    //Payment Successful
    //Money added into your wallet successfully

    public void addMoneyViaUpi(String pin, String amount, String successPageStatus,String successPageText) throws InterruptedException, IOException, JSONException{

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Thread.sleep(100);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(amount);

        addMoneyPage.clickOnContinueButton();

        addMoneyPage.chooseUpiOption();

        addMoneyPage.restoreUpi();

        permissionHelper.permissionAllow();

        permissionHelper.permissionAllow();

        addMoneyPage.chooseUpiOption();

        mbkCommonControlsHelper.handleUpiPin(pin);

        //Assertions
        Double expectedMainBalance = (Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100) + Double.parseDouble(amount) * 100;
        Double actualMainBalance = Double.parseDouble(addMoneyPage.getSuccessPageWalletBalance().replace("New Wallet Balance X", "").replace(",", "")) * 100;
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), successPageText, "Success Screen | Verify Text", false, false);
        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "Success Screen | Verify Main Balance", false, false);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        // POST TRX Assertions
        balanceAfter = mbkCommonControlsHelper.getBalance();
        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 + Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);

    }



}
