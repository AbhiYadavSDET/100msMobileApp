package test.java.AndroidApp.Test.Ola;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.*;
import test.java.AndroidApp.Test.IMPS.ImpsDataProviderClass;

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
