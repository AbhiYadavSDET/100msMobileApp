package Insurance.Models.requestdto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "insuranceCategory",
        "insuranceSellingPlatform"
})


public class InsuranceDetailsV2Dto {
    @JsonProperty("insuranceCategory")
    private String insuranceCategory;
    @JsonProperty("insuranceSellingPlatform")
    private String insuranceSellingPlatform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("insuranceCategory")
    public String getInsuranceCategory() {
        return insuranceCategory;
    }

    @JsonProperty("insuranceCategory")
    public void setInsuranceCategory(String insuranceCategory) {
        this.insuranceCategory = insuranceCategory;
    }

    @JsonProperty("insuranceSellingPlatform")
    public String getInsuranceSellingPlatform() {
        return insuranceSellingPlatform;
    }

    @JsonProperty("insuranceSellingPlatform")
    public void setInsuranceSellingPlatform(String insuranceSellingPlatform) {
        this.insuranceSellingPlatform = insuranceSellingPlatform;
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

