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
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.LoginPage;
import test.java.AndroidApp.PageObject.OnboardingPage;
import test.java.AndroidApp.PageObject.UpiPage;

import java.io.IOException;
import java.util.HashMap;

public class UpiHelper {

        AndroidDriver driver;
        OnboardingPage onboardingPage;
        LoginPage loginPage;
        ApiCommonControls apiCommonControls;
        public static HashMap<String, String> map;
        HashMap<String, String> apiOtp;
        HomePage homePage;
        MBReporter mbReporter;
        PermissionHelper permissionHelper;
        Screen screen;
        UpiPage upiPage;
        MBKCommonControlsHelper mbkCommonControlsHelper;


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




}
