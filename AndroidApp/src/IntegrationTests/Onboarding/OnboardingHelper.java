package IntegrationTests.Onboarding;

import IntegrationTests.Screens.OnboardingScreen;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;

/**
 * contains all methods to test Add Money Flow
 */
public class OnboardingHelper extends OnboardingHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    OnboardingScreen onboardingScreen;
    ApiCommonControls apiCommonControls;
    String otpMid = "MBK5778";
    String serviceURL = "https://wallet.mobikwik.com/getotpandtokendata/";
    String serviceCode = "0";
    HashMap<String, String> apiOtp;
    HashMap<String, String> walletBalance;
    Reporter reporter = new Reporter();


    public OnboardingHelper(AndroidDriver driver) throws IOException {
        onboardingScreen = new OnboardingScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();


    }


    @Override
    public void onboardingLogin(String mobileNo, String userName, String name, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;


        try {

            mbkCommonControls.handleCTOverlay();

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Mobile Number"), "");
            onboardingScreen.waitForVisibility(By.id("com.mobikwik_new:id/phone_number"));
            onboardingScreen.findElement(By.id("com.mobikwik_new:id/phone_number")).sendKeys(mobileNo);

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Get OTP CTA"), "");
            onboardingScreen.selectElement(By.id("send_otp"));

            mbkCommonControls.allowPermission(true, "SMS Permission");


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "OTP"), "");
            Thread.sleep(3000);
            apiOtp = apiCommonControls.getOTPfromDB(userName, mobileNo, otpMid, serviceURL, serviceCode);

            onboardingScreen.waitForVisibility(By.id("otp_field"));
            Log.info("OTP", apiOtp.get("otp"));
            onboardingScreen.findElement(By.id("otp_field")).sendKeys(apiOtp.get("otp"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Submit OTP CTA"), "");
            onboardingScreen.selectElement(By.id("continue_btn"));

            mbkCommonControls.handleUpiInOnboarding();


            Thread.sleep(3000);
            if (onboardingScreen.isElementPresent(By.id("skip"))) {
                Log.info("SELECT", "Skip button");
                onboardingScreen.selectElement(By.name("Skip"));
            }

            mbkCommonControls.handleConscentPopup();


            Log.info("SELECT", "Hamburger");
            onboardingScreen.selectElement(By.xpath("//*/android.view.ViewGroup/android.widget.FrameLayout[@index = '2']/android.widget.ImageView[@index='0']"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ASSERT", "Details"), "");

            String actualName = onboardingScreen.findElement(By.id("com.mobikwik_new:id/drawerHeadingName")).getText();
            String actualEmail = onboardingScreen.findElement(By.id("com.mobikwik_new:id/drawerHeadingEmail")).getText();
            String actualMobileNo = onboardingScreen.findElement(By.id("com.mobikwik_new:id/drawerHeadingNumber")).getText();

            onboardingScreen.verifyEqualsExtentReport(actualName, name, "Name | Actual : " + actualName + " | Expected : " + name, true, "Verify Name", directoryName, screenName);
            onboardingScreen.verifyEqualsExtentReport(actualEmail, userName, "Email | Actual : " + actualEmail + " | Expected : " + userName, true, "Verify Email", directoryName, screenName);
            onboardingScreen.verifyEqualsExtentReport(actualMobileNo, mobileNo, "Phone No. | Actual : " + actualMobileNo + " | Expected : " + mobileNo, true, "Verify MobileNo", directoryName, screenName);


            Log.info("CLOSE", "Sidedrawer");
            onboardingScreen.navigateBack();


        } catch (Exception e)

        {
            String s = onboardingScreen.screenCaptureExtentReport(directoryName, screenName);
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "STEP " + testStepCount + Log.info("ASSERT", "Details"), s, e.getMessage());
            throw e;

        }


    }

    public void loginViaMobileNo(String mobileNo, String userName, String name, String directoryName, String
            screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;

        try {

            mbkCommonControls.handleCTOverlay();

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SKIP", "Onboarding flow"), "");
            onboardingScreen.selectElement(By.id("skip"));

            mbkCommonControls.handleConscentPopup();

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Login/Signup button"), "");
            onboardingScreen.selectElement(By.id("tx_balance"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Login Details"), "");
            onboardingScreen.selectElement(By.xpath("//android.widget.TextView[@text='EXISTING USER']"));

            onboardingScreen.findElement(By.id("edit_text_mket")).sendKeys(mobileNo);

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Send OTP CTA"), "");
            onboardingScreen.selectElement(By.id("btnLogin"));

            mbkCommonControls.allowPermission(true, "SMS");

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "OTP"), "");
            Thread.sleep(3000);
            apiOtp = apiCommonControls.getOTPfromDB(userName, mobileNo, otpMid, serviceURL, serviceCode);

            onboardingScreen.waitForVisibility(By.id("otp_field"));
            Log.info("OTP", apiOtp.get("otp"));
            onboardingScreen.findElement(By.id("otp_field")).sendKeys(apiOtp.get("otp"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Submit OTP CTA"), "");
            onboardingScreen.selectElement(By.id("continue_btn"));

            mbkCommonControls.handleMagicPopup();


            Log.info("SELECT", "Hamburger");
            onboardingScreen.selectElement(By.id("icon_drawer"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ASSERT", "Details"), "");

            String actualName = onboardingScreen.findElement(By.id("drawerHeadingName")).getText();
            String actualEmail = onboardingScreen.findElement(By.id("drawerHeadingEmail")).getText();
            String actualMobileNo = onboardingScreen.findElement(By.id("drawerHeadingNumber")).getText();

            onboardingScreen.verifyEqualsExtentReport(actualName, name, "Name | Actual : " + actualName + " | Expected : " + name, true, "Verify Name", directoryName, screenName);
            onboardingScreen.verifyEqualsExtentReport(actualEmail, userName, "Email | Actual : " + actualEmail + " | Expected : " + userName, true, "Verify Email", directoryName, screenName);
            onboardingScreen.verifyEqualsExtentReport(actualMobileNo, mobileNo, "Phone No. | Actual : " + actualMobileNo + " | Expected : " + mobileNo, true, "Verify MobileNo", directoryName, screenName);


            Log.info("CLOSE", "Sidedrawer");
            onboardingScreen.navigateBack();

        } catch (
                Exception e)

        {
            String s = onboardingScreen.screenCaptureExtentReport(directoryName, screenName);
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "STEP " + testStepCount + " | ASSERT       | Details", s, e.getMessage());
            throw e;

        }
    }

    @Override
    public void loginViaPassword(String mobileNo, String userName, String password, String name, String
            directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;

        try {

            mbkCommonControls.handleCTOverlay();


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SKIP", "Onboarding flow"), "");
            onboardingScreen.selectElement(By.id("com.mobikwik_new:id/skip"));

            mbkCommonControls.handleConscentPopup();

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Login/Signup button"), "");
            onboardingScreen.selectElement(By.id("tx_balance"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Login Details"), "");
            onboardingScreen.selectElement(By.xpath("//android.widget.TextView[@text='EXISTING USER']"));


            Log.info("ENTER", "Email");
            onboardingScreen.findElement(By.id("edit_text_mket")).sendKeys(userName);

            Thread.sleep(3000);
            Log.info("ENTER", "Password");
            onboardingScreen.waitForVisibility(By.xpath("//*/android.widget.TextView[@text = 'Password']/following::android.widget.EditText"));
            onboardingScreen.findElement(By.xpath("//*/android.widget.TextView[@text = 'Password']/following::android.widget.EditText")).sendKeys(password);


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Login CTA"), "");
            onboardingScreen.hideKeyboard();
            onboardingScreen.selectElement(By.id("btnLogin"));
            Thread.sleep(3000);

            mbkCommonControls.allowPermission(true, "SMS");


            if (onboardingScreen.isElementPresent(By.xpath("//android.widget.TextView[@text = 'Enter OTP']"))) {

                apiOtp = apiCommonControls.getOTPfromDB(userName, mobileNo, otpMid, serviceURL, serviceCode);

                onboardingScreen.waitForVisibility(By.id("edit_text_mket"));
                Log.info("OTP", apiOtp.get("otp"));
                onboardingScreen.findElement(By.id("edit_text_mket")).sendKeys(apiOtp.get("otp"));

                reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Submit OTP CTA"), "");
                onboardingScreen.selectElement(By.id("btnVerifyOTP"));

            }


            mbkCommonControls.handleMagicPopup();

            Log.info("SELECT", "Hamburger");
            onboardingScreen.selectElement(By.id("icon_drawer"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ASSERT", "Details"), "");

            String actualName = onboardingScreen.findElement(By.id("drawerHeadingName")).getText();
            String actualEmail = onboardingScreen.findElement(By.id("drawerHeadingEmail")).getText();
            String actualMobileNo = onboardingScreen.findElement(By.id("drawerHeadingNumber")).getText();

            onboardingScreen.verifyEqualsExtentReport(actualName, name, "Name | Actual : " + actualName + " | Expected : " + name, true, "Verify Name", directoryName, screenName);
            onboardingScreen.verifyEqualsExtentReport(actualEmail, userName, "Email | Actual : " + actualEmail + " | Expected : " + userName, true, "Verify Email", directoryName, screenName);
            onboardingScreen.verifyEqualsExtentReport(actualMobileNo, mobileNo, "Phone No. | Actual : " + actualMobileNo + " | Expected : " + mobileNo, true, "Verify MobileNo", directoryName, screenName);


            Log.info("CLOSE", "Sidedrawer");
            onboardingScreen.navigateBack();


        } catch (
                Exception e)

        {
            String s = onboardingScreen.screenCaptureExtentReport(directoryName, screenName);
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "STEP " + testStepCount + " | ASSERT       | Details", s, e.getMessage());
            throw e;


        }

    }

    public void quickLogin(String mobileNo, String userName, String name) throws
            InterruptedException, IOException, JSONException {

        int testStepCount = 0;

        try {

            mbkCommonControls.handleCTOverlay();

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SKIP", "Onboarding flow"), "");
            onboardingScreen.selectElement(By.id("skip"));

            mbkCommonControls.handleConscentPopup();

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Login/Signup button"), "");
            onboardingScreen.selectElement(By.id("tx_balance"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Login Details"), "");
            onboardingScreen.selectElement(By.xpath("//android.widget.TextView[@text='EXISTING USER']"));

            onboardingScreen.findElement(By.id("edit_text_mket")).sendKeys(mobileNo);

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Send OTP CTA"), "");
            onboardingScreen.hideKeyboard();
            onboardingScreen.selectElement(By.id("btnLogin"));

            mbkCommonControls.allowPermission(true, "SMS");

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "OTP"), "");
            Thread.sleep(3000);
            apiOtp = apiCommonControls.getOTPfromDB(userName, mobileNo, otpMid, serviceURL, serviceCode);

            onboardingScreen.waitForVisibility(By.id("otp_field"));
            Log.info("OTP", apiOtp.get("otp"));
            onboardingScreen.findElement(By.id("otp_field")).sendKeys(apiOtp.get("otp"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Submit OTP CTA"), "");
            onboardingScreen.selectElement(By.id("continue_btn"));

            mbkCommonControls.handleKycConcent();

            mbkCommonControls.handleMagicPopup();

            mbkCommonControls.handleUpiPopup();


        } catch (Exception e)

        {
            String s = onboardingScreen.screenCaptureExtentReport("directoryName", "screenName");
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "STEP " + testStepCount + " | ASSERT       | Details", s, e.getMessage());
            throw e;

        }


    }
}