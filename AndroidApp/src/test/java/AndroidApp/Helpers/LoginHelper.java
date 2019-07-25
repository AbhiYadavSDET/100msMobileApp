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
import test.java.AndroidApp.PageObject.SideDrawerPage;

import java.io.IOException;
import java.util.HashMap;

public class LoginHelper {

    AndroidDriver driver;
    OnboardingPage onboardingPage;
    LoginPage loginPage;
    ApiCommonControls apiCommonControls;
    public static HashMap<String, String> map;
    String otpMid = "MBK5778";
    String serviceURL = "https://wallet.mobikwik.com/getotpandtokendata/";
    String serviceCode = "0";
    HashMap<String, String> apiOtp;
    HomePage homePage;
    SideDrawerPage sideDrawerPage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    Screen screen;


    public LoginHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();
        mbReporter = new MBReporter(driver, "testScreenshotDir");

        // Starting page declaration
        onboardingPage = new OnboardingPage(driver);
        permissionHelper = new PermissionHelper(driver);
        screen = new Screen(driver);


    }

    public void doLoginFromOboarding(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        Screen.hideKeyboard(driver);

        onboardingPage.enterMobileNo(map.get("mobile"));

        onboardingPage.clickOnGetOtpCta();

        new PermissionHelper(driver).permissionAllow();

        Thread.sleep(3000);
        apiOtp = apiCommonControls.getOTPfromDB(map.get("email"), map.get("mobile"), otpMid, serviceURL, serviceCode);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterOtp(apiOtp.get("otp"));
        loginPage.clickOnGetOtpCta();

        handleUpiScreenInOnboarding();

//        mbkCommonControls.handleConscentPopup();

        sideDrawerPage = new HomePage(driver).clickHamburgerIcon();

        String actualName = sideDrawerPage.getName();
        String actualEmail = sideDrawerPage.getEmail();
        String actualMobileNo = sideDrawerPage.getMobileNo();

        mbReporter.verifyEqualsWithLogging(actualName, map.get("name"), "Verify Name", false, false);
        mbReporter.verifyEqualsWithLogging(actualEmail, map.get("email"), "Verify Email", false, false);
        mbReporter.verifyEqualsWithLogging(actualMobileNo, map.get("mobile"), "Verify Mobile", false, false);

        homePage.clickHomePageMbkLogo();


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

        Screen.hideKeyboard(driver);

        homePage = onboardingPage.clickOnSkip();

//        mbkCommonControls.handleConscentPopup();
        permissionHelper.permissionAllow();

        loginPage = homePage.clickLoginSignupButton();

        loginPage.clickOnExistingUser();

        // Enter Email
        loginPage.enterEmail(map.get("email"));

        // Enter Password
        loginPage.enterPassword(map.get("password"));

        loginPage.clickOnLoginCta();

        permissionHelper.permissionAllow();

//        mbkCommonControls.handleMagicPopup();

        sideDrawerPage = homePage.clickHamburgerIcon();

        String actualName = sideDrawerPage.getName();
        String actualEmail = sideDrawerPage.getEmail();
        String actualMobileNo = sideDrawerPage.getMobileNo();

        mbReporter.verifyEqualsWithLogging(actualName, map.get("name"), "Verify Name", false, false);
        mbReporter.verifyEqualsWithLogging(actualEmail, map.get("email"), "Verify Email", false, false);
        mbReporter.verifyEqualsWithLogging(actualMobileNo, map.get("mobile"), "Verify Mobile", false, false);

        homePage.clickHomePageMbkLogo();


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
        map.put("securityPin", testData.GetData(rownum, "securityPin"));


    }

    public void handleUpiScreenInOnboarding() throws InterruptedException {
        Thread.sleep(3000);

        if (Element.isElementPresent(driver, By.id("upi_icon"))) {
            Log.info("Handle", "Sanity Popup in Onboarding");
            driver.navigate().back();
        }
    }


    public void quickLoginViaEmail(String email, String password) throws InterruptedException, IOException {

        if (isOnboardingPresent()) {
            Log.info("User is logged out, logging in");

            Screen.hideKeyboard(driver);
            permissionHelper.dismissHintPopup();
            Screen.hideKeyboard(driver);

            homePage = onboardingPage.clickOnSkip();

            permissionHelper.permissionAllow();

            loginPage = homePage.clickLoginSignupButton();

            loginPage.clickOnExistingUser();

            // Enter Email
            loginPage.enterEmail(email);

            // Enter Password
            loginPage.enterPassword(password);

            loginPage.clickOnLoginCta();
        } else {
            Log.info("User is logged in, no need to login");
            permissionHelper.permissionAllow();
        }

    }

    public void logout() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCrossButton();


        homePage.clickOnBottomBarWallet();

        //Swipe to the botton of the screen
        Thread.sleep(2000);
        screen.swipeUpMore(driver);
        screen.swipeUpMore(driver);
        Thread.sleep(2000);


        homePage.clickOnlogout();

        // Apply the assertions


    }

    public boolean isOnboardingPresent() throws InterruptedException {
        Thread.sleep(3000);
        if (Element.isElementPresent(driver, By.id("com.mobikwik_new:id/skip"))) {
            return true;
        } else {
            return false;
        }
    }


}
