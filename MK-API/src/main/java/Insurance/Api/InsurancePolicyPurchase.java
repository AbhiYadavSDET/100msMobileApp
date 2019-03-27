package Insurance.Api;

import Config.Configuration;
import Insurance.Models.requestdto.InsurancePolicyPurchaseDto;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class InsurancePolicyPurchase extends Utils.BaseApi {

    public InsurancePolicyPurchase(String scopeId, InsurancePolicyPurchaseDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Insurance.IS_HTTPS_REQUIRED, Configuration.Insurance.HOST, Configuration.Insurance.PORT));
        getSpecBuilder().setBasePath("api/policy/purchase");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.Insurance.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.Insurance.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "657");
        getSpecBuilder().addHeader("X-MScope", scopeId);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);


    }
}
