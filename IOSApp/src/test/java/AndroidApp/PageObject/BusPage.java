package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BusPage {


    IOSDriver driver;

    //Intro Page

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/mkab_icon_1")
    private IOSElement buspage_back_button;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_departure_city")
    private IOSElement textbox_departure_city;

    //Select Location Page

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_departure_city")
    private IOSElement textbox_enter_departure_city;

    //Departure City = bhubaneswar

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_title")
    private IOSElement select_departure_city;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_destination_city")
    private IOSElement textbox_enter_destination_city;

    //Destination City = baripada

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txt_title")
    private IOSElement select_destination_city;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = '25']")
    private IOSElement select_date_later;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = '5']")
    private IOSElement select_date_earlier;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/textActionButton")
    public IOSElement cta_modify;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Das & Das Travels']")
    private IOSElement select_bus;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = '1']")
    private IOSElement select_number_of_passenger;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/proceed_button")
    private IOSElement button_confirm_seats_1;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/continue_button")
    private IOSElement button_confirm_seats_2;


    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Bermunda Bus Stand']")
    private IOSElement select_boarding_point;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Baripada']")
    private IOSElement select_dropping_point;

    //Passenger Details Screen

    //@iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Passenger Details']/following::android.widget.EditText[1]")

    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
    private IOSElement enter_passenger_name;

    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@text = 'Age']")
    private IOSElement enter_passenger_age;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btnFirst")
    private IOSElement select_gender;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/proceed_button")
    private IOSElement cta_continue;

    //Confirm Details Screen
    @iOSXCUITFindBy(id = "com.mobikwik_new:id/pay_btn")
    private IOSElement cta_pay_amount;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/primary_button")
    private IOSElement cta_confirm_book_now;

    //Booking success
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text= 'Payment Successful']")
    private IOSElement text_heading_payment_successfull;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Bhubaneswar to Baripada']")
    private IOSElement text_onward_route;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/onward_operator_txt")
    private IOSElement text_onward_operator;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/total_amount_paid")
    private IOSElement total_amount_paid;

    //Cancel Booking

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/textActionButton")
    private IOSElement cta_bookings;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'UPCOMING JOURNEYS']/following::android.widget.TextView[@text = 'Das & Das Travels']")
    private IOSElement select_ticket_for_cancellation;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/cancel_button")
    private IOSElement cta_cancel_ticket;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/cancel_complete")
    private IOSElement cta_cancel_complete_ticket;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/primary_button")
    private IOSElement cta_confirm_cancel_ticket;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Your Ticket has been Cancelled']")
    private IOSElement text_cancellation;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/suceess_msg")
    private IOSElement refund_message;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/home_button")
    private IOSElement home_button;


    public BusPage(IOSDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Bus Page*****");

    }


    public void selectBackButton() throws InterruptedException {
        Element.selectElement(driver, buspage_back_button, "Press Back Button");
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
        Element.selectElement(driver, button_confirm_seats_1, "Click on Confirm Seats button");
    }

    public void clickOnContinueSeatsCta() throws InterruptedException {
        Element.selectElement(driver, button_confirm_seats_2, "Click on Confirm Seats button");
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


















