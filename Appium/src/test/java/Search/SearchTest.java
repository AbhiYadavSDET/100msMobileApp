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
    public void Test01_searchFlow() throws IOException, InterruptedException {

        Log.info("======= START : Search home page all options available =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());
        searchHelper.checkSearchPage();
        Log.info("======= END : Search home page all options available =======");

    }

    @Test(groups = {"regression","invalidQuery"}, priority = 0, description = "Search test")
    public void Test02_searchInvalidQuery() throws IOException, InterruptedException {

        Log.info("======= START : Search invalid name on search bar  =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());

        //Enter only invalid query String
        searchHelper.searchInvalidQuery("qwerty");
        Log.info("======= END :Search invalid name on search bar  =======");
    }
    @Test(groups = {"regression","searchQueries"}, priority = 0, description = "Search test")
    public void Test03_searchQueries() throws IOException, InterruptedException {

        //Enter queries in camel case
        String  queries []={"8860624421","Zomato","Pocket","Abhishek"};
        Log.info("======= START : Search invalid name on search bar  =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        SearchHelper searchHelper = new SearchHelper(getAndroidDriver());
        searchHelper.searchQueries(queries);
        Log.info("======= END :Search invalid name on search bar  =======");
    }

}
