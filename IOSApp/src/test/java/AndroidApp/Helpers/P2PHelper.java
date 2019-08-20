package test.java.AndroidApp.Helpers;


import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;

import io.appium.java_client.ios.IOSDriver;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.TransferPage;

import java.io.IOException;
import java.util.HashMap;

/**
 * contains all methods to test Add Money Flow
 */
public class P2PHelper {

    IOSDriver driver;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    MBReporter mbReporter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    HomePage homePage;
    TransferPage transferPage;
    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public P2PHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        homePage = new HomePage(driver);

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
}