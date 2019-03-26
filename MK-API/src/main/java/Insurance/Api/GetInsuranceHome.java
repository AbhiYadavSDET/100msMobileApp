package Insurance.Api;


import Config.Configuration;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class GetInsuranceHome extends Utils.BaseApi {

    public GetInsuranceHome() {
        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Insurance.IS_HTTPS_REQUIRED, Configuration.Insurance.HOST, Configuration.Insurance.PORT));
        getSpecBuilder().setBasePath("api/insurance/home");

        //Set the headers
        getSpecBuilder().addHeader("X-MClient", Configuration.Insurance.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", "E816B70013702137C8E27EE9131CD357E0912D23");
        getSpecBuilder().addHeader("X-App-Ver", "657");

        getSpecBuilder().setContentType(ContentType.JSON);

    }
}
