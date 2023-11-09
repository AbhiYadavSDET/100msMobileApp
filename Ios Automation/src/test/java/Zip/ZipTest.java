package Zip;

import Helpers.LoginHelper;
import Helpers.ZipHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class ZipTest extends TestBase {


    @Test(groups = {"sanity", "verifyZipPage", "regression"}, priority = 0, description = "Verify Zip Page")
    public void Test_Zip_verifyZipPage() throws IOException, InterruptedException {

        Log.info("======= START : Zip Verify test =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        ZipHelper zipHelper = new ZipHelper(getAndroidDriver());
        zipHelper.verifyZip("KYC Details", "Lets start with basic personal details.");

        Log.info("======= END : Zip Verify test =======");


    }
}
