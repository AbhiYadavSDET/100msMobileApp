package Bus.Models.ResponseDto.BusAvailability;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "mobikoin_enable",
        "search_results",
        "is_buspass_user",
        "is_travel_agent",
        "filter_values"
})
public class Data {

    @JsonProperty("mobikoin_enable")
    private Boolean mobikoinEnable;
    @JsonProperty("search_results")
    private List<SearchResult> searchResults = null;
    @JsonProperty("is_buspass_user")
    private Boolean isBuspassUser;
    @JsonProperty("is_travel_agent")
    private Boolean isTravelAgent;
    @JsonProperty("filter_values")
    private FilterValues filterValues;

    @JsonProperty("mobikoin_enable")
    public Boolean getMobikoinEnable() {
        return mobikoinEnable;
    }

    @JsonProperty("mobikoin_enable")
    public void setMobikoinEnable(Boolean mobikoinEnable) {
        this.mobikoinEnable = mobikoinEnable;
    }

    @JsonProperty("search_results")
    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    @JsonProperty("search_results")
    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @JsonProperty("is_buspass_user")
    public Boolean getIsBuspassUser() {
        return isBuspassUser;
    }

    @JsonProperty("is_buspass_user")
    public void setIsBuspassUser(Boolean isBuspassUser) {
        this.isBuspassUser = isBuspassUser;
    }

    @JsonProperty("is_travel_agent")
    public Boolean getIsTravelAgent() {
        return isTravelAgent;
    }

    @JsonProperty("is_travel_agent")
    public void setIsTravelAgent(Boolean isTravelAgent) {
        this.isTravelAgent = isTravelAgent;
    }

    @JsonProperty("filter_values")
    public FilterValues getFilterValues() {
        return filterValues;
    }

    @JsonProperty("filter_values")
    public void setFilterValues(FilterValues filterValues) {
        this.filterValues = filterValues;
    }

}
