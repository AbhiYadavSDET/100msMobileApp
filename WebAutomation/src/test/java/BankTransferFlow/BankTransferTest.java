package BankTransferFlow;

import Helpers.BankTransferHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class BankTransferTest extends TestBase {


    @Test(groups = {"bankTransferFlow"}, priority = 0, description = "Verify Bank Transfer Flow on Web")
    public void Test_Bank_Transfer_Flow() throws InterruptedException {

//        LoginHelper loginHelper= new LoginHelper(driver);
//        loginHelper.loginViaOtp("7795709569", "para jain", "par.ajjain@gmail.com", "7795709569");

        BankTransferHelper bankTransferHelper = new BankTransferHelper(getWebDriver());
        bankTransferHelper.bankTransfer("Mayank Suneja", "114601503265", "ICIC0001146", "50", "Money sent successfully");


    }


}
