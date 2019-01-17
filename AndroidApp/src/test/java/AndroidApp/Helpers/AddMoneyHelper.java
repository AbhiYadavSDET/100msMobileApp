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
    public static HashMap<String, String> map;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;


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

        addMoneyPage = homePage.clickOnAddMoneyButton();

        addMoneyPage.clickOnAmountTextBox();

        addMoneyPage.enterAmount(map.get("amount"));

        addMoneyPage.clickOnContinueButton();

        Element.waitForVisibility(driver, addMoneyPage.label_select_payment_mode);

        screen.swipeUp();

        addMoneyPage.clickOnNetbanking();

        AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + map.get("bankname") + "']"));
        Element.selectElement(driver, androidElement, map.get("bankname"));

        Thread.sleep(10000);

        Element.waitForVisibility(driver, addMoneyPage.label_make_payment);

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.view.View[@text = '" + map.get("bankpagelocator") + "']")), map.get("bankname") + "Bank Page text", false, false);

        mbkCommonControlsHelper.clickUpButton();

        addMoneyPage.clickOnYesButton();


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
        map.put("successtext", testData.GetData(rownum, "successtext"));

    }


}
