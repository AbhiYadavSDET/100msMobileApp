package Supercash;

import Helpers.*;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Supercash extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    AddMoneyHelper addMoneyHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    SupercashHelper supercashHelper;

    @Test(groups = {"verifySupercash"}, priority = 0)
    public void Test01_ValidateSupercashFlow() throws IOException, JSONException, InterruptedException {

        Log.info("START : Validation of Supercash Functionality");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        SupercashHelper supercashHelper = new SupercashHelper(getAndroidDriver());
        supercashHelper.verifySupercash();

        Log.info("END : Successful Validation of Supercash Funtionality");
    }

}

