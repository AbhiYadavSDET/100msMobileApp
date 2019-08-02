package Insurance;

import Helpers.InsuranceHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class InsuranceTest extends TestBase {


    @Test(groups = {"buyInsuranceGas"}, priority = 0, description = "Verify Buy Insurance Flow")
    public void Test_Buy_Insurance() throws InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        InsuranceHelper insuranceHelper = new InsuranceHelper(getWebDriver());
        insuranceHelper.buyGasInsurance("Payment Successful!\nfor Home Insurance (Gas) of Rs. 2 Lakh by ICICI Lombard");


    }


}
