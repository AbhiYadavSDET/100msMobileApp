package Helpers;

import Logger.Log;
import PageObject.ZipPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ZipHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    ZipPage zipPage;
    Screen screen;
    MBReporter mbReporter;


    public ZipHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        zipPage = new ZipPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyZip(String expZipPageTitle, String expZipPageLabel) throws InterruptedException, IOException {
        // Tap on Zip Page
        zipPage.clickZipIcon();

        // Click on Activate Cta
        zipPage.clickCtaActivate();

        // Click on Allow CTa
        if(zipPage.isClickAllowPresent()) {zipPage.clickAllow();}

        // Allow all the permission
        if(zipPage.isPermissionLocationPresent()) {zipPage.allowPermissionLocation();}
        if(zipPage.isPermissionContactsPresent()) {zipPage.allowPermissionContacts();}
        if(zipPage.isPermissionMessagePresent()) {zipPage.allowPermissionMessage();}


        // Verification on the Zip screen
        String actualZipPageTitle = zipPage.getTitle();
        String actualZipPageLabel = zipPage.getLabel();

        // Display the values
        Log.info("Zip Page Title : " + actualZipPageTitle);
        Log.info("Zip Page Label : " + actualZipPageLabel);


        // Add the assertions
        mbReporter.verifyEquals(actualZipPageTitle, expZipPageTitle, "Verify Zip Page Title", false, false);
        mbReporter.verifyEquals(actualZipPageLabel, expZipPageLabel, "Verify Zip Page Label", false, false);


    }


}
