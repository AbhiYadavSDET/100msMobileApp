package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "displayKey",
        "amount",
        "enable"
})
public class ServiceFee {

    @JsonProperty("displayKey")
    private String displayKey;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("enable")
    private Boolean enable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("displayKey")
    public String getDisplayKey() {
        return displayKey;
    }

    @JsonProperty("displayKey")
    public void setDisplayKey(String displayKey) {
        this.displayKey = displayKey;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
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