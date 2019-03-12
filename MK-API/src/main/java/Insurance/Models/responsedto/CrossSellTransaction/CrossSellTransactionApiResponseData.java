package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fixedInsuranceDetails",
        "addMoneyCrossSell",
        "txId",
        "extRefNo",
        "status",
        "description",
        "balance",
        "discountedPrice",
        "walletAmount",
        "pgAmount",
        "lineItemList",
        "superCashBurned",
        "requestJson",
        "serviceFee",
        "businessError"
})
public class CrossSellTransactionApiResponseData {

    @JsonProperty("fixedInsuranceDetails")
    private FixedInsuranceDetails fixedInsuranceDetails;
    @JsonProperty("addMoneyCrossSell")
    private Boolean addMoneyCrossSell;
    @JsonProperty("txId")
    private String txId;
    @JsonProperty("extRefNo")
    private String extRefNo;
    @JsonProperty("status")
    private String status;
    @JsonProperty("description")
    private String description;
    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("discountedPrice")
    private Double discountedPrice;
    @JsonProperty("walletAmount")
    private Double walletAmount;
    @JsonProperty("pgAmount")
    private Double pgAmount;
    @JsonProperty("lineItemList")
    private List<LineItemList> lineItemList = null;
    @JsonProperty("superCashBurned")
    private Double superCashBurned;
    @JsonProperty("requestJson")
    private String requestJson;
    @JsonProperty("serviceFee")
    private ServiceFee serviceFee;
    @JsonProperty("businessError")
    private Boolean businessError;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fixedInsuranceDetails")
    public FixedInsuranceDetails getFixedInsuranceDetails() {
        return fixedInsuranceDetails;
    }

    @JsonProperty("fixedInsuranceDetails")
    public void setFixedInsuranceDetails(FixedInsuranceDetails fixedInsuranceDetails) {
        this.fixedInsuranceDetails = fixedInsuranceDetails;
    }

    @JsonProperty("addMoneyCrossSell")
    public Boolean getAddMoneyCrossSell() {
        return addMoneyCrossSell;
    }

    @JsonProperty("addMoneyCrossSell")
    public void setAddMoneyCrossSell(Boolean addMoneyCrossSell) {
        this.addMoneyCrossSell = addMoneyCrossSell;
    }

    @JsonProperty("txId")
    public String getTxId() {
        return txId;
    }

    @JsonProperty("txId")
    public void setTxId(String txId) {
        this.txId = txId;
    }

    @JsonProperty("extRefNo")
    public String getExtRefNo() {
        return extRefNo;
    }

    @JsonProperty("extRefNo")
    public void setExtRefNo(String extRefNo) {
        this.extRefNo = extRefNo;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @JsonProperty("discountedPrice")
    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    @JsonProperty("discountedPrice")
    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @JsonProperty("walletAmount")
    public Double getWalletAmount() {
        return walletAmount;
    }

    @JsonProperty("walletAmount")
    public void setWalletAmount(Double walletAmount) {
        this.walletAmount = walletAmount;
    }

    @JsonProperty("pgAmount")
    public Double getPgAmount() {
        return pgAmount;
    }

    @JsonProperty("pgAmount")
    public void setPgAmount(Double pgAmount) {
        this.pgAmount = pgAmount;
    }

    @JsonProperty("lineItemList")
    public List<LineItemList> getLineItemList() {
        return lineItemList;
    }

    @JsonProperty("lineItemList")
    public void setLineItemList(List<LineItemList> lineItemList) {
        this.lineItemList = lineItemList;
    }

    @JsonProperty("superCashBurned")
    public Double getSuperCashBurned() {
        return superCashBurned;
    }

    @JsonProperty("superCashBurned")
    public void setSuperCashBurned(Double superCashBurned) {
        this.superCashBurned = superCashBurned;
    }

    @JsonProperty("requestJson")
    public String getRequestJson() {
        return requestJson;
    }

    @JsonProperty("requestJson")
    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

    @JsonProperty("serviceFee")
    public ServiceFee getServiceFee() {
        return serviceFee;
    }

    @JsonProperty("serviceFee")
    public void setServiceFee(ServiceFee serviceFee) {
        this.serviceFee = serviceFee;
    }

    @JsonProperty("businessError")
    public Boolean getBusinessError() {
        return businessError;
    }

    @JsonProperty("businessError")
    public void setBusinessError(Boolean businessError) {
        this.businessError = businessError;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
