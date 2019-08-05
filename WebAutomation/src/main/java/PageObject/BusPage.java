package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import common.DateHelper;
import org.hibernate.validator.internal.engine.messageinterpolation.parser.ELState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.soap.SAAJResult;
import java.util.List;

public class BusPage {

    WebDriver driver;

    //Heading for Visibility
    @FindBy(xpath= "//h1[@class= 'ft25 twhite smtop0 smbottom24']")
    private WebElement load_bus;


//    City From
    @FindBy(xpath= "//label[text()= 'From']/following::input[1]")
    private WebElement input_departure;


    //select From City
    //ng-dropdown-panel[@id= 'a6c5677fcc33']

    @FindBy(xpath= "//div[@class=\'ng-dropdown-panel-items scroll-host\']/div/div/span")
    private WebElement dropdown_cities;

    @FindBy(xpath= "//label[text()= 'To']/following::input[1]")
    private WebElement input_destination;


    @FindBy(xpath= "//label[text()= 'Date']/following::input[1]")
    private  WebElement input_date;


    @FindBy(xpath = "//button[@class='next']")
    private WebElement date_next;

    @FindBy(xpath = "//span[text()= '22']")
    private WebElement date_22;

    @FindBy(xpath = "//span[text()= 'Search']")
    private WebElement button_search;


    @FindBy(xpath = "//p[@title= 'Das & Das Travels']/following::span[text()= 'Select Seats'][1]")
    private WebElement button_select_seats;


    @FindBy(xpath = "//i[@class= 'wheel dpInBLockMid']/following::li[@class= 'SS'][1]")
    private WebElement seat_selecter;


    @FindBy(xpath = "//div[text()= 'Select Boarding Point']")
    private WebElement select_boarding_point;


    @FindBy(xpath = "//div[text()= 'Select Drop Point']")
    private WebElement select_droping_point;

    @FindBy(xpath = "//span[text()= 'Continue']")
    private WebElement button_confirm_seats;


    @FindBy(xpath = "//input[@placeholder= 'Enter Name']")
    private WebElement input_passenger_name;

    @FindBy(xpath = "//input[@placeholder= 'Age']")
    private WebElement input_passenger_age;

    @FindBy(xpath = "//span[text()= 'Continue']")
    private WebElement button_confirm_passenger_details;

    @FindBy(xpath = "//span[text()= 'Make Payment']")
    private WebElement button_make_payment;

    //Success Screen

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']")
    private WebElement tick_icon;

    @FindBy(xpath = "//p[text()= 'Payment Successful']")
    private WebElement label_bus_payment_success;

    @FindBy(xpath = "//div[text()= 'Total Amount Paid']/following::div[@class= 'col-md-6 ft15 tright fw600']")
    private WebElement total_amount_paid;


    //Bus Cancel


    @FindBy(xpath = "//p[@class= 'fw600 ft15 themecolor']")
    private WebElement button_manage_bookings;

    @FindBy(xpath = "//div[text()= 'Bhubaneswar']/following::span[text()= 'View Details']")
    private WebElement button_view_details;

    @FindBy(xpath = "//span[text()= 'Cancel Ticket']")
    private WebElement button_cancel_ticket;

    @FindBy(xpath ="//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
    private WebElement checkbox_passenger_for_cancellation;

    @FindBy(xpath="//div[text()= 'Cancellation Policy']/following::span[text()='Cancel Ticket']")
    private WebElement button_overlay_cancel_ticket;

    @FindBy(xpath = "//div[text()= 'Net Refundable Amount']/following::span[text()='Confirm Cancel Ticket']")
    private WebElement button_confirm_cancel_ticket;


    @FindBy(xpath = "//div[text()= 'Thanks your ticket has been cancelled successfully']")
    private WebElement heading_cancel_bus_success;


    @FindBy(xpath = "//span[@class= 'dpInBLockMid smleft30 fw600']")
    private WebElement label_net_refundable_amount;





    public BusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, load_bus);
        Config.logComment("*****On Bus Page*****");
    }


   public void enterDeparture(String departure){
        Element.enterText(driver, input_departure, departure, " Enter Departure");
        Element.pressEnter(driver);
   }


   public void enterDestination(String destination){
        Element.enterText(driver, input_destination, destination, "Enter Destination");
        Element.pressEnter(driver);
   }


   public void enterDate(){
        Element.selectElement(driver, input_date,"Enter Date");
   }

   public void selectDate(){
        Element.selectElement(driver, date_22,"Select 22 on current calender");

   }

   public void clickSearch(){
        Element.selectElement(driver, button_search, "Click on Search Button");
   }

   public void clickSelectSeats(){
        Element.selectElement(driver, button_select_seats, "Click on Select Seats Button");
   }


   public void selectSeat(){
        Element.selectElement(driver, seat_selecter, "Select random seats");
   }


   public void selectSeats(){
        Element.selectElement(driver, seat_selecter, "Seat Selecter");
   }

   public void  selectBoardingPoint(){
        Element.selectElement(driver,select_boarding_point, "Select Boarding Point");
        Element.pressEnter(driver);
   }

    public void  selectDropPoint(){
        Element.selectElement(driver,select_droping_point, "Select Drop Point");
        Element.pressEnter(driver);
    }

    public void clickConfirmSeats(){
        Element.selectElement(driver, button_confirm_seats, " Click on Continue Button");
    }

    public void enterPassengerName(String passengerName){
        Element.enterText(driver,input_passenger_name,passengerName, "Enter Passenger Name");
    }

    public void enterPassengerAge(String passengerAge){
        Element.enterText(driver,input_passenger_age, passengerAge, "Enter Passenger Age");
    }

    public void clickConfirmPassengerDetails(){
        Element.selectElement(driver, button_confirm_passenger_details, "Confirm Passenger Details");
    }

    public void clickMakePayment(){
        Element.selectElement(driver, button_make_payment, "Click on MAke Payment");
    }

    public void waitForTickIcon() {
        Element.waitForVisibility(driver, tick_icon, "Tick Icon");
    }

    public String getBusSuccess(){
        return Element.getText(driver,label_bus_payment_success, "TRX Status");
    }

    public String getTotalAmountPaid(){
        return Element.getText(driver, total_amount_paid, "Total amount paid").replace("₹ ", "");
    }

    public void clickManageBookings(){
        Element.selectElement(driver, button_manage_bookings, "Click on ManageBookings");
    }

    public void clickViewDetails(){
        Element.selectElement(driver, button_view_details, "Click on View Details");
    }

    public void clickCancelTicket(){
        Element.selectElement(driver, button_cancel_ticket, "Click on Cancel Ticket");
    }

    public void clickOnCheckBox(){
        Element.selectElement(driver, checkbox_passenger_for_cancellation, "select passenger using checkbox");
    }

    public void cancelTicketforSelectedPassenger(){
        Element.selectElement(driver, button_overlay_cancel_ticket, "Cancel ticket for selected passenger");
    }

    public void clickOnConfirmCancel(){
        Element.selectElement(driver, button_confirm_cancel_ticket, "Click on confirm Cancel");
    }

    public String getCancellationStatus(){
        return Element.getText(driver, heading_cancel_bus_success, " Cancel Success Message");
    }

    public String getRefundedAmount(){
        return Element.getText(driver, label_net_refundable_amount, "Net refundable amount").replace("₹ ", "");
    }
}
