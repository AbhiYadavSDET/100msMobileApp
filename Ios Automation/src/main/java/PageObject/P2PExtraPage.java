package PageObject;

import Utils.Elements;
import groovy.transform.ImmutableOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.groovy.json.internal.IO;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.spi.IIOServiceProvider;

public class P2PExtraPage {

    IOSDriver driver;

    @iOSXCUITFindBy(id = "Xtra")
    private IOSElement xtra_icon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'Xtra')]")
    private IOSElement xtraIconOnAllServices;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get started\"]")
    private IOSElement cta_invest;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
    private IOSElement cta_click;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]")
    private IOSElement portfolio_value;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Withdraw\"]")
    private IOSElement withdraw_cta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Only one Withdrawal Request at a time\"]")
    private IOSElement one_time_withdraw_bottomsheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Got it\"]")
    private IOSElement gotIt_cta;

   // @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1\"]")
    private IOSElement amount_from_keyboard;

    @iOSXCUITFindBy(id = "Withdraw")
    private IOSElement withdraw_btn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm\"]")
    private IOSElement confirm_btn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bank holiday approaching!\"]")
    private IOSElement bank_holiday_bottomsheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please wait for the below request to be processed\"]")
    private IOSElement withdrawl_in_Progress_bottomsheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Withdrawal request placed successfully\"]")
    private IOSElement success_heading;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Withdrawal in progress\"]")
    private IOSElement error_title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private IOSElement refer_and_earn_widget;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private IOSElement ok_btn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Earnings\"]")
    private IOSElement earnings_table;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"backBtn\"]")
    private IOSElement back_btn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Know more\"]")
    private IOSElement know_more_btn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refer & earn ₹250 + 10%\"]")
    private IOSElement refer_page_title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
    private IOSElement settings_optn;

    @iOSXCUITFindBy(id = "OK")
    private IOSElement contactsPermission;

    @iOSXCUITFindBy(id = "Nominee")
    private IOSElement nominee_optn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOMINEE DETAILS\"]")
    private IOSElement nominee_details;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Invest More\"]")
    private IOSElement invest_more_btn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Invest Now\"]")
    private IOSElement invest_now_btn;

    @iOSXCUITFindBy(id = "Net Banking")
    private IOSElement net_banking_optn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MobiKwik\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[6]")
    private IOSElement axis_bank_optn;

    @iOSXCUITFindBy(id = "Allow While Using App")
    private IOSElement loc_popup;

    @iOSXCUITFindBy(id = "OK")
    private IOSElement ok_optn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment Gateway\"]")
    private IOSElement payments_page;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton\n")
    private IOSElement plus_tab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Proceed to pay\"]")
    private IOSElement proceed_to_pay_btn;


    public P2PExtraPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectGetStarted() throws InterruptedException {
        Elements.click(driver, cta_invest, "Get Started cta");
    }

    public void selectSkipReminder() throws InterruptedException {
        Elements.click(driver, cta_click ,"Click on SKIP on Daily SIP Reminder");
    }

    public boolean checkSkipReminder() throws InterruptedException {
       return Elements.isElementPresent(driver, cta_click);
    }

    public String getPortfolioValue() throws InterruptedException {
        return Elements.getText(driver, portfolio_value, "Get Portfolio Value");
    }

    public void clickWithdrawCta() throws InterruptedException {
        Elements.click(driver, withdraw_cta, "Click on Withdraw FLEXI");
    }

    public boolean checkOneTimeWithdrawBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, one_time_withdraw_bottomsheet);
    }

    public void clickGotItCta() throws InterruptedException {
        Elements.click(driver, gotIt_cta, "Click on Got It Cta");
    }

    public void clickGotItOnInprogressCta() throws InterruptedException {
        Elements.click(driver, gotIt_cta, "Click on Got It Cta");
    }

    public void enterAmount(String amount) { Elements.enterToElement(driver, amount_from_keyboard, amount , "Enter amount : 1");   }

    public void clickWithdrawBtn() throws InterruptedException {
        Elements.click(driver, withdraw_btn, "Click on Withdraw Button");
    }

    public void clickConfirmBtn() throws InterruptedException {
        Elements.click(driver, confirm_btn, "Click on Confirm Button");
    }

    public boolean checkBankHolidayBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, bank_holiday_bottomsheet);
    }

    public boolean checkWithdrawlInProgressBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, withdrawl_in_Progress_bottomsheet);
    }

    public String getErrorTitleText() throws InterruptedException {
        return Elements.getText(driver, error_title);
    }

    public String getSuccessTitle() throws InterruptedException {
        return Elements.getText(driver, success_heading);
    }

    public void clickReferWidget() throws InterruptedException {
        Elements.click(driver, refer_and_earn_widget, "Click on Refer and Earn Widget");
    }

    public void clickOKFromPopup() throws InterruptedException {
        Elements.click(driver, ok_btn, "Click OK on Contacts Pop-up");
    }

    public boolean checkPopup() throws InterruptedException {
        return Elements.isElementPresent(driver, ok_btn);
    }

    public void clickEarningsTable() throws InterruptedException {
        Elements.click(driver, earnings_table, "Click on Earnings Table");
    }

    public void clickBackBtn() throws InterruptedException {
        Elements.click(driver, back_btn, "Click on back btn");
    }

    public String getReferPageTitle() throws InterruptedException {
        return Elements.getText(driver, refer_page_title);
    }

    public void clickKnowMoreOptn() throws InterruptedException {
        Elements.click(driver, know_more_btn, "Click on Know More");
    }

    public boolean checkSettingOptn() throws InterruptedException {
        return Elements.isElementPresent(driver, settings_optn);
    }

    public void clickSettingOptn() throws InterruptedException {
         Elements.click(driver, settings_optn, "Click on Setting");
    }

    public void clickAllowContactPermission() throws InterruptedException {
        Elements.click(driver, contactsPermission,"Click OK on contact permission popup");
    }

    public void clickNomineeOptn()  {
        Elements.click(driver, nominee_optn, "Click on Nominee Option");
    }

    public String getNomineeName() throws InterruptedException {
       return Elements.getText(driver, nominee_details);
    }

    public void clickInvestMoreBtn() {
        Elements.click(driver, invest_more_btn, "Click on Invest More Button");
    }

    public void clickInvestNowBtn() {
        Elements.click(driver, invest_now_btn, "Click on Invest Now Button");
    }

    public void clickNetBanking() {
        Elements.click(driver, net_banking_optn, "Click on Net Banking");
    }

    public boolean checkNetBankingOptn() throws InterruptedException {
        return Elements.isElementPresent(driver, net_banking_optn);
    }

    public void clickAxisBankOptn() {
        Elements.click(driver, axis_bank_optn, "Click on Axis Bank");
    }

    public boolean checkLocationpopup() throws InterruptedException {
        return Elements.isElementPresent(driver, loc_popup);
    }

    public void clickAllow() {
        Elements.click(driver, loc_popup, "Click on Allow while Using App");
    }

    public void clickOK() {
        Elements.click(driver, ok_optn, "Click on Ok");
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, payments_page,"Get Title on Payments Page");
    }

    public void clickPlus() {
        Elements.click(driver, plus_tab, "Click on Plus");
    }

    public void clickProceedToPayBtn() {
        Elements.click(driver, proceed_to_pay_btn, "Click on Proceed to Pay");
    }

    public void clickOnXtraIcon() { Elements.click(driver, xtraIconOnAllServices, "Click on Xtra icon");}

}
