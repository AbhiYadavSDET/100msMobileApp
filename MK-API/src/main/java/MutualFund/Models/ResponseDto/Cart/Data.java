package MutualFund.Models.ResponseDto.Cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "navDate"
})
public class Data {

    @JsonProperty("navDate")
    private String navDate;

    @JsonProperty("navDate")
    public String getNavDate() {
        return navDate;
    }

    @JsonProperty("navDate")
    public void setNavDate(String navDate) {
        this.navDate = navDate;
    }

}
