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

    @Test(groups = {"busBook", "busSanity"}, priority = 0)
    public void Bus_book() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("parajjain@gmail.com", "Test@1234");

        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busBook("bhubaneswar", "baripada", "Paraj Jain", "28", "525252");

    }

    @Test(groups = {"busCancel", "busSanity"}, priority = 0)
    public void Bus_Cancel() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("parajjain@gmail.com", "Test@1234");

        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busCancel();

    }


}