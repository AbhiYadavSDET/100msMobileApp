package IntegrationTests.Ola;

import IntegrationTests.Screens.OlaScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class OlaHelper extends OlaHelperBase {
    OlaScreen olaScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    Reporter reporter = new Reporter();
    Map<String, String> walletBalance = new HashMap<>();


    public OlaHelper(AndroidDriver driver) throws IOException {
        olaScreen = new OlaScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);


    }


    @Override
    public void olaBook(String to, String passengerName, String directoryName, String screenName) throws InterruptedException, IOException {
        int testStepCount = 0;
        String categoryNumber = "2";


        // Fetch the wallet balance before
        walletBalance = mbkCommonControls.getBalance(directoryName, screenName, testStepCount);
        Double totalBalanceBefore = Double.valueOf(walletBalance.get("Available Balance")) * 100;
        Double moneyAddedBefore = Double.valueOf(walletBalance.get("Money Added")) * 100;

        // Swipe the homescreen up
        Log.info("SWIPE", "UP");
        touchAction.press(400, 1000).waitAction(Duration.ofMillis(1500)).moveTo(400, 200).release().perform();


        // Select the Ola cabs option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "OLA Icon from Homescreen"), "");
        olaScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Ola Cabs']"));


        //Allow the location permission to the app
        Log.info("ALLOW", "Location Permission");
        olaScreen.selectElement(By.xpath("//*[@text='Go to Settings']"));
        olaScreen.selectElement(By.xpath("//*/android.widget.TextView[@text='Permissions']"));
        olaScreen.selectElement(By.xpath("//*/android.widget.TextView[@text='Location']"));
        Thread.sleep(2000);
        olaScreen.navigateBack();
        Thread.sleep(2000);
        olaScreen.navigateBack();
        Thread.sleep(5000);

        // If the device location is not given
        if (olaScreen.isElementPresent(By.id("android:id/parentPanel"))) {
            olaScreen.selectElement(By.id("android:id/button1"));
        }

        Thread.sleep(5000);

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Drop location"), "");
        olaScreen.selectElement(By.id("txt_drop_location"));

        //Enter the drop location
        olaScreen.sendText(By.id("search_address"), to);
        Thread.sleep(5000);

        // select the location
        olaScreen.selectElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout"));
        Thread.sleep(10000);

        // Select the cab category
        int noOfCabCategory = olaScreen.findElements(By.id("tx_cab_type")).size();
        Log.info("noOfCabCategory : " + noOfCabCategory);


        if (noOfCabCategory > 0) {
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Cab Category"), "");

            // Display the category names
            for (int i = 1; i < noOfCabCategory; i++) {
                Log.info(olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=" + i + "]/android.widget.TextView")).getText());
            }

            // Fetch the 2nd category details
            String cabCategoryName = olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='" + categoryNumber + "']/android.widget.TextView")).getText();
            String cabTime = olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index = '" + categoryNumber + "']/android.widget.RelativeLayout[1]/android.widget.TextView")).getText();
            String cabCharge = olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index = '" + categoryNumber + "']/android.widget.RelativeLayout[2]/android.widget.TextView")).getText();

            if (cabCategoryName.equalsIgnoreCase("Auto")) {
                categoryNumber = "3";
                cabCategoryName = olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=" + categoryNumber + "]/android.widget.TextView")).getText();
                cabTime = olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index = '" + categoryNumber + "']/android.widget.RelativeLayout[1]/android.widget.TextView")).getText();
                cabCharge = olaScreen.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index = '" + categoryNumber + "']/android.widget.RelativeLayout[2]/android.widget.TextView")).getText();

                Log.info("cabCategoryName : " + cabCategoryName + " | " + "cabTime : " + cabTime + " | " + "cabCharge : " + cabCharge);
                olaScreen.selectElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=" + categoryNumber + "]/android.widget.TextView"));


            } else {
                Log.info("cabCategoryName : " + cabCategoryName + " | " + "cabTime : " + cabTime + " | " + "cabCharge : " + cabCharge);
                olaScreen.selectElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index=" + categoryNumber + "]/android.widget.TextView"));

            }


            // Enter the Ride now CTA
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Ride Now CTA"), "");
            olaScreen.selectElement(By.id("btn_ride_now"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Proceed CTA"), "");
            olaScreen.selectElement(By.id("confirm_pay_btn"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Confirm CTA"), "");
            olaScreen.selectElement(By.id("primary_button"));


            // Handle the security PIN
            mbkCommonControls.handleSecurityPin("123456");

            Thread.sleep(15000);


            // Fetch the values on the Success screen
            //olaScreen.waitForVisibility(By.id("tx_otp"));

            // Take screen shot of the success Page
            olaScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "OLA Success screen"), directoryName, screenName);

          /*  String otp = olaScreen.getText(By.id("tx_otp"));
            String category = olaScreen.getText(By.id("tx_cab_category"));
            String driver = olaScreen.getText(By.id("tx_driver_name"));
            String cabNo = olaScreen.getText(By.id("tx_cabs_number")) + olaScreen.getText(By.id("tx_cabs_number_end"));*/

            //reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("DETAILS", otp + " " + driver + " " + category + " " + cabNo), "");

            olaScreen.selectElement(By.id("com.mobikwik_new:id/mkab_icon_1"));

            Log.info("CANCEL", "Current Booking");

            mbkCommonControls.handleUpiPopup();
            mbkCommonControls.handleMagicPopup();


            // Select the ola Icon from the Home-screen
            olaScreen.selectElement(By.xpath("//android.widget.TextView[@text = 'Ola Cabs']"));


            if (olaScreen.isElementPresent(By.id("cancel_ride_btn"))) {
                Log.info("Cancelling the ride");

                //Click on the cancel button
                olaScreen.selectElement(By.id("cancel_ride_btn"));

                // select the reason for cancellation
                olaScreen.selectElement(By.xpath("//*[@text='My reason is not listed']"));

                olaScreen.selectElement(By.id("cancel_ride_btn"));

                // return to the home-screen
                olaScreen.selectElement(By.id("back_to_home_btn"));


            } else {
                Log.info("No rides available for cancellation");
            }


        } else

        {
            Log.info("No cabs available");
            reporter.extentReportDisplay("SKIPSS", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Cab Category"), olaScreen.screenCaptureExtentReport(directoryName, screenName));
        }

    }

    @Override
    public void olaCancel(String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int ssCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);

        // Select the ola Icon from the Home-screen
        olaScreen.selectElement(By.name("Ola Cabs"));


        if (olaScreen.isElementPresent(By.xpath("//*[@text='Cancel Ride']"))) {
            Log.info("Cancelling the ride");

            //Click on the cancel button
            olaScreen.selectElement(By.xpath("//*[@text='Cancel Ride']"));

            // select the reason for cancellation
            olaScreen.selectElement(By.xpath("//*[@text='My reason is not listed']"));

            olaScreen.selectElement(By.xpath("//*[@text='Cancel']"));

            // return to the home-screen
            olaScreen.selectElement(By.xpath("//*[@text='Back to home']"));


        } else {
            Log.info("No rides available for cancellation");
        }


    }
}