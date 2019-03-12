package GiftCard.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "brand",
        "cardAmount",
        "couponDetails",
        "price",
        "scheduledDate",
        "supplier"
})
public class CardDetails {

    @JsonProperty("brand")
    private Brand brand;
    @JsonProperty("cardAmount")
    private Integer cardAmount;
    @JsonProperty("couponDetails")
    private CouponDetails couponDetails;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("scheduledDate")
    private Long scheduledDate;
    @JsonProperty("supplier")
    private String supplier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("brand")
    public Brand getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @JsonProperty("cardAmount")
    public Integer getCardAmount() {
        return cardAmount;
    }

    @JsonProperty("cardAmount")
    public void setCardAmount(Integer cardAmount) {
        this.cardAmount = cardAmount;
    }

    @JsonProperty("couponDetails")
    public CouponDetails getCouponDetails() {
        return couponDetails;
    }

    @JsonProperty("couponDetails")
    public void setCouponDetails(CouponDetails couponDetails) {
        this.couponDetails = couponDetails;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("scheduledDate")
    public Long getScheduledDate() {
        return scheduledDate;
    }

    @JsonProperty("scheduledDate")
    public void setScheduledDate(Long scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
