package GiftCard.Models.requestdto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "giftedToSelf",
        "message",
        "name",
        "occasion",
        "phoneNumber"
})
public class ReceiverDetails {

    @JsonProperty("email")
    private String email;
    @JsonProperty("giftedToSelf")
    private Boolean giftedToSelf;
    @JsonProperty("message")
    private String message;
    @JsonProperty("name")
    private String name;
    @JsonProperty("occasion")
    private String occasion;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("giftedToSelf")
    public Boolean getGiftedToSelf() {
        return giftedToSelf;
    }

    @JsonProperty("giftedToSelf")
    public void setGiftedToSelf(Boolean giftedToSelf) {
        this.giftedToSelf = giftedToSelf;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("occasion")
    public String getOccasion() {
        return occasion;
    }

    @JsonProperty("occasion")
    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
