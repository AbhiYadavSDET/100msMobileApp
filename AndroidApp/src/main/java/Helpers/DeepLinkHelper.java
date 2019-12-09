package Helpers;

import PageObject.HomePage;
import PageObject.PermissionPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import utils.Element;
import utils.Screen;

import java.io.IOException;

public class DeepLinkHelper {
    AndroidDriver driver;
    MBKPermissions mbkPermissions;
    MBReporter mbReporter;
    HomePage homePage;
    Screen screen;
    PermissionHelper permissionHelper;

    PermissionPage permissionPage;


    public DeepLinkHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        screen = new Screen(driver);
        permissionPage = new PermissionPage(driver);
        permissionHelper = new PermissionHelper(driver);
        homePage = new HomePage(driver);

    }

    @Parameters({"deeplinkstring", "deeplinkverify", "elementID"})
    public void getdeeplink(String deeplinkstring, String deeplinkverify, String elementID) throws InterruptedException, IOException {
        homePage.clickOnCrossButton();
        //For Merchant
        if (Element.isElementPresent(driver, (By.id("cross_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("cross_button")), "Cross Button");
        }
        if (Element.isElementPresent(driver, (By.id("next_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("next_button")), "Next Button");
        }
        if (Element.isElementPresent(driver, (By.id("next_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("next_button")), "Next Button");
        }

        Thread.sleep(2000);

        Log.info("deeplink started");
        Log.info(deeplinkstring);
        Thread.sleep(2000);
        //For Sanity
        driver.get(deeplinkstring);
        if (Element.isElementPresent(driver, (By.id("add_account_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("add_account_button")), "Add Account Button");
        }

        if (Element.isElementPresent(driver, (By.id("start_button")))) {
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("start_button")), "Let's get started");
        }
        Thread.sleep(3000);

        //For Sanity
        permissionHelper.permissionAllow();
        permissionHelper.permissionAllow();
        permissionHelper.permissionAllow();


        Thread.sleep(2000);


        String textview2 = (driver.findElement(By.id(elementID))).getText();
        Log.info(textview2);
        Log.info(deeplinkverify);


        mbReporter.verifyEqualsWithLogging(textview2, deeplinkverify, "VerifyDeepLink", false, true);


        Log.info("deeplink verfied");
        Thread.sleep(2000);
        driver.navigate().back();


    }
}
