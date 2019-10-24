package test.java.AndroidApp.Test.Bus;

import UITestFramework.CreateSession;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.BusHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;


public class Test_Bus extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"busBook", "busSanity"}, priority = 0, dataProvider = "busData", dataProviderClass = BusProviderClass.class)
    public void Bus_book(String userName, String password) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(userName, password);


        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busBook("bhubaneswar", "baripada", "Paraj Jain", "28", "121212");

    }

    @Test(groups = {"busCancel", "busSanity"}, priority = 1, dataProvider = "busData", dataProviderClass = BusProviderClass.class, dependsOnMethods = "Bus_book")
    public void Bus_Cancel(String userName, String password) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(userName, password);

        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busCancel("Your Ticket has been Cancelled");

    }


}