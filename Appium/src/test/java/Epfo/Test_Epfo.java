package Epfo;

import java.io.IOException;
import Helpers.LoginHelper;
import Helpers.EpfoHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

public class Test_Epfo extends TestBase {


    @Test(groups = {"EPFO", "sanity", "regression"}, priority = 0, description = "Verify Existing User flow in Epfo")
    public void Test01_epfo_existing_User_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardExistingUser("Total EPF Balance","RECENT CONTRIBUTION","View Full Statement","YOUR RETIREMENT FUND","Contact us");
        Log.info("======= EPFO Dashboard test =======");

    }

    @Test(groups = {"EPFO", "sanity", "regression"}, priority = 1, description = "Verify New User flow in Epfo")
    public void Test01_epfo_New_User_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8216900006", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardNewUser("rack your Employee Provident Fund","Input your UAN","Know more about activation","Proceed","Find your UAN");
        Log.info("======= EPFO New Dashboard test =======");

    }

}