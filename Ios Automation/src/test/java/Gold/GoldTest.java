package Gold;

import Helpers.GoldHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;


    public class GoldTest extends TestBase {

        @Test(groups = {"Gold", "regression"}, priority = 0, description = "Verify buy gold flow")

        public void Test_BuyGold_Flow() throws InterruptedException, IOException {

            Log.info("======= START : Login test =======");

            LoginHelper loginHelper = new LoginHelper(getIosDriver());
            loginHelper.loginViaOtp("9205299330", "547372");

            Log.info("======= END : Login test =======");

            Log.info("======= START : Buy Gold Flow test =======");

            GoldHelper goldHelper = new GoldHelper(getIosDriver());
            goldHelper.goldBuy("100","Payment Successful","Gold Purchase","₹100","0.0163 gm(s)");

            Log.info("======= END : Buy Gold Flow test =======");

        }

        @Test(groups = {"Gold", "regression"}, priority = 0, description = "Verify sell gold flow")

        public void Test_SellGold_Flow() throws InterruptedException, IOException {

            Log.info("======= START : Login test =======");

            LoginHelper loginHelper = new LoginHelper(getIosDriver());
            loginHelper.loginViaOtp("9205299330", "547372");

            Log.info("======= END : Login test =======");

            Log.info("======= START : Sell Gold Flow test =======");

            GoldHelper goldHelper = new GoldHelper(getIosDriver());
            goldHelper.goldSell("100","0.0163 gm(s)","₹100","Payment Successful","Sell Gold","0.0163 gm(s)","₹100");

            Log.info("======= END : Sell Gold Flow test =======");

        }
}
