package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import org.testng.annotations.Test;
import utils.TestBase;


import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"investMoneyEndToEnd","sanityPrime"}, priority = 0, description = "Verify Invest Money via Card")
    public void Test_Invest_Money_Flow() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(initiateTest());
        loginHelp.loginViaOtp("7795709569", "547372" );

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(initiateTest());
        p2PExtraHelper.investMoney("1","4363931800224460","12/22","239", "",false,"card");

    }

    @Test(groups = {"investMoneyFlowTillBankPage","sanity"}, priority = 1, description = "Verify Invest Money via Card")
    public void Test_Invest_Money_Flow_ViaCard_OtpPage() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(initiateTest());
        loginHelp.loginViaOtp("7795709569", "547372" );

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(initiateTest());
        p2PExtraHelper.investMoney("1","4363931800224460","12/22","239", "1234",true,"card");

    }

    @Test(groups = {"investMoneyFlowTillBankPage","sanity"}, priority = 2, description = "Verify Invest Money via NetBanking")
    public void Test_Invest_Money_Flow_ViaNetBanking_OtpPage() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(initiateTest());
        loginHelp.loginViaOtp("7795709569", "547372" );

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(initiateTest());
        p2PExtraHelper.investMoney("1","4363931800224460","12/22","239", "1234",true,"netbanking");

    }

    @Test(groups = {"widthdarwMoneyFlow","sanity", "sanityPrime"}, priority = 3, description = "Verify Withdraw Money")
    public void Test_Withdraw_Money() throws InterruptedException, IOException {
        // Start the test
        LoginHelper loginHelp = new LoginHelper(initiateTest());
        loginHelp.loginViaOtp("7795709569", "547372" );

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(initiateTest());
        p2PExtraHelper.withdrawMoney("1");

    }

}
