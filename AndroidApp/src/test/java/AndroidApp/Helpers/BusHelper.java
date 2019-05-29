package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import net.sourceforge.tess4j.TesseractException;
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

    public BusHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }

    public void busBook() throws InterruptedException, IOException, JSONException {

        Screen.swipeUpMore(driver);

        homePage.clickMoreServicesIcon();

        busPage = homePage.clickBusIcon();

        busPage.selectDepartureCity();

        busPage.enterDepartureCity("bhubaneswar");

        busPage.selectDestinationCity();

        busPage.enterDestinationCity("baripada");

        busPage.selectDate();

        Screen.swipeUpMore(driver);

        busPage.selectBus();

        busPage.selectNoPassengers();

        busPage.clickOnConfirmSeatsCta();

        busPage.selectBoardingPoint();

        busPage.selectDropPoint();

        busPage.enterPassengerName("Paraj Jain");

        busPage.enterPassengerAge("28");

        busPage.selectGender();

        busPage.clickOnPassengerDetailsConfirmCta();

        busPage.clickOnPayAmountCta();

        busPage.clickOnConfirmBookingCta();


        String actualSuccessPageHeading=busPage.getSuccessPageHeading();
        String actualOnwardBookingId = busPage.getOnwardBookingId();
        String actualOnwardOperator = busPage.getOnwardOperator();
        String actualOnwardRoute = busPage.getOnwardRoute();


        Log.info(actualSuccessPageHeading);
        Log.info(actualOnwardBookingId);
        Log.info(actualOnwardOperator);
        Log.info(actualOnwardRoute);


    }

















    }
