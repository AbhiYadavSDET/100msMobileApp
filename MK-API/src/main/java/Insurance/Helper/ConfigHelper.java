package Insurance.Helper;

import Insurance.Models.responsedto.Config.ConfigResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class ConfigHelper {

    ConfigResponseDto configResponseDto;
    public ObjectMapper mapper;
    public static HashMap<String, String> map = new HashMap<String, String>();


    public ConfigHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            configResponseDto = mapper.readValue(jsonString, ConfigResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(configResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }


    public void verifyPrimaryPolicyDetails() {
        Log.info("VERIFY", "Primary Pre-Filled Details");
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getPrimaryPolicyDetails().get(0).getPrefilledValue(), "mayank", "Verify full name", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getPrimaryPolicyDetails().get(1).getPrefilledValue(), "Male", "Verify Gender", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getPrimaryPolicyDetails().get(2).getPrefilledValue(), "12/3/2001", "Verify DOB", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getPrimaryPolicyDetails().get(3).getPrefilledValue(), "a@b.com", "Verify Email", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getPrimaryPolicyDetails().get(4).getPrefilledValue(), "7042338867", "Verify Phone No.", false);
        Log.info("VERIFIED", "Primary Pre-Filled Details");
    }


}
