package IntegrationTests.P2M;

import IntegrationTests.Screens.AddmoneyScreen;
import IntegrationTests.Screens.P2MScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class P2MHelper extends P2MHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    P2MScreen p2MScreen;
    LinkedHashMap<String, String> walletBalance = new LinkedHashMap<>();
    Reporter reporter;
    HomePage homePage;

    public P2MHelper(AndroidDriver driver) throws IOException {
        p2MScreen = new P2MScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        reporter = new Reporter();
        homePage = new HomePage(driver);

    }


    public void p2mSufficient(String mCode, String mName, String amount, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;


        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double foodBalanceBefore = Double.valueOf(walletBalance.get("Food Reimbursement")) * 100;

        // Select the transfer money option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Transfer Money button from Homescreen"), "");
        p2MScreen.selectElement(By.id("btn_p2m"));

        Thread.sleep(2000);
        mbkCommonControls.allowPermission(true, "Pictures");


        // Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Recipient Details"), "");
        p2MScreen.selectElement(By.xpath("//*[@text='Enter Mobile Number or Merchant Code']"));


        Thread.sleep(2000);
        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Calls");

        p2MScreen.waitForVisibility(By.id("search_edittext"));
        p2MScreen.findElement(By.id("search_edittext")).sendKeys(mCode);
        Thread.sleep(3000);


        p2MScreen.selectElement(By.id("click_container"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        p2MScreen.waitForVisibility(By.id("edt_txt_transfer_amount"));
        p2MScreen.findElement(By.id("edt_txt_transfer_amount")).sendKeys(amount);


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Confirm Transfer"), "");
        p2MScreen.selectElement(By.id("btn_p2p_action"));

        //Handle the security PIN
        mbkCommonControls.handleSecurityPin("123456");


        Thread.sleep(5000);

        // Take screen shot of the success Page
        p2MScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "P2M Success screen"), directoryName, screenName);


        // Verify the values on the Success screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + Log.info("ASSERT", "Details"), "");

        // Assert the details on the success page
        String successPageStatus = p2MScreen.findElement(By.id("base_title")).getText();
        String successPageMerchantName = p2MScreen.findElement(By.id("txt_info")).getText();
        String successPageMerchantCode = p2MScreen.findElement(By.id("txt_cn_value")).getText();
        Double successPageAmountPaid = Double.valueOf(p2MScreen.findElement(By.id("total_amount_value")).getText().replace("X", "").replace("₹ ", "").replace(",", "")) * 100;


        p2MScreen.verifyEqualsExtentReport(successPageStatus, "Money sent successfully", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Money sent successfully", true, "Verify successPageStatus", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(successPageMerchantName, mName, "Actual : " + successPageMerchantName + " | Expected : " + mName, true, "Verify successPageMerchantName", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(successPageMerchantCode, mCode, "Actual : " + successPageMerchantCode + " | Expected : " + mCode, true, "Verify successPageMerchantCode", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);


        p2MScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleRatingsPopUp();

        p2MScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleUpiPopup();

        // Assert the wallet balances
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double foodBalanceAfter = Double.valueOf(walletBalance.get("Food Reimbursement")) * 100;

        Double expectedTotalBalance = totalBalanceBefore - Double.valueOf(amount) * 100;
        Double expectedFoodBalance = foodBalanceBefore - Double.valueOf(amount) * 100;


        p2MScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(foodBalanceAfter.toString(), expectedFoodBalance.toString(), "Actual : " + foodBalanceAfter.toString() + " | Expected : " + expectedFoodBalance.toString(), true, "Verify foodBalance", directoryName, screenName);


    }
}