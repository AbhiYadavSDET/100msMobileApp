package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "displayKey",
        "displayName"
})
public class QuoteParam {

    @JsonProperty("displayKey")
    private String displayKey;
    @JsonProperty("displayName")
    private String displayName;
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

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
