package FixedDeposit;

import Helpers.FixedDepositHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_FixedDeposit extends TestBase {


    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Existing User Fixed deposit Home Page")
    public void Test01_existing_User_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.existingUserHomePage("View Investment Activity","TOP PLANS","Interest","Tenure","Book","Choose Custom Tenure",
                "Females  upto 0.1% more ","Sr. Citizen  upto 0.5% more","Maximize Your FD Returns","Frequently Asked Questions","Contact us","Help & Support");

        Log.info("======= Fixed Deposit test =======");

    }


    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Existing User book now")
    public void Test02_book_fd_flow() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.fdBooking("Tenure","Annual Yield","Interest Rate","Select Deposit Amount");
        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Edit profile")
    public void Test03_edit_profile() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.personaldetailsEdit();
        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Edit nominee")
    public void Test04_edit_nominee() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.nomineeEdit("Nominee Details","NAME","RELATIONSHIP","DOB","ADDRESS");

        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Summary")
    public void Test05_summary_screen() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.fixedDepositSummary("Tenure","Partner Bank/NBFC","Interest p.a.","Annual Yield","Interest Payout","Maturity Amount","Total Gains","Pre-mature withdrawals","Bank Account","Know more");

        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify History")
    public void Test06_fd_history() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.fixeddepositHistory("Invested Amount","Matures On","Maturity Amount","Gains");

        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Edit profile error case")
    public void Test07_edit_profile_errorcase() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.personaldetailsEditErrorCase();
        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Custom filter")
    public void Test08_custom_filter() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.customTenureFilter();
        Log.info("======= Fixed Deposit test =======");

    }

}
