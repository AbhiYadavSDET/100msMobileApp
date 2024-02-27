package KYC;

import Helpers.IMPSNewHelper;
import Helpers.KYCHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestKYC extends TestBase {
    @Test(groups = {"NoKYC", "kycSanity","regression","onboardingFlow"}, priority = 0, description = "Full KYC flow from Onboarding")
    public void Test01_full_KYC_FLOW_From_Onboarding() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingNonKycFlow("Abhishek","Yadav","HTIPK7865L");
        Log.info("======= END : Full KYC flow from Onboarding =======");

    }

    @Test(groups = {"NoKYC", "errorMessage","regression"}, priority = 0, description = "Error message validation on Non kyc flow")
    public void Test02_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow Error message validation =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnNonKycFlow();
        Log.info("======= END : Full KYC flow Error message validation ======");

    }

    @Test(groups = {"NoKYC", "FullKycViaCKYC","regression"}, priority = 0, description = "Full kyc flow via CKYC")
    public void Test03_fULL_KYC_FLOW_VIA_CKYC() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via CKYC =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYC();
        Log.info("======= END : Full KYC flow via CKYC ======");

    }

    @Test(groups = {"NoKYC", "FullKycViaDigilocker","regression"}, priority = 0, description = "Full kyc flow via digilocker")
    public void Test04_fULL_KYC_FLOW_VIA_DIGILOCKER() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via DIGILOCKER =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromDigilocker("5851","2156","7144","123456");

        Log.info("======= END : Full KYC flow via DIGILOCKER ======");

    }


    @Test(groups = {"NoKYC", "FullKycViaAdhaarWebsite","regression"}, priority = 0, description = "Full kyc flow via adhaar website")
    public void Test05_fULL_KYC_FLOW_VIA_Adhaar_Website() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromAdharWebsite("5851 2156 7144","123456");

        Log.info("======= END : Full KYC flow via Adhaar website ======");

    }

    @Test(groups = {"NoKYC", "FullKycViaCKYCOnailureViaAdhaarWebsite","regression"}, priority = 0, description = "Full kyc flow via ckyc on  FAILURE FROM Adhaar website ")
    public void Test06_fULL_KYC_FLOW_VIA_CKYC_ON_FAILURE_FROM_ADHARWEBSITE() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow - On FAILURE FROM Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYCOnFailureFromAdhaarWebsite("5851 2156 7144","123456","Abhishek","Yadav","HTIPK7865M");

        Log.info("======= END : Full KYC flow Via ckyc - On FAILURE FROM Adhaar website ======");

    }
}
