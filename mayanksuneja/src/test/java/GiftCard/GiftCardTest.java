package GiftCard;

import GiftCard.Api.Categories;
import GiftCard.Api.Transactions;
import GiftCard.Helper.CategoriesHelper;
import GiftCard.Models.requestdto.*;
import Insurance.Helper.InsuranceDetailsV2Helper;
import Utils.DatabaseSqlHelper;
import Utils.Log;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class GiftCardTest {


    Response response;
    InsuranceDetailsV2Helper insuranceDetailsV2Helper;
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
    String memberId = "9953138474@nocash.mobikwik.com";
    String auth = "hoZWfVYS0oB1WrKJ7bbHQw==.vr8gqok0ko0at03mv0aepl2re1";
    String xMClient = "3";
    String deviceId = "5BB5A8A44A1C5E98E280C697D29758548CAF193E";


    @Test(groups = "insuranceSanity", priority = 1)
    public void Test01_verify_categories() {
        int count = 0;


        Categories categories = new Categories(xMClient, auth, deviceId);
        response = categories.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CategoriesHelper categoriesHelper = new CategoriesHelper(response.getBody().asString());

        //Success response Validator
        categoriesHelper.verifySuccessResponse();

        //Assertions
        categoriesHelper.verifyListOfCategoriesSize(7);

    }

    @Test(groups = "insuranceSanity", priority = 2)
    public void Test02_verify_purchase_giftcard() {
        int count = 0;


        TransactionsRequestDto transactionsRequestDto = new TransactionsRequestDto();

        //coupon details
        CouponDetails couponDetails = new CouponDetails();
        couponDetails.setType("Digital");
        couponDetails.setValueType("fixed");

        //brand details
        Brand brand = new Brand();
        brand.setBrandId("eaa3d72b3ea722aece4928d200a4f8f8");

        //card details
        CardDetails cardDetails = new CardDetails();
        cardDetails.setBrand(brand);
        cardDetails.setCardAmount(10);
        cardDetails.setCouponDetails(couponDetails);
        cardDetails.setPrice(0);
        Log.info(String.valueOf(System.currentTimeMillis()));
        cardDetails.setScheduledDate(System.currentTimeMillis());
        cardDetails.setSupplier("GCI");

        //Payment Details
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setSuperCashApplied(false);

        //receiver details
        ReceiverDetails receiverDetails = new ReceiverDetails();
        receiverDetails.setEmail("sandeep.arora@mobikwik.com");
        receiverDetails.setGiftedToSelf(false);
        receiverDetails.setMessage("Special gift for you");
        receiverDetails.setName("Sandeep");
        receiverDetails.setOccasion("Default");
        receiverDetails.setPhoneNumber("7982011727");

        // User details
        UserDetails userDetails = new UserDetails();
        userDetails.setName("Sandeep Arora");

        transactionsRequestDto.setCardDetails(cardDetails);
        transactionsRequestDto.setPaymentDetails(paymentDetails);
        transactionsRequestDto.setReceiverDetails(receiverDetails);
        transactionsRequestDto.setUserDetails(userDetails);


        Transactions transactions = new Transactions(xMClient, auth, deviceId, transactionsRequestDto);
        response = transactions.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


    }

}
