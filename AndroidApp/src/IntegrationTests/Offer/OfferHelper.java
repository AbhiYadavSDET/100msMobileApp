package IntegrationTests.Offer;

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

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * contains all methods to test Add Money Flow
 */
public class OfferHelper extends OfferHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    OnboardingScreen onboardingScreen;
    ApiCommonControls apiCommonControls;
    MBReporter mbReporter;
    OfferScreen offerScreen;
    Set<IOSElement> setCategory = new HashSet<>();
    HomePage homePage;


    public OfferHelper(AndroidDriver driver) throws IOException {
        offerScreen = new OfferScreen(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        homePage=new HomePage(driver);
    }


    @Override
    public void offerSearch(String offerName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;

        homePage.clickOnCrossButton();
        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Offers']"));

        // Step 2 : Select the search option
        offerScreen.selectElement(By.id("btn_search"));

        // Step 3 : Enter the offer name
        offerScreen.waitForVisibility(By.id("offerSearchView"));
        offerScreen.findElement(By.id("offerSearchView")).sendKeys(offerName);
        Thread.sleep(3000);
        offerScreen.navigateBack();


        // Step 4 : Verify the number of results
        int noOfOffers = offerScreen.findElements(By.xpath("//android.widget.LinearLayout/android.view.ViewGroup")).size();

        mbReporter.verifyTrueWithLogging(noOfOffers > 0, "Actual : " + noOfOffers + " | Expected : > 1", true, false);

        // Step 5 : Reach back the Home-screen
        offerScreen.selectElement(By.xpath("//*[@text='w']"));
    }

    @Override
    public void offerCategoryCheck(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        homePage.clickOnCrossButton();
        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen(directoryName, screenName, testStepCount);

        // Step 1 | Goto Offers page
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Offers']"));

        // Step 2 : Select the Category option
        offerScreen.selectElement(By.id("btn_categories"));

        // Step 3 : Fetch all the categories that are getting displayed
        offerScreen.waitForVisibility(By.id("close_button"));
        List<AndroidElement> listCategory = offerScreen.findElements(By.id("text"));
        int noOfCategories = listCategory.size();
        /*for (IOSElement e : listCategory) {
            Log.info(e.getText());
        }*/
        // Step 4 : Apply the assertions
        mbReporter.verifyTrueWithLogging(noOfCategories > 0, "Actual : " + noOfCategories + " | Expected : 9", true, false);

        // Step 5 : Reach back to the Home-screen
        offerScreen.selectElement(By.id("close_button"));
        offerScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Home']"));


    }
}