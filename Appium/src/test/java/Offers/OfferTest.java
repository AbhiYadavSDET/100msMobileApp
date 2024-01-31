package Offers;

import Helpers.LoginHelper;
import Helpers.OfferHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class OfferTest extends TestBase {


    @Test(groups = {"sanity", "offerSearch", "regression"}, priority = 0, description = "Offer Search")
    public void Test_Offers_Search() throws IOException, InterruptedException {

        Log.info("======= START : Offer Search test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        OfferHelper offerHelper = new OfferHelper(getAndroidDriver());
        offerHelper.searchOffers("Myntra", "Cashback", "Get upto 15% cashback on Myntra", "SHOPPING", "Shop Now");
        Log.info("======= END : Offer Search test =======");


    }
}
