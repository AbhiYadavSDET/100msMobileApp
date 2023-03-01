package HelpAndSupport;

import Helpers.HelpAndSupportHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;

import org.testng.annotations.Test;

import java.io.IOException;

public class Test_HelpAndSupport  extends TestBase {

    @Test(groups = {"sanity", "helpAndSupport"}, priority = 0, description = "Verify Help And Support")
    public void Test01_HelpAndSupport() throws IOException, InterruptedException {

        Log.info("======= START : Help And Support test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        HelpAndSupportHelper helpAndSupportHelper = new HelpAndSupportHelper(getAndroidDriver());
        helpAndSupportHelper.helpAndSupport("Hey my name is Ashish", "Help & Support", "Select Your Transaction", "Help & Support");

        Log.info("======= END : Help And Support test =======");


    }


}