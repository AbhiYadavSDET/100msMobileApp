package Insurance.Helper;

import Insurance.Models.responsedto.CrossSellTransaction.CrossSellTransactionDto;
import Utils.DateFormatEnums;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CrossSellTransactionHelper {

    CrossSellTransactionDto crossSellTransactionDto;
    public ObjectMapper mapper;


    public CrossSellTransactionHelper(String jsonString) {
        mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            crossSellTransactionDto = mapper.readValue(jsonString, CrossSellTransactionDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(crossSellTransactionDto.getSuccess(), "Verify Success=true Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyFalseResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(!crossSellTransactionDto.getSuccess(), "Verify Success=false Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyRechargeSuccessResponse(int category) {
        Log.info("VERIFY", "Recharge Success Response");
        MbkReporter.verifyTrueWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Recharge success Response");
    }

    public void verifyRechargeSuccessResponse(int category, Boolean expected) {
        Log.info("VERIFY", "Recharge Success Response");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), expected, "Verify Success Response", false);
        Log.info("VERIFIED", "Recharge success Response");
    }

    public void verifyInsuranceSuccessResponse(int category) {
        Log.info("VERIFY", "Insurance Success Response");
        MbkReporter.verifyTrueWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Insurance success Response");
    }

    public void verifyInsuranceSuccessResponse(int category, Boolean expected) {
        Log.info("VERIFY", "Insurance Success Response");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), expected, "Verify Success Response", false);
        Log.info("VERIFIED", "Insurance success Response");
    }


    public void verifyPolicyPurchaseData(int category, Boolean kyc, String policyHolderName, String insurer, String sumAssured, String price, String insuranceCategory, String responseType, String congratulationsMessage) {
        Log.info("VERIFY", "Data");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getKyc(), kyc, "Verify KYC", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getInsurer(), insurer, "Verify Insurer", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getSumAssured(), sumAssured, "Verify Sum assured", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getPrice(), price, "Verify Price", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getInsuranceCategory(), insuranceCategory, "Verify Insurance Category", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getResponseType(), responseType, "Verify Response Type", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getConratulationsMessage(), congratulationsMessage, "Verify Congratulation Message", false);
        Log.info("VERIFIED", "Data");

    }

    public void verifyPolicyPurchaseStartEndDate(int category, int policyDurationInMonths) {
        Log.info("VERIFY", "Policy Purchase Start and End dates");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getStartDate().substring(0, 11), Utils.DateHelper.getCurrentDate(DateFormatEnums.DD_MMM_YYYY), "Verify Start-Date", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getEndDate().substring(0, 11), Utils.DateHelper.getDateAterNMonthsMinusMDays(DateFormatEnums.DD_MMM_YYYY, policyDurationInMonths, 1), "Verify End-Date", false);
        Log.info("VERIFIED", "Policy Purchase Start and End dates");

    }

    public void verifyRechargeData(int category, String status, String description, Double discountedPrice) {
        Log.info("VERIFY", "Recharge Data");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getStatus(), status, "Verify Recharge Status", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getDescription(), description, "Verify Recharge Description", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getDiscountedPrice(), discountedPrice, "Verify Recharge Amount", false);
        Log.info("VERIFIED", "Recharge Data");

    }

    public void verifyMessage(String code, String text) {
        Log.info("VERIFY", "Insufficient Message");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getMessage().getCode(), code, "Verify Message Code", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getMessage().getText(), text, "Verify Message text", false);
        Log.info("VERIFIED", "Insufficient Message");

    }

    public void verifyRequiredAmount(Double amount) {
        Log.info("VERIFY", "Required Amount");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getRequiredAmount(), amount, "Verify Required Amount", false);
        Log.info("VERIFIED", "Required Amount");

    }

    public void verifyRechargeDataForTC_02(int category, String code, String text) {
        Log.info("VERIFY", "Recharge Data for TC_02");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getCode(), code, "Verify Recharge Error Code", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getText(), text, "Verify Recharge Error Message", false);
        Log.info("VERIFIED", "Recharge Data for TC_02");

    }

    public void verifyInsuranceDataForTC_03(int category, String code, String text) {
        Log.info("VERIFY", "Insurance Data for TC_03");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getCode(), code, "Error code", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getText(), text, "Error message", false);
        Log.info("VERIFIED", "Insurance Data for TC_03");

    }

    public void verifyPgOptions(int count, String option1, String option2, String option3) {
        Log.info("VERIFY", "PG Options");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().size(), count, "Verify PG Options count", false);
        if (crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().size() == count) {
            MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().get(0), option1, "Verify PG Options 1", false);
            MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().get(1), option2, "Verify PG Options 2", false);
            MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().get(2), option3, "Verify PG Options 3", false);
        }
        Log.info("VERIFIED", "PG Options");

    }

    public void verifyAmountToAdd(Double amount) {
        Log.info("VERIFY", "Amount to be Added");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getData().getRequiredAmount(), amount, "Verify Amount to be added", false);
        Log.info("VERIFIED", "Amount to be Added");

    }

    public void verifyAddMoneyMessage(String errorCode, String errorMessage) {
        Log.info("VERIFY", "Add Money Message");
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getMessage().getCode(), errorCode, "Verify code", false);
        MbkReporter.verifyEqualsWithLogging(crossSellTransactionDto.getMessage().getText(), errorMessage, "Verify message", false);
        Log.info("VERIFIED", "Add Money Message");

    }

}
