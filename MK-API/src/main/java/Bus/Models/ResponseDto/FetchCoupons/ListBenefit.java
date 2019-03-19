package Bus.Models.ResponseDto.FetchCoupons;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "left",
        "right"
})
public class ListBenefit {

    @JsonProperty("left")
    private String left;
    @JsonProperty("right")
    private String right;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("left")
    public String getLeft() {
        return left;
    }

    @JsonProperty("left")
    public void setLeft(String left) {
        this.left = left;
    }

    @JsonProperty("right")
    public String getRight() {
        return right;
    }

    @JsonProperty("right")
    public void setRight(String right) {
        this.right = right;
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
