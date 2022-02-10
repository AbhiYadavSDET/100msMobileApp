package SavedConnection;

import Helpers.LoginHelper;
import Helpers.SavedConnectionHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_SavedConnection extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"addSavedConnection", "savedConnectionSanity"}, priority = 1, dataProvider = "savedConnectionData", dataProviderClass = SavedConnectionProviderClass.class)
    public void Test01_addSavedConnection(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

//NOTE: customer id is added under mobile no and name is added under Bank name in DB

        SavedConnectionHelper savedConnectionHelper = new SavedConnectionHelper(getAndroidDriver());
        savedConnectionHelper.addFavourite(frontEndEntity.getMobileNo(), frontEndEntity.getBankName());


    }


    @Test(groups = {"deleteSavedConnection", "savedConnectionSanity"}, priority = 2, dataProvider = "savedConnectionData", dataProviderClass = SavedConnectionProviderClass.class)
    public void Test02_deleteSavedConnection(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

//NOTE: customer id is added under mobile no and name is added under Bank name in DB

        SavedConnectionHelper savedConnectionHelper = new SavedConnectionHelper(getAndroidDriver());
        savedConnectionHelper.deleteFavourite(frontEndEntity.getBankName());


    }

}