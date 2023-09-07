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

    @AndroidFindBy ( id= "cta")
    private AndroidElement cta_invest;

    @AndroidFindBy ( id= "tvOk")
    private AndroidElement plus_ok_popup;

    @AndroidFindBy ( id= "rbFlexi")
    private AndroidElement sliderBtnFlexi;

    @AndroidFindBy ( id= "ivFixed")
    private AndroidElement sliderBtnFixed;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Net Banking']")
    private AndroidElement selectNBOnCheckoutScreen;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Axis Bank']")
    private AndroidElement selectAxisBankFromBankList;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Complete your KYC']")
    private AndroidElement completeKycBottomsheet;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Got it']")
    private AndroidElement bottom_sheet_ad;



    // Withdrawal Amount Main Page.

    @AndroidFindBy (id= "edit_text")
    private AndroidElement withdrawal_amount_textBox;

    @AndroidFindBy (id="tvAvailableBal")
    private AndroidElement available_balance_to_withdraw;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")
    private AndroidElement withdraw_on_withdrawal_amount_page;

    @AndroidFindBy (id ="bank_name")
    private AndroidElement select_bank_to_withdraw;

    @AndroidFindBy (id = "cta")
    private AndroidElement withdraw_on_bottom_sheet;


    // Withdrawal amount success screen.

    @AndroidFindBy (id="title")
    private AndroidElement withdrawal_amount;

    @AndroidFindBy (id="subtitle")
    private AndroidElement withdrawal_status;

    @AndroidFindBy (id="tvHeading")
    private AndroidElement weekend_approaching;

    @AndroidFindBy (id="cta")
    private AndroidElement weekend_approaching_got_it_cta;


    //Refer & Earn Widget
    @AndroidFindBy (id = "referral_widget_layout")
    private AndroidElement referral_widget;

    @AndroidFindBy (id = "cl_total_earnings")
    private AndroidElement total_earnings_table;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Referrals']")
    private AndroidElement referrals_tab;



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

    public void selectOkfromPlusPopUp() throws InterruptedException{
        Element.selectElement(driver, plus_ok_popup,"Click OK on Tool tip of Xtra Plus Pop Up ");
    }

    public void selectFlexiFromNavBar() throws InterruptedException{
        Element.selectElement(driver, sliderBtnFlexi,"Select Flexi From Navbar");
    }

    public void selectFixedFromNavBar() throws InterruptedException{
        Element.selectElement(driver, sliderBtnFixed,"Select Fixed From Navbar");
    }

    public void selectNBOnCheckoutScreen() throws InterruptedException{
        Element.selectElement(driver, selectNBOnCheckoutScreen,"Select NetBanking From Checkout Screen");
    }

    public void selectAxisBankInNB() throws InterruptedException{
        Element.selectElement(driver, selectAxisBankFromBankList,"Select Axis Bank NetBanking option");
    }

    public void tapOutsideBottomSheet() throws InterruptedException{
        Element.selectElement(driver, bottom_sheet_xtra_main_page_remove,"Tap outside bottom sheet");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver,withdrawal_amount_textBox, amount, "Amount");
    }

    public String getWithdrawalAmount() throws InterruptedException{
        return Element.getText(driver, withdrawal_amount,"Get User Earned Amount");
    }

    public String getWithdrawalStatus() throws InterruptedException{
        return Element.getText(driver, withdrawal_status,"Get User Earned Amount");
    }

    public boolean isBottomSheetPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, bottom_sheet_ad);

    }

    public void removeBottomSheet() throws InterruptedException{
        Element.selectElement(driver, bottom_sheet_ad,"remove bottom sheet");
    }

    public boolean isKYCBottomSheetPresent() throws InterruptedException{
        return Elements.isElementPresent(driver, completeKycBottomsheet);

    }


    public int getIntegerPortfolioValue() throws InterruptedException{
        String portfolioValue = Element.getText(driver, portfolio_value,"Get User Portfolio Value");
        int lengthOfPV = portfolioValue.length();
        if(lengthOfPV >= 3){
            if(portfolioValue.charAt(lengthOfPV - 3) == '.'){
                portfolioValue = portfolioValue.substring(0,lengthOfPV-3);
            }
            else if(portfolioValue.charAt(lengthOfPV - 2) == '.'){
                portfolioValue = portfolioValue.substring(0,lengthOfPV-2);
            }
        }
        int value = Integer.parseInt(portfolioValue);
        return value;
    }

    public boolean checkWeekendApproachingBottomsheet() throws InterruptedException{
       return Elements.isElementPresent(driver, weekend_approaching);
    }

    public boolean checkOkfromPlusPopUp() throws InterruptedException{
        return Elements.isElementPresent(driver, plus_ok_popup );
    }

    public void clickGotItCtaWeekendApproaching() throws InterruptedException{
        Element.selectElement(driver, withdraw_on_withdrawal_amount_page,"Click on Got It Cta");
    }

    public void clickReferAndEarnWidget() throws InterruptedException{
        Element.selectElement(driver, referral_widget,"Click on Refer & Earn Widget");
    }

    public void clickEarningsTable() throws InterruptedException{
        Element.selectElement(driver, total_earnings_table,"Click on Earnings Table");
    }

    public void clickReferrals() throws InterruptedException{
        Element.selectElement(driver, referrals_tab,"Click on Referrals on Earning Page");
    }



}

