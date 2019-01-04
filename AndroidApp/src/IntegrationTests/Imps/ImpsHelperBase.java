package IntegrationTests.Imps;

import org.json.JSONException;

import java.io.IOException;

public abstract class ImpsHelperBase {

    public abstract void impsTransfer(String bankAccountNo, String holderName, String ifsc, String amount, String userName, String otpCell, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
