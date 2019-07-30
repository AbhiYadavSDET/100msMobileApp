package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.DthHelper;
import Helpers.Recharge.GasHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class DthTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Dth bill")
    public void Test_Dth() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        DthHelper dthHelper = new DthHelper(driver);
        dthHelper.verifyInvalidDthBill("1043233392", "1");

    }
}
