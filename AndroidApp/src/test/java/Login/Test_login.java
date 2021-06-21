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


    @Test(groups = {"loginViaOnboarding", "loginSanity"}, priority = 0)
    public void Test01_login_via_onboarding() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.doLoginFromOboarding("8216902003", "547372");


    }

    @Test(groups = {"logout", "loginSanity"}, priority = 1)
    public void Test08_logout() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        loginHelper.logout();


    }


}
