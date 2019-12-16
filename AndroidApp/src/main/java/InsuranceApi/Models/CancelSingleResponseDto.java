package InsuranceApi.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "data"
})

public class CancelSingleResponseDto {


    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("data")
    private Boolean data;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("data")
    public Boolean getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Boolean data) {
        this.data = data;
    }

}

