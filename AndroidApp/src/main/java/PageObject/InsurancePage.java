package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class InsurancePage {

    AndroidDriver driver;


    @AndroidFindBy(id = "mkab_title")
    public AndroidElement top_bar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Home Insurance (Gas)']")
    private AndroidElement image_gas_insurance;

    @AndroidFindBy(id = "btnPrice")
    private AndroidElement button_price;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_make_payment;

    @AndroidFindBy(id = "txInsuranceSubHeading")
    private AndroidElement fill_kyc_details_page_description;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private AndroidElement fill_kyc_details_page_header;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Personal Accident Insurance']")
    private AndroidElement image_personal_accident_insurance;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'X20']")
    private AndroidElement selective_button_price;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Insured By']/following-sibling::android.widget.TextView")
    private AndroidElement policy_insurer_name;

    @AndroidFindBy(id = "i_agree")
    private AndroidElement i_agree_terms;

    @AndroidFindBy(id = "amount_to_be_paid")
    private AndroidElement amount_to_be_paid;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Personal Accident Insurance']")
    private AndroidElement personal_accident_insurance;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_button;






    public InsurancePage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Insurance Page*****");
    }

    public void clickOnButtonPrice() throws InterruptedException {
        Element.selectElement(driver, button_price, "Price Button");
    }

    public void clickOnCtaMakePayment() throws InterruptedException {
        Element.selectElement(driver, cta_make_payment, "make Payment");
    }

    public void clickOnImageGasInsurance() throws InterruptedException {
        Element.selectElement(driver, image_gas_insurance, "Gas Insurance Image");
    }

    public String getFillDetailsHeader() {
        return Element.getText(driver, fill_kyc_details_page_header, "Header");
    }

    public String getFillDetailsDescription() {
        return Element.getText(driver, fill_kyc_details_page_description, "Description");
    }

    public void clickOnImagePersonalAccidentInsurance() throws InterruptedException {
        Element.selectElement(driver, image_personal_accident_insurance, "Personal Accident Insurance Image");
    }

    public void clickOnSelectiveBtnPrice() throws InterruptedException {
        Element.selectElement(driver, selective_button_price, "Selective Price Button");
    }

    public String getInsuredBy() {
        return Element.getText(driver, policy_insurer_name, "Insurer Name");
    }

    public void clickOnAgreeTerms() throws InterruptedException {
        Element.selectElement(driver, i_agree_terms, "Agree to Terms and Conditions");
    }

    public String getAmountToBePaid() {
        return Element.getText(driver, amount_to_be_paid, "Amount To Be Paid");
    }

    public void selectPersonalAccidentInsurance() throws InterruptedException {
        Element.selectElement(driver, personal_accident_insurance, "Selective Personal Accident Insurance");
        Thread.sleep(200);
        Element.selectElement(driver, personal_accident_insurance, "Selective Personal Accident Insurance lower Category");

    }

    public void clickOnBackButton() throws InterruptedException {
        Element.selectElement(driver, back_button, "Click on Back Button");
    }

}
