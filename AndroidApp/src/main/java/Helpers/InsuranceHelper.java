package Helpers;

import PageObject.HomePage;
import PageObject.InsurancePage;
import PageObject.TransactionHistoryPage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

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

        Log.info(insurancePage.getFillDetailsDescription());
        String actualDescription = insurancePage.getFillDetailsDescription().toLowerCase().replaceAll("\n","");
        Log.info(actualDescription);

        // fetch the policy ID
        String policyId;

        mbReporter.verifyEqualsWithLogging(actualHeader, expectedHeader, "Fill details Screen | Header", false, false);
        mbReporter.verifyEqualsWithLogging(actualDescription, expectedDescription.toLowerCase() + insuredBy.toLowerCase(), "Fill details Screen | Description", true, false);


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
