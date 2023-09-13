package ViewPipedGasBill;

import Helpers.LoginHelper;
import Helpers.PipedGasHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewPipedGasBillTest extends TestBase {

        @Test(groups = {"sanity", "rechargeSanity"}, priority = 0, description = "View Piped Gas Bill")

        public void viewPipedGasBill() throws InterruptedException, IOException {


            Log.info("======= START : Login Test =======");
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
