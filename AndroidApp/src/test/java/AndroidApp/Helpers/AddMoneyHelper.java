package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Config;
import main.java.utils.Element;
import main.java.utils.Screen;
import main.java.utils.TestDataReader;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.AddMoneyPage;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.util.HashMap;

public class AddMoneyHelper {

    AndroidDriver driver;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;


    public AddMoneyHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");

    }

    public void netbanking(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        balanceBefore = mbkCommonControlsHelper.getBalance();


        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(map.get("amount"));

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        addMoneyPage.clickOnNetbanking();

        Thread.sleep(2000);

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + map.get("bankname") + "']"));
        Element.selectElement(driver, androidElement, map.get("bankname"));

        //Thread.sleep(10000);

        Element.waitForVisibility(driver, addMoneyPage.label_make_payment);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.view.View[@text = '" + map.get("bankpagelocator") + "']")), map.get("bankname") + "Page text", false, false);

        mbkCommonControlsHelper.clickUpButton();

        addMoneyPage.clickOnYesButton();

        balanceAfter = mbkCommonControlsHelper.getBalance();


    }

    public void addMoneyViaNewCard(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(map.get("amount"));

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        addMoneyPage.clickOnNewDebitCreditCard();

        enterCardDetails(map.get("cardno"), map.get("expirymonth"), map.get("expiryyear"), map.get("cvv"));

        addMoneyPage.clickOnPayNow();

        handleIndusindWebView(map.get("password"));

        //Assertions
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), map.get("successpagestatus"), "Success Page Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), map.get("successpagetext"), "Success Page Text", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

        balanceAfter = mbkCommonControlsHelper.getBalance();

    }

    public void addMoneyViaSavedCard(int rownum) throws InterruptedException, IOException, JSONException {
        // Fetch data from sheet
        Log.info("Fetching Data From Sheet");
        fetchDataFromSheet(rownum);

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(map.get("amount"));

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + map.get("cardno") + "']"));
        Element.selectElement(driver, androidElement, map.get("bankname"));

        addMoneyPage.enterCvv(map.get("cvv"));

        addMoneyPage.clickOnPayNow();

        handleIndusindWebView(map.get("password"));

        //Assertions
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageStatus(), map.get("successpagestatus"), "Success Page Status", false, false);
        mbReporter.verifyEqualsWithLogging(addMoneyPage.getSuccessPageText(), map.get("successpagetext"), "Success Page Text", false, false);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();


    }


    public void fetchDataFromSheet(int rownum) {
        map = new HashMap<String, String>();
        TestDataReader testData = Config.getCachedTestDataReaderObject("addmoney");
        map.put("amount", testData.GetData(rownum, "amount"));
        map.put("bankname", testData.GetData(rownum, "bankname"));
        map.put("bankpagelocator", testData.GetData(rownum, "bankpagelocator"));
        map.put("cardno", testData.GetData(rownum, "cardno"));
        map.put("expirymonth", testData.GetData(rownum, "expirymonth"));
        map.put("expiryyear", testData.GetData(rownum, "expiryyear"));
        map.put("cvv", testData.GetData(rownum, "cvv"));
        map.put("password", testData.GetData(rownum, "password"));
        map.put("successpagestatus", testData.GetData(rownum, "successpagestatus"));
        map.put("successpagetext", testData.GetData(rownum, "successpagetext"));


    }

    public void enterCardDetails(String cardNo, String expiryMonth, String expiryYear, String cvv) throws InterruptedException {
        addMoneyPage.enterCardNo(cardNo);
        addMoneyPage.enterExpiry(expiryMonth + "/" + expiryYear);
        addMoneyPage.enterCvv(cvv);
    }

    public void handleIndusindWebView(String password) throws InterruptedException {
        Element.waitForVisibility(driver, addMoneyPage.label_make_payment);

        addMoneyPage.clickOnBankPageSecurePassword();
        addMoneyPage.clickOnBankPageContinueButton();
        addMoneyPage.enterBankPagePassword(password);
        addMoneyPage.clickOnBankPageSubmitButton();

        Thread.sleep(10000);

    }


}
