package Bus.Models.ResponseDto.FetchCoupons;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "buspass_discount_percent",
        "title",
        "desc",
        "cta"
})
public class BuspassOffer {

    @JsonProperty("buspass_discount_percent")
    private Integer buspassDiscountPercent;
    @JsonProperty("title")
    private String title;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("cta")
    private String cta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("buspass_discount_percent")
    public Integer getBuspassDiscountPercent() {
        return buspassDiscountPercent;
    }

    @JsonProperty("buspass_discount_percent")
    public void setBuspassDiscountPercent(Integer buspassDiscountPercent) {
        this.buspassDiscountPercent = buspassDiscountPercent;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("cta")
    public String getCta() {
        return cta;
    }

    @JsonProperty("cta")
    public void setCta(String cta) {
        this.cta = cta;
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
