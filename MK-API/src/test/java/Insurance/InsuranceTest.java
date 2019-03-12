package Insurance;

import Insurance.Api.GetInsuranceHome;
import Insurance.Api.InsuranceDetailsV2;
import Insurance.Api.InsurancePolicyPurchase;
import Insurance.Helper.InsuranceDetailsV2Helper;
import Insurance.Helper.InsuranceHomeHelper;
import Insurance.Helper.InsurancePolicyPurchaseHelper;
import Insurance.Helper.InsurancePolicyPurchaseSuccessHelper;
import Insurance.Models.requestdto.InsuranceDetailsV2Dto;
import Insurance.Models.requestdto.InsurancePolicyPurchaseDto;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InsuranceTest {
    //private final Logger logger = LoggerService.getLogger(InsuranceTest.class);

    Response response;
    InsuranceHomeHelper insuranceHomeHelper;

    @BeforeClass
    public void init() {
//        getTest().assignCategory("Test");
    }


    @Test(priority = 0)
    public void Test01_verify_success_response_for_insurance_home() {

        GetInsuranceHome getInsuranceHome = new GetInsuranceHome("3");
        response = getInsuranceHome.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        InsuranceHomeHelper insuranceHomeHelper = new InsuranceHomeHelper(response.getBody().asString());

        insuranceHomeHelper.verifySuccessResponse();
        insuranceHomeHelper.verifyInsuranceTypeCount(2);
        insuranceHomeHelper.verifyInsuranceCategory("LIFE", "PERSONAL_ACCIDENT");


    }

    @Test(priority = 1)
    public void Test02_verify_success_response_for_insurance_details_v2() {

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("LIFE");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");


        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2("3", "1dHBnn/bvplhi9fYJgyf8g==.rktf42pkckf8h0005dqrgjtn2", insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());

        insuranceDetailsV2Helper.verifySuccessResponse();
        insuranceDetailsV2Helper.verifyFixedInsuranceDetails("NEW_PURCHASE", "Life Insurance", "ICICI Prudential");
        insuranceDetailsV2Helper.setVariables(0);
        insuranceDetailsV2Helper.verifyVariableInsuranceDetails(0, 20, "Rs. 1 Lakh", 1);
        insuranceDetailsV2Helper.verifyVariableInsuranceDetails(1, 30, "Rs. 1 Lakh 50  Thousands", 1);
        insuranceDetailsV2Helper.verifyVariableInsuranceDetails(2, 40, "Rs. 2 Lakh", 1);


    }

    @Test(dependsOnMethods = "Test02_verify_success_response_for_insurance_details_v2", priority = 2)
    public void Test03_verify_insufficient_balance_response_for_insurance_policy_purchase() {
        int count = 0;

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId("INSCG8DDF3DH61FAD");
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase("3", "1dHBnn/bvplhi9fYJgyf8g==.rktf42pkckf8h0005dqrgjtn2", InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        InsurancePolicyPurchaseHelper insurancePolicyPurchaseHelper = new InsurancePolicyPurchaseHelper(response.getBody().asString());
        insurancePolicyPurchaseHelper.verifySuccessResponse();
        insurancePolicyPurchaseHelper.verifyMessage("PG03", "Insufficient balance exception");
        insurancePolicyPurchaseHelper.verifyPgOptions(3, "cc", "dc", "upi");

    }

    @Test(dependsOnMethods = "Test02_verify_success_response_for_insurance_details_v2", priority = 3)
    public void Test03_verify_sufficient_balance_response_for_insurance_policy_purchase() {
        int count = 0;

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId("INSCG8DDF3DH61FAD");
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase("3", "1dHBnn/bvplhi9fYJgyf8g==.rktf42pkckf8h0005dqrgjtn2", InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();
        insurancePolicyPurchaseSuccessHelper.verifyData(false, "Mayank Suneja", "ICICI Prudential", "Rs. 1 Lakh", "20.0", "Life Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        insurancePolicyPurchaseSuccessHelper.verifyStartEndDate(1);

    }

    @Test(dependsOnMethods = {"Test02_verify_success_response_for_insurance_details_v2", "Test03_verify_sufficient_balance_response_for_insurance_policy_purchase"}, priority = 4)
    public void Test04_verify_after_purchase_success_response_for_insurance_details_v2() {

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("LIFE");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2("3", "1dHBnn/bvplhi9fYJgyf8g==.rktf42pkckf8h0005dqrgjtn2", insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());

        insuranceDetailsV2Helper.verifySuccessResponse();
        insuranceDetailsV2Helper.verifyFixedInsuranceDetails("INCOMPLETE_DETAILS", "Life Insurance", "ICICI Prudential");

    }


}

