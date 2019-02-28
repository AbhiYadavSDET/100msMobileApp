package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "responseType",
        "category",
        "planCoverage",
        "platform",
        "tnc",
        "scopeId",
        "helplineNo",
        "policyIconUrl",
        "insurer",
        "oldHeadingIcon",
        "tncText",
        "poweredByIcon",
        "planCoverageHeading",
        "shouldShowAutoApprove",
        "autoApproveText"
})
public class FixedInsuranceDetails {

    @JsonProperty("responseType")
    private String responseType;
    @JsonProperty("category")
    private String category;
    @JsonProperty("planCoverage")
    private List<PlanCoverage> planCoverage = null;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("tnc")
    private String tnc;
    @JsonProperty("scopeId")
    private String scopeId;
    @JsonProperty("helplineNo")
    private String helplineNo;
    @JsonProperty("policyIconUrl")
    private String policyIconUrl;
    @JsonProperty("insurer")
    private String insurer;
    @JsonProperty("oldHeadingIcon")
    private String oldHeadingIcon;
    @JsonProperty("tncText")
    private String tncText;
    @JsonProperty("poweredByIcon")
    private String poweredByIcon;
    @JsonProperty("planCoverageHeading")
    private String planCoverageHeading;
    @JsonProperty("shouldShowAutoApprove")
    private Boolean shouldShowAutoApprove;
    @JsonProperty("autoApproveText")
    private String autoApproveText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("responseType")
    public String getResponseType() {
        return responseType;
    }

    @JsonProperty("responseType")
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("planCoverage")
    public List<PlanCoverage> getPlanCoverage() {
        return planCoverage;
    }

    @JsonProperty("planCoverage")
    public void setPlanCoverage(List<PlanCoverage> planCoverage) {
        this.planCoverage = planCoverage;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("tnc")
    public String getTnc() {
        return tnc;
    }

    @JsonProperty("tnc")
    public void setTnc(String tnc) {
        this.tnc = tnc;
    }

    @JsonProperty("scopeId")
    public String getScopeId() {
        return scopeId;
    }

    @JsonProperty("scopeId")
    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    @JsonProperty("helplineNo")
    public String getHelplineNo() {
        return helplineNo;
    }

    @JsonProperty("helplineNo")
    public void setHelplineNo(String helplineNo) {
        this.helplineNo = helplineNo;
    }

    @JsonProperty("policyIconUrl")
    public String getPolicyIconUrl() {
        return policyIconUrl;
    }

    @JsonProperty("policyIconUrl")
    public void setPolicyIconUrl(String policyIconUrl) {
        this.policyIconUrl = policyIconUrl;
    }

    @JsonProperty("insurer")
    public String getInsurer() {
        return insurer;
    }

    @JsonProperty("insurer")
    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    @JsonProperty("oldHeadingIcon")
    public String getOldHeadingIcon() {
        return oldHeadingIcon;
    }

    @JsonProperty("oldHeadingIcon")
    public void setOldHeadingIcon(String oldHeadingIcon) {
        this.oldHeadingIcon = oldHeadingIcon;
    }

    @JsonProperty("tncText")
    public String getTncText() {
        return tncText;
    }

    @JsonProperty("tncText")
    public void setTncText(String tncText) {
        this.tncText = tncText;
    }

    @JsonProperty("poweredByIcon")
    public String getPoweredByIcon() {
        return poweredByIcon;
    }

    @JsonProperty("poweredByIcon")
    public void setPoweredByIcon(String poweredByIcon) {
        this.poweredByIcon = poweredByIcon;
    }

    @JsonProperty("planCoverageHeading")
    public String getPlanCoverageHeading() {
        return planCoverageHeading;
    }

    @JsonProperty("planCoverageHeading")
    public void setPlanCoverageHeading(String planCoverageHeading) {
        this.planCoverageHeading = planCoverageHeading;
    }

    @JsonProperty("shouldShowAutoApprove")
    public Boolean getShouldShowAutoApprove() {
        return shouldShowAutoApprove;
    }

    @JsonProperty("shouldShowAutoApprove")
    public void setShouldShowAutoApprove(Boolean shouldShowAutoApprove) {
        this.shouldShowAutoApprove = shouldShowAutoApprove;
    }

    @JsonProperty("autoApproveText")
    public String getAutoApproveText() {
        return autoApproveText;
    }

    @JsonProperty("autoApproveText")
    public void setAutoApproveText(String autoApproveText) {
        this.autoApproveText = autoApproveText;
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
