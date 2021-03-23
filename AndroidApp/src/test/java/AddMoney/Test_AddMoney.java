package AddMoney;

import Helpers.AddMoneyHelper;
import Helpers.LoginHelper;
import UITestFramework.CreateSession;
//import dbutil.mysql.automationtest.front_end_automation.entity.FrontEndEntity;
import logger.Log;
import org.json.JSONException;
import org.testng.annotations.Test;
//import utils.DatabaseSqlHelper;

import java.io.IOException;

public class Test_AddMoney extends CreateSession {

//    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();


    @Test(groups = {"addMoneyNetBanking", "addMoneySanity"}, priority = 0, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    public void Test01_netbanking() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaNumber("9205299330", "547372");
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());


        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
//        addmoneyHelper.netbanking(frontEndEntity.getAmount(), frontEndEntity.getBankName(), frontEndEntity.getBankPageLocator(), frontEndEntity.getBankPageLocatorType());
    }


//    @Test(groups = {"addMoneyNewCard", "addMoneySanity", "addMoneySanity2021"}, priority = 1, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    @Test(groups = {"addMoneyNewCard", "addMoneySanity", "addMoneySanity2021"}, priority = 1)
    public void Test02_addMoneyNewCard() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());

//        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        loginHelper.quickLoginViaNumber("9205299330", "547372");
        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
//        addmoneyHelper.addMoneyViaNewCard(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
//                .getSuccessPageText());
        addmoneyHelper.addMoneyViaNewCard("5","4363931800224460", "12", "22", "239", "Paraj@1234", "Thanks", "Money Added Successfully");

    }

//    @Test(groups = {"addMoneySavedCard", "addMoneySanity", "addMoneySanity2021"}, priority = 2, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    @Test(groups = {"addMoneySavedCard", "addMoneySanity", "addMoneySanity2021"}, priority = 2)
    public void Test03_addMoneySavedCard() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        loginHelper.quickLoginViaNumber("9205299330", "547372");
//        Log.info("Password : " + frontEndEntity.getPassword());

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
//        addmoneyHelper.addMoneyViaSavedCard(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
//                .getSuccessPageText(), false, frontEndEntity.getPromoCode());
        addmoneyHelper.addMoneyViaSavedCard("5","4363 XXXX XXXX 4460", "12", "22", "239", "Paraj@1234", "Payment Successful", "Money added into your wallet successfully", false, "NULL");


    }

//    @Test(groups = {"addMoneySavedCardWithPromo", "addMoneySanity", "addMoneySanity2021"}, priority = 3, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    @Test(groups = {"addMoneySavedCardWithPromo", "addMoneySanity", "addMoneySanity2021"}, priority = 3)
    public void Test04_addMoneySavedCardWithPromo() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        loginHelper.quickLoginViaNumber("9205299330", "547372");

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
//        addmoneyHelper.addMoneyViaSavedCard(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
//                .getSuccessPageText(), true, frontEndEntity.getPromoCode());
        addmoneyHelper.addMoneyViaSavedCard("5","4363 XXXX XXXX 4460", "12", "22", "239", "Paraj@1234", "Payment Successful", "Money added into your wallet successfully", true, "addtst5m");

    }

//    @Test(groups = {"addMoneyRefund", "addMoneySanity", "addMoneySanity2021"}, priority = 4, dataProvider = "addMoneyData", dataProviderClass = AddMoneyProviderClass.class)
    @Test(groups = {"addMoneyRefund", "addMoneySanity", "addMoneySanity2021"}, priority = 4)
    public void Test05_addMoneyRefund() throws IOException, JSONException, InterruptedException {
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
//        loginHelper.quickLoginViaEmail(frontEndEntity.getUserName(), frontEndEntity.getPassword());
//        loginHelper.quickLoginViaEmail("8447405515@nocash.mobikwik.com", "priyanka123");
        loginHelper.quickLoginViaNumber("9205299330", "547372");
//        Log.info("Password : " + frontEndEntity.getPassword());

        AddMoneyHelper addmoneyHelper = new AddMoneyHelper(getAndroidDriver());
//        addmoneyHelper.refundAddedMoney(frontEndEntity.getAmount(), frontEndEntity.getCardNo(), frontEndEntity.getExpiryMonth(), frontEndEntity.getExpiryYear(), frontEndEntity.getCvv(), frontEndEntity.getCardPassword(), frontEndEntity.getSuccessPageStatus(), frontEndEntity
//                .getSuccessPageText(), false, frontEndEntity.getPromoCode());
        addmoneyHelper.refundAddedMoney("6","4363 XXXX XXXX 4460", "12", "22", "239", "Paraj@1234", "Payment Successful", "Money added into your wallet successfully", false, "NULL");

    }


}
