package Helpers;

import PageObject.*;
import Utils.DateHelper;
import Utils.Element;
import Utils.Log;
import Utils.MbkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHelper {


    WebDriver driver;
    HomePage homePage;
    MbkReporter mbkReporter;
    LoginPage loginPage;
    SideDrawerPage sideDrawerPage;
    DashboardPage dashboardPage;
    BusPage busPage;

    public BusHelper(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        dashboardPage= new DashboardPage(driver);
        mbkReporter = new MbkReporter();
    }


    //Payment Successful

    public void busBook(String departure, String destination, String passengerName, String passengerAge, String expectedMessage) throws InterruptedException {

        Double balanceBefore =Double.parseDouble(homePage.getAvailableBalance())*100;

        busPage= dashboardPage.clickOnBusSideDrawer();

        busPage.enterDeparture(departure);

        busPage.enterDestination(destination);

        busPage.enterDate();

        busPage.selectDate();

        busPage.clickSearch();

        busPage.clickSelectSeats();

        Thread.sleep(300);

        busPage.selectSeat();

        Thread.sleep(200);

        busPage.selectBoardingPoint();

        Thread.sleep(1000);

        busPage.selectDropPoint();
        Thread.sleep(1000);

        busPage.clickConfirmSeats();

        busPage.enterPassengerName(passengerName);

        busPage.enterPassengerAge(passengerAge);


        busPage.clickConfirmPassengerDetails();

        busPage.clickMakePayment();


        busPage.waitForTickIcon();

        String actualMessage= busPage.getBusSuccess();

        mbkReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Bus booking success", false );

        String amountPaid= busPage.getTotalAmountPaid();

//        Log.info(amountPaid);

       homePage.clickOnLogoMbk();

        Double balanceAfter= Double.parseDouble(homePage.getAvailableBalance())*100;

//        System.out.println(balanceAfter);

        Double paidAmount= Double.parseDouble(amountPaid)*100;

//        System.out.println(paidAmount);

//        System.out.println(balanceBefore);

        Double expectedAmount= balanceBefore-paidAmount;

//        System.out.println(expectedAmount);

        mbkReporter.verifyEqualsWithLogging(balanceAfter, balanceBefore-paidAmount, "Amount Validated", false);

        homePage.clickOnLogoMbk();

        }


    public void busCancel(String expectedMessage) throws InterruptedException{

        //Thanks your ticket has been cancelled successfully

        Double balanceBefore =Double.parseDouble(homePage.getAvailableBalance())*100;

        busPage= dashboardPage.clickOnBusSideDrawer();

        busPage.clickManageBookings();

        busPage.clickViewDetails();

        busPage.clickCancelTicket();

        busPage.clickOnCheckBox();

        busPage.cancelTicketforSelectedPassenger();

        busPage.clickOnConfirmCancel();

        String actualMessage= busPage.getCancellationStatus();

        mbkReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Bank Cancellation success", false );


        String amountRefund= busPage.getRefundedAmount();

//        Log.info(amountRefund);

        busPage.clickOnBackToHome();

        Double balanceAfter= Double.parseDouble(homePage.getAvailableBalance())*100;

        Double refundedAmount= Double.parseDouble(amountRefund)*100;

        Double expectedAmount= balanceBefore+refundedAmount;

        mbkReporter.verifyEqualsWithLogging(balanceAfter, expectedAmount, "Amount Validated", false);

        homePage.clickOnLogoMbk();

    }

}

