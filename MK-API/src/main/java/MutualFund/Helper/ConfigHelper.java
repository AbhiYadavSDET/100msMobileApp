package MutualFund.Helper;

import MutualFund.Models.ResponseDto.Config.ConfigResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConfigHelper {

    ConfigResponseDto configResponseDto;
    public ObjectMapper mapper;


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

    public void verifyData(boolean hasPortfolio, Boolean showInvestorProfilePage, Boolean bankVerification, Boolean eNash, Boolean isKYCed, int kycFlowState) {
        Log.info("VERIFY", "Data");
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getHasPortfolio(), hasPortfolio, "Has Portfolio", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getShowInvestorProfilePage(), showInvestorProfilePage, "show Invester Profile Page", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getBankVerification(), bankVerification, "bank Verification", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getENach(), eNash, "E-Nash", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getIsKYCed(), isKYCed, "is KYC", false);
        MbkReporter.verifyEqualsWithLogging(configResponseDto.getData().getKycFlowState(), kycFlowState, "KYC Flow state", false);
        Log.info("VERIFIED", "Data");

    }

}
