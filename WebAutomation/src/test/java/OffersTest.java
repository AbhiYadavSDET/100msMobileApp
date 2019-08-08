import Helpers.OfferHelper;
import Utils.TestBase;
import org.testng.annotations.Test;


public class OffersTest extends TestBase {
    @Test(groups = {"offers"}, priority = 0, description = "Verify offers page")
    public void Test_Offers() throws InterruptedException {

//        LoginHelper loginHelper = new LoginHelper(driver);
//        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        OfferHelper offerHelper = new OfferHelper(getWebDriver());
        offerHelper.verifyOffers("makemytrip");
    }
}

