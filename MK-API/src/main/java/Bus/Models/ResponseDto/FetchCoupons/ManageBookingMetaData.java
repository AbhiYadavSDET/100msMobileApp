package Bus.Models.ResponseDto.FetchCoupons;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "upcomingTrip",
        "no_upcoming_trips",
        "no_completed_trips"
})
public class ManageBookingMetaData {

    @JsonProperty("upcomingTrip")
    private Boolean upcomingTrip;
    @JsonProperty("no_upcoming_trips")
    private Integer noUpcomingTrips;
    @JsonProperty("no_completed_trips")
    private Integer noCompletedTrips;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("upcomingTrip")
    public Boolean getUpcomingTrip() {
        return upcomingTrip;
    }

    @JsonProperty("upcomingTrip")
    public void setUpcomingTrip(Boolean upcomingTrip) {
        this.upcomingTrip = upcomingTrip;
    }

    @JsonProperty("no_upcoming_trips")
    public Integer getNoUpcomingTrips() {
        return noUpcomingTrips;
    }

    @JsonProperty("no_upcoming_trips")
    public void setNoUpcomingTrips(Integer noUpcomingTrips) {
        this.noUpcomingTrips = noUpcomingTrips;
    }

    @JsonProperty("no_completed_trips")
    public Integer getNoCompletedTrips() {
        return noCompletedTrips;
    }

    @JsonProperty("no_completed_trips")
    public void setNoCompletedTrips(Integer noCompletedTrips) {
        this.noCompletedTrips = noCompletedTrips;
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
