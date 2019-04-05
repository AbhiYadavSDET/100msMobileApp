package MutualFund.Models.ResponseDto.Bank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "autoPayBank",
        "netBankingBank"
})
public class Data {

    @JsonProperty("autoPayBank")
    private AutoPayBank autoPayBank;
    @JsonProperty("netBankingBank")
    private NetBankingBank netBankingBank;

    @JsonProperty("autoPayBank")
    public AutoPayBank getAutoPayBank() {
        return autoPayBank;
    }

    @JsonProperty("autoPayBank")
    public void setAutoPayBank(AutoPayBank autoPayBank) {
        this.autoPayBank = autoPayBank;
    }

    @JsonProperty("netBankingBank")
    public NetBankingBank getNetBankingBank() {
        return netBankingBank;
    }

    @JsonProperty("netBankingBank")
    public void setNetBankingBank(NetBankingBank netBankingBank) {
        this.netBankingBank = netBankingBank;
    }

}