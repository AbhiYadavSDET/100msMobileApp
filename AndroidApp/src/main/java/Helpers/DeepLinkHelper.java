package Helpers;

import PageObject.HomePage;
import PageObject.PermissionPage;
import UITestFramework.MBKPermissions;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import logger.Log;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import utils.Element;
import utils.ExtentReport;
import utils.Screen;

import java.io.IOException;
import java.util.List;

public class DeepLinkHelper {
    AndroidDriver driver;
    MBKPermissions mbkPermissions;
    MBReporter mbReporter;
    HomePage homePage;
    Screen screen;
    PermissionHelper permissionHelper;
    Process process;
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
            List<AndroidElement> textList = driver.findElements(By.className("android.widget.TextView"));
            int count = 0;
            for (AndroidElement textElement : textList) {
                if (Element.getText(driver, textElement, "Get TextView Text").contains("Verify"))
                    ++count;
            }
            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("start_button")), "Let's get started");

            while (count > 0) {
                permissionHelper.permissionAllow();
                --count;
            }
        }

        Thread.sleep(3000);

        String textview2 = (driver.findElement(By.id(elementID))).getText();
        Log.info(textview2);
        Log.info(deeplinkverify);


        mbReporter.verifyEqualsWithLogging(textview2, deeplinkverify, "VerifyDeepLink", false, true);


        Log.info("deeplink verfied");
        //Thread.sleep(2000);
        //driver.navigate().back();
    }

    public void validateDeeplink(String deeplinkstring, String appName, String element, String elementType, String module, String handle) throws InterruptedException, IOException {

//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        // Logging the deeplink details in the extent report
        Log.info("Test Case Started for " + deeplinkstring + " in " + module + " Module.");
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Module", module);
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Deeplink", deeplinkstring);
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Locator", elementType + " : " + element);

        // Kill the app
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(3000);

        // Open the deeplink via adb
        String cmd = "adb shell am start -a android.intent.action.VIEW -d " + deeplinkstring;
        process = Runtime.getRuntime().exec(cmd);
        Thread.sleep(3000);


        if (Element.isElementPresent(driver, By.id("android:id/sem_titlePanel_default"))) {


            List<AndroidElement> applicableApp = driver.findElements(By.id("android:id/text1"));

            Thread.sleep(2000);
            int noOfApp = applicableApp.size();

            for (int i = 0; i < noOfApp; i++) {

//            Log.info(applicableApp.get(i).getText());
//            Log.info(appName);

                String appInstance = applicableApp.get(i).getText();

                if (appInstance.equals(appName)) {
                    mbReporter.verifyTrueWithLogging(true, "Deeplink Indexing of " + deeplinkstring + " is available for " + appName, true, false);
                    ;

                    if (Element.isElementPresent(driver, By.id("android:id/button_once"))) {

                        Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text= '" + appName + "']")), "Select " + appName + " App");

                        Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("android:id/button_once")), "Open App for One time");
                    } else {

                        Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text= '" + appName + "']")), "Select " + appName + " App");

                    }

                    Thread.sleep(3000);
                    break;

                }

            }


        }

        //Handling Special Cases

        switch (handle) {
            case "NA":
                break;
            case "insurance":
                if(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/content_root"))){

                    Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("com.mobikwik_new:id/primary_button")), "Select OHK");
                }
                break;

            case "giftcards":

                //If Gift Card Intro Page is Present. Prodedure to Setup and kill app again
                if(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/content_root"))){

                    Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text = 'View Gift Cards']")), "Select view Gift Cards");
                Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/category_name"));

                    driver.pressKey(new KeyEvent(AndroidKey.HOME));
                    Thread.sleep(2000);

                cmd = "adb shell am start -a android.intent.action.VIEW -d " + deeplinkstring;
                    process = Runtime.getRuntime().exec(cmd);
                    Thread.sleep(3000);


                    if (Element.isElementPresent(driver, By.id("android:id/sem_titlePanel_default"))) {


                        List<AndroidElement> applicableApp = driver.findElements(By.id("android:id/text1"));

                        Thread.sleep(2000);
                        int noOfApp = applicableApp.size();

                        for (int i = 0; i < noOfApp; i++) {

//            Log.info(applicableApp.get(i).getText());
//            Log.info(appName);

                            String appInstance = applicableApp.get(i).getText();

                            if (appInstance.equals(appName)) {
                                mbReporter.verifyTrueWithLogging(true, "Deeplink Indexing of " + deeplinkstring + " is available for " + appName, true, false);
                                ;

                                if (Element.isElementPresent(driver, By.id("android:id/button_once"))) {

                                    Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text= '" + appName + "']")), "Select " + appName + " App");

                                    Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("android:id/button_once")), "Open App for One time");
                                } else {

                                    Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text= '" + appName + "']")), "Select " + appName + " App");

                                }

                                Thread.sleep(3000);
                                break;

                            }

                        }


                    }

                }
                break;

            case "nearby":
                if (permissionHelper.isPermissionPopUpPresent()) {

                    permissionHelper.permissionAllow();
                    Thread.sleep(3000);
                }
                break;



        }




        if (permissionHelper.isPermissionPopUpPresent()) {

            permissionHelper.permissionAllow();
            Thread.sleep(1000);
        }


        // Assertions
        switch (elementType) {
            case "id":
                MBReporter.verifyEqualsWithLoggingExtentReport(Element.isElementPresent(driver, By.id("" + element + "")), true, "User is redirected to the " + module + " feature via " + deeplinkstring, true);
                break;
            case "xpath":
                mbReporter.verifyEqualsWithLoggingExtentReport(Element.isElementPresent(driver, By.xpath("" + element + "")), true, "User is redirected to the " + module + " feature via " + deeplinkstring, true);
        }


    }


}
