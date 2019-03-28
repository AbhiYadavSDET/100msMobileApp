package MutualFund.Models.ResponseDto.Buy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "desc",
        "title",
        "subTitle",
        "displayValues"
})
public class Data {

    @JsonProperty("desc")
    private String desc;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subTitle")
    private String subTitle;
    @JsonProperty("displayValues")
    private List<DisplayValue> displayValues = null;

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subTitle")
    public String getSubTitle() {
        return subTitle;
    }

    @JsonProperty("subTitle")
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @JsonProperty("displayValues")
    public List<DisplayValue> getDisplayValues() {
        return displayValues;
    }

    @JsonProperty("displayValues")
    public void setDisplayValues(List<DisplayValue> displayValues) {
        this.displayValues = displayValues;
    }

}
