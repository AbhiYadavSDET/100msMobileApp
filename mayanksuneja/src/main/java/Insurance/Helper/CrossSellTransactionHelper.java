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

    public void verifyInsuranceSuccessResponse(int category) {
        Log.info("VERIFY", "Insurance Success Response");
        MbkReporter.verifyTrueWithLogging(crossSellTransactionDto.getData().getTxnResponses().get(category).getApiResponse().getSuccess(), "Verify Success Response", false);
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


}
