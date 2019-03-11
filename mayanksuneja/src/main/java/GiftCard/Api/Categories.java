package GiftCard.Api;


import apiutil.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class Categories extends BaseApi {

    public Categories(String xMClient, String auth, String deviceId) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "giftcard.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("categories");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", auth);
        getSpecBuilder().addHeader("X-MClient", xMClient);
        getSpecBuilder().addHeader("X-Device-ID", deviceId);
        getSpecBuilder().addHeader("X-App-Ver", "676");


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body


    }
}
