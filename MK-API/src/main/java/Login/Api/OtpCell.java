package Login.Api;


import Config.Configuration;
import Login.Models.RequestDto.OtpCellDto;
import io.restassured.http.ContentType;

/**
 * @author mayanksuneja
 * @team MobileQA
 */
public class OtpCell extends Utils.BaseApi {

    public OtpCell(OtpCellDto payload) {

        // Set the Request Method
        setHttpMethod(HTTP_METHOD.POST);

        // Set the Base URI and Path
        getSpecBuilder().setBaseUri(getBaseUri(Configuration.Payment.IS_HTTPS_REQUIRED, Configuration.Payment.HOST, Configuration.Payment.PORT));
        getSpecBuilder().setBasePath("p/account/otp/cell");

        //Set the headers
        getSpecBuilder().addHeader("X-MClient", Configuration.Payment.X_MCLIENT);
        getSpecBuilder().addHeader("X-Device-ID", Configuration.Payment.DEVICE_ID);
        getSpecBuilder().addHeader("X-App-Ver", Configuration.Payment.X_App_Version);


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);

    }
}

