package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cardImage"
})
public class BannerCardDetail {

    @JsonProperty("cardImage")
    private String cardImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardImage")
    public String getCardImage() {
        return cardImage;
    }

    @JsonProperty("cardImage")
    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
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
