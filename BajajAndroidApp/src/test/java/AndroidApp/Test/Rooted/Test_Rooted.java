package AndroidApp.Test.Rooted;

import AndroidApp.Helpers.RootedHelper;
import UITestFramework.CreateSession;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.ExtentReport;

import java.io.IOException;

public class Test_Rooted extends CreateSession {

    @Test(groups = {"rootedSanity"})
    public void Test_rootedDevice() throws JSONException, IOException {

        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Test_Rooted_Device_Check");


        Log.info("START : Rooted Device sanity test");
        RootedHelper rootedHelper = new RootedHelper(getAndroidDriver());
        rootedHelper.assertText();
        Log.info("END : Rooted Device sanity test");
    }
}
