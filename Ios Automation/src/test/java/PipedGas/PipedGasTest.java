package PipedGas;

import Helpers.LoginHelper;
import Helpers.PipedGasHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class PipedGasTest extends TestBase {


    @Test(groups = {"ViewPipedGasBill"}, priority = 0, description = "View Piped Gas Bill on Ios app")

    public void Test_View_PipedGas_Bill() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : View Electricity Bill test =======");

        PipedGasHelper pipedGasHelper = new PipedGasHelper(getIosDriver());
        pipedGasHelper.viewPipedGasBill("Aavantika","21234", "PD01RNV1208","Mrs. Ratna  Sharma","Aavantika Gas Ltd.");
        Log.info("======= END : Electricity Bill test =======");

    }
}
