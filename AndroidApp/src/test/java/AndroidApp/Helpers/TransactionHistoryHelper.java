package test.java.AndroidApp.Helpers;

import IntegrationTests.Screens.AddmoneyScreen;
import IntegrationTests.Screens.P2MScreen;
import IntegrationTests.TransactionHistory.TransactionHistoryHelperBase;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;

public class TransactionHistoryHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    P2MScreen p2MScreen;


    public TransactionHistoryHelper(AndroidDriver driver) throws IOException {
        p2MScreen = new P2MScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);

    }


    public void transactionHistoryVerificationLoggedIn() throws InterruptedException, IOException, JSONException {

        int ssCount = 0;

        Log.info("Handle     | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);
        Thread.sleep(3000);

        Log.info("SELECT     | Select Transaction History Tab");
        p2MScreen.selectElement(By.id("com.mobikwik_new:id/navigation_history"));
        Thread.sleep(3000);

        int txnCount = p2MScreen.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout")).size();
        Log.info("VERIFY     | Transaction list count must be non-zero  " + txnCount);

        p2MScreen.verifyTrue(txnCount > 0, "List must be non-empty", false, false);
    }

    public void transactionHistoryVerificationLoggedOut() throws InterruptedException, IOException, JSONException {

        int ssCount = 0;

        Log.info("Handle     | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);
        Thread.sleep(3000);

        Log.info("SKIP       | Click on 'Skip' on onboarding screen");
        p2MScreen.findElement(By.id("com.mobikwik_new:id/skip")).click();

        Log.info("SELECT     | Select Transaction History Tab");
        p2MScreen.selectElement(By.id("com.mobikwik_new:id/navigation_history"));
        Thread.sleep(3000);

        String text = p2MScreen.findElement(By.id("com.mobikwik_new:id/btnVerfiySignUp")).getText();

        Log.info("VERIFY     | User is logged-out");
        p2MScreen.verifyEquals(text, "Verify & Sign Up", "Description | Actual : " + text + " | " + "Expected : " + "Verify & Sign Up", false, false);

    }
}