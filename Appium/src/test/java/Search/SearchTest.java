package Search;

import Helpers.CheckoutHelper;
import Helpers.LoginHelper;
import Helpers.SearchHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class SearchTest extends TestBase {

    @Test(groups = {"sanity","regression"}, priority = 0, description = "Search test")
    public void Test01_searchFlow() throws IOException, InterruptedException {

        Log.info("======= START : Xtra Checkout test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());
        searchHelper.checkSearchPage();

    }

}
