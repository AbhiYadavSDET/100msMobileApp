package IntegrationTests.Test;

import IntegrationTests.Screens.P2MScreen;
import UITestFramework.ExtentReport.Reporter;
import UITestFramework.MBKPermissions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import logger.Log;
import org.json.JSONException;

import java.io.IOException;

/**
 * contains all methods to test Add Money Flow
 */
public class TestHelper extends TestHelperBase {
    TouchAction touchAction;
    MBKPermissions mbkPermissions;
    UITestFramework.MBKCommonControls mbkCommonControls;
    P2MScreen p2MScreen;
    Reporter reporter;


    public TestHelper(AndroidDriver driver) throws IOException {
        p2MScreen = new P2MScreen(driver);
        touchAction = new TouchAction(driver);
        mbkPermissions = new MBKPermissions(driver);
        mbkCommonControls = new UITestFramework.MBKCommonControls(driver);
        reporter = new Reporter();


    }


    public void testExtentReport() throws InterruptedException, IOException, JSONException {


        Log.info("Hieght : " + p2MScreen.getWindowSize().getHeight());
        Log.info("Width : " + p2MScreen.getWindowSize().getWidth());




    }
}