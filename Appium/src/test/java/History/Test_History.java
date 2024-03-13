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

}
