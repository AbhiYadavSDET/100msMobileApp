package test.java.AndroidApp.Test.Bus;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.BusHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;


public class Test_Bus extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"busBook", "busSanity"}, priority = 0, dataProvider = "busData", dataProviderClass = BusProviderClass.class)
    public void Test01_bus_book(String userName, String password, FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail(userName, password);


        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busBook("bhubaneswar", "baripada", "Paraj Jain", "28", "121212");

    }

    @Test(groups = {"busCancel", "busSanity"}, priority = 1, dataProvider = "busData", dataProviderClass = BusProviderClass.class, dependsOnMethods = "Bus_book")
    public void Test02_bus_cancel(String userName, String password, FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail(userName, password);

        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busCancel("Your Ticket has been Cancelled");

    }


}