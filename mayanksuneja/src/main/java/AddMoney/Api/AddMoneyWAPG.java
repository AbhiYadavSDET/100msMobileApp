package AddMoney.Api;


import Insurance.Models.requestdto.CrossSellDetailsDto;
import apiutil.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class AddMoneyWAPG extends BaseApi {

    public AddMoneyWAPG(String xMClient, String auth, String acceptEncoding, CrossSellDetailsDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "stargate-stag.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("crosssell/details");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", auth);
        getSpecBuilder().addHeader("X-MClient", xMClient);
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "657");
        getSpecBuilder().addHeader("Accept-Encoding", acceptEncoding);

        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);


    }
}
