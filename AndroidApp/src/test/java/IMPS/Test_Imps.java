package IMPS;

import Helpers.*;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Imps extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    AddMoneyHelper addMoneyHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    @Test(groups = {"sendMoney", "impsSanity"}, priority = 0, dataProvider = "impsData", dataProviderClass = ImpsDataProviderClass.class)
    public void Test01_imps(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Imps sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        checkBalanceHelper.checkBalance(frontEndEntity.getAmount(), "5");

//        // Add money for the amount
//        addMoneyHelper = new AddMoneyHelper(driver);
//        addMoneyHelper.addMoneyViaSavedCardWithinFlow(amount, "4363 XXXX XXXX 4460", "239", "Paraj@1234");

        // IMPS the same amount

        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.verifyImps("Paraj Jain", "917795709569", "PYTM0123456", frontEndEntity.getAmount(), frontEndEntity.getSecurityPin());

        Log.info("END : Imps sanity test");

    }


}
