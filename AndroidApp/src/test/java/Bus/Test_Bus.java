package Bus;

import Helpers.BusHelper;
import Helpers.CheckBalanceHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;


public class Test_Bus extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"busBook", "busSanity"}, priority = 0, dataProvider = "busData", dataProviderClass = BusProviderClass.class)
    public void Test01_bus_book(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        checkBalanceHelper.checkBalance(frontEndEntity.getAmount());


        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busBook("bhubaneswar", "baripada", "Paraj Jain", "28", "121212");

    }

    @Test(groups = {"busCancel", "busSanity"}, priority = 1, dataProvider = "busData", dataProviderClass = BusProviderClass.class, dependsOnMethods = "Test01_bus_book")
    public void Test02_bus_cancel(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail(userName, password);

        BusHelper busHelper = new BusHelper(getAndroidDriver());
        busHelper.busCancel("Your Ticket has been Cancelled");

    }


}