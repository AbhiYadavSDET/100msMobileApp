package Helpers;
/*
import PageObject.HomePage;
import PageObject.NearbyPage;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import utils.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.List;

public class NearByHelper {
    TouchAction touchAction;
    ApiCommonControls apiCommonControls;
    Reporter reporter = new Reporter();
    NearbyPage nearbyPage;
    HomePage homePage;
    Screen screen;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;
    MBReporter mbReporter;

    public NearByHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        touchAction = new TouchAction(driver);
        apiCommonControls = new ApiCommonControls();
        nearbyPage = new NearbyPage(driver);
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");

    }


    public void nearbyStoreByAddress() throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        homePage.clickAllServices();

        for (int i = 0; i < 3; i++) {

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Local Stores']")) == false) {

                screen.swipeUpMore(driver);

            } else {
                break;
            }
        }

        nearbyPage = homePage.clickNearbyIcon();

        permissionHelper.permissionAllow();

        Thread.sleep(3000);

        Element.waitForVisibility(driver, By.id("overlayView"));

        List<AndroidElement> stores = Element.findElements(driver, By.id("tv_name"));
        int noOfstoresInOneList = stores.size();

        nearbyPage.clickOnBackButton();

//        homePage.closeMoreServicesOverlay();
//
//        Thread.sleep(2000);
//
//        homePage.clickAllServices();

//        String totalStoreCount = homePage.getStoreCount();
//
//        mbReporter.verifyTrueWithLogging(noOfstoresInOneList > 0, "No of Stores under address: " + noOfstoresInOneList, true, false);
//
//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("tx_tag")), "Total Stores count displayed on home page: " + totalStoreCount, true, false);


//        homePage.closeMoreServicesOverlay();


    }


    public void nearbySearchCategory(String categoryName) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        homePage.clickAllServices();

        for (int i = 0; i < 3; i++) {

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Local Stores']")) == false) {

                screen.swipeUpMore(driver);

            } else {
                break;
            }
        }

        nearbyPage = homePage.clickNearbyIcon();

        permissionHelper.permissionAllow();

        Thread.sleep(3000);

        Element.waitForVisibility(driver, By.xpath("//android.view.View[@index= '0']"));

        nearbyPage.clickOnCategoryIcon("More");

        nearbyPage.clickOnCategoryIcon(categoryName);

        Thread.sleep(2000);

        mbReporter.verifyEqualsWithLogging(nearbyPage.getCategoryStoreTitle(), categoryName, "Verify if the Category list is open", true, false);

        List<AndroidElement> stores = Element.findElements(driver, By.id("tv_name"));
        int noOfstoresInOneList = stores.size();

        mbReporter.verifyTrueWithLogging(noOfstoresInOneList > 0, "No of Stores for " + categoryName + ":" + noOfstoresInOneList, true, false);

        nearbyPage.clickOnBackButtonFromInternalPages();

        Thread.sleep(300);

        nearbyPage.clickOnBackButton();

        homePage.closeMoreServicesOverlay();


    }


    public void nearbySearchStore(String storeName) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Screen.swipeUpMore(driver);

        homePage.clickAllServices();

        for (int i = 0; i < 3; i++) {

            if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Local Stores']")) == false) {

                screen.swipeUpMore(driver);

            } else {
                break;
            }
        }

        nearbyPage = homePage.clickNearbyIcon();

        permissionHelper.permissionAllow();

        Thread.sleep(3000);

        Element.waitForVisibility(driver, By.xpath("//android.view.View[@index= '0']"));

        nearbyPage.clickSearchNearbyStores();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Categories']"));

        nearbyPage.enterStore(storeName);

        nearbyPage.clickSearchIcon();

        Thread.sleep(1000);

        List<AndroidElement> stores = Element.findElements(driver, By.id("tv_name"));
        int noOfstoresInOneList = stores.size();

        Log.info(""+noOfstoresInOneList+"");

        mbReporter.verifyTrueWithLogging(noOfstoresInOneList > 0, "No of Stores for " + storeName + ":" + noOfstoresInOneList, true, false);

        nearbyPage.clickOnBackButtonFromInternalPages();

        Thread.sleep(300);

        nearbyPage.clickOnBackButton();

        Thread.sleep(300);

        nearbyPage.clickOnBackButton();

        homePage.closeMoreServicesOverlay();


    }


}


 */