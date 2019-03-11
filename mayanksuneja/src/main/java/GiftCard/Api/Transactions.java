package GiftCard.Api;


import GiftCard.Models.requestdto.TransactionsRequestDto;
import apiutil.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class Transactions extends BaseApi {

    public Transactions(String xMClient, String auth, String deviceId, TransactionsRequestDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "giftcard.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("transactions");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", auth);
        getSpecBuilder().addHeader("X-MClient", xMClient);
        getSpecBuilder().addHeader("X-Device-ID", deviceId);
        getSpecBuilder().addHeader("X-App-Ver", "676");


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);

    }
}
