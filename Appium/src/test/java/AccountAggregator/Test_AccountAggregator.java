package AccountAggregator;

import Helpers.AAHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_AccountAggregator extends TestBase {


    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 7, description = "Verify Existing User flow in AA")
    public void AccountAggregator_Test01_existing_User_AA_Dashboard() throws IOException, InterruptedException {


        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUser("All Bank Balance", "MONEY IN", "MONEY OUT", "vs last month");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Analyser")
    public void AccountAggregator_Test02_existing_User_Analyser() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserAnalyser("DEBITS", "Week", "Month", "Year");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression", "test"}, priority = 7, description = "Verify Manage Section")
    public void AccountAggregator_Test03_existing_User_Manage() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserManage("All Bank Balance", "Manage");
        Log.info("======= Account Aggregator test =======");

    }


    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Add account")
    public void AccountAggregator_Test04_AA_new_addaccount() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.addAccountNewScreen();
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Month filter on AA")
    public void AccountAggregator_Test05_AA_Month_Filter() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.FilterAA("Current Month","Last Month");
        Log.info("======= Account Aggregator test =======");

    }


    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Month filter on AA")
    public void AccountAggregator_Test06_AA_Search_Filter() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.SearchAA();
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Retagging")
    public void AccountAggregator_Test07_AA_New_Retagging() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.AAretagging("Nickname","Category","Sub Category","Payment Mode");
        Log.info("======= Account Aggregator test =======");

    }


    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Retagging")
    public void AccountAggregator_Test08_AA_DownloadStatement() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.AADownloadStatement("Last 7 Days","Last 30 Days","Last 6 Months","Last 12 Months","This Year","Financial Year");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Retagging")
    public void AccountAggregator_Test09_AA_Highlight() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.aaHighlight("Lifestyle","Tax Savings","FY 2024-25");
        Log.info("======= Account Aggregator test =======");

    }
}
