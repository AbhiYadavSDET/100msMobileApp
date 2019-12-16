package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import test.java.AndroidApp.PageObject.RootedNotePage;

public class RootedHelper {

    AndroidDriver driver;
    RootedNotePage rootedNotePage;
    MBReporter mbReporter;

    public RootedHelper(AndroidDriver driver) {
        this.driver = driver;
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        rootedNotePage = new RootedNotePage(driver);
    }

    public void assertText()
    {
        Log.info("Rooted Phone Text Assertion");
        mbReporter.verifyEqualsWithLogging(rootedNotePage.intialText(), "SORRY!", "Verify Initial Text", false, false);
        mbReporter.verifyEqualsWithLogging(rootedNotePage.rootedDisclaimer(), "You are using an unsafe rooted phone.", "Verify Rooted Disclaimer", false, false);
    }
}
