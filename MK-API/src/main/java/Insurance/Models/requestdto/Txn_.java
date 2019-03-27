package Insurance.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "senderToWalletEnum",
        "insuranceSellingPlatform"
})
public class Txn_ {

    @JsonProperty("senderToWalletEnum")
    private String senderToWalletEnum;
    @JsonProperty("insuranceSellingPlatform")
    private String insuranceSellingPlatform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("senderToWalletEnum")
    public String getSenderToWalletEnum() {
        return senderToWalletEnum;
    }

    @JsonProperty("senderToWalletEnum")
    public void setSenderToWalletEnum(String senderToWalletEnum) {
        this.senderToWalletEnum = senderToWalletEnum;
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
