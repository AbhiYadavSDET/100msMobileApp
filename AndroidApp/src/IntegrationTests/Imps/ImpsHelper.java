package IntegrationTests.Imps;

import IntegrationTests.AddMoney.AddmoneyHelper;
import IntegrationTests.Screens.ImpsScreen;
import UITestFramework.Api.ApiCommonControls;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;

/**
 * contains all methods to test Add Money Flow
 */
public class ImpsHelper extends ImpsHelperBase {
    ImpsScreen impsScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    ApiCommonControls apiCommonControls;
    String otpMid = "MBK5778";
    String serviceURL = "https://wallet.mobikwik.com/getotpandtokendata/";
    String serviceCode = "0";
    HashMap<String, String> apiOtp;
    HashMap<String, String> walletBalance;
    AddmoneyHelper addmoneyHelper;
    Reporter reporter;


    public ImpsHelper(AndroidDriver driver) throws IOException {
        impsScreen = new ImpsScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        apiCommonControls = new ApiCommonControls();
        apiOtp = new HashMap<>();
        walletBalance = new HashMap<>();
        addmoneyHelper = new AddmoneyHelper(driver);
        reporter = new Reporter();


    }


    @Override
    public void impsTransfer(String bankAccountNo, String holderName, String ifsc, String amount, String userName, String otpCell, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        int amountToBeAdded = Integer.valueOf("0");


        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedBefore = Double.valueOf(walletBalance.get("Money Added")) * 100;


        Log.info("VALIDATE", "Wallet Balance is sufficient");
        if (Double.parseDouble(walletBalance.get("Money Added")) < Double.parseDouble(amount)) {
            amountToBeAdded = (int) Math.ceil(Double.parseDouble(amount) - Double.parseDouble(walletBalance.get("Money Added")));
            Log.info("Add Money", String.valueOf(amountToBeAdded));
            addmoneyHelper.addmoneyForImps(String.valueOf(amountToBeAdded), "4363931800224460", "12/22", "239", "p@324008", directoryName, screenName);
        }

        // Select the Transfer option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Transfer button from Homescreen"), "");
        impsScreen.selectElement(By.id("btn_p2p"));


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "IMPS Button"), "");
        impsScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'IMPS']"));

        //Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Details of the Bank Account"), "");
        impsScreen.waitForVisibility(By.id("beneficiary_name"));
        impsScreen.findElement(By.id("beneficiary_name")).sendKeys(holderName);

        impsScreen.waitForVisibility(By.id("account_number"));
        impsScreen.findElement(By.id("account_number")).sendKeys(bankAccountNo);

        impsScreen.waitForVisibility(By.id("ifsc_code"));
        impsScreen.findElement(By.id("ifsc_code")).sendKeys(ifsc);

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        impsScreen.selectElement(By.id("continue_button"));


        //Enter the amount
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        impsScreen.waitForVisibility(By.id("edt_txt_transfer_amount"));
        impsScreen.findElement(By.id("edt_txt_transfer_amount")).sendKeys(amount);
        Thread.sleep(3000);


        String processingFee = impsScreen.findElement(By.id("txt_processing_fee")).getText().replace("X", "").replace("₹ ", "").replace(",", "");
        Log.info("Processing Fee", processingFee);


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        impsScreen.selectElement(By.id("btn_p2p_action"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Confirm CTA"), "");
        impsScreen.selectElement(By.id("btn_p2p_action"));

        mbkCommonControls.handleSecurityPin("123456");

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "OTP"), "");
        Log.info("Input", "OTP received");
        Thread.sleep(3000);
        apiOtp = apiCommonControls.getOTPfromDB(userName, otpCell, otpMid, serviceURL, serviceCode);

        impsScreen.waitForVisibility(By.id("otp_field"));
        Log.info("OTP", apiOtp.get("otp"));
        impsScreen.findElement(By.id("otp_field")).sendKeys(apiOtp.get("otp"));


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Submit OTP CTA"), "");
        impsScreen.selectElement(By.id("continue_btn"));

        Thread.sleep(10000);

        // Take screen shot of the success Page
        impsScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "IMPS Success screen"), directoryName, screenName);


        // Assert the details on the success page
        String successPageStatus = impsScreen.getText(By.id("base_title"));
        String successPageAccountNumber = impsScreen.findElement(By.id("txt_cn_value")).getText();
        Double successPageAmountPaid = Double.valueOf(impsScreen.findElement(By.id("txt_amount_value")).getText().replace("X", "").replace("₹ ", "").replace(",", "")) * 100;

        impsScreen.verifyEqualsExtentReport(successPageStatus, "Money sent successfully", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Money sent successfully", true, "Verify successPageStatus", directoryName, screenName);
        impsScreen.verifyEqualsExtentReport(successPageAccountNumber, bankAccountNo, "Actual : " + successPageAccountNumber + " | Expected : " + bankAccountNo, true, "Verify successPageAccountNumber", directoryName, screenName);
        impsScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid.toString() + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);


        Log.info("SELECT", "[X] button");
        impsScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleRatingsPopUp();

        if (impsScreen.isElementPresent(By.id("base_icon_close"))) {
            impsScreen.selectElement(By.id("base_icon_close"));

        }

        mbkCommonControls.handleMagicPopup();
        mbkCommonControls.handleUpiPopup();

        // Assert the wallet balances
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.parseDouble(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedAfter = Double.parseDouble(walletBalance.get("Money Added")) * 100;

        Log.info("totalBalanceAfter", totalBalanceAfter.toString());
        Log.info("moneyAddedAfter", moneyAddedAfter.toString());


        Double expectedTotalBalance = totalBalanceBefore + Double.valueOf(amountToBeAdded) * 100 - Double.valueOf(amount) * 100 - Double.valueOf(processingFee) * 100;
        Double expectedMoneyAdded = moneyAddedBefore + Double.valueOf(amountToBeAdded) * 100 - Double.valueOf(amount) * 100 - Double.valueOf(processingFee) * 100;

        Log.info("expectedTotalBalance", expectedTotalBalance.toString());
        Log.info("expectedMoneyAdded", expectedMoneyAdded.toString());


        impsScreen.verifyEqualsExtentReport(String.valueOf(totalBalanceAfter), String.valueOf(expectedTotalBalance), "Actual : " + String.valueOf(totalBalanceAfter) + " | Expected : " + String.valueOf(expectedTotalBalance), true, "Verify totalBalance", directoryName, screenName);
        impsScreen.verifyEqualsExtentReport(String.valueOf(moneyAddedAfter), String.valueOf(expectedMoneyAdded), "Actual : " + String.valueOf(moneyAddedAfter) + " | Expected : " + String.valueOf(expectedMoneyAdded), true, "Verify moneyAdded", directoryName, screenName);

    }
}