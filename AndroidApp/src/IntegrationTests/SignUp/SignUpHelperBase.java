package IntegrationTests.SignUp;

import org.json.JSONException;

import java.io.IOException;

public abstract class SignUpHelperBase {

    public abstract void signUpOnboardMobile(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void signUpEmail(String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

}

