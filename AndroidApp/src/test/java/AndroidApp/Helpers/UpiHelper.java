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

            upiPage=homePage.clickOnUpiId();

            upiPage.clickOnUpiSetupCta();

            permissionHelper.permissionAllow();

            permissionHelper.permissionAllow();

            permissionHelper.permissionAllow();

            Thread.sleep(500);

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

            upiPage.returnToHomePage();

            mbkCommonControlsHelper.handleRatingsPopUp();

            upiPage.returnToHomePage();



        }
}
