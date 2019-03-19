package Bus.Api;

import Utils.BaseApi;
import io.restassured.http.ContentType;

public class FetchCoupons extends BaseApi {

    public FetchCoupons() {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "busdevapi.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("api/coupons/fetch");
        getSpecBuilder().setRelaxedHTTPSValidation();

        //Set the headers
        getSpecBuilder().addHeader("Authorization", "Z4n5EsJwt4QiTuGqPedbBw==.nflbigpr11qic65k9upi3o86fp");
        getSpecBuilder().addHeader("X-MClient", "3");
        getSpecBuilder().addHeader("X-Device-ID", "2B0D9357EEF4A0BCD6B500AEDDC6AB8427B07949");
        getSpecBuilder().addHeader("X-App-Ver", "680");

        getSpecBuilder().setContentType(ContentType.JSON);


    }
}
