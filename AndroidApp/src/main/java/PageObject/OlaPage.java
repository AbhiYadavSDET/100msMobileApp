package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.util.Random;

public class OlaPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "gps_turn_txt")
    private AndroidElement text_gps_off;

    @AndroidFindBy(id = "gps_turn_on_btn")
    private AndroidElement button_turn_on_gps;


    //Ola MAP Page

    @AndroidFindBy(id = "drop_loc_layout")
    private AndroidElement click_drop_location;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Auto']")
    private AndroidElement auto_icon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Micro']")
    private AndroidElement micro_icon;

    //Ola Search Location

    @AndroidFindBy(xpath = "//android.widget.EditText[@text= 'Enter Drop Location']")
    private AndroidElement textbox_drop_location;

    @AndroidFindBy(id = "category")
    private AndroidElement select_address;

    @AndroidFindBy(id = "btn_ride_now")
    private AndroidElement cta_ride_now;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Estimate Fare']")
    private AndroidElement estimated_fare;

    @AndroidFindBy(id = "confirm_pay_btn")
    private AndroidElement cta_confirm_pay;

    @AndroidFindBy(id = "body_text")
    private AndroidElement pop_up_body_text;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement confirm_book_ride;

    @AndroidFindBy(id = "tx_cab_category")
    private AndroidElement cab_category;


    @AndroidFindBy(id = "tx_driver_name")
    private AndroidElement driver_name;

    @AndroidFindBy(id = "cancel_ride_btn")
    private AndroidElement cta_cancel_ride;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Driver denied to go to destination']")
    private AndroidElement reason_1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Driver denied to come to pickup']")
    private AndroidElement reason_2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Expected a shorter wait time']")
    private AndroidElement reason_3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Unable to contact driver']")
    private AndroidElement reason_4;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Driver wants cash']")
    private AndroidElement reason_5;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'My reason is not listed']")
    private AndroidElement reason_6;


    @AndroidFindBy(id = "cancel_ride_btn")
    private AndroidElement cta_confirm_cancel_ride;

    @AndroidFindBy(id = "mkab_title")
    private AndroidElement title_ride_cancelled;

    @AndroidFindBy(id = "back_to_home_btn")
    private AndroidElement cta_back_to_home;

    public OlaPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */
        Log.info("*****On Ola Page*****");
    }


    public void clickOnDropLocation() throws InterruptedException {

        Element.selectElement(driver, click_drop_location, "Navigate to Location Search");
    }

    public void enterDropLocation(String dropLocation) throws InterruptedException {
        Element.enterText(driver, textbox_drop_location, dropLocation, "Enter Drop Location");
    }

    public void selectAddress() throws InterruptedException {
        Element.selectElement(driver, select_address, "select address from the list");
    }


    public void selectAuto() throws InterruptedException {
        Element.selectElement(driver, auto_icon, "select auto from the list");
    }

    public void selectMicro() throws InterruptedException {
        Element.selectElement(driver, micro_icon, "select micro from the list");
    }


    public void selectRideNow() throws InterruptedException {
        Element.selectElement(driver, cta_ride_now, "select Ride Now");
    }

    public void selectConfirmPay() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_pay, "select Proceed");
    }

    public String getPleaseNoteText() throws InterruptedException {
        return Element.getText(driver, pop_up_body_text, "Get Message from pop Up");
    }

    public void ctaConfirmBookPopUp() throws InterruptedException {
        Element.selectElement(driver, confirm_book_ride, "Select Confirm pay cta on Payment Mode pop Up");
    }

    public String getCabCategory() throws InterruptedException {
        return Element.getText(driver, cab_category, "Get Cab Category Booked");
    }

    public String getDriverName() throws InterruptedException {
        return Element.getText(driver, driver_name, "Get Cab Driver Name");
    }

    public void ctaCancelRide() throws InterruptedException {
        Element.selectElement(driver, cta_cancel_ride, "Select Cancel ride Cta");
    }

    public void selectCancellationReason() throws InterruptedException {

        Random random = new Random();

        int choice = random.nextInt(6);

        switch (choice) {

            case 0:
                Element.selectElement(driver, reason_1, "Select reason 1");
                break;
            case 1:
                Element.selectElement(driver, reason_2, "Select reason 2");
                break;
            case 2:
                Element.selectElement(driver, reason_3, "Select reason 3");
                break;
            case 3:
                Element.selectElement(driver, reason_4, "Select reason 4");
                break;
            case 4:
                Element.selectElement(driver, reason_5, "Select reason 5");
                break;
            case 5:
                Element.selectElement(driver, reason_6, "Select reason 6");
                break;

        }


    }

    public void ctaConfirmCancel() throws InterruptedException {
        Element.selectElement(driver, cta_confirm_cancel_ride, "Confirm Cancel Cta");
    }

    public String getRideCanclled() throws InterruptedException {
        return Element.getText(driver, title_ride_cancelled, "Get Title Ride Cancelled");
    }

    public void ctaBackToHome() throws InterruptedException {
        Element.selectElement(driver, cta_back_to_home, " Click Back To Home");
    }


}
