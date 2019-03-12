package Insurance.Api;


import Utils.BaseApi;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class Config extends BaseApi {

    public Config() {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(true, "insuranceapi-stag2.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("api/insurance/config");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", "/6hweSfR4OKwEHAm2alBUg==.mjbbhr74jpej0qocinco0dum33");
        getSpecBuilder().addHeader("X-MClient", "3");
        getSpecBuilder().addHeader("X-Device-ID", "AC1357605C2174059ECB429924E29BB35E754351");
        getSpecBuilder().addHeader("X-App-Ver", "681");
        getSpecBuilder().addHeader("policyId", "POLMBK7G3D23J58");


        getSpecBuilder().setContentType(ContentType.JSON);


    }
}
