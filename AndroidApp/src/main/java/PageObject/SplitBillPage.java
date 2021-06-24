package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;
import utils.Screen;

import java.io.IOException;

public class SplitBillPage {

    AndroidDriver driver;

    @AndroidFindBy(id="btn_action")
    private AndroidElement lets_start_button;

    @AndroidFindBy(id="permission_allow_button")
    private AndroidElement allow_permission;

    @AndroidFindBy(id="edit_text_mket")
    private AndroidElement search_box;

    @AndroidFindBy(id="select_check_box")
    private AndroidElement click_checkbox;

    @AndroidFindBy(id="button_done")
    private AndroidElement submit_button;

    @AndroidFindBy(id="amount_field")
    private AndroidElement amount_field;

    @AndroidFindBy(id="confirm_cta")
    private AndroidElement confirm_button;

    @AndroidFindBy(id="base_title")
    private AndroidElement success_message;

    @AndroidFindBy(id="bill_amount")
    private AndroidElement success_amount;

    @AndroidFindBy(id="base_icon_close")
    private AndroidElement exit_button;

    public SplitBillPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****Split Bill Page*****");
    }

    public void clickOnStart() throws InterruptedException{
        Element.selectElement(driver, lets_start_button, "Click on Let's Start Button");
    }

    public void clickOnAllow() throws InterruptedException{
        Element.selectElement(driver, allow_permission, "Click on Allow Permission ");
    }

    public void clickAndEnterText(String name) throws InterruptedException{
        Element.selectElement(driver, search_box, "Click on Search Box");
        Element.enterText(driver, search_box, name, "Entering First Name");
    }

    public void clickCheckbox() throws InterruptedException{
        Element.selectElement(driver, click_checkbox, "Click on Checkbox");
    }

    public void clearSearchText(String name) throws InterruptedException{
        Element.clearText(driver, search_box, name, "Clearing input text");
    }

    public void clickContinue() throws InterruptedException{
        Element.selectElement(driver, submit_button, "Click on Continue Button");
    }

    public void clickAndEnterAmount(String amount) throws InterruptedException{
        Element.selectElement(driver, amount_field, "Clicking on Amount Field");
        Element.enterText(driver, amount_field, amount, "Entering Amount" );
    }

    public void clickConfirm() throws InterruptedException{
        Element.selectElement(driver, confirm_button, "Click on Confirm(FinalContinue) Button");
    }

    public String getSuccessMsg() throws InterruptedException{
        return Element.getText(driver, success_message, "Get Success Screen Message");
    }

    public String getSuccessAmount() throws InterruptedException{
        return Element.getText(driver, success_amount, "Get Success Screen Amount");
    }

    public void clickOnClose() throws InterruptedException {
        Element.selectElement(driver, exit_button, "Click on Close Button");
    }

}
