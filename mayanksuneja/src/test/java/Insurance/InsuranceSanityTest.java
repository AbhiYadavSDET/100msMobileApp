package Insurance;

import Insurance.Api.CrossSellDetails;
import Insurance.Api.CrossSellTransaction;
import Insurance.Api.InsuranceDetailsV2;
import Insurance.Api.InsurancePolicyPurchase;
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
    String auth = "/6hweSfR4OKwEHAm2alBUg==.t6akqqjausb71g4mu58u8mh47s";
    String xMClient = "3";
    String acceptEncoding = "\n*";


    @Test(groups = "insuranceSanity", priority = 1)
    public void Test01_verify_insufficient_pa_policy_purchase() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "0");

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
        update_balance(memberId, "0");

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
        update_balance(memberId, "0");

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
        insurancePolicyPurchaseSuccessHelper.verifyData(false, "Mayank Suneja", "ICICI Lombard", "Rs. 50000", "99.0", "Online Fraud Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
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

        insuranceDetailsV2Helper.verifyFixedInsuranceDetails("INCOMPLETE_DETAILS", "Online Fraud Insurance", "ICICI Lombard");

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
        update_balance(memberId, "21");


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
        crossSellTransactionHelper.verifyPolicyPurchaseData(1, false, "Mayank Suneja", "ICICI Lombard", "Rs. 1 Lakh", "20.0", "Personal Accident Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        crossSellTransactionHelper.verifyPolicyPurchaseStartEndDate(1, 12);
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
        update_balance(memberId, "0");


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
        crossSellTransactionHelper.verifyRequiredAmount(21.0);

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
        crossSellDetailsHelper.verifyCrossSellInsuranceTitle("Personal Accident Insurance cover of Rs.1 Lakh");
        crossSellDetailsHelper.verifyFixedCrossSellDetails("NEW_PURCHASE", "Personal Accident Insurance", "ICICI Lombard");
        crossSellDetailsHelper.verifyVariableCrossSellDetails(0, 20, "Rs. 1 Lakh", 12);

    }

    public void update_balance(String memberId, String amount) {
        databaseSqlHelper.updateWalletMainBalance(memberId, amount);
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
