package IntegrationTests.ViewBill;

import IntegrationTests.Screens.RechargeScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKCommonControls;
import UITestFramework.MBKPermissions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;

/**
 * contains all methods to test Add Money Flow
 */
public class ViewBillHelper extends ViewBillHelperBase {
    RechargeScreen rechargeScreen;
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    Reporter reporter;
    MBKCommonControls mbkCommonControls;


    public ViewBillHelper(AndroidDriver driver) throws IOException {
        rechargeScreen = new RechargeScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new MBKCommonControls(driver);
        reporter = new Reporter();


    }


    public void viewBillWater(String operator, String cn, String directoryName, String screenName) throws InterruptedException {
        int ssCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);

        rechargeScreen.selectElement(By.xpath("//*[@text='More']"));
        rechargeScreen.selectElement(By.xpath("//*[@text='Water']"));


        rechargeScreen.selectElement(By.name("Select Operator"));

        // Select the operator
        rechargeScreen.selectElement(By.name(operator));

        // Enter the cn number
        rechargeScreen.findElement(By.xpath("//*[@text='Empty list' and (./preceding-sibling::* | ./following-sibling::*)[@text='RR Number']]")).sendKeys(cn);

        rechargeScreen.iosBack("Done");

        rechargeScreen.selectElement(By.xpath("//*[@text='View Bill']"));
        Thread.sleep(5000);

        rechargeScreen.selectElement(By.xpath("//*[@text='w']"));
        rechargeScreen.selectElement(By.xpath("//*[@text='w']"));
    }

    public void viewBillGas(String operator, String cn, String mobileNo, String email, String directoryName, String screenName) throws InterruptedException, IOException {
        int testStepCount = 0;


        // Select the Mobile option from the Home-screen
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Gas button from Homescreen"), "");
        rechargeScreen.selectElement(By.xpath("//*[@text='More']"));
        rechargeScreen.selectElement(By.xpath("//*[@text='Gas']"));

        mbkCommonControls.allowPermission(true, "Contacts");
        mbkCommonControls.allowPermission(true, "Manage Phone Calls");

        // Enter the details
        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("ENTER", "Details"), "");
        Thread.sleep(2000);
        rechargeScreen.selectElement(By.id("com.mobikwik_new:id/edit_text_mket"));

        // Select the operator
        rechargeScreen.selectElement(By.xpath("//*[@text='" + operator + "']"));

        // Enter the cn number
        rechargeScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'Customer ID']/following::android.widget.EditText[1]"), cn);
        rechargeScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'Mobile No']/following::android.widget.EditText[1]"), mobileNo);
        rechargeScreen.sendText(By.xpath("//*/android.widget.TextView[@text = 'Email id']/following::android.widget.EditText[1]"), email);


        reporter.extentReportDisplay("INFO", "STEP " + ++testStepCount + " | " + Log.info("SELECT", "Continue CTA"), "");
        rechargeScreen.selectElement(By.id("recharge_button"));

        Thread.sleep(7000);
        // Take screen shot of the success Page
        rechargeScreen.takeSSOnSuccess("message", "STEP " + ++testStepCount + " | " + Log.info("Take SS", "ViewBill Success screen"), directoryName, screenName);


        rechargeScreen.selectElement(By.xpath("//*[@text='w']"));
        rechargeScreen.selectElement(By.xpath("//*[@text='w']"));
        rechargeScreen.selectElement(By.id("close_button"));
    }

    public void viewBillElectricity(String operator, String cn, String directoryName, String screenName) throws InterruptedException {
        int ssCount = 0;

        // Handle the KYC Popup
        mbkPermissions.handleKYCScreen("directoryName", "screenName", ssCount);

        rechargeScreen.selectElement(By.xpath("//*[@text='More']"));
        rechargeScreen.selectElement(By.xpath("//XCUIElementTypeStaticText[@name = 'Recharge & Bill Payments']/following::XCUIElementTypeStaticText[@name = 'Electricity']"));


        rechargeScreen.selectElement(By.name("Select Operator"));

        // Select the operator
        rechargeScreen.selectElement(By.name(operator));

        // Enter the cn number
        rechargeScreen.findElement(By.xpath("//*[@class='UIATextField' and (./preceding-sibling::* | ./following-sibling::*)[@text='Consumer Number']]")).sendKeys(cn);

        rechargeScreen.iosBack("Done");

        rechargeScreen.selectElement(By.xpath("//*[@text='View Bill']"));
        Thread.sleep(5000);

        rechargeScreen.selectElement(By.xpath("//*[@text='w']"));
        rechargeScreen.selectElement(By.xpath("//*[@text='w']"));
    }

}