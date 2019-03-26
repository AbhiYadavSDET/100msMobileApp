package Insurance.Api;


import Config.Configuration;
import Insurance.Models.requestdto.CrossSellDetailsDto;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class CrossSellDetails extends Utils.BaseApi {

    public CrossSellDetails(String acceptEncoding, CrossSellDetailsDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Stargate.IS_HTTPS_REQUIRED, Configuration.Stargate.HOST, Configuration.Stargate.PORT));
        getSpecBuilder().setBasePath("crosssell/details");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.Insurance.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.Insurance.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "673");
        getSpecBuilder().addHeader("Accept-Encoding", acceptEncoding);

        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);


    }
}
