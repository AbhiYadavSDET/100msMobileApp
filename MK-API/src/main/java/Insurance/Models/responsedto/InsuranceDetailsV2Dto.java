package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "data"
})
public class InsuranceDetailsV2Dto {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("data")
    private InsuranceDetailsV2ResponseData insuranceDetailsV2ResponseData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("data")
    public InsuranceDetailsV2ResponseData getData() {
        return insuranceDetailsV2ResponseData;
    }

    @JsonProperty("data")
    public void setData(InsuranceDetailsV2ResponseData data) {
        this.insuranceDetailsV2ResponseData = data;
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
