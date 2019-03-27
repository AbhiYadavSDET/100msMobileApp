package Insurance.Helper;

import Insurance.Models.responsedto.CrossSellDetailsDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class CrossSellDetailsHelper {

    CrossSellDetailsDto crossSellDetailsDto;
    public ObjectMapper mapper;
    public static HashMap<String, String> map = new HashMap<String, String>();


    public CrossSellDetailsHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            crossSellDetailsDto = mapper.readValue(jsonString, CrossSellDetailsDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setVariables(int count) {
        map.put("scopeId", crossSellDetailsDto.getData().getFixedInsuranceDetails().getScopeId());
        map.put("insuranceId_" + count, crossSellDetailsDto.getData().getVariableInsuranceDetails().get(count).getInsuranceId());

    }

    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(crossSellDetailsDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyCrossSellInsuranceTitle(String title) {
        Log.info("VERIFY", "Cross-sell Insurance Title");
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getCrossSellInsuranceTitle(), title, "Verify Cross-sell Title", false);
        Log.info("VERIFIED", "Cross-sell Insurance Title");

    }

    public void verifyFixedCrossSellDetails(String responseType, String category, String insurer) {
        Log.info("VERIFY", "Fixed Cross-Sell Details");
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getFixedInsuranceDetails().getResponseType(), responseType, "Verify Response Type", false);
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getFixedInsuranceDetails().getCategory(), category, "Verify category", false);
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getFixedInsuranceDetails().getInsurer(), insurer, "Verify Insurer", false);
        Log.info("VERIFIED", "Fixed Cross-Sell Details");

    }

    public void verifyVariableCrossSellDetails(int count, int price, String sumAssured, int tenureInMonths) {
        Log.info("VERIFY", "Variable Insurance Details");
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getVariableInsuranceDetails().get(count).getPrice(), price, "Verify Price", false);
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getVariableInsuranceDetails().get(count).getSumAssured(), sumAssured, "Verify Sum Assured", false);
        MbkReporter.verifyEqualsWithLogging(crossSellDetailsDto.getData().getVariableInsuranceDetails().get(count).getTenureInMonths(), tenureInMonths, "Verify Tenure In  Months", false);
        Log.info("VERIFIED", "Variable Insurance Details");

    }
}
