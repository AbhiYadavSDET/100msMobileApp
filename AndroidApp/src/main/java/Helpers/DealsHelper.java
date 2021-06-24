package Helpers;

import PageObject.DealsPage;
import PageObject.HomePage;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class DealsHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    ApiCommonControls apiCommonControls;
    HomePage homePage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    AndroidDriver driver;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    DealsPage dealsPage;
    Screen screen;
    Element element;

    public DealsHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        apiCommonControls = new ApiCommonControls();
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        screen = new Screen(driver);
        dealsPage=new DealsPage(driver);
        element=new Element(driver);

    }


    public void validateDeals() throws InterruptedException, IOException, JSONException {

        int noOfCategories = 0;
        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        homePage.clickOnAllServicesSection();

        for(int i=0; i<6; i++){

            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Wallet to Wallet transfer']"))){
                screen.swipeUpMedium(driver);
                Log.info("Wallet to Wallet Transfer found");
                break;

            }else{

                screen.swipeUpMedium(driver);
                Log.info("Option not on Screen");

            }

        }

        dealsPage=homePage.clickOnButtonDeals();

        Element.waitForVisibility(driver, By.id("design_bottom_sheet"));

        dealsPage.closeBottomSheet();

        dealsPage.selectCategoryOption();

        if (dealsPage.isCategoryBottomSheetVisible()) {
            noOfCategories = dealsPage.fetchCategoryList();
        }

        mbReporter.verifyTrueWithLogging(noOfCategories > 0, "Actual : " + noOfCategories + " | Expected > 0", false, false);

        driver.navigate().back();


        for (int i=0; i<6;i++ ) {
            if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='JioSaavn']"))) {
                screen.swipeUpMedium(driver);
                Log.info("Offer not found");
            }else {
                break;
            }

        }

        dealsPage.selectJioDeal();

        String actualDescriptionText= dealsPage.getDescriptionText();

        mbReporter.verifyEqualsWithLogging(actualDescriptionText, "JioSaavn is the largest audio streaming service with more than 55 million Bollywood, English, Hindi, & Indian regional songs, top artists, expertly curated playlists & custom radio stations for any mood or genre, even exclusive releases & Original shows.","Verify Description Text" ,false, false);

        String actualVoucherText= dealsPage.getVoucherText();

        mbReporter.verifyEqualsWithLogging(actualVoucherText, "Get voucher of 20% off for 25.0 supercash.","Verify Voucher Text" ,false, false);

        dealsPage.clickOnBuyNow();

        Element.waitForVisibility(driver, By.id("buy_button"));

        mbReporter.verifyTrueWithLogging(getDealDetails(), "Verify Deals Details", false,false);

        dealsPage.closeBottomSheet();

        dealsPage.clickOnBackButton();


        Thread.sleep(1000);
        dealsPage.clickOnBackButton();


        homePage.clickOnCrossButton();

        homePage.navigateToHome();

    }

    public Boolean getDealDetails() throws InterruptedException, IOException {
        LinkedHashMap<String, String> dealDetails = new LinkedHashMap<>();
        Log.info("START", "Fetch Deal Details");

        if(Element.waitForVisibility(driver, By.id("buy_button"))) {
            int noOfDetails = Element.findElements(driver, By.id("row_element_left")).size();
            Log.info("No Of Details - " + noOfDetails);

            // Fetch Details
            for (int i = 1; i <= noOfDetails; i++) {

                String detailText = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                String detailValue = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                dealDetails.put(detailText, detailValue);
            }

            Log.info("------------ Details --------------");

            for (Map.Entry<String, String> e : dealDetails.entrySet()) {
                Log.info(e.getKey(), e.getValue());
            }

//            dealDetails.entrySet().forEach( entry -> {
//                System.out.println( entry.getKey() + " => " + entry.getValue() );
//            });

            Log.info("-----------------------------------");

            return true;

        }else {
            return false;
        }


    }
}