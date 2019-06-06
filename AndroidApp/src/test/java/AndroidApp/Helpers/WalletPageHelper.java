package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import net.sourceforge.tess4j.TesseractException;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.WalletPage;
import test.java.AndroidApp.PageObject.HomePage;
import java.io.IOException;
import java.util.HashMap;

public class WalletPageHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    WalletPage walletPage;
    PermissionHelper permissionHelper;


    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;

    public WalletPageHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }

    public void checkIfNoKycUser() throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        Element.waitForVisibility(driver, homePage.icon_mobile);

        walletPage= homePage.clickWalletNavigate();

        Thread.sleep(3000);

        Boolean status1 = walletPage.ifKycCardDisplayed();

        Boolean status2 = walletPage.ifUpgradeButtonDisplayed();

        if (status1 == true && status2 == true) {

            Log.info("KYC Card Displayed");

        } else {

            Log.info("KYC Card not Displayed");


        }


    }
}