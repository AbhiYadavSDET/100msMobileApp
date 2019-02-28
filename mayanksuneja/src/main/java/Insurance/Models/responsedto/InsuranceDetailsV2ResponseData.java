package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fixedInsuranceDetails",
        "variableInsuranceDetails",
        "addMoneyCrossSell"
})
public class InsuranceDetailsV2ResponseData {

    @JsonProperty("fixedInsuranceDetails")
    private FixedInsuranceDetails fixedInsuranceDetails;
    @JsonProperty("variableInsuranceDetails")
    private List<VariableInsuranceDetail> variableInsuranceDetails = null;
    @JsonProperty("addMoneyCrossSell")
    private Boolean addMoneyCrossSell;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fixedInsuranceDetails")
    public FixedInsuranceDetails getFixedInsuranceDetails() {
        return fixedInsuranceDetails;
    }

    @JsonProperty("fixedInsuranceDetails")
    public void setFixedInsuranceDetails(FixedInsuranceDetails fixedInsuranceDetails) {
        this.fixedInsuranceDetails = fixedInsuranceDetails;
    }

    @JsonProperty("variableInsuranceDetails")
    public List<VariableInsuranceDetail> getVariableInsuranceDetails() {
        return variableInsuranceDetails;
    }

    @JsonProperty("variableInsuranceDetails")
    public void setVariableInsuranceDetails(List<VariableInsuranceDetail> variableInsuranceDetails) {
        this.variableInsuranceDetails = variableInsuranceDetails;
    }

    @JsonProperty("addMoneyCrossSell")
    public Boolean getAddMoneyCrossSell() {
        return addMoneyCrossSell;
    }

    @JsonProperty("addMoneyCrossSell")
    public void setAddMoneyCrossSell(Boolean addMoneyCrossSell) {
        this.addMoneyCrossSell = addMoneyCrossSell;
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
