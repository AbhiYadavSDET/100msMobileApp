package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "apiResponse"
})
public class TxnResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("apiResponse")
    private ApiResponse apiResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("apiResponse")
    public ApiResponse getApiResponse() {
        return apiResponse;
    }

    @JsonProperty("apiResponse")
    public void setApiResponse(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
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