package SecuritySettings;
/*
import Helpers.LoginHelper;
import Helpers.SavedConnectionHelper;
import Helpers.SecuritySettingsHelper;
import SavedConnection.SavedConnectionProviderClass;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_SecuritySettings extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

//    @Test(groups = {"setAndChangeSecurityPin", "securityPinSanity"}, priority = 1, dataProvider = "securitySettingsData", dataProviderClass = SecuritySettingsProviderClass.class)
    @Test(groups = {"setAndChangeSecurityPin", "securityPinSanity"}, priority = 1)
    public void Test01_SetSecurityPin() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        SecuritySettingsHelper securitySettingsHelper=new SecuritySettingsHelper(getAndroidDriver());
        securitySettingsHelper.setSecurityPin("121212");
    }

    @Test(groups = {"changeSecurityPin", "securityPinSanity"}, priority = 2)
    public void Test02_ChangeSecurityPin() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        SecuritySettingsHelper securitySettingsHelper=new SecuritySettingsHelper(getAndroidDriver());
        securitySettingsHelper.changeSecurityPin("121212", "101010");
    }

//    @Test(groups = {"forgotSecurityPinViaMobileNumber", "securityPinSanity"}, priority = 2, dataProvider = "securitySettingsData", dataProviderClass = SecuritySettingsProviderClass.class)
    @Test(groups = {"forgotSecurityPinViaMobileNumber", "securityPinSanity"}, priority = 3)
    public void Test03_forgotSecurityPinViaMobileNumber() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        SecuritySettingsHelper securitySettingsHelper=new SecuritySettingsHelper(getAndroidDriver());
        securitySettingsHelper.forgotSecurityPin("121212", "9205299330", "recoverViaMobileNumber", "NA", "101010");
    }

//    @Test(groups = {"forgotSecurityPinViaOtherOptions", "securityPinSanity"}, priority = 3, dataProvider = "securitySettingsData", dataProviderClass = SecuritySettingsProviderClass.class)
    @Test(groups = {"forgotSecurityPinViaOtherOptions", "securityPinSanity"}, priority = 4)
    public void Test04_forgotSecurityPinViaOtherOptions() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        SecuritySettingsHelper securitySettingsHelper=new SecuritySettingsHelper(getAndroidDriver());
        securitySettingsHelper.forgotSecurityPin("121212", "9205299330", "recoverViaOtherOptions", "St Pauls", "101010");
    }


}

 */