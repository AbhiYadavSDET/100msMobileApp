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
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewAccount("Paraj Jain", "167795709569", "INDB0000724", "5000","Transfer Successful" , "₹50","Bank transfer to  Paraj Jain (XXXXXXXXXXX0315)","-₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number Test =======");

    }

  @Test(groups = {"impsNewUPIid", "impsSanity"}, priority =0, description = "IMPS on New UPI ID")
    public void Test02_imps_new_upi_id() throws IOException,InterruptedException{

        Log.info("======= START : IMPS to New UPI ID Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewVPA("8882305453@paytm","50", "Transfer Successful" , "5000","Bank transfer to  Ashish Kumar Pradhan (8882305453@paytm)","-₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number Test =======");
    }


  @Test(groups = {"impsSavedVPA", "impsSanity"}, priority = 0, description = "IMPS on Saved VPA")
    public void Test03_imps_to_saved_vpa() throws  IOException,InterruptedException{

        Log.info("======= START : IMPS to Saved VPA Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");


        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSSavedVPA("8882305453@paytm","200", "Transfer Successful" , "5000","Bank transfer to  Ashish Kumar Pradhan (8882305453@paytm)","-₹51.18","Success");


        Log.info("======= END : IMPS to Saved VPA Test =======");
    }


//Non transactions tests

 @Test(groups = {"impsSanity","ipmsAutoIfscCode", "regression"}, priority = 0, description = "IMPS on New Account Number with auto ifsc code")
    public void Test04_imps_new_account_numberWithAutoIfscCode() throws IOException, InterruptedException {

        Log.info("======= START : IMPS to New Account Number with auto ifsc code Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
       impsHelper.verifyIMPSNewAccountWithAutoIfscCode("Abhishek Kumar", "040801000080315", "ICICI","5000");

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

    @Test(groups = {"impsErrorMessage", "impsSanity", "regression"}, priority = 0, description = "Error messages on Imps")
    public void Test06_imps_new_account_numberWithErrorMessage() throws IOException, InterruptedException {

        Log.info("======= START : Error message on add new property on Imps Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSErrorMessageOnAddNewProperty("Abhishek kumar","6213768365");
        Log.info("======= END  : Error message on add new property on Imps Test =======");

    }

    @Test(groups = {"impsCheckLimits", "impsSanity", "regression"}, priority = 0, description = "Check limit option on IMPS")
    public void Test07_imps_checkLimits() throws IOException, InterruptedException {

        Log.info("======= START : check limits on Imps Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyCheckLimitsOnImps();
        Log.info("======= END  : check limits on Imps Test =======");

    }

    @Test(groups = {"impsNewAccountNumberManualIfscCode", "impsSanity","regression"}, priority = 0, description = "IMPS on New Account Number with manual ifsc code")
    public void Test01_imps_new_account_number_Manual_IfscCode() throws IOException, InterruptedException {

        Log.info("======= START : IMPS to New Account Number manual IFC code Test =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSNewAccountWithManualIfscCode("Paraj Jain", "167795709569", "INDB0000724", "5000","Transfer Successful" , "₹50","Bank transfer to  Paraj Jain (XXXXXXXXXXX0315)","-₹51.18","Success");

        Log.info("======= END : IMPS to New Account Number manual IFC code Test =======");

    }


    @Test(groups = {"impsInfoMessage", "impsSanity", "regression"}, priority = 0, description = "Info messages on amount screen on Imps")
    public void Test06_imps_new_account_Info_Messages() throws IOException, InterruptedException {

        Log.info("======= START : Info message on add new property on Amount page  =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSInfoMessages("Abhishek yadav","50","135701525113","ICIC0001437");
        Log.info("======= END  : Info  message on add new property on Amount page =======");

    }


    @Test(groups = {"impsCheckout", "impsSanity","regression"}, priority = 0, description = "Checkout options on Imps")
    public void Test06_imps_new_account_checkout_option() throws IOException, InterruptedException {

        Log.info("======= START : Checkout option on IMPS page  =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("9205299330","547372");

        IMPSNewHelper impsHelper = new IMPSNewHelper(getAndroidDriver());
        impsHelper.verifyIMPSCheckout("Abhishek Yadav","135701525113","ICIC0001437","9000","492");
        Log.info("======= END  : Checkout option on IMPS page   =======");

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


