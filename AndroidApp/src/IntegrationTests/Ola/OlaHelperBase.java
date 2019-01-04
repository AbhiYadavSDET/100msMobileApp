package IntegrationTests.Ola;

import org.json.JSONException;

import java.io.IOException;

public abstract class OlaHelperBase {

    public abstract void olaBook(String to, String passengerName, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void olaCancel(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
