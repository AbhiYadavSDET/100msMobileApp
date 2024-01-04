package SecurityPin;

import Helpers.LoginHelper;
import Helpers.RechargeHelper;
import Helpers.SecurityPinHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class SecurityPinTest  extends TestBase {

    @Test(groups = {"securityPinFlow"}, priority = 0, description = "Verify security pin Flow on Ios app")

    public void Test_SecurityPin_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Prepaid Recharge Flow test =======");

        SecurityPinHelper securityPinHelper = new SecurityPinHelper(getIosDriver());
        securityPinHelper.securityPinFlow("Security PIN");

        Log.info("======= END : Prepaid Recharge Flow test =======");

    }
}

