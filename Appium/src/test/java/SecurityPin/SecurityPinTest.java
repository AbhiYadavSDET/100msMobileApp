package SecurityPin;

import Helpers.SecurityPinHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class SecurityPinTest extends TestBase {


    @Test(groups = {"sanity", "securityPin", "regression"}, priority = 0, description = "Verify Security Pin")
    public void SecurityPinTest1() throws IOException, InterruptedException {

        Log.info("======= START : Security Pin Test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        SecurityPinHelper securityPinHelper = new SecurityPinHelper(getAndroidDriver());
        securityPinHelper.securityPinTestCase("Security Settings","Security PIN");

        Log.info("======= END : Security Pin Test =======");


    }
}