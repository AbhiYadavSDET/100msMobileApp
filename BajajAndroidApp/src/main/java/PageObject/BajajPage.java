package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BajajPage {


    AndroidDriver driver;

    //Bajaj Date of Birth Registration Page

    @AndroidFindBy(xpath= "//android.widget.TextView[@text= 'Benefits of the EMI Network Card']")
    private AndroidElement bajaj_registration_page;

    @AndroidFindBy(id= "com.mobikwik_new.bajajfinserv:id/edit_text_mket")
    private AndroidElement textbox_enter_dob;

    @AndroidFindBy(id= "com.mobikwik_new.bajajfinserv:id/btn_see_cards")
    private AndroidElement cta_see_emi_cards_now;

    //20111989

    //EMI Network Card Page

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'EMI Network Card']")
    private AndroidElement title_emi_network_card;

    @AndroidFindBy(id="com.mobikwik_new.bajajfinserv:id/mkab_icon_1")
    private AndroidElement back_button;

    @AndroidFindBy(id="com.mobikwik_new.bajajfinserv:id/card_container")
    private AndroidElement card_layout;

    @AndroidFindBy(id="com.mobikwik_new.bajajfinserv:id/cardNumber")
    private AndroidElement card_number;

    @AndroidFindBy(id ="com.mobikwik_new.bajajfinserv:id/cardHolderName")
    private AndroidElement card_holder_name;

    @AndroidFindBy(id= "com.mobikwik_new.bajajfinserv:id/btn_view_card_number")
    private AndroidElement cta_view_card_number;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'OTP will get auto-read']")
    private AndroidElement otp_auto_read;

    //press hardware back after above statement

    //scroll up

    @AndroidFindBy(id= "com.mobikwik_new.bajajfinserv:id/loan_product_name")
    private AndroidElement loan_product_id;

    @AndroidFindBy(id= "com.mobikwik_new.bajajfinserv:id/txt_loan_amount")
    private AndroidElement loan_amount;

    @AndroidFindBy(id="com.mobikwik_new.bajajfinserv:id/btn_view_details")
    private AndroidElement cta_view_details;

    //Loan DetailsPage

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Loan Details']")
    private AndroidElement title_loan_details;

    //Insta Credit Page

    @AndroidFindBy(id= "com.mobikwik_new.bajajfinserv:id/amount_query_text")
    private AndroidElement credit_amount_query_text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'X5,000']")
    private AndroidElement cta_5000_offer;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/text")
    private AndroidElement select_feedback;

    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private AndroidElement getFeedbackReason;




    public BajajPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Bajaj Page*****");

    }


    public void enterDob(String dob) throws IOException, InterruptedException {
        Element.selectElement(driver, textbox_enter_dob, "Enter Dob");

        String[] dobArr = dob.split("|");

        for (String e : dobArr) {

            handleNativeKeyboard(Integer.parseInt(e));

        }

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Log.info("Enter");


    }


    public void handleNativeKeyboard(int key) throws InterruptedException {


        switch (key){


            case 0:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
                Log.info("0");
                break;
            case 1:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                Log.info("1");
                break;
            case 2:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                Log.info("2");
                break;
            case 3:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                Log.info("3");
                break;
            case 4:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                Log.info("4");
                break;
            case 5:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
                Log.info("5");
                break;
            case 6:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
                Log.info("6");
                break;
            case 7:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
                Log.info("7");
                break;
            case 8:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
                Log.info("8");
                break;
            case 9:
                driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
                Log.info("9");
                break;

        }
    }


    public void selectSeeEmiCards() throws InterruptedException{
        Element.selectElement(driver, cta_see_emi_cards_now, "See EMI Cards now");
    }


    public String getCardNumber() throws InterruptedException{
        return Element.getText(driver, card_number, "Get Card Number");
    }


    public String getCardHolderName() throws InterruptedException{
        return Element.getText(driver, card_holder_name, "Get Card Holder Name");
    }

    public void selectViewCardNumber() throws InterruptedException{
        Element.selectElement(driver, cta_view_card_number, "Click on View Card Number");
    }

    public String getLoanId() throws InterruptedException{
        return Element.getText(driver, loan_product_id, "Get Loan ID");
    }

    public String getLoanAmount() throws InterruptedException{
        return Element.getText(driver, loan_amount, "Get Loan Amount");
    }

    public void selectViewDetails() throws InterruptedException{
        Element.selectElement(driver, cta_view_details, "View Details About Loan");
    }

    public void getEmiAndLoanDetails() throws InterruptedException{


        List<AndroidElement> loanDetails= driver.findElements(By.id("label"));
        List<AndroidElement> values= driver.findElements(By.id("value"));

        int noOfValues = loanDetails.size();

        for (int i = 0 ; i < noOfValues ; i++) {
            System.out.println(loanDetails.get(i).getText()+" = "+ values.get(i).getText().replaceAll("X", ""));
            }

    }

    public void selectBackButton() throws InterruptedException{
        Element.selectElement(driver,back_button, "Naviagte Back");

    }

    public String getAmountQueryText() throws InterruptedException{

        return Element.getText(driver, credit_amount_query_text, "Get Description");
    }

    public void selectInstaCreditOffer() throws InterruptedException{
        Element.selectElement(driver, cta_5000_offer, "Select Insta Credit Offer");
    }

    public void getInstaCreditLoanDetails() throws InterruptedException{


        List<AndroidElement> loanDetails= driver.findElements(By.id("row_element_left"));
        List<AndroidElement> values= driver.findElements(By.id("row_element_right"));

        int noOfValues = loanDetails.size();

        for (int i = 0 ; i < noOfValues ; i++) {
            System.out.println(loanDetails.get(i).getText()+" = "+ values.get(i).getText().replaceAll("X", ""));
        }

    }


    public void selectFeedback() throws InterruptedException{

        Element.selectElement(driver, select_feedback, "Select Dont need it now");

    }

    public String getFeedbackReason() throws InterruptedException{
        return Element.getText(driver, getFeedbackReason, "Get Feedback Reason");
    }





}


















