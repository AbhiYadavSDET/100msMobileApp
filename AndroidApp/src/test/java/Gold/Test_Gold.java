package Gold;

import Helpers.AddMoneyHelper;
import Helpers.GoldHelper;
import Helpers.LoginHelper;
import Helpers.MBKCommonControlsHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Gold extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    AddMoneyHelper addMoneyHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    @Test(groups = {"buyGold", "goldSanity"}, priority = 1, dataProvider = "goldData", dataProviderClass = GoldDataProviderClass.class)
    public void Test01_buyGold(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gold sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.buyGold(frontEndEntity.getSecurityPin(), frontEndEntity.getAmount());

    }

    @Test(groups = {"sellGold", "goldSanity"}, priority = 0, dataProvider = "goldData", dataProviderClass = GoldDataProviderClass.class)
    public void Test02_sellGold(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gold sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        GoldHelper goldHelper = new GoldHelper(getAndroidDriver());
        goldHelper.sellGold(frontEndEntity.getSecurityPin(), frontEndEntity.getAmount());

    }


}
