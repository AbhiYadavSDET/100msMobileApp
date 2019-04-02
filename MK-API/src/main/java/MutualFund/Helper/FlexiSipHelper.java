package MutualFund.Helper;

import MutualFund.Models.ResponseDto.FlexiSip.FlexiSipResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FlexiSipHelper {


    FlexiSipResponseDto flexiSipResponseDto;
    public ObjectMapper mapper;


    public FlexiSipHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            flexiSipResponseDto = mapper.readValue(jsonString, FlexiSipResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(flexiSipResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }
}
