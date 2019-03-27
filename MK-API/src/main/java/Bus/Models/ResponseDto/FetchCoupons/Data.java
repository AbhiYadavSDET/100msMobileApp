package Bus.Models.ResponseDto.FetchCoupons;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "buspass_offers",
        "is_travel_agent",
        "coupons",
        "travel_agent_offers",
        "is_buspass_user",
        "manage_booking_meta_data"
})
public class Data {

    @JsonProperty("buspass_offers")
    private List<BuspassOffer> buspassOffers = null;
    @JsonProperty("is_travel_agent")
    private Boolean isTravelAgent;
    @JsonProperty("coupons")
    private List<Coupon> coupons = null;
    @JsonProperty("travel_agent_offers")
    private List<Object> travelAgentOffers = null;
    @JsonProperty("is_buspass_user")
    private Boolean isBuspassUser;
    @JsonProperty("manage_booking_meta_data")
    private ManageBookingMetaData manageBookingMetaData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("buspass_offers")
    public List<BuspassOffer> getBuspassOffers() {
        return buspassOffers;
    }

    @JsonProperty("buspass_offers")
    public void setBuspassOffers(List<BuspassOffer> buspassOffers) {
        this.buspassOffers = buspassOffers;
    }

    @JsonProperty("is_travel_agent")
    public Boolean getIsTravelAgent() {
        return isTravelAgent;
    }

    @JsonProperty("is_travel_agent")
    public void setIsTravelAgent(Boolean isTravelAgent) {
        this.isTravelAgent = isTravelAgent;
    }

    @JsonProperty("coupons")
    public List<Coupon> getCoupons() {
        return coupons;
    }

    @JsonProperty("coupons")
    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @JsonProperty("travel_agent_offers")
    public List<Object> getTravelAgentOffers() {
        return travelAgentOffers;
    }

    @JsonProperty("travel_agent_offers")
    public void setTravelAgentOffers(List<Object> travelAgentOffers) {
        this.travelAgentOffers = travelAgentOffers;
    }

    @JsonProperty("is_buspass_user")
    public Boolean getIsBuspassUser() {
        return isBuspassUser;
    }

    @JsonProperty("is_buspass_user")
    public void setIsBuspassUser(Boolean isBuspassUser) {
        this.isBuspassUser = isBuspassUser;
    }

    @JsonProperty("manage_booking_meta_data")
    public ManageBookingMetaData getManageBookingMetaData() {
        return manageBookingMetaData;
    }

    @JsonProperty("manage_booking_meta_data")
    public void setManageBookingMetaData(ManageBookingMetaData manageBookingMetaData) {
        this.manageBookingMetaData = manageBookingMetaData;
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
