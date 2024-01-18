package IMPS;

import Helpers.CCBPHelper;
import Helpers.IMPSHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class IMPSTest extends TestBase {

    @Test(groups = {"Imps", "regression"}, priority = 1, description = "Verify transfer to account")

    public void Test_TransferToAccount_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Transfer to Account Flow test =======");

        IMPSHelper impsHelper = new IMPSHelper(getIosDriver());
        impsHelper.transferToAccountNumber("Vikrant","006198700002090","YESB0000061","Vikrant","Bank A/C : 006198700002090, YESB0000061","4000","₹4,000");

        Log.info("======= END : Transfer to Account Flow test =======");

    }
    @Test(groups = {"Imps", "regression"}, priority = 1, description = "Verify check limits bottom sheet")

    public void Test_CheckLimit_Screen() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Check Limit Flow test =======");

        IMPSHelper impsHelper = new IMPSHelper(getIosDriver());
        impsHelper.checkImpsLimit("TRANSFER LIMITS");

        Log.info("======= END : Check Limit Flow test =======");

    }

    @Test(groups = {"Imps", "regression"}, priority = 1, description = "Verify warning message on account number")

    public void Test_WarningMessage_AccountNumber() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Check warning error message on tranfer to account flow =======");

        IMPSHelper impsHelper = new IMPSHelper(getIosDriver());
        impsHelper.warningMessagesOnAccountNumber("Beneficiary Name, Beneficiary Name cannot be empty","Vikrant","Account Number, Account Number cannot be empty","006198700002090","IFSC Code, IFSC Code cannot be empty");

        Log.info("======= END : Check Check warning error message on tranfer to account flow =======");

    }

    @Test(groups = {"Imps", "regression"}, priority = 1, description = "Verify transfer to UPI Id Flow")

    public void Test_TransferToUpiId_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("7795709569", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Check Transfer to UPI Id Flow test =======");

        IMPSHelper impsHelper = new IMPSHelper(getIosDriver());
        impsHelper.transferToUpiId("nagarvikrant671@oksbi","Mr Vikrant Nagar","nagarvikrant671@oksbi","4000");

        Log.info("======= END : Check Transfer to UPI Id Flow test =======");

    }

    @Test(groups = {"Imps", "regression"}, priority = 0, description = "Verify warning error message on UPI Id field")

    public void Test_WarningMessage_UPI() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Check warning error message on tranfer to upi id flow=======");

        IMPSHelper impsHelper = new IMPSHelper(getIosDriver());
        impsHelper.warningMessagesOnUpi("UPI ID, Please enter valid UPI Id");

        Log.info("======= END : Check warning error message on tranfer to upi id flow =======");

    }
}


