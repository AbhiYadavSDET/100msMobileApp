package IntegrationTests.TransactionHistory;

import IntegrationTests.Screens.AddmoneyScreen;
import IntegrationTests.Screens.P2MScreen;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;

/**
 * contains all methods to test Add Money Flow
 */
public class TransactionHistoryHelper extends TransactionHistoryHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    P2MScreen p2MScreen;
    HomePage homePage;


    public TransactionHistoryHelper(AndroidDriver driver) throws IOException {
        p2MScreen = new P2MScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        homePage=new HomePage(driver);

    }


    public void transactionHistoryVerification(String expectedDescription, String expectedDate, String expectedAmount, String transactionType, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        homePage.clickOnCrossButton();

        int ssCount = 0;
        String sign;

        if (transactionType.toUpperCase() == "DEBIT") {
            sign = "-";
        } else {
            sign = "+";
        }

        Log.info("Handle       | KYC Popup");
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);

        Log.info("SELECT       | Transaction History Tab");
        p2MScreen.selectElement(By.name("History"));
        Thread.sleep(3000);

        Log.info("FETCH        | Details from the 1st Cell");
        p2MScreen.waitForVisibility(By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]"));
        String description = p2MScreen.findElement(By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")).getText();
        String date = p2MScreen.findElement(By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")).getText();
        String amount = p2MScreen.findElement(By.xpath("//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]")).getText();
        Log.info("DETAILS      | description : " + description + " | " + "date : " + date + " | " + "amount : " + amount);

        Log.info("VERIFY       | Actual values with Expected");
        p2MScreen.verifyEquals(description, expectedDescription, "Description | Actual : " + description + " | " + "Expected : " + expectedDescription, false, false);
        p2MScreen.verifyEquals(date, expectedDate, "Date | Actual : " + date + " | " + "Expected : " + expectedDate, false, false);
        p2MScreen.verifyEquals(amount, sign + " ₹ " + expectedAmount, "Amount | Actual : " + amount + " | " + "Expected : " + expectedAmount, false, false);

        Log.info("RETURN       | Home-screen");


    }
}