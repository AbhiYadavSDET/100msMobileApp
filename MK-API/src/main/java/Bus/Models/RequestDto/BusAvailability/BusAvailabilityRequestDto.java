package Bus.Models.RequestDto.BusAvailability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dest_id",
        "doj",
        "source_id"
})
public class BusAvailabilityRequestDto {

    @JsonProperty("dest_id")
    private String destId;
    @JsonProperty("doj")
    private String doj;
    @JsonProperty("source_id")
    private String sourceId;

    @JsonProperty("dest_id")
    public String getDestId() {
        return destId;
    }

    @JsonProperty("dest_id")
    public void setDestId(String destId) {
        this.destId = destId;
    }

    @JsonProperty("doj")
    public String getDoj() {
        return doj;
    }

    @JsonProperty("doj")
    public void setDoj(String doj) {
        this.doj = doj;
    }

    @JsonProperty("source_id")
    public String getSourceId() {
        return sourceId;
    }

    @JsonProperty("source_id")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

}
