package Bus.Helper;

import Bus.Models.ResponseDto.Availability.AvailabilityResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class AvailabilityHelper {

    AvailabilityResponseDto availabilityResponseDto;
    public ObjectMapper mapper;
    public static HashMap<String, Object> map = new HashMap<String, Object>();


    public AvailabilityHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            availabilityResponseDto = mapper.readValue(jsonString, AvailabilityResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(availabilityResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

}
