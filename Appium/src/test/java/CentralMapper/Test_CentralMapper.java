package CentralMapper;

import Helpers.CentralMapperHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_CentralMapper extends TestBase {

    @Test(groups = {"centralMapper"}, priority = 0, description = "Central Mapper test on UPI home screen")
    public void CentralMapper_Test01_Verify_On_UPI_Homescreen() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.checkMappedNumberOnUPIHomeScreen("807659576", "ASHISH KUMAR PRADHAN", "ashish789799@ikwik");

    }

    @Test(groups = {"centralMapper"}, priority = 0, description = "Central Mapper test on scan qr screen")
    public void CentralMapper_Test02_Verify_On_QRScreen() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.checkMappedNumberOnScanAnyQrScreen("807659576", "ASHISH KUMAR PRADHAN", "ashish789799@ikwik");

    }

    @Test(groups = {"centralMapper"}, priority = 0, description = "Central Mapper deactivate number")
    public void CentralMapper_Test03_Change_State_OF_Mapper_Number_To_Deactivate() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.changeStateOfMappedNumber("deactivate");

    }

    @Test(groups = {"centralMapper"}, priority = 0, description = "Central Mapper deregister number")
    public void CentralMapper_Test04_Change_State_OF_Mapper_Number_To_Deregister() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.changeStateOfMappedNumber("deregister");

    }

    @Test(groups = {"centralMapper"}, priority = 0, description = "Central Mapper activate number")
    public void CentralMapper_Test05_Change_State_OF_Mapper_Number_To_Activate() throws IOException, InterruptedException {

        Log.info("======= START : Central Mapper =======");
        // Starting the test in the extent report

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("8076595767", "547372");

        // Execute the test
        CentralMapperHelper centralMapperHelper = new CentralMapperHelper(getAndroidDriver());
        centralMapperHelper.changeStateOfMappedNumber("activate");

    }

    @Test(groups = {"centralMapper"}, priority = 0, description = "Central Mapper activate number")
    public void CentralMapper_Test06_Add_New_Number() throws IOException, InterruptedException {

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
