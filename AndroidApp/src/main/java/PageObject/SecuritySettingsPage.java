package PageObject;

import com.amazonaws.auth.policy.actions.ElasticMapReduceActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

public class SecuritySettingsPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "mkab_icon_5")
    private AndroidElement security_settings_option;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Deregister UPI Account']")
    private AndroidElement deregister_account;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Deregister Account']")
    private AndroidElement deregister_account_popup;

    @AndroidFindBy(id = "horizontal_button_1")
    private AndroidElement yes_deregister;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Deregister successful']")
    private AndroidElement deregister_succesfull;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement cta_ok;

    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_button;

    @AndroidFindBy(id= "switch_enable_pin")
    private AndroidElement security_pin_toggle;

    @AndroidFindBy(id= "success_headline")
    private AndroidElement success_headline;

    @AndroidFindBy(id= "instruction_text")
    private AndroidElement success_page_instruction_text;

    @AndroidFindBy(id= "back_to_home_button")
    private AndroidElement cta_back_to_home;

    @AndroidFindBy(id= "layout_change_or_upgrade_pin")
    private AndroidElement btn_change_pin_action;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Your Current Security PIN']/following::android.widget.EditText")
    private AndroidElement enter_current_security_pin;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Enter 6 Digit Security PIN']/following::android.widget.EditText")
    private AndroidElement enter_new_security_pin;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Confirm 6 Digit Security PIN']/following::android.widget.EditText")
    private AndroidElement confirm_new_security_pin;

    @AndroidFindBy(id= "btn_change_pin_action")
    private AndroidElement cta_change_pin;


    @AndroidFindBy(id= "success_headline")
    private AndroidElement change_pin_success_page_title;

    @AndroidFindBy(id= "txnLock_forgetPIN")
    private AndroidElement cta_forget_security_pin;

    @AndroidFindBy(id= "edit_text")
    private AndroidElement mobile_number_field_in_forgot_pin_Flow;

    @AndroidFindBy(id= "continue_button")
    private AndroidElement cta_continue_button_recover_via_mobile_number;

    @AndroidFindBy(id= "tv_try_another_way")
    private AndroidElement cta_recover_via_other_options;

    @AndroidFindBy(id="progress_message")
    private AndroidElement progress_message;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Reset via Security Question']")
    private AndroidElement select_reset_via_security_questions;

    @AndroidFindBy(id="security_question_text")
    private AndroidElement get_security_question_text;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text = 'Your Answer']/following::android.widget.EditText")
    private AndroidElement enter_answer_to_security_question;

    @AndroidFindBy(id="submit_button")
    private AndroidElement cta_submit;

    @AndroidFindBy(id="confirm_pin_button")
    private AndroidElement confirm_pin_button;

    @AndroidFindBy(id="base_title")
    private AndroidElement get_success_page_title;

    @AndroidFindBy(id="go_to_home")
    private AndroidElement cta_back_to_home_from_success_page;









    public SecuritySettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Side Drawer Page*****");
    }


    public void ClickSecurityOptions() throws InterruptedException {
        Element.selectElement(driver, security_settings_option, "Select options");
    }

    public void ClickDeregisterFromOptions() throws InterruptedException {
        Element.selectElement(driver, deregister_account, "Select Deregister from Options");
    }

    public void ClickYesDeregisterAccount() throws InterruptedException {
        Element.selectElement(driver, yes_deregister, "Select Yes from Options");
    }

    public void ClickOk() throws InterruptedException {
        Element.selectElement(driver, cta_ok, "Select Ok");
    }

    public HomePage clickBackButton() throws InterruptedException {
        Element.selectElement(driver, back_button, "Navigate back to Home Page");
        return new HomePage(driver);
    }

    public void clickBackButtonWithinFlow() throws InterruptedException{
        Element.selectElement(driver, back_button, "Navigate back");
    }

    public void hitToggle() throws InterruptedException {
        Element.selectElement(driver, security_pin_toggle, "Hit Security Pin On/Off Toggle");
    }

    public String getSuccessPageTitleText() throws InterruptedException {
        return Element.getText(driver, success_headline, "Success Page Title Text");
    }

    public String getSuccessPageInstructionText() throws InterruptedException {
        return Element.getText(driver, success_page_instruction_text, "Success Page Instruction Text");
    }

    public void clickBackToHome() throws InterruptedException {
        Element.selectElement(driver, cta_back_to_home, "Click Back To Home");
    }

    public void clickChangeSecurityPinLabel() throws InterruptedException {
        Element.selectElement(driver, btn_change_pin_action, "Click Change Security Pin from Security pin Home page");
    }

    public void enterCurrentSecurityPin(String currentPin) throws InterruptedException{
        Element.enterText(driver, enter_current_security_pin, currentPin,"Enter Current Pin");
    }

    public void enterNewSecurityPin(String newPin) throws InterruptedException{
        Element.enterText(driver, enter_new_security_pin, newPin,"Enter New Pin");
    }

    public void confirmNewSecurityPin(String confirmPin) throws InterruptedException{
        Element.enterText(driver, confirm_new_security_pin, confirmPin,"Confirm New Pin");
    }

    public void clickChangeSecurityPinCta() throws InterruptedException {
        Element.selectElement(driver, cta_change_pin, "Click Change Security Pin from changing security pin Flow");
    }

    public String getChangePinSuccessPageText() throws InterruptedException {
        return Element.getText(driver, change_pin_success_page_title, "Change Pin Success Page Title Text");
    }

    public void clickForgetSecurityPinCta() throws InterruptedException {
        Element.selectElement(driver, cta_forget_security_pin, "Click Forget Security Pin.");
    }

    public String getMobileNumber() throws InterruptedException {
        return Element.getText(driver, mobile_number_field_in_forgot_pin_Flow, "Mobile Number non Editable field");
    }

    public void clickContinueToRecoverViaMobileNumber() throws InterruptedException {
        Element.selectElement(driver, cta_continue_button_recover_via_mobile_number, "Click Continue to recover via Mobile Number.");
    }

    public void clickToRecoverViaOtherOptions() throws InterruptedException {
        Element.selectElement(driver, cta_recover_via_other_options, "Click to recover via Other Options.");
    }

    public String getProgressMessageText() throws InterruptedException {
        return Element.getText(driver, progress_message, "Get Progress Message Text");
    }

    public void clickToRecoverViaSecurityQuestion() throws InterruptedException {
        Element.selectElement(driver, select_reset_via_security_questions, "Click to recover via Security Question.");
    }

    public String getQuestionText() throws InterruptedException {
        return Element.getText(driver, get_security_question_text, "Security Question is : ");
    }

    public void enterAnswer(String answer) throws InterruptedException{
        Element.enterText(driver,enter_answer_to_security_question, answer,"Add answer: ");
    }

    public void clickContinueToSubmitAnswer() throws InterruptedException {
        Element.selectElement(driver, cta_submit, "Click to Submit Answer.");
    }

    public void clickContinueToConfirmPin() throws InterruptedException {
        Element.selectElement(driver, confirm_pin_button, "Click to confirm pin.");
    }

    public String getSetupSuccessPageTitleText() throws InterruptedException {
        return Element.getText(driver, get_success_page_title, "Get Setup Success Page Title Text");
    }

    public void clickGoToHome() throws InterruptedException {
        Element.selectElement(driver, cta_back_to_home_from_success_page, "Go to home from setup success page.");
    }






}
