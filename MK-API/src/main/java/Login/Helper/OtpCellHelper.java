package Login.Helper;

import Login.Models.ResponseDto.OtpCell.OtpCellResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class OtpCellHelper {

    public ObjectMapper mapper;
    public OtpCellResponseDto otpCellResponseDto;


    public OtpCellHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            otpCellResponseDto = mapper.readValue(jsonString, OtpCellResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(otpCellResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyData() {
        Log.info("VERIFY", "Verify Data");
        MbkReporter.verifyEqualsWithLogging(otpCellResponseDto.getData().getGeneralMessage(), "OTP is sent successfully to your primary number ending in *******474", "Verify general Message", false);
        MbkReporter.verifyEqualsWithLogging(otpCellResponseDto.getData().getRegisteredMobileNumber(), false, "Verify registered Mobile Number", false);
        Log.info("VERIFIED", "Verify Data");

    }

}
