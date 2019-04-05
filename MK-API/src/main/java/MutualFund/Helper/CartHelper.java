package MutualFund.Helper;

import MutualFund.Models.ResponseDto.Cart.CartResponseDto;
import Utils.DateFormatEnums;
import Utils.DateHelper;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CartHelper {

    CartResponseDto cartResponseDto;
    public ObjectMapper mapper;


    public CartHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            cartResponseDto = mapper.readValue(jsonString, CartResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(cartResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyNavDate(int noOfDays) throws IOException {
        Log.info("VERIFY", "AutoPayBank");
        MbkReporter.verifyEqualsWithLoggingExtentReport(cartResponseDto.getData().getNavDate().substring(0, 11), DateHelper.getDateAterNDays(DateFormatEnums.DD_MMM_YYYY, noOfDays), "beneficiaryName", false);
        Log.info("VERIFIED", "AutoPayBank");
    }


}
