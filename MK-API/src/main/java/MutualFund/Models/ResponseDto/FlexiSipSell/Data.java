package MutualFund.Models.ResponseDto.FlexiSipSell;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "folioId",
        "minimumSellAmount",
        "maximumSellAmount",
        "multipleOf",
        "maxInstantRedemptionAmount",
        "instantRedemptionErrorMessage",
        "description",
        "bank"
})
public class Data {

    @JsonProperty("folioId")
    private String folioId;
    @JsonProperty("minimumSellAmount")
    private Double minimumSellAmount;
    @JsonProperty("maximumSellAmount")
    private Double maximumSellAmount;
    @JsonProperty("multipleOf")
    private Double multipleOf;
    @JsonProperty("maxInstantRedemptionAmount")
    private Object maxInstantRedemptionAmount;
    @JsonProperty("instantRedemptionErrorMessage")
    private Object instantRedemptionErrorMessage;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("bank")
    private Object bank;

    @JsonProperty("folioId")
    public String getFolioId() {
        return folioId;
    }

    @JsonProperty("folioId")
    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    @JsonProperty("minimumSellAmount")
    public Double getMinimumSellAmount() {
        return minimumSellAmount;
    }

    @JsonProperty("minimumSellAmount")
    public void setMinimumSellAmount(Double minimumSellAmount) {
        this.minimumSellAmount = minimumSellAmount;
    }

    @JsonProperty("maximumSellAmount")
    public Double getMaximumSellAmount() {
        return maximumSellAmount;
    }

    @JsonProperty("maximumSellAmount")
    public void setMaximumSellAmount(Double maximumSellAmount) {
        this.maximumSellAmount = maximumSellAmount;
    }

    @JsonProperty("multipleOf")
    public Double getMultipleOf() {
        return multipleOf;
    }

    @JsonProperty("multipleOf")
    public void setMultipleOf(Double multipleOf) {
        this.multipleOf = multipleOf;
    }

    @JsonProperty("maxInstantRedemptionAmount")
    public Object getMaxInstantRedemptionAmount() {
        return maxInstantRedemptionAmount;
    }

    @JsonProperty("maxInstantRedemptionAmount")
    public void setMaxInstantRedemptionAmount(Object maxInstantRedemptionAmount) {
        this.maxInstantRedemptionAmount = maxInstantRedemptionAmount;
    }

    @JsonProperty("instantRedemptionErrorMessage")
    public Object getInstantRedemptionErrorMessage() {
        return instantRedemptionErrorMessage;
    }

    @JsonProperty("instantRedemptionErrorMessage")
    public void setInstantRedemptionErrorMessage(Object instantRedemptionErrorMessage) {
        this.instantRedemptionErrorMessage = instantRedemptionErrorMessage;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("bank")
    public Object getBank() {
        return bank;
    }

    @JsonProperty("bank")
    public void setBank(Object bank) {
        this.bank = bank;
    }

}
