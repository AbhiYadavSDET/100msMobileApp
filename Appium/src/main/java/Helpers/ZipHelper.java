package Helpers;

import Logger.Log;
import PageObject.ElectricityPage;
import PageObject.ZipPage;
import Utils.Element;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        if (zipPage.isClickAllowPresent()) {
            zipPage.clickAllow();
        }

        // Allow all the permission
        if (zipPage.isPermissionLocationPresent()) {
            zipPage.allowPermissionLocation();
        }
        if (zipPage.isPermissionContactsPresent()) {
            zipPage.allowPermissionContacts();
        }
        if (zipPage.isPermissionMessagePresent()) {
            zipPage.allowPermissionMessage();
        }


        // Verification on the Zip screen
        String actualZipPageTitle = zipPage.getTitle();
        String actualZipPageLabel = zipPage.getLabel();

        // Display the values
        Log.info("Zip Page Title : " + actualZipPageTitle);
        Log.info("Zip Page Label : " + actualZipPageLabel);


        // Add the assertions
        mbReporter.verifyEqualsWithLogging(actualZipPageTitle, expZipPageTitle, "Verify Zip Page Title", false, false, true);
        mbReporter.verifyEqualsWithLogging(actualZipPageLabel, expZipPageLabel, "Verify Zip Page Label", false, false, true);


    }

    //"ZIP Dashboard","Your Credit Score"
    public void verifyZipActiveUser(String expZipPageTitle, String expCreditScorePageTitle) throws InterruptedException, IOException {
        // Tap on Zip Page
        zipPage.clickZipIcon();

        Element.waitForVisibility(driver, By.id("tv_title"));
        mbReporter.verifyEqualsWithLogging(zipPage.getTitle(), expZipPageTitle, "Validating Zip Page Title", false, false);

        Integer availableBalance = Integer.parseInt(zipPage.getAvailableBalance());
        Integer amountUsed = Integer.parseInt(zipPage.getAmountUsed());
        Integer amountTotal = Integer.parseInt(zipPage.getAmountTotal());

        mbReporter.verifyEqualsWithLogging(amountTotal - amountUsed, availableBalance, "Validating amount calculation", false, false);

        Screen.swipeUpMore(driver);

        String outsideCreditValue = zipPage.fetchCreditValue();

        zipPage.selectViewReport();

        Element.waitForVisibility(driver, By.id("tv_credit_performance"));

        mbReporter.verifyEqualsWithLogging(zipPage.getTitle(), expCreditScorePageTitle, "Validating Credit Score Page Title", false, false);

        String insideCreditValue = zipPage.fetchCreditValue();

        mbReporter.verifyEqualsWithLogging(insideCreditValue, outsideCreditValue, "Validating Credit Score Value", false, false);

        zipPage.navigateBack();

        Screen.swipeUpMore(driver);

        if (zipPage.getOfferCount() > 0) {
            mbReporter.verifyTrueWithLogging(true, "Validate Offers Count : " + zipPage.getOfferCount(), false, false);
        }

        Screen.swipeUpMore(driver);

        if (zipPage.getHistoryCount() < 4) {
            mbReporter.verifyTrueWithLogging(true, "Validate History Txn Count : " + zipPage.getHistoryCount(), false, false);
        }

    }


    //"ZIP Dashboard","Bill Book", "Vi", "Delhi NCR", "7795709569"
    public void verifyZipAutoPay(String expZipPageTitle, String expAutoPayPageTitle, String operator, String city, String mobileNumber) throws InterruptedException, IOException {
        // Tap on Zip Page
        zipPage.clickZipIcon();

        Element.waitForVisibility(driver, By.id("tv_title"));

        mbReporter.verifyEqualsWithLogging(zipPage.getTitle(), expZipPageTitle, "Validating Zip Page Title", false, false);

        Screen.swipeUpMore(driver);

        if(!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Manage now']"))){
            Screen.swipeUpMore(driver);
        }

        zipPage.clickOnManageNowCta();

        Element.waitForVisibility(driver, By.id("switch_auto_pay"));

        mbReporter.verifyEqualsWithLogging(zipPage.getTitle(), expAutoPayPageTitle, "Validating Zip Page Title", false, false);

        zipPage.clickOnAddBillerCta();

        zipPage.selectMobileIcon();

        //Click Search Operator Brand field
        zipPage.clickSearchBrand();

        //Enter Brand name in search text box
        zipPage.enterSearchCriteria(operator);

        Thread.sleep(2000);

        //Select brand from list
        zipPage.clickSelectResult();


        //Click Search City field
        zipPage.clickSearchCity();

        //Enter Brand name in search text box
        zipPage.enterSearchCriteria(city);

        Thread.sleep(2000);

        //Select brand from list
        zipPage.clickSelectResult();


        //Click on Mobile number text box
        zipPage.clickMobileNumber();

        //Enter Mobile number in text field
        zipPage.enterMobileNumber(mobileNumber);

        zipPage.clickOnAutopayToggle();

        zipPage.clickOnSaveConnectionCta();

        Thread.sleep(1000);

// Wait for the toast message to appear (you may need to adjust the timeout)
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast")));

// Get the text of the toast message
        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("text");

        mbReporter.verifyTrueWithLogging(!(toastMessage == null), "Toast Message : " + toastMessage, false, false);

        System.out.println("Toast Message: " + toastMessage);


    }


}
