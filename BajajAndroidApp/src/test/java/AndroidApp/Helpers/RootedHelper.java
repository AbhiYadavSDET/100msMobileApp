package AndroidApp.Helpers;

import AndroidApp.PageObject.RootedNotePage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;

import java.io.IOException;

public class RootedHelper {

    AndroidDriver driver;
    RootedNotePage rootedNotePage;
    MBReporter mbReporter;

    public RootedHelper(AndroidDriver driver) {
        this.driver = driver;
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        rootedNotePage = new RootedNotePage(driver);
    }

    public void assertText() throws IOException {
        Log.info("Rooted Phone Text Assertion");
        MBReporter.verifyEqualsWithLoggingExtentReport(rootedNotePage.intialText(), "SORRY!", "Verify Initial Text", false);
        MBReporter.verifyEqualsWithLoggingExtentReport(rootedNotePage.rootedDisclaimer(), "You are using an unsafe rooted phone.", "Verify Rooted Disclaimer", false);
    }
}
