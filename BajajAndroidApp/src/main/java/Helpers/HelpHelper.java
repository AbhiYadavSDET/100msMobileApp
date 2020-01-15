package Helpers;

import PageObject.HelpPage;
import PageObject.HomePage;
import PageObject.SideDrawerPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import utils.Screen;

import java.io.IOException;

public class HelpHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    HelpPage helpPage;
    SideDrawerPage sideDrawerPage;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;


    public HelpHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        helpPage = new HelpPage(driver);
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }

    public void helpVerification() throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        permissionHelper.permissionAllow();

        // Open Help from drawer
        sideDrawerPage = homePage.clickHamburgerIcon();
        helpPage = sideDrawerPage.clickOnHelp();

        helpPage.chooseAddMoney();

        helpPage.clickOnIssue();

        helpPage.clickOnQues();

        helpPage.typeQuery();

        helpPage.clickOnSend();

        boolean isTicket = helpPage.isTicketIDVisible();

//        mbReporter.verifyEqualsWithLogging(isTicket, true, "Description | Actual : " + isTicket + " | " + "Expected : " + "true", false, false);
        mbReporter.verifyEqualsWithLogging(isTicket, true, "Verify If ticket ID is visible", false, false);

    }

}
