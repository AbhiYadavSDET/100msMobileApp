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
        impsHelper.verifyIMPSNewAccount("Paraj Jain", "167795709569", "INDB0000724", "50","Transfer Successful" , "₹50","Bank transfer to  Paraj Jain (XXXXXXXXXXX0315)","-₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number Test =======");

    }

  @Test(groups = {"impsNewUPIid", "impsSanity"}, priority = 1, description = "IMPS on New UPI ID")
    public void Test02_imps_new_upi_id() throws IOException,InterruptedException{

        Log.info("======= START : IMPS to New UPI ID Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewVPA("8882305453@paytm","50", "Transfer Successful" , "₹200","Bank transfer to  Ashish Kumar Pradhan (8882305453@paytm)","-₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number Test =======");
    }


  @Test(groups = {"impsSavedVPA", "impsSanity"}, priority = 2, description = "IMPS on Saved VPA")
    public void Test03_imps_to_saved_vpa() throws  IOException,InterruptedException{

        Log.info("======= START : IMPS to Saved VPA Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");


        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSSavedVPA("8882305453@paytm","200", "Transfer Successful" , "₹200","Bank transfer to  Ashish Kumar Pradhan (8882305453@paytm)","-₹51.18","Success");


        Log.info("======= END : IMPS to Saved VPA Test =======");
    }


//Non transactions tests

 @Test(groups = {"impsNewAccountNumber", "impsSanity","ipmsAutoIfscCode"}, priority = 3, description = "IMPS on New Account Number with auto ifsc code")
    public void Test04_imps_new_account_numberWithAutoIfscCode() throws IOException, InterruptedException {

        Log.info("======= START : IMPS to New Account Number with auto ifsc code Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
       impsHelper.verifyIMPSNewAccountWithAutoIfscCode("Abhishek Kumar", "040801000080315", "ICICI","200");

        Log.info("======= END : IMPS to New Account Number with auto Ifsc code Test =======");

    }

    //@Test(groups = {"impsReferAndEarn", "impsSanity"}, priority = 4, description = "Refer and earn on Imps")
   /* public void Test05_imps_new_account_numberWithAutoIfscCode() throws IOException, InterruptedException {

        Log.info("======= START : Refer and earn on Imps Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyReferAndEarnOnImps();
        Log.info("======= END  : Refer and earn on Imps Test =======");

    }
*/

    @Test(groups = {"impsErrorMessage", "impsSanity","impsNewAccountNumber"}, priority = 5, description = "Refer and earn on Imps")
    public void Test06_imps_new_account_numberWithErrorMessage() throws IOException, InterruptedException {

        Log.info("======= START : Error message on add new property on Imps Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSErrorMessageOnAddNewProperty("Abhishek kumar","6213768365");
        Log.info("======= END  : Error message on add new property on Imps Test =======");

    }

    @Test(groups = {"impsCheckLimits", "impsSanity","impsNewAccountNumber"}, priority = 6, description = "Refer and earn on Imps")
    public void Test07_imps_checkLimits() throws IOException, InterruptedException {

        Log.info("======= START : check limits on Imps Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyCheckLimitsOnImps();
        Log.info("======= END  : check limits on Imps Test =======");

    }

    //Insurance option is not coming on IMPS flow

  /*  @Test(groups = {"impsNewAccountNumber", "impsSanity","impsInsurance"}, priority = 7, description = "IMPS on New Account Number with auto ifsc code")
    public void Test08_imps_with_insurance_option_selected() throws IOException, InterruptedException {

        Log.info("======= START : IMPS to add new insurance at checkout page Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("8076595767","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSWithInsuranceOption("Abhishek Kumar", "040801000080315", "ICIC0001401","200");

        Log.info("======= END : IMPS to add new insurance at checkout page Test =======");

    }*/
}


