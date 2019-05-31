package test.java.AndroidApp.Helpers;

import IntegrationTests.Screens.P2MScreen;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.MutualFundPage;

import java.io.IOException;
import java.time.Duration;

public class MutualFundsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    MutualFundPage mutualFundPage;

    public MutualFundsHelper(AndroidDriver driver) throws IOException {
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        screen = new Screen(driver);
    }

    public void mutualFundsVerification() throws InterruptedException, IOException, JSONException {
        int ssCount = 0;

        Log.info("Handle     | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);
        Thread.sleep(3000);

        // Swipe the homescreen up
        Log.info("SWIPE", "UP");
        screen.swipeUp();

        Log.info("SELECT     | Click on Mutual Funds");
        mutualFundPage = homePage.clickMutualFunds();

        //p2MScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Mutual Funds']"));
        boolean isVisible = mutualFundPage.isViewAllFunds();

        // Verify by putting assertion
        mbReporter.verifyTrue(isVisible, "Actual : " + isVisible + " | Expected : true", false, false);

    }

    }
