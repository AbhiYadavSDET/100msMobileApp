package Offers;
/*
import Helpers.LoginHelper;
import Helpers.OfferHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.testng.annotations.Test;

/**
 * automated test to verify Offers
 */

//public class Test_Offer extends CreateSession {
//    OfferHelper offerHelperBase;

    /**
     * method to verify Offers from Home Screen
     *
     * @throws Exception
     */
    /*
    @Test(groups = {"offerSanity", "offerSearch"}, priority = 0, dataProvider = "offersData", dataProviderClass = OffersDataProviderClass.class)
    public void Test20_offerSearch(FrontEndEntity frontEndEntity) throws Exception {
        Log.infoStartTest("offerSearch");
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        offerHelperBase = new OfferHelper(getAndroidDriver());
        offerHelperBase.offerSearch("makemytrip", "Offer", "offerSearch");

        Log.infoEndTest("offerSearch");

    }

    @Test(groups = {"offerSanity", "offerCategoryCheck"}, priority = 1, dataProvider = "offersData", dataProviderClass = OffersDataProviderClass.class)
    public void Test21_offerCategoryCheck(FrontEndEntity frontEndEntity) throws Exception {
        Log.infoStartTest("offerCategoryCheck");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        offerHelperBase = new OfferHelper(getAndroidDriver());
        offerHelperBase.offerCategoryCheck("Offer", "offerCategoryCheck");

        Log.infoEndTest("offerCategoryCheck");

    }

    @Test(groups = {"offerSanity", "redeemOffersCheck"}, priority = 1, dataProvider = "offersData", dataProviderClass = OffersDataProviderClass.class)
    public void Test22_redeemOffersCheck(FrontEndEntity frontEndEntity) throws Exception {
        Log.infoStartTest("redeemOffersCheck");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        offerHelperBase = new OfferHelper(getAndroidDriver());
        offerHelperBase.redeemOffersCheck("Offer", "redeemOffer");

        Log.infoEndTest("redeemOffersCheck");

    }


}





     */