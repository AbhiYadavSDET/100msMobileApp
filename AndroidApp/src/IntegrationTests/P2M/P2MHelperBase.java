package IntegrationTests.P2M;

import org.json.JSONException;

import java.io.IOException;

public abstract class P2MHelperBase {

    public abstract void p2mSufficient(String mCode, String mName, String amount, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
