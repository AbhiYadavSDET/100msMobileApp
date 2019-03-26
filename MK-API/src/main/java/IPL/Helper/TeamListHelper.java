package IPL.Helper;

import IPL.Models.ResponseDto.TeamList.TeamListResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class TeamListHelper {

    TeamListResponseDto teamListResponseDto;
    public ObjectMapper mapper;


    public TeamListHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            teamListResponseDto = mapper.readValue(jsonString, TeamListResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() throws IOException {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLoggingExtentReport(teamListResponseDto.getSuccess(), "Verify Success Response", "Response code = 200", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyListOfCategoriesSize(int size) throws IOException {
        Log.info("VERIFY", "Number of teams");
        int noOfCategories = teamListResponseDto.getData().getTeams().size();
        MbkReporter.verifyEqualsWithLoggingExtentReport(noOfCategories, size, "Verify No Of teams", false);
        Log.info("VERIFIED", "Number of teams");

    }

}
