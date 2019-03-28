package MutualFund.Api;


import Config.Configuration;
import MutualFund.Models.RequestDto.Cart.BuyRequestDto;
import Utils.ExtentReport;
import io.restassured.http.ContentType;

import java.io.IOException;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class Buy extends Utils.BaseApi {
    String host = Configuration.Mf.HOST;
    String basePath = "api/mf/buy";

    public Buy(BuyRequestDto payload) throws IOException {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Mf.IS_HTTPS_REQUIRED, host, Configuration.Mf.PORT));
        getSpecBuilder().setBasePath(basePath);

        //Log in Extent Report
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Request", host + basePath);
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Request Body", payload.toString());


        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.Mf.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.Mf.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", Configuration.Mf.DEVICE_ID);
        getSpecBuilder().addHeader("X-App-Ver", Configuration.Mf.X_App_Version);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);


    }
}
