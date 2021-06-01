package Helpers;

import PageObject.*;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Config;
import utils.Element;
import utils.Screen;
import utils.TestDataReader;

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
    WalletPage walletPage;
    MBReporter mbReporter;
    Helpers.PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    Screen screen;


    public LoginHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        // Starting page declaration
        onboardingPage = new OnboardingPage(driver);
        permissionHelper = new Helpers.PermissionHelper(driver);
        screen = new Screen(driver);
        homePage = new HomePage(driver);
        walletPage = new WalletPage(driver);


    }

    public void doLoginFromOboarding(String mobile) throws InterruptedException, IOException, JSONException {

        onboardingPage.clickOnGetStartedCta();
        onboardingPage.enterMobileNo(mobile);

        onboardingPage.clickOnGetOtpCta();

//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Enter your OTP below']"));

        //If OTP not Auto Read enter OTP and press Submit

        Element.waitForVisibility(driver, By.id("com.android.packageinstaller:id/dialog_container"));

        permissionHelper.permissionAllow();

        Thread.sleep(1500);

//       mbReporter.verifyEqualsWithLogging(homePage.getTitleMessageSecondaryEmail(), "Enter a valid Email below", "Secondary Email Screen displayed", true, true);

        homePage.clickOnSkip();

        permissionHelper.permissionAllow();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        sideDrawerPage = new HomePage(driver).clickHamburgerIcon();


        String actualMobileNo = sideDrawerPage.getMobileNo();

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("drawerHeadingName")), "Name Is Present", true, false);
        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("drawerHeadingEmail")), "Email Id Is Present", true, false);
        mbReporter.verifyEqualsWithLogging(actualMobileNo, mobile, "Verify Mobile", false, false);

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

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        if (Element.isElementPresent(driver, By.id("tx_add_money"))) {

            sideDrawerPage= homePage.clickHamburgerIcon();
            walletPage=sideDrawerPage.clickOnAccountsPage();

            //Swipe to the botton of the screen
            Thread.sleep(2000);


            for (int i = 0; i < 3; i++) {

                if (Element.isElementPresent(driver, By.id("btn_logout")) == false) {

                    screen.swipeUpMore(driver);

                } else {
                    break;
                }
            }

            walletPage.clickOnlogout();

            Thread.sleep(1000);

            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Login/Signup']")), "User is Logged out", true, false);

        } else {

            Log.info("User is already logged out");
        }


    }


    /**
     * @param number
     * @param otp
     * @throws InterruptedException
     * @throws IOException
     * @author Paraj Jain@24th March,2021
     */

    public void quickLoginViaNumber(String number, String otp) throws InterruptedException, IOException {
        Log.info("START", "Login");
        Log.info("----------- Arguments ---------------");
        Log.info("Mobile : " + number);
        Log.info("Otp : " + otp);
        Log.info("-------------------------------------");

        onboardingPage.clickOnGetStartedCta();

        if (isOnboardingPresent()) {
            Log.info("User is logged out, logging in");

//            Screen.hideKeyboard(driver);
//            permissionHelper.dismissHintPopup();
//            Screen.hideKeyboard(driver);

            homePage = onboardingPage.clickOnSkip();

//            permissionHelper.permissionAllow();

            loginPage = homePage.clickLoginSignupButton();

            // Enter Number
            loginPage.enterMobileNumber(number);

            loginPage.clickOnSendOtpCta();


            // Enter Password
            loginPage.enterOtp(otp);


            loginPage.clickSubmitOtpCta();


        } else {
            Log.info("User is logged in, no need to login");
            permissionHelper.permissionAllow();
        }

        Log.info("END", "Login");

    }


    public boolean isOnboardingPresent() throws InterruptedException {


        if (Element.isElementPresent(driver, By.id("splash_icon"))) {
            Thread.sleep(6000);
        }

        Thread.sleep(3000);

        if (Element.isElementPresent(driver, By.id("skip"))) {
            return true;
        } else {
            return false;
        }
    }


}
