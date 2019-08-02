import Helpers.LoginHelper;
import Helpers.NearByHelper;
import Utils.TestBase;
import org.testng.annotations.Test;


public class NearByTest extends TestBase {
    @Test(groups = {"nearby"}, priority = 0, description = "Verify local store page")
    public void Test_Nearby() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginViaOtp("8527797582", "T.C. Suneja", "mayank.suneja@mobikwik.com", "8527797582");

        NearByHelper nearByHelper = new NearByHelper(driver);
        nearByHelper.verifyLocalStores("Food");
    }
}