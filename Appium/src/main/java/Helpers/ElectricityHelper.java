package Helpers;

import Logger.Log;
import PageObject.*;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.LinkedHashMap;

public class ElectricityHelper {
    AndroidDriver<AndroidElement> driver;
    RechargePage rechargePage;
    CCPage ccPage;
    LoginPage loginPage;
    HomePage homePage;
    PermissionPage permissionsPage;
    Screen screen;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    LinkedHashMap<String, String> balanceBefore;
    LinkedHashMap<String, String> balanceAfter;
    SyncEmailBottomSheet syncEmailBottomSheet;
    ElectricityPage electricityPage;


    public ElectricityHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargePage = new RechargePage(driver);
        ccPage = new CCPage(driver);
        electricityPage = new ElectricityPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        permissionsPage = new PermissionPage(driver);
        mbReporter = new MBReporter(driver);
        securityPinPage = new SecurityPinPage(driver);
        syncEmailBottomSheet = new SyncEmailBottomSheet(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
    }

    public void viewElectricityBill(String expUserName, String expDueDate, String expTitle, String expSubTitle, String expAmount, String brandName, String CA_number) throws IOException, InterruptedException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

       // Click on All services
        electricityPage.clickAllServices();

        //Click on Electricity option
        electricityPage.clickElectricity();

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

        //Check Bill is fetched or not
        if(electricityPage.isBillFetched()) {

            // Verification on Enter amount screen
            String userName = electricityPage.getUserName();
            Log.info("User name electricity bill : " + userName);
            mbReporter.verifyEqualsWithLogging(userName, expUserName, "Verify username on Bill", false, false, true);

            String dueDate = electricityPage.getDueDate();
            Log.info("Due date on Electricity Bill : " + dueDate);
            // mbReporter.verifyEqualsWithLogging(dueDate, expDueDate, "Verify Due date on Electricity Bill", false, false, true);

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
            Log.info("Bill not present for given CA number");
        }

    }


}

