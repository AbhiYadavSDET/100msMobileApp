package Insurance;

import Insurance.Api.CrossSellDetails;
import Insurance.Api.CrossSellTransaction;
import Insurance.Helper.CrossSellDetailsHelper;
import Insurance.Helper.CrossSellTransactionHelper;
import Insurance.Helper.InsuranceDetailsV2Helper;
import Insurance.Models.requestdto.*;
import Utils.DatabaseMongoHelper;
import Utils.DatabaseSqlHelper;
import Utils.Log;
import apiutil.StatusCodeValidator;
import customexception.PolicyNotFoundInPolicyCollection;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class CrossSellTest {


    Response response;
    InsuranceDetailsV2Helper insuranceDetailsV2Helper;
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    DatabaseMongoHelper databaseMongoHelper = new DatabaseMongoHelper();

    @BeforeClass(alwaysRun = true)
    public void BeforeClass() {
        databaseSqlHelper.initiateMemberBalance();
        databaseMongoHelper.initiatePolicy();
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) throws PolicyNotFoundInPolicyCollection {
        Log.info("****************:" + method.getName() + "****************");
        deletePolicies("9953138474@nocash.mobikwik.com");
    }


    // Constants
    String memberId = "9953138474@nocash.mobikwik.com";
    String acceptEncoding = "\n*";

    @Test(groups = {"insuranceSanity", "crossSellSanity", "insurancePallaviDataSetup", "crossSellWalletFlows"}, priority = 0)
    public void Test00_setup() throws PolicyNotFoundInPolicyCollection {
        //deletePolicies("9953138474@nocash.mobikwik.com");
    }

    public void deletePolicies(String memberId) throws PolicyNotFoundInPolicyCollection {
        databaseMongoHelper.deletePolicies(memberId);

    }


    @Test(groups = "crossSellSanity", priority = 1)
    public void Test01_verify_cross_sell_details() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);
        crossSellDetailsHelper.verifyCrossSellInsuranceTitle("Protect yourself from fraudulent online transactions upto Rs.50000");
        crossSellDetailsHelper.verifyFixedCrossSellDetails("NEW_PURCHASE", "Online Fraud Insurance", "ICICI Lombard");
        crossSellDetailsHelper.verifyVariableCrossSellDetails(0, 99, "Rs. 50  Thousands", 1);

    }

    @Test(groups = "crossSellSanity", priority = 2, dependsOnMethods = "Test01_verify_cross_sell_details")
    public void Test02_verify_cross_sell_transaction_sufficient_balance() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "100");


        List<CrossSellTxn> txns = new ArrayList<CrossSellTxn>();
        txns.add(initiateRechargeTxn());
        txns.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txns);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0);
        crossSellTransactionHelper.verifyPolicyPurchaseData(1, false, "Mayank Suneja", "ICICI Lombard", "Rs. 50000", "99.0", "Online Fraud Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        crossSellTransactionHelper.verifyPolicyPurchaseStartEndDate(1, 1);
        crossSellTransactionHelper.verifyRechargeData(0, "RECHARGESUCCESSPENDING", "recharge successful", 1.0);


    }


    @Test(groups = "crossSellSanity", priority = 4, dependsOnMethods = "Test01_cross_sell_details")
    public void Test04_sufficient_recharge_fail_insurance_success() {
        int count = 0;

        // Initiate the DB - Member Balance
        update_balance(memberId, "0");


        List<CrossSellTxn> txns = new ArrayList<CrossSellTxn>();
        txns.add(initiateRechargeTxn());
        txns.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txns);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());
        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");
        crossSellTransactionHelper.verifyRequiredAmount(100.0);

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

    public CrossSellTxn initiateRechargeTxn(String id, String amount, String circle, String cn, Boolean crossSell, Boolean dataConscent, String operator, Boolean special, Boolean superCashOpted) {

        CrossSellTxn_ crossSellTxn_Rch = new CrossSellTxn_();

        crossSellTxn_Rch.setAdParams(new CrossSellAdParams());
        crossSellTxn_Rch.setAmt(amount);
        crossSellTxn_Rch.setCir(circle);
        crossSellTxn_Rch.setCn(cn);
        crossSellTxn_Rch.setCrossSell(crossSell);
        crossSellTxn_Rch.setDataConsent(dataConscent);
        crossSellTxn_Rch.setOp(operator);
        crossSellTxn_Rch.setSpecial(special);
        crossSellTxn_Rch.setSuperCashOpted(superCashOpted);

        CrossSellTxn crossSellTxnRch = new CrossSellTxn();
        crossSellTxnRch.setId(id);
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

    public CrossSellTxn initiateInsurancetxn(String id, String insuranceId, Boolean autoRenew, Boolean crossSell) {

        CrossSellTxn_ crossSellTxn_Ins = new CrossSellTxn_();
        crossSellTxn_Ins.setAutoRenew(autoRenew);
        crossSellTxn_Ins.setCrossSell(crossSell);
        crossSellTxn_Ins.setInsuranceId(insuranceId);

        CrossSellTxn crossSellTxnIns = new CrossSellTxn();
        crossSellTxnIns.setId(id);
        crossSellTxnIns.setTxn(crossSellTxn_Ins);

        return crossSellTxnIns;
    }


    public void update_balance(String memberId, String amount) {
        databaseSqlHelper.updateWalletMainBalance(memberId, amount);
    }


    //--------------------- Cross Sell Wallet flows --------------------------------
    @Test(groups = "crossSellWalletFlows", priority = 1)
    public void Test01_sufficient_recharge_success_insurance_success() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
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

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
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


    @Test(groups = "crossSellWalletFlows", priority = 2)
    public void Test02_sufficient_recharge_fail_insurance_success() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "40");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "20", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPolicyPurchaseData(1, false, "Mayank Suneja", "ICICI Lombard", "Rs. 1 Lakh", "20.0", "Personal Accident Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        crossSellTransactionHelper.verifyPolicyPurchaseStartEndDate(1, 12);
        crossSellTransactionHelper.verifyRechargeDataForTC_02(0, "500", "txn is mocked hence failed user readable error");

    }

    @Test(groups = "crossSellWalletFlows", priority = 3)
    public void Test03_sufficient_recharge_success_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "40");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "1", "5", "9811499418", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, true);
        crossSellTransactionHelper.verifyRechargeData(0, "RECHARGESUCCESSPENDING", "recharge successful", 1.0);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
    }

    @Test(groups = "crossSellWalletFlows", priority = 4)
    public void Test04_sufficient_recharge_fail_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "40");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "20", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyRechargeDataForTC_02(0, "500", "txn is mocked hence failed user readable error");
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
    }

    @Test(groups = "crossSellWalletFlows", priority = 5)
    public void Test05_sufficientForRecharge_recharge_pass_insurance_pass() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "20", "5", "8527797582", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, true);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(20.00);

    }

    @Test(groups = "crossSellWalletFlows", priority = 6)
    public void Test06_sufficientForRecharge_recharge_fail_insurance_pass() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "20", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, true);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPolicyPurchaseData(1, false, "Mayank Suneja", "ICICI Lombard", "Rs. 1 Lakh", "20.0", "Personal Accident Insurance", "INCOMPLETE_DETAILS", "You have successfully paid for your insurance policy. Now, you are just one step away from getting your insurance cover");
        crossSellTransactionHelper.verifyPolicyPurchaseStartEndDate(1, 12);
        crossSellTransactionHelper.verifyRechargeDataForTC_02(0, "500", "txn is mocked hence failed user readable error");

    }

    @Test(groups = "crossSellWalletFlows", priority = 7)
    public void Test07_sufficientForRecharge_recharge_pass_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "1", "5", "7795709569", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, true);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
        crossSellTransactionHelper.verifyRechargeData(0, "RECHARGESUCCESSPENDING", "recharge successful", 1.0);

    }

    @Test(groups = "crossSellWalletFlows", priority = 8)
    public void Test08_sufficientForRecharge_recharge_fail_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "20", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifySuccessResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
        crossSellTransactionHelper.verifyRechargeDataForTC_02(0, "500", "txn is mocked hence failed user readable error");

    }

    @Test(groups = "crossSellWalletFlows", priority = 9)
    public void Test09_sufficientForInsurance_recharge_pass_insurance_pass() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "30", "5", "9811499418", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(30.00);
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");


    }

    @Test(groups = "crossSellWalletFlows", priority = 10)
    public void Test10_sufficientForInsurance_recharge_fail_insurance_pass() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "30", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(30.00);
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");

    }

    @Test(groups = "crossSellWalletFlows", priority = 11)
    public void Test11_sufficientForInsurance_recharge_pass_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "30", "5", "9811499418", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(10.00);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");


    }

    @Test(groups = "crossSellWalletFlows", priority = 12)
    public void Test12_sufficientForInsurance_recharge_fail_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
        response = crossSellDetails.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);


        CrossSellDetailsHelper crossSellDetailsHelper = new CrossSellDetailsHelper(response.getBody().asString());

        crossSellDetailsHelper.verifySuccessResponse();
        crossSellDetailsHelper.setVariables(0);

        // Initiate the DB - Member Balance
        update_balance(memberId, "20");


        List<CrossSellTxn> txnsResponse = new ArrayList<CrossSellTxn>();
        txnsResponse.add(initiateRechargeTxn("rch", "30", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyRequiredAmount(10.00);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");


    }

    @Test(groups = "crossSellWalletFlows", priority = 13)
    public void Test13_insufficient_recharge_success_insurance_success() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
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
        txnsResponse.add(initiateRechargeTxn("rch", "1", "5", "9650200338", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn(CrossSellDetailsHelper.map.get("insuranceId_" + count)));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(21.00);
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");


    }

    @Test(groups = "crossSellWalletFlows", priority = 14)
    public void Test14_insufficient_recharge_fail_insurance_success() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
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
        txnsResponse.add(initiateRechargeTxn("rch", "20", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, CrossSellDetailsHelper.map.get("scopeId"), crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(40.00);
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");

    }

    @Test(groups = "crossSellWalletFlows", priority = 15)
    public void Test15_insufficient_recharge_success_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
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
        txnsResponse.add(initiateRechargeTxn("rch", "1", "5", "8527797582", true, true, "29", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyPgOptions(3, "cc", "dc", "upi");
        crossSellTransactionHelper.verifyRequiredAmount(1.00);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");


    }

    @Test(groups = "crossSellWalletFlows", priority = 16)
    public void Test16_insufficient_recharge_fail_insurance_fail() {
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


        CrossSellDetails crossSellDetails = new CrossSellDetails(acceptEncoding, crossSellDetailsDto);
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
        txnsResponse.add(initiateRechargeTxn("rch", "20", "", "9953138474", true, true, "19", false, true));
        txnsResponse.add(initiateInsurancetxn("ins", CrossSellDetailsHelper.map.get("insuranceId_" + count), false, true));


        CrossSellTransactionDto crossSellTransactionDto = new CrossSellTransactionDto();
        crossSellTransactionDto.setTxns(txnsResponse);

        CrossSellTransaction crossSellTransaction = new CrossSellTransaction(acceptEncoding, "scopeId", crossSellTransactionDto);
        response = crossSellTransaction.execute();

        System.out.println(response.getBody().asString());

        //Status code validator
        StatusCodeValidator.validate200(response);

        CrossSellTransactionHelper crossSellTransactionHelper = new CrossSellTransactionHelper(response.getBody().asString());

        crossSellTransactionHelper.verifyFalseResponse();
        crossSellTransactionHelper.verifyInsuranceSuccessResponse(1, false);
        crossSellTransactionHelper.verifyRechargeSuccessResponse(0, false);
        crossSellTransactionHelper.verifyRequiredAmount(20.00);
        crossSellTransactionHelper.verifyInsuranceDataForTC_03(1, "INVL_SCP", "Invalid Scope ");
        crossSellTransactionHelper.verifyMessage("ADD_MONEY", "Please add Money");


    }


    // ----------------------------------------------------------------------------

}
