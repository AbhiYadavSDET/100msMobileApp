package IntegrationTests.Bikes;

import org.json.JSONException;

import java.io.IOException;

import org.json.JSONException;

import java.io.IOException;

public abstract class BikeHelperBase {

    public abstract void bikeInSufficientBooking(String drivinglic, String mName, String amount, String mobNo, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}