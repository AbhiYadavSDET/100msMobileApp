package GiftCard;
/*
import Helpers.AddMoneyHelper;
import Helpers.GiftCardHelper;
import Helpers.LoginHelper;
import Helpers.MBKCommonControlsHelper;
import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_GiftCard extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();
    AddMoneyHelper addMoneyHelper;
    MBKCommonControlsHelper mbkCommonControlsHelper;

    @Test(groups = {"buyGiftCard", "giftCardSanityWithBuy"}, priority = 0, dataProvider = "giftCardData", dataProviderClass = GiftCardDataProviderClass.class)
    public void Test01_buyGiftCard(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gift Card sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");

//using bankname for Gift Card
//category for the person name gift card is for.
//mobile_no for gift card details
//operator for emailid for gift card

        GiftCardHelper giftCardHelper = new GiftCardHelper(getAndroidDriver());
        giftCardHelper.buyGiftCard(frontEndEntity.getBankName(), frontEndEntity.getAmount(), frontEndEntity.getCategory(), frontEndEntity.getMobileNo(), frontEndEntity.getOperator(), frontEndEntity.getSecurityPin(), frontEndEntity.getCardNo(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword());


    }

    @Test(groups = {"purchasedGiftCard", "giftCardSanity", "giftCardSanityWithBuy"}, priority = 1, dataProvider = "giftCardData", dataProviderClass = GiftCardDataProviderClass.class)
    public void Test02_checkPurchasedCard(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gift Card sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");


        GiftCardHelper giftCardHelper = new GiftCardHelper(getAndroidDriver());
        giftCardHelper.checkPurchasedGiftCard(frontEndEntity.getBankName());

    }

    @Test(groups = {"categoryFilter", "giftCardSanity", "giftCardSanityWithBuy"}, priority = 2, dataProvider = "giftCardData", dataProviderClass = GiftCardDataProviderClass.class)
    public void Test03_checkCategroyFilter(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {

        Log.info("START : Gift Card sanity test");

        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");


        GiftCardHelper giftCardHelper = new GiftCardHelper(getAndroidDriver());
        giftCardHelper.checkCategoryFilter();

    }


}


 */