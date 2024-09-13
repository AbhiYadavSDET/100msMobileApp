package Epfo;

import java.io.IOException;
import Helpers.LoginHelper;
import Helpers.EpfoHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

public class Test_Epfo extends TestBase {


    /*
    @Test(groups = {"EPFO", "sanity", "regression"}, priority = 1, description = "Verify Existing User flow in Epfo")
    public void Epfo_Test01_epfo_existing_User_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardExistingUser("Total EPF Balance","RECENT CONTRIBUTION","View Full Statement","YOUR RETIREMENT FUND","Contact us");
        Log.info("======= EPFO Dashboard test =======");

    }

    @Test(groups = {"EPFO", "sanity", "regression"}, priority = 1, description = "Verify New User flow in Epfo")
    public void Epfo_Test01_epfo_New_User_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8216900006", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardNewUser("Track your Employee Provident Fund","Input your UAN","Know more about activation","Proceed","Find your UAN");
        Log.info("======= EPFO New Dashboard test =======");

    }

   @Test(groups = {"EPFO", "sanity1", "regression"}, priority = 1, description = "Verify balance breakup")
    public void Epfo_Test01_epfo_balance_breakup() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardBalanceBreakup("Name","Active since","Work experience","Employee’s Share","Employer’s Share","Pension Share (EPS)","Total EPF Balance");
        Log.info("======= EPFO New Dashboard test =======");

    }

    @Test(groups = {"EPFO", "sanity1", "regression"}, priority = 1, description = "Verify View Statement with Filter")
    public void Epfo_Test01_epfo_viewStatement_withFilter() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardViewStatementWithFilter("Employee Share","Employer Share","Pension Share (EPS)");
        Log.info("======= EPFO View Statement with Filter =======");
    }
    */

    @Test(groups = {"EPFO", "sanity1", "regression"}, priority = 0, description = "Verify View all employer")
    public void Test01_epfo_viewALL() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        EpfoHelper epfoHelper = new EpfoHelper(getAndroidDriver());
        // Execute the test
        epfoHelper.epfoDashBoardAll();
        Log.info("======= EPFO Verify View ALL employer =======");
    }

}