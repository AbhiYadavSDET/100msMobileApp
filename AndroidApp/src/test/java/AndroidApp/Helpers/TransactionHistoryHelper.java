package test.java.AndroidApp.Helpers;

import IntegrationTests.Screens.AddmoneyScreen;
import IntegrationTests.Screens.P2MScreen;
import IntegrationTests.TransactionHistory.TransactionHistoryHelperBase;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.TransactionHistoryPage;

import java.io.IOException;

public class TransactionHistoryHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    TransactionHistoryPage transactionHistoryPage;
    HomePage homePage;
    MBReporter mbReporter;

    public TransactionHistoryHelper(AndroidDriver driver) throws IOException {
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");

    }


    public void transactionHistoryVerificationLoggedIn() throws InterruptedException, IOException, JSONException {

        int ssCount = 0;

        Log.info("Handle     | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);
        Thread.sleep(3000);

        Log.info("SELECT     | Select Transaction History Tab");
        transactionHistoryPage = homePage.clickHistory();
        Thread.sleep(3000);

        int txnCount = transactionHistoryPage.getListSize();
        Log.info("VERIFY     | Transaction list count must be non-zero  " + txnCount);

        mbReporter.verifyTrue(txnCount > 0, "List must be non-empty", false, false);
    }

    public void transactionHistoryVerificationLoggedOut() throws InterruptedException, IOException, JSONException {

        int ssCount = 0;

        Log.info("Handle     | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);
        Thread.sleep(3000);

        Log.info("SKIP       | Click on 'Skip' on onboarding screen");
        homePage.clickOnSkip();

        Log.info("SELECT     | Select Transaction History Tab");
        transactionHistoryPage = homePage.clickHistory();
        Thread.sleep(3000);

        String text =  transactionHistoryPage.getCTAText();

        Log.info("VERIFY     | User is logged-out");
        mbReporter.verifyEquals(text, "Verify & Sign Up", "Description | Actual : " + text + " | " + "Expected : " + "Verify & Sign Up", false, false);

    }
}