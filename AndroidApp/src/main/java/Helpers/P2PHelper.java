package Helpers;


import PageObject.HomePage;
import PageObject.OnboardingPage;
import PageObject.TransferPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;

/**
 * contains all methods to test Add Money Flow
 */
public class P2PHelper {
    AndroidDriver driver;
    OnboardingPage onboardingPage;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    HomePage homePage;
    TransferPage transferPage;
    Helpers.LoginHelper loginHelper;
    Helpers.PermissionHelper permissionHelper;
    Screen screen;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public P2PHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        onboardingPage = new OnboardingPage(driver);
        loginHelper= new Helpers.LoginHelper(driver);
        permissionHelper = new Helpers.PermissionHelper(driver);
        homePage = new HomePage(driver);
        transferPage = new TransferPage(driver);

    }


    public void p2pSufficient(String mobile, String amount, String securityPin, String successPageStatus, String successPageName) throws InterruptedException, IOException,
            JSONException {

        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        balanceBefore = mbkCommonControlsHelper.getBalance();
        transferPage = homePage.clickOnButtonP2P();
        transferPage.clickOnLabelEnterMobileNumber();
        transferPage.enterMobileNumber(mobile);
        transferPage.enterAmount(amount);
        transferPage.clickOnCtaConfirmTransfer();
        mbkCommonControlsHelper.handleSecurityPin(securityPin);
        Thread.sleep(5000);

        // Assertion on the success screen
        String actualSuccessScreenStatus = transferPage.getSuccessPageStatus();
        String actualSuccessScreenName = transferPage.getSuccessPageName();
        String actualSuccessScreenNumber = transferPage.getSuccessPageNumber();

        mbReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, successPageStatus, "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenName, successPageName, "Success Screen | Verify Name", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobile, "Success Screen | Verify Code", false, false);

        Thread.sleep(5000);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        // Assert the wallet balances
        balanceAfter = mbkCommonControlsHelper.getBalance();

        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedSuperCashBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.SUPERCASH)) * 100;
        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuperCashBalanceAfter, expectedSuperCashBalanceAfter, "After TRX | Verify Supercash Balance", false, false);


    }

    public void p2pSufficientLoggedOut(String loginMobileNumber, String otp, String mobile, String amount, String securityPin, String successPageStatus, String successPageName) throws InterruptedException, IOException,
            JSONException {

        Log.info("START", "Start");
        Log.info("----------- Arguments ---------------");
        Log.info("-------------------------------------");

        onboardingPage.clickOnGetStartedCta();

        if (loginHelper.isOnboardingPresent()) {
            Log.info("User is logged out, logging in");
        }

            homePage = onboardingPage.clickOnSkip();

            mbkCommonControlsHelper.handleGetInstantLoanBottomSheet();

            mbkCommonControlsHelper.dismissAllOnHomePage(driver);


        homePage.clickOnAllServicesSection();

            for(int i=0; i<6; i++){

                if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Wallet to Wallet transfer']"))){
                    screen.swipeUpMedium(driver);
                    Log.info("Wallet to Wallet Transfer found");
                    break;

                }else{

                    screen.swipeUpMedium(driver);
                    Log.info("Option not on Screen");

                }

            }

            homePage.clickOnButtonP2P();
            mbkCommonControlsHelper.handleLogin(loginMobileNumber,otp);

        transferPage.clickOnLabelEnterMobileNumber();
        transferPage.enterMobileNumber(mobile);
        transferPage.enterAmount(amount);
        transferPage.clickOnCtaConfirmTransfer();
        mbkCommonControlsHelper.handleSecurityPin(securityPin);
        Thread.sleep(5000);

        // Assertion on the success screen
        String actualSuccessScreenStatus = transferPage.getSuccessPageStatus();
        String actualSuccessScreenName = transferPage.getSuccessPageName();
        String actualSuccessScreenNumber = transferPage.getSuccessPageNumber();

        mbReporter.verifyEqualsWithLogging(actualSuccessScreenStatus, "Your Transfer is Successful", "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobile, "Success Screen | Verify Code", false, false);

        Thread.sleep(5000);

        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();


    }


    public void p2pInSufficient(String mobile, String amount, String securityPin) throws InterruptedException, IOException,
            JSONException {



        homePage.clickOnAllServicesSection();

        for(int i=0; i<6; i++){

            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Wallet to Wallet transfer']"))){
                screen.swipeUpMedium(driver);
                Log.info("Wallet to Wallet Transfer found");
                break;

            }else{

                screen.swipeUpMedium(driver);
                Log.info("Option not on Screen");

            }

        }

        homePage.clickOnButtonP2P();
        transferPage.clickOnLabelEnterMobileNumber();
        transferPage.enterMobileNumber(mobile);
        transferPage.enterAmount(amount);
        transferPage.clickOnCtaConfirmTransfer();
        mbkCommonControlsHelper.handleSecurityPin(securityPin);
        Thread.sleep(5000);

        //AddMoney Page Validation

        String actualAddMoneyPageTitle = transferPage.getAddMoneyPageTitle();

        mbReporter.verifyEqualsWithLogging(actualAddMoneyPageTitle, "Select Payment Mode", "Add Money Screen | Verify Add Money screen Opened", false, false);

        for(int i=0; i<6; i++){
            if(Element.isElementPresent(driver, By.id("navigation_home"))){
                break;
            }else{
                driver.navigate().back();
            }
        }

        mbkCommonControlsHelper.returnToHomePage();



    }




}
