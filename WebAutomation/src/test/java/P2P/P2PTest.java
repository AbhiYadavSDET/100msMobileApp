package P2P;

import Helpers.LoginHelper;
import Helpers.MoneyTransferHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class P2PTest extends TestBase {


    @Test(groups = {"p2pSend"}, priority = 0, description = "Verify P2P Flow")
    public void Test_P2P_Send() throws InterruptedException {

//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        MoneyTransferHelper moneyTransferHelper = new MoneyTransferHelper(getWebDriver());
        moneyTransferHelper.p2p("9461528145", "Transfer Successful", "5");


    }


}
