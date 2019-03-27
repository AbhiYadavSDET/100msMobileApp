package Insurance.Models.responsedto.Config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "primaryPolicyDetails",
        "insuranceSellingPlatforms",
        "insurer",
        "secondaryPolicyDetails",
        "insuranceResponseType"
})
public class Data {

    @JsonProperty("primaryPolicyDetails")
    private List<PrimaryPolicyDetail> primaryPolicyDetails = null;
    @JsonProperty("insuranceSellingPlatforms")
    private List<InsuranceSellingPlatforms> insuranceSellingPlatforms = null;
    @JsonProperty("insurer")
    private List<Insurer> insurer = null;
    @JsonProperty("secondaryPolicyDetails")
    private List<SecondaryPolicyDetail> secondaryPolicyDetails = null;
    @JsonProperty("insuranceResponseType")
    private List<InsuranceResponseType> insuranceResponseType = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("primaryPolicyDetails")
    public List<PrimaryPolicyDetail> getPrimaryPolicyDetails() {
        return primaryPolicyDetails;
    }

    @JsonProperty("primaryPolicyDetails")
    public void setPrimaryPolicyDetails(List<PrimaryPolicyDetail> primaryPolicyDetails) {
        this.primaryPolicyDetails = primaryPolicyDetails;
    }

    @JsonProperty("insuranceSellingPlatforms")
    public List<InsuranceSellingPlatforms> getInsuranceSellingPlatforms() {
        return insuranceSellingPlatforms;
    }

    @JsonProperty("insuranceSellingPlatforms")
    public void setInsuranceSellingPlatforms(List<InsuranceSellingPlatforms> insuranceSellingPlatforms) {
        this.insuranceSellingPlatforms = insuranceSellingPlatforms;
    }

    @JsonProperty("insurer")
    public List<Insurer> getInsurer() {
        return insurer;
    }

    @JsonProperty("insurer")
    public void setInsurer(List<Insurer> insurer) {
        this.insurer = insurer;
    }

    @JsonProperty("secondaryPolicyDetails")
    public List<SecondaryPolicyDetail> getSecondaryPolicyDetails() {
        return secondaryPolicyDetails;
    }

    @JsonProperty("secondaryPolicyDetails")
    public void setSecondaryPolicyDetails(List<SecondaryPolicyDetail> secondaryPolicyDetails) {
        this.secondaryPolicyDetails = secondaryPolicyDetails;
    }

    @JsonProperty("insuranceResponseType")
    public List<InsuranceResponseType> getInsuranceResponseType() {
        return insuranceResponseType;
    }

    @JsonProperty("insuranceResponseType")
    public void setInsuranceResponseType(List<InsuranceResponseType> insuranceResponseType) {
        this.insuranceResponseType = insuranceResponseType;
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
