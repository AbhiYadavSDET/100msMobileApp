package Bus.Models.RequestDto.Availability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "schedule_id"
})
public class AvailabilityRequestDto {

    @JsonProperty("schedule_id")
    private String scheduleId;

    @JsonProperty("schedule_id")
    public String getScheduleId() {
        return scheduleId;
    }

    @JsonProperty("schedule_id")
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

}
