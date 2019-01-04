package IntegrationTests.AddMoney;

import org.json.JSONException;

import java.io.IOException;

public abstract class AddmoneyHelperBase {

    public abstract void addmoneyNetbanking(String bankName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void addmoneyNewCard(String amount, String cardNo, String expiry, String cvv, String password, String successMessage, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void addmoneySavedCardPromocode(String amount, String cardNo, String cvv, String password, String successMessage, boolean promocodeFlag, String promocode, String supercashToBeAdded, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
