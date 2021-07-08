package Recharge;

import Helpers.CheckBalanceHelper;
import Helpers.LoginHelper;
import Helpers.RechargeHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_Recharge extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"PrepaidRecharge", "rechargeSanity"}, priority = 0, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test01_prepaid_recharge(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        checkBalanceHelper.checkBalance(frontEndEntity.getAmount());

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.prepaidRecharge(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getOperator(), frontEndEntity.getTotalPayment(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSecurityPin(), false, "N/A", frontEndEntity.getPromoCodeText());
    }



    @Test(groups = {"PostpaidRecharge", "rechargeSanity"}, priority = 1, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test02_postpaid_recharge(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.postpaidPayment(frontEndEntity.getMobileNo(), frontEndEntity.getPopupError(), frontEndEntity.getPopupText(), "Postpaid, Vodafone");
    }

    @Test(groups = {"PostpaidRechargeSavedConnection", "rechargeSanity"}, priority = 2, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test03_postpaid_recharge_saved_connection(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.postpaidPaymentViaSavedConnection(frontEndEntity.getMobileNo(), frontEndEntity.getPopupText(), frontEndEntity.getCategory(), frontEndEntity.getOperator(), "Postpaid, Vodafone");
    }

//    @Test(groups = {"RechargeDthInvalidAmount", "rechargeSanity"}, priority = 3, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
//    public void Test04_recharge_invalid_amount(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException, TesseractException {
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//
//        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
//        rechargeHelper.rechargeDthInvalidAmount(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getErrorMessage());
//    }

    @Test(groups = {"PrepaidRechargeWithPromoCode", "rechargeSanity"}, priority = 4, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test05_recharge_prepaid_promocode(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        checkBalanceHelper.checkBalance(frontEndEntity.getAmount());

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.prepaidRecharge(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getOperator(), frontEndEntity.getTotalPayment(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSecurityPin(), true, frontEndEntity.getPromoCode(), frontEndEntity.getPromoCodeText());
    }



    //Pallavi
    @Test(groups = {"SavedConnectionPostpaidRecharge", "rechargeSanity"}, priority = 0, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test01_recharge_postpaid_SavedConnection(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        //checkBalanceHelper.checkBalance(frontEndEntity.getAmount());

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.postpaidRecharge(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getOperator(), frontEndEntity.getTotalPayment(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSecurityPin(), false, "N/A", frontEndEntity.getPromoCodeText());
    }

    @Test(groups = {"ElectricityViewBill", "rechargeSanity"}, priority = 0, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test02_Electricity_ViewBill(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.viewBillElectricity(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getOperator(), frontEndEntity.getTotalPayment(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSecurityPin(), false, "N/A", frontEndEntity.getPromoCodeText());
    }

    @Test(groups = {"GasViewBill", "rechargeSanity"}, priority = 0, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test03_viewbill_Gas(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        CheckBalanceHelper checkBalanceHelper = new CheckBalanceHelper(getAndroidDriver());
        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.viewBillGas(frontEndEntity.getMobileNo(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getOperator(), frontEndEntity.getTotalPayment(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSecurityPin(), false, "N/A", frontEndEntity.getPromoCodeText());
    }


    @Test(groups = {"ViewBillGas", "rechargeSanity"}, priority = 5, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test06_viewbill_gas(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.viewBillGas(frontEndEntity.getOperator(), frontEndEntity.getMobileNo());
    }

    @Test(groups = {"ViewBillMtnlDelhi", "rechargeSanity"}, priority = 6, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test07_viewbill_mtnl_delhi(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.viewBillMtnlDelhi(frontEndEntity.getOperator(), frontEndEntity.getMobileNo());
    }

    @Test(groups = {"creditCardBillPaymentWapg", "rechargeSanity", "ccbpSanity"}, priority = 7, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test08_credit_card_bill_pay_wapg(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.creditCardRechargeFlow(frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getCardNo(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), "Payment successful", false,frontEndEntity.getPromoCode(), "WAPG");
    }

    @Test(groups = {"creditCardBillPaymentWallet", "rechargeSanity", "ccbpSanity"}, priority = 7, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
    public void Test09_credit_card_bill_pay_wallet_conv_fee(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
        rechargeHelper.creditCardRechargeFlow(frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getCardNo(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), "Payment successful", false,frontEndEntity.getPromoCode(), "WALLET");}



//    @Test(groups = {"creditCardBillPaymentWapgWithCoupon", "ccbpSanity"}, priority = 8, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
//    public void Test09_credit_card_bill_pay_wapg_with_coupon(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
////        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaNumber("9205299330", "547372");
//
//        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
//        rechargeHelper.creditCardRechargeWapgFlow(frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getCardNo(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSuccessPageText(), true, frontEndEntity.getPromoCode());
//    }
//
//
//    @Test(groups = {"creditCardBillPaymentWithVoucherSameAmount", "ccbpSanityWithVoucher"}, priority = 9, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
//    public void Test10_credit_card_bill_pay_with_voucher_same_amount(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
////        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaNumber("9205299330", "547372");
//
//        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
//        rechargeHelper.creditCardRechargeWapgFlowVoucherSameAmount(frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSuccessPageText());
//    }
//
//    @Test(groups = {"creditCardBillPaymentWithVoucherWapgAmountMoreThanVoucher", "ccbpSanityWithVoucher"}, priority = 10, dataProvider = "rechargeData", dataProviderClass = RechargeDataProviderClass.class)
//    public void Test10_credit_card_bill_pay_wapg_amount_more_than_voucher(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
//        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
////        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaNumber("9205299330", "547372");
//
//        RechargeHelper rechargeHelper = new RechargeHelper(getAndroidDriver());
//        rechargeHelper.creditCardRechargeWapgFlowMoreAmountThanVoucher(frontEndEntity.getAmount(), frontEndEntity.getSecurityPin(), frontEndEntity.getCardNo(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity.getSuccessPageText());
//    }

}
