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


    @Test(groups = {"deeplink", "bajajSanity"}, priority = 3)
    public void Test04_Deep_Link() throws IOException, JSONException, InterruptedException {


        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("amityd321@gmail.com", "Test@1234");

        DeepLinkHelper deepLinkHelper = new DeepLinkHelper(getAndroidDriver());

        deepLinkHelper.validateDeeplink("mobikwik://upi", "Wallet", "service_name");


    }









}