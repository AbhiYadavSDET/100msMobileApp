package MutualFund.Models.ResponseDto.RecommendationFunds;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "logo",
        "variation",
        "subCategory",
        "starRating",
        "riskType",
        "fundId",
        "recommended",
        "withdrawType",
        "pastPerformance"
})
public class Datum {

    @JsonProperty("name")
    private String name;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("variation")
    private String variation;
    @JsonProperty("subCategory")
    private String subCategory;
    @JsonProperty("starRating")
    private Double starRating;
    @JsonProperty("riskType")
    private String riskType;
    @JsonProperty("fundId")
    private Integer fundId;
    @JsonProperty("recommended")
    private Boolean recommended;
    @JsonProperty("withdrawType")
    private String withdrawType;
    @JsonProperty("pastPerformance")
    private List<PastPerformance> pastPerformance = null;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("variation")
    public String getVariation() {
        return variation;
    }

    @JsonProperty("variation")
    public void setVariation(String variation) {
        this.variation = variation;
    }

    @JsonProperty("subCategory")
    public String getSubCategory() {
        return subCategory;
    }

    @JsonProperty("subCategory")
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @JsonProperty("starRating")
    public Double getStarRating() {
        return starRating;
    }

    @JsonProperty("starRating")
    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    @JsonProperty("riskType")
    public String getRiskType() {
        return riskType;
    }

    @JsonProperty("riskType")
    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    @JsonProperty("fundId")
    public Integer getFundId() {
        return fundId;
    }

    @JsonProperty("fundId")
    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    @JsonProperty("recommended")
    public Boolean getRecommended() {
        return recommended;
    }

    @JsonProperty("recommended")
    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    @JsonProperty("withdrawType")
    public String getWithdrawType() {
        return withdrawType;
    }

    @JsonProperty("withdrawType")
    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType;
    }

    @JsonProperty("pastPerformance")
    public List<PastPerformance> getPastPerformance() {
        return pastPerformance;
    }

    @JsonProperty("pastPerformance")
    public void setPastPerformance(List<PastPerformance> pastPerformance) {
        this.pastPerformance = pastPerformance;
    }

}
