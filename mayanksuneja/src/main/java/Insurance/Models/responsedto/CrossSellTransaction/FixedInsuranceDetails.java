package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "responseType",
        "category",
        "planCoverage",
        "helplineNo",
        "policyIconUrl",
        "insurer",
        "policyPurchaseResponse",
        "policyId",
        "sumAssured",
        "policyPurchasedSumAssured",
        "shouldShowAutoApprove"
})
public class FixedInsuranceDetails {

    @JsonProperty("responseType")
    private String responseType;
    @JsonProperty("category")
    private String category;
    @JsonProperty("planCoverage")
    private List<Object> planCoverage = null;
    @JsonProperty("helplineNo")
    private String helplineNo;
    @JsonProperty("policyIconUrl")
    private String policyIconUrl;
    @JsonProperty("insurer")
    private String insurer;
    @JsonProperty("policyPurchaseResponse")
    private PolicyPurchaseResponse policyPurchaseResponse;
    @JsonProperty("policyId")
    private String policyId;
    @JsonProperty("sumAssured")
    private String sumAssured;
    @JsonProperty("policyPurchasedSumAssured")
    private String policyPurchasedSumAssured;
    @JsonProperty("shouldShowAutoApprove")
    private Boolean shouldShowAutoApprove;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("responseType")
    public String getResponseType() {
        return responseType;
    }

    @JsonProperty("responseType")
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("planCoverage")
    public List<Object> getPlanCoverage() {
        return planCoverage;
    }

    @JsonProperty("planCoverage")
    public void setPlanCoverage(List<Object> planCoverage) {
        this.planCoverage = planCoverage;
    }

    @JsonProperty("helplineNo")
    public String getHelplineNo() {
        return helplineNo;
    }

    @JsonProperty("helplineNo")
    public void setHelplineNo(String helplineNo) {
        this.helplineNo = helplineNo;
    }

    @JsonProperty("policyIconUrl")
    public String getPolicyIconUrl() {
        return policyIconUrl;
    }

    @JsonProperty("policyIconUrl")
    public void setPolicyIconUrl(String policyIconUrl) {
        this.policyIconUrl = policyIconUrl;
    }

    @JsonProperty("insurer")
    public String getInsurer() {
        return insurer;
    }

    @JsonProperty("insurer")
    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    @JsonProperty("policyPurchaseResponse")
    public PolicyPurchaseResponse getPolicyPurchaseResponse() {
        return policyPurchaseResponse;
    }

    @JsonProperty("policyPurchaseResponse")
    public void setPolicyPurchaseResponse(PolicyPurchaseResponse policyPurchaseResponse) {
        this.policyPurchaseResponse = policyPurchaseResponse;
    }

    @JsonProperty("policyId")
    public String getPolicyId() {
        return policyId;
    }

    @JsonProperty("policyId")
    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    @JsonProperty("sumAssured")
    public String getSumAssured() {
        return sumAssured;
    }

    @JsonProperty("sumAssured")
    public void setSumAssured(String sumAssured) {
        this.sumAssured = sumAssured;
    }

    @JsonProperty("policyPurchasedSumAssured")
    public String getPolicyPurchasedSumAssured() {
        return policyPurchasedSumAssured;
    }

    @JsonProperty("policyPurchasedSumAssured")
    public void setPolicyPurchasedSumAssured(String policyPurchasedSumAssured) {
        this.policyPurchasedSumAssured = policyPurchasedSumAssured;
    }

    @JsonProperty("shouldShowAutoApprove")
    public Boolean getShouldShowAutoApprove() {
        return shouldShowAutoApprove;
    }

    @JsonProperty("shouldShowAutoApprove")
    public void setShouldShowAutoApprove(Boolean shouldShowAutoApprove) {
        this.shouldShowAutoApprove = shouldShowAutoApprove;
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