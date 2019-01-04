package IntegrationTests.ViewBill;

import org.json.JSONException;

import java.io.IOException;

public abstract class ViewBillHelperBase {


    public abstract void viewBillGas(String operator, String cn, String mobileNo, String email, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void viewBillElectricity(String operator, String cn, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void viewBillWater(String operator, String cn, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}