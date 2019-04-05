package MutualFund.Models.ResponseDto.FlexiSip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fundId",
        "fundName",
        "sip"
})
public class Data {

    @JsonProperty("fundId")
    private Object fundId;
    @JsonProperty("fundName")
    private Object fundName;
    @JsonProperty("sip")
    private Object sip;

    @JsonProperty("fundId")
    public Object getFundId() {
        return fundId;
    }

    @JsonProperty("fundId")
    public void setFundId(Object fundId) {
        this.fundId = fundId;
    }

    @JsonProperty("fundName")
    public Object getFundName() {
        return fundName;
    }

    @JsonProperty("fundName")
    public void setFundName(Object fundName) {
        this.fundName = fundName;
    }

    @JsonProperty("sip")
    public Object getSip() {
        return sip;
    }

    @JsonProperty("sip")
    public void setSip(Object sip) {
        this.sip = sip;
    }

}