package MutualFund.Models.ResponseDto.Config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "heading",
        "image",
        "title",
        "subtitle",
        "logo",
        "totalAmount",
        "monthlyAmount",
        "years",
        "riskId",
        "riskName",
        "investmentType"
})
public class Intro {

    @JsonProperty("heading")
    private Object heading;
    @JsonProperty("image")
    private String image;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("logo")
    private Object logo;
    @JsonProperty("totalAmount")
    private Object totalAmount;
    @JsonProperty("monthlyAmount")
    private Object monthlyAmount;
    @JsonProperty("years")
    private Object years;
    @JsonProperty("riskId")
    private Object riskId;
    @JsonProperty("riskName")
    private Object riskName;
    @JsonProperty("investmentType")
    private Object investmentType;

    @JsonProperty("heading")
    public Object getHeading() {
        return heading;
    }

    @JsonProperty("heading")
    public void setHeading(Object heading) {
        this.heading = heading;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("logo")
    public Object getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(Object logo) {
        this.logo = logo;
    }

    @JsonProperty("totalAmount")
    public Object getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("totalAmount")
    public void setTotalAmount(Object totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("monthlyAmount")
    public Object getMonthlyAmount() {
        return monthlyAmount;
    }

    @JsonProperty("monthlyAmount")
    public void setMonthlyAmount(Object monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    @JsonProperty("years")
    public Object getYears() {
        return years;
    }

    @JsonProperty("years")
    public void setYears(Object years) {
        this.years = years;
    }

    @JsonProperty("riskId")
    public Object getRiskId() {
        return riskId;
    }

    @JsonProperty("riskId")
    public void setRiskId(Object riskId) {
        this.riskId = riskId;
    }

    @JsonProperty("riskName")
    public Object getRiskName() {
        return riskName;
    }

    @JsonProperty("riskName")
    public void setRiskName(Object riskName) {
        this.riskName = riskName;
    }

    @JsonProperty("investmentType")
    public Object getInvestmentType() {
        return investmentType;
    }

    @JsonProperty("investmentType")
    public void setInvestmentType(Object investmentType) {
        this.investmentType = investmentType;
    }

}