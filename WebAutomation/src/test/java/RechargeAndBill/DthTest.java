package RechargeAndBill;

import Helpers.LoginHelper;
import Helpers.Recharge.DthHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class DthTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Dth bill")
    public void Test_Dth() throws InterruptedException, IOException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9149237812", "Sumit Chauhan", "sumitch853@gmail.com", "9149237812");

        DthHelper dthHelper = new DthHelper(getWebDriver());
        dthHelper.verifyInvalidDthBill("tata", "1043233392", "1");

    }
}
