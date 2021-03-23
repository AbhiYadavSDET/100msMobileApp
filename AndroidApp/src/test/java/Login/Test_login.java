package Login;

import Helpers.LoginHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_login extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"logout", "loginSanity"}, priority = 0, dataProvider = "loginData", dataProviderClass = LoginDataProviderClass.class)
    public void Test08_logout(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginFromOboarding(frontEndEntity.getMobileNo());

        loginHelper.logout();


    }

    @Test(groups = {"logout", "loginSanity"}, priority = 0, dataProvider = "loginData", dataProviderClass = LoginDataProviderClass.class)
    public void Test08_logout() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        loginHelper.logout();


    }



}
