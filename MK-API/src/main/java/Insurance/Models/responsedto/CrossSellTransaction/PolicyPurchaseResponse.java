package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kyc",
        "responseHeading",
        "policyNo",
        "orderNo",
        "insurer",
        "startDate",
        "endDate",
        "policyDocUrl",
        "sumAssured",
        "price",
        "insuranceCategory",
        "insuranceCategoryEnum",
        "policyIconUrl",
        "responseType",
        "conratulationsMessage"
})
public class PolicyPurchaseResponse {

    @JsonProperty("kyc")
    private Boolean kyc;
    @JsonProperty("responseHeading")
    private String responseHeading;
    @JsonProperty("policyNo")
    private String policyNo;
    @JsonProperty("orderNo")
    private String orderNo;
    @JsonProperty("insurer")
    private String insurer;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("policyDocUrl")
    private String policyDocUrl;
    @JsonProperty("sumAssured")
    private String sumAssured;
    @JsonProperty("price")
    private String price;
    @JsonProperty("insuranceCategory")
    private String insuranceCategory;
    @JsonProperty("insuranceCategoryEnum")
    private String insuranceCategoryEnum;
    @JsonProperty("policyIconUrl")
    private String policyIconUrl;
    @JsonProperty("responseType")
    private String responseType;
    @JsonProperty("conratulationsMessage")
    private String conratulationsMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kyc")
    public Boolean getKyc() {
        return kyc;
    }

    @JsonProperty("kyc")
    public void setKyc(Boolean kyc) {
        this.kyc = kyc;
    }

    @JsonProperty("responseHeading")
    public String getResponseHeading() {
        return responseHeading;
    }

    @JsonProperty("responseHeading")
    public void setResponseHeading(String responseHeading) {
        this.responseHeading = responseHeading;
    }

    @JsonProperty("policyNo")
    public String getPolicyNo() {
        return policyNo;
    }

    @JsonProperty("policyNo")
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    @JsonProperty("orderNo")
    public String getOrderNo() {
        return orderNo;
    }

    @JsonProperty("orderNo")
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @JsonProperty("insurer")
    public String getInsurer() {
        return insurer;
    }

    @JsonProperty("insurer")
    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("policyDocUrl")
    public String getPolicyDocUrl() {
        return policyDocUrl;
    }

    @JsonProperty("policyDocUrl")
    public void setPolicyDocUrl(String policyDocUrl) {
        this.policyDocUrl = policyDocUrl;
    }

    @JsonProperty("sumAssured")
    public String getSumAssured() {
        return sumAssured;
    }

    @JsonProperty("sumAssured")
    public void setSumAssured(String sumAssured) {
        this.sumAssured = sumAssured;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("insuranceCategory")
    public String getInsuranceCategory() {
        return insuranceCategory;
    }

    @JsonProperty("insuranceCategory")
    public void setInsuranceCategory(String insuranceCategory) {
        this.insuranceCategory = insuranceCategory;
    }

    @JsonProperty("insuranceCategoryEnum")
    public String getInsuranceCategoryEnum() {
        return insuranceCategoryEnum;
    }

    @JsonProperty("insuranceCategoryEnum")
    public void setInsuranceCategoryEnum(String insuranceCategoryEnum) {
        this.insuranceCategoryEnum = insuranceCategoryEnum;
    }

    @JsonProperty("policyIconUrl")
    public String getPolicyIconUrl() {
        return policyIconUrl;
    }

    @JsonProperty("policyIconUrl")
    public void setPolicyIconUrl(String policyIconUrl) {
        this.policyIconUrl = policyIconUrl;
    }

    @JsonProperty("responseType")
    public String getResponseType() {
        return responseType;
    }

    @JsonProperty("responseType")
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    @JsonProperty("conratulationsMessage")
    public String getConratulationsMessage() {
        return conratulationsMessage;
    }

    @JsonProperty("conratulationsMessage")
    public void setConratulationsMessage(String conratulationsMessage) {
        this.conratulationsMessage = conratulationsMessage;
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