package Bus.Helper;

import Bus.Models.ResponseDto.CanCancel.CanCancelResponseDto;
import Utils.Log;
import Utils.MbkReporter;

import java.io.IOException;

public class CanCancelHelper {

    CanCancelResponseDto canCancelResponseDto;
    public com.fasterxml.jackson.databind.ObjectMapper mapper;

    public CanCancelHelper(String jsonString) {
        try {
            canCancelResponseDto = mapper.readValue(jsonString, CanCancelResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(canCancelResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyCancellable() {
        Log.info("VERIFY", "can cancel");
        MbkReporter.verifyEqualsWithLogging(canCancelResponseDto.getData().getCanCancel(), true, "Verify Can cancel", false);
        Log.info("VERIFIED", "Can cancel");
    }

    public void verifyCancellable2() {
        Log.info("VERIFY", "can cancel");
        MbkReporter.verifyEqualsWithLogging(canCancelResponseDto.getData().getCanCancel(), true, "Verify Can cancel", false);
        Log.info("VERIFIED", "Can cancel");
    }

}
