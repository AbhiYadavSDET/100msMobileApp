package RechargeAndBill;

import Helpers.Recharge.DthHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class DthTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Dth bill")
    public void Test_Dth() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        DthHelper dthHelper = new DthHelper(getWebDriver());
        dthHelper.verifyInvalidDthBill("tata", "1043233392", "1");

    }
}
