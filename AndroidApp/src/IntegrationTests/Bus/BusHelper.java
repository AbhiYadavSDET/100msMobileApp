package IntegrationTests.Bus;

import IntegrationTests.Screens.BusScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class BusHelper extends BusHelperBase {
    BusScreen busScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    Reporter reporter;
    Map<String, String> walletBalance;


    public BusHelper(AndroidDriver driver) throws IOException {
        busScreen = new BusScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        reporter = new Reporter();
        walletBalance = new HashMap();


    }


    @Override
    public void busBook(String from, String to, String passengerName, String age, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {
        int testStepCount = 0;


        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedBefore = Double.valueOf(walletBalance.get("Money Added")) * 100;

        // Swipe the homescreen up
        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();


        // Select the Bus option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "OLA Icon from Homescreen"), "");
        busScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Bus']"));

        // Enter from/to
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "From/To details"), "");
        busScreen.selectElement(By.id("txt_from"));

        busScreen.waitForVisibility(By.id("search_filter_field"));
        busScreen.findElement(By.id("search_filter_field")).sendKeys(from);

        Thread.sleep(3000);
        busScreen.selectElement(By.id("txt_title"));

        busScreen.waitForVisibility(By.id("search_filter_field"));
        busScreen.findElement(By.id("search_filter_field")).sendKeys(to);
        Thread.sleep(3000);
        busScreen.selectElement(By.id("txt_title"));


        // Select the date
        String currentDay = mbkCommonControls.getCurrentDay();
        if (Integer.parseInt(currentDay) < 10) {
            Log.info("SELECT", "Day = 13");
            busScreen.selectElement(By.xpath("//*[@text='13']"));
        } else if (Integer.parseInt(currentDay) < 20) {
            Log.info("SELECT", "Day = 23");
            busScreen.selectElement(By.xpath("//*[@text='23']"));
        } else {
            Log.info("SELECT", "Day = 3");
            busScreen.selectElement(By.id("com.mobikwik_new:id/rightButton"));
            busScreen.selectElement(By.xpath("//*[@text='3']"));
        }

        Thread.sleep(5000);


        // Scroll in case the operator is not visible
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Bus operator : " + "Das & Das Travels"), "");
        Log.info("Scrolling down to search the operator");

        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();

        Thread.sleep(5000);

        busScreen.findElements(By.xpath("//android.widget.TextView[@text = 'Das & Das Travels']")).get(0).click();

        Thread.sleep(3000);

        // select the number of travellers
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "No of PAX"), "");
        busScreen.selectElement(By.xpath("//*/android.widget.TextView[@text = 'How many passengers traveling?']/following::android.widget.TextView[1]"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        busScreen.selectElement(By.id("continue_button"));

        //select the boarding/drop points
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Boarding/Drop Points"), "");
        busScreen.selectElement(By.id("txt_bus_stop_name"));
        busScreen.selectElement(By.id("txt_bus_stop_name"));


        // Enter the passenger details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "PAX Details"), "");
        List<AndroidElement> paxdetails = busScreen.findElements(By.id("edit_text_mket"));

        paxdetails.get(0).clear();
        paxdetails.get(0).sendKeys(passengerName);

        paxdetails.get(1).sendKeys(age);

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        busScreen.selectElement(By.id("proceed_button"));

        // Fetch the fare of the Bus
        busScreen.waitForVisibility(By.id("total_amount_value"));
        Double amountToBePaid = Double.valueOf(busScreen.findElement(By.id("total_amount_value")).getText().replace("“ ", "").replace("₹ ", "").replace(",", "")) * 100;
        Log.info(amountToBePaid.toString());

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Pay CTA"), "");
        busScreen.selectElement(By.id("pay_btn"));


        //Handle the security PIN
        mbkCommonControls.handleSecurityPin("123456");

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Book Now CTA"), "");
        busScreen.selectElement(By.id("primary_button"));

        Thread.sleep(10000);


        // Take screen shot of the succes Page
        busScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "Bus success screen"), directoryName, screenName);


        // Verify the values on the Success screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + Log.info("ASSERT", "Details"), "");

        String successPageStatus = busScreen.getText(By.id("base_title"));
        String successPageOperator = busScreen.getText(By.id("operator_name"));
        String successPageFrom = busScreen.getText(By.id("from_city"));
        String successPageTo = busScreen.getText(By.id("to_city"));

        Log.info("Scrolling down to search the pax name");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();


        String successPagePassengerName = busScreen.getText(By.id("txt_passenger_name"));


        busScreen.verifyEqualsExtentReport(successPageStatus, "Payment Successful", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Payment Successful", true, "Verify successPageStatus", directoryName, screenName);
        busScreen.verifyEqualsExtentReport(successPageOperator, "Das & Das Travels", "successPageOperator | Actual : " + successPageOperator + " | Expected : " + "Das & Das Travels", true, "Verify successPageOperator", directoryName, screenName);
        busScreen.verifyEqualsExtentReport(successPageFrom, "Bhubaneswar", "successPageFrom | Actual : " + successPageFrom + " | Expected : " + "Bhubaneswar", true, "Verify successPageFrom", directoryName, screenName);
        busScreen.verifyEqualsExtentReport(successPageTo, "Baripada", "successPageTo | Actual : " + successPageTo + " | Expected : " + "Baripada", true, "Verify successPageTo", directoryName, screenName);
        busScreen.verifyEqualsExtentReport(successPagePassengerName, "IOS Automation", "successPagePassengerName | Actual : " + successPagePassengerName + " | Expected : " + "IOS Automation", true, "Verify successPagePassengerName", directoryName, screenName);

        touchAction.press(PointOption.point(400, 200)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 1000)).release().perform();

        Thread.sleep(3000);


        // Reach back the HOme-screen
        busScreen.selectElement(By.id("base_icon_close"));
        mbkPermissions.handleNPSScreen("directoryName", "screenName", testStepCount);
        busScreen.selectElement(By.xpath("//*[@text='w']"));
        Thread.sleep(3000);


        touchAction.press(PointOption.point(400, 200)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 1000)).release().perform();

        Thread.sleep(3000);


        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceAfter = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedAfter = Double.valueOf(walletBalance.get("Money Added")) * 100;

        Double expectedTotalBalance = totalBalanceBefore - amountToBePaid;
        Double expectedMoneyAddedBalance = moneyAddedBefore - amountToBePaid;

        busScreen.verifyEqualsExtentReport(totalBalanceAfter.toString(), expectedTotalBalance.toString(), "Total Balance | Actual : " + totalBalanceAfter.toString() + " | Expected : " + expectedTotalBalance.toString(), true, "Verify totalBalance", directoryName, screenName);


        busCancel(directoryName, screenName);

    }

    @Override
    public void busCancel(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        String amountToBeRefunded = "313.50";


        // Swipe the homescreen up
        Log.info("SWIPE", "UP");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();


        // Select the Bus option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Bus Icon from Homescreen"), "");
        busScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Bus']"));

        // Goto My-rides section
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "My Rides button"), "");
        busScreen.selectElement(By.id("textActionButton"));
        Thread.sleep(3000);

        // select the booking to be cancelled
        if (busScreen.findElements(By.id("booked_ticket_row_container")).size() < 1) {
            Log.info("There are no existing bookings");
            reporter.extentReportDisplay("SKIPSS", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "The booking to be cancelled | Error : OOPS, No Previous booking found"), busScreen.screenCaptureExtentReport(directoryName, screenName));
        } else {

            Thread.sleep(3000);
            Log.info("Test");
            if (true) {

                //if (busScreen.isElementPresent(By.xpath("//*/android.view.ViewGroup[@index = '1']/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView[@text='Upcoming Journeys']"))) {
                reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "The booking to be cancelled"), "");
                busScreen.selectElement(By.id("com.mobikwik_new:id/booked_ticket_row_container"));

                // Cancel the booking
                Thread.sleep(2000);
                touchAction.press(PointOption.point(200, 600)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();


                reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Cancel Ticket CTA"), "");
                busScreen.selectElement(By.id("cancel_button"));

                reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Cancel Complete Ticket CTA"), "");
                busScreen.selectElement(By.id("cancel_complete"));

                busScreen.selectElement(By.id("primary_button"));


                //Verify the values on the Success screen
                reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | ASSERT       | Details", "");

                String successPageStatus = busScreen.getText(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
                Double actualAmountToBeRefunded = Double.valueOf(busScreen.findElement(By.id("cancel_refund")).getText().replace("X", "").replace("₹ ", "").replace(",", "")) * 100;
                touchAction.press(PointOption.point(400, 400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();

                String actualNoteText = busScreen.getText(By.id("suceess_msg"));


                busScreen.verifyEqualsExtentReport(successPageStatus, "Your Ticket has been Cancelled", "successPageStatus | Actual : " + successPageStatus + " | Expected : " + "Your Ticket has been Cancelled", true, "Verify successPageStatus", directoryName, screenName);
                busScreen.verifyEqualsExtentReport(actualAmountToBeRefunded.toString(), "31350.0", "actualAmountToBeRefunded | Actual : " + actualAmountToBeRefunded.toString() + " | Expected : " + "31350.0", true, "Verify actualAmountToBeRefunded", directoryName, screenName);
                busScreen.verifyEqualsExtentReport(actualNoteText, "Refund of ₹ 313.50 has been successfully done in your wallet", "actualNoteText | Actual : " + actualNoteText + " | Expected : " + "Refund of ₹ 313.50 has been successfully done in your wallet", true, "Verify actualNoteText", directoryName, screenName);


                // return to the Home-screen
                busScreen.selectElement(By.id("home_button"));

                mbkCommonControls.handleUpiPopup();

                mbkCommonControls.handleMagicPopup();
            } else {
                Log.info("There is no upcoming booking");
                reporter.extentReportDisplay("SKIPSS", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "The booking to be cancelled | Error : OOPS, No Upcoming booking found"), busScreen.screenCaptureExtentReport(directoryName, screenName));

            }

        }

    }
}