package AccountAggregator;

import Helpers.AAHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_AccountAggregator extends TestBase {


    @Test(groups = {"AccountAggregator", "sanity", "regression"}, priority = 7, description = "Verify Existing User flow in AA")
    public void Test01_existing_User_AA_Dashboard() throws IOException, InterruptedException {


        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUser("All Bank Balance", "MONEY IN", "MONEY OUT", "vs last month");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Analyser")
    public void Test03_existing_User_Analyser() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserAnalyser("DEBITS", "Week", "Month", "Year");
        Log.info("======= Account Aggregator test =======");

    }

    @Test(groups = {"AccountAggregator", "sanity1", "regression", "test"}, priority = 7, description = "Verify Manage Section")
    public void Test04_existing_User_Manage() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.existingUserManage("All Bank Balance", "Manage");
        Log.info("======= Account Aggregator test =======");

    }


    @Test(groups = {"AccountAggregator", "sanity1", "regression"}, priority = 7, description = "Verify Add account")
    public void Test05_AA_new_addaccount() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        AAHelper aaHelper = new AAHelper(getAndroidDriver());
        // Execute the test
        aaHelper.addAccountNewScreen();
        Log.info("======= Account Aggregator test =======");

    }


}
