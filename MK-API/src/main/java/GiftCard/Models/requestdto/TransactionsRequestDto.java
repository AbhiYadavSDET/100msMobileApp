package GiftCard.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cardDetails",
        "paymentDetails",
        "receiverDetails",
        "userDetails"
})
public class TransactionsRequestDto {

    @JsonProperty("cardDetails")
    private CardDetails cardDetails;
    @JsonProperty("paymentDetails")
    private PaymentDetails paymentDetails;
    @JsonProperty("receiverDetails")
    private ReceiverDetails receiverDetails;
    @JsonProperty("userDetails")
    private UserDetails userDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardDetails")
    public CardDetails getCardDetails() {
        return cardDetails;
    }

    @JsonProperty("cardDetails")
    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    @JsonProperty("paymentDetails")
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    @JsonProperty("paymentDetails")
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @JsonProperty("receiverDetails")
    public ReceiverDetails getReceiverDetails() {
        return receiverDetails;
    }

    @JsonProperty("receiverDetails")
    public void setReceiverDetails(ReceiverDetails receiverDetails) {
        this.receiverDetails = receiverDetails;
    }

    @JsonProperty("userDetails")
    public UserDetails getUserDetails() {
        return userDetails;
    }

    @JsonProperty("userDetails")
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
