package IMPSNew;

import Helpers.IMPSNewHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.Element;
import Utils.Elements;
import Utils.ExtentReport;
import Utils.TestBase;
import org.apache.groovy.json.internal.IO;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;


public class IMPSTest extends TestBase {

    public void login() throws IOException, InterruptedException{
        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330","547372");

    }
    @Test(groups = {"impsNewAccountNumber", "impsSanity"}, priority = 0, description = "IMPS on New Account Number")
    public void Test01_imps_new_account_number() throws IOException, InterruptedException {


        // Starting the test in the extentreport
        //ExtentReport.EXTENTREPORT.createTest("Verify IMPS-New Account number Flow");

        Log.info("======= START : IMPS to New Account Number Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");


        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewAccountTransferFlow("Paraj Jain", "218101502680", "ICIC0002181", "50", "121212");

        Log.info("======= END : IMPS to New Account Number Test =======");

    }

    @Test(groups = {"impsNewUPIid", "impsSanity"}, priority = 1, description = "IMPS on New UPI ID")
    public void Test02_imps_new_upi_id() throws IOException,InterruptedException{

        Log.info("======= START : IMPS to New UPI ID Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewUPITransferFlow("7795709569@paytml","50","121212");

        Log.info("======= END : IMPS to New Account Number Test =======");
    }


    @Test(groups = {"impsSavedVPA", "impsSanity"}, priority = 2, description = "IMPS on Saved VPA")
    public void Test03_imps_to_saved_vpa() throws  IOException,InterruptedException{

        Log.info("======= START : IMPS to Saved VPA Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.loginViaOtp("9205299330","547372");


        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSSavedAccountTransfer("7795709569@paytm","50","121212");

        Log.info("======= END : IMPS to Saved VPA Test =======");
    }




}


