package PageObject;

import Logger.Log;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ReferAndEarnPage {

    AndroidDriver driver;

//    @AndroidFindBy(xpath = "//*[@text = 'All Services']")
//    private AndroidElement allServicesCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Refer & Earn']")
    private AndroidElement refer_and_earn_cta;

    @AndroidFindBy(id = "title")
    private AndroidElement title_text;

    @AndroidFindBy(id = "tv_know_more")
    private AndroidElement know_more_cta;

    @AndroidFindBy(id = "ctaViewTnc")
    private AndroidElement view_tnc_option;

    @AndroidFindBy(id = "refer_now_btn")
    private AndroidElement refer_cta;

    @AndroidFindBy(id = "not_on_mobikwik")
    private AndroidElement click_eligible_contacts_btn;

    @AndroidFindBy(id = "tv_title_total_earning")
    private AndroidElement earnings_sub_heading;

    @AndroidFindBy(id = "tv_title_referrals")
    private AndroidElement referrals_sub_heading;

    @AndroidFindBy(id = "button_accept")
    private AndroidElement allow_btn;

    @AndroidFindBy(id = "tv_waiting_users")
    private AndroidElement invite_contacts;

    @AndroidFindBy(id = "desc")
    private AndroidElement desc_first_time_user;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Timely reminders']")
    private AndroidElement insights_bottomsheet;

    @AndroidFindBy(id = "tv_cta")
    private AndroidElement refer_btn_on_widget;

    @AndroidFindBy(id = "title")
    private AndroidElement title_on_ccbp_page;


    public ReferAndEarnPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        /*
        To Do
        wait for Page load to be added
         */
        Log.info("*****Refer & Earn Page*****");
    }



    public void clickAndNavigateToReferAndEarn() throws InterruptedException {
        Elements.scrollToElement(driver, refer_and_earn_cta );
        Element.selectElement(driver, refer_and_earn_cta, "Select Refer & Earn");
    }

    public Boolean getTitleonUPIPage() throws InterruptedException {
        String title = Elements.getText(driver,title_text);
        if(title != null) {
            return true;
        }else {
            return false;
        }
    }

    public void clickKnowMoreCTA() {
        Elements.selectElement(driver,know_more_cta,"Click on Know More Option");
    }

    public void clickTermAndCondition() {
        Elements.selectElement(driver,view_tnc_option,"Click on View Terms and Conditions");
    }

    public void clickReferBtn() {
        Elements.selectElement(driver,refer_cta,"Click on Refer Now Button");
    }

    public void clickOnEligibleContacts() {
        Elements.selectElement(driver,click_eligible_contacts_btn,"Click on Eligible Contacts");
    }

    public Boolean getTotalEarnings() throws InterruptedException {
        String earnings = Elements.getText(driver,earnings_sub_heading);
        if(earnings != null) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean getSucessfullReferals() throws InterruptedException {
        String referrals = Elements.getText(driver,referrals_sub_heading);
        if(referrals != null) {
            return true;
        }else {
            return false;
        }
    }

    public void clickOnAllowBtn() {
        Elements.selectElement(driver,allow_btn,"Click on Allow");
    }

    public void clickOnInvite() {
        Elements.selectElement(driver,invite_contacts,"Click For Invitations");
    }

    public String getDesc() throws InterruptedException,IOException {
        return Elements.getText(driver,desc_first_time_user);
    }

    public Boolean checkInsightBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver,insights_bottomsheet);
    }

    public void clickReferAndEarn() {
        Elements.selectElement(driver,refer_btn_on_widget,"Click on Refer and Earn Widget");
    }

    public Boolean getTitleonCCPBPage() throws InterruptedException {
        String titleOnCCBP = Elements.getText(driver,title_on_ccbp_page);
        if(titleOnCCBP != null) {
            return true;
        }else {
            return false;
        }
    }


}
