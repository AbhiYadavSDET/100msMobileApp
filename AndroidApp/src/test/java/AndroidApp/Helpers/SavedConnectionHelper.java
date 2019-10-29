package test.java.AndroidApp.Helpers;

import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Element;
import org.json.JSONException;
import org.openqa.selenium.By;
import sun.awt.windows.ThemeReader;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.SavedConnectionPage;
import test.java.AndroidApp.PageObject.SideDrawerPage;
import test.java.AndroidApp.PageObject.TransactionHistoryPage;

import java.io.IOException;

public class SavedConnectionHelper {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    SideDrawerPage sideDrawerPage;
    SavedConnectionPage savedConnectionPage;
    HomePage homePage;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    AndroidDriver driver;

    public SavedConnectionHelper(AndroidDriver driver) throws IOException {
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        homePage = new HomePage(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        this.driver = driver;

    }


    public void addFavourite(String customerId, String name) throws InterruptedException, IOException, JSONException {


        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        sideDrawerPage = homePage.clickHamburgerIcon();


        Thread.sleep(1000);

        savedConnectionPage= sideDrawerPage.clickOnMySavedConnection();

        savedConnectionPage.clickAddFavouritecta();

        savedConnectionPage.selectServiceDropdown();

        savedConnectionPage.selectDth();

        savedConnectionPage.selectOperator();

        savedConnectionPage.selectAirtelDth();

        savedConnectionPage.enterCustomerId(customerId);

        savedConnectionPage.enterName(name);

        savedConnectionPage.clickSave();

        Thread.sleep(2000);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= '"+name+"']")), "Verify if saved connection is created", true, true);

        savedConnectionPage.clickOnBackButton();


    }

    public void deleteFavourite(String name) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        sideDrawerPage = homePage.clickHamburgerIcon();


        Thread.sleep(1000);

        savedConnectionPage= sideDrawerPage.clickOnMySavedConnection();

        if(Element.isElementPresent(driver,By.xpath("//android.widget.TextView[@text= '"+name+"']") )){

            savedConnectionPage.selectSavedConnection();

            savedConnectionPage.selectMoreOption();

            savedConnectionPage.selectDeleteOption();


            Thread.sleep(2000);

            if (Element.isElementPresent(driver,By.xpath("//android.widget.TextView[@text= '"+name+"']") ))
            {
                Log.info("Saved Connection not Deleted");
            }else{

                Log.info("Saved Connection is Deleted");
            }

            savedConnectionPage.clickOnBackButton();

        }else{

            Log.info("Saved Connection already Deleted");
            savedConnectionPage.clickOnBackButton();
        }



    }
}