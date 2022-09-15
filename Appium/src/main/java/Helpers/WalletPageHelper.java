package Helpers;
/*
import PageObject.HomePage;
import PageObject.SideDrawerPage;
import PageObject.WalletPage;
import utils.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import utils.Element;
import utils.Screen;

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
    SideDrawerPage sideDrawerPage;


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
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        Element.waitForVisibility(driver, homePage.icon_mobile);

        sideDrawerPage= homePage.clickHamburgerIcon();
        walletPage = sideDrawerPage.clickOnAccountsPage();


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

 */