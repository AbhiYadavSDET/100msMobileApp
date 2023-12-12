package PipedGas;

import Helpers.ElectricityHelper;
import Helpers.LoginHelper;
import Logger.Log;
import org.testng.annotations.Test;
import java.io.IOException;

public class PipedGasTest {


    @Test(groups = {"viewPipedGasBill"}, priority = 0, description = "View Piped Gas Bill on Ios app")

    public void Test_View_PipedGas_Bill() throws InterruptedException, IOException {

        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("9205299330", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : View Electricity Bill test =======");

        ElectricityHelper electricityHelper = new ElectricityHelper(getIosDriver());
        electricityHelper.viewElectricityBill("KOTA","21234", "210736016179","ANJANA  JAIN","Kota Electricity Distribution Limited (KEDL)");
        Log.info("======= END : Electricity Bill test =======");

    }
}
