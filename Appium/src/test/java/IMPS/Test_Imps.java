package IMPS;

import Helpers.ImpsHelper;
import Helpers.LoginHelper;
import org.testng.annotations.Test;
import Utils.ExtentReport;
import Utils.TestBase;

import java.io.IOException;


public class Test_Imps extends TestBase {

    @Test(groups = {"impsNewAccountNumber", "impsSanity"}, priority = 0, description = "IMPS on New Account Number")
    public void Test01_imps_new_account_number() throws IOException, InterruptedException {

        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("Verify IMPS-New Account number Flow");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.verifyImpsNewAccountTransferFlow("Paraj Jain", "218101502680", "ICIC0002181", "50", "121212", "4389760052036060", "06/29", "068");

    }

    @Test(groups = {"impsSavedAccountNumber", "impsSanity"}, priority = 1, description = "IMPS on Saved Account Number")
    public void Test02_imps_saved_account_number() throws IOException, InterruptedException {

        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("Verify IMPS-Saved Account number Flow");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");
        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.verifyImpsSavedAccountTransferFlow("50", "121212", "4389760052036060", "06/29", "068");
    }

    @Test(groups = {"impsSavedVpa", "impsSanity"}, priority = 1, description = "IMPS on Saved VPA")
    public void Test03_imps_saved_vpa() throws IOException, InterruptedException {

        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("Verify IMPS-Saved VPA Flow");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330", "547372");

        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.verifyImpsVPATransferFlow("50", "121212", "4389760052036060", "06/29", "068");
    }


}


