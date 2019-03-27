package Bus.Models.RequestDto.Passengers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "baseFare",
        "board_point_id",
        "cell_no",
        "coupon_code",
        "doj",
        "drop_point_id",
        "emergency_contact_no",
        "is_return",
        "passengers",
        "schedule_id",
        "split_pay",
        "totalFare"
})
public class PassengersRequestDto {

    @JsonProperty("baseFare")
    private Integer baseFare;
    @JsonProperty("board_point_id")
    private Integer boardPointId;
    @JsonProperty("cell_no")
    private String cellNo;
    @JsonProperty("coupon_code")
    private String couponCode;
    @JsonProperty("doj")
    private String doj;
    @JsonProperty("drop_point_id")
    private Integer dropPointId;
    @JsonProperty("emergency_contact_no")
    private String emergencyContactNo;
    @JsonProperty("is_return")
    private Boolean isReturn;
    @JsonProperty("passengers")
    private List<Passenger> passengers = null;
    @JsonProperty("schedule_id")
    private Integer scheduleId;
    @JsonProperty("split_pay")
    private Boolean splitPay;
    @JsonProperty("totalFare")
    private Integer totalFare;

    @JsonProperty("baseFare")
    public Integer getBaseFare() {
        return baseFare;
    }

    @JsonProperty("baseFare")
    public void setBaseFare(Integer baseFare) {
        this.baseFare = baseFare;
    }

    @JsonProperty("board_point_id")
    public Integer getBoardPointId() {
        return boardPointId;
    }

    @JsonProperty("board_point_id")
    public void setBoardPointId(Integer boardPointId) {
        this.boardPointId = boardPointId;
    }

    @JsonProperty("cell_no")
    public String getCellNo() {
        return cellNo;
    }

    @JsonProperty("cell_no")
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    @JsonProperty("coupon_code")
    public String getCouponCode() {
        return couponCode;
    }

    @JsonProperty("coupon_code")
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @JsonProperty("doj")
    public String getDoj() {
        return doj;
    }

    @JsonProperty("doj")
    public void setDoj(String doj) {
        this.doj = doj;
    }

    @JsonProperty("drop_point_id")
    public Integer getDropPointId() {
        return dropPointId;
    }

    @JsonProperty("drop_point_id")
    public void setDropPointId(Integer dropPointId) {
        this.dropPointId = dropPointId;
    }

    @JsonProperty("emergency_contact_no")
    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    @JsonProperty("emergency_contact_no")
    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    @JsonProperty("is_return")
    public Boolean getIsReturn() {
        return isReturn;
    }

    @JsonProperty("is_return")
    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    @JsonProperty("passengers")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    @JsonProperty("passengers")
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @JsonProperty("schedule_id")
    public Integer getScheduleId() {
        return scheduleId;
    }

    @JsonProperty("schedule_id")
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @JsonProperty("split_pay")
    public Boolean getSplitPay() {
        return splitPay;
    }

    @JsonProperty("split_pay")
    public void setSplitPay(Boolean splitPay) {
        this.splitPay = splitPay;
    }

    @JsonProperty("totalFare")
    public Integer getTotalFare() {
        return totalFare;
    }

    @JsonProperty("totalFare")
    public void setTotalFare(Integer totalFare) {
        this.totalFare = totalFare;
    }

}
