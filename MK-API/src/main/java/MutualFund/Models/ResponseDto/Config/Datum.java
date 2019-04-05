package MutualFund.Models.ResponseDto.Config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "subTitle",
        "desc",
        "leftIcon",
        "deeplink",
        "topIcon"
})
public class Datum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subTitle")
    private String subTitle;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("leftIcon")
    private String leftIcon;
    @JsonProperty("deeplink")
    private String deeplink;
    @JsonProperty("topIcon")
    private String topIcon;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("leftIcon")
    public String getLeftIcon() {
        return leftIcon;
    }

    @JsonProperty("leftIcon")
    public void setLeftIcon(String leftIcon) {
        this.leftIcon = leftIcon;
    }

    @JsonProperty("deeplink")
    public String getDeeplink() {
        return deeplink;
    }

    @JsonProperty("deeplink")
    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    @JsonProperty("topIcon")
    public String getTopIcon() {
        return topIcon;
    }

    @JsonProperty("topIcon")
    public void setTopIcon(String topIcon) {
        this.topIcon = topIcon;
    }

}
