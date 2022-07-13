package P2M;
/*
import Helpers.LoginHelper;
import Helpers.P2MHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_P2M extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"sendMoney", "p2mSanity"}, priority = 0, dataProvider = "p2mData", dataProviderClass = P2MDataProviderClass.class)
    public void Test01_p2m_send_money(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        P2MHelper p2MHelper = new P2MHelper(getAndroidDriver());
        p2MHelper.p2mSendMoney(frontEndEntity.getOperator(), frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getCategory());
    }


}


 */