package Insurance.Models.responsedto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "requiredAmount",
        "walletAsPG"
})
public class InsurancePolicyPurchaseResponseData {

    @JsonProperty("requiredAmount")
    private String requiredAmount;
    @JsonProperty("walletAsPG")
    private WalletAsPG walletAsPG;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("requiredAmount")
    public String getRequiredAmount() {
        return requiredAmount;
    }

    @JsonProperty("requiredAmount")
    public void setRequiredAmount(String requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    @JsonProperty("walletAsPG")
    public WalletAsPG getWalletAsPG() {
        return walletAsPG;
    }

    @JsonProperty("walletAsPG")
    public void setWalletAsPG(WalletAsPG walletAsPG) {
        this.walletAsPG = walletAsPG;
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

