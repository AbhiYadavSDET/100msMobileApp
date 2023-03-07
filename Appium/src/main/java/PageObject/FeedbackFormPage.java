package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FeedbackFormPage {

    AndroidDriver driver;

    @AndroidFindBy(id = "mkab_left_icon")
    private AndroidElement backButton;

    @AndroidFindBy(id = "iv_cross")
    private AndroidElement crossButton;

    @AndroidFindBy(xpath = "//*/android.widget.CompoundButton[@text = 'Trying out']")
    private AndroidElement suggestion1;

    @AndroidFindBy(xpath = "/*//android.widget.CompoundButton[@text = 'Recharge & Bill Payments']")
    private AndroidElement title;

//    @AndroidFindBy(xpath = "//*/android.widget.CompoundButton[@text = 'Not able to make payment']")
//    private AndroidElement suggestion2;
//
//    @AndroidFindBy(xpath = "//*/android.widget.CompoundButton[@text = 'Looking for Credit Card']")
//    private AndroidElement suggestion3;
//
//    @AndroidFindBy(xpath = "//*/android.widget.CompoundButton[@text = 'No bill due']")
//    private AndroidElement suggestion4;
//
//    @AndroidFindBy(xpath = "//*/android.widget.CompoundButton[@text = 'No offers']")
//    private AndroidElement suggestion5;
//
//    @AndroidFindBy(xpath = "//*/android.widget.CompoundButton[@text = 'Other']")
//    private AndroidElement others;

//    @AndroidFindBy(id = "et_others")
//    private AndroidElement reasonTextBox;

    @AndroidFindBy(id = "btn_cta")
    private AndroidElement submitButton;


    public FeedbackFormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickBackButton(){
        Elements.selectElement(driver,backButton, "Click Back button");
    }

    public void clickCrossButton(){
        Elements.selectElement(driver,crossButton, "Click cross button");
    }

    public void clickSuggestion(){
        Elements.selectElement(driver,suggestion1,"Click on Trying out option");
    }
//
//    public void clickOther(){
//        Elements.selectElement(driver, others, "Click on Others");
//    }
//
//    public void clickReasonTextBox(){
//        Elements.selectElement(driver, reasonTextBox, "click on enter reason text box");
//    }

    public void clickSubmitButton(){
        Elements.selectElement(driver, submitButton, "Click on Submit button");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");

    }


}
