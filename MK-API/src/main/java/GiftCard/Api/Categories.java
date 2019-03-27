package GiftCard.Api;


import Config.Configuration;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class Categories extends Utils.BaseApi {

    public Categories() {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.GET);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.GiftCard.IS_HTTPS_REQUIRED, Configuration.GiftCard.HOST, Configuration.GiftCard.PORT));
        getSpecBuilder().setBasePath("categories");

        //Set the headers
        getSpecBuilder().addHeader("Authorization", Configuration.GiftCard.AUTH);
        getSpecBuilder().addHeader("X-MClient", Configuration.GiftCard.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", Configuration.GiftCard.DEVICE_ID);
        getSpecBuilder().addHeader("X-App-Ver", Configuration.GiftCard.X_App_Version);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body


    }
}
