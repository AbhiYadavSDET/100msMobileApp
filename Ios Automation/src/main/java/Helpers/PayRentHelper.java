package Helpers;

import Logger.Log;
import PageObject.HomePage;
import PageObject.PayRentPage;
import PageObject.PermissionPage;
import PageObject.SecurityPinPage;
import Utils.Element;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;

public class PayRentHelper {

    IOSDriver<IOSElement> driver;
    HomePage homePage;
    PayRentPage payRentPage;
    MBReporter mbReporter;
    SecurityPinPage securityPinPage;
    PermissionPage permissionPage;

    Screen screen;
    String excpectedAmount = null;
    String actualAmount = null;
    boolean isNewUserTestStarted;


    public PayRentHelper(IOSDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        payRentPage = new PayRentPage(driver);
        securityPinPage = new SecurityPinPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        permissionPage = new PermissionPage(driver);
    }

    public void addNewPropertyOnPayRent(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException {

        clickOnPayRentOption();

        Thread.sleep(2000);

        if (payRentPage.isNewUser()) {
            Log.info("This is a new user flow on rent pay");
            isNewUserTestStarted = true;
            payRentPage.clickOnContinueOnZip();
        } else {
            Log.info("This is a old user flow on rent pay");
            payRentPage.clickOnAddNewProperty();
        }

        addNewProperties(accountNumber,ifscCode,name,amount,false);

    }
    public void addNewPropertyNewUser(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException
        {
            if(!isNewUserTestStarted) {
                clickOnPayRentOption();

                if (payRentPage.isNewUser()) {
                    Log.info("This is a new user flow on rent pay");
                    payRentPage.clickOnContinueOnZip();
                    addNewProperties(accountNumber,ifscCode,name,amount,false);
                } else {
                    deleteAllRecipient();
                    payRentPage.clickOnContinueOnZip();
                   // clickOnPayRentOption();
                    addNewProperties(accountNumber, ifscCode, name, amount,false);
                }
            }else{
                Log.info("New user flow has been already tested for adding new property .. ");
            }
    }

    public void verifyConvFeeOnPayRent(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException {

        clickOnPayRentOption();

        if (payRentPage.isNewUser()) {
            Log.info("This is a new user flow on rent pay");
            payRentPage.clickOnContinueOnZip();
        }else{
            Log.info("This is a old user flow on rent pay");
            payRentPage.clickOnAddNewProperty();
        }

        addNewProperties(accountNumber,ifscCode,name,amount,false);
        mbReporter.verifyEqualsWithLogging(actualAmount, excpectedAmount, "Verify Conv fee  on Pay Rent", false, false, false);
    }

    public void addNewPropertyWithPan(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException {

        clickOnPayRentOption();

        if (payRentPage.isNewUser()) {
            Log.info("This is a new user flow on rent pay");
            payRentPage.clickOnContinueOnZip();
        }else{
            Log.info("This is a old user flow on rent pay");
            payRentPage.clickOnAddNewProperty();
        }

        addNewProperties(accountNumber,ifscCode,name,amount,false);

    }

    public void addNewPropertyWithCouponCode(String accountNumber, String ifscCode, String name, String amount) throws IOException, InterruptedException {

        clickOnPayRentOption();
        if (payRentPage.isNewUser()) {
            Log.info("This is a new user flow on rent pay");
            payRentPage.clickOnContinueOnZip();
        }else{
            Log.info("This is a old user flow on rent pay");
            payRentPage.clickOnAddNewProperty();
        }

        addNewProperties(accountNumber,ifscCode,name,amount,true);
         }

    public void faqOnRentPay() throws IOException, InterruptedException {

        clickOnPayRentOption();

        Thread.sleep(2000);

        if (payRentPage.isNewUser()) {
            payRentPage.clickOnFaq();
        } else {
            payRentPage.clickOnSavedRecipient();
            payRentPage.clickOnFaq();
        }
             }
    public void deleteRecipientOnRentPay() throws IOException, InterruptedException {

        clickOnPayRentOption();
        Thread.sleep(2000);


        if (payRentPage.isNewUser()) {
            payRentPage.clickOnContinueOnZip();
            addNewProperties("135701525113","ICIC0001431","Abhishek yadav","5000",false);

            clickOnPayRentOption();
            if(payRentPage.isSavedRecipientAvailable()){
                payRentPage.clickOnDeleteButton();
                Thread.sleep(2000);
                payRentPage.clickOnDelete();

            }else{
                Log.info("No Saved Recipient available so skipping this test case.. ");
            }
        } else {
            payRentPage.clickOnDeleteButton();
            Thread.sleep(2000);
            payRentPage.clickOnDelete();
        }
    }

    public void clickOnPayRentOption() throws InterruptedException {
        if(payRentPage.isPayRentVisibleOnHomeScreen()){
            homePage.clickOnpayRent();
        }else{
            homePage.clickAllServices();
            if(!payRentPage.isPayRentVisibleOnHomeScreen()) {
                Log.info("Swipe up to get Pay rent option on all services");
                Screen.swipeUp(driver);
            }
            homePage.clickOnpayRent();
        }
    }

    public void upiOptionOnRentPay() throws InterruptedException, IOException {
        clickOnPayRentOption();
        Thread.sleep(2000);

        if (payRentPage.isNewUser()) {
            Log.info("This is a new user flow on rent pay");
            Thread.sleep(2000);
            payRentPage.clickOnUPI();

            if(permissionPage.isPermissionPopUpPresent()){
                permissionPage.clickOnAllow();
            }

            String actualTitle = payRentPage.getTtileOnUPIPage();
            mbReporter.verifyEqualsWithLogging(actualTitle, "Send Money via UPI", "Verify upi page is opening via pay rent module .. ", false, false, false);

        }else{
            Log.info("This is a old user flow on rent pay");
            payRentPage.clickOnSavedRecipient();
            payRentPage.clickOnUPI();

            if(permissionPage.isPermissionPopUpPresent()){
                permissionPage.clickOnAllow();
            }

            String rupeesText = payRentPage.getRupeesTextOnUPIPage();
            mbReporter.verifyEqualsWithLogging(rupeesText,"Continue","Continue button on UPI page",false,false,false);
        }
    }

    public void deleteAllRecipient() throws InterruptedException {
        while (payRentPage.isSavedRecipientAvailable()){
            Log.info("Saved recipient is available on rent pay .. ");
            payRentPage.clickOnDeleteButton();
            Thread.sleep(2000);
            payRentPage.clickOnDelete();
            Thread.sleep(3000);
        }
    }

    public String  calculateConv(String amount){
Integer amounts = Integer.parseInt(amount);
        Log.info("Expected total amount = "+(int) (amounts + (amounts * 1.76/100)));
        Integer amountCalculated = (int) (amounts + (amounts * 1.76/100));

         excpectedAmount = String.valueOf(amountCalculated);;

        return excpectedAmount;
    }

    public String actualConv() throws InterruptedException {
    Log.info("Actual total amount calculation start");
       String finalAmount = payRentPage.getFinalAmountOnCheckout();
        Log.info("Final Amount text = "+finalAmount);
     String doubleAmount = finalAmount.split("₹")[1];
     Log.info("Double Amount ="+doubleAmount);
     StringBuilder sb = new StringBuilder();

     for(int i = 0; i< doubleAmount.length();i++){
         if(doubleAmount.charAt(i)=='.'){
             break;
         }
         if(doubleAmount.charAt(i)!=',') {
             sb.append(doubleAmount.charAt(i));
         }

        }
     Log.info("Actual Aamount = "+ sb.toString());
    actualAmount = sb.toString();
     return  actualAmount;
    }

    public void addNewProperties(String accountNumber,String ifscCode,String name,String amount, boolean isCouponCodeRequired) throws InterruptedException, IOException {

        payRentPage.enterBankAccountNumber(accountNumber);
        payRentPage.enterIfscCode(ifscCode);
        payRentPage.clickOnAcccountDetails();

        payRentPage.clickOnContinuebuttonOnAccountpage();

        payRentPage.enterLandLordName(name);

        payRentPage.enterRentAmount(amount);

        if (payRentPage.isLandlordButtonAvailableOnScreen()) {
            payRentPage.clickOnLandLordPanNumber();
            payRentPage.enterLandLordPanNumber("DSOPP3157C");
        } else if (Integer.parseInt(amount) < 50000) {
            Log.info("Pan card option is not available for this user because amount is less than 50000 Rs. ");
        } else {
            Log.info("Pan card option is not applicable for this user ");
        }
        payRentPage.clickOnRentDetails();
        Thread.sleep(2000);

        if(isCouponCodeRequired){
            payRentPage.clickOnApplyCouponbutton();
            Thread.sleep(2000);
            payRentPage.clickOnFirstCoupon();
        }
        payRentPage.clickOnContinueButtonOnLandlordPage();

        Thread.sleep(2000);

        if(securityPinPage.isSecurityPinPageShown())
        {
            securityPinPage.enterSecurityPin();
        }
        Thread.sleep(4000);
        calculateConv(amount);
        actualConv();
        screen.tapOutsideBottomSheetByCoordinates(driver);
        Thread.sleep(3000);
        payRentPage.pressBackFromTransaction();
        payRentPage.pressBackFromTransaction();

        if(!payRentPage.isBckButtonAvailableOnPitchScreen()){
            payRentPage.pressBackButtonFromRecipientPage();
        }
        payRentPage.pressBackFromPitchScreen();
    }
    }


