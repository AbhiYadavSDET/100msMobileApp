package Checkout;

import Helpers.CheckoutHelper;
import Helpers.LoginHelper;
import Logger.Log;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;


public class CheckoutTest extends TestBase {

    @Test(groups = {"sanity", "xtraCheckout","regression"}, priority = 0, description = "Xtra Checkout test")
    public void Test01_xtraCheckoutFlow() throws IOException, InterruptedException {

        Log.info("======= START : Xtra Checkout test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CheckoutHelper checkoutHelper = new CheckoutHelper(getAndroidDriver());
        checkoutHelper.validateXtraCheckoutFlow("Select Your Bank", "Make Payment", "LDBX6900220000817633", "ICIC0000104", "Transactree Technologies Private Limited", "ICICI Bank Ltd", "CURRENT");


    }

    @Test(groups = {"sanity", "xtraCheckout","xtraCheckoutUpiMode","regression"}, priority = 0, description = "Xtra Checkout Upi Mode test")
    public void Test02_xtraCheckoutUpiModeFlow() throws IOException, InterruptedException {

        Log.info("======= START : Xtra Checkout test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        CheckoutHelper checkoutHelper = new CheckoutHelper(getAndroidDriver());
        checkoutHelper.validateXtraCheckoutUpiModeHandling("100000", "100001");

    }

    @Test(groups = {"sanity", "wapgCheckoutFlowCCBP","wapgCheckoutFlow","regression"}, priority = 0, description = "Wapg Checkout Flow CCBP test")
    public void Test03_wapgCheckoutFlowCCBP() throws IOException, InterruptedException {

        Log.info("======= START : WAPG CCBP Checkout test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        CheckoutHelper checkoutHelper = new CheckoutHelper(getAndroidDriver());
        checkoutHelper.wapgCheckoutFlowCCBP("4000", "4375517199762008");

    }

    @Test(groups = {"sanity", "wapgCheckoutFlowZipAutoPay","wapgCheckoutFlow","regression"}, priority = 0, description = "Wapg Checkout Flow Zip Auto Pay test")
    public void Test04_zipAutoPayCheckoutElectricityBillPayment() throws IOException, InterruptedException {

        Log.info("======= START : Wapg Checkout Flow Zip Auto Pay test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("7795709569", "547372");

        // Execute the test
        CheckoutHelper checkoutHelper = new CheckoutHelper(getAndroidDriver());
        checkoutHelper.zipAutoPayWidgetValidationBillPayments("ANJANA  JAIN","210736016179", "Kota Electricity Distribution Limited (KEDL)", "Kota Electricity Distribution Limited (KEDL)", "210736016179", "Enable ZIP autopay to pay bills automatically");

    }

    @Test(groups = {"sanity", "addMoneyCardDetails","regression"}, priority = 0, description = "Add Money Checkout Flow Card Details")
    public void Test05_addMoneyCardDetailsViewTest() throws IOException, InterruptedException {

        Log.info("======= START : Add Money Checkout Flow Card Details test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CheckoutHelper checkoutHelper = new CheckoutHelper(getAndroidDriver());
        checkoutHelper.addMoneyCheckoutCardViewsValidation("7000");
    }

    @Test(groups = {"sanity", "addMoneyConvFeeDetails","regression"}, priority = 0, description = "Add Money Checkout Flow Conv Fee Details")
    public void Test06_addMoneyConvFeeTest() throws IOException, InterruptedException {

        Log.info("======= START : Add Money Checkout Flow Conv Fee test =======");

        // Login to the account
        LoginHelper loginHelper = new LoginHelper(getAndroidDriver());
        loginHelper.quickLoginViaOtp("9205299330", "547372");

        // Execute the test
        CheckoutHelper checkoutHelper = new CheckoutHelper(getAndroidDriver());
        checkoutHelper.addMoneyCheckoutConvFeeValidation("7000");
    }




}
