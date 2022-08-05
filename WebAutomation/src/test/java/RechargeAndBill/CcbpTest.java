package RechargeAndBill;

import Helpers.Recharge.LandlineHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class CcbpTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Landline bill")
    public void Test_Ccbp() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        LandlineHelper landlineHelper = new LandlineHelper(getWebDriver());
        landlineHelper.verifyLandlineBill("Delhi", "2061533162");
    }
}
