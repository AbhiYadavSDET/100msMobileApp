package Insurance.Api;


import Insurance.Models.requestdto.InsurancePolicyPurchaseDto;
import apiutil.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class InsurancePolicyPurchase extends BaseApi {

    public InsurancePolicyPurchase(String xMClient, String auth, String scopeId, InsurancePolicyPurchaseDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "insuranceapi-stag2.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("api/policy/purchase");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", auth);
        getSpecBuilder().addHeader("X-MClient", xMClient);
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "657");
        getSpecBuilder().addHeader("X-MScope", scopeId);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);


    }
}
