package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Logger.Log;
import org.openqa.selenium.support.PageFactory;
import Utils.Element;

import java.io.IOException;

public class P2PExtraPage {

    AndroidDriver driver;


    // Xtra Main Page.

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Xtra']")
    private AndroidElement xtra_icon;

    @AndroidFindBy (id="non_focusing_scroll")
    private AndroidElement bottom_sheet_xtra_main_page;

    @AndroidFindBy (id="non_focusing_scroll")
    private AndroidElement bottom_sheet_xtra_main;

    @AndroidFindBy (id="touch_outside")
    private AndroidElement bottom_sheet_xtra_main_page_remove;

    @AndroidFindBy (id="tvAmount")
    private AndroidElement portfolio_value;

    @AndroidFindBy (id="tvAmountDesc")
    private AndroidElement invested_amount;

    @AndroidFindBy (id="tvAmountEarning")
    private AndroidElement earned_amount;

    @AndroidFindBy (id="tvYourInterest")
    private AndroidElement perday_earning;

    @AndroidFindBy ( id= "ctaWithdraw")
    private AndroidElement cta_withdraw;

    @AndroidFindBy ( id= "ctaInvest")
    private AndroidElement cta_invest;



    // Withdrawal Amount Main Page.

    @AndroidFindBy (id= "edit_text")
    private AndroidElement withdrawal_amount_textBox;

    @AndroidFindBy (id="tvAvailableBal")
    private AndroidElement available_balance_to_withdraw;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Withdraw']")
    private AndroidElement withdraw_on_withdrawal_amount_page;

    @AndroidFindBy (id ="bank_name")
    private AndroidElement select_bank_to_withdraw;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Withdraw ₹']")
    private AndroidElement withdraw_on_bottom_sheet;


    // Withdrawal amount success screen.

    @AndroidFindBy (id="title")
    private AndroidElement withdrawal_amount;

    @AndroidFindBy (id="subtitle")
    private AndroidElement withdrawal_status;



    public P2PExtraPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****All Services Page*****");
    }

    public void selectXtra() throws InterruptedException{
        Element.selectElement(driver,xtra_icon ,"Tap on xtra icon");
    }

    public String getPortfolioValue() throws InterruptedException{
        return Element.getText(driver, portfolio_value,"Get User Portfolio Value");
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

    public void selectWithdrawOnWithdrawAmount() throws InterruptedException{
        Element.selectElement(driver, withdraw_on_withdrawal_amount_page,"Withdraw Amount");
    }

    public void selectWithdrawOnBottomSheet() throws InterruptedException{
        Element.selectElement(driver, withdraw_on_bottom_sheet,"Withdraw Amount on bottom sheet");
    }

    public void selectBankOnBottomSheet() throws InterruptedException{
        Element.selectElement(driver, select_bank_to_withdraw,"Select bank on bottom sheet");
    }

    public void selectInvestMore() throws InterruptedException{
        Element.selectElement(driver, cta_invest,"Invest More Amount cta");
    }

    public void removeBottomSheet() throws InterruptedException{
        Element.selectElement(driver, bottom_sheet_xtra_main_page_remove,"remove bottom sheet");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver,withdrawal_amount_textBox, amount, "Amount");
    }


}

