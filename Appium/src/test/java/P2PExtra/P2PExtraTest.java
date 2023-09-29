package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"p2pXtraWithdraw", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Withdraw Money")
    public void Test_Xtra_Withdraw_Money() throws InterruptedException, IOException {

        Log.info("======= START : p2p Xtra Withdraw test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.withdraw("1", "₹1", "Withdrawal request placed successfully");

        Log.info("======= END : p2p Xtra Withdraw test =======");


    }


    @Test(groups = {"p2pXtraInvestInFlexi", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Invest in Flexi flow")
    public void Test_Xtra_Invest_In_Flexi() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FLEXI Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFlexi("Select Your Bank");

        Log.info("======= END : p2p Xtra-FLEXI test =======");

    }


    @Test(groups = {"p2pXtraInvestInFixed", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Invest in Fixed flow")
    public void Test_Xtra_Invest_In_Fixed() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FIXED Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFixed("Select Your Bank");

        Log.info("======= END : p2p XTRA-FIXED Invest test =======");

    }


    @Test(groups = {"p2pXtraNewUser", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra :New User Flow Journey")
    public void Test_Xtra_New_User_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - NEW USER flow test with no kYC=======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.newUserFlow("Complete your KYC");

        Log.info("======= END : XTRA - NEW USER flow test with no kYC=======");

    }


    @Test(groups = {"p2pXtraReferAndEarn", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra : Refer & Earn Journey from Xtra Dashboard")
    public void Test_Xtra_Refer_Earn_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Refer & Earn  flow =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.referAndEarnFlow("Know More");

        Log.info("======= END : XTRA - Refer & Earn flow =======");

    }


    @Test(groups = {"p2pXtraDefaultBankAccount", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra  f  : Check Default Bank Account from settings option")
    public void Test_Xtra_Default_bank_account() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Default Account flow from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.setDefaultBankAccountFlow("Default Bank Account");

        Log.info("======= END : XTRA - Default Account flow  =======");

    }

/* Function to Check Add Nominee Flow
    @Test(groups = {"p2pXtraAddNominee", "sanity", "sanityPrime"}, priority = 0, description = "Verify Xtra : Add Nominee from settings option")
    public void Test_Add_Nominee_Account() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Add Nominee flow from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.setNomineeFlow("Add Nominee Flow","In case you don't login for a period of at least 2 years, we will reach out to you and your nominee");
        Log.info("======= END : XTRA - Add Nominee flow from Settings Option  =======");

    }
*/


    @Test(groups = {"p2pXtraNomineeDetails", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra : Add Nominee from settings option")
    public void Test_Xtra_Check_Nominee_Details() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Check Nominee Details from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.checkNomineeDetailsFlow("Check Nominee Details", "NAME", "In case you don't login for a period of at least 2 years, we will reach out to you and your nominee");
        Log.info("======= END : XTRA - Check Nominee Details from Settings Option  =======");

    }


    @Test(groups = {"p2pXtraReInvestFromFixed", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra : Change Maturity Options of Fixed Investment")
    public void Test_Xtra_Reinvest_Fixed() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Re-Invest in Fixed=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");


        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.reinvestFixed("Transfer to Flexi", "Re-invest");

        Log.info("======= END : XTRA - Re-Invest in Fixed =======");

    }


    @Test(groups = {"p2pXtraReInvestFromFlexi", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Verify Xtra : Reinvest(in FXIED) From Flexi Investment")
    public void Test_Xtra_Reinvest_Flexi() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Reinvest(in FIXED) From Flexi=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.reinvestFlexi("1000", "Invest More", "Re-Invest from Flexi to FIXED(From Summary Page)");

        Log.info("======= END : XTRA - Re-Invest in Fixed =======");

    }


}