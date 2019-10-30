package test.java.AndroidApp.Test.Login;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_login extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"logout", "loginSanity"}, priority = 0, dataProvider = "loginData", dataProviderClass = LoginDataProviderClass.class)
    public void Test08_logout(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginFromOboarding(frontEndEntity.getMobileNo());

        loginHelper.logout();


    }
}
