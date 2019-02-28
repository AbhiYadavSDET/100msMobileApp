package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isEnabled",
        "agId",
        "pgOptions"
})
public class WalletAsPG {

    @JsonProperty("isEnabled")
    private Boolean isEnabled;
    @JsonProperty("agId")
    private String agId;
    @JsonProperty("pgOptions")
    private List<String> pgOptions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isEnabled")
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    @JsonProperty("isEnabled")
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonProperty("agId")
    public String getAgId() {
        return agId;
    }

    @JsonProperty("agId")
    public void setAgId(String agId) {
        this.agId = agId;
    }

    @JsonProperty("pgOptions")
    public List<String> getPgOptions() {
        return pgOptions;
    }

    @JsonProperty("pgOptions")
    public void setPgOptions(List<String> pgOptions) {
        this.pgOptions = pgOptions;
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