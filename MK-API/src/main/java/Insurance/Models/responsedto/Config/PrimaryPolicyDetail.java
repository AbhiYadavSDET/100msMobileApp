package Insurance.Models.responsedto.Config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nameId",
        "displayName",
        "inputType",
        "regex",
        "prefilledValue",
        "isEditable",
        "dropdown",
        "placeHolder",
        "isTertiaryDetail",
        "ageLimit",
        "maxLength"
})
public class PrimaryPolicyDetail {

    @JsonProperty("nameId")
    private String nameId;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("inputType")
    private String inputType;
    @JsonProperty("regex")
    private String regex;
    @JsonProperty("prefilledValue")
    private String prefilledValue;
    @JsonProperty("isEditable")
    private Boolean isEditable;
    @JsonProperty("dropdown")
    private List<String> dropdown = null;
    @JsonProperty("placeHolder")
    private String placeHolder;
    @JsonProperty("isTertiaryDetail")
    private Boolean isTertiaryDetail;
    @JsonProperty("ageLimit")
    private AgeLimit ageLimit;
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

    @JsonProperty("inputType")
    public String getInputType() {
        return inputType;
    }

    @JsonProperty("inputType")
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    @JsonProperty("regex")
    public String getRegex() {
        return regex;
    }

    @JsonProperty("regex")
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @JsonProperty("prefilledValue")
    public String getPrefilledValue() {
        return prefilledValue;
    }

    @JsonProperty("prefilledValue")
    public void setPrefilledValue(String prefilledValue) {
        this.prefilledValue = prefilledValue;
    }

    @JsonProperty("isEditable")
    public Boolean getIsEditable() {
        return isEditable;
    }

    @JsonProperty("isEditable")
    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }

    @JsonProperty("dropdown")
    public List<String> getDropdown() {
        return dropdown;
    }

    @JsonProperty("dropdown")
    public void setDropdown(List<String> dropdown) {
        this.dropdown = dropdown;
    }

    @JsonProperty("placeHolder")
    public String getPlaceHolder() {
        return placeHolder;
    }

    @JsonProperty("placeHolder")
    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    @JsonProperty("isTertiaryDetail")
    public Boolean getIsTertiaryDetail() {
        return isTertiaryDetail;
    }

    @JsonProperty("isTertiaryDetail")
    public void setIsTertiaryDetail(Boolean isTertiaryDetail) {
        this.isTertiaryDetail = isTertiaryDetail;
    }

    @JsonProperty("ageLimit")
    public AgeLimit getAgeLimit() {
        return ageLimit;
    }

    @JsonProperty("ageLimit")
    public void setAgeLimit(AgeLimit ageLimit) {
        this.ageLimit = ageLimit;
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
