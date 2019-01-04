package IntegrationTests.Bus;

import org.json.JSONException;

import java.io.IOException;

public abstract class BusHelperBase {

    public abstract void busBook(String from, String to, String passengerName, String age, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void busCancel(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
