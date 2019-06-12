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
        String actualOnwardBookingId = busPage.getOnwardBookingId();
//        String actualOnwardOperator = busPage.getOnwardOperator();
        String actualOnwardRoute = busPage.getOnwardRoute();


        Log.info(actualSuccessPageHeading);
        Log.info(actualOnwardBookingId);
//        Log.info(actualOnwardOperator);
        Log.info(actualOnwardRoute);

        mbkCommonControlsHelper.returnToHomePageFromSuccessScreen();


    }


    public void busCancel() throws InterruptedException, IOException, JSONException {

        balanceBefore = mbkCommonControlsHelper.getBalance();

        Element.waitForVisibility(driver, homePage.icon_mobile);

        screen.swipeUp();

        homePage.clickMoreServicesIcon();

        busPage = homePage.clickBusIcon();

        busPage.clickOnBookingsCta();

        busPage.selectTicketForCancellation();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/btn_download_tkt"));

        screen.swipeUp();

        busPage.clickOnCancelTicketCta();

        busPage.clickOnCancelCompleteTicketCta();

        busPage.clickOnConfirmCancelTicketCta();

        String actualCancellationSuccessMessage = busPage.getCancellationSuccess();
        String actualCancellationRefundMessage = busPage.getCancellationRefund();


        Log.info(actualCancellationSuccessMessage);
        Log.info(actualCancellationRefundMessage);


        busPage.clickBackToHome();


        Log.info("Test Completed");

    }


}
