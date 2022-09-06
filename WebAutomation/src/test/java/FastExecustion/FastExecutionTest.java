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
//        ExtentReport.EXTENTTEST = ExtentReport.EXTENTREPORT.createTest("Test_Sanity_Flow");

        LoginHelper loginHelper = new LoginHelper(getWebDriver());
        loginHelper.loginViaOtp("9818484290", "Udit Gupta", "uditgupta5j151@gmail.com", "9818484290");

//        AddMoneyHelper addMoneyHelper = new AddMoneyHelper(getWebDriver());
//        addMoneyHelper.addMoneyViaNewcard("5", "4799470274582974","07","2027", "443", "521991", "Money Added Successfully");

        TransactionHistoryHelper transactionHistoryHelper = new TransactionHistoryHelper(getWebDriver());
        transactionHistoryHelper.transactionHistoryHelper();

        GasHelper gasHelper = new GasHelper(getWebDriver());
        gasHelper.verifyGasBill("Adani Gas", "1000236410", "No Bills Found", "Adani Gas");

        DthHelper dthHelper = new DthHelper(getWebDriver());
        dthHelper.verifyInvalidDthBill("tata", "1043233392", "1");

        MyWalletHelper myWalletHelper = new MyWalletHelper(getWebDriver());
        myWalletHelper.myWalletDetails();

        OfferHelper offerHelper = new OfferHelper(getWebDriver());
        offerHelper.verifyOffers("makemytrip");

        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.aboutWebPage("https://www.mobikwik.com/about", "About us - Mobikwik | Recharge, Bill Payment & More",17);

//        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.blogWebPage("https://blog.mobikwik.com/", "MobiKwik - Who we Are, What we Think, What we Do.",9);

//        StaticWebPagesHelper staticWebPagesHelper = new StaticWebPagesHelper(getWebDriver());
        staticWebPagesHelper.pressWebPage("https://blog.mobikwik.com/category/press/pressreleases/", "Press Release Archives - MobiKwik",9);

        ElectricityHelper electricityHelper = new ElectricityHelper(getWebDriver());
        electricityHelper.verifyElectricityBill("Kota Electricity Distribution Limited (KEDL)", "210736016179");

        MoneyTransferHelper moneyTransferHelper = new MoneyTransferHelper(getWebDriver());
        moneyTransferHelper.p2p("9599155446", "Transfer Successful", "5");

        LandlineHelper landlineHelper = new LandlineHelper(getWebDriver());
        landlineHelper.verifyLandlineBill("MTNL Delhi","23693162", "2061533162");

        HelpHelper helpHelper = new HelpHelper(driver);
        helpHelper.help("This is a test ticket being raised by automation suite. In case you are reading this , Please close the ticket.-MobiKwik Team");

        ImpsHelper impsHelper = new ImpsHelper(getWebDriver());
        impsHelper.imps("Udit Gupta", "106207566006", "HSBC0411002","50");

        MobileHelper mobileHelper = new MobileHelper(getWebDriver());
        mobileHelper.verifyPrepaid("vodafone", "7795709569", "Delhi/NCR", "10", false, "", "","4799470274582974","07","2027", "443", "521991");


//        ElectricityHelper electricityHelper= new ElectricityHelper(getWebDriver());
//        electricityHelper.verifyElectricityBill("Kota Electricity Distribution Limited (KEDL)", "210736016179");

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
