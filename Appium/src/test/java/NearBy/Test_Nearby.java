package NearBy;
/*
import Helpers.LoginHelper;
import Helpers.NearByHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;


public class Test_Nearby extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"nearBySanity", "nearByHome"}, priority = 0, enabled = true, dataProvider = "nearbyData", dataProviderClass = NearbyProviderClass.class)
    public void Test19_nearbyStoreListMap(FrontEndEntity frontEndEntity) throws Exception {
        Log.info("START : OLA sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        NearByHelper nearByHelper = new NearByHelper(getAndroidDriver());
        nearByHelper.nearbyStoreByAddress();

        Log.info("END : Nearby Store List test");

    }

    @Test(groups = {"nearBySanity", "nearbySearchCategory"}, priority = 1, enabled = true, dataProvider = "nearbyData", dataProviderClass = NearbyProviderClass.class)
    public void Test20_nearbySearchCategory(FrontEndEntity frontEndEntity) throws Exception {
        Log.info("START : OLA sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        NearByHelper nearByHelper = new NearByHelper(getAndroidDriver());
        nearByHelper.nearbySearchCategory(frontEndEntity.getBankName());

        Log.info("END : Nearby Search Category test");
    }


    @Test(groups = {"nearBySanity", "nearbySearchKeyword"}, priority = 2, enabled = true, dataProvider = "nearbyData", dataProviderClass = NearbyProviderClass.class)
    public void Test21_nearbySearchStore(FrontEndEntity frontEndEntity) throws Exception {
        Log.info("START : OLA sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        NearByHelper nearByHelper = new NearByHelper(getAndroidDriver());
        nearByHelper.nearbySearchStore(frontEndEntity.getBankName());

        Log.info("END : Nearby Search Store test");
    }
}

 */