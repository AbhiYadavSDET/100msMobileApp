package KYC;

import Helpers.IMPSNewHelper;
import Helpers.KYCHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestKYC extends TestBase {
    @Test(groups = {"NoKYC", "kycSanity","regression","NonKyconboardingFlow"}, priority = 0, description = "No kyc user - Full KYC flow from Onboarding")
    public void Test01_NoKyc_user_full_KYC_FLOW_From_Onboarding() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingNonKycFlow("Abhishek","Yadav","HTIPK7865L");
        Log.info("======= END : Full KYC flow from Onboarding =======");

    }

    @Test(groups = {"NoKYC", "NonKycerrorMessage","regression"}, priority = 0, description = "No kyc user - Error message validation on Non kyc flow")
    public void Test02_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow Error message validation =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnNonKycFlow();
        Log.info("======= END : Full KYC flow Error message validation ======");

    }

    @Test(groups = {"NoKYC", "NonKycFullKycViaCKYC","regression"}, priority = 0, description = "No kyc user - Full kyc flow via CKYC")
    public void Test03_NoKyc_user_fULL_KYC_FLOW_VIA_CKYC() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via CKYC =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYC();
        Log.info("======= END : Full KYC flow via CKYC ======");

    }

    @Test(groups = {"NoKYC", "NonKycFullKycViaDigilocker","regression"}, priority = 0, description = "No kyc user - Full kyc flow via digilocker")
    public void Test04_NoKyc_user_fULL_KYC_FLOW_VIA_DIGILOCKER() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via DIGILOCKER =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromDigilocker("5851","2156","7144","123456");

        Log.info("======= END : Full KYC flow via DIGILOCKER ======");

    }


    @Test(groups = {"NoKYC", "NonKycFullKycViaAdhaarWebsite","regression"}, priority = 0, description = "No kyc user - Full kyc flow via adhaar website")
    public void Test05_NoKyc_user_fULL_KYC_FLOW_VIA_Adhaar_Website() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromAdharWebsite("5851 2156 7144","123456");

        Log.info("======= END : Full KYC flow via Adhaar website ======");

    }

    @Test(groups = {"NoKYC", "NonKycFullKycViaCKYCOnailureViaAdhaarWebsite","regression"}, priority = 0, description = "No kyc user - Full kyc flow via ckyc on  FAILURE FROM Adhaar website ")
    public void Test06_NoKyc_user_fULL_KYC_FLOW_VIA_CKYC_ON_FAILURE_FROM_ADHARWEBSITE() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow - On FAILURE FROM Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYCOnFailureFromAdhaarWebsite("5851 2156 7144","123456","Abhishek","Yadav","HTIPK7865M");

        Log.info("======= END : Full KYC flow Via ckyc - On FAILURE FROM Adhaar website ======");

    }

    //

    @Test(groups = {"NoKYC", "kycSanity","regression","minKycOnboardingFlow"}, priority = 0, description = "min kyc user -  Full KYC flow from Onboarding")
    public void Test07_minKyc_user_full_KYC_FLOW_From_Onboarding() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user - Full KYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingNonKycFlow("Abhishek","Yadav","HTIPK7865L");
        Log.info("======= END :min kyc user - Full KYC flow from Onboarding =======");

    }

    @Test(groups = {"NoKYC", "minKycerrorMessage","regression"}, priority = 0, description = " min kyc user - Error message validation on Non kyc flow")
    public void Test08_minKyc_user_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow Error message validation =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnNonKycFlow();
        Log.info("======= END :  min kyc user - Full KYC flow Error message validation ======");

    }

    @Test(groups = {"NoKYC", "minKycFullKycViaCKYC","regression"}, priority = 0, description = " min kyc user - Full kyc flow via CKYC")
    public void Test09_minKyc_user_NoKyc_user_fULL_KYC_FLOW_VIA_CKYC() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via CKYC =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYC();
        Log.info("======= END :  min kyc user - Full KYC flow via CKYC ======");

    }

    @Test(groups = {"NoKYC", "minKycFullKycViaDigilocker","regression"}, priority = 0, description = " min kyc user - Full kyc flow via digilocker")
    public void Test010_minKyc_user_fULL_KYC_FLOW_VIA_DIGILOCKER() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via DIGILOCKER =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromDigilocker("5851","2156","7144","123456");

        Log.info("======= END : min kyc user -  Full KYC flow via DIGILOCKER ======");

    }


    @Test(groups = {"NoKYC", "minKycFullKycViaAdhaarWebsite","regression"}, priority = 0, description = " min kyc user -Full kyc flow via adhaar website")
    public void Test011_minKyc_user_fULL_KYC_FLOW_VIA_Adhaar_Website() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromAdharWebsite("5851 2156 7144","123456");

        Log.info("======= END :  min kyc user - Full KYC flow via Adhaar website ======");

    }

    @Test(groups = {"NoKYC", "minKycFullKycViaCKYCOnailureViaAdhaarWebsite","regression"}, priority = 0, description = " min kyc user -Full kyc flow via ckyc on  FAILURE FROM Adhaar website ")
    public void Test012_minKyc_user_fULL_KYC_FLOW_VIA_CKYC_ON_FAILURE_FROM_ADHARWEBSITE() throws IOException, InterruptedException {

        Log.info("======= START :  min kyc user - Full KYC flow - On FAILURE FROM Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYCOnFailureFromAdhaarWebsite("5851 2156 7144","123456","Abhishek","Yadav","HTIPK7865M");

        Log.info("======= END :  min kyc user - Full KYC flow Via ckyc - On FAILURE FROM Adhaar website ======");

    }

}
