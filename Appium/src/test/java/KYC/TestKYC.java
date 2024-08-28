package KYC;

import Helpers.KYCHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestKYC extends TestBase {


    //==================================New test cases as per 3 step kyc========================================//

    @Test(enabled = true, groups = {"kycSanity", "regression", "OnboardingFullkyc"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void KYC_Test01_OnBoarding_Full_Kyc_Flow() throws IOException, InterruptedException {

        Log.info("======= START : CKYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006", "547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006", "547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingFullKycFlow("Abhishek", "Yadav", "HTIPK7865M", "585121567144", "000000", false);
        Log.info("======= END : CKYC flow from Onboarding =======");

    }

    @Test(enabled = true, groups = {"kycSanity", "regression", "OnboardingCkycFlow"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void KYC_Test02_OnBoarding_Ckyc_Flow() throws IOException, InterruptedException {

        Log.info("======= START : CKYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006", "547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900001", "547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingFullKycFlow("Abhishek", "Yadav", "HTIPK7865M", "585121567144", "000000", true);
        Log.info("======= END : CKYC flow from Onboarding =======");

    }

    @Test(enabled = true, groups = {"kycSanity", "regression", "sanity", "ProfileFullLKycFlow"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void KYC_Test03_Profile_Full_Kyc_Flow() throws IOException, InterruptedException {

        Log.info("======= START : Full flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006", "547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L", "Abhishek", "kumar", "", "", "585121567144", "000000", false);
        Log.info("======= END : Full flow from Profile =======");

    }

    @Test(enabled = true, groups = {"kycSanity", "regression", "sanity", "ProfileCKYCFlow"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void KYC_Test04_Profile_Ckyc_Flow() throws IOException, InterruptedException {

        Log.info("======= START : CKYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001", "547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L", "Abhishek", "kumar", "", "", "585121567144", "000000", true);
        Log.info("======= END : CKYC flow from Profile =======");

    }


    @Test(enabled = false, groups = {"NoKYC", "minKycerrorMessage", "regression"}, priority = 0, description = " min kyc user - Error message validation on Non kyc flow")
    public void KYC_Test05_minKyc_user_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via ckyc Error message validation =======");


        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001", "547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnCKycFlow();
        Log.info("======= END :  min kyc user - Full KYC flow via ckyc Error message validation ======");

    }

    // No number is present who is non kyc user.
    @Test(enabled = false, groups = {"minKYCFromProfile", "kycSanity", "regression"}, priority = 0, description = "min KYC flow from Profile")
    public void KYC_Test06_min_KYC_FLOW_From_Profile() throws IOException, InterruptedException {

        Log.info("======= START : min KYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006", "547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileMinKycFlow("HTIPK7865L", "Abhishek Yadav", "Provide below details", "Self Declared Verification", "Your wallet limit will increase to ₹ 10,000");
        Log.info("======= END : min KYC flow from Profile =======");

    }


}
