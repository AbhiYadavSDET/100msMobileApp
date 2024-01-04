package Electricity;

import Helpers.ElectricityHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElectricityTest extends TestBase {

        @Test(groups = {"ViewElectricityBill", "regression"}, priority = 0, description = "View Electricity Bill on Ios app")

        public void Test_View_Electricity_Bill() throws InterruptedException, IOException {

            Log.info("======= START : Login test =======");

            LoginHelper loginHelper = new LoginHelper(getIosDriver());
            loginHelper.loginViaOtp("9205299330", "547372");

            Log.info("======= END : Login test =======");

            Log.info("======= START : View Electricity Bill test =======");

            ElectricityHelper electricityHelper = new ElectricityHelper(getIosDriver());
            electricityHelper.viewElectricityBill("KOTA","21234", "210736016179","ANJANA  JAIN","Kota Electricity Distribution Limited (KEDL)", "Payment received for the billing period, no bill due");
            Log.info("======= END : Electricity Bill test =======");

        }
}
