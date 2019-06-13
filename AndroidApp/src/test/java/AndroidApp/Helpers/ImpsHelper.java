package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.ImpsPage;
import test.java.AndroidApp.PageObject.P2MPage;

import java.io.IOException;
import java.util.HashMap;

public class ImpsHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    P2MPage p2mPage;
    PermissionHelper permissionHelper;
    ImpsPage impsPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public ImpsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        impsPage = new ImpsPage(driver);

    }


    public void verifyImps() throws InterruptedException, IOException, JSONException {
        //driver.navigate().back();

        impsPage.clickOnViaWallet();

        impsPage.clickOnWalletToBank();

        // Swipe the homescreen up
        Thread.sleep(2000);
        screen.swipeUp();

        impsPage.clickOnBank();

        impsPage.sendAmount();
        Thread.sleep(2000);

        impsPage.clickOnContinue();

        impsPage.clickOnConfirm();

        mbkCommonControlsHelper.handleSecurityPin("123456");
        Thread.sleep(5000);

        boolean flag = Element.isElementPresent(driver, impsPage.returnLocator());
        mbReporter.verifyTrueWithLogging(flag, "verify imps success screen", false, false);

    }


}
