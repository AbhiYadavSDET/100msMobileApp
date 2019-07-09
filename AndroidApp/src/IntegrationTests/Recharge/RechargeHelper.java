package IntegrationTests.Recharge;

import IntegrationTests.Screens.RechargeScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKCommonControls;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class RechargeHelper extends RechargeHelperBase {
    RechargeScreen rechargeScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    MBKCommonControls mbkCommonControls;
    Map<String, String> walletBalance = new HashMap<>();
    Reporter reporter;
    HomePage homePage;


    public RechargeHelper(AndroidDriver driver) throws IOException {
        rechargeScreen = new RechargeScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new MBKCommonControls(driver);
        reporter = new Reporter();

    }

    public void prepaidRecharge(String cell, String amount, String category, String operator, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        homePage.clickOnCrossButton();

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", testStepCount);

        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;


        // Select the Mobile option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Mobile button from Homescreen"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Mobile']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Mobile']")).click();

        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Phone Calls");


        // Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Mobile Number"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Enter Mobile Number']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Enter Mobile Number']")).sendKeys(cell);


        // Enter the Amount
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        rechargeScreen.selectElement(By.xpath("//*[@text='Enter any amount']"));

        rechargeScreen.waitForVisibility(By.id("amount_field"));
        rechargeScreen.findElement(By.id("amount_field")).sendKeys(amount);


        // Click on the Continue CTA
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Continue']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Continue']")).click();


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Make payment CTA"), "");
        rechargeScreen.selectElement(By.xpath("//*[@text='Make payment']"));

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", testStepCount);


        //handle the security PIN
        mbkCommonControls.handleSecurityPin("123456");

        Thread.sleep(10000);

        mbkCommonControls.handleCTOverlay();

        // Take screen shot of the success Page
        rechargeScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "Recharge Success screen"), directoryName, screenName);


        // Assert the details on the success page
        String successPageStatus = rechargeScreen.findElement(By.id("base_title")).getText().trim();

        List<AndroidElement> successDetails = rechargeScreen.findElements(By.xpath("//*[@resource-id='com.mobikwik_new:id/txt_value']"));
        String successPageConnectionNumber = successDetails.get(0).getText();
        String successPageCategory = successDetails.get(1).getText();
        String successPageOperator = successDetails.get(2).getText();
        Double successPageAmountPaid = Double.valueOf(rechargeScreen.findElement(By.xpath("//*[@resource-id='com.mobikwik_new:id/total_amount_value']")).getText().replace("“ ", "").replace("₹ ", "").replace(",", "")) * 100;

        rechargeScreen.verifyEqualsExtentReport(successPageStatus, "Recharge successful", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Recharge successful", true, "Verify successPageStatus", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageConnectionNumber, cell, "Actual : " + successPageConnectionNumber + " | Expected : " + cell, true, "Verify successPageMerchantName", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageCategory, category, "Actual : " + successPageCategory + " | Expected : " + category, true, "Verify successPageMerchantCode", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageOperator, operator, "Actual : " + successPageOperator + " | Expected : " + operator, true, "Verify successPageAmountPaid", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid.toString() + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);


        rechargeScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleRatingsPopUp();
        //mbkCommonControls.handleNPS();

        rechargeScreen.selectElement(By.id("base_icon_close"));


        //mbkPermissions.handleNPSScreen(directoryName, screenName, testStepCount);


        // Assert the wallet balances
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;


        Double expectedTotalBalance = totalBalanceBefore - Double.valueOf(amount) * 100;


        rechargeScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);


    }

    @Override
    public void creditCardBillPayment(String amount, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        homePage.clickOnCrossButton();


        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;

        // Click on More button
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "More button from Homescreen"), "");
        rechargeScreen.selectElement(By.id("tx_gradient"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Credit card from the list"), "");
        rechargeScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Credit card']"));

        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Phone calls");

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Saved card"), "");
        rechargeScreen.selectElement(By.xpath("//*[@text='4375XXXXXXXX1019']"));


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        rechargeScreen.waitForVisibility(By.id("edit_text_mket"));
        rechargeScreen.findElement(By.id("edit_text_mket")).sendKeys(amount);

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        rechargeScreen.selectElement(By.id("connection_detail_button_recharge"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Make Payment CTA"), "");
        rechargeScreen.selectElement(By.id("cta"));

        mbkCommonControls.handleSecurityPin("123456");


    }

    public void mobilePostpaidSavedConnection(String cell, String amount, String category, String operator, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        homePage.clickOnCrossButton();


        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", testStepCount);

        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;

        // Select the Mobile option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Mobile button from Homescreen"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Mobile']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Mobile']")).click();

        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Phone Calls");

        // Select the Mobile no. from from the saved connection  list
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Saved Connection"), "");
        if (selectSavedConnection(cell)) {


            // Enter the Amount
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
            rechargeScreen.waitForVisibility(By.id("edit_text_mket"));
            rechargeScreen.findElement(By.id("edit_text_mket")).sendKeys(amount);

            // Click on the Continue CTA
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
            rechargeScreen.hideKeyboard();
            rechargeScreen.selectElement(By.id("connection_detail_button_recharge"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Make Payment CTA"), "");
            rechargeScreen.selectElement(By.id("cta"));


            //handle the security PIN
            mbkCommonControls.handleSecurityPin("123456");

            Thread.sleep(10000);
            mbkCommonControls.handleCTOverlay();

            // Take screen shot of the success Page
            rechargeScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "Recharge Success screen"), directoryName, screenName);


            // Verify the values on the Success screen
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + Log.info("ASSERT", "Details"), "");

            // Assert the details on the success page

            String successPageStatus = rechargeScreen.findElement(By.id("base_title")).getText().trim();

            List<AndroidElement> successDetails = rechargeScreen.findElements(By.xpath("//*[@resource-id='com.mobikwik_new:id/txt_value']"));
            String successPageConnectionNumber = successDetails.get(0).getText();
            Double successPageAmountPaid = Double.valueOf(rechargeScreen.findElement(By.xpath("//*[@resource-id='com.mobikwik_new:id/total_amount_value']")).getText().replace("“ ", "").replace("₹ ", "").replace(",", "")) * 100;


            rechargeScreen.verifyEqualsExtentReport(successPageStatus, "Payment successful", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Payment successful", true, "Verify successPageStatus", directoryName, screenName);
            rechargeScreen.verifyEqualsExtentReport(successPageConnectionNumber, cell, "Actual : " + successPageConnectionNumber + " | Expected : " + cell, true, "Verify successPageMerchantName", directoryName, screenName);
            rechargeScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid.toString() + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);


            rechargeScreen.selectElement(By.id("base_icon_close"));

            mbkCommonControls.handleRatingsPopUp();

            rechargeScreen.selectElement(By.id("base_icon_close"));


            mbkCommonControls.handleMagicPopup();


            // Assert the wallet balances
            walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
            Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;


            Double expectedTotalBalance = totalBalanceBefore - Double.valueOf(amount) * 100;


            rechargeScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);

        } else {
            Log.info("FALSE", "Saved Connection : " + cell + "is not present");

        }
    }

    public void bsnlSpecial(String cell, String operator, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;
        homePage.clickOnCrossButton();


        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", testStepCount);

        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;


        // Select the Mobile option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Mobile button from Homescreen"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Mobile']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Mobile']")).click();

        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Phone Calls");


        // Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Mobile Number"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Enter Mobile Number']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Enter Mobile Number']")).sendKeys(cell);

        // Click on See all plans
        rechargeScreen.selectElement(By.id("see_all_plans"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Special Category"), "");
        rechargeScreen.selectElement(By.xpath("//*[@text='Special Offer']"));


        // select the plan
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Plan"), "");
        String amount = rechargeScreen.getText(By.xpath("//android.support.v4.view.ViewPager/android.widget.LinearLayout[@index = '1']/android.widget.ListView//android.widget.Button[1]")).replace("X", "").replace("₹ ", "").replace(",", "");
        rechargeScreen.selectElement(By.xpath("//android.support.v4.view.ViewPager/android.widget.LinearLayout[@index = '1']/android.widget.ListView//android.widget.Button[1]"));


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Make Payment CTA"), "");
        rechargeScreen.selectElement(By.id("cta"));

        //handle the security PIN
        mbkCommonControls.handleSecurityPin("123456");

        Thread.sleep(10000);

        mbkCommonControls.handleCTOverlay();

        // Take screen shot of the success Page
        rechargeScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "Recharge Success screen"), directoryName, screenName);

        // Assert the details on the success page
        String successPageStatus = rechargeScreen.getText(By.id("base_title"));

        List<AndroidElement> successDetails = rechargeScreen.findElements(By.xpath("//*[@resource-id='com.mobikwik_new:id/txt_value']"));

        String successPageConnectionNumber = successDetails.get(0).getText();
        String successPageOperator = successDetails.get(2).getText();
        Double successPageAmountPaid = Double.valueOf(rechargeScreen.findElement(By.xpath("//*[@resource-id='com.mobikwik_new:id/total_amount_value']")).getText().replace("“ ", "").replace("₹ ", "").replace(",", "")) * 100;


        rechargeScreen.verifyEqualsExtentReport(successPageStatus, "Recharge under process", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Recharge under process", true, "Verify successPageStatus", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageConnectionNumber, cell, "Actual : " + successPageConnectionNumber + " | Expected : " + cell, true, "Verify successPageMerchantName", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageOperator, operator, "Actual : " + successPageOperator + " | Expected : " + operator, true, "Verify successPageAmountPaid", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid.toString() + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);


        rechargeScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleRatingsPopUp();

        if (rechargeScreen.isElementPresent(By.id("base_icon_close"))) {
            rechargeScreen.selectElement(By.id("base_icon_close"));

        }

        // Assert the wallet balances
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;


        Double expectedTotalBalance = totalBalanceBefore - Double.valueOf(amount) * 100;


        rechargeScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);


    }


    public void postpaidPaymentWithPromocode(String cell, String amount, boolean promocodeFlag, String promocode, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        homePage.clickOnCrossButton();


        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", testStepCount);

        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;

        // Select the Mobile option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Mobile button from Homescreen"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Mobile']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Mobile']")).click();

        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Phone Calls");

        // Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Mobile Number"), "");
        rechargeScreen.waitForVisibility(By.xpath("//*[@text='Enter Mobile Number']"));
        rechargeScreen.findElement(By.xpath("//*[@text='Enter Mobile Number']")).sendKeys(cell);

        // select the operator/circle
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Operator/Circle"), "");
        rechargeScreen.selectElement(By.xpath("//*[@text='L']"));
        Thread.sleep(3000);

        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 800)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();

        rechargeScreen.selectElement(By.xpath("//*[@text = 'Vodafone']"));
        rechargeScreen.selectElement(By.xpath("//*[@text = 'Delhi/NCR']"));

        // Enter the category
        rechargeScreen.selectElement(By.xpath("//*/android.widget.TextView[@text='Postpaid']"));

        // Enter the Amount
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        rechargeScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'Amount']/following::android.widget.EditText[1]"), amount);


        // Click on the Continue CTA
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        rechargeScreen.selectElement(By.id("recharge_button"));


        if (promocodeFlag) {
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("APPLY", "PromoCode"), "");
            mbkCommonControls.applyPromocodeRecharge(promocode);
        }

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Make Payment CTA"), "");
        rechargeScreen.selectElement(By.id("cta"));


        //handle the security PIN
        mbkCommonControls.handleSecurityPin("123456");

        Thread.sleep(10000);

        mbkCommonControls.handleCTOverlay();

        // Take screen shot of the success Page
        rechargeScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "Recharge Success screen"), directoryName, screenName);


        // Verify the values on the Success screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | ASSERT       | Details", "");

        // Assert the details on the success page
        String successPageStatus = rechargeScreen.findElement(By.id("base_title")).getText().trim();

        List<AndroidElement> successDetails = rechargeScreen.findElements(By.xpath("//*[@resource-id='com.mobikwik_new:id/txt_value']"));
        String successPageConnectionNumber = successDetails.get(0).getText();
        Double successPageAmountPaid = Double.valueOf(rechargeScreen.findElement(By.xpath("//*[@resource-id='com.mobikwik_new:id/total_amount_value']")).getText().replace("“ ", "").replace("₹ ", "").replace(",", "")) * 100;
        String successPagePromoCodeMessage = rechargeScreen.findElement(By.id("txt_promo_result_desc")).getText().trim();

        rechargeScreen.verifyEqualsExtentReport(successPageStatus, "Payment successful", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Payment successful", true, "Verify successPageStatus", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageConnectionNumber, cell, "Actual : " + successPageConnectionNumber + " | Expected : " + cell, true, "Verify successPageMerchantName", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPageAmountPaid.toString(), String.valueOf(Double.valueOf(amount) * 100), "Actual : " + successPageAmountPaid.toString() + " | Expected : " + String.valueOf(Double.valueOf(amount) * 100), true, "Verify successPageAmountPaid", directoryName, screenName);
        rechargeScreen.verifyEqualsExtentReport(successPagePromoCodeMessage, "Congrats! SuperCash worth ₹ 5 will be credited within 48 hours", "Actual : " + successPagePromoCodeMessage + " | Expected : " + "Congrats! SuperCash worth ₹ 5 will be credited within 48 hours", true, "Verify successPagePromoCodeMessage", directoryName, screenName);


        rechargeScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleRatingsPopUp();

        rechargeScreen.selectElement(By.id("base_icon_close"));

        mbkCommonControls.handleMagicPopup();


        // Assert the wallet balances
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;


        Double expectedTotalBalance = totalBalanceBefore - Double.valueOf(amount) * 100;


        rechargeScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);


    }

    public boolean selectSavedConnection(String connectionNo) throws InterruptedException {


        for (int i = 0; i < 6; i++) {
            //if (rechargeScreen.isElementPresent(By.xpath("//*/android.widget.TextView[contains(text()," + connectionNo + ")]"))) {
            if (rechargeScreen.isElementPresent(By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"))) {
                Log.info("SCROLL", "Less");
                touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 800)).release().perform();

                Log.info("SELECT", "Saved Connection");
                rechargeScreen.selectElement(By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"));
                return true;
            } else {
                Log.info("SCROLL", "More");
                touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();

                Thread.sleep(2000);
            }
        }

        return false;
    }


}


