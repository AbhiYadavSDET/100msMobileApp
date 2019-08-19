package test.java.AndroidApp.Helpers;

import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.OfferPage;

import java.io.IOException;

/**
 * contains all methods to test Add Money Flow
 */
public class OfferHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    ApiCommonControls apiCommonControls;
    Reporter reporter = new Reporter();
    HomePage homePage;
    OfferPage offerPage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    AndroidDriver driver;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    public OfferHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        apiCommonControls = new ApiCommonControls();
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);

    }


    public void offerSearch(String offerName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        permissionHelper.permissionAllow();
        Thread.sleep(3000);
        homePage.clickOnCrossButton();
        Thread.sleep(1000);
        // Step 1 | Goto Offers page
        offerPage = homePage.clickOffers();

        // Step 2 | Select the search option
        offerPage.clickOnSearchOption();

        // Step 3 | Enter the offer name
        offerPage.sendOfferName(offerName);
        Thread.sleep(3000);

        // Step 4 | Verify the number of results
        int noOfOffers = offerPage.noOfOffers();
        mbReporter.verifyTrueWithLogging(noOfOffers > 0, "Actual : " + noOfOffers + " | Expected : > 0", false, false);

    }

    public void offerCategoryCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int noOfCategories = 0;

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        permissionHelper.permissionAllow();
        Thread.sleep(3000);
        homePage.clickOnCrossButton();
        Thread.sleep(1000);
        // Step 1 | Goto Offers page
        offerPage = homePage.clickOffers();

        // Step 2 | Select the Category option
        offerPage.selectCategoryOption();

        // Step 3 | Fetch all the categories that are getting displayed
        if (offerPage.isCloseButtonVisible()) {
            noOfCategories = offerPage.fetchCategoryList();
        }

        // Step 4 | Apply the assertions
        mbReporter.verifyTrueWithLogging(noOfCategories > 0, "Actual : " + noOfCategories + " | Expected > 0", false, false);

    }

    public void redeemOffersCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        permissionHelper.permissionAllow();
        Thread.sleep(3000);
        homePage.clickOnCrossButton();
        Thread.sleep(1000);
        // Step 1 | Goto Offers page
        offerPage = homePage.clickOffers();

        // Step 2 | Go to redeem offer tab
        offerPage.clickOnRedeemOffer();

        // Step 3 | Fetch the list of offers
        int listSize = offerPage.fetchRedeemOffers();

        // Step 4 | Apply the assertions
        mbReporter.verifyTrueWithLogging(listSize > 0, "Actual : " + listSize + " | Expected > 0", false, false);


    }
}