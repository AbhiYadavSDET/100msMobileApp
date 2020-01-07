package P2P;

import Helpers.LoginHelper;
import Helpers.P2PHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_P2p extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"p2pSufficient", "p2pSanity"}, priority = 1, dataProvider = "p2pData", dataProviderClass = P2pProviderClass.class)
    public void Test01_p2pSufficient(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        P2PHelper p2PHelper = new P2PHelper(getAndroidDriver());
        p2PHelper.p2pSufficient(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getCategory());


    }
}