package Login.Models.ResponseDto.OtpCell;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "generalMessage",
        "registeredMobileNumber"
})
public class Data {
//test
    @JsonProperty("generalMessage")
    private String generalMessage;
    @JsonProperty("registeredMobileNumber")
    private Boolean registeredMobileNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("generalMessage")
    public String getGeneralMessage() {
        return generalMessage;
    }

    @JsonProperty("generalMessage")
    public void setGeneralMessage(String generalMessage) {
        this.generalMessage = generalMessage;
    }

    @JsonProperty("registeredMobileNumber")
    public Boolean getRegisteredMobileNumber() {
        return registeredMobileNumber;
    }

    @JsonProperty("registeredMobileNumber")
    public void setRegisteredMobileNumber(Boolean registeredMobileNumber) {
        this.registeredMobileNumber = registeredMobileNumber;
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
