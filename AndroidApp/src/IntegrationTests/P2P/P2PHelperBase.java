package IntegrationTests.P2P;

import org.json.JSONException;

import java.io.IOException;

public abstract class P2PHelperBase {

    public abstract void p2pSufficient(String mCode, String mName, String amount, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
