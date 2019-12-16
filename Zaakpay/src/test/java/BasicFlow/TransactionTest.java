package BasicFlow;

import Helpers.RefundHelper;
import Helpers.TransactionApiHelper;
import Utils.TestBase;
import org.testng.annotations.Test;

public class TransactionTest extends TestBase {


    @Test(groups = {"basicFlowSanity"}, priority = 0, description = "Verify Transaction Flow via Credit Card using Amex")
    public void Test_Transaction_Via_Credit_Card_Amex() throws InterruptedException {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaCreditCard(TransactionApiHelper.flowType.AMEX, "mayank.suneja@gmail.com", "5", "340000000000009", "5", "2021", "0773", "The transaction was completed successfully.");
    }

    @Test(groups = {"basicFlowSanity"}, priority = 1, description = "Verify Transaction Flow via Credit Card using Hdfc")
    public void Test_Transaction_Via_Credit_Card_Hdfc() throws InterruptedException {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaCreditCard(TransactionApiHelper.flowType.HDFC, "mayank.suneja@gmail.com", "5", "4012888888881881", "12", "2021", "123", "The transaction was completed successfully.");
    }

    @Test(groups = {"basicFlowSanity"}, priority = 2, description = "Verify Transaction Flow via Credit Card using Cc Avenue")
    public void Test_Transaction_Via_Credit_Card_Cc_Avenue() throws InterruptedException {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaCreditCard(TransactionApiHelper.flowType.CCAVENUE, "mayank.suneja@gmail.com", "5", "4111111111111111", "12", "2021", "123", "The transaction was completed successfully.");
    }

    @Test(groups = {"basicFlowSanity"}, priority = 3, description = "Verify Transaction Flow via Credit Card using Cyber Source")
    public void Test_Transaction_Via_Credit_Card_Cyber_Source() throws InterruptedException {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaCreditCard(TransactionApiHelper.flowType.CYBERSOURCE, "mayank.suneja@gmail.com", "5", "4000000000000002", "12", "2021", "123", "The transaction was completed successfully.");
    }

    @Test(groups = {"basicFlowSanity", "refundFlowSanity"}, priority = 5, description = "Verify Refund Transaction", dependsOnMethods = "Test_Transaction_Via_Credit_Card_Amex")
    public void Test_Refund_Transaction() throws InterruptedException {

        RefundHelper refundHelper = new RefundHelper(driver);
        refundHelper.refundTransaction(TransactionApiHelper.transactionMap.get("orderId"), "14", "MerchantIdentifier not valid.");
    }

    @Test(groups = {"basicFlowSanity1"}, priority = 4, description = "Verify Transaction Flow via Net Banking")
    public void Test_Transaction_Via_Netbanking() throws InterruptedException {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaNetBanking("mayank.suneja@gmail.com", "5", "The transaction was completed successfully.");

    }

    //Transactioin via Paylater option

    @Test(groups = {"basicFlowSanity"}, priority = 0, description = "Verify Transaction Paylater option")
    public void Test_Transaction_via_Paylater_option1() throws InterruptedException {

        TransactionApiHelper transactionApiHelper = new TransactionApiHelper(driver);
        transactionApiHelper.transactionViaPaylaterOption("noopur.gupta@mobikwik.com", "9971518597","1234","The transaction was completed successfully.");
    }





}
