package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jdk.internal.org.objectweb.asm.Handle;
import logger.Log;
import main.java.utils.DateFormatEnums;
import main.java.utils.DateHelper;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.BusPage;
import test.java.AndroidApp.PageObject.HomePage;

import java.io.IOException;
import java.util.HashMap;



public class BusHelper {


    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    BusPage busPage;
    PermissionHelper permissionHelper;


    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;

    public BusHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }

    public void busBook(String departureCity, String destinationCity, String passengerName, String passengerAge, String pin) throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        Element.waitForVisibility(driver, homePage.icon_mobile);

        screen.swipeUp();

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Bus']"))==true) {
            busPage = homePage.clickBusIcon();

        }else {

            homePage.clickMoreServicesIcon();
            busPage = homePage.clickBusIcon();
        }

        busPage.selectDepartureCityBox();

        busPage.enterDepartureCity(departureCity);

        busPage.selectDepartureCity();

        busPage.enterDestinationCity(destinationCity);

        busPage.selectDestinationCity();


        int date = DateHelper.getDayFromCurrentDate();

        if (date<15){

            busPage.selectDateLater();

        }else{


            int month = DateHelper.getCurrentMonthInteger();
            if (month<12){

                month= month +1;

            }else {

                month=1;

            }

            int year = DateHelper.getCurrentYearInteger();

            String monthString= DateHelper.getMonthInStringFromInteger(month);

            String selectMonth= monthString + " " + year;

            AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '"+ selectMonth +"']/following::android.widget.TextView[@text = '5']"));
            Element.selectElement(driver, androidElement ,"select modified date" );



        }



        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/journey_info"));

        screen.swipeUp();


        busPage.selectBus();

        busPage.selectNoPassengers();

        busPage.clickOnConfirmSeatsCta();

        busPage.selectBoardingPoint();

        busPage.selectDropPoint();

        busPage.enterPassengerName(passengerName);

        busPage.enterPassengerAge(passengerAge);

        busPage.selectGender();

        busPage.clickOnPassengerDetailsConfirmCta();

        busPage.clickOnPayAmountCta();

        mbkCommonControlsHelper.handleSecurityPin(pin);

        busPage.clickOnConfirmBookingCta();


        String actualSuccessPageHeading = busPage.getSuccessPageHeading();
        String actualOnwardRoute = busPage.getOnwardRoute();
        String actualTotalAmountPaid = busPage.getTotalAmountPaid();


        String expectedOnwardRoute= departureCity+" to "+ destinationCity;

        mbReporter.verifyEqualsWithLogging(actualSuccessPageHeading, "Payment Successful", "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(actualOnwardRoute, expectedOnwardRoute, "Success Screen | Verify Route", false, false);


        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();

        balanceAfter = mbkCommonControlsHelper.getBalance();

        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(actualTotalAmountPaid) * 100;

        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);


    }


    public void busCancel() throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        Element.waitForVisibility(driver, homePage.icon_mobile);

        screen.swipeUp();

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Bus']"))==true) {
            busPage = homePage.clickBusIcon();

        }else {

            homePage.clickMoreServicesIcon();
            busPage = homePage.clickBusIcon();
        }

        busPage.clickOnBookingsCta();

        busPage.selectTicketForCancellation();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/btn_download_tkt"));

        screen.swipeUp();

        busPage.clickOnCancelTicketCta();

        busPage.clickOnCancelCompleteTicketCta();

        busPage.clickOnConfirmCancelTicketCta();

        String actualCancellationSuccessMessage = busPage.getCancellationSuccess();
        String actualCancellationRefundMessage = busPage.getCancellationRefund();


        mbReporter.verifyEqualsWithLogging(actualCancellationSuccessMessage,"", "Success Message", false, false);
        Log.info(actualCancellationRefundMessage);

        busPage.clickBackToHome();


        Log.info("Test Completed");

    }


}