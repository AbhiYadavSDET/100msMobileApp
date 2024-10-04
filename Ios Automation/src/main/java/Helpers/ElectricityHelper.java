package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ElectricityHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PermissionPage permissionPage;
    RechargePage rechargePage;
    MBReporter mbReporter;
    ElectricityPage electricityPage;

    public ElectricityHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        rechargePage = new RechargePage(driver);
        permissionPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        electricityPage = new ElectricityPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void viewElectricityBill(String brandName, String CA_number, String expTitle, String expUserName,String expSubTitle, String expMessage) throws InterruptedException, IOException {

        //Click Recharge and Pay Bills option
        homePage.clickRechargeAndPayBills();

        if(permissionPage.isEnablePermissionPopupPresent()) {
            //Allow loaction permission
            permissionPage.clickAllowWhileUsingApp();
        }

        //Click on Electricity option
        electricityPage.clickElectricity();

        Thread.sleep(2000);

        //Click on See More if present
        if(electricityPage.isSeeMorePresent()){
            electricityPage.clickSeeMore();
        }

        if(electricityPage.isSavedConnectionPresent()){
            //Click on saved connection
            electricityPage.clickSavedElectricityConnection();
        }

        Thread.sleep(3000);

/*
        //Click Search Electricity Brand field
        electricityPage.clickSearchElectricityBrand();

        //Enter Brand name in search text box
        electricityPage.enterSearchElectricityBrand(brandName);

        Thread.sleep(2000);

        //Select brand from list
        electricityPage.clickSelectBrand();

        //Click on CA number text box
        electricityPage.clickCaNumber();

        //Enter CA number in text field
        electricityPage.enterCaNumber(CA_number);

        //Click Continue CTA
        electricityPage.clickContinueButton();

 */

        //Check Bill is fetched or not
        if(!electricityPage.isBillFetched()) {

            // Verification on Enter amount screen
            String userName = electricityPage.getUserName();
            Log.info("User name electricity bill : " + userName);
            mbReporter.verifyEqualsWithLogging(userName, expUserName, "Verify username on Bill", false, false, true);


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

            //Click on Pay button
            electricityPage.clickPay();


        }else{

            // Verification on Bill not fetched screen
            String message = electricityPage.getMessage();
            Log.info("Message on no bill due screen: " + message);
            mbReporter.verifyEqualsWithLogging(message, expMessage, "Verify message on no bill due screen", false, false, true);

            Log.info("Bill not present for given CA number");
        }


    }
}
