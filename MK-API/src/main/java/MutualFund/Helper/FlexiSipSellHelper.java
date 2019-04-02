package MutualFund.Helper;

import MutualFund.Models.ResponseDto.FlexiSipSell.FlexiSipSellResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FlexiSipSellHelper {


    FlexiSipSellResponseDto flexiSipSellResponseDto;
    public ObjectMapper mapper;


    public FlexiSipSellHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            flexiSipSellResponseDto = mapper.readValue(jsonString, FlexiSipSellResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(flexiSipSellResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }
}
