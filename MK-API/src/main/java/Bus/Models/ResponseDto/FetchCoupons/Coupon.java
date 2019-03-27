package Bus.Models.ResponseDto.FetchCoupons;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "couponCode1",
        "couponCode2",
        "coupon_info",
        "list_benefit",
        "min_txn_amount",
        "percentage_cashback",
        "max_cashback_applicable",
        "is_percent_cashback"
})
public class Coupon {

    @JsonProperty("couponCode")
    private String couponCode1;
    @JsonProperty("coupon_code")
    private String couponCode2;
    @JsonProperty("coupon_info")
    private String couponInfo;
    @JsonProperty("list_benefit")
    private List<ListBenefit> listBenefit = null;
    @JsonProperty("min_txn_amount")
    private Double minTxnAmount;
    @JsonProperty("percentage_cashback")
    private Double percentageCashback;
    @JsonProperty("max_cashback_applicable")
    private Double maxCashbackApplicable;
    @JsonProperty("is_percent_cashback")
    private Boolean isPercentCashback;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("couponCode")
    public String getCouponCode1() {
        return couponCode1;
    }

    @JsonProperty("couponCode")
    public void setCouponCode1(String couponCode1) {
        this.couponCode1 = couponCode1;
    }

    @JsonProperty("coupon_code")
    public String getCouponCode2() {
        return couponCode2;
    }

    @JsonProperty("coupon_code")
    public void setCouponCode2(String couponCode2) {
        this.couponCode2 = couponCode2;
    }

    @JsonProperty("coupon_info")
    public String getCouponInfo() {
        return couponInfo;
    }

    @JsonProperty("coupon_info")
    public void setCouponInfo(String couponInfo) {
        this.couponInfo = couponInfo;
    }

    @JsonProperty("list_benefit")
    public List<ListBenefit> getListBenefit() {
        return listBenefit;
    }

    @JsonProperty("list_benefit")
    public void setListBenefit(List<ListBenefit> listBenefit) {
        this.listBenefit = listBenefit;
    }

    @JsonProperty("min_txn_amount")
    public Double getMinTxnAmount() {
        return minTxnAmount;
    }

    @JsonProperty("min_txn_amount")
    public void setMinTxnAmount(Double minTxnAmount) {
        this.minTxnAmount = minTxnAmount;
    }

    @JsonProperty("percentage_cashback")
    public Double getPercentageCashback() {
        return percentageCashback;
    }

    @JsonProperty("percentage_cashback")
    public void setPercentageCashback(Double percentageCashback) {
        this.percentageCashback = percentageCashback;
    }

    @JsonProperty("max_cashback_applicable")
    public Double getMaxCashbackApplicable() {
        return maxCashbackApplicable;
    }

    @JsonProperty("max_cashback_applicable")
    public void setMaxCashbackApplicable(Double maxCashbackApplicable) {
        this.maxCashbackApplicable = maxCashbackApplicable;
    }

    @JsonProperty("is_percent_cashback")
    public Boolean getIsPercentCashback() {
        return isPercentCashback;
    }

    @JsonProperty("is_percent_cashback")
    public void setIsPercentCashback(Boolean isPercentCashback) {
        this.isPercentCashback = isPercentCashback;
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
