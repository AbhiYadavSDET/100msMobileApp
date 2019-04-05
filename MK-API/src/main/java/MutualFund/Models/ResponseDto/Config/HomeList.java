package MutualFund.Models.ResponseDto.Config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "viewType",
        "data",
        "title",
        "gridType"
})
public class HomeList {

    @JsonProperty("viewType")
    private String viewType;
    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("gridType")
    private String gridType;

    @JsonProperty("viewType")
    public String getViewType() {
        return viewType;
    }

    @JsonProperty("viewType")
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("gridType")
    public String getGridType() {
        return gridType;
    }

    @JsonProperty("gridType")
    public void setGridType(String gridType) {
        this.gridType = gridType;
    }

}
