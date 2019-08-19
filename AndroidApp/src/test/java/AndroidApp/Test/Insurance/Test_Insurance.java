package test.java.AndroidApp.Test.Insurance;

import UITestFramework.CreateSession;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.InsuranceHelper;
import test.java.AndroidApp.Helpers.LoginHelper;
import test.java.AndroidApp.InsuranceApi.Api.CancelSingle;
import test.java.AndroidApp.InsuranceApi.Helper.CancelSingleHelper;

import java.io.IOException;

public class Test_Insurance extends CreateSession {

    Response response;


    @Test(groups = {"insuranceBuy", "insuranceSanity"}, priority = 0)
    public void Test01_insurance_buy() throws IOException, JSONException, InterruptedException {

        Log.info("START : Insurance sanity test");
        String amount = "25";

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");


        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        String trxId = insuranceHelper.buyInsurance("Payment Successful!", "for Home Insurance (Gas) of Rs. 2 Lakh by ICICI Lombard");

        CancelSingle cancelSingle = new CancelSingle(trxId, amount);
        response = cancelSingle.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CancelSingleHelper cancelSingleHelper = new CancelSingleHelper(response.getBody().asString());

        cancelSingleHelper.verifySuccessResponse();

        Log.info("END : Insurance sanity test");

    }


}