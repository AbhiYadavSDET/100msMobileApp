package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

import java.io.IOException;
import java.util.List;

public class PayRentPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath="//android.widget.TextView['Benefits of paying rent through Credit card']")
    public AndroidElement home_title;

    @AndroidFindBy(id="mkab_title")
    private AndroidElement title_bar;

    @AndroidFindBy(id="textActionButton")
    private AndroidElement faq_button;

    @AndroidFindBy(id="card_button")
    private AndroidElement use_credit_card;

    @AndroidFindBy(id="upi_button")
    private AndroidElement use_upi;

    @AndroidFindBy(id="mkab_icon_1")
    private AndroidElement back_button;

    @AndroidFindAll(@AndroidBy(id="edit_text_mket"))
    private List<AndroidElement> text_fields;

    @AndroidFindBy(id="continue_btn")
    private AndroidElement continue_button_detailsPage;

    @AndroidFindBy(id="processing_fee_discounted")
    private AndroidElement processing_fee;

    @AndroidFindBy(id="address")
    private AndroidElement address_home;


    public PayRentPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        /*
        To Do
        wait for Page load to be added
         */
        Log.info("*****PayRent Page*****");
    }
/*
    public String getTitle() throws InterruptedException{
       return Element.getText(driver, title_bar, "Title Bar Text");
    }

    public String getTitleText() throws  InterruptedException{
        return Element.getText(driver, home_title, "Home Page Title Bar Text");
    }

    public void clickFAQ() throws InterruptedException{
        Element.selectElement(driver, faq_button, "click on FAQ Button");
    }

    public void clickCCButton() throws InterruptedException{
        Element.selectElement(driver, use_credit_card, "Click on Credit Card Button");
    }

    public void clickUPIButton() throws InterruptedException{
        Element.selectElement(driver, use_upi, "Click on UPI Button");
    }

    public void selectAndEnterAddress(String address) throws  InterruptedException{
        Element.selectElement(driver, text_fields.get(0) ,"Selecting Address Field");
        Element.enterText(driver, text_fields.get(0), address, "Entering Address Field");
    }

    public void selectAndEnterPincode(String pincode) throws InterruptedException{
        Element.selectElement(driver, text_fields.get(1),"Selecting Pincode");
        Element.enterText(driver, text_fields.get(1), pincode, "Entering Pincode");
    }

    public void clickOnContinueButton() throws InterruptedException{
        Element.selectElement(driver, continue_button_detailsPage, "Clicking on Continue Button");
    }

    public void selectAndEnterLandlordName(String name) throws InterruptedException{
        Element.selectElement(driver, text_fields.get(0), "Selecting Landlord Name");
        Element.enterText(driver, text_fields.get(0), name, "Entering Landlord Name");
    }

    public void selectAndEnterAmount(String amount) throws InterruptedException{
        Element.selectElement(driver, text_fields.get(1), "Selecting Amount");
        Element.enterText(driver, text_fields.get(1), amount, "Entering amount");
    }

    public String getProcessingFees() throws InterruptedException{
        return Element.getText(driver, processing_fee, "Get Processing Fees");
    }

    public void selectAndEnterBankAccountNumber(String bankAccNum) throws InterruptedException{
        Element.selectElement(driver, text_fields.get(0), "Selecting Bank Account Number");
        Element.enterText(driver, text_fields.get(0), bankAccNum, "Entering Account Number");
    }

    public void selectAndEnterIFSC(String ifsc) throws InterruptedException{
        Element.selectElement(driver, text_fields.get(1), "Selecting IFSC Field");
        Element.enterText(driver, text_fields.get(1), ifsc, "Entering IFSC Code");
    }

    public void clickExisting() throws InterruptedException{
        Element.selectElement(driver, address_home, "Click on Existing Property");
    }



 */

}
