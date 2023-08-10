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

    @Test(groups = {"impsNewAccountNumber", "impsSanity"}, priority = 0, description = "IMPS on New Account Number")
    public void Test01_imps_new_account_number() throws IOException, InterruptedException {

        Log.info("======= START : IMPS to New Account Number Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewAccount("Ashish Kumar Pradhan", "040801000080315", "IOBA0000408", "50","Transfer Successful" , "₹50","Bank transfer to  Ashish Kumar Pradhan (XXXXXXXXXXX0315)","₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number Test =======");

    }

    @Test(groups = {"impsNewUPIid", "impsSanity"}, priority = 1, description = "IMPS on New UPI ID")
    public void Test02_imps_new_upi_id() throws IOException,InterruptedException{

        Log.info("======= START : IMPS to New UPI ID Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewVPA("8882305453@paytm","50", "Transfer Successful" , "₹50","Bank transfer to  Ashish Kumar Pradhan (8882305453@paytm)","₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number Test =======");
    }


    @Test(groups = {"impsSavedVPA", "impsSanity"}, priority = 2, description = "IMPS on Saved VPA")
    public void Test03_imps_to_saved_vpa() throws  IOException,InterruptedException{

        Log.info("======= START : IMPS to Saved VPA Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");


        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSSavedVPA("8882305453@paytm","50", "Transfer Successful" , "₹50","Bank transfer to  Ashish Kumar Pradhan (8882305453@paytm)","₹51.18","Success");


        Log.info("======= END : IMPS to Saved VPA Test =======");
    }




}


