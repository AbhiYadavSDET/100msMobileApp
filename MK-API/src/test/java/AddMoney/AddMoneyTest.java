package AddMoney;

import AddMoney.Api.AddMoneyWallet;
import AddMoney.Models.requestDto.CardBanking;
import AddMoney.Models.requestDto.PgV1Initiate2Dto;
import Insurance.Helper.InsuranceDetailsV2Helper;
import Utils.DatabaseSqlHelper;
import Utils.Log;
import Utils.RSAEncUtils;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class AddMoneyTest {


    Response response;
    InsuranceDetailsV2Helper insuranceDetailsV2Helper;
    DatabaseSqlHelper databaseSqlHelper = new DatabaseSqlHelper();

    @BeforeClass(alwaysRun = true)
    public void BeforeClass() {
        databaseSqlHelper.initiateMemberBalance();
    }


    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(Method method) {
        Log.info("****************:" + method.getName() + "****************");
    }


    // Constants
    String memberId = "9953138474@nocash.mobikwik.com";
    String auth = "/6hweSfR4OKwEHAm2alBUg==.idigoc531qvk7pjddsq2fjtqsr";
    String xMClient = "3";
    String acceptEncoding = "\n*";
    String deviceId = "4F8E8A745B5B61A066A90DCECB483672BA45650F";
    String encryptionPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsH2Oyz8FNu1WRV8xjMjfUpxlnQQi2rK89+KvBDNtkiZi95yJKkemA8f7EkpbQQyxdEVCyn5BMc8oscOgsyFoESA7Lyrprv6S7syHRdAumL/jGbeKg3CLydnIxN4vjxcQ6mRwCXYjlbL/2rGTwRHc3ROkO/JEiA13L3jTuXJqvUQSZ/J94H0WejW8Y2RtCqXi2sGsp2/tuqnblud63K99NI5YJekskr/MBoMItT/AbZSaHVyRCsQhAotDh3f93KkDYSapA1UlFu0vsvbpatjON3pkqu+4+yRlQs41fysrwz3fLQOO4MGhx6OSQFM9v9itRgEfx8KD28Wg7QOrpM28yQIDAQAB";


    @Test(groups = "addmoneyWallet", priority = 1)
    public void Test01_addmoney_wallet() {
        int count = 0;

        String amount = "10.0";
        String payMode = "CC";
        String cardCvv = "123";
        String savedCard = "true";
        String savedCardId = "bce8e4e1e66520cb0bc2bf3a0e760412d53273a844bf0931f2b3136a2ee0ada3";

        RSAEncUtils encUtils = new RSAEncUtils(encryptionPublicKey);

        CardBanking cardBanking = new CardBanking();
        cardBanking.setCardCvv(encUtils.encrypt(cardCvv));
        cardBanking.setSavedCardId(savedCardId);

        PgV1Initiate2Dto pgV1Initiate2Dto = new PgV1Initiate2Dto();
        pgV1Initiate2Dto.setAmount(amount);
        pgV1Initiate2Dto.setMemberId(memberId);
        pgV1Initiate2Dto.setIsSISetupFlow(false);
        pgV1Initiate2Dto.setClient(xMClient);
        pgV1Initiate2Dto.setDeviceId(deviceId);
        pgV1Initiate2Dto.setPayMode(payMode);
        pgV1Initiate2Dto.setCardBanking(cardBanking);

        AddMoneyWallet addMoneyWallet = new AddMoneyWallet(xMClient, auth, pgV1Initiate2Dto);
        response = addMoneyWallet.execute();

        System.out.println(response.getBody().asString());


    }


    public void update_balance(String memberId, String amount) {
        databaseSqlHelper.updateWalletMainBalance(memberId, amount);
    }


}
