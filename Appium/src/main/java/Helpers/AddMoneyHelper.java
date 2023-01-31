package Helpers;

import PageObject.AddMoneyPage;
import PageObject.HomePage;
import PageObject.SecurityPinPage;
import PageObject.TransactionHistoryPage;
import PageObject.PermissionPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;

import java.io.IOException;
import java.util.HashMap;

public class AddMoneyHelper {

    AndroidDriver driver;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    SecurityPinPage securityPinPage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionPage permissionPage;


    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    private Object AndroidElement;


    public AddMoneyHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        addMoneyPage = new AddMoneyPage(driver);
        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionPage = new PermissionPage(driver);

    }

    /**
     * This method is to Test standalone add money Flow.
     * Flow Can Be "SavedCard" or "NewCard"
     */


    public void addMoneyViaCard(String amount, String cvv) throws InterruptedException, IOException {

        Log.info("START", "Add Money");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);
        Log.info("cvv : " + cvv);
        Log.info("-------------------------------------");

        // Click on the profile
        securityPinPage.clickOnProfile();

        // Click on add Money
        addMoneyPage.clickOnAddMoney();

        // Enter amount
        addMoneyPage.enterAmount(amount);

        // Click on Add
        addMoneyPage.clickOnAdd();

        // Select More Payment Options
        addMoneyPage.selectMorePaymentOptions();

        // Click on Indusind Bank
        addMoneyPage.clickOnIndusindBank();

        // Enter CVV
        addMoneyPage.enterCVV(cvv);

        // Click on Pay
        addMoneyPage.clickOnPay();

        Thread.sleep(3000);

        if(permissionPage.isPermissionMessagePresent()){ permissionPage.allowPermissionMessage(); }

        Thread.sleep(3000);

    }

}


