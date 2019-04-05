package Insurance.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "txns"
})
public class CrossSellTransactionDto {

    @JsonProperty("txns")
    private List<CrossSellTxn> txns = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("txns")
    public List<CrossSellTxn> getTxns() {
        return txns;
    }

    @JsonProperty("txns")
    public void setTxns(List<CrossSellTxn> txns) {
        this.txns = txns;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CrossSellTransactionDto{" +
                "txns=" + txns +
                ", additionalProperties=" + additionalProperties +
                '}';
    }


}
