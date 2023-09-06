package PageObject;

import Utils.Elements;
import Utils.MobiKwikScreen;
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

    @AndroidFindBy (id = "cta_escape")
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


    //Default Bank Account
    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Settings']")
    private AndroidElement settings_option;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Default Bank Account']")
    private AndroidElement default_bank_account_option;

    @AndroidFindBy (id = "ctaEscape")
    private AndroidElement cancel_btn;


    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Nominee']")
    private AndroidElement nominee_option;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Add Nominee']")
    private AndroidElement add_nominee;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Add Bank']")
    private AndroidElement add_bank;

    @AndroidFindBy (id = "mkab_left_icon")
    private AndroidElement back_btn;

    @AndroidFindBy (xpath = "//*/android.view.ViewGroup[@index = 0]")
    private AndroidElement first_fixed_investment;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Re-invest']")
    private AndroidElement reinvest_btn;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Transfer to Flexi']")
    private AndroidElement transfer_flexi_btn;

    @AndroidFindBy (xpath = "//*/android.widget.RelativeLayout[@index = 0]")
    private AndroidElement select_reinvest;

    @AndroidFindBy (xpath = "//*/android.widget.RelativeLayout[@index = 1]")
    private AndroidElement select_transfer_to_flexi;

    @AndroidFindBy (id = "tvSubHeading")
    private AndroidElement add_nominee_page_title;

    @AndroidFindBy (id = "tvHeading")
    private AndroidElement dafault_bankAc_bottomsheet_title;

    @AndroidFindBy (id = "tvHeading")
    private AndroidElement nominee_details_page_heading;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'NAME']")
    private AndroidElement nominee_name;

    @AndroidFindBy (id = "ctaTransfer")
    private AndroidElement transfer_to_plus_btn;

    @AndroidFindBy (xpath = "//*/android.widget.TextView[@text = 'Confirm']")
    private AndroidElement confirm_btn;

    @AndroidFindBy (xpath = "//*/android.view.ViewGroup[]")
    private AndroidElement first_investment_widget;



    @AndroidFindBy (id="title")
    private AndroidElement reinvested_amount_flexi;

    @AndroidFindBy (id="tvViewMore")
    private AndroidElement view_all_btn;

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

    public void clickSettings() throws InterruptedException{
        Element.selectElement(driver, settings_option,"Click on Settings Option ");
    }

    public void clickDefaultBankAccount() throws InterruptedException{
        Element.selectElement(driver, default_bank_account_option,"Click on Default Bank Account option");
    }

    public void clickNominee() throws InterruptedException{
        Element.selectElement(driver, nominee_option,"Click on Nominee Option");
    }

    public void clickCancelBtn() throws InterruptedException{
        Element.selectElement(driver, cancel_btn,"Click on Cancel Button");
    }

    public boolean checkAddNomineeOptn() throws InterruptedException{
        return Elements.isElementPresent(driver, add_nominee );
    }

    public boolean checkAddBankOptn() throws InterruptedException{
        return Elements.isElementPresent(driver, add_bank );
    }

    public void clickAddNominee() throws InterruptedException{
        Element.selectElement(driver, add_nominee,"Click on Add Nominee Option");
    }

    public void clickBackBtn() throws InterruptedException{
        Element.selectElement(driver, back_btn,"Click on Top Left Back Button");
    }

    public void clickAddBankBtn() throws InterruptedException{
        Element.selectElement(driver, add_bank,"Click on Add Bank Option");
    }

    public void click1stFixedInvestment() throws InterruptedException{
        Element.selectElement(driver, first_fixed_investment,"Click on First Fixed Investment");
    }

    public boolean checkReinvestBtn() throws InterruptedException{
        return Elements.isElementPresent(driver, reinvest_btn );
    }

    public void selectReinvestBtn() throws InterruptedException{
        Element.selectElement(driver,reinvest_btn ,"Tap on Reinvest Button");
    }

    public void selectTransferToFlexiBtn() throws InterruptedException{
        Element.selectElement(driver,transfer_flexi_btn ,"Tap on Transfer To Flexi Button");
    }

    public void selectReinvestoption() throws InterruptedException{
        Element.selectElement(driver,select_reinvest ,"Change option to Re-invest");
    }

    public void selectTransferToFlexioption() throws InterruptedException{
        Element.selectElement(driver,select_transfer_to_flexi ,"Change option to Transfer to Flexi");
    }

    public String getNomineeTitle() throws InterruptedException{
        return Elements.getText(driver, add_nominee_page_title,"Get Sub-Heading on Add Nominee Page");
    }

    public String getDefaultBankAccTitle() throws InterruptedException{
        return Elements.getText(driver, dafault_bankAc_bottomsheet_title,"Get Heading on Default Bank Account Bottomsheet");
    }

    public String getNomineeDetails() throws InterruptedException{
        return Elements.getText(driver, nominee_details_page_heading,"Get Heading on Nominee Details Page");
    }

    public String getNomineeName() throws InterruptedException{
        return Elements.getText(driver, nominee_name,"Get Name of Nominee");
    }

    public String selectTransferToPlusBtn() throws InterruptedException{
        return Elements.getText(driver, transfer_to_plus_btn,"Click on Transfer to Plus Button");
    }

    public String selectConfirmBtn() throws InterruptedException{
        return Elements.getText(driver, confirm_btn,"Click on Confirm Button");
    }

    public String getTransferAmount() throws InterruptedException{
        return Elements.getText(driver, reinvested_amount_flexi,"Get Amount on Txn Status Screen");
    }

    public String selectViewAllBtn() throws InterruptedException{
        return Elements.getText(driver, view_all_btn,"Click on View All Button");
    }

    public String selectFirstInvestment() throws InterruptedException{
        return Elements.getText(driver, first_investment_widget,"Click on 1st Investment");
    }


}

