package test.java.AndroidApp.Test;

import UITestFramework.CreateSession;
import UITestFramework.ExtentReport.Reporter;
import logger.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.OfferHelper;
import java.io.IOException;

/**
 * automated test to verify Offers
 */

public class Test_Offer extends CreateSession {
    OfferHelper offerHelperBase;

    /**
     * method to verify Offers from Home Screen
     *
     * @throws Exception
     */
    @Test(groups = {"offerSanity", "offerSearch"}, priority = 0)
    public void offerSearch() throws Exception {
        Log.infoStartTest("offerSearch");
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        //loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        offerHelperBase = new OfferHelper(getAndroidDriver());

        offerHelperBase.offerSearch("makemytrip", "Offer", "offerSearch");

        Log.infoEndTest("offerSearch");

    }

    @Test(groups = {"offerSanity", "offerCategoryCheck"}, priority = 1)
    public void offerCategoryCheck() throws Exception {
        Log.infoStartTest("offerCategoryCheck");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        //loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        offerHelperBase = new OfferHelper(getAndroidDriver());

        offerHelperBase.offerCategoryCheck("Offer", "offerCategoryCheck");

        Log.infoEndTest("offerCategoryCheck");

    }

    @Test(groups = {"offerSanity", "redeemOffersCheck"}, priority = 1)
    public void redeemOffersCheck() throws Exception {
        Log.infoStartTest("redeemOffersCheck");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        //loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaEmail("priyankaigdtuw@gmail.com", "priyanka123");

        offerHelperBase = new OfferHelper(getAndroidDriver());
        offerHelperBase.redeemOffersCheck("Offer", "redeemOffer");

        Log.infoEndTest("redeemOffersCheck");

    }




}



