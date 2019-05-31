package test.java.AndroidApp.Helpers;

import IntegrationTests.Screens.OfferScreen;
import IntegrationTests.Screens.OnboardingScreen;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.OfferPage;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * contains all methods to test Add Money Flow
 */
public class OfferHelper{
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    OnboardingScreen onboardingScreen;
    ApiCommonControls apiCommonControls;
    Reporter reporter = new Reporter();
    OfferScreen offerScreen;
    HomePage homePage;
    OfferPage offerPage;
    MBReporter mbReporter;

    public OfferHelper(AndroidDriver driver) throws IOException {
        offerScreen = new OfferScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");


    }


    public void offerSearch(String offerName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerPage = homePage.clickOffers();

        // Step 2 | Select the search option
        offerPage.clickOnSearchOption();

        // Step 3 | Enter the offer name
        offerPage.sendOfferName(offerName);
        Thread.sleep(3000);

        // Step 4 | Verify the number of results
        int noOfOffers = offerPage.noOfOffers();
        mbReporter.verifyTrueWithLogging(noOfOffers > 0, "Actual : " + noOfOffers + " | Expected : > 1", false, false);

    }

    public void offerCategoryCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        int noOfCategories = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerPage = homePage.clickOffers();

        // Step 2 | Select the Category option
        offerPage.selectCategoryOption();

        // Step 3 | Fetch all the categories that are getting displayed
        if (offerPage.isCloseButtonVisible()){
            noOfCategories = offerPage.fetchCategoryList();
        }

        // Step 4 | Apply the assertions
        mbReporter.verifyTrueWithLogging(noOfCategories > 0, "Actual : " + noOfCategories + " | Expected > 0", false, false);

    }

    public void redeemOffersCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException{
        int testStepCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

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