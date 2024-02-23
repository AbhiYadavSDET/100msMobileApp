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
}
