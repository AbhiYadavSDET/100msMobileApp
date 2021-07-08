package Services;

import Helpers.LoginHelper;
import Helpers.MBKCommonControlsHelper;
import Helpers.SplitBillHelper;
import UITestFramework.CreateSession;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_SplitBill extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    MBKCommonControlsHelper mbkCommonControlsHelper;

    @Test(groups = {"verifySplitBill"}, priority = 0)
    public void Test01_verifySplitBill() throws IOException, JSONException, InterruptedException {

        Log.info("START : Split Bill Sanity Test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        SplitBillHelper splitBillHelper = new SplitBillHelper(getAndroidDriver());
        splitBillHelper.verifySplitBill("Sandeep Verma","Pallavi Kumari", "50");

        Log.info("END : Split Bill Sanity Test Completion");
    }



}
