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

public class PipedGasHelper {

    AndroidDriver<AndroidElement> driver;

        CCPage ccPage;
        MBReporter mbReporter;
        MBKCommonControlsHelper mbkCommonControlsHelper;
        LinkedHashMap<String, String> balanceBefore;
        ElectricityPage electricityPage;
        PipedGasPage pipedGasPage;

    public PipedGasHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        ccPage = new CCPage(driver);
        electricityPage = new ElectricityPage(driver);
        pipedGasPage = new PipedGasPage(driver);
        mbReporter = new MBReporter(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);


    }
    public void viewPipedGasBill(String expUserName, String expTitle, String expSubTitle, String brandName, String CA_number) throws IOException, InterruptedException {

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        //Click on Recharge and Pay Bill option
        ccPage.clickRechargeAndPayBills();

        // Click on outside Swipe Left Bottom Popup
        ccPage.clickSwipeLeftBottomRemove();

        //Click on Home services
        pipedGasPage.clickHomeServices();

        //Click on Piped Gas option
        pipedGasPage.clickPipedGas();

        //Click Search Piped Gas provider text box
        pipedGasPage.clickSearchPipedGasProvider();

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
        Thread.sleep(2000);

        if(electricityPage.isBillFetched()) {

            // Verification on Enter amount screen
            String userName = electricityPage.getUserName();
            Log.info("User name on Gas bill : " + userName);
            mbReporter.verifyEqualsWithLogging(userName, expUserName, "Verify username on Bill", false, false, true);

            String dueDate = electricityPage.getDueDate();
            Log.info(Log.ANSI_GREEN + "Due date on Gas Bill : " + dueDate + Log.ANSI_RESET);

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
            Log.info(Log.ANSI_GREEN  + "Amount on the Bill: " + amount + Log.ANSI_RESET);


        }else{
            Log.info(Log.ANSI_RED + "Bill not present for given CA number" + Log.ANSI_RESET);
        }

    }

    }

