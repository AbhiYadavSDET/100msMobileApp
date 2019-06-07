package test.java.AndroidApp.Helpers;

import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Screen;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.MutualFundPage;

import java.io.IOException;
import java.util.HashMap;

public class MutualFundsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    MutualFundPage mutualFundPage;
    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;

    public MutualFundsHelper(AndroidDriver driver) throws IOException {
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        screen = new Screen(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        this.driver = driver;
    }

    public void mutualFundsVerification() throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Swipe the homescreen up
        Thread.sleep(2000);
        screen.swipeUp();

        mutualFundPage = homePage.clickMutualFunds();

        boolean isVisible = mutualFundPage.isViewAllFunds();

        // Verify by putting assertion
        mbReporter.verifyTrueWithLogging(isVisible, "Actual : " + isVisible + " | Expected : true", false, false);

    }

}
