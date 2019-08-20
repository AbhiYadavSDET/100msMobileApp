package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class InsurancePage {

    IOSDriver driver;


    @iOSXCUITFindBy(id = "com.mobikwik_new:id/mkab_title")
    public IOSElement top_bar;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text = 'Home Insurance (Gas)']")
    private IOSElement image_gas_insurance;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/btnPrice")
    private IOSElement button_price;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/cta")
    private IOSElement cta_make_payment;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/txInsuranceSubHeading")
    private IOSElement fill_kyc_details_page_description;

    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private IOSElement fill_kyc_details_page_header;


    public InsurancePage(IOSDriver driver) throws IOException {

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

}
