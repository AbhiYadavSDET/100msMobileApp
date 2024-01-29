package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PipedGasHelper {


    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    MBReporter mbReporter;
    ElectricityPage electricityPage;
    PipedGasPage pipedGasPage;

    public PipedGasHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        permissionPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        electricityPage = new ElectricityPage(driver);
        pipedGasPage = new PipedGasPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void viewPipedGasBill(String brandName, String CA_number, String expTitle, String expUserName,String expSubTitle, String expMessage) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        //Click Allow using app for location action popup
        permissionPage.clickAllowWhileUsingApp();

        //Click on Home services tab
        pipedGasPage.clickHomeServices();

        Thread.sleep(2000);

        //Click on PipedGas option
        pipedGasPage.clickPipedGas();

        Thread.sleep(2000);

        //Click on See More if present
        if(electricityPage.isSeeMorePresent()){
            electricityPage.clickSeeMore();
        }

        if(pipedGasPage.isSavedPipedGasConnectionPresent()){
            //Click on saved connection
            pipedGasPage.clickSavedPipedGasConnection();
        }

        Thread.sleep(3000);

        //Check Bill is fetched or not
        if(!electricityPage.isBillFetched()) {

            // Verification on Enter amount screen
            String userName = electricityPage.getUserName();
            Log.info("User name Piped Gas bill : " + userName);
            mbReporter.verifyEqualsWithLogging(userName, expUserName, "Verify username on Bill", false, false, true);

            //Click on Pay button
            electricityPage.clickPay();

            //Verification on Payment confirmation screen
            String title = electricityPage.getTitle();
            Log.info("CN number on Bill : " + title);
            mbReporter.verifyEqualsWithLogging(title, expTitle, "Verify CN number on Bill", false, false, true);

            String subtitle = electricityPage.getSubTitle();
            Log.info("Brand Name on the Bill: " + subtitle);
            mbReporter.verifyEqualsWithLogging(subtitle, expSubTitle, "Verify Brand name on Bill", false, false, true);

            String amount = electricityPage.getBillPayment();
            Log.info("Amount on the Bill: " + amount);
            //mbReporter.verifyEqualsWithLogging(amount, expAmount, "Verify amount on Bill", false, false, true);


        }else{

            // Verification on Bill not fetched screen
            String message = electricityPage.getMessage();
            Log.info("Message on no bill due screen: " + message);
            mbReporter.verifyEqualsWithLogging(message, expMessage, "Verify message on no bill due screen", false, false, true);

            Log.info("Bill not present for given Connection number");
        }


    }
}
