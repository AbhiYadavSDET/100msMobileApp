package Insurance.Api;


import Insurance.Models.requestdto.CrossSellTransactionDto;
import Utils.Log;
import apiutil.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class CrossSellTransaction extends BaseApi {

    public CrossSellTransaction(String xMClient, String auth, String acceptEncoding, String xMScope, CrossSellTransactionDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "stargate-stag.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("crosssell/transaction");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", auth);
        getSpecBuilder().addHeader("X-MClient", xMClient);
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
