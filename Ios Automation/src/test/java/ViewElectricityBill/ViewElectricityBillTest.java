package ViewElectricityBill;

import Helpers.ElectricityHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewElectricityBillTest extends TestBase {

    @Test(groups = {"sanity", "rechargeSanity", "regression"}, priority = 0, description = "view electricity bill")

    public void viewElectricityBill() throws InterruptedException, IOException {

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : View Electricity Bill =======");

        // Execute the test
        ElectricityHelper electricityHelper = new ElectricityHelper(getAndroidDriver());
        electricityHelper.viewElectricityBill("KULDIP", "04 Mar 2023", "60003686668", "Tata Power Delhi Distribution Ltd - TTPDDL", "1,320", "Tata Power", "60003686668");

        Log.info("======= END : View Electricity Bill =======");
    }

}
