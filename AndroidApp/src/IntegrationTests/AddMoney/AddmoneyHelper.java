package IntegrationTests.AddMoney;

import IntegrationTests.Screens.AddmoneyScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class AddmoneyHelper extends AddmoneyHelperBase {
    AddmoneyScreen addmoneyScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    Reporter reporter = new Reporter();
    Map<String, String> walletBalance = new HashMap<>();


    public AddmoneyHelper(AndroidDriver driver) throws IOException {
        addmoneyScreen = new AddmoneyScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);

    }


    @Override
    public void addmoneyNetbanking(String bankName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;


        try {


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Add money icon from Homescreen"), "");
            addmoneyScreen.selectElement(By.id("tx_add_money"));


            // Enter the amount
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
            addmoneyScreen.selectElement(By.id("edit_text_mket"));
            addmoneyScreen.waitForVisibility(By.id("edit_text_mket"));
            addmoneyScreen.findElement(By.id("edit_text_mket")).sendKeys("5");
            addmoneyScreen.navigateBack();

            Log.info("SELECT", "Continue CTA");
            addmoneyScreen.selectElement(By.id("btnContinue"));

            addmoneyScreen.waitForVisibility(By.xpath("//*[@text = 'Select Payment Mode']"));
            Log.info("SWIPE", "UP");
            touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(400, 400)).release().perform();


            // Secure payment screen
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Netbanking option"), "");
            addmoneyScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Net Banking']"));


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", bankName), "");
            addmoneyScreen.selectElement(By.xpath("//android.widget.TextView[@text = '" + bankName + "']"));


            Thread.sleep(10000);

            addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Bank screen"), directoryName, screenName);

            // Bank page
            Log.info("Select", "[<-] button");
            addmoneyScreen.selectElement(By.xpath("//*[@text='w']"));

            try {
                addmoneyScreen.selectElement(By.id("horizontal_button_2"));
            } catch (TimeoutException e) {
                String s = addmoneyScreen.screenCaptureExtentReport(directoryName, screenName);
                Log.info(e.getMessage());
                reporter.extentReportDisplay("SKIPSS", "EXCEPTION in STEP " + testStepCount, s, e.getMessage());
            }

            mbkCommonControls.handleUpiPopup();

            mbkCommonControls.handleMagicPopup();

        } catch (Exception e) {
            String s = addmoneyScreen.screenCaptureExtentReport(directoryName, screenName);
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "EXCEPTION in STEP " + testStepCount, s, e.getMessage());
            throw e;
        }

    }

    @Override
    public void addmoneyNewCard(String amount, String cardNo, String expiry, String cvv, String password, String expectedSuccessMessage, String directoryName, String screenName) throws InterruptedException, IOException {


        int testStepCount = 0;

        try {

            // Fetch the wallet balance before
            walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
            Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
            Double moneyAddedBefore = Double.valueOf(walletBalance.get("Money Added")) * 100;


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Add money icon from Homescreen"), "");
            addmoneyScreen.selectElement(By.id("tx_add_money"));


            // Enter the amount
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
            addmoneyScreen.selectElement(By.id("edit_text_mket"));
            addmoneyScreen.waitForVisibility(By.id("edit_text_mket"));
            addmoneyScreen.findElement(By.id("edit_text_mket")).sendKeys(amount);
            addmoneyScreen.navigateBack();

            Log.info("SELECT", "Continue CTA");
            addmoneyScreen.selectElement(By.id("btnContinue"));

            addmoneyScreen.waitForVisibility(By.xpath("//*[@text = 'Select Payment Mode']"));
            Log.info("SWIPE", "UP");
            touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500))).moveTo(PointOption.point(400, 400)).release().perform();


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "New Debit/Credit Card option"), "");
            addmoneyScreen.selectElement(By.xpath("//android.widget.TextView[@text='New Debit/Credit Card']"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Card Details"), "");
            addmoneyScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'Card Number']/following::android.widget.EditText[1]"), cardNo);
            addmoneyScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'Card Expiry']/following::android.widget.EditText[1]"), expiry);
            addmoneyScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]"), cvv);

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Pay Now CTA"), "");
            addmoneyScreen.selectElement(By.id("btn_add_money"));


            addmoneyScreen.waitForVisibility(By.xpath("//*[@text='Continue']"));
            addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Payment screen 1"), directoryName, screenName);
            addmoneyScreen.selectElement(By.xpath("//*[@text='Continue']"));

            addmoneyScreen.waitForVisibility(By.xpath("//android.widget.EditText"));
            addmoneyScreen.findElement(By.xpath("//android.widget.EditText")).sendKeys(password);


            addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Payment screen 2"), directoryName, screenName);
            addmoneyScreen.selectElement(By.xpath("//*[@text='Submit']"));

            Thread.sleep(10000);


            Log.info("ASSERT", "Details");
            String actualSuccessMessage = addmoneyScreen.findElement(By.id("title_text")).getText();


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + Log.info("ASSERT", "Details"), "");
            addmoneyScreen.verifyEqualsExtentReport(actualSuccessMessage, expectedSuccessMessage, "successMessage | Actual : " + actualSuccessMessage + " | Expected : " + expectedSuccessMessage, true, "Verify successMessage", directoryName, screenName);


            addmoneyScreen.selectElement(By.id("primary_button"));

            mbkCommonControls.handleMagicPopup();
            mbkCommonControls.handleUpiPopup();

            // Fetch the wallet balance After
            walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
            Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;
            Double moneyAddedAfter = Double.valueOf(walletBalance.get("Money Added")) * 100;


            Double expectedMoneyAdded = moneyAddedBefore + Double.valueOf(amount) * 100;
            Double expectedTotalBalance = totalBalanceBefore + Double.valueOf(amount) * 100;


            addmoneyScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Money Added | Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);
            addmoneyScreen.verifyEqualsExtentReport(moneyAddedAfter.toString(), expectedMoneyAdded.toString(), "Total Balance | Actual : " + moneyAddedAfter.toString() + " | Expected : " + expectedMoneyAdded.toString(), true, "Verify moneyAdded", directoryName, screenName);

        } catch (Exception e) {
            String s = addmoneyScreen.screenCaptureExtentReport(directoryName, screenName);
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "EXCEPTION in STEP " + testStepCount, s, e.getMessage());
            throw e;

        }

    }

    public void addmoneyForImps(String amount, String cardNo, String expiry, String cvv, String password, String directoryName, String screenName) throws InterruptedException, IOException {

        int testStepCount = 0;


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Add money icon from Homescreen"), "");
        addmoneyScreen.selectElement(By.id("tx_add_money"));


        // Enter the amount
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
        addmoneyScreen.selectElement(By.id("edit_text_mket"));
        addmoneyScreen.waitForVisibility(By.id("edit_text_mket"));
        addmoneyScreen.findElement(By.id("edit_text_mket")).sendKeys(amount);
        addmoneyScreen.navigateBack();

        Log.info("SELECT", "Continue CTA");
        addmoneyScreen.selectElement(By.id("btnContinue"));

        addmoneyScreen.waitForVisibility(By.xpath("//*[@text = 'Select Payment Mode']"));
        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 400)).release().perform();


        // Secure payment screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Saved Card option"), "");
        Log.info("SWIPE", "LESS");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(500,600)).release().perform();

        addmoneyScreen.selectElement(By.xpath("//android.widget.TextView[@text = '4363 XXXX XXXX 4460']"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Card Details"), "");
        addmoneyScreen.selectElement(By.xpath("//*/android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]"));
        addmoneyScreen.findElement(By.xpath("//*/android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]")).sendKeys(cvv);


        addmoneyScreen.selectElement(By.id("btn_add_money"));


        addmoneyScreen.waitForVisibility(By.xpath("//*[@text='Continue']"));
        addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Payment screen 1"), directoryName, screenName);
        addmoneyScreen.selectElement(By.xpath("//*[@text='Continue']"));

        addmoneyScreen.waitForVisibility(By.xpath("//android.widget.EditText"));
        addmoneyScreen.findElement(By.xpath("//android.widget.EditText")).sendKeys(password);


        addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Payment screen 2"), directoryName, screenName);
        addmoneyScreen.selectElement(By.xpath("//*[@text='Submit']"));

        Thread.sleep(10000);

        addmoneyScreen.selectElement(By.id("primary_button"));

        mbkCommonControls.handleMagicPopup();
        mbkCommonControls.handleUpiPopup();


    }


    @Override
    public void addmoneySavedCardPromocode(String amount, String cardNo, String cvv, String password, String expectedSuccessMessage, boolean promocodeFlag, String promocode, String supercashToBeAdded, String directoryName, String screenName) throws InterruptedException, IOException {
        int testStepCount = 0;

        try {

            // Fetch the wallet balance before
            walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
            Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
            Double moneyAddedBefore = Double.valueOf(walletBalance.get("Money Added")) * 100;
            Double supercashBefore = Double.valueOf(walletBalance.get("SuperCash")) * 100;


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Add money icon from Homescreen"), "");
            addmoneyScreen.selectElement(By.id("tx_add_money"));


            // Enter the amount
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Amount"), "");
            addmoneyScreen.selectElement(By.id("edit_text_mket"));
            addmoneyScreen.waitForVisibility(By.id("edit_text_mket"));
            addmoneyScreen.findElement(By.id("edit_text_mket")).sendKeys(amount);
            addmoneyScreen.navigateBack();

            Log.info("SELECT", "Continue CTA");
            addmoneyScreen.selectElement(By.id("btnContinue"));

            addmoneyScreen.waitForVisibility(By.xpath("//*[@text = 'Select Payment Mode']"));


            // Secure payment screen
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Saved Card option"), "");
            Log.info("SWIPE", "LESS");
            touchAction.press(PointOption.point(500, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(500,600)).release().perform();

            addmoneyScreen.selectElement(By.xpath("//android.widget.TextView[@text = '4363 XXXX XXXX 4460']"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Card Details"), "");
            addmoneyScreen.selectElement(By.xpath("//*/android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]"));
            addmoneyScreen.findElement(By.xpath("//*/android.widget.TextView[@text = 'CVV']/following::android.widget.EditText[1]")).sendKeys(cvv);

            // Apply a promo-code
            if (promocodeFlag) {
                reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("APPLY", "Promocode : " + promocode), "");
                mbkCommonControls.applyPromocodeAddMoney(promocode);
                Thread.sleep(3000);

                String promoCodeSuccessText = addmoneyScreen.findElement(By.id("txt_promo_code")).getText();
                addmoneyScreen.verifyEqualsExtentReport(promoCodeSuccessText, promocode.toUpperCase() + " Applied!", "Promocode success Message | Actual : " + promoCodeSuccessText + " | Expected : " + promocode + " Applied!", true, "Verify totalBalance", directoryName, screenName);

            }


            addmoneyScreen.selectElement(By.id("btn_add_money"));


            addmoneyScreen.waitForVisibility(By.xpath("//*[@text='Continue']"));
            addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Payment screen 1"), directoryName, screenName);
            addmoneyScreen.selectElement(By.xpath("//*[@text='Continue']"));

            addmoneyScreen.waitForVisibility(By.xpath("//android.widget.EditText"));
            addmoneyScreen.findElement(By.xpath("//android.widget.EditText")).sendKeys(password);


            addmoneyScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("VERIFY", "Payment screen 2"), directoryName, screenName);
            addmoneyScreen.selectElement(By.xpath("//*[@text='Submit']"));

            Thread.sleep(10000);


            //Log.info("ASSERT", "Details");
            String actualSuccessMessage = addmoneyScreen.findElement(By.id("title_text")).getText();


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + Log.info("ASSERT", "Details"), "");
            addmoneyScreen.verifyEqualsExtentReport(actualSuccessMessage, expectedSuccessMessage, "successMessage | Actual : " + actualSuccessMessage + " | Expected : " + expectedSuccessMessage, true, "Verify successMessage", directoryName, screenName);


            addmoneyScreen.selectElement(By.id("primary_button"));


            mbkCommonControls.handleMagicPopup();
            mbkCommonControls.handleUpiPopup();

            // Fetch the wallet balance After
            walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
            Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;
            Double moneyAddedAfter = Double.valueOf(walletBalance.get("Money Added")) * 100;
            Double supercashBalanceAfter = Double.valueOf(walletBalance.get("SuperCash")) * 100;


            Double expectedMoneyAdded = moneyAddedBefore + Double.valueOf(amount) * 100;
            Double expectedTotalBalance = totalBalanceBefore + Double.valueOf(amount) * 100;
            Double expectedSupercashBalance = supercashBefore + Double.valueOf(supercashToBeAdded) * 100;


            addmoneyScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Money Added | Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);
            addmoneyScreen.verifyEqualsExtentReport(moneyAddedAfter.toString(), expectedMoneyAdded.toString(), "Total Balance | Actual : " + moneyAddedAfter.toString() + " | Expected : " + expectedMoneyAdded.toString(), true, "Verify moneyAdded", directoryName, screenName);
            addmoneyScreen.verifyEqualsExtentReport(supercashBalanceAfter.toString(), expectedSupercashBalance.toString(), "Total Balance | Actual : " + supercashBalanceAfter.toString() + " | Expected : " + expectedSupercashBalance.toString(), true, "Verify supercash", directoryName, screenName);

        } catch (Exception e) {
            String s = addmoneyScreen.screenCaptureExtentReport(directoryName, screenName);
            Log.info(e.getMessage());
            reporter.extentReportDisplay("SKIPSS", "EXCEPTION in STEP " + testStepCount, s, e.getMessage());
            throw e;
        }
    }


}