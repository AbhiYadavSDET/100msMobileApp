package CentralMapper;

import Helpers.CentralMapperHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_CentralMapper extends TestBase {

    @Test(groups = {"sanity", "centralMapper"}, priority = 0, description = "Central Mapper test on UPI home screen")
    public void Test01_centralMapper() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.checkMappedNumberOnUPIHomeScreen("807659576", "ASHISH KUMAR PRADHAN", "ashish789799@ikwik");

    }

    @Test(groups = {"sanity", "centralMapper"}, priority = 1, description = "Central Mapper test on scan qr screen")
    public void Test02_centralMapper() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.checkMappedNumberOnScanAnyQrScreen("807659576", "ASHISH KUMAR PRADHAN", "ashish789799@ikwik");

    }

}
