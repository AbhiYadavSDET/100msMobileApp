package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BusPage {


    AndroidDriver driver;

    //Intro Page

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_departure_city")
    private AndroidElement textbox_departure_city;

    //Select Location Page

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_departure_city")
    private AndroidElement textbox_enter_departure_city;

    //Departure City = bhubaneswar

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_title")
    private AndroidElement select_departure_city;

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_destination_city")
    private AndroidElement textbox_enter_destination_city;

    //Destination City = baripada

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_title")
    private AndroidElement select_destination_city;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '25']")
    private AndroidElement select_date_later;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '5']")
    private AndroidElement select_date_earlier;

    @AndroidFindBy(id = "com.mobikwik_new:id/textActionButton")
    public AndroidElement cta_modify;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Das & Das Travels']")
    private AndroidElement select_bus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '1']")
    private AndroidElement select_number_of_passenger;

    @AndroidFindBy(id = "com.mobikwik_new:id/proceed_button")
    private AndroidElement button_confirm_seats;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bermunda Bus Stand']")
    private AndroidElement select_boarding_point;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Baripada']")
    private AndroidElement select_dropping_point;

    //Passenger Details Screen
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Passenger Details']/following::android.widget.EditText[1]")
    private AndroidElement enter_passenger_name;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Age']")
    private AndroidElement enter_passenger_age;

    @AndroidFindBy(id = "com.mobikwik_new:id/btnFirst")
    private AndroidElement select_gender;

    @AndroidFindBy(id = "com.mobikwik_new:id/proceed_button")
    private AndroidElement cta_continue;

    //Confirm Details Screen
    @AndroidFindBy(id = "com.mobikwik_new:id/pay_btn")
    private AndroidElement cta_pay_amount;

    @AndroidFindBy(id = "com.mobikwik_new:id/primary_button")
    private AndroidElement cta_confirm_book_now;


    //Booking success

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Payment Successful']")
    private AndroidElement text_heading_payment_successfull;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bhubaneswar to Baripada']")
    private AndroidElement text_onward_route;


    @AndroidFindBy(id = "com.mobikwik_new:id/onward_operator_txt")
    private AndroidElement text_onward_operator;


    @AndroidFindBy(id = "com.mobikwik_new:id/total_amount_paid")
    private AndroidElement total_amount_paid;

    //Cancel Booking

    @AndroidFindBy(id = "com.mobikwik_new:id/textActionButton")
    private AndroidElement cta_bookings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'UPCOMING JOURNEYS']/following::android.widget.TextView[@text = 'Das & Das Travels']")
    private AndroidElement select_ticket_for_cancellation;

    @AndroidFindBy(id = "com.mobikwik_new:id/cancel_button")
    private AndroidElement cta_cancel_ticket;

    @AndroidFindBy(id = "com.mobikwik_new:id/cancel_complete")
    private AndroidElement cta_cancel_complete_ticket;

    @AndroidFindBy(id = "com.mobikwik_new:id/primary_button")
    private AndroidElement cta_confirm_cancel_ticket;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Your Ticket has been Cancelled']")
    private AndroidElement text_cancellation;

    @AndroidFindBy(id = "com.mobikwik_new:id/suceess_msg")
    private AndroidElement refund_message;

    @AndroidFindBy(id = "com.mobikwik_new:id/home_button")
    private AndroidElement home_button;



    public BusPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Bus Page*****");

    }

    public void selectDepartureCityBox() throws InterruptedException {
        Element.selectElement(driver, textbox_departure_city, "Select Departure City");
    }


    public void enterDepartureCity(String departureCity) throws InterruptedException {
        Element.enterText(driver, textbox_enter_departure_city, departureCity, "Enter Departure City");
    }

    public void selectDepartureCity() throws InterruptedException {
        Element.selectElement(driver, select_departure_city, "Select Departure city from List");
    }

    public void enterDestinationCity(String destinationCity) throws InterruptedException {
        Element.enterText(driver, textbox_enter_destination_city, destinationCity, "Enter Destination City");
    }


    public void selectDestinationCity() throws InterruptedException {
        Element.selectElement(driver, select_destination_city, "Select Destination city from List");
    }

    public void selectDateLater() throws InterruptedException {
        Element.selectElement(driver, select_date_later, "Later Date selected");
    }


    public void selectDateEarlier() throws InterruptedException {
        Element.selectElement(driver, select_date_earlier, "Earlier Date selected");
    }

    public void clickOnModify() throws InterruptedException {
        Element.selectElement(driver, cta_modify, "Modify CTA");
    }

    public void selectBus() throws InterruptedException {
        Element.selectElement(driver, select_bus, "Select Bus");
    }

    public void selectNoPassengers() throws InterruptedException {
        Element.selectElement(driver, select_number_of_passenger, "Select no of Passengers");
    }

    public void clickOnConfirmSeatsCta() throws InterruptedException {
        Element.selectElement(driver, button_confirm_seats, "Click on Confirm Seats button");
    }

    public void selectBoardingPoint() throws InterruptedException {
        Element.selectElement(driver, select_boarding_point, "Select Boarding Point");
    }

    public void selectDropPoint() throws InterruptedException {
        Element.selectElement(driver, select_dropping_point, "Select Dropping Point");
    }

    public void enterPassengerName(String name) throws InterruptedException {
        Element.enterText(driver, enter_passenger_name, name, "Enter Passenger Name");
    }

    public void enterPassengerAge(String age) throws InterruptedException {
        Element.enterText(driver, enter_passenger_age, age, "Enter Passenger Age");
    }

    public void selectGender() throws InterruptedException {
        Element.selectElement(driver, select_gender, "Select Gender");
    }

    public void clickOnPassengerDetailsConfirmCta() throws InterruptedException {
        Element.selectElement(driver, cta_continue, "Proceed with Passenger Details");
    }


    public void clickOnPayAmountCta() throws InterruptedException {
        Element.selectElement(driver, cta_pay_amount, "Tap on Pay amount on Confirm Details Creen");
    }

    public void clickOnConfirmBookingCta() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_book_now, "Confirm and Proceed with bus booking");
    }


    public String getSuccessPageHeading() throws InterruptedException {
        return Element.getText(driver, text_heading_payment_successfull, "Success Screen | Verify Booking Success");
    }

    public String getOnwardRoute() throws InterruptedException {
        return Element.getText(driver, text_onward_route, "Success Screen | Verify Onward Route");
    }

    public String getOnwardOperator() throws InterruptedException {
        return Element.getText(driver, text_onward_operator, "Success Screen | Verify Onward Operator");
    }

    public String getTotalAmountPaid() throws InterruptedException {
        return Element.getText(driver, total_amount_paid, "Success Screen | Verify Total Amount Paid");
    }

    public void clickOnBookingsCta() throws InterruptedException {
        Element.selectElement(driver, cta_bookings, "Navigate to Bookings Page");
    }

    public void selectTicketForCancellation() throws InterruptedException {
        Element.selectElement(driver, select_ticket_for_cancellation, "Select Ticket for Cancellation ");
    }

    public void clickOnCancelTicketCta() throws InterruptedException {
        Element.selectElement(driver, cta_cancel_ticket, "Click on Cancel Ticket");
    }

    public void clickOnCancelCompleteTicketCta() throws InterruptedException {
        Element.selectElement(driver, cta_cancel_complete_ticket, "Click on Cancel Complete Ticket");
    }

    public void clickOnConfirmCancelTicketCta() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_cancel_ticket, "Click on Comfirm Cancel Ticket");
    }

    public String getCancellationSuccess() throws InterruptedException {
        return Element.getText(driver, text_cancellation, "Cancellation Success Screen | Verify Message");
    }

    public String getCancellationRefund() throws InterruptedException {
        return Element.getText(driver, refund_message, "Cancellation Success Screen | Verify Refund");
    }

    public String clickBackToHome() throws InterruptedException {
        return Element.getText(driver, home_button, "Navigate back to Home");
    }

}


















