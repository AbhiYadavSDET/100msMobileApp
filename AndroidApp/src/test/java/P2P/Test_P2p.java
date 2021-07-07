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

    @Test(groups = {"p2pSufficient", "p2pSanity"}, priority = 0)
    public void Test01_p2pSufficient() throws IOException, JSONException, InterruptedException {

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        P2PHelper p2PHelper = new P2PHelper(getAndroidDriver());
        p2PHelper.p2pSufficient("9414065033", "5", "121212", "NA", "NA");

    }

    @Test(groups = {"p2pSufficientLoggedout", "p2pSanity"}, priority = 1)
    public void Test02_p2pSufficientLoggedOut() throws IOException, JSONException, InterruptedException {

        P2PHelper p2PHelper = new P2PHelper(getAndroidDriver());
        p2PHelper.p2pSufficientLoggedOut("9205299330", "547372", "9414065033", "5", "121212", "NA", "NA");

    }

    @Test(groups = {"p2pInSufficient", "p2pSanity"}, priority = 2)
    public void Test03_p2pInSufficient() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");


        P2PHelper p2PHelper = new P2PHelper(getAndroidDriver());
        p2PHelper.p2pInSufficient("7795709569", "5", "121212");

    }


}