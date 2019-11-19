package test.java.AndroidApp.Test.GiftCard;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.*;
import test.java.AndroidApp.Test.IMPS.ImpsDataProviderClass;

import java.io.IOException;

public class Test_GiftCard extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    AddMoneyHelper addMoneyHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    @Test(groups = {"buyGiftCard", "giftCardSanityWithBuy"}, priority = 0, dataProvider = "giftCardData", dataProviderClass = GiftCardDataProviderClass.class)
    public void Test01_buyGiftCard(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gift Card sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

//using bankname for Gift Card
//category for the person name gift card is for.
//mobile_no for gift card details
//operator for emailid for gift card

        GiftCardHelper giftCardHelper= new GiftCardHelper(getAndroidDriver());
        giftCardHelper.buyGiftCard(frontEndEntity.getBankName(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getMobileNo(), frontEndEntity.getOperator(),frontEndEntity.getSecurityPin(), frontEndEntity.getCardNo(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword());


    }

    @Test(groups = {"purchasedGiftCard", "giftCardSanity", "giftCardSanityWithBuy"}, priority = 1, dataProvider = "giftCardData", dataProviderClass = GiftCardDataProviderClass.class)
    public void Test02_checkPurchasedCard(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gift Card sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        GiftCardHelper giftCardHelper= new GiftCardHelper(getAndroidDriver());
        giftCardHelper.checkPurchasedGiftCard(frontEndEntity.getBankName());

    }

    @Test(groups = {"categoryFilter", "giftCardSanity", "giftCardSanityWithBuy"}, priority = 2, dataProvider = "giftCardData", dataProviderClass = GiftCardDataProviderClass.class)
    public void Test03_checkCategroyFilter(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gift Card sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        GiftCardHelper giftCardHelper= new GiftCardHelper(getAndroidDriver());
        giftCardHelper.checkCategoryFilter();

    }


}
