package test.java.AndroidApp.Helpers;

import IntegrationTests.Screens.P2MScreen;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;

public class MutualFundsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    P2MScreen p2MScreen;


    public MutualFundsHelper(AndroidDriver driver) throws IOException {
        p2MScreen = new P2MScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);

    }

    public void mutualFundsVerification() throws InterruptedException, IOException, JSONException {
        int ssCount = 0;

        Log.info("Handle     | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);
        Thread.sleep(3000);

        Log.info("SELECT     | Click on Mutual Funds");

        // Swipe the homescreen up
        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(400,200)).release().perform();

        p2MScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Mutual Funds']"));
        boolean isVisible = p2MScreen.waitForVisibility(By.id("com.mobikwik_new:id/viewAllFunds"));

        // Verify by putting assertion
        p2MScreen.verifyTrue(isVisible, "Actual : " + isVisible + " | Expected : true", false, false);

    }

    }
