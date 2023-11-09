package SecurityPin;

import Helpers.SecurityPinHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class SecurityPinTest extends TestBase {


    @Test(groups = {"sanity", "enableDisablePin()", "regression"}, priority = 0, description = "Verify Security Pin")
    public void securitySettings_EnableDisablePin() throws IOException, InterruptedException {

        Log.info("======= START : Security Pin Test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        SecurityPinHelper securityPinHelper = new SecurityPinHelper(getAndroidDriver());
        securityPinHelper.securityPinTestCase("121212", "Security Settings","Security PIN");

        Log.info("======= END : Security Pin Test =======");


    }

    @Test(groups = {"sanity", "changeSecurityPin", "regression"}, priority = 0, description = "Verify Security Pin")
    public void securitySettings_ChangeSecurityPin() throws IOException, InterruptedException {

        Log.info("======= START : Change Security Pin Test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        SecurityPinHelper securityPinHelper = new SecurityPinHelper(getAndroidDriver());
        securityPinHelper.changeSecurityPinTest("121212", "Security Settings","Security PIN");

        Log.info("======= END : Change Security Pin Test =======");


    }
}