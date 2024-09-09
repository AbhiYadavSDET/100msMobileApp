package P2PExtra;

import Helpers.LoginHelper;
import Helpers.P2PExtraHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class P2PExtraTest extends TestBase {

    @Test(groups = {"p2pXtraWithdraw"}, priority = 1, description = "Verify Withdraw Money")
    public void P2PExtra_Test01_Xtra_Withdraw_Money() throws InterruptedException, IOException {

        Log.info("======= START : p2p Xtra Withdraw test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.withdraw("1", "₹1", "Withdrawal request placed successfully", "Please wait for the below request to be processed", "Withdrawal in progress", "₹1");

        Log.info("======= END : p2p Xtra Withdraw test =======");

    }

    @Test(groups = {"p2pXtraInvestInFlexi"}, priority = 1, description = "Verify Invest in Flexi flow")
    public void P2PExtra_Test02_Invest_In_Flexi() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FLEXI Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFlexi("Select Your Bank");

        Log.info("======= END : p2p Xtra-FLEXI test =======");

    }


    @Test(groups = {"p2pXtraInvestInFixed","sanity", "sanityPrime", "regression"}, priority = 1, description = "Verify Invest in Fixed flow")
    public void P2PExtra_Test03_Xtra_Invest_In_Fixed() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FIXED Invest test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFixed("Select Your Bank","1,000");

        Log.info("======= END : p2p XTRA-FIXED Invest test =======");

    }


    @Test(groups = {"p2pXtraNewUser","sanity"}, priority = 1, description = "Verify Xtra :New User Flow Journey")
    public void P2PExtra_Test04_Xtra_New_User_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - NEW USER flow test with no kYC=======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.newUserFlow("Complete your KYC");

        Log.info("======= END : XTRA - NEW USER flow test with no kYC=======");

    }


    @Test(groups = {"p2pXtraReferAndEarn", "sanityPrime", "regression"}, priority = 1, description = "Verify Xtra : Refer & Earn Journey from Xtra Dashboard")
    public void P2PExtra_Test05_Xtra_Refer_Earn_In_XTRA() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Refer & Earn  flow =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.referAndEarnFlow("Know More");

        Log.info("======= END : XTRA - Refer & Earn flow =======");

    }


    @Test(groups = {"p2pXtraDefaultBankAccount", "sanityPrime", "regression"}, priority = 1, description = "Verify Xtra  f  : Check Default Bank Account from settings option")
    public void P2PExtra_Test06_Xtra_Default_bank_account() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Default Account flow from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.setDefaultBankAccountFlow("Default Bank Account");

        Log.info("======= END : XTRA - Default Account flow  =======");

    }



    @Test(groups = {"p2pXtraNewUser","sanity"}, priority = 0, description = "Verify Xtra : Add Nominee from settings option")
    public void P2PExtra_Test07_Xtra_Check_Nominee_Details() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Check Nominee Details from Settings Option=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.checkNomineeDetailsFlow("Check Nominee Details", "NAME", "In case you don't login for a period of at least 2 years, we will reach out to you and your nominee");
        Log.info("======= END : XTRA - Check Nominee Details from Settings Option  =======");

    }


    @Test(groups = {"p2pXtraReInvestFromFixed", "sanity", "sanityPrime", "regression"}, priority = 1, description = "Verify Xtra : Change Maturity Options of Fixed Investment")
    public void P2PExtra_Test08_Xtra_Reinvest_Fixed() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Re-Invest in Fixed=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");


        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.reinvestFixed("Transfer to Bank", "Re-invest");

        Log.info("======= END : XTRA - Re-Invest in Fixed =======");

    }


    @Test(groups = {"p2pXtraReInvestFromFlexi", "sanityPrime", "regression"}, priority = 1, description = "Verify Xtra : Reinvest(in FXIED) From Flexi Investment")
    public void P2PExtra_Test09_Xtra_Reinvest_Flexi() throws InterruptedException, IOException {

        Log.info("======= START : XTRA - Reinvest(in FIXED) From Flexi=======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.reinvestFlexi("1000", "Invest More", "Re-Invest from Flexi to FIXED(From Summary Page)");

        Log.info("======= END : XTRA - Re-Invest in Fixed =======");

    }


    @Test(groups = {"p2pXtraInvestInFixedErrorCase", "sanityPrime", "regression"}, priority = 1, description = "Verify Invest in Fixed flow")
    public void P2PExtra_Test10_Xtra_Invest_In_Fixed_errorcase() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA-FIXED Invest error case test =======");


        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.investInFixedErrorCase("Select Your Bank","Amount cannot be more than ₹9,96,077");

        Log.info("======= END : p2p XTRA-FIXED Invest Error Case test =======");

    }

    @Test(groups = {"p2pXtraNewUser","sanity"}, priority = 1, description = "Verify Invest new xtar Revamp")
    public void P2PExtra_Test02_Invest_Loancreation() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA loan creation Test =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.xtraLoanCreation("Your Portfolio","Next Repayment","Status","Estimated Interest");

        Log.info("======= END : p2p XTRA loan creation Test =======");

    }

    @Test(groups = {"p2pXtraNewUser","sanity"}, priority = 1, description = "Verify p2p XTRA Manage section report and statement")
    public void P2PExtra_Test03_Manage_Report_and_Statement() throws InterruptedException, IOException {

        Log.info("======= START : p2p XTRA Manage section report and statement =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.checkManageFlow("Interest Certificate","Transaction Statements");

        Log.info("======= END : p2p XTRA Manage section report and statement =======");

    }


    @Test(groups = {"p2pXtraNewUser","sanity"}, priority = 0, description = "Verify p2p Xtra setting")
    public void P2PExtra_Test03_Setting() throws InterruptedException, IOException {

        Log.info("======= START :  p2p Xtra setting =======");

        // Start the test
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");

        P2PExtraHelper p2PExtraHelper = new P2PExtraHelper(getAndroidDriver());
        p2PExtraHelper.settingFlow("In case you don't login for a period of at least 2 years, we will reach out to you and your nominee","Email","Primary Bank Account");

        Log.info("======= END : p2p XTRA Manage section report and statement =======");

    }




}