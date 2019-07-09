package test.java.AndroidApp.Test.Bus;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.BusHelper;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Test.AddMoney.AddMoneyProviderClass;

import java.io.IOException;


public class Test_Bus extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    @Test(groups = {"busBook", "busSanity"}, priority = 0, dataProvider = "busData", dataProviderClass = BusProviderClass.class)

    public void Bus_book(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        //loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(),frontEndEntity.getPassword());


        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busBook("bhubaneswar", "baripada", "Paraj Jain", "28", "525252");

    }
    @Test(groups = {"busBook", "busSanity"}, priority = 1, dataProvider = "busData", dataProviderClass = BusProviderClass.class)

    public void Bus_Cancel(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(),frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busCancel();

    }


}