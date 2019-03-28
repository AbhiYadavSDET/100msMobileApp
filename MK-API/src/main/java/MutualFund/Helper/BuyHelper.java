package MutualFund.Helper;

import MutualFund.Models.ResponseDto.Buy.BuyResponseDto;
import Utils.DateFormatEnums;
import Utils.DateHelper;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class BuyHelper {

    BuyResponseDto buyResponseDto;
    public ObjectMapper mapper;


    public BuyHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            buyResponseDto = mapper.readValue(jsonString, BuyResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(buyResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyDetails(String desc, String title, String subtitle) {
        Log.info("VERIFY", "Details");
        MbkReporter.verifyEqualsWithLogging(buyResponseDto.getData().getDesc(), desc, "Description", false);
        MbkReporter.verifyEqualsWithLogging(buyResponseDto.getData().getTitle(), title, "Title", false);
        MbkReporter.verifyEqualsWithLogging(buyResponseDto.getData().getSubTitle(), subtitle, "Subtitle", false);
        Log.info("VERIFIED", "Details");
    }

    public void verifyDisplayValues(String amount, int noOfDays) {
        Log.info("VERIFY", "Details");
        MbkReporter.verifyEqualsWithLogging(buyResponseDto.getData().getDisplayValues().get(0).getValue(), amount, "Amount", false);
        MbkReporter.verifyEqualsWithLogging(buyResponseDto.getData().getDisplayValues().get(1).getValue().substring(0, 11), DateHelper.getDateAterNDays(DateFormatEnums.DD_MMM_YYYY, noOfDays), "Nav Date", false);
        Log.info("VERIFIED", "Details");
    }

}
