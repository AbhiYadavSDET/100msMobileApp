package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.OlaPage;
import test.java.AndroidApp.PageObject.P2MPage;

import java.io.IOException;
import java.util.HashMap;

public class OlaHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    OlaPage olaPage;
    PermissionHelper permissionHelper;


    public OlaHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }


    public void olaBook() throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        olaPage=homePage.clickOnOlaIcon();
        permissionHelper.permissionAllow();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/drop_loc_layout"));



    }


}
