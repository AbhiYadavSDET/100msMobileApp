package BajajFeatures;

import DeepLink.DeepLinkDataProviderClass;
import Helpers.*;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;


public class Test_Bajaj extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

//    @Test(groups = {"busValidateEmiCard", "bajajSanity"}, priority = 0, dataProvider = "bajajData", dataProviderClass = BajajProviderClass.class)
@Test(groups = {"busValidateEmiCard", "bajajSanity"}, priority = 0)
    public void Test01_Validate_Emi_Card() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        BajajPageHelper bajajPageHelper= new BajajPageHelper(getAndroidDriver());
//        bajajPageHelper.validateEmiCardAndDetails("20111989");
    bajajPageHelper.validateEmiCardAndDetails("27031993");


    }

//    @Test(groups = {"busValidateInstaCredit", "bajajSanity"}, priority = 1, dataProvider = "bajajData", dataProviderClass = BajajProviderClass.class)
@Test(groups = {"busValidateInstaCredit", "bajajSanity"}, priority = 1)
    public void Test02_Validate_Insta_credit() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//    loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
    loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");


        BajajPageHelper bajajPageHelper= new BajajPageHelper(getAndroidDriver());
        bajajPageHelper.validateInstaCreditVisible();


    }


//    @Test(groups = {"busValidateHomePageAds", "bajajSanity"}, priority = 2, dataProvider = "bajajData", dataProviderClass = BajajProviderClass.class)
@Test(groups = {"busValidateHomePageAds", "bajajSanity"}, priority = 2)
    public void Test03_Validate_Home_Page_Ads() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        BajajPageHelper bajajPageHelper= new BajajPageHelper(getAndroidDriver());
        bajajPageHelper.validateAdsAreVisible();

    }


    @Test(groups = {"deeplink","upiDeeplink" ,"bajajSanity"}, priority = 3)
    public void Test04_Deep_Link_Upi() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://upi", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://upi/verifyVpa?vpa=<VPA>", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://upi/pending", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://upi/request", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://upi/selftransfer", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://upi/collect", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://upi/transfer", "Wallet");

        Thread.sleep(2000);



    }


    @Test(groups = {"deeplink","boostDeeplink" ,"bajajSanity"}, priority = 4)
    public void Test05_Deep_Link_Boost() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://loanpreview", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://loans", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://enach", "Wallet");

        Thread.sleep(2000);



    }


    @Test(groups = {"deeplink","referDeeplink" ,"bajajSanity"}, priority = 5)
    public void Test06_Deep_Link_Refer() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://refer", "Wallet");

        Thread.sleep(2000);





    }

    @Test(groups = {"deeplink","zipDeeplink" ,"bajajSanity"}, priority = 6)
    public void Test07_Deep_Link_Zip() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://paylater?utm_source=HomeIcon", "Wallet");

        Thread.sleep(2000);


    }



    @Test(groups = {"deeplink","grandSlamDeeplink" ,"bajajSanity"}, priority = 7)
    public void Test08_Deep_Link_Grandslam() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://grandslam-info", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://grandslam-profile", "Wallet");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://grandslam-received", "Wallet");

        Thread.sleep(2000);


    }


    @Test(groups = {"deeplink","insurnaceDeeplink" ,"bajajSanity"}, priority = 8)
    public void Test09_Deep_Link_Insurance() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance/manage", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance/personal-accident-insurance", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance/life-insurance", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance/cyber-insurance", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance/hospicash", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance/gas-insurance", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);

        deepLinkHelper.validateDeeplink("mobikwik://buy-insurance?policyId=POLMBK62AAE0D50", "Wallet", "icon_drawer", "Insurance");

        Thread.sleep(2000);


    }


    @Test(groups = {"deeplink","mutualFundsDeeplink" ,"bajajSanity"}, priority = 9)
    public void Test10_Deep_Link_MutualFunds() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://mutual-funds", "Wallet", "icon_drawer", "Mutual Funds");

        Thread.sleep(2000);


        deepLinkHelper.validateDeeplink("mobikwik://mutual-funds/sip", "Wallet", "icon_drawer", "Mutual Funds");

        Thread.sleep(2000);


        deepLinkHelper.validateDeeplink("mobikwik://mutual-funds/lumpsum", "Wallet", "icon_drawer", "Mutual Funds");

        Thread.sleep(2000);


        deepLinkHelper.validateDeeplink("mobikwik://mutual-funds/instant-redemption", "Wallet", "icon_drawer", "Mutual Funds");

        Thread.sleep(2000);


    }





}