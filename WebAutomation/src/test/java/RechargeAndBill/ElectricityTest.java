package RechargeAndBill;

import Helpers.Recharge.ElectricityHelper;
import Helpers.Recharge.LandlineHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class ElectricityTest extends TestBase {
    @Test(groups = {"recharge"}, priority = 0, description = "Verify Electricity bill")
    public void Test_Electricity() throws InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        ElectricityHelper electricityHelper = new ElectricityHelper(getWebDriver());
        electricityHelper.verifyElectricityBill("Kota Electricity Distribution Limited (KEDL)", "210736016179");
    }
}
