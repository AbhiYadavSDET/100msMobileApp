package test.java.AndroidApp.Test.Insurance;

import UITestFramework.CreateSession;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.InsuranceHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_Insurance extends CreateSession {


    @Test(groups = {"insuranceBuy", "insuranceSanity"}, priority = 0)
    public void Test01_insurance_buy() throws IOException, JSONException, InterruptedException {

        Log.info("START : Insurance sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail("mayank.suneja@mobikwik.com", "Tuesday20");


        InsuranceHelper insuranceHelper = new InsuranceHelper(getAndroidDriver());
        insuranceHelper.buyInsurance("Payment Successful!", "for Home Insurance (Gas) of Rs. 2 Lakh by ICICI Lombard");

        Log.info("END : Insurance sanity test");

    }


}
