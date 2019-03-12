package Insurance.Models.responsedto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "insuranceId",
        "price",
        "sumAssured",
        "tenureInMonths",
        "quoteParams",
        "headingIcon",
        "heading",
        "subHeading",
        "tag",
        "title",
        "subtitle"
})
public class VariableInsuranceDetail {

    @JsonProperty("insuranceId")
    private String insuranceId;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("sumAssured")
    private String sumAssured;
    @JsonProperty("tenureInMonths")
    private Integer tenureInMonths;
    @JsonProperty("quoteParams")
    private List<QuoteParam> quoteParams = null;
    @JsonProperty("headingIcon")
    private String headingIcon;
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("subHeading")
    private String subHeading;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("insuranceId")
    public String getInsuranceId() {
        return insuranceId;
    }

    @JsonProperty("insuranceId")
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("sumAssured")
    public String getSumAssured() {
        return sumAssured;
    }

    @JsonProperty("sumAssured")
    public void setSumAssured(String sumAssured) {
        this.sumAssured = sumAssured;
    }

    @JsonProperty("tenureInMonths")
    public Integer getTenureInMonths() {
        return tenureInMonths;
    }

    @JsonProperty("tenureInMonths")
    public void setTenureInMonths(Integer tenureInMonths) {
        this.tenureInMonths = tenureInMonths;
    }

    @JsonProperty("quoteParams")
    public List<QuoteParam> getQuoteParams() {
        return quoteParams;
    }

    @JsonProperty("quoteParams")
    public void setQuoteParams(List<QuoteParam> quoteParams) {
        this.quoteParams = quoteParams;
    }

    @JsonProperty("headingIcon")
    public String getHeadingIcon() {
        return headingIcon;
    }

    @JsonProperty("headingIcon")
    public void setHeadingIcon(String headingIcon) {
        this.headingIcon = headingIcon;
    }

    @JsonProperty("heading")
    public String getHeading() {
        return heading;
    }

    @JsonProperty("heading")
    public void setHeading(String heading) {
        this.heading = heading;
    }

    @JsonProperty("subHeading")
    public String getSubHeading() {
        return subHeading;
    }

    @JsonProperty("subHeading")
    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    @JsonProperty("tag")
    public String getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(String tag) {
        this.tag = tag;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

