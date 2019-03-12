package GiftCard.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "brandId"
})
public class Brand {

    @JsonProperty("brandId")
    private String brandId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    @JsonProperty("brandId")
    public void setBrandId(String brandId) {
        this.brandId = brandId;
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
