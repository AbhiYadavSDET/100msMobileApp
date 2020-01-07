package Insurance;

import InsuranceApi.Api.CancelSingle;
import InsuranceApi.Helper.CancelSingleHelper;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseApi;

public class RefundApiTest extends BaseApi {

    Response response;

    @BeforeClass
    public void init() {
    }


    @Test(priority = 0)
    public void Test01_refund_policy() {

        CancelSingle cancelSingle = new CancelSingle("POLMBK5JE76C175", "20");
        response = cancelSingle.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CancelSingleHelper cancelSingleHelper = new CancelSingleHelper(response.getBody().asString());

        cancelSingleHelper.verifySuccessResponse();


    }

}

