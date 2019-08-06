package RechargeAndBill;

import Helpers.Recharge.GasHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class GasTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Gas bill")
    public void Test_Gas() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        GasHelper gasHelper = new GasHelper(getWebDriver());
        gasHelper.verifyGasBill("Indraprastha", "4000013890", "No Bills Found", "Indraprastha Gas Limited (IGL)");

    }
}
