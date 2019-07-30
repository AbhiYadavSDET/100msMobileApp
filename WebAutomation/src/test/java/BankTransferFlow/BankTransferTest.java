package BankTransferFlow;

import Helpers.BankTransferHelper;
import Helpers.LoginHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class BankTransferTest extends TestBase {


    @Test(groups = {"bankTransferFlow"}, priority = 0, description = "Verify Bank Transfer Flow on Web")
    public void Test_Bank_Transfer_Flow() throws InterruptedException {

        LoginHelper loginHelper= new LoginHelper(driver);
        loginHelper.loginViaOtp("7795709569", "para jain", "par.ajjain@gmail.com", "7795709569");

        BankTransferHelper bankTransferHelper= new BankTransferHelper(driver);
        bankTransferHelper.bankTransfer("Paraj Jain", "218101502680", "ICIC0002181", "50", "Money sent successfully");


    }


}
