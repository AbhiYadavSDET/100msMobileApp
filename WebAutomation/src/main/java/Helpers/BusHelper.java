package Helpers;

import PageObject.*;
import Utils.DateHelper;
import Utils.Element;
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

        busPage.clickSearch();

        busPage.clickSelectSeats();

        busPage.selectSeat();

        busPage.selectBoardingPoint();

        busPage.selectDropPoint();

        busPage.clickConfirmSeats();

        busPage.enterPassengerName(passengerName);

        busPage.enterPassengerAge(passengerAge);


        busPage.clickConfirmPassengerDetails();

        busPage.clickMakePayment();


        busPage.waitForTickIcon();

        String actualMessage= busPage.getBusSuccess();

        mbkReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Bank transfer success", false );

        String amountPaid= busPage.getTotalAmountPaid();


        Double balanceAfter= Double.parseDouble(homePage.getAvailableBalance())*100;

        Double paidAmount= Double.parseDouble(amountPaid)*100;

        Double expectedAmount= (balanceBefore-paidAmount);

        mbkReporter.verifyEqualsWithLogging(expectedAmount, balanceAfter, "Amount Validated", false);

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

        mbkReporter.verifyEqualsWithLogging(actualMessage, expectedMessage, "Bank transfer success", false );


        String amountRefund= busPage.getRefundedAmount();


        Double balanceAfter= Double.parseDouble(homePage.getAvailableBalance())*100;

        Double refundedAmount= Double.parseDouble(amountRefund)*100;

        Double expectedAmount= (balanceBefore+refundedAmount);

        mbkReporter.verifyEqualsWithLogging(expectedAmount, balanceAfter, "Amount Validated", false);

        homePage.clickOnLogoMbk();

    }

}

