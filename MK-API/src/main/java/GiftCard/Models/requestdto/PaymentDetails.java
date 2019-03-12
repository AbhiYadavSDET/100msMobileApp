package GiftCard.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "superCashApplied"
})
public class PaymentDetails {

    @JsonProperty("superCashApplied")
    private Boolean superCashApplied;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("superCashApplied")
    public Boolean getSuperCashApplied() {
        return superCashApplied;
    }

    @JsonProperty("superCashApplied")
    public void setSuperCashApplied(Boolean superCashApplied) {
        this.superCashApplied = superCashApplied;
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
