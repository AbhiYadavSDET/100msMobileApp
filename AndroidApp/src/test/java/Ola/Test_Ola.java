package Ola;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import Helpers.MBKCommonControlsHelper;
import Helpers.OlaHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Ola extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    AddMoneyHelper addMoneyHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    @Test(groups = {"ola", "olaSanity"}, priority = 0, dataProvider = "olaData", dataProviderClass = OlaDataProviderClass.class)
    public void Test01_olaBookAndCancel(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : OLA sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        OlaHelper olaHelper = new OlaHelper(getAndroidDriver());
        olaHelper.olaBook(frontEndEntity.getBankName(), frontEndEntity.getSecurityPin());

        Log.info("END : OLA sanity test");

    }


}
