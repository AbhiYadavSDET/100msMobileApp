package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.LandlineHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class LandlineTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Landline bill")
    public void Test_Landline() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        LandlineHelper landlineHelper = new LandlineHelper(driver);
        landlineHelper.verifyLandlineBill("Delhi", "23693162", "2061533162");

    }
}
