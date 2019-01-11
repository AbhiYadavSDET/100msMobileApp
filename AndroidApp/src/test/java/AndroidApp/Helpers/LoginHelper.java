package test.java.AndroidApp.Helpers;

import UITestFramework.Api.ApiCommonControls;
import UITestFramework.MBKCommonControls;
import UITestFramework.MBReporter;
import UITestFramework.MobiKwikScreen;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Config;
import main.java.utils.Element;
import main.java.utils.TestDataReader;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.LoginPage;
import test.java.AndroidApp.PageObject.OnboardingPage;
import test.java.AndroidApp.PageObject.SideDrawerPage;

import java.io.IOException;
import java.util.HashMap;

public class LoginHelper {

    AndroidDriver driver;
    OnboardingPage onboardingPage;
    LoginPage loginPage;
    PermissionHelper permissionHelper;
    ApiCommonControls apiCommonControls;
    public static HashMap<String, String> map;
    String otpMid = "MBK5778";
    String serviceURL = "https://wallet.mobikwik.com/getotpandtokendata/";
    String serviceCode = "0";
    HashMap<String, String> apiOtp;
    MBKCommonControls mbkCommonControls;
    HomePage homePage;
    SideDrawerPage sideDrawerPage;
    MBReporter mbReporter;
    MobiKwikScreen mobiKwikScreen;


    public LoginHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();
        mbkCommonControls = new MBKCommonControls(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mobiKwikScreen = new MobiKwikScreen(driver);

        // Starting page declaration
        onboardingPage = new OnboardingPage(driver);


    }

    public void doLoginFromOboarding(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        onboardingPage.enterMobileNo(map.get("mobile"));

        onboardingPage.clickOnGetOtpCta();

        permissionHelper.permissionAllow();

        Thread.sleep(3000);
        apiOtp = apiCommonControls.getOTPfromDB(map.get("email"), map.get("mobile"), otpMid, serviceURL, serviceCode);
        loginPage.enterOtp(apiOtp.get("otp"));

        loginPage.clickOnGetOtpCta();

        handleUpiScreenInOnboarding();

        mbkCommonControls.handleConscentPopup();

        sideDrawerPage = homePage.clickHamburgerIcon();

        String actualName = sideDrawerPage.getName();
        String actualEmail = sideDrawerPage.getEmail();
        String actualMobileNo = sideDrawerPage.getMobileNo();

        mbReporter.verifyEqualsWithLogging(actualName, map.get("name"), "Verify Name", false, false);
        mbReporter.verifyEqualsWithLogging(actualEmail, map.get("email"), "Verify Email", false, false);
        mbReporter.verifyEqualsWithLogging(actualMobileNo, map.get("mobile"), "Verify Mobile", false, false);

    }

    public void doLoginViaMobileNo(int rownum) {
        // Fetch data from sheet
        Log.info("Fetchin Data From Sheet");
        fetchDataFromSheet(rownum);


    }

    public void doLoginViaEmail(int rownum) throws InterruptedException, IOException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        homePage = onboardingPage.clickOnSkip();

        mbkCommonControls.handleConscentPopup();

        loginPage = homePage.clickLoginSignupButton();

        loginPage.clickOnExistingUser();

        // Enter Email
        loginPage.enterEmail(map.get("email"));

        // Enter Password
        loginPage.enterPassword(map.get("password"));

        loginPage.clickOnLoginCta();

        new PermissionHelper(driver).permissionAllow();

        mbkCommonControls.handleMagicPopup();

        sideDrawerPage = homePage.clickHamburgerIcon();

        String actualName = sideDrawerPage.getName();
        String actualEmail = sideDrawerPage.getEmail();
        String actualMobileNo = sideDrawerPage.getMobileNo();

        mbReporter.verifyEqualsWithLogging(actualName, map.get("name"), "Verify Name", false, false);
        mbReporter.verifyEqualsWithLogging(actualEmail, map.get("email"), "Verify Email", false, false);
        mbReporter.verifyEqualsWithLogging(actualMobileNo, map.get("mobile"), "Verify Mobile", false, false);


    }

    public void fetchDataFromSheet(int rownum) {
        map = new HashMap<String, String>();
        TestDataReader testData = Config.getCachedTestDataReaderObject("loginData");
        map.put("mobile", testData.GetData(rownum, "mobile"));
        map.put("email", testData.GetData(rownum, "email"));
        map.put("name", testData.GetData(rownum, "name"));
        map.put("loginUsing", testData.GetData(rownum, "loginUsing"));
        map.put("password", testData.GetData(rownum, "password"));
        map.put("isKycUser", testData.GetData(rownum, "isKycUser"));

    }

    public void handleUpiScreenInOnboarding() throws InterruptedException {
        Thread.sleep(3000);

        if (Element.isElementPresent(driver, By.id("upi_icon"))) {
            Log.info("Handle", "UPI Popup in Onboarding");
            driver.navigate().back();
        }
    }

   /* public void verifyLoggedInUser() {
        dashboardHelper.verifyUser(map.get("email"), map.get("mobile"));
    }*/


}
