package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sgId",
        "txnResponses",
        "balanceData",
        "request"
})
public class CrossSellTransactionResponseData {

    @JsonProperty("sgId")
    private String sgId;
    @JsonProperty("txnResponses")
    private List<TxnResponse> txnResponses = null;
    @JsonProperty("balanceData")
    private BalanceData balanceData;
    @JsonProperty("request")
    private Request request;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sgId")
    public String getSgId() {
        return sgId;
    }

    @JsonProperty("sgId")
    public void setSgId(String sgId) {
        this.sgId = sgId;
    }

    @JsonProperty("txnResponses")
    public List<TxnResponse> getTxnResponses() {
        return txnResponses;
    }

    @JsonProperty("txnResponses")
    public void setTxnResponses(List<TxnResponse> txnResponses) {
        this.txnResponses = txnResponses;
    }

    @JsonProperty("balanceData")
    public BalanceData getBalanceData() {
        return balanceData;
    }

    @JsonProperty("balanceData")
    public void setBalanceData(BalanceData balanceData) {
        this.balanceData = balanceData;
    }

    @JsonProperty("request")
    public Request getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(Request request) {
        this.request = request;
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
