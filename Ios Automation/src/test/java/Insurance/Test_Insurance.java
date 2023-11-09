package Insurance;
/*
import Helpers.InsuranceHelper;
import Helpers.LoginHelper;
import InsuranceApi.Api.CancelSingle;
import InsuranceApi.Helper.CancelSingleHelper;
import UITestFramework.CreateSession;
import apiutil.StatusCodeValidator;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import io.restassured.response.Response;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Insurance extends CreateSession {

    Response response;

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"insuranceBuy", "insuranceSanity"}, priority = 1, dataProvider = "insuranceData", dataProviderClass = InsuranceDataProviderClass.class)
    public void Test01_insurance_buy(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Insurance sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.validateInsurance(frontEndEntity.getPopupText());
        Log.info("END : Insurance sanity test");

    }


}


 */