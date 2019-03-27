package Insurance.Models.responsedto.Config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ICICI Lombard",
        "ICICI Prudential",
        "BAJAJ Allianz"
})
public class AgeLimit {

    @JsonProperty("ICICI Lombard")
    private ICICILombard iCICILombard;
    @JsonProperty("ICICI Prudential")
    private ICICIPrudential iCICIPrudential;
    @JsonProperty("BAJAJ Allianz")
    private BAJAJAllianz bAJAJAllianz;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ICICI Lombard")
    public ICICILombard getICICILombard() {
        return iCICILombard;
    }

    @JsonProperty("ICICI Lombard")
    public void setICICILombard(ICICILombard iCICILombard) {
        this.iCICILombard = iCICILombard;
    }

    @JsonProperty("ICICI Prudential")
    public ICICIPrudential getICICIPrudential() {
        return iCICIPrudential;
    }

    @JsonProperty("ICICI Prudential")
    public void setICICIPrudential(ICICIPrudential iCICIPrudential) {
        this.iCICIPrudential = iCICIPrudential;
    }

    @JsonProperty("BAJAJ Allianz")
    public BAJAJAllianz getBAJAJAllianz() {
        return bAJAJAllianz;
    }

    @JsonProperty("BAJAJ Allianz")
    public void setBAJAJAllianz(BAJAJAllianz bAJAJAllianz) {
        this.bAJAJAllianz = bAJAJAllianz;
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