package Insurance.Api;


import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class GetInsuranceHome extends Utils.BaseApi {

    public GetInsuranceHome(String xMClient) {
        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "insurance.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("api/insurance/home");

        //Set the headers
        getSpecBuilder().addHeader("X-MClient", xMClient);
        getSpecBuilder().addHeader("X-Device-ID", "E816B70013702137C8E27EE9131CD357E0912D23");
        getSpecBuilder().addHeader("X-App-Ver", "657");

        getSpecBuilder().setContentType(ContentType.JSON);

    }
}
