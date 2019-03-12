package Insurance.Models.requestdto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "insuranceId",
        "autoRenew"
})
public class InsurancePolicyPurchaseDto {

    @JsonProperty("insuranceId")
    private String insuranceId;
    @JsonProperty("autoRenew")
    private Boolean autoRenew;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("insuranceId")
    public String getInsuranceId() {
        return insuranceId;
    }

    @JsonProperty("insuranceId")
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    @JsonProperty("autoRenew")
    public Boolean getAutoRenew() {
        return autoRenew;
    }

    @JsonProperty("autoRenew")
    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
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

