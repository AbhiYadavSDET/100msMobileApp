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


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(teamListResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyListOfCategoriesSize(int size) {
        Log.info("VERIFY", "Number of teams");
        int noOfCategories = teamListResponseDto.getData().getTeams().size();
        MbkReporter.verifyEqualsWithLogging(noOfCategories, size, "Verify No Of teams", false);
        Log.info("VERIFIED", "Number of teams");

    }

}
