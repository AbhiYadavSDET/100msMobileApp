package IMPS;
/*
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
    //Lakshay entries -

    @Test(groups = {"sendMoneyVPA"}, priority = 0)
    public void Test02_imps_sendMoneytoVPA() throws IOException, JSONException, InterruptedException {

        Log.info("START : Imps to VPA sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.sendMoneyVPA("lakshayvrm@ybl", "50", "121212");

        Log.info("END : IMPS to VPA sanity test");
    }

    @Test(groups = {"sendMoneyBA"}, priority = 1)
    public void Test03_imps_sendMoneytoBA() throws IOException, JSONException, InterruptedException {

        Log.info("START : Imps to Bank Account sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        ImpsHelper impsHelper = new ImpsHelper(getAndroidDriver());
        impsHelper.sendMoneyBA("Lakshay Verma", "239001509736", "ICIC0002390", "50", "121212");

        Log.info("END : IMPS to VPA sanity test");
    }
}


 */