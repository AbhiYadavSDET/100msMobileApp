package test.java.AndroidApp.Helpers;

import IntegrationTests.Screens.OfferScreen;
import IntegrationTests.Screens.OnboardingScreen;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

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
    Set<IOSElement> setCategory = new HashSet<>();


    public OfferHelper(AndroidDriver driver) throws IOException {
        offerScreen = new OfferScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();


    }


    public void offerSearch(String offerName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Offers']"));

        // Step 2 | Select the search option
        offerScreen.selectElement(By.id("btn_search"));

        // Step 3 | Enter the offer name
        offerScreen.waitForVisibility(By.id("offerSearchView"));
        offerScreen.findElement(By.id("offerSearchView")).sendKeys(offerName);
        Thread.sleep(3000);
        offerScreen.navigateBack();

        // Step 4 | Verify the number of results
        int noOfOffers = offerScreen.findElements(By.xpath("//android.widget.LinearLayout/android.view.ViewGroup")).size();

        offerScreen.verifyTrue(noOfOffers > 0, "Actual : " + noOfOffers + " | Expected : > 1", false, false);

    }

    public void offerCategoryCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Offers']"));

        // Step 2 : Select the Category option
        offerScreen.selectElement(By.id("btn_categories"));

        // Step 3 | Fetch all the categories that are getting displayed
        offerScreen.waitForVisibility(By.id("close_button"));
        List<AndroidElement> listCategory = offerScreen.findElements(By.id("text"));
        int noOfCategories = listCategory.size();

        // Step 4 | Apply the assertions
        offerScreen.verifyTrue(noOfCategories > 0, "Actual : " + noOfCategories + " | Expected > 0", false, false);

    }

    public void redeemOffersCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException{
        int testStepCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Offers']"));

        // Step 2 | Go to redeem offer tab
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Redeem SuperCash']"));

        // Step 3 | Fetch the list of offers
        List<AndroidElement> list = offerScreen.findElements(By.id("com.mobikwik_new:id/click_view"));
        int listSize = list.size();

        // Step 3 | Apply the assertions
        offerScreen.verifyTrue(listSize > 0, "Actual : " + listSize + " | Expected > 0", false, false);


    }
}