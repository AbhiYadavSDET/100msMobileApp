package Bus.Models.ResponseDto.CanCancel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "can_cancel",
        "convenience_charges",
        "refund_amount",
        "cancellation_charges"
})
public class Data {

    @JsonProperty("can_cancel")
    private Boolean canCancel;
    @JsonProperty("convenience_charges")
    private Double convenienceCharges;
    @JsonProperty("refund_amount")
    private Double refundAmount;
    @JsonProperty("cancellation_charges")
    private Double cancellationCharges;

    @JsonProperty("can_cancel")
    public Boolean getCanCancel() {
        return canCancel;
    }

    @JsonProperty("can_cancel")
    public void setCanCancel(Boolean canCancel) {
        this.canCancel = canCancel;
    }

    @JsonProperty("convenience_charges")
    public Double getConvenienceCharges() {
        return convenienceCharges;
    }

    @JsonProperty("convenience_charges")
    public void setConvenienceCharges(Double convenienceCharges) {
        this.convenienceCharges = convenienceCharges;
    }

    @JsonProperty("refund_amount")
    public Double getRefundAmount() {
        return refundAmount;
    }

    @JsonProperty("refund_amount")
    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    @JsonProperty("cancellation_charges")
    public Double getCancellationCharges() {
        return cancellationCharges;
    }

    @JsonProperty("cancellation_charges")
    public void setCancellationCharges(Double cancellationCharges) {
        this.cancellationCharges = cancellationCharges;
    }

}
