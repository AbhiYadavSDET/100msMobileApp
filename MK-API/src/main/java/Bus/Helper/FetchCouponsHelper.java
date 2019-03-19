package Bus.Helper;

import Bus.Models.ResponseDto.FetchCoupons.FetchCouponsResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FetchCouponsHelper {

    FetchCouponsResponseDto fetchCouponsResponseDto;
    public ObjectMapper mapper;


    public FetchCouponsHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            fetchCouponsResponseDto = mapper.readValue(jsonString, FetchCouponsResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(fetchCouponsResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyNoOfCouponCodes() {
        Log.info("VERIFY", "Number of Coupon Codes");
        int noOfCodes = fetchCouponsResponseDto.getData().getCoupons().size();
        MbkReporter.verifyEqualsWithLogging(noOfCodes, 1, "Verify Number of Coupon Codes", false);
        Log.info("VERIFIED", "Number of Coupon Codes");


    }
}
