package test.java.AndroidApp.Test.MutualFunds;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import main.java.utils.DatabaseSqlHelper;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.Helpers.MutualFundsHelper;


public class Test_MutualFunds extends CreateSession {
    MutualFundsHelper mutualFundsHelper;
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"mfSanity"}, priority = 1, dataProvider = "mutualFundsData", dataProviderClass = MutualFundsDataProviderClass.class)
    public void Test19_mutualfunds_verification(FrontEndEntity frontEndEntity) throws Exception {
        Log.info("START : Mutual Funds verification test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());

        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");

        mutualFundsHelper = new MutualFundsHelper(getAndroidDriver());

        mutualFundsHelper.mutualFundsVerification();
        Log.info("END : Mutual Funds verification test");

    }


}
