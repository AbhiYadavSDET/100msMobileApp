package AddMoney.Api;


import AddMoney.Models.requestDto.PgV1Initiate2Dto;
import apiutil.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class AddMoneyWallet extends BaseApi {

    public AddMoneyWallet(String xMClient, String auth, PgV1Initiate2Dto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "stagingpayment2.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("p/pg/v1/initiate2");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", auth);
        getSpecBuilder().addHeader("X-MClient", xMClient);
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "657");

        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);


    }
}
