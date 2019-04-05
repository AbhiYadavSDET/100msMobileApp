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


    public void verifySuccessResponse() throws IOException {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLoggingExtentReport(crossSellTransactionDto.getSuccess(), "Verify Success Response", "Expected = true", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyFalseResponse() throws IOException {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLoggingExtentReport(!crossSellTransactionDto.getSuccess(), "Verify Success Response", "Expected = false", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyRechargeSuccessResponse(int category) throws IOException {
        Log.info("VERIFY", "Recharge Success Response");
        MbkReporter.verifyTrueWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), "Verify Recharge Success Response", "Expected = true", false);
        Log.info("VERIFIED", "Recharge success Response");
    }

    public void verifyRechargeSuccessResponse(int category, Boolean expected) throws IOException {
        Log.info("VERIFY", "Recharge Success Response");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), expected, "Verify Recharge Success Response", false);
        Log.info("VERIFIED", "Recharge success Response");
    }

    public void verifyInsuranceSuccessResponse(int category) throws IOException {
        Log.info("VERIFY", "Insurance Success Response");
        MbkReporter.verifyTrueWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), "Verify Insurance Success Response", "Expected = true", false);
        Log.info("VERIFIED", "Insurance success Response");
    }

    public void verifyInsuranceSuccessResponse(int category, Boolean expected) throws IOException {
        Log.info("VERIFY", "Insurance Success Response");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), expected, "Verify Insurance Success Response", false);
        Log.info("VERIFIED", "Insurance success Response");
    }


    public void verifyPolicyPurchaseData(int category, Boolean kyc, String policyHolderName, String insurer, String sumAssured, String price, String insuranceCategory, String responseType, String congratulationsMessage) throws IOException {
        Log.info("VERIFY", "Data");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getKyc(), kyc, "Verify KYC", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getInsurer(), insurer, "Verify Insurer", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getSumAssured(), sumAssured, "Verify Sum assured", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getPrice(), price, "Verify Price", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getInsuranceCategory(), insuranceCategory, "Verify Insurance Category", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getResponseType(), responseType, "Verify Response Type", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getConratulationsMessage(), congratulationsMessage, "Verify Congratulation Message", false);
        Log.info("VERIFIED", "Data");

    }

    public void verifyPolicyPurchaseStartEndDate(int category, int policyDurationInMonths) throws IOException {
        Log.info("VERIFY", "Policy Purchase Start and End dates");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getStartDate().substring(0, 11), Utils.DateHelper.getCurrentDate(DateFormatEnums.DD_MMM_YYYY), "Verify Start-Date", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getFixedInsuranceDetails().getPolicyPurchaseResponse().getEndDate().substring(0, 11), Utils.DateHelper.getDateAterNMonthsMinusMDays(DateFormatEnums.DD_MMM_YYYY, policyDurationInMonths, 1), "Verify End-Date", false);
        Log.info("VERIFIED", "Policy Purchase Start and End dates");

    }

    public void verifyRechargeData(int category, String status, String description, Double discountedPrice) throws IOException {
        Log.info("VERIFY", "Recharge Data");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getStatus(), status, "Verify Recharge Status", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getDescription(), description, "Verify Recharge Description", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getData().getDiscountedPrice(), discountedPrice, "Verify Recharge Amount", false);
        Log.info("VERIFIED", "Recharge Data");

    }

    public void verifyMessage(String code, String text) throws IOException {
        Log.info("VERIFY", "Insufficient Message");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getMessage().getCode(), code, "Verify Message Code", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getMessage().getText(), text, "Verify Message text", false);
        Log.info("VERIFIED", "Insufficient Message");

    }

    public void verifyRequiredAmount(Double amount) throws IOException {
        Log.info("VERIFY", "Required Amount");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getRequiredAmount(), amount, "Verify Required Amount", false);
        Log.info("VERIFIED", "Required Amount");

    }

    public void verifyRechargeDataForTC_02(int category, String code, String text) throws IOException {
        Log.info("VERIFY", "Recharge Data for TC_02");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getCode(), code, "Verify Recharge Error Code", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getText(), text, "Verify Recharge Error Message", false);
        Log.info("VERIFIED", "Recharge Data for TC_02");

    }

    public void verifyInsuranceDataForTC_03(int category, String code, String text) throws IOException {
        Log.info("VERIFY", "Insurance Data for TC_03");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getCode(), code, "Error code", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getMessage().getText(), text, "Error message", false);
        Log.info("VERIFIED", "Insurance Data for TC_03");

    }

    public void verifyPgOptions(int count, String option1, String option2, String option3) throws IOException {
        Log.info("VERIFY", "PG Options");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().size(), count, "Verify PG Options count", false);
        if (crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().size() == count) {
            MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().get(0), option1, "Verify PG Options 1", false);
            MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().get(1), option2, "Verify PG Options 2", false);
            MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getWalletAsPG().getPgOptions().get(2), option3, "Verify PG Options 3", false);
        }
        Log.info("VERIFIED", "PG Options");

    }

    public void verifyAmountToAdd(Double amount) throws IOException {
        Log.info("VERIFY", "Amount to be Added");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getData().getRequiredAmount(), amount, "Verify Amount to be added", false);
        Log.info("VERIFIED", "Amount to be Added");

    }

    public void verifyAddMoneyMessage(String errorCode, String errorMessage) throws IOException {
        Log.info("VERIFY", "Add Money Message");
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getMessage().getCode(), errorCode, "Verify code", false);
        MbkReporter.verifyEqualsWithLoggingExtentReport(crossSellTransactionDto.getMessage().getText(), errorMessage, "Verify message", false);
        Log.info("VERIFIED", "Add Money Message");

    }

}
