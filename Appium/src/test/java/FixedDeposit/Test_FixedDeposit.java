package FixedDeposit;

import Helpers.FixedDepositHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_FixedDeposit extends TestBase {


    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 1, description = "Verify Existing User Fixed deposit Home Page")
    public void FixedDeposit_Test01_existing_User__FD_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.existingUserHomePage("View Investment Activity","TOP PLANS","Interest","Tenure","Book","Choose Custom Tenure",
                "Females  upto 0.1% more ","Sr. Citizen  upto 0.5% more","Maximize Your FD Returns","Frequently Asked Questions","Contact us","Help & Support");

        Log.info("======= Fixed Deposit test =======");

    }


    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Verify Existing User book now")
    public void FixedDeposit_Test02_book_fd_flow() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.fdBooking("Tenure","Annual Yield","Interest Rate","Select Deposit Amount");
        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity1", "regression"}, priority = 0, description = "Verify Edit profile")
    public void FixedDeposit_Test03_fd_edit_profile() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.personaldetailsEdit();
        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Verify Edit nominee")
    public void FixedDeposit_Test04_edit_nominee() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.nomineeEdit("Nominee Details","NAME","RELATIONSHIP","DOB","ADDRESS");

        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Verify Summary")
    public void FixedDeposit_Test05_summary_screen() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.fixedDepositSummary("Tenure","Partner Bank/NBFC","Interest p.a.","Annual Yield","Interest Payout","Maturity Amount","Total Gains","Pre-mature withdrawals","Bank Account","Know more");

        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Verify History")
    public void FixedDeposit_Test06_fd_history() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.fixeddepositHistory("Invested Amount","Matures On","Maturity Amount","Gains");

        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Verify Edit profile error case")
    public void FixedDeposit_Test07_edit_profile_errorcase() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.personaldetailsEditErrorCase();
        Log.info("======= Fixed Deposit test =======");

    }

    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Verify Custom filter")
    public void FixedDeposit_Test08_custom_filter() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.customTenureFilter();
        Log.info("======= Fixed Deposit test =======");

    }


    @Test(groups = {"FixedDeposit", "sanity1", "regression1"}, priority = 2, description = "Partner Changes")
    public void FixedDeposit_Test08_partner_changes() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());

        // Execute the test
        fixedDepositHelper.partnerChangesfromTopOnSummeryScreen("Partner Bank/NBFC", "Bank", "Interest p.a.");
        Log.info("======= Fixed Deposit test =======");

    }
}
