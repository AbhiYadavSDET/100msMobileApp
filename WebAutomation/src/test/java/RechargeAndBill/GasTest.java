package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.GasHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class GasTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Gas bill")
    public void Test_Gas() throws InterruptedException, IOException {
        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("9149237812", "Sumit Chauhan", "sumitch853@gmail.com", "9149237812");

        GasHelper gasHelper = new GasHelper(getWebDriver());
        gasHelper.verifyGasBill("Adani Gas", "1000236410", "No Bills Found", "Adani Gas");

    }
}
