package History;

import Helpers.HistoryHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_History extends TestBase {


    @Test(groups = {"History", "sanity", "regression"}, priority = 1, description = "Verify New User History")
    public void Test01_History_New_User() throws IOException, InterruptedException {
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8216900006", "547372");
        HistoryHelper historyHelper = new HistoryHelper(getAndroidDriver());
        // Execute the test
        historyHelper.newUserHistory();
        Log.info("======= History test =======");

    }

    @Test(groups = {"History", "sanity", "regression"}, priority = 1, description = "Verify Existing User History")
    public void Test02_History_Kyced_User() throws IOException, InterruptedException {
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        HistoryHelper historyHelper = new HistoryHelper(getAndroidDriver());
        // Execute the test
        historyHelper.existingUserHistory("All Categories","Help?");
        Log.info("======= History test Kyced User =======");

    }


    @Test(groups = {"History", "sanity", "regression"}, priority = 1, description = "Verify Existing User History")
    public void Test03_History_Kyced_User_AAbottomsheet() throws IOException, InterruptedException {
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        HistoryHelper historyHelper = new HistoryHelper(getAndroidDriver());
        // Execute the test
        historyHelper.existingUserHistoryAAbottomSheet("SELECT YOUR BANK","Insights");
        Log.info("======= History test Kyced User =======");

    }

}
