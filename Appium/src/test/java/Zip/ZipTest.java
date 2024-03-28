package Zip;

import Helpers.LoginHelper;
import Helpers.ZipHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class ZipTest extends TestBase {


    @Test(groups = { "verifyZipPage", "regression"}, priority = 0, description = "Verify Zip Page")
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

    @Test(groups = {"sanity", "verifyZipPageActiveUser", "regression"}, priority = 0, description = "Verify Zip Page for Active User")
    public void Test_Zip_verifyZipPage_activeUser() throws IOException, InterruptedException {

        Log.info("======= START : Zip Verify test for active User =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        ZipHelper zipHelper = new ZipHelper(getAndroidDriver());
        zipHelper.verifyZipActiveUser("ZIP Dashboard","Your Credit Score");

        Log.info("======= END : Zip Verify test for active User =======");


    }

    @Test(groups = {"verifyZipAutoPay", "regression"}, priority = 0, description = "Verify Zip Auto Pay")
    public void Test_Zip_verifyZip_AutoPay() throws IOException, InterruptedException {

        Log.info("======= START : Zip Verify test for Zip Auto Pay =======");


        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        ZipHelper zipHelper = new ZipHelper(getAndroidDriver());
        zipHelper.verifyZipAutoPay("ZIP Dashboard","Bill Book", "Vi", "Delhi NCR", "7795709569");

        Log.info("======= END : Zip Verify test for Zip Auto Pay =======");


    }



}
