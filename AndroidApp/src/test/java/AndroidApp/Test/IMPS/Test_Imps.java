package test.java.AndroidApp.Test.IMPS;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.AddMoneyHelper;
import test.java.AndroidApp.Helpers.ImpsHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_Imps extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @Test(groups = {"sendMoney", "impsSanity"}, priority = 0, dataProvider = "impsData", dataProviderClass = ImpsDataProviderClass.class)
    public void Test01_imps(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Imps sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        /*AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.addMoneyViaNewCard("5", frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
                .getSuccessPageText());*/

        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.verifyImps("Mayank Suneja", "114601503265", "ICIC0001146", "50");

        Log.info("END : Imps sanity test");

    }


}
