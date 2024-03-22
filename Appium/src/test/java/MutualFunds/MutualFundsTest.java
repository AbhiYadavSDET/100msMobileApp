package MutualFunds;

import Helpers.LoginHelper;
import Helpers.MutualFundsHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class MutualFundsTest extends TestBase {

    @Test(groups = {"MutualFunds", "sanity", "sanityPrime", "regression"}, priority = 0, description = "Explore Mutual Funds")
    public void Test_MF_Explore_Mutual_Funds() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.mutualFundsCheck("ICICI Pru Commodities Dir Gr", "₹5,000", "+48.25%", "N/A ", "KYC pending", "You need a KYC to invest in Mutual Funds. Please provide your details to complete your KYC", "Complete KYC");

        Log.info("======= END : Mutual Funds Flow test =======");


    }

    @Test(groups = {"MutualFunds", "sanity", "riskAnalyser", "regression"}, priority = 0, description = "Retake risk analyser ")
    public void Test_MF_Retake_Risk_Analyser() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds Risk analyser Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.retakeRiskAnalyser();

        Log.info("======= END : Mutual Funds Risk analyser Flow test =======");
    }

    @Test(groups = {"MutualFunds", "sanity", "faq", "regression"}, priority = 0, description = "Retake risk analyser ")
    public void Test_MF_FAQ() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds FAQ Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.faq();

        Log.info("======= END : Mutual Funds FAQ Flow test =======");
    }

    @Test(groups = {"MutualFunds", "sanity", "privacyPolicy", "regression"}, priority = 0, description = "Retake risk analyser ")
    public void Test_MF_PrivacyPolicy() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds privacy policy analyser Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.privacyPolicy();

        Log.info("======= END : Mutual Funds privacy policy  Flow test =======");
    }



    @Test(groups = {"MutualFunds", "sanity", "mutlipleFDsOptions", "regression"}, priority = 0, description = "Retake risk analyser ")
    public void Test_MF_multipleFdsOptions() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds privacy policy analyser Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.multipleFDsOptions();

        Log.info("======= END : Mutual Funds privacy policy  Flow test =======");
    }

    @Test(groups = {"MutualFunds", "sanity", "investCharter", "regression"}, priority = 0, description = "Invest charter on mutual funds ")
    public void Test_MF_InvestCharter() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds Invest charter Flow test =======");

        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.investCharter();

        Log.info("======= END : Mutual Funds Invest charter Flow test =======");
    }
    @Test(groups = {"MutualFunds", "sanity", "termsAndConditions", "regression"}, priority = 0, description = "Terms and conditions on MF ")
    public void Test_MF_TermsAndConditions() throws InterruptedException, IOException {

        Log.info("======= START : Mutual Funds Terms and conditions Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.termsAndConditions();

        Log.info("======= END :Mutual Funds Terms and conditions Flow test======");
    }

    @Test(groups = {"MutualFunds", "sanity", "profileUpdate", "regression"}, priority = 0, description = "Profile updation on MF ")
    public void Test_MF_ProfileUpdate() throws InterruptedException, IOException {

        Log.info("======= START : MF Profile update Flow test =======");


        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.updateProfile("AQXPJ9529K","12/10/2000","mkwik9330@gmail.com","1 to 5 Lacks","Balanced", "Get Rich Fund");

        Log.info("======= END : MF Profile update Flow test ======");
    }

    @Test(groups = {"MutualFunds", "sanity", "profileUpdate", "regression"}, priority = 0, description = "Verify Filters")
    public void Test_MF_FilterOptions() throws InterruptedException, IOException {

        Log.info("======= START : MF Filter test =======");

        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.verifyFilter("icici","ICICI Pru Bluechip Dir Gr","₹100","+20.42%","5","No funds available");

        Log.info("======= END : MF Filter test ======");
    }

    @Test(groups = {"MutualFunds", "sanity", "profileUpdate", "regression"}, priority = 0, description = "Verify Sorting of funds based on tenure")
    public void Test_MF_Sort() throws InterruptedException, IOException {

        Log.info("======= START : MF Sort test =======");

        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.verifySort("5Y Returns");

        Log.info("======= END : MF Sort test ======");
    }

    @Test(groups = {"MutualFunds", "sanity", "profileUpdate", "regression"}, priority = 0, description = "Verify Search MF")
    public void Test_MF_SearchMF() throws InterruptedException, IOException {

        Log.info("======= START : MF Search test =======");

        // Start the test
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        MutualFundsHelper mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());
        mutualFundsHelper.verifySearchMF("Parag", "Parag Parikh Cnsv Hyb Dir Gr","₹5,000","+32.40%","N/A ");

        Log.info("======= END : MF Search test ======");
    }
}

