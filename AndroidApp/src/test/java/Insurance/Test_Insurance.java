package Insurance;

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

import java.io.IOException;

public class Test_Insurance extends CreateSession {

    Response response;


    @Test(groups = {"insuranceBuy", "insuranceSanity"}, priority = 1, dataProvider = "insuranceData", dataProviderClass = InsuranceDataProviderClass.class)
    public void Test01_insurance_buy(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Insurance sanity test");
//        String amount = frontEndEntity.getAmount();

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

//        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");

        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
//        String trxId = insuranceHelper.buyInsurance("Payment Successful!", "for Personal Accident Insurance of Rs. 1 Lac by ", frontEndEntity.getSecurityPin());
//
//        CancelSingle cancelSingle = new CancelSingle(trxId, amount);
//        response = cancelSingle.execute();
//
//        System.out.println(response.getBody().asString());
//
//        //Status code validator
//        StatusCodeValidator.validate200(response);
//
//        CancelSingleHelper cancelSingleHelper = new CancelSingleHelper(response.getBody().asString());
//
//        cancelSingleHelper.verifySuccessResponse();

        insuranceHelper.validateInsurance(frontEndEntity.getPopupError(), frontEndEntity.getPopupText());
        Log.info("END : Insurance sanity test");

    }


}
