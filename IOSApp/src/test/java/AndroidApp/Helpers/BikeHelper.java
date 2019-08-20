package test.java.AndroidApp.Helpers;

import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.BikeHelperBase;
import test.java.AndroidApp.PageObject.BikesScreen;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * contains all methods to test Add Money Flow
 */
public class BikeHelper extends BikeHelperBase {
    BikesScreen bikeScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    Map<String, String> walletBalance = new HashMap<>();
    Reporter reporter = new Reporter();
    HomePage homePage;


    public BikeHelper(IOSDriver driver) throws IOException {
        bikeScreen = new BikesScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        homePage = new HomePage(driver);

    }


    public void bikeInSufficientBooking(String drivinglic, String mName, String amount, String mobNo, String directoryName, String screenName) throws InterruptedException, IOException, JSONException {

        int testStepCount = 0;
        boolean found = false;
        homePage.clickOnCrossButton();


        Log.info("Home Page");

        // Swipe the homescreen up
        Log.info("SWIPE", "Down");
        touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();

        Thread.sleep(2000);
        homePage.clickMoreServicesIcon();

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Bike Icon"), "");
        bikeScreen.selectElement(By.xpath("//*/android.view.ViewGroup/android.widget.TextView[@text='Bikes']"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Jaipur City"), "");
        bikeScreen.selectElement(By.xpath("//android.widget.TextView[@text='Jaipur']"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "CTA From"), "");
        bikeScreen.selectElement(By.id("com.mobikwik_new:id/btn_confirm"));

        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "CTA To"), "");
        bikeScreen.selectElement(By.id("com.mobikwik_new:id/btn_confirm"));


        if (bikeScreen.isElementPresent(By.xpath("//android.widget.TextView[@text='No Result Found! Please modify search parameters']"))) {
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ERROR", "No Result found"), "");
            bikeScreen.selectElement(By.xpath("//android.widget.Button[@text='OK']"));

        } else {
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "First Bike from the list"), "");
            bikeScreen.selectElement(By.id("com.mobikwik_new:id/iv_bike"));


            // Reach the end of Page
            Log.info("SWIPE", "Down");
            for (int i = 0; i < 3; i++) {
                touchAction.press(PointOption.point(400, 1000)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(400, 200)).release().perform();

            }
            Thread.sleep(5000);

            // Enter the deetyails
            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Details"), "");
            bikeScreen.findElement(By.xpath("//*/android.widget.TextView[@text = 'Enter Full Name']/following::android.widget.EditText[1]")).clear();
            //mbkCommonControls.sendText(By.xpath("//*/android.widget.TextView[@text = 'Enter Full Name']/following::android.widget.EditText[1]"), mName);
            bikeScreen.hideKeyboard();

            bikeScreen.findElement(By.xpath("//android.widget.TextView[@text='Driving Licence No']/following::android.widget.EditText")).clear();
//            mbkCommonControls.sendText(By.xpath("//android.widget.TextView[@text='Driving Licence No']/following::android.widget.EditText"), drivinglic);
            bikeScreen.hideKeyboard();


            bikeScreen.findElement(By.xpath("//android.widget.TextView[@text='Email']/following::android.widget.EditText")).clear();
//            mbkCommonControls.sendText(By.xpath("//android.widget.TextView[@text='Email']/following::android.widget.EditText"), "mobitest313@gmail.com");
            bikeScreen.hideKeyboard();
            Thread.sleep(2000);


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "T & C check box"), "");
            bikeScreen.selectElement(By.id("com.mobikwik_new:id/iconview_checkbox"));

            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
            bikeScreen.selectElement(By.id("com.mobikwik_new:id/btnConfirmButton"));

            // Handle the security PIN
//            mbkCommonControls.handleSecurityPin("123456");

            Thread.sleep(10000);


            reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + Log.info("ASSERT", "Details"), "");

//            String text = mbkCommonControls.getText(By.id("com.mobikwik_new:id/title_view"));
//            bikeScreen.verifyEqualsExtentReport(text, "Otp Sent Successfully on mobile " + mobNo, "otpText | Actual : " + text + " | Expected :  Otp Sent Successfully on mobile " + mobNo, true, " Verify otpText", directoryName, screenName);

        }
    }
}