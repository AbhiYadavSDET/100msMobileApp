package Insurance.Api;


import Config.Configuration;
import Insurance.Models.requestdto.CrossSellTransactionDto;
import Utils.ExtentReport;
import Utils.Log;
import io.restassured.http.ContentType;

import java.io.IOException;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class CrossSellTransaction extends Utils.BaseApi {

    public CrossSellTransaction(String acceptEncoding, String xMScope, CrossSellTransactionDto payload) throws IOException {

        String host = Configuration.Stargate.HOST;
        String basePath = "crosssell/transaction";

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Stargate.IS_HTTPS_REQUIRED, host, Configuration.Stargate.PORT));
        getSpecBuilder().setBasePath(basePath);

        //Log in Extent Report
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Request", host + basePath);
        ExtentReport.extentReportDisplay(ExtentReport.Status.INFO, "Request Body", payload.toString());

        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.Stargate.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.Stargate.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "657");
        getSpecBuilder().addHeader("Accept-Encoding", acceptEncoding);
        getSpecBuilder().addHeader("X-MScope", xMScope);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        Log.info(payload.toString());
        getSpecBuilder().setBody(payload);


    }
}
