package MutualFund;

import MutualFund.Api.*;
import MutualFund.Helper.*;
import MutualFund.Models.RequestDto.Cart.BuyRequestDto;
import MutualFund.Models.RequestDto.Cart.CartRequestDto;
import Utils.DatabaseSqlHelper;
import Utils.Log;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class MutualFundTest {


    Response response;
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @BeforeClass(alwaysRun = true)
    public void BeforeClass() {
        databaseSqlHelper.initiateMemberBalance();
    }


    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) {
        Log.info("****************:" + method.getName() + "****************");
    }


    // Constants


    @Test(groups = "mutualFundSanity", priority = 1)
    public void Test01_verify_config_api() {
        int count = 0;

        Config config = new Config();
        response = config.execute();

        System.out.println(response.getBody().asString());


        //Status code validator
        StatusCodeValidator.validate200(response);

        //Assertions
        ConfigHelper configHelper = new ConfigHelper(response.getBody().asString());
        configHelper.verifySuccessResponse();
        configHelper.verifyData(true, false, true, true, true, 1);


    }

    @Test(groups = "mutualFundSanity", priority = 2)
    public void Test02_verify_recommendation_funds() {
        int count = 0;

        RecommendationFunds recommendationFunds = new RecommendationFunds("1000", "1", "2", "0", "0", "0");
        response = recommendationFunds.execute();

        System.out.println(response.getBody().asString());


        //Status code validator
        StatusCodeValidator.validate200(response);

        //Assertions
        RecommendationFundsHelper recommendationFundsHelper = new RecommendationFundsHelper(response.getBody().asString());
        recommendationFundsHelper.verifySuccessResponse();
        recommendationFundsHelper.verifyData(3);

    }

    @Test(groups = "mutualFundSanity", priority = 3)
    public void Test03_verify_recommendation_funds() {
        int count = 0;

        Bank bank = new Bank("1");
        response = bank.execute();

        System.out.println(response.getBody().asString());


        //Status code validator
        StatusCodeValidator.validate200(response);

        //Assertions
        BankHelper bankHelper = new BankHelper(response.getBody().asString());
        bankHelper.verifySuccessResponse();
        bankHelper.verifyAutoPayBank("NAVNEET PANDEY", "035701533723", "ICIC0000357", "ICICI BANK LIMITED", null, true);
        bankHelper.verifyNetBankingBank("NAVNEET PANDEY", "035701533723", "ICIC0000357", "ICICI BANK LIMITED", null, true);


    }

    @Test(groups = "mutualFundSanity", priority = 4)
    public void Test04_verify_cart() {
        int count = 0;


        CartRequestDto cartRequestDto = new CartRequestDto();
        cartRequestDto.setAmount(1000);
        cartRequestDto.setType("1");
        cartRequestDto.setMonths(0);
        cartRequestDto.setFundId(11324);

        Cart cart = new Cart(cartRequestDto);
        response = cart.execute();

        System.out.println(response.getBody().asString());


        //Status code validator
        StatusCodeValidator.validate200(response);

        //Assertions
        CartHelper cartHelper = new CartHelper(response.getBody().asString());
        cartHelper.verifySuccessResponse();
        cartHelper.verifyNavDate(1);


    }

    @Test(groups = "mutualFundSanity", priority = 5)
    public void Test05_buy_mf() {
        int count = 0;

        BuyRequestDto buyRequestDto = new BuyRequestDto();
        buyRequestDto.setPaymentMode(0);

        Buy buy = new Buy(buyRequestDto);
        response = buy.execute();

        System.out.println(response.getBody().asString());


        //Status code validator
        StatusCodeValidator.validate200(response);

        //Assertions
        BuyHelper buyHelper = new BuyHelper(response.getBody().asString());
        buyHelper.verifySuccessResponse();
        buyHelper.verifyDetails("You have placed a purchase order for Aditya BSL Regular Sav Dir Gr fund on 27 Mar 2019. It will appear in your holdings instantly.", "Lumpsum Order Received", "Aditya BSL Regular Sav Dir Gr");
        buyHelper.verifyDisplayValues("₹ 1,000", 1);


    }


}
