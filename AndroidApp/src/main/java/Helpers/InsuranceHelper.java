package Helpers;

import PageObject.HomePage;
import PageObject.InsurancePage;
import PageObject.TransactionHistoryPage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

        homePage.clickInvestmentAndInsuranceLayout();
        insurancePage = homePage.clickOnInsuranceIcon();

        Element.waitForVisibility(driver, By.id("mkab_title"));
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


    public void validateInsurance(String insuranceAmount) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        Element.waitForVisibility(driver, homePage.sidedrawer_icon);
        screen.swipeUpMedium(driver);

        homePage.clickInvestmentAndInsuranceLayout();
        insurancePage = homePage.clickOnInsuranceIcon();

        Thread.sleep(4000);
        Element.waitForVisibility(driver, By.id("mkab_title"));

        mbReporter.verifyTrueWithLogging(getInsuranceDetails(), "Verify Insurance Details", false,false);

        insurancePage.selectPersonalAccidentInsurance();

        Element.waitForVisibility(driver,By.id("tnc_view"));

        insurancePage.clickOnAgreeTerms();

        permissionHelper.permissionAllow();

        Thread.sleep(2000);
        Element.selectElement(driver, (AndroidElement) driver.findElement(By.xpath("//android.widget.Button[@text='"+insuranceAmount+"']")), "Select Insurance Category");


        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text = 'Confirm Payment']"));


        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Confirm Payment']")), "Verify Confirmation Page is Loaded", true, true);

        mbReporter.verifyTrueWithLogging(getInsuranceDetailsInfo(), "Verify Insurance Info Details", false,false);

        insurancePage.clickOnBackButton();

        insurancePage.clickOnBackButton();

        insurancePage.clickOnBackButton();

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        homePage.closeMoreServicesOverlay();







    }



    public Boolean getInsuranceDetails() throws InterruptedException, IOException {
        LinkedHashMap<String, String> insuranceDetails = new LinkedHashMap<>();
        Log.info("START", "Fetch Insurance Details");

        if(Element.waitForVisibility(driver, By.id("deeplinkLayout"))) {
            int noOfDetails = Element.findElements(driver, By.id("offer_tittle")).size();
            Log.info("No Of Insurance Details - " + noOfDetails);

            // Fetch Details
            for (int i = 1; i <= noOfDetails; i++) {

                String TitleText = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]")).getText();
                String Subtitle = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]")).getText();
                insuranceDetails.put(TitleText, Subtitle);
            }

            Log.info("------------ Insurance Details --------------");

            for (Map.Entry<String, String> e : insuranceDetails.entrySet()) {
                Log.info(e.getKey(), e.getValue());
            }

//            dealDetails.entrySet().forEach( entry -> {
//                System.out.println( entry.getKey() + " => " + entry.getValue() );
//            });

            Log.info("-----------------------------------");

            return true;

        }else {
            return false;
        }


    }

    public Boolean getInsuranceDetailsInfo() throws InterruptedException, IOException {
        LinkedHashMap<String, String> insuranceDetailsInfo = new LinkedHashMap<>();
        Log.info("START", "Fetch Insurance Info Details");

        if(Element.waitForVisibility(driver, By.id("amount_to_be_paid"))) {
            int noOfDetails = Element.findElements(driver, By.id("row_element_left")).size();
            Log.info("No Of Insurance Info Details - " + noOfDetails);

            // Fetch Details
            for (int i = 1; i <= noOfDetails; i++) {

                String leftDetails = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
                String rightDetails = element.findElement(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
                insuranceDetailsInfo.put(leftDetails, rightDetails);
            }

            Log.info("------------ Insurance Details --------------");

            for (Map.Entry<String, String> e : insuranceDetailsInfo.entrySet()) {
                Log.info(e.getKey(), e.getValue());
            }

//            dealDetails.entrySet().forEach( entry -> {
//                System.out.println( entry.getKey() + " => " + entry.getValue() );
//            });

            Log.info("-----------------------------------");

            return true;

        }else {
            return false;
        }


    }


}
