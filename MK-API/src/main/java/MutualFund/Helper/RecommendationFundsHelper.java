package MutualFund.Helper;

import MutualFund.Models.ResponseDto.RecommendationFunds.RecommendationFundsResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RecommendationFundsHelper {

    RecommendationFundsResponseDto recommendationFundsResponseDto;
    public ObjectMapper mapper;


    public RecommendationFundsHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            recommendationFundsResponseDto = mapper.readValue(jsonString, RecommendationFundsResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(recommendationFundsResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyData(int fundsCount) throws IOException {
        Log.info("VERIFY", "Count of funds");
        int size = recommendationFundsResponseDto.getData().size();
        MbkReporter.verifyEqualsWithLoggingExtentReport(size, fundsCount, "Count", false);
        Log.info("VERIFIED", "Count of funds");

    }

}
