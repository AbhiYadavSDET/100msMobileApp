package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.InsurancePage;
import test.java.AndroidApp.PageObject.TransactionHistoryPage;

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
    TransactionHistoryPage transactionHistoryPage;

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


    public String buyInsurance(String expectedHeader, String expectedDescription, String securityPin) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Element.waitForVisibility(driver, homePage.sidedrawer_icon);
        screen.swipeUpMedium(driver);

        insurancePage = homePage.clickOnInsuranceIcon();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/mkab_title"));
        screen.swipeUpMore(driver);

        insurancePage.clickOnImagePersonalAccidentInsurance();

        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = 'Personal Accident Insurance']"));

        insurancePage.clickOnSelectiveBtnPrice();

        String insuredBy = insurancePage.getInsuredBy();

        insurancePage.clickOnCtaMakePayment();

        mbkCommonControlsHelper.handleSecurityPin(securityPin);

        // Fetch the details from the screen
        String actualHeader = insurancePage.getFillDetailsHeader();
        String actualDescription = insurancePage.getFillDetailsDescription();

        // fetch the policy ID
        String policyId;

        mbReporter.verifyEqualsWithLogging(actualHeader, expectedHeader, "Fill details Screen | Header", false, false);
        mbReporter.verifyEqualsWithLogging(actualDescription, expectedDescription+insuredBy, "Fill details Screen | Description", false, false);


        // Return to the homepage
        mbkCommonControlsHelper.clickUpButton();
        mbkCommonControlsHelper.clickUpButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        // Goto History Tab
        transactionHistoryPage = homePage.clickHistory();

        transactionHistoryPage.clickOnFirstElementInTheList();

        policyId = transactionHistoryPage.getTrxId();
        Log.info("Policy Id : " + policyId);
        return policyId;
    }


}
