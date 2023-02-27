package ViewElectricityBill;

import Helpers.CCBPHelper;
import Helpers.ElectricityHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewElectricityBillTest extends TestBase {

    @Test(groups = {"sanity", "view electricity bill"}, priority = 0, description = "view electricity bill")

    public void viewElectricityBill() throws InterruptedException, IOException {


        Log.info("======= START : P2M Send test =======");
        // Starting the test in the extentreport
        ExtentReport.EXTENTREPORT.createTest("CCBP test");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        Log.info("======= START : View Electricity Bill =======");

        // Execute the test
        ElectricityHelper electricityHelper  = new ElectricityHelper(getAndroidDriver());
        electricityHelper.viewElectricityBill("KULDIP","04 Mar 2023","101003577","BSES Yamuna","1,320","BSES Yamuna", "101003577");

        Log.info("======= END : View Electricity Bill =======");
    }

}
