package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "thumbnailImage",
        "title",
        "subTitle",
        "insuranceCategory",
        "deeplink"
})
public class InsuranceThumbnailDetail {

    @JsonProperty("thumbnailImage")
    private String thumbnailImage;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subTitle")
    private String subTitle;
    @JsonProperty("insuranceCategory")
    private String insuranceCategory;
    @JsonProperty("deeplink")
    private String deeplink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumbnailImage")
    public String getThumbnailImage() {
        return thumbnailImage;
    }

    @JsonProperty("thumbnailImage")
    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subTitle")
    public String getSubTitle() {
        return subTitle;
    }

    @JsonProperty("subTitle")
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @JsonProperty("insuranceCategory")
    public String getInsuranceCategory() {
        return insuranceCategory;
    }

    @JsonProperty("insuranceCategory")
    public void setInsuranceCategory(String insuranceCategory) {
        this.insuranceCategory = insuranceCategory;
    }

    @JsonProperty("deeplink")
    public String getDeeplink() {
        return deeplink;
    }

    @JsonProperty("deeplink")
    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
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
