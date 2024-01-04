package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import Logger.Log;
import Utils.TestBase;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"p2pXtraNewUser", "regression"}, priority = 0, description = "Verify Xtra :New User Flow Journey")
    public void Test_Xtra_New_User_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - NEW USER flow test with no kYC=======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.newUserFlow("Complete your KYC");

        Log.info("======= END : XTRA - NEW USER flow test with no kYC=======");

    }



    @Test(groups = {"p2pXtraReferAndEarn", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra : Refer & Earn Journey from Xtra Dashboard")
    public void Test_Xtra_Refer_Earn_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Refer & Earn  flow =======");

        // Start the test
        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");

        Log.info("======= END : Login test =======");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.referAndEarnFlow("Refer & earn ₹250 + 10%");

        Log.info("======= END : XTRA - Refer & Earn flow =======");

    }



    @Test(groups = {"p2pXtraWithdraw", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Withdraw Money")
    public void Test_Xtra_Withdraw_Money() throws InterruptedException, IOException {

        Log.info("======= START : p2p Xtra Withdraw Flexi =======");

        Log.info("======= START : Login test =======");

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");

        Log.info("======= END : Login test =======");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.withdraw("1", "₹1", "Withdrawal request placed successfully", "Please wait for the below request to be processed", "Withdrawal in progress", "₹1");

        Log.info("======= END : p2p Xtra Withdraw Flexi =======");


    }



    @Test(groups = {"p2pXtraDefaultBankAccount", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra  f  : Check Default Bank Account from settings option")
    public void Test_Xtra_Default_bank_account() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Default Account flow from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.setDefaultBankAccountFlow("Default Bank Account","NOMINEE DETAILS");

        Log.info("======= END : XTRA - Default Account flow  =======");

    }




    @Test(groups = {"p2pXtraInvestInFlexi", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Invest in Flexi flow")
    public void Test_Xtra_Invest_In_Flexi() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FLEXI Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.investInFlexi("Payment Gateway");

        Log.info("======= END : p2p Xtra-FLEXI test =======");

    }




    @Test(groups = {"p2pXtraInvestInFixed", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Invest in Fixed flow")
    public void Test_Xtra_Invest_In_Fixed() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FIXED Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getIosDriver());
        p2PExtraHelper.investInFixed("Payment Gateway");

        Log.info("======= END : p2p XTRA-FIXED Invest test =======");

    }


}
