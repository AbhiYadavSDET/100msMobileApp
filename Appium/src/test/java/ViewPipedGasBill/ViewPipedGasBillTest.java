package ViewPipedGasBill;

import Helpers.ElectricityHelper;
import Helpers.LoginHelper;
import Helpers.PipedGasHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewPipedGasBillTest extends TestBase {

        @Test(groups = {"sanity", "View Piped Gas Bill"}, priority = 0, description = "View Piped Gas Bill")

        public void viewPipedGasBill() throws InterruptedException, IOException {


            Log.info("======= START : P2M Send test =======");
            // Starting the test in the extentreport
            ExtentReport.EXTENTREPORT.createTest("CCBP test");

            // Login to the account
            LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
            loginHelper.quickLoginViaOtp("9205299330", "547372");

            Log.info("======= START : View Piped Gas Bill =======");

            // Execute the test
            PipedGasHelper pipedGasHelper  = new PipedGasHelper(getAndroidDriver());
            pipedGasHelper.viewPipedGasBill("Ravindra Thakkar","1000236410","Adani Gas","Adani Gas","1000236410");

            Log.info("======= END : View Piped Gas Bill =======");
        }

}
