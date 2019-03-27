package Insurance.Helper;

import Insurance.Models.responsedto.InsuranceDetailsV2Dto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class InsuranceDetailsV2Helper {

    InsuranceDetailsV2Dto insuranceDetailsV2Dto;
    public ObjectMapper mapper;
    public static HashMap<String, String> map = new HashMap<String, String>();


    public InsuranceDetailsV2Helper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            insuranceDetailsV2Dto = mapper.readValue(jsonString, Insurance.Models.responsedto.InsuranceDetailsV2Dto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setVariables(int count) {
        map.put("scopeId", insuranceDetailsV2Dto.getData().getFixedInsuranceDetails().getScopeId());
        map.put("insuranceId_" + count, insuranceDetailsV2Dto.getData().getVariableInsuranceDetails().get(count).getInsuranceId());

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(insuranceDetailsV2Dto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyFixedInsuranceDetails(String responeType, String category, String insurer) {
        Log.info("VERIFY", "Fixed Insurance Details");
        MbkReporter.verifyEqualsWithLogging(insuranceDetailsV2Dto.getData().getFixedInsuranceDetails().getResponseType(), responeType, "Verify Response Type", false);
        MbkReporter.verifyEqualsWithLogging(insuranceDetailsV2Dto.getData().getFixedInsuranceDetails().getCategory(), category, "Verify Category", false);
        MbkReporter.verifyEqualsWithLogging(insuranceDetailsV2Dto.getData().getFixedInsuranceDetails().getInsurer(), insurer, "Verify Insurer", false);
        Log.info("VERIFIED", "Fixed Insurance Details");

    }

    public void verifyVariableInsuranceDetails(int count, int price, String sumAssured, int tenureInMonths) {
        Log.info("VERIFY", "Variable Insurance Details");
        MbkReporter.verifyEqualsWithLogging(insuranceDetailsV2Dto.getData().getVariableInsuranceDetails().get(count).getPrice(), price, "Verify Price", false);
        MbkReporter.verifyEqualsWithLogging(insuranceDetailsV2Dto.getData().getVariableInsuranceDetails().get(count).getSumAssured(), sumAssured, "Verify Sum Assured", false);
        MbkReporter.verifyEqualsWithLogging(insuranceDetailsV2Dto.getData().getVariableInsuranceDetails().get(count).getTenureInMonths(), tenureInMonths, "Verify Tenure In  Months", false);
        Log.info("VERIFIED", "Variable Insurance Details");


    }
}
