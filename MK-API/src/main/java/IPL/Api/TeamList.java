package IPL.Api;

import Utils.BaseApi;
import io.restassured.http.ContentType;

public class TeamList extends BaseApi {

    public TeamList(String tournamentId) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "stagingpayment1.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("p/cricket/tmlist/" + tournamentId);
        //getSpecBuilder().setRelaxedHTTPSValidation();

        //Set the headers
        getSpecBuilder().addHeader("Authorization", "Z4n5EsJwt4QiTuGqPedbBw==.76b24epr1pqvc4p7ck2asqigru");
        getSpecBuilder().addHeader("X-MClient", "3");
        getSpecBuilder().addHeader("X-Device-ID", "2B0D9357EEF4A0BCD6B500AEDDC6AB8427B07949");
        getSpecBuilder().addHeader("X-App-Ver", "680");

        getSpecBuilder().setContentType(ContentType.JSON);


    }
}
