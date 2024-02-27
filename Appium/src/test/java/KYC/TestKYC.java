package KYC;

import Helpers.IMPSNewHelper;
import Helpers.KYCHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestKYC extends TestBase {
    @Test(groups = {"NoKYC", "kycSanity","regression"}, priority = 0, description = "Non KYC flow from Onboarding")
    public void Test06_No_KYC_FLOW_From_Onboarding() throws IOException, InterruptedException {

        Log.info("======= START : Non KYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingNonKycFlow("Abhishek","Yadav","HTIPK7865L");
        Log.info("======= END : Non KYC flow from Onboarding =======");

    }

    @Test(groups = {"NoKYC", "errorMessage","regression"}, priority = 0, description = "Error message validation on Non kyc flow")
    public void Test06_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : Non KYC flow Error message validation =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnNonKycFlow();
        Log.info("======= END : Non KYC flow Error message validation ======");

    }


    @Test(groups = {"minKYCProfile", "kycSanity","regression"}, priority = 0, description = "min KYC flow from Profile")
    public void Test11_min_KYC_FLOW_From_Profile() throws IOException, InterruptedException {

        Log.info("======= START : min KYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileMinKycFlow("HTIPK7865L","Abhishek Yadav", "Provide below details", "Self Declared Verification", "Your wallet limit will increase to ₹ 10,000");
        Log.info("======= END : min KYC flow from Profile =======");

    }

    @Test(groups = {"fullKYCProfile", "kycSanity","regression"}, priority = 0, description = "CKYC KYC flow from Profile")
    public void Test12_CKYC_full_KYC_FLOW_From_Profile() throws IOException, InterruptedException {

        Log.info("======= START : CKYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","Abhishek", "Yadav");
        Log.info("======= END : CKYC flow from Profile =======");

    }
}
