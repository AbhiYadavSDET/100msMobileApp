package MutualFund.Models.RequestDto.Cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "amount",
        "type",
        "months",
        "fundId"
})
public class CartRequestDto {

    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("type")
    private String type;
    @JsonProperty("months")
    private Integer months;
    @JsonProperty("fundId")
    private Integer fundId;

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("months")
    public Integer getMonths() {
        return months;
    }

    @JsonProperty("months")
    public void setMonths(Integer months) {
        this.months = months;
    }

    @JsonProperty("fundId")
    public Integer getFundId() {
        return fundId;
    }

    @JsonProperty("fundId")
    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

}
