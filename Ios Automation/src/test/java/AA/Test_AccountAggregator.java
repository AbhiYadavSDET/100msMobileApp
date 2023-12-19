package AA;

import Helpers.LoginHelper;
import Helpers.AAHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_AccountAggregator extends TestBase {

    @Test(groups = {"AADashboard", "regression"}, priority = 0, description = "Verify Account aggregator Dashboard")

    public void Test01_existing_User_Dashboard() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("7795709569", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : AA  Dashboard Flow test =======");
        AAHelper aaHelper = new AAHelper(getIosDriver());
        aaHelper.aaExistingUserDashboard("All Bank Balance", "Others", "Expenses", "SIPs & EMIs", "Bank charges", "OUTGOING", "Your Monthly Summary", "HIGHLIGHTS", "YOUR ACCOUNTS", "Settings", "Download Statements", "Help & Support");
        Log.info("======= Account Aggregator test =======");


    }

    @Test(groups = {"AADashboard", "regression"}, priority = 0, description = "Verify Monthly summary")
    public void Test02_existing_User_MonthlySummery() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getIosDriver());
        // Execute the test
        aaHelper.existingUserMonthlySummary("Incoming", "Outgoing", "Invested", "Remaining", "Outgoing", "Expenses", "SIPs & EMIs", "Bank charges", "Others", "Highest Spend", "Top Category", "Spends by Date", "Money Received");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AADashboard", "regression"}, priority = 0, description = "Verify Analyser")
    public void Test03_existing_User_Analyser() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getIosDriver());
        loginHelp.loginViaOtp("7795709569", "547372");
        AAHelper aaHelper = new AAHelper(getIosDriver());
        // Execute the test
        aaHelper.existingUserAnalyser("DEBITS", "Credits", "Week", "Month", "Year", "Debited this week");
        Log.info("======= Account Aggregator test =======");

    }

}
