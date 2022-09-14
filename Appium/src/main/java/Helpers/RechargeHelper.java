package Helpers;

import PageObject.*;
import utils.MBReporter;
import utils.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;

public class RechargeHelper {

    //############################ Udit start ################################
    AndroidDriver<AndroidElement> driver;
    RechargePage rechargeBillPage;
    LoginPage loginPage;
    HomePage homePage;
    PermissionPage permissionsPage;
    SideDrawerPage sideDrawerPage;

    // Login and home page elements

    @AndroidFindBy(id = "skip")
    private AndroidElement checkSkip;

    @AndroidFindBy(id = "login_signup")
    private AndroidElement checkLoginSignupButton;

    @AndroidFindBy(id = "cancel")
    private AndroidElement noneOfAboveButton;

    @AndroidFindBy(id = "tx_balance")
    private AndroidElement getBalance;

    @AndroidFindBy(id = "tx_add_money")
    private AndroidElement checkViewDetails;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    private AndroidElement contactPermission;

    // Permission elements

    @AndroidFindBy(id = "permission_allow_foreground_only_button")
    private AndroidElement checkLocationAccess;

    // Recharge elements

    @AndroidFindBy(id = "view_curved")
    private AndroidElement checkSwipLeftPopUp;

    @AndroidFindBy(xpath="//*[@text='Enter Mobile Number']")
    private AndroidElement enterNumber;

    @AndroidFindBy(xpath="//*[@text='Select a Coupon']")
    private AndroidElement checkCouponPage;

    @AndroidFindBy(xpath="//*[@text='Confirm Payment']")
    private AndroidElement checkPaymentPage;

    @AndroidFindBy(id = "supercash_value")
    private AndroidElement checkSupercashDeduct;

    String applySupercash="Apply Supercash";

    //############################ Udit end ################################

    //############################ Old start ################################

//    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
//    RechargePage rechargePage;
    PermissionHelper permissionHelper;
//    AddMoneyHelper addMoneyHelper;
    TransactionHistoryPage transactionHistoryPage;

    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;

    //############################ Old end ################################

    public RechargeHelper(AndroidDriver<AndroidElement> driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        rechargeBillPage=new RechargePage(driver);
        loginPage = new LoginPage(driver);
        homePage=new HomePage(driver);
        permissionsPage=new PermissionPage(driver);
        sideDrawerPage=new SideDrawerPage(driver);
        permissionHelper=new PermissionHelper(driver);
        mbkCommonControlsHelper=new MBKCommonControlsHelper(driver);
        mbReporter=new MBReporter(driver);
    }

    //############################ Udit start ################################
    public void rechargeBill(String number,String operatorType, String operatorName, String circle, String amount,String coupon,String pin) throws InterruptedException {


        Thread.sleep(8000);
        String test;
        String[] dataBefore,testArray;
        double balanceBefore,balanceAfter ;
        // Check for logged in user
        if(Elements.isElementPresent(driver,getBalance)){
            //Getting balance before transaction
            test= Elements.getText(driver,getBalance);
            dataBefore= test.split("₹");
            balanceBefore=Double.parseDouble(dataBefore[1]);
            System.out.println(balanceBefore);

            //Check insufficient balance
            if(balanceBefore >= Double.parseDouble(amount)) {
                Config.logComment("Sufficient balance");
                homePage.clickHomeTab();
                homePage.clickRechargePayBill();
                //Check for Swipe left blue popup
                Elements.waitForElementToVisibleOnPage(driver, checkSwipLeftPopUp, 2);
                if (Elements.isElementPresent(driver, checkSwipLeftPopUp)) {
                    rechargeBillPage.clickSwipPopUp();
                }
                //Check for new user or old user
                if (Elements.isElementPresent(driver, enterNumber)) {
                    rechargeBillPage.enterMobileNumber(number);
                    rechargeBillPage.clickContinue("Recharge");
                } else {
                    rechargeBillPage.clickMobileButton();
                    //Check contact permission
                    Elements.waitForElementToVisibleOnPage(driver, contactPermission, 2);
                    if(Elements.isElementPresent(driver,contactPermission)){
                        rechargeBillPage.giveContactPermission();
                    }
                    rechargeBillPage.enterMobileNumber(number);
                    rechargeBillPage.selectNumber();
                }
                Elements.waitForElementToVisibleOnPageUsingText(driver, operatorName, 2);
                //check for asking operator and circle
                if (Elements.isElementPresent(driver, operatorName)) {
                    rechargeBillPage.selectOperator(operatorName);
                    rechargeBillPage.selectCircle(circle);
                }
                //Check for Prepaid and Postpaid
                if (rechargeBillPage.checkOperatorType(operatorType)) {
                    rechargeBillPage.changeType();
                    rechargeBillPage.clickYes();
                }
                //Check for amount screen or no dues screen
                if (rechargeBillPage.checkResultScreen(number)) {
                    rechargeBillPage.enterAmount(amount);
                    rechargeBillPage.clickNextCTA();
                    rechargeBillPage.clickConfirm();

                    //Check for coupon code
                    if (!coupon.equals("")) {
                        rechargeBillPage.clickApplyCoupon();
                        if (coupon.contains(applySupercash)) {
                            rechargeBillPage.clickApplySupercash();
                        } else {
                            rechargeBillPage.enterCouponCode(coupon);
                            rechargeBillPage.clickApplyButton();
                            if (Elements.isElementPresent(driver, checkCouponPage)) {
                                Config.info("-------------Entered coupon is invalid-------------");
                                Assert.assertTrue(false);
                            } else if (Elements.isElementPresent(driver, checkPaymentPage)) {
                                Config.info("Coupon applied");
                            } else {
                                Config.info("-------------Error occurred----------------");
                                Assert.assertTrue(false);
                            }

                        }
                        //Check for coupon code and supercash
                        if (coupon.contains(applySupercash)) {
                            rechargeBillPage.checkSupercashApplied();
                            // Check supercash deduct amount
                            test = Elements.getText(driver, checkSupercashDeduct);
                            testArray = test.split("₹");
                            balanceBefore = balanceBefore + Double.parseDouble(testArray[1]);
                            System.out.println(balanceBefore);
                        } else {
                            rechargeBillPage.checkCouponApplied(coupon);
                        }
                    }

                    rechargeBillPage.clickPayButton();
                    rechargeBillPage.enterSecurityPin(pin);
                    //Check details on final screen
                    rechargeBillPage.checkPaymentScreen(number,amount);

                    //Getting balance after transaction and comparing
                    test = Elements.getText(driver, getBalance);
                    dataBefore = test.split("₹");
                    balanceAfter = Double.parseDouble(dataBefore[1]);
                    if (balanceBefore - balanceAfter == Double.parseDouble(amount)) {
                        Config.info("Balance deduction is correct");
                    } else {
                        Config.info("Balance deduction is incorrect");
                        Assert.assertTrue(false,"Wrong balance deduction");
                    }

                }
            }else{
                Config.logComment("Insufficient balance");
                Assert.assertTrue(false,"Don't have sufficient balance");
            }

        }else{
            Config.logComment("Please Login/Signup and than continue");
            Assert.assertTrue(false,"App is in logged out state");
        }

    }
    public void viewWater() throws InterruptedException {

        homePage.clickAllServicesTab("Water");
        rechargeBillPage.clickMoreButtonWater();
        rechargeBillPage.clickWaterButton();
//        rechargeBillPage.enterOperatorGas(operatorName);
//        rechargeBillPage.selectOperatorGas();
//        rechargeBillPage.enterBPNumberGas(BP_Number);
//        rechargeBillPage.clickContinue("Gas");
//        rechargeBillPage.checkResultScreenGas(operatorName);

    }

    public void viewBills(String number,String operatorType, String operatorName, String circle) throws InterruptedException, IOException {
        Thread.sleep(8000);
        String test;
        String[] dataBefore,testArray;
        double balanceBefore,balanceAfter ;
        // Check for logged in user
        if(Elements.isElementPresent(driver,getBalance)){

                homePage.clickHomeTab();
                homePage.clickRechargePayBill();
                //Check for Swipe left blue popup
                Elements.waitForElementToVisibleOnPage(driver, checkSwipLeftPopUp, 2);
                if (Elements.isElementPresent(driver, checkSwipLeftPopUp)) {
                    rechargeBillPage.clickSwipPopUp();
                }
                //Check for new user or old user
                if (Elements.isElementPresent(driver, enterNumber)) {
                    rechargeBillPage.enterMobileNumber(number);
                    rechargeBillPage.clickContinue("Recharge");
                } else {
                    rechargeBillPage.clickMobileButton();
                    //Check contact permission
                    Elements.waitForElementToVisibleOnPage(driver, contactPermission, 2);
                    if(Elements.isElementPresent(driver,contactPermission)){
                        rechargeBillPage.giveContactPermission();
                    }
                    rechargeBillPage.enterMobileNumber(number);
                    rechargeBillPage.selectNumber();
                }
                Elements.waitForElementToVisibleOnPageUsingText(driver, operatorName, 2);
                //check for asking operator and circle
                if (Elements.isElementPresent(driver, operatorName)) {
                    rechargeBillPage.selectOperator(operatorName);
                    rechargeBillPage.selectCircle(circle);
                }
                //Check for Prepaid and Postpaid
                if (rechargeBillPage.checkOperatorType(operatorType)) {
                    rechargeBillPage.changeType();
                    rechargeBillPage.clickYes();
                }
                //Check for amount screen or no dues screen
                rechargeBillPage.checkAmountScreen();
                rechargeBillPage.backToHomeScreen();

                //Checking for Electricity
            Config.logComment("*************************************Start for Electricity Bill*************************************");
            for(int i=1;i<=2;i++) {
                String[] data = Excel.readData(i,"Electricity");
//            String[] excelData = data.split(" split ");
//                data[0]=BP number , data[1]=Operator name
                homePage.clickAllServicesTab("Electricity");
                rechargeBillPage.clickElectricityButtonElectricity();
                rechargeBillPage.enterBoardElectricity(data[1]);
                rechargeBillPage.selectBoardElectricity();
                rechargeBillPage.enterNumberElectricity(data[0]);
                rechargeBillPage.clickContinue("Electricity");
                rechargeBillPage.checkAmountScreen();
                rechargeBillPage.backToHomeScreen();
            }
            Config.logComment("*************************************End for Electricity Bill*************************************");

            //Checking for Gas
            Config.logComment("*************************************Start for Gas Bill*************************************");
            for(int i=1;i<=2;i++) {
                String[] data = Excel.readData(i,"Gas");
//            String[] excelData = data.split(" split ");
//                data[0]=BP number , data[1]=Operator name
                homePage.clickAllServicesTab("Gas");
                rechargeBillPage.clickMoreButtonGas();
                rechargeBillPage.clickPipedGasButtonGas();
                rechargeBillPage.enterOperatorGas(data[1]);
                rechargeBillPage.selectOperatorGas();
                rechargeBillPage.enterBPNumberGas(data[0]);
                rechargeBillPage.clickContinue("Gas");
                rechargeBillPage.checkResultScreenGas(operatorName);
                rechargeBillPage.backToHomeScreen();
            }
            Config.logComment("*************************************End for Gas Bill*************************************");


        }else{
            Config.logComment("Please Login/Signup and than continue");
            Assert.assertTrue(false,"App is in logged out state");
        }


    }


    public void rechargeBillWithLogout(String number, String operatorType, String operatorName, String circle, String amount,String coupon, String pin) throws InterruptedException {
        int flag=0;
        Thread.sleep(8000);
        String test;
        String[] dataBefore,testArray;
        double balanceBefore,balanceAfter ;
        //Check for location access
        if(Elements.isElementPresent(driver,checkLocationAccess)){
            permissionsPage.clickLocationAccess();

        }
        //Checking user is logged out or not
        if(Elements.isElementPresent(driver,checkSkip)){
            homePage.clickSkip();
            flag=1;
            //Check for location access
            if(Elements.isElementPresent(driver,checkLocationAccess)){
                permissionsPage.clickLocationAccess();

            }

        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            flag=1;
        }else if(Elements.isElementPresent(driver,checkViewDetails)){
            homePage.openSideDrawr();
            sideDrawerPage.clickAccounts();
            rechargeBillPage.clickLogout();
            flag=1;

        }
        if(flag==1){
            loginPage.clickLoginSignup();
            if(Elements.isElementPresent(driver,noneOfAboveButton)) {
                loginPage.clickNoneOfAbove();
            }
            loginPage.enterMobileNum(number);
            loginPage.clickSendOtpbutton();
            loginPage.clickHistoryTab();

            homePage.clickHomeTab();

            test= Elements.getText(driver,getBalance);
            dataBefore= test.split("₹");
            balanceBefore=Double.parseDouble(dataBefore[1]);

            if(balanceBefore >= Double.parseDouble(amount)) {
                homePage.clickRechargePayBill();
                //Check for Swipe left blue popup
                Elements.waitForElementToVisibleOnPage(driver, checkSwipLeftPopUp, 2);
                if (Elements.isElementPresent(driver, checkSwipLeftPopUp)) {
                    rechargeBillPage.clickSwipPopUp();
                }
                //Check for new user or old user
                if (Elements.isElementPresent(driver, enterNumber)) {
                    rechargeBillPage.enterMobileNumber(number);
                    rechargeBillPage.clickContinue("Recharge");
                }
                Elements.waitForElementToVisibleOnPageUsingText(driver, operatorName, 2);
                //check for asking operator and circle
                if (Elements.isElementPresent(driver, operatorName)) {
                    rechargeBillPage.selectOperator(operatorName);
                    rechargeBillPage.selectCircle(circle);
                }
                if (rechargeBillPage.checkOperatorType(operatorType)) {
                    rechargeBillPage.changeType();
                    rechargeBillPage.clickYes();
                }
                //Check for amount screen or no dues screen
                if (rechargeBillPage.checkResultScreen(number)) {
                    rechargeBillPage.enterAmount(amount);
                    rechargeBillPage.clickNextCTA();
                    rechargeBillPage.clickConfirm();
                    rechargeBillPage.clickPayButton();


                    //Check for coupon code
                    if (!coupon.equals("")) {
                        rechargeBillPage.clickApplyCoupon();
                        if (coupon.contains(applySupercash)) {
                            rechargeBillPage.clickApplySupercash();
                        } else {
                            rechargeBillPage.enterCouponCode(coupon);
                            rechargeBillPage.clickApplyButton();
                            if (Elements.isElementPresent(driver, checkCouponPage)) {
                                Config.info("-------------Entered coupon is invalid-------------");
                                Assert.assertTrue(false);
                            } else if (Elements.isElementPresent(driver, checkPaymentPage)) {
                                Config.info("Coupon applied");
                            } else {
                                Config.info("-------------Error occurred----------------");
                                Assert.assertTrue(false);
                            }

                        }
                        //Check for coupon code and supercash
                        if (coupon.contains(applySupercash)) {
                            rechargeBillPage.checkSupercashApplied();
                            // Check supercash deduct amount
                            test = Elements.getText(driver, checkSupercashDeduct);
                            testArray = test.split("₹");
                            balanceBefore = balanceBefore + Double.parseDouble(testArray[1]);
                            System.out.println(balanceBefore);
                        } else {
                            rechargeBillPage.checkCouponApplied(coupon);
                        }
                    }

                    rechargeBillPage.clickPayButton();
                    rechargeBillPage.enterSecurityPin(pin);
                    //Check details on final screen
                    rechargeBillPage.checkPaymentScreen(number,amount);

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
                Config.logComment("Insufficient balance");
            }
        }

    }

    public void viewElectricityBill(String BP_Number, String operatorName) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,getBalance)){
            homePage.clickAllServicesTab("Electricity");
            rechargeBillPage.clickElectricityButtonElectricity();
            rechargeBillPage.enterBoardElectricity(operatorName);
            rechargeBillPage.selectBoardElectricity();
            rechargeBillPage.enterNumberElectricity(BP_Number);
            rechargeBillPage.clickContinue("Electricity");
            rechargeBillPage.checkResultScreenElectricity(operatorName);
        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            Config.logComment("Please Login/Signup and than continue");
        }
    }

    public void viewGasBill(String BP_Number, String operatorName) throws InterruptedException {


        Thread.sleep(8000);
        if(Elements.isElementPresent(driver,checkViewDetails)){
            homePage.clickAllServicesTab("Gas");
            rechargeBillPage.clickMoreButtonGas();
            rechargeBillPage.clickPipedGasButtonGas();
            rechargeBillPage.enterOperatorGas(operatorName);
            rechargeBillPage.selectOperatorGas();
            rechargeBillPage.enterBPNumberGas(BP_Number);
            rechargeBillPage.clickContinue("Gas");
            rechargeBillPage.checkResultScreenGas(operatorName);
        }else if(Elements.isElementPresent(driver,checkLoginSignupButton)){
            Config.logComment("Please Login/Signup and than continue");
        }
    }
    //############################ Udit end ################################

    //############################ Old start ################################

    public void prepaidRecharge(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException, IOException, IOException {
        Thread.sleep(8000);

        balanceBefore = mbkCommonControlsHelper.getBalance();     //Udit -Have to change code

        homePage.clickOnRechargeLayout();

        if (Element.isElementPresent(driver, By.id("view_curved"))) { //Added by udit
            rechargeBillPage.clickSwipPopUp();
        }

        homePage.clickOnMobileButton();

        permissionHelper.permissionAllow();

        rechargeBillPage.enterMobileNo(mobileNo);

//        rechargeBillPage.clickOnDropDown();
//
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text='Operators']"));
//        screen.swipeUpMedium(driver);
//        rechargeBillPage.selectOperator();
//
//        Element.waitForVisibility(driver, By.id("cir_name"));
//        rechargeBillPage.selectCircle();
//
//        rechargeBillPage.clickOnSeeAllPlans();
//
//        boolean seeAllPlans = Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'TOPUP']"));
//
//        mbReporter.verifyTrueWithLogging(seeAllPlans, "Plans Page loaded", true, true);
//
//        rechargeBillPage.clickOnBackButtonPlansPage();
//
//        Thread.sleep(300);
//
        rechargeBillPage.selectAmount();

        mbkCommonControlsHelper.handleRechargeAmountKeyboard(amount);

        rechargeBillPage.clickOnContinue();

        rechargeBillPage.clickOnConfirmAmountPageCta();

        // Apply coupon code if applicable
        if (promoCodeStatus) {
            mbkCommonControlsHelper.applyPromoCodeRecharge(promoCode);
        }

        mbkCommonControlsHelper.uncheckInsuranceCta(); // To Remove insurance

        rechargeBillPage.clickOnCtaCotinue(); // Not waiting for without extra wait

        mbkCommonControlsHelper.handleSecurityPin(securityPin);


        for(int i=0; i<6; i++){

            if(Element.isElementPresent(driver, By.xpath("//*[@id='common_header']//*[@id='title']"))){
                Log.info("Success Page");
                break;

            }else{

                Thread.sleep(1000);
                i++;

            }

        }



        // Wait for the success screen

        Element.waitForVisibility(driver, By.xpath("//*[@id='common_header']//*[@id='title']"));

        mbkCommonControlsHelper.handleCTOverlay();
        mbReporter.verifyEqualsWithLogging(rechargeBillPage.getSuccessPageStatus(), trxStatus, "Success Page | Verify Status", false, false);

        // Assertions on the success screen

        if(Element.isElementPresent(driver, By.id("cn_value") )) {
            mbReporter.verifyEqualsWithLogging(rechargeBillPage.getSuccessPageConnectionNo(), mobileNo, "Success Page | Verify Connection number", false, false);
        }

//        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Category']/following::android.widget.TextView[1]"))) {
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageCategory(), category, "Success Page | Verify category", false, false);
//        }

        if(Element.isElementPresent(driver, By.id("operator"))) {
            mbReporter.verifyEqualsWithLogging(rechargeBillPage.getSuccessPageOperator().toLowerCase(), operator.toLowerCase(), "Success Page | Verify operator", false, false);
        }

        if(Element.isElementPresent(driver, By.id("amount"))) {
            mbReporter.verifyEqualsWithLogging(rechargeBillPage.getSuccessPageAmount().replace("X", ""), amount, "Success Page | Verify amount", false, false);
        }

//        if(Element.isElementPresent(driver, By.id("total_amount_value"))) {
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageTotalPayment().replace("₹ ", ""), totalPayment, "Success Page | Verify totalPayment", false, false);
//        }

        // Assert the Success page in case promo code is applied
        if (promoCodeStatus) {
            String actualPromoCodeText = rechargeBillPage.getPromoCodeTextOnSuccessScreen();
            String expectedPromoCodeText = "Congrats! SuperCash worth " + promoCodeText + " will be credited within 48 hours";
            mbReporter.verifyEqualsWithLogging(actualPromoCodeText, expectedPromoCodeText, "After TRX | Verify Promo Code Text", false, false);

        }

        mbkCommonControlsHelper.returnToHomePageFromRechargeSuccessScreen();

        balanceAfter = mbkCommonControlsHelper.getBalance();

        // Post TRX assertions
        Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
        Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
        Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;

        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
        mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);

    }
//
//    //Pallavi Work
//    public void postpaidRecharge(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException, IOException, JSONException {
//        Thread.sleep(2000);
//
//        balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickOnMobileButton();
//        permissionHelper.permissionAllow();
//
//        rechargePage.selectPostpaidnoSavedContact();
//        Thread.sleep(300);
//        rechargePage.enterTextClick();
//        rechargePage.enterPostpaidAmount("1");
//        Thread.sleep(300);
//        rechargePage.selectAmount();
//        rechargePage.enterAmount(amount);
//        Thread.sleep(300);
//        mbkCommonControlsHelper.handleRechargeAmountKeyboard(amount);
//        rechargePage.clickOnContinue();
//        Thread.sleep(300);
//        rechargePage.clickOnConfirmAmountPageCta();
//        Thread.sleep(1000);
//        Element.waitForVisibility(driver, By.id("total_amount_label"));
//        rechargePage.clickOnCtaCotinue();
//        Thread.sleep(1000);
//        mbkCommonControlsHelper.handleSecurityPin(securityPin);
//        for (int i = 0; i < 6; i++) {
//            if (Element.isElementPresent(driver, By.id("base_status_icon_animation"))) {
//                Log.info("Success Page");
//                break;
//            } else {
//                Thread.sleep(1000);
//                i++;
//            }
//        }
//        // Wait for the success screen
//        Element.waitForVisibility(driver, By.id("base_status_icon_animation"));
//        mbkCommonControlsHelper.handleCTOverlay();
//        mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageStatus(), trxStatus, "Success Page | Verify Status", false, false);
//        // Assertions on the success screen
//        if (Element.isElementPresent(driver, By.id("cn_value"))) {
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageConnectionNo(), mobileNo, "Success Page | Verify Connection number", false, false);
//        }
//
//        if (Element.isElementPresent(driver, By.id("operator"))) {
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageOperator().toLowerCase(), operator.toLowerCase(), "Success Page | Verify operator", false, false);
//        }
//        if (Element.isElementPresent(driver, By.id("amount"))) {
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessPageAmount().replace("X", ""), amount, "Success Page | Verify amount", false, false);
//        }
//
//        mbkCommonControlsHelper.returnToHomePageFromRechargeSuccessScreenBackButton();
//        rechargePage.clickOnPopupCross();
//        balanceAfter = mbkCommonControlsHelper.getBalance();
//        // Post TRX assertions
//        Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
//        Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
//        Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
//        Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;
//        mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
//        mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);
//    }
//
//
//    //Pallavi Work
//    public void viewBillElectricity(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException, IOException, JSONException {
//        Thread.sleep(2000);
//
//        balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickElectricityButton();
//        permissionHelper.permissionAllow();
//        rechargePage.dropdownElectricityfirstOpClick();
//        Thread.sleep(300);
//
//        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='No dues']"))) {
//
//            rechargePage.clickOnElectricityBackIcon();
//            rechargePage.clickOnElectricityBackIcon();
//            // Post TRX assertions
//            balanceAfter = mbkCommonControlsHelper.getBalance();
//            // Post TRX assertions
//            Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
//            Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
//            Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
//            Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;
//            mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
//            mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);
//        } else {
//
//            // Assertions on the success screen
//            String actualBillPaymentText = rechargePage.getBillPaymentText();
//            String expectedBillPaymentText = "Bill Payment for";
//            String actualElectricityScreenReminerText = rechargePage.getElectricityBillreminderText();
//            mbReporter.verifyEqualsWithLogging(rechargePage.getElectricityBillPageStatus(), trxStatus, "Preview Amount age| Verify Status", false, false);
//            mbReporter.verifyEqualsWithLogging(actualElectricityScreenReminerText, "Remind me for forthcoming bill payments", "Preview electricity Screen reminder text", false, false);
//            mbReporter.verifyEqualsWithLogging(actualBillPaymentText, expectedBillPaymentText, "Bill Payment Text Verification", false, false);
//            rechargePage.clickOnElectricityBackIcon();
//            Thread.sleep(300);
//            rechargePage.clickOnElectricityBackIcon();
//            Thread.sleep(300);
//            rechargePage.clickOnPopupCross();
//            // Post TRX assertions
//            balanceAfter = mbkCommonControlsHelper.getBalance();
//
//            Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
//            Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
//            Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
//            Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;
//            mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
//            mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);
//
//
//        }
//    }
//
//    //PK
//    public void viewBillGas(String mobileNo, String amount, String category, String operator, String totalPayment, String trxStatus, String securityPin, Boolean promoCodeStatus, String promoCode, String promoCodeText) throws InterruptedException, IOException, JSONException {
//        Thread.sleep(2000);
//
//        balanceBefore = mbkCommonControlsHelper.getBalance();
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickGasIcon();
//        permissionHelper.permissionAllow();
//        rechargePage.clickGasFirstOperator();
//        Element.waitForVisibility(driver, By.id("tv_title"));
//        rechargePage.enterGasConnectionNo("PD01RNV1208");
//        rechargePage.clickGasContinueCta();
//
//
//        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='No dues']"))) {
//            rechargePage.clickOnElectricityBackIcon();
//            Thread.sleep(300);
//            rechargePage.clickOnElectricityBackIcon();
//            Thread.sleep(400);
//            rechargePage.clickOnElectricityBackIcon();
//            ;
//            rechargePage.clickOnPopupCross();
//
//            // Post TRX assertions
//            balanceAfter = mbkCommonControlsHelper.getBalance();
//            // Post TRX assertions
//            Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
//            Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
//            Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
//            Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;
//            mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
//            mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);
//
//        } else {
//            // Assertions on the success screen
//            String actualBillPaymentText = rechargePage.getBillPaymentText();
//            String actualSuccessScreenAmount = rechargePage.getPreSuccessScreenAmount().replace(",", "");
//            System.out.println("amount" + actualSuccessScreenAmount);
//            String expectedBillPaymentText = "Bill Payment for";
//            mbReporter.verifyEqualsWithLogging(actualBillPaymentText, expectedBillPaymentText, "Bill Payment Text Verification", false, false);
//            mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);
//
//            rechargePage.clickOnElectricityBackIcon();
//            Thread.sleep(300);
//            rechargePage.clickOnElectricityBackIcon();
//            Thread.sleep(400);
//            rechargePage.clickOnElectricityBackIcon();
//            rechargePage.clickOnPopupCross();
//            // Post TRX assertions
//            balanceAfter = mbkCommonControlsHelper.getBalance();
//            // Post TRX assertions
//            Double actualMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
//            Double actualMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100;
//            Double expectedMainBalance = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(amount) * 100;
//            Double expectedMoneyAdded = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MONEYADDED)) * 100 - Double.parseDouble(amount) * 100;
//            mbReporter.verifyEqualsWithLogging(actualMainBalance, expectedMainBalance, "After TRX | Verify Main Balance", false, false);
//            mbReporter.verifyEqualsWithLogging(actualMoneyAdded, expectedMoneyAdded, "After TRX | Verify Money Added", false, false);
//
//        }
//    }
//
//    public void postpaidPayment(String mobileNo, String popupError, String popupText, String operator) throws InterruptedException, IOException, JSONException {
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
//
//            screen.swipeUpMedium(driver);
//        }
//
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickOnMobileButton();
//        permissionHelper.permissionAllow();
//        rechargePage.enterMobileNo(mobileNo);
//        Thread.sleep(3000);
//
//        rechargePage.clickOnCtaContinue2();
//        Thread.sleep(10000);
//
//        if (!(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'No dues']")))) {
//
//            String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
//            String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
//            String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();
//
//            mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
//            mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
//            mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);
//
//            mbkCommonControlsHelper.clickUpButton();
//            mbkCommonControlsHelper.clickUpButton();
//        } else {
//            Log.info("No dues");
//            // Assertions
//
//            if (Element.isElementPresent(driver, By.id("title_text"))) {
//
//                String actualPopupError = rechargePage.getPopupError();
//                mbReporter.verifyEqualsWithLogging(actualPopupError, "Error", "Popup | Error message", false, false);
//
//            }
//
//            if (Element.isElementPresent(driver, By.id("body_text"))) {
//
//                String actualPopupText = rechargePage.getPopupText();
//                mbReporter.verifyEqualsWithLogging(actualPopupText, "No dues", "Popup | Message", false, false);
//
//            }
//
//            rechargePage.clickOnPopupCross();
//
//            mbkCommonControlsHelper.clickUpButton();
//            mbkCommonControlsHelper.clickUpButton();
//        }
//
//
//    }
//
//    public void postpaidPaymentViaSavedConnection(String mobileNo, String popupText, String category, String operator, String successScreenOperatorText) throws InterruptedException, IOException, JSONException {
//
//        //balanceBefore = mbkCommonControlsHelper.getBalance();
////        homePage.clickOnCrossButton();
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
//
//            screen.swipeUpMedium(driver);
//        }
//
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickOnMobileButton();
//
//        permissionHelper.permissionAllow();
//
//
//        if (selectSavedConnection(mobileNo, category, operator)) {
//
//            Thread.sleep(10000);
//
//            if (!(Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = 'No dues']")))) {
//
//                String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
//                String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
//                String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();
//
//                mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, successScreenOperatorText, "Success Page | Verify Operator", false, false);
//                mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
//                mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);
//
//                mbkCommonControlsHelper.clickUpButton();
//                mbkCommonControlsHelper.clickUpButton();
//            } else {
//                Log.info("No dues");
//                // Assertions
//                String viewBillText = rechargePage.getViewBillText();
//
//                mbReporter.verifyEqualsWithLogging(viewBillText, "No dues", "ViewBill | text", false, false);
//
//
////                rechargePage.clickOnPopupCross();
//
//                mbkCommonControlsHelper.clickUpButton();
//                mbkCommonControlsHelper.clickUpButton();
//            }
//
//
//        } else {
//            Log.info("The saved connection is not present");
//
//
//        }
//
//
//    }
//
//    public void rechargeDthInvalidAmount(String mobileNo, String amount, String securityPin, String errorMessage) throws InterruptedException, IOException, JSONException, TesseractException {
//
//        //balanceBefore = mbkCommonControlsHelper.getBalance();
////        homePage.clickOnCrossButton();
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
//
//            screen.swipeUpMedium(driver);
//        }
//
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickOnDthButton();
//
//        permissionHelper.permissionAllow();
//        Thread.sleep(5000);
//        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = '" + mobileNo + "']"))) {
//            AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + mobileNo + "']"));
//            Element.selectElement(driver, androidElement, "Select Saved Connection");
//
//            rechargePage.enterDthAmount(amount);
//
//            rechargePage.clickOnDthContinueCta();
//
//            rechargePage.clickOnCtaCotinue();
//
//            mbkCommonControlsHelper.handleSecurityPin(securityPin);
//
//            Thread.sleep(3000);
//            String path = mbReporter.screenShot1("toast", "rechargeInvalidAmount");
//            Log.info(path);
//            String[] text = screen.readToastMessage("screenshots/toast", path).split("\\r?\\n");
//            int len = text.length;
//
//            for (String e : text) {
//                Log.info(e);
//            }
//            String actualErrorText = text[len - 2] + text[len - 1];
//            mbReporter.verifyEqualsWithLogging(actualErrorText, errorMessage, "Verify Error Message", false, false);
//        } else {
//            Log.info("Connection not present");
//        }
//
//    }
//
//    public boolean selectSavedConnection(String mobileNo, String category, String operator) throws InterruptedException {
//
//
//        for (int i = 0; i < 3; i++) {
//            if (Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"))) {
//                Log.info("SCROLL", "Screen");
//                Screen.swipeUpMedium(driver);
//
//                Log.info("SELECT", "Saved Connection");
//                AndroidElement androidElement = element.findElement(driver, By.xpath("//*/android.widget.TextView[@text = '7795709569 | Postpaid, Vodafone']"));
//                Element.selectElement(driver, androidElement, "Select Connection");
//                return true;
//            } else {
//                Screen.swipeUpMedium(driver);
//                Thread.sleep(2000);
//            }
//        }
//
//        return false;
//    }
//
//
//    public void viewBillGas(String operator, String mobileNo) throws InterruptedException, IOException, JSONException {
//
//        //balanceBefore = mbkCommonControlsHelper.getBalance();
////        homePage.clickOnCrossButton();
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
//
//            screen.swipeUpMedium(driver);
//        }
//
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickGasIcon();
//
//        permissionHelper.permissionAllow();
//
//        rechargePage.clickOnDropDown();
//
//        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = '" + operator + "']"))) {
//            rechargePage.selectOperator(operator);
//        } else {
//            screen.swipeUpMedium(driver);
//            rechargePage.selectOperator(operator);
//        }
//
//        rechargePage.enterBpNumber(mobileNo);
//
//        rechargePage.clickOnCtaContinue2();
//        Thread.sleep(6000);
//        if (!(Element.isElementPresent(driver, By.xpath("//*/android.widget.TextView[@text = 'No dues']")))) {
//
//            String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
//            String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
//            String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();
//
//            mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
//            mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, mobileNo, "Success Page | Verify Number", false, false);
//            mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);
//
//            mbkCommonControlsHelper.clickUpButton();
//            mbkCommonControlsHelper.clickUpButton();
//        } else {
//            Log.info("No dues");
//            // Assertions
////            String actualPopupError = rechargePage.getPopupError();
//            String actualPopupText = rechargePage.getPopupText();
//
////            mbReporter.verifyEqualsWithLogging(actualPopupError, "Error", "Popup | Error message", false, false);
//            mbReporter.verifyTrueWithLogging(actualPopupText != null, "Popup | " + actualPopupText + "", false, false);
//
//
//            rechargePage.clickOnPopupCross();
//
//            mbkCommonControlsHelper.clickUpButton();
//            mbkCommonControlsHelper.clickUpButton();
//        }
//
//    }
//
//    public void viewBillMtnlDelhi(String operator, String telephoneNo) throws InterruptedException, IOException, JSONException {
//
//        //balanceBefore = mbkCommonControlsHelper.getBalance();
//
//        String[] arr = telephoneNo.split("\\|");
//        String expectedtelephoneNo = arr[arr.length - 2];
//        String expectedCan = arr[arr.length - 1];
////        homePage.clickOnCrossButton();
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
//
//            screen.swipeUpMedium(driver);
//        }
//
//
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickLandlineIcon();
//
//        permissionHelper.permissionAllow();
//
//        rechargePage.clickOnDropDown();
//
//        rechargePage.selectOperator(operator);
//
//        rechargePage.enterTelephoneNumber(expectedtelephoneNo);
//
//        rechargePage.enterCanNumber(expectedCan);
//
//        rechargePage.clickOnCtaContinue2();
//
//        String actualSuccessScreenOperator = rechargePage.getSuccessScreenOperator();
//        String actualSuccessScreenNumber = rechargePage.getSuccessScreenNumber();
//        String actualSuccessScreenAmount = rechargePage.getSuccessScreenAmount();
//
//        mbReporter.verifyEqualsWithLogging(actualSuccessScreenOperator, operator, "Success Page | Verify Operator", false, false);
//        mbReporter.verifyEqualsWithLogging(actualSuccessScreenNumber, expectedCan, "Success Page | Verify Telephone Number", false, false);
//        mbReporter.verifyTrueWithLogging(Double.parseDouble(actualSuccessScreenAmount) > 0, "Success Page | Verify Amount greater than 0", false, false);
//
//        mbkCommonControlsHelper.clickUpButton();
//        mbkCommonControlsHelper.clickUpButton();
//
//    }
//
//    public void creditCardRechargeFlow(String amount, String securityPin, String cardNo, String cvv, String bankPassword, String success_page_status, Boolean promoCodeStatus, String promoCode, String payMode) throws InterruptedException, IOException, JSONException {
//
//        //balanceBefore = mbkCommonControlsHelper.getBalance();
////        homePage.clickOnCrossButton();
//
//        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
//
//        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
//
//            screen.swipeUpMedium(driver);
//        }
//
//        homePage.clickOnRechargeLayout();
//        rechargePage = homePage.clickCreditCardIcon();
//
//        permissionHelper.permissionAllow();
//
//        rechargePage.selectCreditCardFromSavedConnection();
//
//        mbkCommonControlsHelper.handleRechargeAmountKeyboard(amount);
//
//        rechargePage.submitCreditCardAmount();
//
////        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Credit Card Bill']"));
//
//        rechargePage.clickOnCreditCardContinueCta();
//
//        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"));
//
//        // Apply coupon code if applicable
//        if (promoCodeStatus) {
//            mbkCommonControlsHelper.applyPromoCodeRecharge(promoCode);
//        }
//
//        rechargePage.clickOnCtaCotinue();
//
//        if(payMode == "WAPG"){
//
//            rechargePage.selectWalletAsPgFlow();
//            Double finalAmount=Double.parseDouble(amount);
//
//            mbkCommonControlsHelper.handleSecurityPin(securityPin);
//
//            Thread.sleep(4000);
//
//            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Select Payment Mode']"))) {
//                addMoneyHelper = new AddMoneyHelper(driver);
//                addMoneyHelper.addMoneyInsufficientFunds(cardNo, cvv, bankPassword);
//                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Select Payment Mode']")), "Add money Page opened , and insuffcient flow validated, As currently Add money not Working by Test Card", true, true);
//
//            }
//
//            Element.waitForVisibility(driver, By.id("base_title"));
//
//
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success, WAPG transaction was success", true, true);
//
//            String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("₹ ", "");
//
//            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, false);
//
//            String actualPendingDescription = rechargePage.getPendingDescMessage();
//
//            mbReporter.verifyTrueWithLogging(actualPendingDescription!=null, ""+actualPendingDescription+"", true, false);
//
//
//            if (promoCodeStatus) {
//
//                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);
//            }
//
//            mbkCommonControlsHelper.returnToHomePageFromCCBPSuccessScreen();
//
//            homePage.closeRechargeServicesOverlay();
//
//            transactionHistoryPage=homePage.clickOnBottomBarHistory();
//
//            mbReporter.verifyEqualsWithLogging(finalAmount, Double.parseDouble(transactionHistoryPage.getLatestHistoryRecordAmount()), "Verify Amount Deducted After transaction", true, false);
//
//            Thread.sleep(300);
//
//
//
//
//        }else {
//            rechargePage.clickOnWhyCta();
//            mbReporter.verifyTrueWithLogging(rechargePage.isWhyPageOpened(), "Why Page Opened", false, false);
//            rechargePage.clickOnOK();
//            Double feeAmount=Double.parseDouble(rechargePage.getFeesAmount());
//            rechargePage.selectWalletFlowWithConvFee();
//            Double finalAmount=Double.parseDouble(amount)+feeAmount;
//            mbkCommonControlsHelper.handleSecurityPin(securityPin);
//
//            Thread.sleep(4000);
//
//            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Select Payment Mode']"))) {
//                addMoneyHelper = new AddMoneyHelper(driver);
//                addMoneyHelper.addMoneyInsufficientFunds(cardNo, cvv, bankPassword);
//            }
//
//            Element.waitForVisibility(driver, By.id("base_title"));
//
//
//            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success, WAPG transaction was success", true, false);
//
//            String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("X", "");
//
//            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, false);
//
//            String actualPendingDescription = rechargePage.getPendingDescMessage();
//
//            mbReporter.verifyTrueWithLogging(actualPendingDescription!=null, ""+actualPendingDescription+"", true, false);
//
//
//            if (promoCodeStatus) {
//
//                mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);
//            }
//
//            mbkCommonControlsHelper.returnToHomePageFromCCBPSuccessScreen();
//
//            homePage.closeRechargeServicesOverlay();
//
//            transactionHistoryPage=homePage.clickOnBottomBarHistory();
//
//            mbReporter.verifyEqualsWithLogging(finalAmount, Double.parseDouble(transactionHistoryPage.getLatestHistoryRecordAmount()), "Verify Amount Deducted After transaction", true,false);
//
//            Thread.sleep(300);
//
//
//
//
//        }
//
//
//    }
//
////    public void creditCardRechargeWapgFlowVoucherSameAmount(String amount, String securityPin, String success_page_status, String success_page_text) throws InterruptedException, IOException, JSONException {
////
////        //balanceBefore = mbkCommonControlsHelper.getBalance();
//////        homePage.clickOnCrossButton();
////
////        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
////
////        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
////
////            screen.swipeUpMedium(driver);
////        }
////
////        homePage.clickOnRechargeLayout();
////        rechargePage = homePage.clickCreditCardIcon();
////
////        permissionHelper.permissionAllow();
////
////        rechargePage.selectCreditCardFromSavedConnection();
////
////        rechargePage.enterCreditCardAmount(amount);
////
//////        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Credit Card Bill']"));
////
////        rechargePage.clickOnCreditCardContinueCta();
////
////        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"));
////
////
////        rechargePage.clickApplyCoupon();
////
////        Element.waitForVisibility(driver, By.id("redeem_layout"));
////
////
////        List<AndroidElement> vouchers = Element.findElements(driver, By.id("redeem_layout"));
////        int noOfVouchersAvailable = vouchers.size();
////
////        if (noOfVouchersAvailable > 0) {
////
////            rechargePage.selectVoucher();
////
////            Thread.sleep(1000);
////
////            rechargePage.clickOnCtaCotinue();
////
////            mbkCommonControlsHelper.handleSecurityPin(securityPin);
////
////            Thread.sleep(3000);
////
////            Element.waitForVisibility(driver, By.id("base_title"));
////
////
////            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success with voucher applied of same amount", true, true);
////
////            String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("₹ ", "");
////
////            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, true);
////
////            String actualPendingDescription = rechargePage.getPendingDescMessage();
////
////            mbReporter.verifyEqualsWithLogging(actualPendingDescription, success_page_text, "Verify Pending Message", true, true);
////
////            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);
////
////            rechargePage.backToHomeFromPendingScreen();
////
////            homePage.closeRechargeServicesOverlay();
////
////            Thread.sleep(300);
////
////        } else {
////
////            mbReporter.verifyFalse(noOfVouchersAvailable < 1, "No vouchers Available", true, true);
////        }
////
////    }
////
////    public void creditCardRechargeWapgFlowMoreAmountThanVoucher(String amount, String securityPin, String cardNo, String cvv, String bankPassword, String success_page_status, String success_page_text) throws InterruptedException, IOException, JSONException {
////
////        //balanceBefore = mbkCommonControlsHelper.getBalance();
//////        homePage.clickOnCrossButton();
////
////        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
////
////        if (!Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Mobile']"))) {
////
////            screen.swipeUpMedium(driver);
////        }
////
////        homePage.clickOnRechargeLayout();
////        rechargePage = homePage.clickCreditCardIcon();
////
////        permissionHelper.permissionAllow();
////
////        rechargePage.selectCreditCardFromSavedConnection();
////
////        rechargePage.enterCreditCardAmount(amount);
////
//////        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Credit Card Bill']"));
////
////        rechargePage.clickOnCreditCardContinueCta();
////
////        Element.waitForVisibility(driver, By.xpath("//android.widget.TextView[@text= 'Confirm Payment']"));
////
////
////        rechargePage.clickApplyCoupon();
////
////        Element.waitForVisibility(driver, By.id("redeem_layout"));
////
////
////        List<AndroidElement> vouchers = Element.findElements(driver, By.id("redeem_layout"));
////        int noOfVouchersAvailable = vouchers.size();
////
////        if (noOfVouchersAvailable > 0) {
////
////            rechargePage.selectVoucher();
////
////            Thread.sleep(1000);
////
////            rechargePage.clickOnCtaCotinue();
////
////            mbkCommonControlsHelper.handleSecurityPin(securityPin);
////
////            Thread.sleep(3000);
////
////            addMoneyHelper = new AddMoneyHelper(driver);
////            addMoneyHelper.addMoneyInsufficientFunds(cardNo, cvv, bankPassword);
////
////            Element.waitForVisibility(driver, By.id("base_title"));
////
////
////            mbReporter.verifyEqualsWithLogging(rechargePage.getSuccessScreenTitle(), success_page_status, "Credit Card Bill payment Success, voucher applied and Wapg Transaction success", true, true);
////
////            String actualTotalAmountPaid = rechargePage.getTotalAmountValue().replace("₹ ", "");
////
////            mbReporter.verifyEqualsWithLogging(actualTotalAmountPaid, amount, "Verify Amount", true, true);
////
////            String actualPendingDescription = rechargePage.getPendingDescMessage();
////
////            mbReporter.verifyEqualsWithLogging(actualPendingDescription, success_page_text, "Verify Pending Message", true, true);
////
////
////            mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("txt_promo_result_desc")), rechargePage.getPromoCodeTextOnSuccessScreen(), true, false);
////
////
////            rechargePage.backToHomeFromPendingScreen();
////
////            homePage.closeRechargeServicesOverlay();
////
////            Thread.sleep(300);
////
////        } else {
////
////            mbReporter.verifyFalse(noOfVouchersAvailable < 1, "No vouchers Available", true, true);
////        }
////
////    }


    //############################ Old end ################################
}
