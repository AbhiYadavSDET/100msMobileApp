package MutualFund.Api;


import Config.Configuration;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class Config extends Utils.BaseApi {

    public Config() {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Mf.IS_HTTPS_REQUIRED, Configuration.Mf.HOST, Configuration.Mf.PORT));
        getSpecBuilder().setBasePath("api/anonymous/v2/config");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.Mf.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.Mf.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", Configuration.Mf.DEVICE_ID);
        getSpecBuilder().addHeader("X-App-Ver", Configuration.Mf.X_App_Version);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body


    }
}
