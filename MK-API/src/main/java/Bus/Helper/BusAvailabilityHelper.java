package Bus.Helper;

import Bus.Models.ResponseDto.BusAvailability.BusAvailabilityResponseDto;
import Bus.Models.ResponseDto.BusAvailability.SearchResult;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class BusAvailabilityHelper {

    BusAvailabilityResponseDto busAvailabilityResponseDto;
    public ObjectMapper mapper;
    public static HashMap<String, Object> map = new HashMap<String, Object>();


    public BusAvailabilityHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            busAvailabilityResponseDto = mapper.readValue(jsonString, BusAvailabilityResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(busAvailabilityResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void setXMScope(String scopeId) {
        map.put("XMScope", scopeId);
    }

    public SearchResult searchForBus(String operatorName) {
        Log.info("SEARCH", "Bus");
        int size = busAvailabilityResponseDto.getData().getSearchResults().size();
        for (SearchResult e : busAvailabilityResponseDto.getData().getSearchResults()) {
            if (e.getOperatorServiceName().equalsIgnoreCase(operatorName)) {
                Log.info("Bus Found with Operator : " + operatorName);
                return e;
            }

        }
        Log.info("No Bus Found with Operator : " + operatorName);
        return busAvailabilityResponseDto.getData().getSearchResults().get(size - 1);

    }

    public void setScheduleId(SearchResult searchResult) {
        map.put("scheduleId", searchResult.getScheduleId());
    }

    public void verifyBusDetails(SearchResult searchResult, Integer gId, String operatorName, String busType, String depTime, String arrTime, String duration) {
        Log.info("VERIFY", "Search Bus Result");
        MbkReporter.verifyEqualsWithLogging(searchResult.getGid(), gId, "GID", false);
        MbkReporter.verifyEqualsWithLogging(searchResult.getOperatorServiceName(), operatorName, "GID", false);
        MbkReporter.verifyEqualsWithLogging(searchResult.getBusType(), busType, "GID", false);
        MbkReporter.verifyEqualsWithLogging(searchResult.getDepTime(), depTime, "GID", false);
        MbkReporter.verifyEqualsWithLogging(searchResult.getArrTime(), arrTime, "GID", false);
        MbkReporter.verifyEqualsWithLogging(searchResult.getDuration(), duration, "GID", false);
        Log.info("VERIFIED", "Search Bus Result");
    }

}
