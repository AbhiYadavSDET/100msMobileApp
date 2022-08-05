package FastExecustion;

import Helpers.*;
import Helpers.Recharge.*;
import Utils.ExtentReport;
import Utils.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class FastExecutionTest extends TestBase {


    @Test(groups = {"sanityFlow"}, priority = 0, description = "Verify Sanity Flow on Web")
    public void Test_Sanity_Flow() throws InterruptedException, IOException {
        // Start the test
        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Test_Sanity_Flow");

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("9205299330" ,"mobi testu", "mkwik9330@gmail.com", "9205299330");

        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
        addMoneyHelper.addMoneyViaNewcard("5", "4799470274582974","07","2027", "443", "521991", "Money Added Successfully");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPrepaid("vodafone", "7795709569", "Delhi/NCR", "10", false, "", "","4799470274582974","07","2027", "443", "521991");

        LandlineHelper landlineHelper = new LandlineHelper(getWebDriver());
        landlineHelper.verifyLandlineBill("BSNL Landline - Individual", "1010097738");

        ElectricityHelper electricityHelper= new ElectricityHelper(getWebDriver());
        electricityHelper.verifyElectricityBill("Kota Electricity Distribution Limited (KEDL)", "210736016179");

//        CcbpHelper ccbpHelper= new CcbpHelper(getWebDriver());
//        ccbpHelper.payCreditCardBill("","1");
//
//        BankTransferHelper bankTransferHelper = new BankTransferHelper(getWebDriver());
//        bankTransferHelper.bankTransfer("Paraj Jain", "218101502680", "ICIC0002181", "50", "Money sent successfully");
//
//        MoneyTransferHelper moneyTransferHelper = new MoneyTransferHelper(getWebDriver());
//        moneyTransferHelper.p2p("9414065033", "Transfer Successful", "5");
//
//        OfferHelper offerHelper = new OfferHelper(getWebDriver());
//        offerHelper.verifyOffers("makemytrip");
//
//        HelpHelper helpHelper = new HelpHelper(driver);
//        helpHelper.help("This is a test ticket being raised by automation suite. In case you are reading this , Please close the ticket.-MobiKwik Team");











    }


}
