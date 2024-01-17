package IMPS;

import Helpers.CCBPHelper;
import Helpers.IMPSHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class IMPSTest extends TestBase {

    @Test(groups = {"Imps", "regression"}, priority = 0, description = "Verify transfer to account")

    public void Test_TransferToAccount_Flow() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Transfer to Account Flow test =======");

        IMPSHelper impsHelper = new IMPSHelper(getIosDriver());
        impsHelper.transferToAccountNumber("Vikrant","006198700002090","YESB0000061","Vikrant","Bank A/C : 006198700002090, YESB0000061","4000","₹5,000");

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
}


