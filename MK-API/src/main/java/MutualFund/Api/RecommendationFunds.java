package MutualFund.Api;


import Config.Configuration;
import Utils.ExtentReport;
import io.restassured.http.ContentType;

import java.io.IOException;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class RecommendationFunds extends Utils.BaseApi {

    String host = Configuration.Mf.HOST;
    String basePath = "api/anonymous/recommendation/funds";

    public RecommendationFunds(String amount, String type, String riskTypeId, String timeInMonths, String targetAmount, String fundCategory) throws IOException {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Mf.IS_HTTPS_REQUIRED, host, Configuration.Mf.PORT));
        getSpecBuilder().setBasePath(basePath);
        getSpecBuilder().addParam("amount", amount);
        getSpecBuilder().addParam("type", type);
        getSpecBuilder().addParam("riskTypeId", riskTypeId);
        getSpecBuilder().addParam("timeInMonths", timeInMonths);
        getSpecBuilder().addParam("targetAmount", targetAmount);
        getSpecBuilder().addParam("fundCategory", fundCategory);

        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.Mf.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.Mf.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", Configuration.Mf.DEVICE_ID);
        getSpecBuilder().addHeader("X-App-Ver", Configuration.Mf.X_App_Version);

        //Log in Extent Report
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Request", host + basePath);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body


    }
}