package IntegrationTests.P2P;

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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class P2PHelper extends P2PHelperBase {
    AddmoneyScreen addmoneyScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    P2MScreen p2MScreen;
    Map<String, String> walletBalance = new HashMap<>();
    Reporter reporter = new Reporter();


    public P2PHelper(AndroidDriver driver) throws IOException {
        p2MScreen = new P2MScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);

    }


    public void p2pSufficient(String mCode, String mName, String amount, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", testStepCount);

        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedBefore = Double.valueOf(walletBalance.get("Money Added")) * 100;

        // Select the transfer money option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Transfer Money button from Homescreen"), "");
        p2MScreen.selectElement(By.id("btn_p2p"));

        // Select the transfer from Wallet option
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Transfer from Wallet option"), "");
        p2MScreen.selectElement(By.xpath("//android.widget.TextView[@text='Wallet']"));


        // Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Recipient Details"), "");
        p2MScreen.selectElement(By.id("edit_field"));
        p2MScreen.findElement(By.id("edit_field")).sendKeys(mCode);
        Thread.sleep(5000);


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        p2MScreen.waitForVisibility(By.id("edt_txt_transfer_amount"));
        p2MScreen.findElement(By.id("edt_txt_transfer_amount")).sendKeys(amount);


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Transfer Now CTA"), "");
        p2MScreen.selectElement(By.id("btn_p2p_action"));
        Thread.sleep(3000);

        //Handle the security PIN
        mbkCommonControls.handleSecurityPin("123456");
        Thread.sleep(5000);

        // Take screen shot of the success Page
        p2MScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "P2P Success screen"), directoryName, screenName);


        // Verify the values on the Success screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | ASSERT       | Details", "");

        // Assert the details on the success page
        String successPageStatus = p2MScreen.findElement(By.id("base_title")).getText();
        String successPageMerchantName = p2MScreen.findElement(By.id("txt_info")).getText();
        String successPageMerchantMobile = p2MScreen.findElement(By.id("txt_cn_value")).getText();
        Double successPageAmountPaid = Double.valueOf(p2MScreen.findElement(By.id("txt_amount_value")).getText().replace("X", "").replace("₹ ", "").replace(",", "")) * 100;


        p2MScreen.verifyEqualsExtentReport(successPageStatus, "Money sent successfully", "Actual : " + successPageStatus + " | Expected : " + "Money sent successfully", true, "Verify successPageStatus", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(successPageMerchantName, mName, "Actual : " + successPageMerchantName + " | Expected : " + mName, true, "Verify successPageMerchantName", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(successPageMerchantMobile, mCode, "Actual : " + successPageMerchantMobile + " | Expected : " + mCode, true, "Verify successPageMerchantMobile", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid.toString() + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);


        p2MScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleRatingsPopUp();

        p2MScreen.selectElement(By.id("base_icon_close"));


        mbkCommonControls.handleUpiPopup();

        mbkCommonControls.handleMagicPopup();


        // Assert the wallet balances
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedAfter = Double.valueOf(walletBalance.get("Money Added")) * 100;

        Double expectedTotalBalance = totalBalanceBefore - Double.valueOf(amount) * 100;
        Double expectedMoneyAdded = moneyAddedBefore - Double.valueOf(amount) * 100;


        p2MScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);
        p2MScreen.verifyEqualsExtentReport(moneyAddedAfter.toString(), expectedMoneyAdded.toString(), "Actual : " + moneyAddedAfter.toString() + " | Expected : " + expectedMoneyAdded.toString(), true, "Verify moneyAdded", directoryName, screenName);


    }
}