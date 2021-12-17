package Helpers;

import PageObject.LoginPage;
import PageObject.RechargeBillPage;
import Utils.Config;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RechargeHelper {

    AndroidDriver<AndroidElement> driver;
    RechargeBillPage rechargeBillPage;

    @AndroidFindBy(xpath="//*[@text='Skip']")
    private AndroidElement checkSkip;

    @AndroidFindBy(xpath="//*[@text='Allow only while using the app']")
    private AndroidElement checkLocationAccess;

    @AndroidFindBy(xpath="//*[@text='View Details']")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(xpath="//*[@text='Login/Signup']")
    private AndroidElement checkLoginSignupButton;

    @AndroidFindBy(xpath="//*[@text='Enter Mobile Number']")
    private AndroidElement enterNumber;

    @AndroidFindBy(xpath="//android.view.ViewGroup[2]/android.view.View[2]")
    private AndroidElement checkSwipLeftPopUp;

    @AndroidFindBy(xpath="//*[@text='NONE OF THE ABOVE']")
    private AndroidElement noneOfAboveButton;

    @AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    private AndroidElement getBalance;

    @AndroidFindBy(xpath="//*[@text='Select a Coupon']")
    private AndroidElement checkCouponPage;

    @AndroidFindBy(xpath="//*[@text='Confirm Payment']")
    private AndroidElement checkPaymentPage;

    String applySupercash="Apply Supercash";

    public RechargeHelper(AndroidDriver<AndroidElement> driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void viewRechargeBill(String number,String operatorType, String operatorName, String circle, String amount,String coupon,String pin) throws InterruptedException {


        Thread.sleep(8000);
        String test;
        String[] dataBefore;
        double balanceBefore,balanceAfter ;
        // Check for logged in user
        if(Elements.isElementPresent(driver,checkViewDetails)){
            rechargeBillPage=new RechargeBillPage(driver);
            //Getting balance before transaction
            test= Elements.getText(driver,getBalance);
            dataBefore= test.split("₹");
            balanceBefore=Double.parseDouble(dataBefore[1]);

            rechargeBillPage.clickHomeTab();
            rechargeBillPage.clickRechargePayBill();
            //Check for Swipe left blue popup
            Elements.waitForElementToVisibleOnPage(driver,checkSwipLeftPopUp,2);
            if(Elements.isElementPresent(driver,checkSwipLeftPopUp)){
                rechargeBillPage.clickSwipPopUp();
            }
            //Check for new user or old user
            if(Elements.isElementPresent(driver,enterNumber)){
                rechargeBillPage.enterMobileNumber(number);
                rechargeBillPage.clickContinue();
            }else {
                rechargeBillPage.clickMobileButton();
                rechargeBillPage.enterMobileNumber(number);
                rechargeBillPage.selectNumber();
            }
            Elements.waitForElementToVisibleOnPageUsingText(driver,operatorName,2);
            //check for asking operator and circle
            if(Elements.isElementPresent(driver,operatorName)){
                rechargeBillPage.selectOperator(operatorName);
                rechargeBillPage.selectCircle(circle);
            }
            //Check for Prepaid and Postpaid
            if(rechargeBillPage.checkOperatorType(operatorType)){
                rechargeBillPage.changeType();
                rechargeBillPage.clickYes();
            }
            //Check for amount screen or no dues screen
            if(rechargeBillPage.checkResultScreen(number)) {
                rechargeBillPage.enterAmount(amount);
                rechargeBillPage.clickNextCTA();
                rechargeBillPage.clickConfirm();

                //Check for coupon code
                if(!coupon.equals("")){
                    rechargeBillPage.clickApplyCoupon();
                    if(coupon.contains(applySupercash)){
                        rechargeBillPage.clickApplySupercash();
                    }else{
                        rechargeBillPage.enterCouponCode(coupon);
                        rechargeBillPage.clickApplyButton();
                        if(Elements.isElementPresent(driver,checkCouponPage)){
                            Config.info("-------------Entered coupon is invalid-------------");
                            Assert.assertTrue(false);
                        }else if(Elements.isElementPresent(driver,checkPaymentPage)){
                            Config.info("Coupon applied");
                        }else{
                            Config.info("-------------Error occurred----------------");
                            Assert.assertTrue(false);
                        }

                    }
                    //Check for coupon code and supercash
                    if(coupon.contains(applySupercash)){
                        rechargeBillPage.checkSupercashApplied();
                    }else{
                        rechargeBillPage.checkCouponApplied(coupon);
                    }
                }

                rechargeBillPage.clickPayButton();
                rechargeBillPage.enterSecurityPin(pin);
                //Check details on final screen
                rechargeBillPage.checkPaymentScreen();

                //Getting balance after transaction and comparing
                test = Elements.getText(driver, getBalance);
                dataBefore = test.split("₹");
                balanceAfter = Double.parseDouble(dataBefore[1]);
                if (balanceBefore - balanceAfter == Double.parseDouble(amount)) {
                    Config.info("Balance deduction is correct");
                } else {
                    Config.info("Balance deduction is incorrect");
                }

            }

        }else{
            Config.logComment("Please Login/Signup and than continue");
        }

    }


    public void viewRechargeBillWithLogout(String number, String operatorType, String operatorName, String circle, String amount,String coupon, String pin) throws InterruptedException {
        int flag=0;
        Thread.sleep(8000);
        String test;
        String[] dataBefore;
        double balanceBefore,balanceAfter ;
        rechargeBillPage=new RechargeBillPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //Check for location access
        if(Elements.isElementPresent(driver,checkLocationAccess)){
            rechargeBillPage.clickLocationAccess();

        }
        //Checking user is logged out or not
        if(Elements.isElementPresent(driver,checkSkip)){
            rechargeBillPage.clickSkip();
            flag=1;
            //Check for location access
            if(Elements.isElementPresent(driver,checkLocationAccess)){
                rechargeBillPage.clickLocationAccess();

            }

        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            flag=1;
        }else if(Elements.isElementPresent(driver,checkViewDetails)){
            rechargeBillPage.openSideDrawr();
            rechargeBillPage.clickAccounts();
            rechargeBillPage.clickLogout();
            flag=1;

        }
        if(flag==1){
            rechargeBillPage.clickHomeTab();

            test= Elements.getText(driver,getBalance);
            dataBefore= test.split("₹");
            balanceBefore=Double.parseDouble(dataBefore[1]);

            rechargeBillPage.clickRechargePayBill();
            //Check for Swipe left blue popup
            Elements.waitForElementToVisibleOnPage(driver,checkSwipLeftPopUp,2);
            if(Elements.isElementPresent(driver,checkSwipLeftPopUp)){
                rechargeBillPage.clickSwipPopUp();
            }
            //Check for new user or old user
            if(Elements.isElementPresent(driver,enterNumber)){
                rechargeBillPage.enterMobileNumber(number);
                rechargeBillPage.clickContinue();
            }
            Elements.waitForElementToVisibleOnPageUsingText(driver,operatorName,2);
            //check for asking operator and circle
            if(Elements.isElementPresent(driver,operatorName)){
                rechargeBillPage.selectOperator(operatorName);
                rechargeBillPage.selectCircle(circle);
            }
            if(rechargeBillPage.checkOperatorType(operatorType)){
                rechargeBillPage.changeType();
                rechargeBillPage.clickYes();
            }
            //Check for amount screen or no dues screen
            if(rechargeBillPage.checkResultScreen(number)) {
                rechargeBillPage.enterAmount(amount);
                rechargeBillPage.clickNextCTA();
                rechargeBillPage.clickConfirm();
                rechargeBillPage.clickPayButton();

                if(Elements.isElementPresent(driver,noneOfAboveButton)) {
                    loginPage.clickNoneOfAbove();
                }
                loginPage.enterMobileNum(number);
                loginPage.clickSendOtpbutton();

                //Check for coupon code
                if(!coupon.equals("")){
                    rechargeBillPage.clickApplyCoupon();
                    if(coupon.contains(applySupercash)){
                        rechargeBillPage.clickApplySupercash();
                    }else{
                        rechargeBillPage.enterCouponCode(coupon);
                        rechargeBillPage.clickApplyButton();
                        if(Elements.isElementPresent(driver,checkCouponPage)){
                            Config.info("-------------Entered coupon is invalid-------------");
                            Assert.assertTrue(false);
                        }else if(Elements.isElementPresent(driver,checkPaymentPage)){
                            Config.info("Coupon applied");
                        }else{
                            Config.info("-------------Error occurred----------------");
                            Assert.assertTrue(false);
                        }

                    }
                    //Check for coupon code and supercash
                    if(coupon.contains(applySupercash)){
                        rechargeBillPage.checkSupercashApplied();
                    }else{
                        rechargeBillPage.checkCouponApplied(coupon);
                    }
                }

                rechargeBillPage.clickPayButton();
                rechargeBillPage.enterSecurityPin(pin);
                //Check details on final screen
                rechargeBillPage.checkPaymentScreen();

                //Getting balance after transaction and comparing
                test = Elements.getText(driver, getBalance);
                dataBefore = test.split("₹");
                balanceAfter = Double.parseDouble(dataBefore[1]);
                if (balanceBefore - balanceAfter == Double.parseDouble(amount)) {
                    Config.info("Balance deduction is correct");
                } else {
                    Config.info("Balance deduction is incorrect");
                }
            }
        }

    }
}
