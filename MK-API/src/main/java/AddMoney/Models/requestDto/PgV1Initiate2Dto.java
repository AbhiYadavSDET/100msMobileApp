package AddMoney.Models.requestDto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "amount",
        "memberId",
        "isSISetupFlow",
        "client",
        "deviceId",
        "payMode",
        "cardBanking"
})
public class PgV1Initiate2Dto {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("memberId")
    private String memberId;
    @JsonProperty("isSISetupFlow")
    private Boolean isSISetupFlow;
    @JsonProperty("client")
    private String client;
    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("payMode")
    private String payMode;
    @JsonProperty("cardBanking")
    private CardBanking cardBanking;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("memberId")
    public String getMemberId() {
        return memberId;
    }

    @JsonProperty("memberId")
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @JsonProperty("isSISetupFlow")
    public Boolean getIsSISetupFlow() {
        return isSISetupFlow;
    }

    @JsonProperty("isSISetupFlow")
    public void setIsSISetupFlow(Boolean isSISetupFlow) {
        this.isSISetupFlow = isSISetupFlow;
    }

    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    @JsonProperty("deviceId")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("deviceId")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @JsonProperty("payMode")
    public String getPayMode() {
        return payMode;
    }

    @JsonProperty("payMode")
    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    @JsonProperty("cardBanking")
    public CardBanking getCardBanking() {
        return cardBanking;
    }

    @JsonProperty("cardBanking")
    public void setCardBanking(CardBanking cardBanking) {
        this.cardBanking = cardBanking;
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
