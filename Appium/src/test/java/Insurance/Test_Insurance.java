package Insurance;

import Helpers.FixedDepositHelper;
import Helpers.InsuranceHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Insurance extends TestBase {


   /* @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Personal Accident Insurance payment success screen")
    public void Test_payment_of_PersonalAccident_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.personalAccidentInsuranceBuy();

    }*/

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 0, description = "My PolicyRefund")
    public void Test_insurance_mypolicy_refund() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.mypolicyRefund("Full Name","Select Gender","Mobile Number","Congratulations","Download Policy");

    }

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
    public void Test_DocAssure_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.docAssureInsurance("DocAssure","Select Sum Insured","Product Benefits","Market Value","Partner Name","Start Date","End Date","Amount to be paid","Payable Amount");

    }

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Wallet Protect")
    public void Test_WalletProtect_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.walletProtectInsurance("Wallet Protect","Select Sum Insured","Product Benefits","Coverage","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Hospicash Protect")
    public void Test_Hospicash_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.hospicashInsurance("Hospital Cash + Personal Accident","Select Sum Insured","Your policy covers","30 Days Coverage","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Dengue Insurance")
    public void Test_Dengue_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.dengueInsurance("Dengue Insurance","Select Sum Insured","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Communicable Diseases Insurance")
    public void Test_Communicable_Diseases_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.communicableDisesInsurance("Communicable Diseases","Select Sum Insured","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }

    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Personal Accident Insurance")
    public void Test_Personal_Accident_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7042338867", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.comprehensivePersonalAccidentInsurance("Comprehensive Accidental Insurance","Select Sum Insured","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }


    @Test(groups = {"insurance", "sanity", "regression"}, priority = 1, description = "Verify Personal Accident Insurance")
    public void Test_Loss_of_Job_insurance() throws IOException, InterruptedException {

        Log.info("======= START : Insurance =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.lossOfJobInsurance("Loss of Job","Select Sum Insured","Insured By","Start Date","End Date","Amount to be paid","Payable Amount");

    }




}
