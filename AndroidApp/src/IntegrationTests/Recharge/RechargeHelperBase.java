package IntegrationTests.Recharge;

import org.json.JSONException;

import java.io.IOException;

public abstract class RechargeHelperBase {

    public abstract void prepaidRecharge(String cell, String amount, String category, String operator, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void mobilePostpaidSavedConnection(String cell, String amount, String category, String operator, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void postpaidPaymentWithPromocode(String cell, String amount, boolean promocodeFlag, String promocode, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void bsnlSpecial(String cell, String operator, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


    public abstract void creditCardBillPayment(String amount, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
