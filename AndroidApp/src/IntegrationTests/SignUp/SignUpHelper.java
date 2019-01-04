package IntegrationTests.SignUp;

import IntegrationTests.Onboarding.OnboardingHelper;
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
import java.util.Map;
import java.util.Random;

/**
 * contains all methods to test Add Money Flow
 */
public class SignUpHelper extends SignUpHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    OnboardingScreen onboardingScreen;
    ApiCommonControls apiCommonControls;
    String otpMid = "MBK5778";
    String serviceURL = "https://wallet.mobikwik.com/getotpandtokendata/";
    String serviceCode = "0";
    HashMap<String, String> apiOtp;
    Map<String, String> walletBalance = new HashMap<>();
    Reporter reporter = new Reporter();


    public SignUpHelper(AndroidDriver driver) throws IOException {
        onboardingScreen = new OnboardingScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();
    }


    public void signUpOnboardMobile(String directoryName, String screenName) throws InterruptedException, IOException
            , JSONException {

        int testStepCount = 0;
        long n = Math.round(Math.random() * 1000000);
        String mobileNo = "8216" + n;
        String userName = mobileNo + "@nocash.mobikwik.com";


        mbkCommonControls.handleCTOverlay();

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Mobile " +
                "Number"), "");
        //onboardingScreen.waitForVisibility(By.id("com.mobikwik_new:id/phone_number"));
        mbkCommonControls.sendText(By.id("com.mobikwik_new:id/phone_number"), mobileNo);
        //onboardingScreen.findElement(By.id("com.mobikwik_new:id/phone_number")).sendKeys(mobileNo);

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Get OTP " +
                "CTA"), "");
        onboardingScreen.selectElement(By.id("send_otp"));

        mbkCommonControls.allowPermission(true, "SMS Permission");


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "OTP"), "");
        Thread.sleep(3000);
        apiOtp = apiCommonControls.getOTPfromDB(userName, mobileNo, otpMid, serviceURL, serviceCode);

        onboardingScreen.waitForVisibility(By.id("otp_field"));
        Log.info("OTP", apiOtp.get("otp"));
        onboardingScreen.verifyEqualsExtentReport(apiOtp.get("otp").length(), 6,
                "OTP Length | Actual : " + apiOtp.get("otp").length() + " | Expected : " + "6", true, "Verify " +
                        "OTP Length", directoryName, screenName);
        mbkCommonControls.sendText(By.id("otp_field"), apiOtp.get("otp"));
        //  onboardingScreen.findElement(By.id("otp_field")).sendKeys(apiOtp.get("otp"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Submit " +
                "OTP CTA"), "");
        onboardingScreen.selectElement(By.id("continue_btn"));

        mbkCommonControls.handleUpiInOnboarding();

        mbkCommonControls.allowPermission(true, "Contact Permission");


        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.id("skip"))) {
            Log.info("SELECT", "Skip button");
            onboardingScreen.selectElement(By.id("skip"));
        }

        mbkCommonControls.handleConscentPopup();


        Log.info("SELECT", "Hamburger");
        onboardingScreen.selectElement(By.id("icon_drawer"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ASSERT",
                "Details"), "");

        // String actualEmail =
        //        onboardingScreen.findElement(By.id("com.mobikwik_new:id/drawerHeadingEmail")).getText();
        //String actualMobileNo =
        //        onboardingScreen.findElement(By.id("com.mobikwik_new:id/drawerHeadingNumber")).getText();
        String actualMobileNo = mbkCommonControls.getText(By.id("com.mobikwik_new:id/drawerHeadingNumber"));


        //onboardingScreen.selectElement(By.xpath("//android.widget.TextView[@text='Update Profile']"));


        // String actualEmail = onboardingScreen.findElement(By.xpath("//android.widget.TextView[contains(text(),
        // 'nocash')]")).getText();


        //onboardingScreen.verifyEqualsExtentReport(actualEmail, userName, "Email | Actual : " + actualEmail +
        //         " | Expected : " + userName, true, "Verify Email", directoryName, screenName);
        onboardingScreen.verifyEqualsExtentReport(actualMobileNo, mobileNo,
                "Phone No. | Actual : " + actualMobileNo + " | Expected : " + mobileNo, true, "Verify " +
                        "MobileNo", directoryName, screenName);


        Log.info("CLOSE", "Sidedrawer");
        onboardingScreen.navigateBack();


    }

    @Override
    public void signUpEmail(String directoryName, String screenName) throws InterruptedException, IOException,
            JSONException {

        int testStepCount = 0;
        long n = Math.round(Math.random() * 1000000);
        String mobileNo = "8216" + n;
        String userName = mobileNo + "@nocash.mobikwik.com";


        mbkCommonControls.handleCTOverlay();

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SKIP", "Onboarding flow"),
                "");
        onboardingScreen.selectElement(By.id("skip"));

        mbkCommonControls.handleConscentPopup();

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Login/Signup " +
                "button"), "");
        onboardingScreen.selectElement(By.id("tx_balance"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "SignUp Details"),
                "");
        onboardingScreen.selectElement(By.xpath("//android.widget.TextView[@text='NEW USER']"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Email " +
                "Id"), "");

//        onboardingScreen.findElement(By.id("edit_text_mket")).sendKeys(userName);
        mbkCommonControls.sendText(By.id("edit_text_mket"), userName);
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Mobile " +
                "Number"), "");

//        onboardingScreen.findElement(By.xpath("//android.widget.TextView[@text='Mobile']//following::android.widget" +
//                ".EditText")).sendKeys(mobileNo);
        mbkCommonControls.sendText(By.xpath("//android.widget.TextView[@text='Mobile']//following::android.widget" +
                ".EditText"), mobileNo);

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Verify & " +
                "Sign Up CTA"), "");

        onboardingScreen.hideKeyboard();
        onboardingScreen.selectElement(By.id("btnVerfiySignUp"));


        mbkCommonControls.allowPermission(true, "SMS Permission");


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "OTP"), "");
        Thread.sleep(4000);
        apiOtp = apiCommonControls.getOTPfromDB(userName, mobileNo, otpMid, serviceURL, serviceCode);

        onboardingScreen.waitForVisibility(By.xpath("//android.widget.TextView[@text='Enter OTP']"));
        Log.info("OTP", apiOtp.get("otp"));
        onboardingScreen.verifyEqualsExtentReport(apiOtp.get("otp").length(), 4,
                "OTP Length | Actual : " + apiOtp.get("otp").length() + " | Expected : " + "4", true, "Verify " +
                        "OTP Length", directoryName, screenName);
        //onboardingScreen.findElement(By.id("edit_text_mket")).sendKeys(apiOtp.get("otp"));
        mbkCommonControls.sendText(By.id("edit_text_mket"), apiOtp.get("otp"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Verify " +
                "CTA"), "");
        onboardingScreen.selectElement(By.id("btnVerifyOTP"));

        mbkCommonControls.allowPermission(true, "Contact Permission");
/*

        Thread.sleep(3000);
        if (onboardingScreen.isElementPresent(By.id("skip"))) {
            Log.info("SELECT", "Skip button");
            onboardingScreen.selectElement(By.id("skip"));
        }*/

        //       mbkCommonControls.handleConscentPopup();


        Log.info("SELECT", "Hamburger");
        onboardingScreen.selectElement(By.id("icon_drawer"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ASSERT",
                "Details"), "");

        // String actualEmail =
        //        onboardingScreen.findElement(By.id("com.mobikwik_new:id/drawerHeadingEmail")).getText();
        String actualMobileNo = mbkCommonControls.getText(By.id("com.mobikwik_new:id/drawerHeadingNumber"));


/*
        onboardingScreen.selectElement(By.xpath("//android.widget.TextView[@text='Update Profile']"));


        String actualEmail = onboardingScreen.findElement(By.id("edit_text_mket")).getText();

        onboardingScreen.navigateBack();
*/

        //onboardingScreen.verifyEqualsExtentReport(actualEmail, userName, "Email | Actual : " + actualEmail +
        //         " | Expected : " + userName, true, "Verify Email", directoryName, screenName);


        onboardingScreen.verifyEqualsExtentReport(actualMobileNo, mobileNo,
                "Phone No. | Actual : " + actualMobileNo + " | Expected : " + mobileNo, true, "Verify " +
                        "MobileNo", directoryName, screenName);


        Log.info("CLOSE", "Sidedrawer");
        onboardingScreen.navigateBack();


    }
}