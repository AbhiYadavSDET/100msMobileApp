package GiftCard.Helper;

import GiftCard.Models.responsedto.Categories.CategoriesResponseDto;
import Utils.Log;
import Utils.MbkReporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CategoriesHelper {

    CategoriesResponseDto categoriesResponseDto;
    public ObjectMapper mapper;


    public CategoriesHelper(String jsonString) {
        mapper = new ObjectMapper();
        try {
            categoriesResponseDto = mapper.readValue(jsonString, CategoriesResponseDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void verifySuccessResponse() {
        Log.info("VERIFY", "Success Response");
        MbkReporter.verifyTrueWithLogging(categoriesResponseDto.getSuccess(), "Verify Success Response", false);
        Log.info("VERIFIED", "Success Response");
    }

    public void verifyListOfCategoriesSize(int size) {
        Log.info("VERIFY", "Number of categories");
        int noOfCategories = categoriesResponseDto.getData().getList().size();
        MbkReporter.verifyEqualsWithLogging(noOfCategories, size, "Verify No Of categories", false);
        Log.info("VERIFIED", "Number of categories");

    }

}
