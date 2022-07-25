package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class P2PExtraPage {

    AndroidDriver driver;

    @AndroidFindBy (id="tvAmount")
    private AndroidElement invested_amount;

    @AndroidFindBy (id="tvAmountEarning")
    private AndroidElement earned_amount;

    @AndroidFindBy (id="tvYourInterest")
    private AndroidElement perday_earning;

    @AndroidFindBy ( id= "ctaWithdraw")
    private AndroidElement cta_withdraw;

    @AndroidFindBy ( id= "ctaInvest")
    private AndroidElement cta_invest;

    @AndroidFindBy (id="tv_right")
    private AndroidElement cta_history;

    @AndroidFindBy (id ="mkab_icon_1")
    private AndroidElement back_button;

    @AndroidFindBy (id ="tvMessage")
    private AndroidElement timeout_message;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text= 'Retry']")
    private AndroidElement retry_cta;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text= 'Download Statement']")
    private AndroidElement history_download_statement_cta;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private AndroidElement history_txn_description;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[4]")
    private AndroidElement history_txn_amount;

    //Invest Amount Screen

    @AndroidFindBy (id= "edit_text")
    private AndroidElement amount_textBox;

    @AndroidFindBy (id= "tvAmount")
    private AndroidElement return_amount;

    @AndroidFindBy (id ="cta")
    private AndroidElement invest_now_cta;

    @AndroidFindBy (id= "tvInvestment")
    private AndroidElement total_investment;

    //Invest Success Page

    @AndroidFindBy (id="subtitle")
    private AndroidElement success_page_subtitle_text;
    //Investment is successful
    //Withdrawal request placed successfully

    @AndroidFindBy (id = "view_detail_text")
    private AndroidElement success_page_description_text;
    //You will start earning interest from 20th July '22 midnight
    //Your money will be deposited to your account within 24 business hours

    @AndroidFindBy (id = "title")
    private AndroidElement success_page_amount_invested;

    @AndroidFindBy (id = "back_icon")
    private AndroidElement success_page_back;

    //WithDraw Flow

    @AndroidFindBy (id= "edit_text")
    private AndroidElement withdrawal_amount_textBox;

    @AndroidFindBy (id="tvAvailableBal")
    private AndroidElement available_balance_to_withdraw;
    //Available Balance ₹2

    @AndroidFindBy (id ="cta")
    private AndroidElement withdraw_cta;

    //Confirm Withdraw
    @AndroidFindBy (id ="cta")
    private AndroidElement confirm_withdraw_cta;

    @AndroidFindBy (id= "bankHeading")
    private AndroidElement bank_bottom_sheet;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text = '2181XXXXXXXX']")
    private AndroidElement select_bank_to_withdraw;

    @AndroidFindBy (id ="cta")
    private AndroidElement bank_withdraw_cta;

    //WithDraw Success Page





    public P2PExtraPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****All Services Page*****");
    }

    public String getInvestedAmount() throws InterruptedException{
        return Element.getText(driver, invested_amount,"Get User Invested Amount");
    }

    public String getEarnedAmount() throws InterruptedException{
        return Element.getText(driver, earned_amount,"Get User Earned Amount");
    }

    public String getPerDayEarning() throws InterruptedException{
        return Element.getText(driver, perday_earning,"Get User per day Earning");
    }

    public void selectWithdraw() throws InterruptedException{
        Element.selectElement(driver, cta_withdraw,"Withdraw Amount cta");
    }

    public void selectInvestMore() throws InterruptedException{
        Element.selectElement(driver, cta_invest,"Invest More Amount cta");
    }

    public void selectHistoryCta() throws InterruptedException{
        Element.selectElement(driver, cta_history,"History cta");
    }

    public HomePage backToHomeButton() throws InterruptedException{
        Element.selectElement(driver, back_button,"Hit Back Button");
        return new HomePage(driver);
    }
    public void backButton() throws InterruptedException{
        Element.selectElement(driver, back_button,"Hit Back Button");
    }

    public String getErrorMessageText() throws InterruptedException{
        //We had a little hiccup! In the meantime you can check your network connection too!
        return Element.getText(driver, timeout_message,"Get Error Message Text");
    }

    public void retryCta() throws InterruptedException{
        Element.selectElement(driver, retry_cta,"Retry cta");
    }

    public void downloadStatementCta() throws InterruptedException{
        Element.selectElement(driver, history_download_statement_cta,"Download Statement cta");
    }

    public String getLatestTransactionRecord() throws InterruptedException{
         String description=Element.getText(driver, history_txn_description,"Description");
         String amount= Element.getText(driver, history_txn_amount,"Amount");
         return description+" : "+amount;
    }

    public void enterAmountToInvest(String amount) throws InterruptedException{
        Element.clearText(driver, amount_textBox, "", "Clear Existing Text");
        Element.enterText(driver, amount_textBox, amount, "Enter New Text");
    }

    public String getReturnAmount() throws InterruptedException{
        return Element.getText(driver, return_amount,"Get User Return Amount based on amount entered to invest");
    }

    public void selectInvestNow() throws InterruptedException{
        Element.selectElement(driver, invest_now_cta, "Select Invest Now");
    }

    public String getTotalInvestmentAmount() throws InterruptedException{
        return Element.getText(driver, total_investment,"Total investment Value").replace("₹","").replace("X","");
    }

    public void proceedToPay() throws InterruptedException{
        Element.selectElement(driver, invest_now_cta, "Select Proceed To Pay CTA");
    }

    public String getSuccessPageInvestedAmount() throws InterruptedException{
        return Element.getText(driver, success_page_amount_invested,"Get User Invested Amount on Success Page").replace("₹","").replace("X","");
    }

    public String getSuccessPageTitleText() throws InterruptedException{
        return Element.getText(driver, success_page_subtitle_text,"Get Success Page Title Text");
    }

    public String getSuccessPageDescriptionText() throws InterruptedException{
        return Element.getText(driver, success_page_description_text,"Get Success Page Description Text");
    }

    public void pressBackFromSuccessPage() throws InterruptedException{
        Element.selectElement(driver,success_page_back,"Press Back from Success Page");
    }

    //Withdraw

    public void enterAmountToWithdraw(String amount) throws InterruptedException{
        Element.enterText(driver, withdrawal_amount_textBox, amount, "Enter amount to Withdraw");
    }

    public String getAvailableBalanceToWithdraw() throws InterruptedException{
        return Element.getText(driver,available_balance_to_withdraw,"Get Available Balance to Withdraw").replace("Available Balance ₹","");
    }

    public void selectWithdrawCta() throws InterruptedException{
        Element.selectElement(driver, withdraw_cta, "Select Withdraw cta");
    }

    public void confirmWithdrawCta() throws InterruptedException{
        Element.selectElement(driver, confirm_withdraw_cta, "Confirm Withdraw cta");
    }

    public void selectBankToWithdraw() throws InterruptedException{
        Element.waitForVisibility(driver,bank_bottom_sheet );
        Element.selectElement(driver,select_bank_to_withdraw,"Select Bank to Withdraw");
    }

    public void bankWithdrawCta() throws InterruptedException{
        Element.selectElement(driver, bank_withdraw_cta, "Bank Withdraw cta");
    }









}


