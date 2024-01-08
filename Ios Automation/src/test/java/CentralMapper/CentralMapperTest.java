package CentralMapper;

import Helpers.CentralMapperHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class CentralMapperTest extends TestBase {

    @Test(groups = {"regression", "centralMapper"}, priority = 0, description = "Central Mapper test on UPI home screen")
    public void Test_CentralMapper_Verify_On_UPI_Homescreen() throws IOException, InterruptedException {


        Log.info("======= START : Login test =======");

        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("7795709569", "547372");

        Log.info("======= END : Login test =======");

        Log.info("======= START : Central Mapper =======");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getIosDriver());
        centralMapperHelper.checkMappedNumberOnUPIHomeScreen("8076595767", "Ashish Kumar Pradhan", "ashish789799@ikwik");

        Log.info("======= END : Central Mapper =======");

    }

    @Test(groups = {"regression", "centralMapper"}, priority = 0, description = "Central Mapper test on scan qr screen")
    public void Test_CentralMapper_Verify_On_QRScreen() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getIosDriver());
        loginHelper.loginViaOtp("7795709569", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getIosDriver());
        centralMapperHelper.checkMappedNumberOnScanAnyQrScreen("8076595767", "Ashish Kumar Pradhan", "ashish789799@ikwik");

    }
}
