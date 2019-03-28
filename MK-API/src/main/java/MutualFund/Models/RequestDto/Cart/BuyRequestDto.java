package MutualFund.Models.RequestDto.Cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "paymentMode"
})
public class BuyRequestDto {

    @JsonProperty("paymentMode")
    private Integer paymentMode;

    @JsonProperty("paymentMode")
    public Integer getPaymentMode() {
        return paymentMode;
    }

    @JsonProperty("paymentMode")
    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "BuyRequestDto{" +
                "paymentMode=" + paymentMode +
                '}';
    }
}