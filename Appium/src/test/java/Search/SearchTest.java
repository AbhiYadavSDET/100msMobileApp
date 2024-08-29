package Search;

import Helpers.CheckoutHelper;
import Helpers.LoginHelper;
import Helpers.SearchHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class SearchTest extends TestBase {

    @Test(groups = {"regression"}, priority = 0, description = "Search test")
    public void Search_Test01_searchFlow() throws IOException, InterruptedException {

        Log.info("======= START : Search home page all options available =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());
        searchHelper.checkSearchPage();
        Log.info("======= END : Search home page all options available =======");

    }

    @Test(groups = {"regression","invalidQuery"}, priority = 0, description = "Search test")
    public void Search_Test02_searchInvalidQuery() throws IOException, InterruptedException {

        Log.info("======= START : Search invalid name on search bar  =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());

        //Enter only invalid query String
        searchHelper.searchInvalidQuery("qwerty");
        Log.info("======= END :Search invalid name on search bar  =======");
    }
    @Test(groups = {"regression","searchValidQueries"}, priority = 0, description = "Search test")
    public void Search_Test03_searchValidQueries() throws IOException, InterruptedException {

        //Enter mobile number that is not in contact list
         String  queries []={"8860624421","zomato","Pocket","Abhishek"};
        Log.info("======= START : Search invalid name on search bar  =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());
        searchHelper.searchQueries(queries);
        Log.info("======= END :Search invalid name on search bar  =======");
    }

}
