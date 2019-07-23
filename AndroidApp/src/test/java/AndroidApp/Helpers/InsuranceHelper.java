package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.InsurancePage;

import java.io.IOException;
import java.util.HashMap;

public class InsuranceHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    InsurancePage insurancePage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public InsuranceHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }


    public void buyInsurance(String expectedHeader, String expectedDescription) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Element.waitForVisibility(driver, homePage.icon_mobile);
        screen.swipeUpMedium(driver);

        insurancePage = homePage.clickOnInsuranceIcon();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/mkab_title"));
        screen.swipeUpMore(driver);

        insurancePage.clickOnImageGasInsurance();

        insurancePage.clickOnButtonPrice();

        insurancePage.clickOnCtaMakePayment();

        mbkCommonControlsHelper.handleSecurityPin("123456");

        // Fetch the details from the screen
        String actualHeader = insurancePage.getFillDetailsHeader();
        String actualDescription = insurancePage.getFillDetailsDescription();

        mbReporter.verifyEqualsWithLogging(actualHeader, expectedHeader, "Fill details Screen | Header", false, false);
        mbReporter.verifyEqualsWithLogging(actualDescription, expectedDescription, "Fill details Screen | Description", false, false);


        // Return to the homepage
        mbkCommonControlsHelper.clickUpButton();
        mbkCommonControlsHelper.clickUpButton();

    }


}
