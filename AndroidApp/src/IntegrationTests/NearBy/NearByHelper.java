package IntegrationTests.NearBy;

import java.io.IOException;

import IntegrationTests.Screens.NearByScreen;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;

import IntegrationTests.Screens.OfferScreen;
import IntegrationTests.Screens.OnboardingScreen;
import UITestFramework.MBKPermissions;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;

import java.util.List;

public class NearByHelper extends NearByHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    OnboardingScreen onboardingScreen;
    ApiCommonControls apiCommonControls;
    Reporter reporter = new Reporter();
    NearByScreen nearByScreen;

    public NearByHelper(AndroidDriver driver) throws IOException {
        //offerScreen = new OfferScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();
        nearByScreen = new NearByScreen(driver);
    }

    @Override
    public void nearbyStoreListMap(String directoryName, String screenName)
            throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        int noOfstores = 0;

        // go to services
        Log.info("SELECT", "Services Tab");
        nearByScreen.selectElement(nearByScreen.services);

        // click on near by icon
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on nearby icon"), "");
        nearByScreen.selectElement(nearByScreen.nearbyIcon);

        mbkCommonControls.allowPermission(true, "Location");

        // If the device location is not given
        Thread.sleep(3000);
        if (nearByScreen.isElementPresent(By.id("button1"))) {
            nearByScreen.selectElement(By.id("button1"));
        }

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

        // go to services
        Log.info("SELECT", "Services Tab");
        nearByScreen.selectElement(nearByScreen.services);

        // click on near by icon
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on nearby icon"), "");
        nearByScreen.selectElement(nearByScreen.nearbyIcon);

        mbkCommonControls.allowPermission(true, "Location");

        // If the device location is not given
        Thread.sleep(3000);
        if (nearByScreen.isElementPresent(By.id("button1"))) {
            nearByScreen.selectElement(By.id("button1"));
        }

        // wait for fetching of stores
        nearByScreen.waitForVisibility(nearByScreen.storesByAdd);

        // select category
        nearByScreen.selectElement(By.xpath("//android.widget.TextView[@text = '" + categoryName + "']"));
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
        Log.info("SELECT", "Services Tab");
        nearByScreen.selectElement(nearByScreen.services);

        // click on near by icon
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Click on nearby icon"), "");
        nearByScreen.selectElement(nearByScreen.nearbyIcon);

        mbkCommonControls.allowPermission(true, "Location");

        // If the device location is not given
        Thread.sleep(3000);
        if (nearByScreen.isElementPresent(By.id("button1"))) {
            nearByScreen.selectElement(By.id("button1"));
        }

        // wait for fetching of stores
        nearByScreen.waitForVisibility(nearByScreen.storesByAdd);

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
