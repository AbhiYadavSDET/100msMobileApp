package test.java.AndroidApp.InsuranceApi.Api;

import io.restassured.http.ContentType;
import logger.Log;
import main.java.utils.BaseApi;

/**
 * @author pallavirai
 * @team MobileQA
 */
public class CancelSingle extends BaseApi {

    public CancelSingle(String policyId, String amount) {
        String host = "insurance.mobikwik.com";
        String basePath = "api/ops/policy/cancel-single";
        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, host, "null"));
        getSpecBuilder().setBasePath(basePath);

        //Set the headers
        getSpecBuilder().addHeader("Authorization", "09yLkqMhXd7B0i+/QIHYtw==.vjqvdqfcgjcq4liai8p2kt32ej");
        getSpecBuilder().addHeader("X-MClient", "3");
        getSpecBuilder().setContentType(ContentType.JSON);

        getSpecBuilder().addQueryParam("policyId", policyId);
        getSpecBuilder().addQueryParam("amount", amount);
        getSpecBuilder().addQueryParam("refundPurchasedPolicy", true);
        getSpecBuilder().addQueryParam("errorCode", "E00");
        getSpecBuilder().addQueryParam("reason", "abc");

        Log.info(host + basePath);


    }
}