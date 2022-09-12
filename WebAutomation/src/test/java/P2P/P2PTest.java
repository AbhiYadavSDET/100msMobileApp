package P2P;

import Helpers.LoginHelper;
import Helpers.MoneyTransferHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class P2PTest extends TestBase {


    @Test(groups = {"p2pSend"}, priority = 0, description = "Verify P2P Flow")
    public void Test_P2P_Send() throws InterruptedException, IOException {

//        LoginHelper loginHelper = new LoginHelper(getWebDriver());
//        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

        MoneyTransferHelper moneyTransferHelper = new MoneyTransferHelper(getWebDriver());
        moneyTransferHelper.p2p("9414065033", "Transfer Successful", "5");


    }


}
