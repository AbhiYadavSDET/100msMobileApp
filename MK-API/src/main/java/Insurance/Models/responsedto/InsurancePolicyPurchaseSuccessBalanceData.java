package Insurance.Models.responsedto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "balance",
        "txnlockstatus",
        "wallet",
        "totalBalance",
        "totalMobiKash",
        "availableMobiKash",
        "txnPinModules",
        "extendSuperCash",
        "mobi_koin_balance"
})
public class InsurancePolicyPurchaseSuccessBalanceData {

    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("txnlockstatus")
    private Integer txnlockstatus;
    @JsonProperty("wallet")
    private List<InsurancePolicyPurchaseSuccessWallet> wallet = null;
    @JsonProperty("totalBalance")
    private Double totalBalance;
    @JsonProperty("totalMobiKash")
    private Double totalMobiKash;
    @JsonProperty("availableMobiKash")
    private Double availableMobiKash;
    @JsonProperty("txnPinModules")
    private List<String> txnPinModules = null;
    @JsonProperty("extendSuperCash")
    private Boolean extendSuperCash;
    @JsonProperty("mobi_koin_balance")
    private Double mobiKoinBalance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @JsonProperty("txnlockstatus")
    public Integer getTxnlockstatus() {
        return txnlockstatus;
    }

    @JsonProperty("txnlockstatus")
    public void setTxnlockstatus(Integer txnlockstatus) {
        this.txnlockstatus = txnlockstatus;
    }

    @JsonProperty("wallet")
    public List<InsurancePolicyPurchaseSuccessWallet> getWallet() {
        return wallet;
    }

    @JsonProperty("wallet")
    public void setWallet(List<InsurancePolicyPurchaseSuccessWallet> wallet) {
        this.wallet = wallet;
    }

    @JsonProperty("totalBalance")
    public Double getTotalBalance() {
        return totalBalance;
    }

    @JsonProperty("totalBalance")
    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    @JsonProperty("totalMobiKash")
    public Double getTotalMobiKash() {
        return totalMobiKash;
    }

    @JsonProperty("totalMobiKash")
    public void setTotalMobiKash(Double totalMobiKash) {
        this.totalMobiKash = totalMobiKash;
    }

    @JsonProperty("availableMobiKash")
    public Double getAvailableMobiKash() {
        return availableMobiKash;
    }

    @JsonProperty("availableMobiKash")
    public void setAvailableMobiKash(Double availableMobiKash) {
        this.availableMobiKash = availableMobiKash;
    }

    @JsonProperty("txnPinModules")
    public List<String> getTxnPinModules() {
        return txnPinModules;
    }

    @JsonProperty("txnPinModules")
    public void setTxnPinModules(List<String> txnPinModules) {
        this.txnPinModules = txnPinModules;
    }

    @JsonProperty("extendSuperCash")
    public Boolean getExtendSuperCash() {
        return extendSuperCash;
    }

    @JsonProperty("extendSuperCash")
    public void setExtendSuperCash(Boolean extendSuperCash) {
        this.extendSuperCash = extendSuperCash;
    }

    @JsonProperty("mobi_koin_balance")
    public Double getMobiKoinBalance() {
        return mobiKoinBalance;
    }

    @JsonProperty("mobi_koin_balance")
    public void setMobiKoinBalance(Double mobiKoinBalance) {
        this.mobiKoinBalance = mobiKoinBalance;
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

