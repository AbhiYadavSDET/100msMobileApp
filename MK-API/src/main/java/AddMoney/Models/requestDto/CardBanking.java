package AddMoney.Models.requestDto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cardCvv",
        "cardNumber",
        "cardExpiryMonth",
        "cardExpiryYear",
        "saveCard"
})
public class CardBanking {

    @JsonProperty("cardCvv")
    private String cardCvv;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("cardExpiryMonth")
    private String cardExpiryMonth;
    @JsonProperty("cardExpiryYear")
    private String cardExpiryYear;
    @JsonProperty("saveCard")
    private String saveCard;
    @JsonProperty("savedCardId")
    private String savedCardId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardCvv")
    public String getCardCvv() {
        return cardCvv;
    }

    @JsonProperty("cardCvv")
    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("cardExpiryMonth")
    public String getCardExpiryMonth() {
        return cardExpiryMonth;
    }

    @JsonProperty("cardExpiryMonth")
    public void setCardExpiryMonth(String cardExpiryMonth) {
        this.cardExpiryMonth = cardExpiryMonth;
    }

    @JsonProperty("cardExpiryYear")
    public String getCardExpiryYear() {
        return cardExpiryYear;
    }

    @JsonProperty("cardExpiryYear")
    public void setCardExpiryYear(String cardExpiryYear) {
        this.cardExpiryYear = cardExpiryYear;
    }

    @JsonProperty("saveCard")
    public String getSaveCard() {
        return saveCard;
    }

    @JsonProperty("saveCard")
    public void setSaveCard(String saveCard) {
        this.saveCard = saveCard;
    }

    @JsonProperty("savedCardId")
    public String getSavedCardId() {
        return savedCardId;
    }

    @JsonProperty("savedCardId")
    public void setSavedCardId(String savedCardId) {
        this.savedCardId = savedCardId;
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
