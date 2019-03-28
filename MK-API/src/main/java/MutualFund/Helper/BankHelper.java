package MutualFund.Helper;

import MutualFund.Models.ResponseDto.Bank.BankResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class BankHelper {

    BankResponseDto bankResponseDto;
    public ObjectMapper mapper;


    public BankHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            bankResponseDto = mapper.readValue(jsonString, BankResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(bankResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyAutoPayBank(String beneficiaryName, String accountNumber, String ifsc, String bankName, String bankLogo, Boolean mandateApproved) {
        Log.info("VERIFY", "AutoPayBank");
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getAutoPayBank().getBeneficiaryName(), beneficiaryName, "beneficiaryName", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getAutoPayBank().getAccountNumber(), accountNumber, "accountNumber", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getAutoPayBank().getIfscCode(), ifsc, "ifsc", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getAutoPayBank().getBankName(), bankName, "bankName", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getAutoPayBank().getBankLogo(), bankLogo, "bankLogo", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getAutoPayBank().getMandateApproved(), mandateApproved, "mandateApproved", false);
        Log.info("VERIFIED", "AutoPayBank");
    }

    public void verifyNetBankingBank(String beneficiaryName, String accountNumber, String ifsc, String bankName, String bankLogo, Boolean mandateApproved) {
        Log.info("VERIFY", "NetBankingBank");
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getNetBankingBank().getBeneficiaryName(), beneficiaryName, "beneficiaryName", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getNetBankingBank().getAccountNumber(), accountNumber, "accountNumber", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getNetBankingBank().getIfscCode(), ifsc, "ifsc", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getNetBankingBank().getBankName(), bankName, "bankName", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getNetBankingBank().getBankLogo(), bankLogo, "bankLogo", false);
        MbkReporter.verifyEqualsWithLogging(bankResponseDto.getData().getNetBankingBank().getMandateApproved(), mandateApproved, "mandateApproved", false);
        Log.info("VERIFIED", "NetBankingBank");
    }

}
