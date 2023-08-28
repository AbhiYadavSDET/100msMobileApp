package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import Logger.Log;
import Utils.ExtentReport;
import org.testng.annotations.Test;
import Utils.TestBase;


import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"p2pXtraWithdraw", "sanity", "sanityPrime"}, priority = 0, description = "Verify Withdraw Money")
    public void Test_Withdraw_Money() throws InterruptedException, IOException {

        Log.info("======= START : p2p Xtra Withdraw test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.withdraw("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : p2p Xtra Withdraw test =======");


    }



    @Test(groups = {"p2pXtraInvestInFlexi", "sanity", "sanityPrime"}, priority = 0, description = "Verify Invest in Flexi flow")
    public void Test_Invest_In_Flexi() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FLEXI Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFlexi("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : p2p Xtra-FLEXI test =======");

    }



    @Test(groups = {"p2pXtraInvestInFixed", "sanity", "sanityPrime"}, priority = 0, description = "Verify Invest in Fixed flow")
    public void Test_Invest_In_Fixed() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FIXED Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFixed("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : p2p XTRA-FIXED Invest test =======");

    }




    @Test(groups = {"p2pXtraNewUser", "sanity", "sanityPrime"}, priority = 0, description = "Verify Xtra :New User Flow Journey")
    public void Test_New_User_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - NEW USER flow test with no kYC=======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.newUserFlow("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : XTRA - NEW USER flow test with no kYC=======");

    }



    @Test(groups = {"p2pXtraReferAndEarn", "sanity", "sanityPrime"}, priority = 0, description = "Verify Xtra : Refer & Earn Journey from Xtra Dashboard")
    public void Test_Refer_Earn_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Refer & Earn  flow =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.referAndEarnFlow("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : XTRA - Refer & Earn flow =======");

    }




    @Test(groups = {"p2pXtraDefaultBankAccount", "sanity", "sanityPrime"}, priority = 0, description = "Verify Xtra : Default Bank Account from settings option")
    public void Test_Default_bank_account() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Default Account flow from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.setDefaultBankAccount("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : XTRA - Default Account flow  =======");

    }


    @Test(groups = {"p2pXtraReInvest", "sanity", "sanityPrime"}, priority = 0, description = "Verify Xtra : Change Maturity Options of Fixed Investment")
    public void Test_Reinvest() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Re-Invest=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9991015888", "547372");


        //Wait for 10 sec
        Thread.sleep(10000);

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.reinvest("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : XTRA - Re-Invest  =======");

    }





}