import Helpers.LoginHelper;
import Helpers.NearByHelper;
import Helpers.OfferHelper;
import Helpers.Recharge.GasHelper;
import Utils.TestBase;
import org.testng.annotations.Test;


public class NearByTest extends TestBase {
    @Test(groups = {"nearby"}, priority = 0, description = "Verify local store page")
    public void Test_Nearby() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        NearByHelper nearByHelper = new NearByHelper(driver);
        nearByHelper.verifyLocalStores("Food");
    }
}