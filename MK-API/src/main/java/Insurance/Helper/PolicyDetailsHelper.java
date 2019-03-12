package Insurance.Helper;

import Insurance.Models.responsedto.PolicyDetails.PolicyDetailsResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PolicyDetailsHelper {

    PolicyDetailsResponseDto policyDetailsResponseDto;
    public ObjectMapper mapper;


    public PolicyDetailsHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            policyDetailsResponseDto = mapper.readValue(jsonString, PolicyDetailsResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(policyDetailsResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }


}
