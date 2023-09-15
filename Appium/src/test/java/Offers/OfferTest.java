package Offers;

import Helpers.LoginHelper;
import Helpers.OfferHelper;
import Logger.Log;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class OfferTest extends TestBase {


    @Test(groups = {"sanity", "offerSearch", "regression"}, priority = 0, description = "Offer Search")
    public void Test01_offerSearch() throws IOException, InterruptedException {

        Log.info("======= START : Offer Search test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        OfferHelper offerHelper = new OfferHelper(getAndroidDriver());
        offerHelper.searchOffers("cleartrip", "Discount", "Get Flat 10% Instant Discount upto Rs.400 on Cleartrip!", "Travel", "Book Now");

        Log.info("======= END : Offer Search test =======");


    }
}
