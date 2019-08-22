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
    AddMoneyHelper addMoneyHelper;

    @Test(groups = {"sendMoney", "impsSanity"}, priority = 0, dataProvider = "impsData", dataProviderClass = ImpsDataProviderClass.class)
    public void Test01_imps(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        String amount = "50";
        Log.info("START : Imps sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        // Add money for the amount
        addMoneyHelper = new AddMoneyHelper(driver);
        addMoneyHelper.addMoneyViaSavedCardWithinFlow(amount, "4363 XXXX XXXX 4460", "239", "Paraj@1234");

        // IMPS the same amount
        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.verifyImps("Paraj Jain", "218101502680", "ICIC0002181", amount);

        Log.info("END : Imps sanity test");

    }


}
