package test.java.AndroidApp.Helpers;

import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;

import io.appium.java_client.ios.IOSDriver;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.MutualFundPage;
import test.java.AndroidApp.PageObject.WalletBalancePage;

import java.io.IOException;
import java.util.HashMap;

public class MutualFundsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    MutualFundPage mutualFundPage;
    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    IOSDriver driver;
    WalletBalancePage walletBalancePage;


    public MutualFundsHelper(IOSDriver driver) throws IOException {
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        screen = new Screen(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        this.driver = driver;
    }

    public void mutualFundsVerification() throws InterruptedException, IOException, JSONException {
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        // Swipe the homescreen up
        Thread.sleep(2000);
        screen.swipeUpMedium(driver);

        mutualFundPage = homePage.clickMutualFunds();
        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/mkab_title"));

        boolean isVisible = false;
        // Check for the 1st element
        if (mutualFundPage.isViewAllFunds()) {
            isVisible = true;
        }
        // Check for the 2nd element
        if (mutualFundPage.isVisibleGrowthImage()) {
            isVisible = true;
        }

        // Verify by putting assertion
        mbReporter.verifyEqualsWithLogging(isVisible, true, "Verify if the Element is present", false, false);

    }

}
