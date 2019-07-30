package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.GasHelper;
import Helpers.Recharge.LandlineHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class GasTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Gas bill")
    public void Test_Gas() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        GasHelper gasHelper = new GasHelper(driver);
        gasHelper.verifyGasBill("Indraprastha", "4000013890");

    }
}
