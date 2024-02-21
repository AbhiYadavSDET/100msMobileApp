package AccountAggregator;

import Helpers.AAHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_AccountAggregator extends TestBase {


    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 1, description = "Verify Existing User flow in AA")
    public void Test01_existing_User_Dashboard() throws IOException, InterruptedException {


        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUser("All Bank Balance", "Your Monthly Summary", "Analyser", "HIGHLIGHTS", "YOUR ACCOUNTS", "OUTGOING", "Others", "Expenses", "EMI", "Investment", "Settings", "Download Statements", "Help & Support");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 1, description = "Verify Monthly summary")
    public void Test02_existing_User_MonthlySummery() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserMonthlySummary("Incoming", "Outgoing", "Invested", "Remaining", "Outgoing", "Expenses", "SIPs & EMIs", "Bank charges", "Others", "Highest Spend", "Top Category", "Spends by Date", "Money Received");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 1, description = "Verify Analyser")
    public void Test03_existing_User_Analyser() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserAnalyser("DEBITS", "Credits", "Week", "Month", "Year", "Debited this week");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity", "regression", "test"}, priority = 1, description = "Verify Manage Section")
    public void Test04_existing_User_Manage() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserManage("Auto Refresh Frequency", "Manage Consent", "Help");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 1, description = "Verify Added Existing Users bank account")
    public void Test05_existing_User_Added_BankAccount() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserBankAccountDetails();
        Log.info("======= Account Aggregator test =======");

    }


    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 0, description = "Verify Add account")
    public void Test05_AA_new_addaccount() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.addAccountNewScreen();
        Log.info("======= Account Aggregator test =======");

    }

}
