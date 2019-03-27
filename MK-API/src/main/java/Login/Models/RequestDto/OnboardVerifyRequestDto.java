package Login.Models.RequestDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "av",
        "v",
        "otp",
        "cell",
        "deviceId"
})
public class OnboardVerifyRequestDto {

    @JsonProperty("av")
    private Integer av;
    @JsonProperty("v")
    private String v;
    @JsonProperty("otp")
    private String otp;
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("deviceId")
    private String deviceId;

    @JsonProperty("av")
    public Integer getAv() {
        return av;
    }

    @JsonProperty("av")
    public void setAv(Integer av) {
        this.av = av;
    }

    @JsonProperty("v")
    public String getV() {
        return v;
    }

    @JsonProperty("v")
    public void setV(String v) {
        this.v = v;
    }

    @JsonProperty("otp")
    public String getOtp() {
        return otp;
    }

    @JsonProperty("otp")
    public void setOtp(String otp) {
        this.otp = otp;
    }

    @JsonProperty("cell")
    public String getCell() {
        return cell;
    }

    @JsonProperty("cell")
    public void setCell(String cell) {
        this.cell = cell;
    }

    @JsonProperty("deviceId")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("deviceId")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}