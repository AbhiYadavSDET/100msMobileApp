package IMPS;

import Helpers.ImpsHelper;
import Helpers.LoginHelper;
import Helpers.MoneyTransferHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class IMPSTest extends TestBase {


    @Test(groups = {"imps"}, priority = 0, description = "Verify imps Flow")
    public void Test_IMPS() throws InterruptedException, IOException {

//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        ImpsHelper impsHelper = new ImpsHelper(getWebDriver());
        impsHelper.imps("Paraj Jain", "167795709569", "INDB0000724","50");


    }


}
