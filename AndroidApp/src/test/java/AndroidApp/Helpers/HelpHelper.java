package test.java.AndroidApp.Helpers;

import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Screen;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HelpPage;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.SideDrawerPage;

import java.io.IOException;

public class HelpHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    HomePage homePage;
    Screen screen;
    MBReporter mbReporter;
    HelpPage helpPage;
    SideDrawerPage sideDrawerPage;
    PermissionHelper permissionHelper;


    public HelpHelper (AndroidDriver driver) throws IOException{
        homePage = new HomePage(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        helpPage = new HelpPage(driver);
        permissionHelper = new PermissionHelper(driver);

    }

    public void helpVerification() throws InterruptedException, IOException, JSONException {
        homePage.clickOnCrossButton();

        mbkCommonControls.handleConscentPopup();
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

        mbReporter.verifyEqualsWithLogging(isTicket, "true", "Description | Actual : " + isTicket + " | " + "Expected : " + "true", false, false);

    }

}
