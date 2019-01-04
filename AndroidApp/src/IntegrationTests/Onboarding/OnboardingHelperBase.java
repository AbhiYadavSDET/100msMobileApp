package IntegrationTests.Onboarding;

import org.json.JSONException;

import java.io.IOException;

public abstract class OnboardingHelperBase {

    public abstract void onboardingLogin(String mobileNo, String userName, String name, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void loginViaMobileNo(String mobileNo, String userName, String name, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;

    public abstract void loginViaPassword(String mobileNo, String userName, String password, String name, String directoryName, String screenName) throws InterruptedException, IOException, JSONException;


}
