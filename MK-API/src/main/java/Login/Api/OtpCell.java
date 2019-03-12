package Login.Api;


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
        getSpecBuilder().setBaseUri(getBaseUri(true, "stagingpayment2.mobikwik.com", "null"));
        getSpecBuilder().setBasePath("p/account/otp/cell");

        //Set the headers
        getSpecBuilder().addHeader("X-MClient", "3");
        getSpecBuilder().addHeader("X-Device-ID", "4F8E8A745B5B61A066A90DCECB483672BA45650F");
        getSpecBuilder().addHeader("X-App-Ver", "676");


        getSpecBuilder().setContentType(ContentType.JSON);

        // Set the body
        getSpecBuilder().setBody(payload);

    }
}

