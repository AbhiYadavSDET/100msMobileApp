package Bus.Models.RequestDto.Passengers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "available",
        "fare",
        "isDisabledInFilter",
        "isSelected",
        "isSleeper",
        "reserved_for",
        "seat_no",
        "type"
})
public class SeatDetail {

    @JsonProperty("available")
    private Boolean available;
    @JsonProperty("fare")
    private Integer fare;
    @JsonProperty("isDisabledInFilter")
    private Boolean isDisabledInFilter;
    @JsonProperty("isSelected")
    private Boolean isSelected;
    @JsonProperty("isSleeper")
    private Boolean isSleeper;
    @JsonProperty("reserved_for")
    private String reservedFor;
    @JsonProperty("seat_no")
    private String seatNo;
    @JsonProperty("type")
    private String type;

    @JsonProperty("available")
    public Boolean getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @JsonProperty("fare")
    public Integer getFare() {
        return fare;
    }

    @JsonProperty("fare")
    public void setFare(Integer fare) {
        this.fare = fare;
    }

    @JsonProperty("isDisabledInFilter")
    public Boolean getIsDisabledInFilter() {
        return isDisabledInFilter;
    }

    @JsonProperty("isDisabledInFilter")
    public void setIsDisabledInFilter(Boolean isDisabledInFilter) {
        this.isDisabledInFilter = isDisabledInFilter;
    }

    @JsonProperty("isSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("isSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonProperty("isSleeper")
    public Boolean getIsSleeper() {
        return isSleeper;
    }

    @JsonProperty("isSleeper")
    public void setIsSleeper(Boolean isSleeper) {
        this.isSleeper = isSleeper;
    }

    @JsonProperty("reserved_for")
    public String getReservedFor() {
        return reservedFor;
    }

    @JsonProperty("reserved_for")
    public void setReservedFor(String reservedFor) {
        this.reservedFor = reservedFor;
    }

    @JsonProperty("seat_no")
    public String getSeatNo() {
        return seatNo;
    }

    @JsonProperty("seat_no")
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

}
