package Helpers;

import PageObject.BusPage;
import PageObject.HomePage;
import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import utils.DateHelper;
import utils.Element;
import utils.Screen;

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
        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        balanceBefore = mbkCommonControlsHelper.getBalance();

        busPage = reachBusHomeScreen();

        busPage.selectDepartureCityBox();

        busPage.enterDepartureCity(departureCity);

        busPage.selectDepartureCity();

        busPage.enterDestinationCity(destinationCity);

        busPage.selectDestinationCity();


        int date = DateHelper.getDayFromCurrentDate();

        if (date < 15) {

            busPage.selectDateLater();

        } else {


            int month = DateHelper.getCurrentMonthInteger();
            if (month < 12) {

                month = month + 1;

            } else {

                month = 1;

            }

            int year = DateHelper.getCurrentYearInteger();

            String monthString = DateHelper.getMonthInStringFromInteger(month);

            String selectMonth = monthString + " " + year;

            AndroidElement androidElement = element.findElement(driver, By.xpath("//android.widget.TextView[@text = '" + selectMonth + "']/following::android.widget.TextView[@text = '5']"));
            Element.selectElement(driver, androidElement, "select modified date");


        }


        Element.waitForVisibility(driver, By.id("com.mobikwik_new.bajajfinserv:id/journey_info"));

        screen.swipeUpMedium(driver);


        busPage.selectBus();

        busPage.selectNoPassengers();

        Thread.sleep(2000);
        if (Element.isElementPresent(driver, By.id("com.mobikwik_new.bajajfinserv:id/continue_button"))) {
            busPage.clickOnContinueSeatsCta();
        } else {
            busPage.clickOnConfirmSeatsCta();
        }

        busPage.selectBoardingPoint();

        busPage.selectDropPoint();

        busPage.enterPassengerName(passengerName);

        busPage.enterPassengerAge(passengerAge);

        busPage.selectGender();

        busPage.clickOnPassengerDetailsConfirmCta();

        busPage.clickOnPayAmountCta();

        mbkCommonControlsHelper.handleSecurityPin(pin);

        busPage.clickOnConfirmBookingCta();

        Thread.sleep(2000);

        mbkCommonControlsHelper.handleNPS();

        mbkCommonControlsHelper.handleRatingsPopUp();

        String actualSuccessPageHeading = busPage.getSuccessPageHeading();
        String actualOnwardRoute = busPage.getOnwardRoute().toLowerCase();
        String actualTotalAmountPaid = busPage.getTotalAmountPaid().replace("X", "");

        String expectedOnwardRoute = (departureCity + " to " + destinationCity).toLowerCase();

        mbReporter.verifyEqualsWithLogging(actualSuccessPageHeading, "Payment Successful", "Success Screen | Verify Status", false, false);
        mbReporter.verifyEqualsWithLogging(actualOnwardRoute.toUpperCase(), expectedOnwardRoute.toUpperCase(), "Success Screen | Verify Route", false, false);


        mbkCommonControlsHelper.returnToHomePageFromP2MSuccessScreen();

        busPage.selectBackButton();

        driver.navigate().back();

        Screen.swipeDownMedium(driver);

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Available Balance']")) == false) {
            Screen.swipeDownMedium(driver);
        }
        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text = 'Available Balance']")) == false) {
            Screen.swipeDownMedium(driver);
        }

        balanceAfter = mbkCommonControlsHelper.getBalance();

        Double actualMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceAfter, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100;
        Double expectedMainBalanceAfter = Double.parseDouble(mbkCommonControlsHelper.getBalance(balanceBefore, MBKCommonControlsHelper.BalanceType.MAINBALANCE)) * 100 - Double.parseDouble(actualTotalAmountPaid) * 100;

        mbReporter.verifyEqualsWithLogging(actualMainBalanceAfter, expectedMainBalanceAfter, "After TRX | Verify Wallet Main Balance", false, false);

    }


    public void busCancel(String message) throws InterruptedException, IOException, JSONException {
        homePage.clickOnCrossButton();
        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        balanceBefore = mbkCommonControlsHelper.getBalance();

        busPage = reachBusHomeScreen();

        busPage.clickOnBookingsCta();

        Thread.sleep(2000);

        busPage.selectTicketForCancellation();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new.bajajfinserv:id/btn_download_tkt"));

        screen.swipeUpMedium(driver);

        busPage.clickOnCancelTicketCta();

        busPage.clickOnCancelCompleteTicketCta();

        busPage.clickOnConfirmCancelTicketCta();

        String actualCancellationSuccessMessage = busPage.getCancellationSuccess();
        String actualCancellationRefundMessage = busPage.getCancellationRefund();


        mbReporter.verifyEqualsWithLogging(actualCancellationSuccessMessage, message, "Success Message", false, false);
        Log.info(actualCancellationRefundMessage);

        busPage.clickBackToHome();

        Log.info("Test Completed");

    }


    public BusPage reachBusHomeScreen() throws InterruptedException, IOException {
        Element.waitForVisibility(driver, homePage.sidedrawer_icon);
        screen.swipeUpMedium(driver);

        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='More Services']/following::android.widget.TextView[@text='More']")) == false) {
            screen.swipeUpMedium(driver);
        }


        if (Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Bus']")) == true) {
            return busPage = homePage.clickBusIcon();

        } else {
            homePage.clickMoreIconUnderMoreServices();
            return busPage = homePage.clickBusIcon();
        }
    }


}
