package test.java.AndroidApp.Helpers;

import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.NearByHelperBase;
import test.java.AndroidApp.PageObject.NearByScreen;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class NearByHelper extends NearByHelperBase {
    TouchAction touchAction;
    ApiCommonControls apiCommonControls;
    Reporter reporter = new Reporter();
    NearByScreen nearByScreen;
    HomePage homePage;
    Screen screen;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;

    public NearByHelper(AndroidDriver driver) throws IOException {
        this.driver= driver;
        touchAction = new TouchAction(driver);
        apiCommonControls = new ApiCommonControls();
        nearByScreen = new NearByScreen(driver);
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }

    @Override
    public void nearbyStoreListMap(String directoryName, String screenName)
            throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        int noOfstores = 0;
//        homePage.clickOnCrossButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();
        homePage.clickMoreServicesIcon();

        // go to services
        //Log.info("SELECT", "Services Tab");
        //nearByScreen.selectElement(nearByScreen.services);

        // click on near by icon
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on nearby icon"), "");
        nearByScreen.selectElement(nearByScreen.nearbyIcon);

        permissionHelper.permissionAllow();

        // If the device location is not given
        Thread.sleep(3000);
//        if (nearByScreen.isElementPresent(By.id("button1"))) {
//            nearByScreen.selectElement(By.id("button1"));
//        }

        // wait for fetching of stores
        nearByScreen.waitForVisibility(nearByScreen.storesByAdd);
        List<AndroidElement> stores = nearByScreen.findElements(By.id("com.mobikwik_new:id/tv_name"));
        noOfstores = stores.size();

        // log number of stores
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("Verify", "Number of stores fetched:" + noOfstores), "");

        // Assert no of stores
        nearByScreen.verifyTrueExtentReport(noOfstores > 0, "Actual : " + noOfstores + " | Expected : > 1", true, "Verify noOfstores", directoryName, screenName);

        // take screenshot of success page
        nearByScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "NearBy success screen"), directoryName, screenName);


    }

    @Override
    public void nearbySearchCategory(String categoryName, String directoryName, String screenName)
            throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        int noOfstores = 0;

//        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();
        homePage.clickMoreServicesIcon();

        // click on near by icon
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on nearby icon"), "");
        nearByScreen.selectElement(nearByScreen.nearbyIcon);

        permissionHelper.permissionAllow();

        // If the device location is not given
        Thread.sleep(3000);
       /* if (nearByScreen.isElementPresent(By.id("button1"))) {
            nearByScreen.selectElement(By.id("button1"));
        }*/

        // wait for fetching of stores
        //nearByScreen.waitForVisibility(nearByScreen.storesByAdd);

        // select category
        nearByScreen.selectElement(nearByScreen.searchIcon);
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Searching for stores under category"), "");

        // wait for list of stores
        nearByScreen.waitForVisibility(nearByScreen.storesByAdd1);

        List<AndroidElement> stores = nearByScreen.findElements(By.id("com.mobikwik_new:id/tv_name"));
        noOfstores = stores.size();

        // log number of stores
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("Verify", "Number of stores fetched:" + noOfstores), "");

        // Assert no of stores
        nearByScreen.verifyTrueExtentReport(noOfstores > 0, "Actual : " + noOfstores + " | Expected : > 1", true, "Verify noOfstores", directoryName, screenName);


    }

    @Override
    public void nearbySearchStore(String storeName, String directoryName, String screenName)
            throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        int noOfstores = 0;

        // go to services
//        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();
        homePage.clickMoreServicesIcon();

        // click on near by icon
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on nearby icon"), "");
        nearByScreen.selectElement(nearByScreen.nearbyIcon);

        permissionHelper.permissionAllow();
        // If the device location is not given
        Thread.sleep(3000);
        if (nearByScreen.isElementPresent(By.id("button1"))) {
            nearByScreen.selectElement(By.id("button1"));
        }

        // wait for fetching of stores
        //nearByScreen.waitForVisibility(nearByScreen.storesByAdd);
        screen.swipeUp();
        Thread.sleep(3000);
        nearByScreen.selectElement(nearByScreen.searchIcon);
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on search icon"), "");

        // searching for store with keyword "food"
        nearByScreen.sendText(nearByScreen.searchBar, storeName);
        nearByScreen.selectElement(nearByScreen.searchIcon2);
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Searching for store"), "");

        // wait for list of stores
        nearByScreen.waitForVisibility(nearByScreen.storesByAdd1);

        List<AndroidElement> stores = nearByScreen.findElements(By.id("com.mobikwik_new:id/tv_name"));
        noOfstores = stores.size();

        // log number of stores
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("Verify", "Number of stores fetched:" + noOfstores), "");

        // Assert no of stores
        nearByScreen.verifyTrueExtentReport(noOfstores > 0, "Actual : " + noOfstores + " | Expected : > 1", true, "Verify noOfstores", directoryName, screenName);

    }


}
