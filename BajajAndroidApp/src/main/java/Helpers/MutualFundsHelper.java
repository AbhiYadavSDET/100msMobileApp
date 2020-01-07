package Helpers;

import PageObject.HomePage;
import PageObject.MutualFundPage;
import PageObject.WalletBalancePage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

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
    AndroidDriver driver;
    WalletBalancePage walletBalancePage;


    public MutualFundsHelper(AndroidDriver driver) throws IOException {
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
        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/tv_title"));

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
