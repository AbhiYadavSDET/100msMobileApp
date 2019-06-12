package test.java.AndroidApp.Helpers;

import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
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
    PermissionHelper permissionHelper;

    public TransactionHistoryHelper(AndroidDriver driver) throws IOException {
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }


    public void transactionHistoryVerificationLoggedIn() throws InterruptedException, IOException, JSONException {

        mbkCommonControls.handleConscentPopup();
        permissionHelper.permissionAllow();

        transactionHistoryPage = homePage.clickHistory();
        Thread.sleep(3000);

        int txnCount = transactionHistoryPage.getListSize();
        Log.info("VERIFY     | Transaction list count must be non-zero  " + txnCount);

        mbReporter.verifyTrueWithLogging(txnCount > 0, "List must be non-empty", false, false);
    }

    public void transactionHistoryVerificationLoggedOut() throws InterruptedException, IOException, JSONException {

        homePage.clickOnSkip();

        mbkCommonControls.handleConscentPopup();
        permissionHelper.permissionAllow();

        transactionHistoryPage = homePage.clickHistory();
        Thread.sleep(3000);

        String text = transactionHistoryPage.getCTAText();

        mbReporter.verifyEqualsWithLogging(text, "Verify & Sign Up", "Description | Actual : " + text + " | " + "Expected : " + "Verify & Sign Up", false, false);

    }
}