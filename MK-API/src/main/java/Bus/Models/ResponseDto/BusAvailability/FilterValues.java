package Bus.Models.ResponseDto.BusAvailability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "seat_types",
        "bus_types",
        "dep_types",
        "board_points",
        "drop_points",
        "operator_service_names",
        "fare_list"
})
public class FilterValues {

    @JsonProperty("seat_types")
    private List<Integer> seatTypes = null;
    @JsonProperty("bus_types")
    private List<String> busTypes = null;
    @JsonProperty("dep_types")
    private List<Integer> depTypes = null;
    @JsonProperty("board_points")
    private List<String> boardPoints = null;
    @JsonProperty("drop_points")
    private List<String> dropPoints = null;
    @JsonProperty("operator_service_names")
    private List<String> operatorServiceNames = null;
    @JsonProperty("fare_list")
    private List<Double> fareList = null;

    @JsonProperty("seat_types")
    public List<Integer> getSeatTypes() {
        return seatTypes;
    }

    @JsonProperty("seat_types")
    public void setSeatTypes(List<Integer> seatTypes) {
        this.seatTypes = seatTypes;
    }

    @JsonProperty("bus_types")
    public List<String> getBusTypes() {
        return busTypes;
    }

    @JsonProperty("bus_types")
    public void setBusTypes(List<String> busTypes) {
        this.busTypes = busTypes;
    }

    @JsonProperty("dep_types")
    public List<Integer> getDepTypes() {
        return depTypes;
    }

    @JsonProperty("dep_types")
    public void setDepTypes(List<Integer> depTypes) {
        this.depTypes = depTypes;
    }

    @JsonProperty("board_points")
    public List<String> getBoardPoints() {
        return boardPoints;
    }

    @JsonProperty("board_points")
    public void setBoardPoints(List<String> boardPoints) {
        this.boardPoints = boardPoints;
    }

    @JsonProperty("drop_points")
    public List<String> getDropPoints() {
        return dropPoints;
    }

    @JsonProperty("drop_points")
    public void setDropPoints(List<String> dropPoints) {
        this.dropPoints = dropPoints;
    }

    @JsonProperty("operator_service_names")
    public List<String> getOperatorServiceNames() {
        return operatorServiceNames;
    }

    @JsonProperty("operator_service_names")
    public void setOperatorServiceNames(List<String> operatorServiceNames) {
        this.operatorServiceNames = operatorServiceNames;
    }

    @JsonProperty("fare_list")
    public List<Double> getFareList() {
        return fareList;
    }

    @JsonProperty("fare_list")
    public void setFareList(List<Double> fareList) {
        this.fareList = fareList;
    }

}
