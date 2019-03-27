package Insurance.Models.responsedto.Config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nameId",
        "displayName",
        "isEditable",
        "isTertiaryDetail",
        "maxLength"
})
public class InsuranceResponseType {

    @JsonProperty("nameId")
    private String nameId;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("isEditable")
    private Boolean isEditable;
    @JsonProperty("isTertiaryDetail")
    private Boolean isTertiaryDetail;
    @JsonProperty("maxLength")
    private Integer maxLength;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nameId")
    public String getNameId() {
        return nameId;
    }

    @JsonProperty("nameId")
    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("isEditable")
    public Boolean getIsEditable() {
        return isEditable;
    }

    @JsonProperty("isEditable")
    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }

    @JsonProperty("isTertiaryDetail")
    public Boolean getIsTertiaryDetail() {
        return isTertiaryDetail;
    }

    @JsonProperty("isTertiaryDetail")
    public void setIsTertiaryDetail(Boolean isTertiaryDetail) {
        this.isTertiaryDetail = isTertiaryDetail;
    }

    @JsonProperty("maxLength")
    public Integer getMaxLength() {
        return maxLength;
    }

    @JsonProperty("maxLength")
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
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