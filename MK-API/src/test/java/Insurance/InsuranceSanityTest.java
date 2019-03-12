package Insurance;

import Insurance.Api.*;
import Insurance.Helper.*;
import Insurance.Models.requestdto.*;
import Utils.DatabaseSqlHelper;
import Utils.Log;
import apiutil.StatusCodeValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class InsuranceSanityTest {


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
    String auth = "/6hweSfR4OKwEHAm2alBUg==.idigoc531qvk7pjddsq2fjtqsr";
    String xMClient = "3";
    String acceptEncoding = "\n*";


    @Test(groups = "insuranceSanity", priority = 1)
    public void Test01_verify_insufficient_pa_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "0", 0.0);

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("PERSONAL_ACCIDENT");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsurancePolicyPurchaseHelper insurancePolicyPurchaseHelper = new InsurancePolicyPurchaseHelper(response.getBody().asString());
        insurancePolicyPurchaseHelper.verifySuccessResponse();
        insurancePolicyPurchaseHelper.verifyMessage("PG03", "Insufficient balance exception");
        insurancePolicyPurchaseHelper.verifyPgOptions(3, "cc", "dc", "upi");
    }

    @Test(groups = "insuranceSanity", priority = 2)
    public void Test02_verify_insufficient_li_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "0", 0.0);

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("LIFE");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase("3", auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsurancePolicyPurchaseHelper insurancePolicyPurchaseHelper = new InsurancePolicyPurchaseHelper(response.getBody().asString());
        insurancePolicyPurchaseHelper.verifySuccessResponse();
        insurancePolicyPurchaseHelper.verifyMessage("PG03", "Insufficient balance exception");
        insurancePolicyPurchaseHelper.verifyPgOptions(3, "cc", "dc", "upi");


    }

    @Test(groups = "insuranceSanity", priority = 3)
    public void Test03_verify_insufficient_cyber_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "0", 0.0);

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("CYBER");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase("3", auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsurancePolicyPurchaseHelper insurancePolicyPurchaseHelper = new InsurancePolicyPurchaseHelper(response.getBody().asString());
        insurancePolicyPurchaseHelper.verifySuccessResponse();
        insurancePolicyPurchaseHelper.verifyMessage("PG03", "Insufficient balance exception");
        insurancePolicyPurchaseHelper.verifyPgOptions(3, "cc", "dc", "upi");


    }

    @Test(groups = "insuranceSanity", priority = 4)
    public void Test04_verify_sufficient_li_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("LIFE");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();

        //Assertions
        insurancePolicyPurchaseSuccessHelper.verifyData(false, "Mayank Suneja", "ICICI Prudential", "Rs. 1 Lakh", "20.0", "Life Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        insurancePolicyPurchaseSuccessHelper.verifyStartEndDate(1);


    }

    @Test(groups = "insuranceSanity", priority = 5)
    public void Test05_verify_sufficient_pa_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("PERSONAL_ACCIDENT");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();

        //Assertions
        insurancePolicyPurchaseSuccessHelper.verifyData(false, "Mayank Suneja", "ICICI Lombard", "Rs. 1 Lakh", "20.0", "Personal Accident Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        insurancePolicyPurchaseSuccessHelper.verifyStartEndDate(12);


    }

    @Test(groups = "insuranceSanity", priority = 6)
    public void Test06_verify_sufficient_cyber_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "99");


        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("CYBER");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();

        //Assertions
        insurancePolicyPurchaseSuccessHelper.verifyData(false, "Mayank Suneja", "ICICI Lombard", "Rs. 50000", "99.0", "Online Fraud Protection", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        insurancePolicyPurchaseSuccessHelper.verifyStartEndDate(1);


    }

    @Test(groups = "insuranceSanity", priority = 7)
    public void Test07_verify_li_policy_purchase_already_bought() {
        int count = 0;

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("LIFE");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        insuranceDetailsV2Helper.verifyFixedInsuranceDetails("INCOMPLETE_DETAILS", "Life Insurance", "ICICI Prudential");

    }

    @Test(groups = "insuranceSanity", priority = 8)
    public void Test08_verify_pa_policy_purchase_already_bought() {
        int count = 0;

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("PERSONAL_ACCIDENT");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        insuranceDetailsV2Helper.verifyFixedInsuranceDetails("INCOMPLETE_DETAILS", "Personal Accident Insurance", "ICICI Lombard");

    }

    @Test(groups = "insuranceSanity", priority = 9)
    public void Test09_verify_cyber_policy_purchase_already_bought() {
        int count = 0;

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("CYBER");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        insuranceDetailsV2Helper.verifyFixedInsuranceDetails("INCOMPLETE_DETAILS", "Online Fraud Protection", "ICICI Lombard");

    }

    @Test(groups = "crossSellSanity", priority = 12)
    public void Test12_verify_cross_sell_transaction_sufficient_balance() {
        int count = 0;

        Txn_ txn_ = new Txn_();
        txn_.setSenderToWalletEnum("SENDER_TO_WALLET_HOME");
        txn_.setInsuranceSellingPlatform("APP_RECHARGE_CROSS_SELL");

        Txn txn = new Txn();
        txn.setId("rch");
        txn.setTxn(txn_);

        List<Txn> txns = new ArrayList<Txn>();
        txns.add(txn);
        CrossSellDetailsDto crossSellDetailsDto = new CrossSellDetailsDto();
        crossSellDetailsDto.setTxns(txns);


        CrossSellDetails crossSellDetails = new CrossSellDetails(xMClient, auth, acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "100");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn());
        txnsResponse.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(xMClient, auth, acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0);
        crossSellTransactionHelper.verifyPolicyPurchaseData(1, false, "Mayank Suneja", "ICICI Lombard", "Rs. 50000", "99.0", "Online Fraud Protection", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        crossSellTransactionHelper.verifyPolicyPurchaseStartEndDate(1, 1);
        crossSellTransactionHelper.verifyRechargeData(0, "RECHARGESUCCESSPENDING", "recharge successful", 1.0);

    }

    @Test(groups = "crossSellSanity", priority = 11)
    public void Test11_verify_cross_sell_transaction_insufficient_balance() {
        int count = 0;

        Txn_ txn_ = new Txn_();
        txn_.setSenderToWalletEnum("SENDER_TO_WALLET_HOME");
        txn_.setInsuranceSellingPlatform("APP_RECHARGE_CROSS_SELL");

        Txn txn = new Txn();
        txn.setId("rch");
        txn.setTxn(txn_);

        List<Txn> txns = new ArrayList<Txn>();
        txns.add(txn);
        CrossSellDetailsDto crossSellDetailsDto = new CrossSellDetailsDto();
        crossSellDetailsDto.setTxns(txns);


        CrossSellDetails crossSellDetails = new CrossSellDetails(xMClient, auth, acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "0", 0.0);


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn());
        txnsResponse.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(xMClient, auth, acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());
        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");
        crossSellTransactionHelper.verifyRequiredAmount(100.0);

    }


    @Test(groups = "crossSellSanity", priority = 10)
    public void Test10_verify_cross_sell_details() {
        int count = 0;


        Txn_ txn_ = new Txn_();
        txn_.setSenderToWalletEnum("SENDER_TO_WALLET_HOME");
        txn_.setInsuranceSellingPlatform("APP_RECHARGE_CROSS_SELL");

        Txn txn = new Txn();
        txn.setId("rch");
        txn.setTxn(txn_);

        List<Txn> txns = new ArrayList<Txn>();
        txns.add(txn);
        CrossSellDetailsDto crossSellDetailsDto = new CrossSellDetailsDto();
        crossSellDetailsDto.setTxns(txns);


        CrossSellDetails crossSellDetails = new CrossSellDetails(xMClient, auth, acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);
        crossSellDetailsHelper.verifyCrossSellInsuranceTitle("Protect yourself from fraudulent online transactions upto Rs.50000");
        crossSellDetailsHelper.verifyFixedCrossSellDetails("NEW_PURCHASE", "Online Fraud Protection", "ICICI Lombard");
        crossSellDetailsHelper.verifyVariableCrossSellDetails(0, 99, "Rs. 50  Thousands", 1);

    }

    @Test(groups = "policyPurchase", priority = 14)
    public void Test14_verify_li_enter_policy_details() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("LIFE");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();

        insurancePolicyPurchaseSuccessHelper.setPolicyId();

        PolicyDetailsDto policyDetailsDto = new PolicyDetailsDto();
        initialiseRequestBody(policyDetailsDto);

        PolicyDetails policyDetails = new PolicyDetails(xMClient, auth, policyDetailsDto);
        response = policyDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        PolicyDetailsHelper policyDetailsHelper = new PolicyDetailsHelper(response.getBody().asString());
        policyDetailsHelper.verifySuccessResponse();


    }

    @Test(groups = "policyPurchase", priority = 13)
    public void Test13_verify_pa_enter_policy_details() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");

        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("PERSONAL_ACCIDENT");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();

        insurancePolicyPurchaseSuccessHelper.setPolicyId();

        PolicyDetailsDto policyDetailsDto = new PolicyDetailsDto();
        initialiseRequestBody(policyDetailsDto);

        PolicyDetails policyDetails = new PolicyDetails(xMClient, auth, policyDetailsDto);
        response = policyDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        PolicyDetailsHelper policyDetailsHelper = new PolicyDetailsHelper(response.getBody().asString());
        policyDetailsHelper.verifySuccessResponse();


    }

    @Test(groups = "policyPurchase", priority = 15)
    public void Test15_verify_cyber_enter_policy_details() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "99");


        InsuranceDetailsV2Dto insuranceDetailsV2Dto = new InsuranceDetailsV2Dto();
        insuranceDetailsV2Dto.setInsuranceCategory("CYBER");
        insuranceDetailsV2Dto.setInsuranceSellingPlatform("APP_ICON");

        InsuranceDetailsV2 insuranceDetailsV2 = new InsuranceDetailsV2(xMClient, auth, insuranceDetailsV2Dto);
        response = insuranceDetailsV2.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        // Success response Validator
        InsuranceDetailsV2Helper insuranceDetailsV2Helper = new InsuranceDetailsV2Helper(response.getBody().asString());
        insuranceDetailsV2Helper.verifySuccessResponse();

        // Set the scope ID
        insuranceDetailsV2Helper.setVariables(count);

        InsurancePolicyPurchaseDto insurancePolicyPurchaseDto = new InsurancePolicyPurchaseDto();
        insurancePolicyPurchaseDto.setInsuranceId(InsuranceDetailsV2Helper.map.get("insuranceId_" + count));
        insurancePolicyPurchaseDto.setAutoRenew(true);

        InsurancePolicyPurchase insurancePolicyPurchase = new InsurancePolicyPurchase(xMClient, auth, InsuranceDetailsV2Helper.map.get("scopeId"), insurancePolicyPurchaseDto);
        response = insurancePolicyPurchase.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        InsurancePolicyPurchaseSuccessHelper insurancePolicyPurchaseSuccessHelper = new InsurancePolicyPurchaseSuccessHelper(response.getBody().asString());
        insurancePolicyPurchaseSuccessHelper.verifySuccessResponse();

        insurancePolicyPurchaseSuccessHelper.setPolicyId();

        PolicyDetailsDto policyDetailsDto = new PolicyDetailsDto();
        initialiseRequestBody(policyDetailsDto);

        PolicyDetails policyDetails = new PolicyDetails(xMClient, auth, policyDetailsDto);
        response = policyDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        //Success response Validator
        PolicyDetailsHelper policyDetailsHelper = new PolicyDetailsHelper(response.getBody().asString());
        policyDetailsHelper.verifySuccessResponse();


    }

    public PolicyDetailsDto initialiseRequestBody(PolicyDetailsDto policyDetailsDto) {
        policyDetailsDto.setAddress("H No - 1560, sector 46, Gurgaon");
        policyDetailsDto.setNomineeName("Neelam Suneja");
        policyDetailsDto.setFullName("Mayank Suneja");
        policyDetailsDto.setNomineeAge("58");
        policyDetailsDto.setPincode("122002");
        policyDetailsDto.setDob("20/11/1989");
        policyDetailsDto.setNomineeRelationship("Mother");
        policyDetailsDto.setPolicyId(InsuranceDetailsV2Helper.map.get("policyId"));
        policyDetailsDto.setEmail("mayank.suneja@gmail.com");
        policyDetailsDto.setPhone("9953138474");
        policyDetailsDto.setState("Haryana");
        policyDetailsDto.setGender("Male");

        return policyDetailsDto;
    }


    public void update_balance(String memberId, String amount) {
        databaseSqlHelper.updateWalletMainBalance(memberId, amount);
    }

    public void update_balance(String memberId, String mainBalance, Double bucket6Balance) {
        databaseSqlHelper.updateWalletMainBalance(memberId, mainBalance);
        databaseSqlHelper.updateWalletBucket6Balance(memberId, bucket6Balance);

    }

    public CrossSellTxn initiateRechargeTxn() {

        CrossSellTxn_ crossSellTxn_Rch = new CrossSellTxn_();

        crossSellTxn_Rch.setAdParams(new CrossSellAdParams());
        crossSellTxn_Rch.setAmt("1");
        crossSellTxn_Rch.setCir("5");
        crossSellTxn_Rch.setCn("9650200338");
        crossSellTxn_Rch.setCrossSell(true);
        crossSellTxn_Rch.setDataConsent(true);
        crossSellTxn_Rch.setOp("29");
        crossSellTxn_Rch.setSpecial(false);
        crossSellTxn_Rch.setSuperCashOpted(true);

        CrossSellTxn crossSellTxnRch = new CrossSellTxn();
        crossSellTxnRch.setId("rch");
        crossSellTxnRch.setTxn(crossSellTxn_Rch);

        return crossSellTxnRch;

    }

    public CrossSellTxn initiateInsurancetxn(String insuranceId) {

        CrossSellTxn_ crossSellTxn_Ins = new CrossSellTxn_();
        crossSellTxn_Ins.setAutoRenew(false);
        crossSellTxn_Ins.setCrossSell(true);
        crossSellTxn_Ins.setInsuranceId(insuranceId);

        CrossSellTxn crossSellTxnIns = new CrossSellTxn();
        crossSellTxnIns.setId("ins");
        crossSellTxnIns.setTxn(crossSellTxn_Ins);

        return crossSellTxnIns;
    }


}
