package FixedDeposit;

import Helpers.FixedDepositHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_FixedDeposit extends TestBase {


    @Test(groups = {"FixedDeposit", "sanity", "regression"}, priority = 0, description = "Verify Existing User Fixed deposit Home Page")
    public void Test01_existing_User_Dashboard() throws IOException, InterruptedException {

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtp("7042338867", "547372");
        FixedDepositHelper fixedDepositHelper = new FixedDepositHelper(getAndroidDriver());
        // Execute the test
        fixedDepositHelper.existingUserHomePage("View Investment Activity","TOP PLANS","Interest","Tenure","Book","Choose Custom Tenure",
                "Females  upto 0.1% more ","Sr. Citizen  upto 0.5% more","Maximize Your FD Returns","Frequently Asked Questions","Contact us");
        Log.info("======= Fixed Deposit test =======");

    }

}
