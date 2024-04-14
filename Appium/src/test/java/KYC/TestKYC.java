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

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingNonKycFlow("Abhishek","Yadav","HTIPK7865L");
        Log.info("======= END : Full KYC flow from Onboarding =======");

    }

    @Test(groups = {"NoKYC", "NonKycerrorMessage","regression"}, priority = 0, description = "No kyc user - Error message validation on Non kyc flow")
    public void Test02_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow Error message validation =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnNonKycFlow();
        Log.info("======= END : Full KYC flow Error message validation ======");

    }

    @Test(groups = {"NoKYC", "NonKycFullKycViaMultipleWay","regression", "sanity"}, priority = 0, description = "No kyc user - Full kyc flow via CKYC,Digilocker,Adhaar website")
    public void Test03_NoKyc_user_fULL_KYC_FLOW_VIA_CKYC() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via CKYC =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromOnboardingBackPress("Abhishek","yadav","HTIPK7865M","585121567144","000000","5851 2156 7144","123456");


        Log.info("======= END : Full KYC flow via CKYC ======");

    }

    @Test(groups = {"NoKYC", "NonKycFullKycViaDigilocker","regression", "sanity"}, priority = 0, description = "No kyc user - Full kyc flow via digilocker")
    public void Test04_NoKyc_user_fULL_KYC_FLOW_VIA_DIGILOCKER() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via DIGILOCKER =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromDigilocker("585121567144","123456");

        Log.info("======= END : Full KYC flow via DIGILOCKER ======");

    }


 /*   @Test(groups = {"NoKYC", "NonKycFullKycViaAdhaarWebsite","regression", "sanity"}, priority = 0, description = "No kyc user - Full kyc flow via adhaar website")
    public void Test05_NoKyc_user_fULL_KYC_FLOW_VIA_Adhaar_Website() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow via Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());

        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromAdharWebsite("5851 2156 7144","123456");

        Log.info("======= END : Full KYC flow via Adhaar website ======");

    }*/

    @Test(groups = {"NoKYC", "NonKycFullKycViaCKYCOnailureViaAdhaarWebsite","regression"}, priority = 0, description = "No kyc user - Full kyc flow via ckyc on  FAILURE FROM Adhaar website ")
    public void Test06_NoKyc_user_fULL_KYC_FLOW_VIA_CKYC_ON_FAILURE_FROM_ADHARWEBSITE() throws IOException, InterruptedException {

        Log.info("======= START : Full KYC flow - On FAILURE FROM Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYCOnFailureFromAdhaarWebsite("5851 2156 7144","123456","Abhishek","Yadav","HTIPK7865M");

        Log.info("======= END : Full KYC flow Via ckyc - On FAILURE FROM Adhaar website ======");

    }
    @Test(groups = {"NoKYC", "kycSanity","regression","minKycOnboardingFlow"}, priority = 0, description = "min kyc user -  Full KYC flow from Onboarding")
    public void Test07_minKyc_user_full_KYC_FLOW_From_Onboarding() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user - Full KYC flow from Onboarding =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.OnboardingNonKycFlow("Abhishek","Yadav","HTIPK7865L");
        Log.info("======= END :min kyc user - Full KYC flow from Onboarding =======");

    }

    @Test(groups = {"NoKYC", "minKycerrorMessage","regression"}, priority = 0, description = " min kyc user - Error message validation on Non kyc flow")
    public void Test08_minKyc_user_No_KYC_FLOW_Error_message() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow Error message validation =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.ErrorMessageOnNonKycFlow();
        Log.info("======= END :  min kyc user - Full KYC flow Error message validation ======");

    }

    @Test(groups = {"NoKYC", "minKycFullKycViaMultipleWay","regression"}, priority = 0, description = " min kyc user - Full kyc flow via CKYC")
    public void Test09_minKyc_user_NoKyc_user_fULL_KYC_FLOW_VIA_CKYC() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via CKYC =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromOnboardingBackPress("Abhishek","yadav","HTIPK7865M","585121567144","000000","5851 2156 7144","qwerty");
        Log.info("======= END :  min kyc user - Full KYC flow via CKYC ======");

    }
/*
    @Test(groups = {"NoKYC", "minKycFullKycViaDigilocker","regression"}, priority = 0, description = " min kyc user - Full kyc flow via digilocker")
    public void Test10_minKyc_user_fULL_KYC_FLOW_VIA_DIGILOCKER() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via DIGILOCKER =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromDigilocker("585121567144", "123456");

        Log.info("======= END : min kyc user -  Full KYC flow via DIGILOCKER ======");

    }*/


 /*   @Test(groups = {"NoKYC", "minKycFullKycViaAdhaarWebsite","regression"}, priority = 0, description = " min kyc user -Full kyc flow via adhaar website")
    public void Test11_minKyc_user_fULL_KYC_FLOW_VIA_Adhaar_Website() throws IOException, InterruptedException {

        Log.info("======= START : min kyc user -  Full KYC flow via Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromAdharWebsite("5851 2156 7144","123456");

        Log.info("======= END :  min kyc user - Full KYC flow via Adhaar website ======");

    }*/

    @Test(groups = {"NoKYC", "minKycFullKycViaCKYCOnailureViaAdhaarWebsite","regression"}, priority = 0, description = " min kyc user -Full kyc flow via ckyc on  FAILURE FROM Adhaar website ")
    public void Test12_minKyc_user_fULL_KYC_FLOW_VIA_CKYC_ON_FAILURE_FROM_ADHARWEBSITE() throws IOException, InterruptedException {

        Log.info("======= START :  min kyc user - Full KYC flow - On FAILURE FROM Adhaar website =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        loginHelp.quickLogout();
        loginHelp.quickLoginFromProfile("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.fullKycFromCKYCOnFailureFromAdhaarWebsite("5851 2156 7144","123456","Abhishek","Yadav","HTIPK7865M");

        Log.info("======= END :  min kyc user - Full KYC flow Via ckyc - On FAILURE FROM Adhaar website ======");

    }



    @Test(groups = {"minKYCFromProfile", "kycSanity","regression"}, priority = 0, description = "min KYC flow from Profile")
    public void Test51_min_KYC_FLOW_From_Profile() throws IOException, InterruptedException {

        Log.info("======= START : min KYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileMinKycFlow("HTIPK7865L","Abhishek Yadav", "Provide below details", "Self Declared Verification", "Your wallet limit will increase to ₹ 10,000");
        Log.info("======= END : min KYC flow from Profile =======");

    }


    @Test(groups = {"fullKYCProfile", "kycSanity","regression", "sanity","ckycFlowProfileNoKyc"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void Test52_CKYC_FLOW_Profile_NoKyc() throws IOException, InterruptedException {

        Log.info("======= START : CKYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","585121567144","Abhishek", "Yadav", "CKYC", "NOKYC", "Complete your KYC ", "Upgrade your wallet limit for unlimited transactions");
        Log.info("======= END : CKYC flow from Profile =======");

    }

    @Test(groups = {"fullKYCProfile", "kycSanity","regression"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void Test53_Digilocker_FLOW_Profile_NoKyc() throws IOException, InterruptedException {

        Log.info("======= START : DIGILOCKER flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","585121567144","Abhishek", "Yadav", "DIGILOCKER", "NOKYC", "Complete your KYC ", "Upgrade your wallet limit for unlimited transactions");
        Log.info("======= END : DIGILOCKER flow from Profile =======");

    }

    @Test(groups = {"fullKYCProfile", "kycSanity","regression"}, priority = 0, description = "CKYC KYC flow from Profile for No Kyc User")
    public void Test54_OKYC_FLOW_Profile_NoKyc() throws IOException, InterruptedException {

        Log.info("======= START : OKYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900006","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","585121567144","Abhishek", "Yadav", "OKYC", "NOKYC", "Complete your KYC ", "Upgrade your wallet limit for unlimited transactions");
        Log.info("======= END : OKYC flow from Profile =======");

    }

    @Test(groups = {"fullKYCProfile", "kycSanity","regression"}, priority = 0, description = "CKYC KYC flow from Profile for Min Kyc User")
    public void Test55_CKYC_FLOW_Profile_MinKyc() throws IOException, InterruptedException {

        Log.info("======= START : CKYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","585121567144","Abhishek", "Yadav", "CKYC", "MINKYC", "Complete your KYC ", "Upgrade your wallet limit for unlimited transactions");
        Log.info("======= END : CKYC flow from Profile =======");

    }

    @Test(groups = {"fullKYCProfile", "kycSanity","regression"}, priority = 0, description = "CKYC KYC flow from Profile for Min Kyc User")
    public void Test56_Digilocker_FLOW_Profile_MinKyc() throws IOException, InterruptedException {

        Log.info("======= START : DIGILOCKER flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","585121567144","Abhishek", "Yadav", "DIGILOCKER", "MINKYC", "Complete your KYC ", "Upgrade your wallet limit for unlimited transactions");
        Log.info("======= END : DIGILOCKER flow from Profile =======");

    }

    @Test(groups = {"fullKYCProfile", "kycSanity","regression"}, priority = 0, description = "CKYC KYC flow from Profile for Min Kyc User")
    public void Test57_OKYC_FLOW_Profile_MinKyc() throws IOException, InterruptedException {

        Log.info("======= START : OKYC flow from Profile =======");

        LoginHelper loginHelp = new LoginHelper(getAndroidDriver());
        loginHelp.quickLoginViaOtpForNonKycUser("8216900001","547372");

        KYCHelper kycHelper = new KYCHelper(getAndroidDriver());
        kycHelper.profileFullKycFlow("HTIPK7865L","585121567144","Abhishek", "Yadav", "OKYC", "MINKYC","Complete your KYC ", "Upgrade your wallet limit for unlimited transactions");
        Log.info("======= END : OKYC flow from Profile =======");

    }


}
