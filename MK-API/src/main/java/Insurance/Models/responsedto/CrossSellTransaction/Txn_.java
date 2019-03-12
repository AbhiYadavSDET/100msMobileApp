package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "autoRenew",
        "insuranceId",
        "sgId",
        "crossSell",
        "special",
        "op",
        "adParams",
        "amt",
        "cn",
        "superCashOpted",
        "cir",
        "dataConsent"
})
public class Txn_ {

    @JsonProperty("autoRenew")
    private Boolean autoRenew;
    @JsonProperty("insuranceId")
    private String insuranceId;
    @JsonProperty("sgId")
    private String sgId;
    @JsonProperty("crossSell")
    private Boolean crossSell;
    @JsonProperty("special")
    private Boolean special;
    @JsonProperty("op")
    private String op;
    @JsonProperty("adParams")
    private AdParams adParams;
    @JsonProperty("amt")
    private String amt;
    @JsonProperty("cn")
    private String cn;
    @JsonProperty("superCashOpted")
    private Boolean superCashOpted;
    @JsonProperty("cir")
    private String cir;
    @JsonProperty("dataConsent")
    private Boolean dataConsent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("autoRenew")
    public Boolean getAutoRenew() {
        return autoRenew;
    }

    @JsonProperty("autoRenew")
    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

    @JsonProperty("insuranceId")
    public String getInsuranceId() {
        return insuranceId;
    }

    @JsonProperty("insuranceId")
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    @JsonProperty("sgId")
    public String getSgId() {
        return sgId;
    }

    @JsonProperty("sgId")
    public void setSgId(String sgId) {
        this.sgId = sgId;
    }

    @JsonProperty("crossSell")
    public Boolean getCrossSell() {
        return crossSell;
    }

    @JsonProperty("crossSell")
    public void setCrossSell(Boolean crossSell) {
        this.crossSell = crossSell;
    }

    @JsonProperty("special")
    public Boolean getSpecial() {
        return special;
    }

    @JsonProperty("special")
    public void setSpecial(Boolean special) {
        this.special = special;
    }

    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    @JsonProperty("op")
    public void setOp(String op) {
        this.op = op;
    }

    @JsonProperty("adParams")
    public AdParams getAdParams() {
        return adParams;
    }

    @JsonProperty("adParams")
    public void setAdParams(AdParams adParams) {
        this.adParams = adParams;
    }

    @JsonProperty("amt")
    public String getAmt() {
        return amt;
    }

    @JsonProperty("amt")
    public void setAmt(String amt) {
        this.amt = amt;
    }

    @JsonProperty("cn")
    public String getCn() {
        return cn;
    }

    @JsonProperty("cn")
    public void setCn(String cn) {
        this.cn = cn;
    }

    @JsonProperty("superCashOpted")
    public Boolean getSuperCashOpted() {
        return superCashOpted;
    }

    @JsonProperty("superCashOpted")
    public void setSuperCashOpted(Boolean superCashOpted) {
        this.superCashOpted = superCashOpted;
    }

    @JsonProperty("cir")
    public String getCir() {
        return cir;
    }

    @JsonProperty("cir")
    public void setCir(String cir) {
        this.cir = cir;
    }

    @JsonProperty("dataConsent")
    public Boolean getDataConsent() {
        return dataConsent;
    }

    @JsonProperty("dataConsent")
    public void setDataConsent(Boolean dataConsent) {
        this.dataConsent = dataConsent;
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
