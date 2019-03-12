package Insurance.Models.responsedto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bannerCardDetails",
        "insuranceThumbnailDetails",
        "buyNewInsuranceHeading",
        "payPremiumDetails"
})
public class Data {

    @JsonProperty("bannerCardDetails")
    private List<BannerCardDetail> bannerCardDetails = null;
    @JsonProperty("insuranceThumbnailDetails")
    private List<InsuranceThumbnailDetail> insuranceThumbnailDetails = null;
    @JsonProperty("buyNewInsuranceHeading")
    private String buyNewInsuranceHeading;
    @JsonProperty("payPremiumDetails")
    private PayPremiumDetails payPremiumDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bannerCardDetails")
    public List<BannerCardDetail> getBannerCardDetails() {
        return bannerCardDetails;
    }

    @JsonProperty("bannerCardDetails")
    public void setBannerCardDetails(List<BannerCardDetail> bannerCardDetails) {
        this.bannerCardDetails = bannerCardDetails;
    }

    @JsonProperty("insuranceThumbnailDetails")
    public List<InsuranceThumbnailDetail> getInsuranceThumbnailDetails() {
        return insuranceThumbnailDetails;
    }

    @JsonProperty("insuranceThumbnailDetails")
    public void setInsuranceThumbnailDetails(List<InsuranceThumbnailDetail> insuranceThumbnailDetails) {
        this.insuranceThumbnailDetails = insuranceThumbnailDetails;
    }

    @JsonProperty("buyNewInsuranceHeading")
    public String getBuyNewInsuranceHeading() {
        return buyNewInsuranceHeading;
    }

    @JsonProperty("buyNewInsuranceHeading")
    public void setBuyNewInsuranceHeading(String buyNewInsuranceHeading) {
        this.buyNewInsuranceHeading = buyNewInsuranceHeading;
    }

    @JsonProperty("payPremiumDetails")
    public PayPremiumDetails getPayPremiumDetails() {
        return payPremiumDetails;
    }

    @JsonProperty("payPremiumDetails")
    public void setPayPremiumDetails(PayPremiumDetails payPremiumDetails) {
        this.payPremiumDetails = payPremiumDetails;
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