package Insurance.Helper;

import Insurance.Models.responsedto.InsurancePolicyPurchaseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class InsurancePolicyPurchaseHelper {

    InsurancePolicyPurchaseDto insurancePolicyPurchaseDto;
    public ObjectMapper mapper;


    public InsurancePolicyPurchaseHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            insurancePolicyPurchaseDto = mapper.readValue(jsonString, InsurancePolicyPurchaseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(!insurancePolicyPurchaseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }


    public void verifyMessage(String code, String text) {
        Log.info("VERIFY", "Message");
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseDto.getMessage().getCode(), code, "Verify Message --> Code", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseDto.getMessage().getText(), text, "Verify Message --> text", false);
        Log.info("VERIFIED", "Message");
    }

    public void verifyPgOptions(int count, String option1, String option2, String option3) {
        Log.info("VERIFY", "PG Options");
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseDto.getData().getWalletAsPG().getPgOptions().size(), count, "Verify PG Options count", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseDto.getData().getWalletAsPG().getPgOptions().get(0), option1, "Verify PG Options 1", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseDto.getData().getWalletAsPG().getPgOptions().get(1), option2, "Verify PG Options 2", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseDto.getData().getWalletAsPG().getPgOptions().get(2), option3, "Verify PG Options 3", false);
        Log.info("VERIFIED", "PG Options");

    }
}
