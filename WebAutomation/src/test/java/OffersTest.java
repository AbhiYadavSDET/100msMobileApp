import Helpers.LoginHelper;
import Helpers.OfferHelper;
import Helpers.Recharge.GasHelper;
import Utils.TestBase;
import org.testng.annotations.Test;


public class OffersTest extends TestBase {
    @Test(groups = {"offers"}, priority = 0, description = "Verify offers page")
    public void Test_Offers() throws InterruptedException {

        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("9958314430", "Rashi Agarwal", "amanagarwal30@gmail.com", "9958314430");

        OfferHelper offerHelper = new OfferHelper(driver);
        offerHelper.verifyOffers("makemytrip");
    }
}

