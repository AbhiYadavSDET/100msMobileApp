package Insurance.Helper;

import Insurance.Models.responsedto.InsuranceHomeDto;
import Insurance.Models.responsedto.InsuranceThumbnailDetail;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class InsuranceHomeHelper {


    public ObjectMapper mapper;
    public InsuranceHomeDto insuranceHomeDto;

    public InsuranceHomeHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            insuranceHomeDto = mapper.readValue(jsonString, InsuranceHomeDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(insuranceHomeDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyInsuranceTypeCount(int count) {

        Log.info("VERIFY", "Number of Insurance Types");
        List<InsuranceThumbnailDetail> arrListInsuranceTypes = insuranceHomeDto.getData().getInsuranceThumbnailDetails();

        MbkReporter.verifyTrueWithLogging(arrListInsuranceTypes.size() == 2, "Verify Insurance Type Count", false);
        Log.info("VERIFIED", "Number of Insurance Types");

    }

    public void verifyInsuranceCategory(String category1, String category2) {
        Log.info("VERIFY", "Insurance Category");
        List<InsuranceThumbnailDetail> arrListInsuranceTypes = insuranceHomeDto.getData().getInsuranceThumbnailDetails();

        MbkReporter.verifyTrueWithLogging(arrListInsuranceTypes.get(0).getInsuranceCategory().equals(category1), "Verify First Insurance Category", false);
        MbkReporter.verifyTrueWithLogging(arrListInsuranceTypes.get(1).getInsuranceCategory().equals(category2), "Verify second Insurance Category", false);

        Log.info("VERIFIED", "Insurance Category");

    }
}