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
    MBKCommonControlsHelper mbkCommonControlsHelper;
    PermissionPage permissionPage;
    Process process;


    public DeepLinkHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        mbkPermissions = new MBKPermissions(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        screen = new Screen(driver);
        permissionPage = new PermissionPage(driver);
        permissionHelper = new PermissionHelper(driver);
        homePage = new HomePage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);


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

    public void validateDeeplink(String deeplinkstring, String appName, String elementID) throws InterruptedException, IOException {

//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Thread.sleep(3000);

        String cmd = "/home/parajjain/Android/Sdk/platform-tools/adb shell am start -a android.intent.action.VIEW -d "+deeplinkstring;

        process = Runtime.getRuntime().exec(cmd);

//        driver.get(deeplinkstring);

        Thread.sleep(6000);

        boolean abc= getApplicableApp(appName);

//        if(abc){
//            Log.info("true");
//        }else{
//            Log.info("false");
//        }

        if(abc){

            mbReporter.verifyTrueWithLogging(abc, "Deeplink Indexing of "+deeplinkstring+ " is available for "+appName, true, false );

            Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text= '"+appName+"']")), "Select "+appName+" App");

            Element.selectElement(driver, (AndroidElement) driver.findElement(By.id("android:id/button_once")), "Open App for One time");

            Thread.sleep(5000);

            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//")), "Validate Feature is not Visible", true, false);

        }else {

            mbReporter.verifyTrueWithLogging(abc, "Deeplink Indexing of "+deeplinkstring+ " is not available for "+appName, true, false );


        }




    }

    public void validateDeeplink(String deeplinkstring, String appName) throws InterruptedException, IOException {

//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));


        String cmd = "adb shell am start -a android.intent.action.VIEW -d "+deeplinkstring;

        process = Runtime.getRuntime().exec(cmd);

//        driver.get(deeplinkstring);

        Thread.sleep(3000);

        boolean abc= getApplicableApp(appName);


        if(!abc){

            mbReporter.verifyTrueWithLogging(!abc, "Deeplink Indexing of "+deeplinkstring+ " is not available for "+appName, true, false );


        }else {

            mbReporter.verifyTrueWithLogging(!abc, "Deeplink Indexing of "+deeplinkstring+ " is available for "+appName, true, false );

        }




    }


    public boolean getApplicableApp( String appName) throws InterruptedException{



        List<AndroidElement> applicableApp= driver.findElements(By.id("android:id/text1"));

        Thread.sleep(2000);
        int noOfApp = applicableApp.size();

        boolean abc = false;

        for (int i = 0; i < noOfApp ; i++) {

//            Log.info(applicableApp.get(i).getText());
//            Log.info(appName);

            String appInstance= applicableApp.get(i).getText();

            if(appInstance.equals(appName)){
                System.out.println("Deeplink Indexing available for "+ appName);
                abc=true;
                break;

            }

        }

//        if(abc){
//            Log.info("true found");
//        }else{
//            Log.info("false not found");
//        }
        return abc;

    }



}
