package InsuranceApi.Helper;

import InsuranceApi.Models.CancelSingleResponseDto;
import UITestFramework.CreateSession;
import UITestFramework.MBReporter;
import com.fasterxml.jackson.databind.ObjectMapper;
import logger.Log;

import java.io.IOException;
import java.util.HashMap;

public class CancelSingleHelper extends CreateSession {

    CancelSingleResponseDto cancelSingleResponseDto;
    public ObjectMapper mapper;
    public static HashMap<String, String> map = new HashMap<String, String>();
    MBReporter mbReporter = new MBReporter(getAndroidDriver(), "abc");


    public CancelSingleHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            cancelSingleResponseDto = mapper.readValue(jsonString, CancelSingleResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        mbReporter.verifyTrueWithLogging(cancelSingleResponseDto.getSuccess(), "Verify Success Response", false, false);
        Log.info("VERIFIED", "Success Response");
    }
}
