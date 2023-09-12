package CentralMapper;

import Helpers.CentralMapperHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_CentralMapper extends TestBase {

    @Test(groups = {"regression", "centralMapper"}, priority = 0, description = "Central Mapper test on UPI home screen")
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

    @Test(groups = {"regression", "centralMapper"}, priority = 1, description = "Central Mapper test on scan qr screen")
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

    @Test(groups = {"regression", "centralMapper"}, priority = 2, description = "Central Mapper deactivate number")
    public void Test03_centralMapper() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.changeStateOfMappedNumber("deactivate");

    }

    @Test(groups = {"regression", "centralMapper"}, priority = 3, description = "Central Mapper deregister number")
    public void Test04_centralMapper() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.changeStateOfMappedNumber("deregister");

    }

    @Test(groups = {"regression", "centralMapper"}, priority = 4, description = "Central Mapper activate number")
    public void Test05_centralMapper() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.changeStateOfMappedNumber("activate");

    }

    @Test(groups = {"regression", "centralMapper"}, priority = 5, description = "Central Mapper activate number")
    public void Test06_centralMapper() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.addNewNumber("807658787");

    }

}
