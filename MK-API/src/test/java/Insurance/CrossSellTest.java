package Insurance;

import Insurance.Api.CrossSellDetails;
import Insurance.Api.CrossSellTransaction;
import Insurance.Helper.CrossSellDetailsHelper;
import Insurance.Helper.CrossSellTransactionHelper;
import Insurance.Helper.InsuranceDetailsV2Helper;
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


public class CrossSellTest {


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

    @Test(groups = "crossSellSanity", priority = 3, dependsOnMethods = "Test01_verify_cross_sell_details")
    public void Test03_verify_cross_sell_transaction_insufficient_balance() {
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


    public void update_balance(String memberId, String amount) {
        databaseSqlHelper.updateWalletMainBalance(memberId, amount);
    }


}
