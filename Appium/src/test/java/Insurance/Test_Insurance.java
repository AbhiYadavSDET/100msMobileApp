package Insurance;

import Helpers.FixedDepositHelper;
import Helpers.InsuranceHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Insurance extends TestBase {

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Insurance Home Screen")
    public void Test_Insurance_Homescreen() throws IOException, InterruptedException {
        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.insuranceHomePage("Insurance","Group Insurance","Retail Insurance","Loss of Job","Personal Accident Insurance","Wallet Protect","Health Insurance","DocAssure","Pay your existing insurance Premium");

    }

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Doc Assure")
    public void Test_DocAssure() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.docAssureInsurance("DocAssure","Select Sum Insured","Product Benefits","Market Value","Partner Name","Start Date","End Date","Amount to be paid","Payable Amount");

    }


    @Test(groups = {"insurance", "sanity", "regression"}, priority = 0, description = "Verify Wallet Protect")
    public void Test_WalletProtect() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.walletProtectInsurance("Wallet Protect","Select Sum Insured","Product Benefits","Coverage","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }

}
