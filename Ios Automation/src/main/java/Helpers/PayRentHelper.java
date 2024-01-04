package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.PayRentPage;
import Utils.Element;
import Utils.MBReporter;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

import java.io.IOException;

public class PayRentHelper {


    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PayRentPage payRentPage;
    MBReporter mbReporter;


    public PayRentHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        payRentPage = new PayRentPage(driver);

    }

    public void addNewPropertyOldUser(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException {

        payRentPage.clickOnpayRent();

        if (!isNewUser()) {

            payRentPage.clickOnAddNewProperty();

            payRentPage.enterBankAccountNumber(accountNumber);
          //  payRentPage.clickOnIfscCode();
            payRentPage.enterIfscCode(ifscCode);
            payRentPage.clickOnAcccountDetails();

            payRentPage.clickOnContinuebuttonOnAccountpage();

            payRentPage.enterLandLordName(name);
          //  payRentPage.clickOnRentAmount();
            payRentPage.enterRentAmount(amount);
            payRentPage.clickOnRentDetails();
            payRentPage.clickOnContinueBUttonOnLandlordPage();
        } else {

            Log.info("This is a new user, so skipping this test case");
        }
    }

    public void addNewPropertyNewUser(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException
        {

            payRentPage.clickOnpayRent();

            if (isNewUser()) {

                payRentPage.clickOnContinueOnZip();
                payRentPage.enterBankAccountNumber(accountNumber);
         //       payRentPage.clickOnIfscCode();
                payRentPage.enterIfscCode(ifscCode);
                payRentPage.clickOnAcccountDetails();

                payRentPage.clickOnContinuebuttonOnAccountpage();

                payRentPage.enterLandLordName(name);
          //      payRentPage.clickOnRentAmount();
                payRentPage.enterRentAmount(amount);
                payRentPage.clickOnRentDetails();
                payRentPage.clickOnContinueBUttonOnLandlordPage();
            } else {
                Log.info("This is an old user, so skipping this test case");


        }
    }
    public void addNewPropertyNewUserWithPan(String accountNumber, String ifscCode, String name, String amount,String panNumber) throws IOException, InterruptedException {


        payRentPage.clickOnpayRent();
        Thread.sleep(2000);

        if(isNewUser()){
            payRentPage.clickOnContinueOnZip();
        }else{
            payRentPage.clickOnAddNewProperty();
        }
        payRentPage.enterBankAccountNumber(accountNumber);

        payRentPage.enterIfscCode(ifscCode);
        payRentPage.clickOnAcccountDetails();

        payRentPage.clickOnContinuebuttonOnAccountpage();

        payRentPage.enterLandLordName(name);
   //     payRentPage.clickOnRentAmount();
        payRentPage.enterRentAmount(amount);


        if (Element.isElementPresent(driver, By.xpath("//XCUIElementTypeTextField[@name=\"Landlord PAN\"]"))){
            payRentPage.clickOnLandLordPanNumber();
            payRentPage.enterLandLordPanNumber(panNumber);
        }else if (Integer.parseInt(amount) <50000){
            Log.info("Pan card option is not available for this user because amount is less than 50000 Rs. ");
        } else {
            Log.info("Pan card option is not available for this user ");
        }
        payRentPage.clickOnRentDetails();
        Thread.sleep(2000);
        payRentPage.clickOnContinueBUttonOnLandlordPage();
    }


    public void addNewPropertyNewUserWithCouponCode(String accountNumber, String ifscCode, String name, String amount,String panNumber) throws IOException, InterruptedException {


        payRentPage.clickOnpayRent();
        Thread.sleep(2000);

        if(isNewUser()){
            payRentPage.clickOnContinueOnZip();
        }else{
            payRentPage.clickOnAddNewProperty();
        }
        payRentPage.enterBankAccountNumber(accountNumber);

        payRentPage.enterIfscCode(ifscCode);
        payRentPage.clickOnAcccountDetails();

        payRentPage.clickOnContinuebuttonOnAccountpage();

        payRentPage.enterLandLordName(name);
        //     payRentPage.clickOnRentAmount();
        payRentPage.enterRentAmount(amount);


        if (Element.isElementPresent(driver, By.xpath("//XCUIElementTypeTextField[@name=\"Landlord PAN\"]"))){
            payRentPage.clickOnLandLordPanNumber();
            payRentPage.enterLandLordPanNumber(panNumber);
        }else if (Integer.parseInt(amount) <50000){
            Log.info("Pan card option is not available for this user because amount is less than 50000 Rs. ");
        } else {
            Log.info("Pan card option is not available for this user ");
        }
        payRentPage.clickOnRentDetails();
       Thread.sleep(2000);
        payRentPage.clickOnApplyCouponbutton();
        Thread.sleep(2000);
        payRentPage.clickOnFirstCoupon();
        payRentPage.clickOnContinueBUttonOnLandlordPage();
    }

    //Common method to check if user is new or old on pay rent module
    public  boolean isNewUser() throws InterruptedException, IOException{

       return Element.isElementPresent(driver, By.xpath("//XCUIElementTypeStaticText[@name=\"Continue with Zip/Cards\"]")) ;

        }

    }


