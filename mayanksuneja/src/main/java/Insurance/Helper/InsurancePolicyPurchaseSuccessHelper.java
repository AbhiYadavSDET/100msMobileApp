package Insurance.Helper;

import Insurance.Models.responsedto.InsurancePolicyPurchaseSuccessResponseDto;
import Utils.DateFormatEnums;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class InsurancePolicyPurchaseSuccessHelper {

    InsurancePolicyPurchaseSuccessResponseDto insurancePolicyPurchaseSuccessResponseDto;
    public ObjectMapper mapper;


    public InsurancePolicyPurchaseSuccessHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            insurancePolicyPurchaseSuccessResponseDto = mapper.readValue(jsonString, InsurancePolicyPurchaseSuccessResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(insurancePolicyPurchaseSuccessResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }


    public void verifyData(Boolean kyc, String policyHolderName, String insurer, String sumAssured, String price, String insuranceCategory, String responseType, String congratulationsMessage) {
        Log.info("VERIFY", "Data");
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getKyc(), kyc, "Verify KYC", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getPolicyHolderName(), policyHolderName, "Verify Policy Holder Name", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getInsurer(), insurer, "Verify Insurer", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getSumAssured(), sumAssured, "Verify Sum assured", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getPrice(), price, "Verify Price", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getInsuranceCategory(), insuranceCategory, "Verify Insurance Category", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getResponseType(), responseType, "Verify Response Type", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getConratulationsMessage(), congratulationsMessage, "Verify Congratulation Message", false);
        Log.info("VERIFIED", "Data");

    }

    public void verifyStartEndDate(int policyDurationInMonths) {
        Log.info("VERIFY", "Start and End dates");
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getStartDate().substring(0, 11), Utils.DateHelper.getCurrentDate(DateFormatEnums.DD_MMM_YYYY), "Verify Start-Date", false);
        MbkReporter.verifyEqualsWithLogging(insurancePolicyPurchaseSuccessResponseDto.getData().getEndDate().substring(0, 11), Utils.DateHelper.getDateAterNMonthsMinusMDays(DateFormatEnums.DD_MMM_YYYY, policyDurationInMonths, 1), "Verify End-Date", false);
        Log.info("VERIFIED", "Start and End dates");

    }

    public void setPolicyId() {
        //Log.info("SET", "Policy ID");
        String policyId = insurancePolicyPurchaseSuccessResponseDto.getData().getPolicyNo();
        //Log.info(policyId);
        InsuranceDetailsV2Helper.map.put("policyId", policyId);
    }
}
