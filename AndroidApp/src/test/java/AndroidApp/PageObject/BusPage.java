package test.java.AndroidApp.PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BusPage {


    AndroidDriver driver;

    //Intro Page

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_departure_city")
    private AndroidElement textbox_departure_city;

    //Select Location Page

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Departure']/following::android.widget.TextView[@text = 'Enter City Name']")
    private AndroidElement textbox_enter_departure_city;

    //Departure City = bhubaneswar

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_title")
    private AndroidElement select_departure_city;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Destination']/following::android.widget.TextView[@text = 'Enter City Name']")
    private AndroidElement textbox_enter_destination_city;

    //Destination City = baripada

    @AndroidFindBy(id = "com.mobikwik_new:id/txt_title")
    private AndroidElement select_destination_city;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '15']")
    private AndroidElement select_date;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Das & Das Travels']")
    private AndroidElement select_bus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = '1']")
    private AndroidElement select_number_of_passenger;

    @AndroidFindBy(id="com.mobikwik_new:id/proceed_button")
    private AndroidElement button_confirm_seats;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bermunda Bus Stand']")
    private AndroidElement select_boarding_point;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Baripada']")
    private AndroidElement select_dropping_point;

    //Passenger Details Screen

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(text(), 'Primary Passenger']/following::android.widget.EditText[1]")
    private AndroidElement enter_passenger_name;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(text(), 'Primary Passenger']/following::android.widget.EditText[2]")
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


    @AndroidFindBy(id = "com.mobikwik_new:id/onward_booking_id")
    private AndroidElement text_onward_booking_id;

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



}
