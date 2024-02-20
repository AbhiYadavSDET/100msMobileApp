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
}

