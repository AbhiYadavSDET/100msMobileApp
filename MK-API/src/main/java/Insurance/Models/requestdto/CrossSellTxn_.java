package Insurance.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "adParams",
        "amt",
        "cir",
        "cn",
        "crossSell",
        "dataConsent",
        "op",
        "special",
        "superCashOpted",
        "autoRenew",
        "insuranceId"
})
public class CrossSellTxn_ {

    @JsonProperty("adParams")
    private CrossSellAdParams adParams;
    @JsonProperty("amt")
    private String amt;
    @JsonProperty("cir")
    private String cir;
    @JsonProperty("cn")
    private String cn;
    @JsonProperty("crossSell")
    private Boolean crossSell;
    @JsonProperty("dataConsent")
    private Boolean dataConsent;
    @JsonProperty("op")
    private String op;
    @JsonProperty("special")
    private Boolean special;
    @JsonProperty("superCashOpted")
    private Boolean superCashOpted;
    @JsonProperty("autoRenew")
    private Boolean autoRenew;
    @JsonProperty("insuranceId")
    private String insuranceId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("adParams")
    public CrossSellAdParams getAdParams() {
        return adParams;
    }

    @JsonProperty("adParams")
    public void setAdParams(CrossSellAdParams adParams) {
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

    @JsonProperty("cir")
    public String getCir() {
        return cir;
    }

    @JsonProperty("cir")
    public void setCir(String cir) {
        this.cir = cir;
    }

    @JsonProperty("cn")
    public String getCn() {
        return cn;
    }

    @JsonProperty("cn")
    public void setCn(String cn) {
        this.cn = cn;
    }

    @JsonProperty("crossSell")
    public Boolean getCrossSell() {
        return crossSell;
    }

    @JsonProperty("crossSell")
    public void setCrossSell(Boolean crossSell) {
        this.crossSell = crossSell;
    }

    @JsonProperty("dataConsent")
    public Boolean getDataConsent() {
        return dataConsent;
    }

    @JsonProperty("dataConsent")
    public void setDataConsent(Boolean dataConsent) {
        this.dataConsent = dataConsent;
    }

    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    @JsonProperty("op")
    public void setOp(String op) {
        this.op = op;
    }

    @JsonProperty("special")
    public Boolean getSpecial() {
        return special;
    }

    @JsonProperty("special")
    public void setSpecial(Boolean special) {
        this.special = special;
    }

    @JsonProperty("superCashOpted")
    public Boolean getSuperCashOpted() {
        return superCashOpted;
    }

    @JsonProperty("superCashOpted")
    public void setSuperCashOpted(Boolean superCashOpted) {
        this.superCashOpted = superCashOpted;
    }

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
