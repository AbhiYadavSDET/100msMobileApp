package test.java.AndroidApp.Helpers;

import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;

import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.MgmHelperBase;
import test.java.AndroidApp.PageObject.MgmScreen;

import java.io.IOException;

public class MgmHelper extends MgmHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    ApiCommonControls apiCommonControls;
    Reporter reporter = new Reporter();
    MgmScreen mgmScreen;
    HomePage homePage;

    public MgmHelper(IOSDriver driver) throws IOException {

        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        apiCommonControls = new ApiCommonControls();
        mgmScreen = new MgmScreen(driver);
    }

    public void verifyMgm(String directoryName, String screenName)
            throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        boolean found = false;
        homePage.clickOnCrossButton();

        // go to wallet
        Log.info("SELECT       | Wallet Tab");
        mgmScreen.selectElement(mgmScreen.wallet);

        // click on mgm points
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on mgm points"), "");
        mgmScreen.selectElement(mgmScreen.mgmPoints);

        // click on "Add card"
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on mgm add card"), "");
        mgmScreen.selectElement(mgmScreen.mgmAddNewCard);

        // verify MGM screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Mgm title on screen"), "");

        found = mgmScreen.isElementPresent(mgmScreen.mgmTitle);
        // assert MGM screen
        mgmScreen.verifyTrueExtentReport(found, "Verify Mgm screen", true, "mgm screen opened", directoryName, screenName);

    }
}
