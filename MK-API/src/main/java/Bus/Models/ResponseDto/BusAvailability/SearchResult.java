package Bus.Models.ResponseDto.BusAvailability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "zeroCancellationTime",
        "exclusive_amenities",
        "schedule_id",
        "liveTrackingAvailable",
        "operator_service_name",
        "bus_type",
        "dep_time",
        "_gid",
        "arr_time",
        "duration",
        "available_seat_count",
        "is_cancellable",
        "rating",
        "amenities",
        "fares",
        "effective_fare",
        "base_fare",
        "discount",
        "board_points",
        "drop_points",
        "is_ac",
        "seat_type",
        "dep_type",
        "partial_booking",
        "split_pay",
        "score",
        "score_key",
        "num_of_ratings",
        "max_seat_per_ticket",
        "bpDpSeatLayout",
        "exclusive_amenities_with_id"
})
public class SearchResult {

    @JsonProperty("zeroCancellationTime")
    private Integer zeroCancellationTime;
    @JsonProperty("exclusive_amenities")
    private List<Object> exclusiveAmenities = null;
    @JsonProperty("schedule_id")
    private Integer scheduleId;
    @JsonProperty("liveTrackingAvailable")
    private Boolean liveTrackingAvailable;
    @JsonProperty("operator_service_name")
    private String operatorServiceName;
    @JsonProperty("bus_type")
    private String busType;
    @JsonProperty("dep_time")
    private String depTime;
    @JsonProperty("_gid")
    private Integer gid;
    @JsonProperty("arr_time")
    private String arrTime;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("available_seat_count")
    private Integer availableSeatCount;
    @JsonProperty("is_cancellable")
    private Boolean isCancellable;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("amenities")
    private List<Object> amenities = null;
    @JsonProperty("fares")
    private List<Double> fares = null;
    @JsonProperty("effective_fare")
    private Integer effectiveFare;
    @JsonProperty("base_fare")
    private Double baseFare;
    @JsonProperty("discount")
    private Double discount;
    @JsonProperty("board_points")
    private List<BoardPoint> boardPoints = null;
    @JsonProperty("drop_points")
    private List<DropPoint> dropPoints = null;
    @JsonProperty("is_ac")
    private Boolean isAc;
    @JsonProperty("seat_type")
    private List<Integer> seatType = null;
    @JsonProperty("dep_type")
    private Integer depType;
    @JsonProperty("partial_booking")
    private Boolean partialBooking;
    @JsonProperty("split_pay")
    private Boolean splitPay;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("score_key")
    private String scoreKey;
    @JsonProperty("num_of_ratings")
    private Integer numOfRatings;
    @JsonProperty("max_seat_per_ticket")
    private Integer maxSeatPerTicket;
    @JsonProperty("bpDpSeatLayout")
    private Boolean bpDpSeatLayout;
    @JsonProperty("exclusive_amenities_with_id")
    private List<Object> exclusiveAmenitiesWithId = null;

    @JsonProperty("zeroCancellationTime")
    public Integer getZeroCancellationTime() {
        return zeroCancellationTime;
    }

    @JsonProperty("zeroCancellationTime")
    public void setZeroCancellationTime(Integer zeroCancellationTime) {
        this.zeroCancellationTime = zeroCancellationTime;
    }

    @JsonProperty("exclusive_amenities")
    public List<Object> getExclusiveAmenities() {
        return exclusiveAmenities;
    }

    @JsonProperty("exclusive_amenities")
    public void setExclusiveAmenities(List<Object> exclusiveAmenities) {
        this.exclusiveAmenities = exclusiveAmenities;
    }

    @JsonProperty("schedule_id")
    public Integer getScheduleId() {
        return scheduleId;
    }

    @JsonProperty("schedule_id")
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @JsonProperty("liveTrackingAvailable")
    public Boolean getLiveTrackingAvailable() {
        return liveTrackingAvailable;
    }

    @JsonProperty("liveTrackingAvailable")
    public void setLiveTrackingAvailable(Boolean liveTrackingAvailable) {
        this.liveTrackingAvailable = liveTrackingAvailable;
    }

    @JsonProperty("operator_service_name")
    public String getOperatorServiceName() {
        return operatorServiceName;
    }

    @JsonProperty("operator_service_name")
    public void setOperatorServiceName(String operatorServiceName) {
        this.operatorServiceName = operatorServiceName;
    }

    @JsonProperty("bus_type")
    public String getBusType() {
        return busType;
    }

    @JsonProperty("bus_type")
    public void setBusType(String busType) {
        this.busType = busType;
    }

    @JsonProperty("dep_time")
    public String getDepTime() {
        return depTime;
    }

    @JsonProperty("dep_time")
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    @JsonProperty("_gid")
    public Integer getGid() {
        return gid;
    }

    @JsonProperty("_gid")
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @JsonProperty("arr_time")
    public String getArrTime() {
        return arrTime;
    }

    @JsonProperty("arr_time")
    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("available_seat_count")
    public Integer getAvailableSeatCount() {
        return availableSeatCount;
    }

    @JsonProperty("available_seat_count")
    public void setAvailableSeatCount(Integer availableSeatCount) {
        this.availableSeatCount = availableSeatCount;
    }

    @JsonProperty("is_cancellable")
    public Boolean getIsCancellable() {
        return isCancellable;
    }

    @JsonProperty("is_cancellable")
    public void setIsCancellable(Boolean isCancellable) {
        this.isCancellable = isCancellable;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("amenities")
    public List<Object> getAmenities() {
        return amenities;
    }

    @JsonProperty("amenities")
    public void setAmenities(List<Object> amenities) {
        this.amenities = amenities;
    }

    @JsonProperty("fares")
    public List<Double> getFares() {
        return fares;
    }

    @JsonProperty("fares")
    public void setFares(List<Double> fares) {
        this.fares = fares;
    }

    @JsonProperty("effective_fare")
    public Integer getEffectiveFare() {
        return effectiveFare;
    }

    @JsonProperty("effective_fare")
    public void setEffectiveFare(Integer effectiveFare) {
        this.effectiveFare = effectiveFare;
    }

    @JsonProperty("base_fare")
    public Double getBaseFare() {
        return baseFare;
    }

    @JsonProperty("base_fare")
    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    @JsonProperty("discount")
    public Double getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @JsonProperty("board_points")
    public List<BoardPoint> getBoardPoints() {
        return boardPoints;
    }

    @JsonProperty("board_points")
    public void setBoardPoints(List<BoardPoint> boardPoints) {
        this.boardPoints = boardPoints;
    }

    @JsonProperty("drop_points")
    public List<DropPoint> getDropPoints() {
        return dropPoints;
    }

    @JsonProperty("drop_points")
    public void setDropPoints(List<DropPoint> dropPoints) {
        this.dropPoints = dropPoints;
    }

    @JsonProperty("is_ac")
    public Boolean getIsAc() {
        return isAc;
    }

    @JsonProperty("is_ac")
    public void setIsAc(Boolean isAc) {
        this.isAc = isAc;
    }

    @JsonProperty("seat_type")
    public List<Integer> getSeatType() {
        return seatType;
    }

    @JsonProperty("seat_type")
    public void setSeatType(List<Integer> seatType) {
        this.seatType = seatType;
    }

    @JsonProperty("dep_type")
    public Integer getDepType() {
        return depType;
    }

    @JsonProperty("dep_type")
    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    @JsonProperty("partial_booking")
    public Boolean getPartialBooking() {
        return partialBooking;
    }

    @JsonProperty("partial_booking")
    public void setPartialBooking(Boolean partialBooking) {
        this.partialBooking = partialBooking;
    }

    @JsonProperty("split_pay")
    public Boolean getSplitPay() {
        return splitPay;
    }

    @JsonProperty("split_pay")
    public void setSplitPay(Boolean splitPay) {
        this.splitPay = splitPay;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonProperty("score_key")
    public String getScoreKey() {
        return scoreKey;
    }

    @JsonProperty("score_key")
    public void setScoreKey(String scoreKey) {
        this.scoreKey = scoreKey;
    }

    @JsonProperty("num_of_ratings")
    public Integer getNumOfRatings() {
        return numOfRatings;
    }

    @JsonProperty("num_of_ratings")
    public void setNumOfRatings(Integer numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    @JsonProperty("max_seat_per_ticket")
    public Integer getMaxSeatPerTicket() {
        return maxSeatPerTicket;
    }

    @JsonProperty("max_seat_per_ticket")
    public void setMaxSeatPerTicket(Integer maxSeatPerTicket) {
        this.maxSeatPerTicket = maxSeatPerTicket;
    }

    @JsonProperty("bpDpSeatLayout")
    public Boolean getBpDpSeatLayout() {
        return bpDpSeatLayout;
    }

    @JsonProperty("bpDpSeatLayout")
    public void setBpDpSeatLayout(Boolean bpDpSeatLayout) {
        this.bpDpSeatLayout = bpDpSeatLayout;
    }

    @JsonProperty("exclusive_amenities_with_id")
    public List<Object> getExclusiveAmenitiesWithId() {
        return exclusiveAmenitiesWithId;
    }

    @JsonProperty("exclusive_amenities_with_id")
    public void setExclusiveAmenitiesWithId(List<Object> exclusiveAmenitiesWithId) {
        this.exclusiveAmenitiesWithId = exclusiveAmenitiesWithId;
    }

}