package test.java.AndroidApp.Test.AddMoney;

import UITestFramework.CreateSession;
import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import main.java.utils.DatabaseSqlHelper;
import org.json.JSONException;
import org.testng.annotations.Test;
import test.java.AndroidApp.Helpers.AddMoneyHelper;
import test.java.AndroidApp.Helpers.LoginHelper;

import java.io.IOException;

public class Test_AddMoney extends CreateSession {

    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"addMoneyNetBanking", "addMoneySanity"}, priority = 0, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    public void Test01_netbanking(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail("mkwik9330@gmail.com", "Test@1234");
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.netbanking(frontEndEntity.getAmount(), frontEndEntity.getBankName(), frontEndEntity.getBankPageLocator(), frontEndEntity.getBankPageLocatorType());
    }


    @Test(groups = {"addMoneyNewCard", "addMoneySanity"}, priority = 1, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    public void Test02_addMoneyNewCard(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

        //loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.addMoneyViaNewCard(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
                .getSuccessPageText());
    }

    @Test(groups = {"addMoneySavedCard", "addMoneySanity"}, priority = 2, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    public void Test03_addMoneySavedCard(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        //loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        Log.info("Password : " + frontEndEntity.getPassword());

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.addMoneyViaSavedCard(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
                .getSuccessPageText(), false, frontEndEntity.getPromoCode());
    }

    @Test(groups = {"addMoneySavedCardWithPromo", "addMoneySanity"}, priority = 3, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    public void Test04_addMoneySavedCardWithPromo(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        //loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");


        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.addMoneyViaSavedCard(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
                .getSuccessPageText(), true, frontEndEntity.getPromoCode());
    }

    @Test(groups = {"addMoneyRefund", "addMoneySanity"}, priority = 4, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    public void Test05_addMoneyRefund(FrontEndEntity frontEndEntity) throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
        //loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");

        Log.info("Password : " + frontEndEntity.getPassword());

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
        addmoneyHelper.refundAddedMoney(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
                .getSuccessPageText(), false, frontEndEntity.getPromoCode());
    }


}
