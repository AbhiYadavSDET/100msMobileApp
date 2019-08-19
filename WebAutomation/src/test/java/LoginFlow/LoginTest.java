package LoginFlow;

import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test(groups = {"loginFlow"}, priority = 0, description = "Verify Login Flow on Web")
    public void Test_Login_Flow() throws InterruptedException {

//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("7795709569", "para jain", "par.ajjain@gmail.com", "7795709569");

//        BankTransferHelper bankTransferHelper= new BankTransferHelper(driver);
//        bankTransferHelper.bankTransfer("Paraj Jain", "218101502680", "ICIC0002181", "50", "Money sent successfully");

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");


    }


}
