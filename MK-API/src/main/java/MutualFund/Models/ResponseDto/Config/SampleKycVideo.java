package MutualFund.Models.ResponseDto.Config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "image",
        "videoUrl"
})
public class SampleKycVideo {

    @JsonProperty("title")
    private String title;
    @JsonProperty("image")
    private String image;
    @JsonProperty("videoUrl")
    private String videoUrl;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    @JsonProperty("videoUrl")
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}
