package Insurance.Models.responsedto.CrossSellTransaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "message",
        "data"
})
public class ApiResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private Message message;
    @JsonProperty("data")
    private Data_ data;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("message")
    public Message getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Message message) {
        this.message = message;
    }

    @JsonProperty("data")
    public Data_ getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data_ data) {
        this.data = data;
    }

}