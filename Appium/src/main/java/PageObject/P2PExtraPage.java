package PageObject;

import Logger.Log;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.Statement;

public class P2PExtraPage {

    AndroidDriver driver;


    // Xtra Main Page.


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Xtra']")
    private AndroidElement xtra_icon;

    @AndroidFindBy(id = "non_focusing_scroll")
    private AndroidElement bottom_sheet_xtra_main_page;

    @AndroidFindBy(id = "non_focusing_scroll")
    private AndroidElement bottom_sheet_xtra_main;

    @AndroidFindBy(id = "touch_outside")
    private AndroidElement bottom_sheet_xtra_main_page_remove;

    @AndroidFindBy(id = "tvAmount")
    private AndroidElement portfolio_value;

    @AndroidFindBy(id = "tvAmountDesc")
    private AndroidElement invested_amount;

    @AndroidFindBy(id = "tvAmountEarning")
    private AndroidElement earned_amount;

    @AndroidFindBy(id = "tvYourInterest")
    private AndroidElement perday_earning;

    @AndroidFindBy(id = "ctaWithdraw")
    private AndroidElement cta_withdraw;

    @AndroidFindBy(id = "cta")
    private AndroidElement cta_invest;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Review and pay']")
    private AndroidElement review_and_pay_btn;

    @AndroidFindBy(id = "tvOk")
    private AndroidElement plus_ok_popup;

    @AndroidFindBy(id = "rbFlexi")
    private AndroidElement sliderBtnFlexi;

    @AndroidFindBy(id = "ivFixed")
    private AndroidElement sliderBtnFixed;

    @AndroidFindBy(id="amount_edit_text")
    private AndroidElement investment_amount_box;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Net Banking']")
    private AndroidElement selectNBOnCheckoutScreen;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Axis Bank']")
    private AndroidElement selectAxisBankFromBankList;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Complete your KYC']")
    private AndroidElement completeKycBottomsheet;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Got it']")
    private AndroidElement bottom_sheet_ad;

    @AndroidFindBy(id = "permission_allow_button")
    private AndroidElement allow_SMS_permission;

    @AndroidFindBy(id = "bottom_sheet_text")
    private AndroidElement bank_page;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement errorMainTitle;

    @AndroidFindBy(id = "tvTitleAmount")
    private AndroidElement errorTitle;

    @AndroidFindBy(id = "tvAmount")
    private AndroidElement errorAmount;

    // Withdrawal Amount Main Page.

    @AndroidFindBy(id = "edit_text")
    private AndroidElement withdrawal_amount_textBox;

    @AndroidFindBy(id = "tvAvailableBal")
    private AndroidElement available_balance_to_withdraw;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Withdraw' and @index = '4']")
    private AndroidElement withdraw_on_withdrawal_amount_page;

    @AndroidFindBy(id = "bank_name")
    private AndroidElement select_bank_to_withdraw;

    @AndroidFindBy(id = "cta_escape")
    private AndroidElement withdraw_on_bottom_sheet;

    // Withdrawal amount success screen.

    @AndroidFindBy(id = "title")
    private AndroidElement withdrawal_amount;

    @AndroidFindBy(id = "subtitle")
    private AndroidElement withdrawal_status;

    @AndroidFindBy(id = "tvHeading")
    private AndroidElement weekend_approaching;

    @AndroidFindBy(id = "cta")
    private AndroidElement weekend_approaching_got_it_cta;

    @AndroidFindBy(id = "cta")
    private AndroidElement check_invest_more_cta;


    //Refer & Earn Widget
    @AndroidFindBy(id = "referral_widget_layout")
    private AndroidElement referral_widget;

    @AndroidFindBy(id = "cl_total_earnings")
    private AndroidElement total_earnings_table;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Referrals']")
    private AndroidElement referrals_tab;


    //Default Bank Account
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Settings']")
    private AndroidElement settings_option;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Email']")
    private AndroidElement email_title;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Default Bank Account']")
    private AndroidElement default_bank_account_option;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Primary Bank Account']")
    private AndroidElement primary_bank_account_title;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Cancel']")
    private AndroidElement cancel_btn_txt;

    @AndroidFindBy(id = "ctaEscape")
    private AndroidElement cancel_btn;


    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Nominee']")
    private AndroidElement nominee_option;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Add Nominee']")
    private AndroidElement add_nominee;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Add Bank']")
    private AndroidElement add_bank;

    @AndroidFindBy(id = "mkab_left_icon")
    private AndroidElement back_btn;

    @AndroidFindBy(id = "icon_cross")
    private AndroidElement back_btn_amountscreen;

    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[@index = 0]")
    private AndroidElement first_fixed_investment;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Re-invest']")
    private AndroidElement reinvest_btn;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Transfer to Bank']")
    private AndroidElement transfer_bank_btn;

    @AndroidFindBy(xpath = "//*/android.widget.RelativeLayout[@index = 0]")
    private AndroidElement select_reinvest;

    @AndroidFindBy(xpath = "//*/android.widget.RelativeLayout[@index = 1]")
    private AndroidElement select_transfer_to_bank;

    @AndroidFindBy(id = "tvSubHeading")
    private AndroidElement add_nominee_page_title;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Interest Certificate']")
    private AndroidElement interest_certificate;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = '2022-23']")
    private AndroidElement firstdate_interest_certificate;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Download']")
    private AndroidElement download_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Transaction Statements']")
    private AndroidElement transaction_ststement_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'This month']")
    private AndroidElement this_month;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Borrower List Report']")
    private AndroidElement borrower_list_report_txt;

    @AndroidFindBy(id = "tvValue")
    private AndroidElement click_onMaturity_option;


    @AndroidFindBy(id = "tvHeading")
    private AndroidElement dafault_bankAc_bottomsheet_title;

    @AndroidFindBy(id = "tvHeading")
    private AndroidElement nominee_details_page_heading;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'NAME']")
    private AndroidElement nominee_name;

    @AndroidFindBy(id = "ctaTransfer")
    private AndroidElement transfer_to_plus_btn;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Confirm']")
    private AndroidElement confirm_btn;

    @AndroidFindBy(xpath = "//*/android.view.TextView[@text = 'Invested Amount']")
    private AndroidElement first_investment_widget;

    @AndroidFindBy(id = "title")
    private AndroidElement reinvested_amount_flexi;

    @AndroidFindBy(id = "tvViewMore")
    private AndroidElement view_all_btn;

    @AndroidFindBy(id = "clParent")
    private AndroidElement notification_alert_widget;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private AndroidElement investment_widget;

    @AndroidFindBy(id = "title")
    private AndroidElement complete_kyc_bottomsheet;

    @AndroidFindBy(id = "clContainer")
    private AndroidElement invest_container;

    @AndroidFindBy(id = "btn_back")
    private AndroidElement refer_page_back_btn;

    @AndroidFindBy(xpath = "//*/android.view.TextView[@text = 'Refer & earn ₹250 + 10%']")
    private AndroidElement refer_page_title;

    @AndroidFindBy(id = "tv_know_more")
    private AndroidElement know_more_optn;

    @AndroidFindBy(id = "tvAmountDesc")
    private AndroidElement check_fixed_investment_amount;


    @AndroidFindBy(id = "cta")
    private AndroidElement got_it_btn_mapping_report;


    @AndroidFindBy(id = "error_text")
    private AndroidElement errorOnExceedAmount;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/txt_header_title")
    private AndroidElement info_page_heading;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/cta")
    private AndroidElement got_it_cta;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/tv_amount")
    private AndroidElement investment_amount;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Borrower preferences')]")
    private AndroidElement borrower_preference;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Pay')]")
    private AndroidElement pay_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text ='Read Again']")
    private AndroidElement read_again_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'I Understand']")
    private AndroidElement i_understand_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Your Loan Portfolio']")
    private AndroidElement portfolio_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Next Repayment']")
    private AndroidElement nextRepayment_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Invested amount']")
    private AndroidElement investeed_amt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Status']")
    private AndroidElement status_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Estimated Interest']")
    private AndroidElement estimated_interest_txt;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'View All Disbursed')]")
    private AndroidElement viewll_disbursedloan_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'MANAGE']")
    private AndroidElement manage_txt;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Settings']")
    private AndroidElement setting_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Reports & Statements']")
    private AndroidElement reportstatement_txt;

    @AndroidFindBy(id = "rv_main")
    private AndroidElement borrower_preference_bottomsheet;

    @AndroidFindBy(xpath = "//*[@text = 'All Services']")
    private AndroidElement allServicesCTA;

    public P2PExtraPage(AndroidDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);


        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****All Services Page*****");
    }

    public void allServicesCTA() throws InterruptedException{
        Elements.selectElement(driver,allServicesCTA,"Click on all services");
    }

    public void scrollToXtra() throws InterruptedException {
        Elements.scrollToElement(driver,xtra_icon);
    }
    public void selectXtra() throws InterruptedException {
        Element.selectElement(driver, xtra_icon, "Tap on xtra icon");
    }



    public String getPortfolioValue() throws InterruptedException {
        return Element.getText(driver, portfolio_value, "Get User Portfolio Value");
    }

    public String getInvestedAmount() throws InterruptedException {
        return Element.getText(driver, invested_amount, "Get User Invested Amount");
    }

    public String getEarnedAmount() throws InterruptedException {
        return Element.getText(driver, earned_amount, "Get User Earned Amount");
    }

    public String getPerDayEarning() throws InterruptedException {
        return Element.getText(driver, perday_earning, "Get User per day Earning");
    }

    public void selectWithdraw() throws InterruptedException {
        Element.selectElement(driver, cta_withdraw, "Withdraw Amount cta");
    }

    public void selectWithdrawOnWithdrawAmount() throws InterruptedException {
        Element.selectElement(driver, withdraw_on_withdrawal_amount_page, "Withdraw Amount");
    }

    public void selectWithdrawOnBottomSheet() throws InterruptedException {
        Element.selectElement(driver, withdraw_on_bottom_sheet, "Withdraw Amount on bottom sheet");
    }

    public void selectBankOnBottomSheet() throws InterruptedException {
        Element.selectElement(driver, select_bank_to_withdraw, "Select bank on bottom sheet");
    }


    public Boolean iserrorMessageOnWithdrawPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, errorOnExceedAmount);
    }

    public void selectInvestMore() throws InterruptedException {
        Element.selectElement(driver, cta_invest, "Invest More Amount cta");
    }

    public Boolean isBorrowerPreferenceBottomsheetVisible() throws InterruptedException {
        return Elements.isElementPresent(driver, borrower_preference_bottomsheet);
    }

    public void selectBorrowerPreferenceBottomsheet() throws InterruptedException {
        Element.selectElement(driver, borrower_preference_bottomsheet, "Close Borrower bottomsheet");
    }


    public void selectGetStarted() throws InterruptedException {
        Element.selectElement(driver, cta_invest, "Get Started cta");
    }

    public void selectProceedKYC() throws InterruptedException {
        Element.selectElement(driver, cta_invest, "Proceed KYC cta");
    }

    public void selectOkfromPlusPopUp() throws InterruptedException {
        Element.selectElement(driver, plus_ok_popup, "Click OK on Tool tip of Xtra Plus Pop Up ");
    }
    public Boolean isselectOkfromPlusPopUp() throws InterruptedException {
        return Elements.isElementPresent(driver, plus_ok_popup);
    }

    public void selectFlexiFromNavBar() throws InterruptedException {
        Element.selectElement(driver, sliderBtnFlexi, "Select Flexi From Navbar");
    }

    public void selectFixedFromNavBar() throws InterruptedException {
        Element.selectElement(driver, sliderBtnFixed, "Select Fixed From Navbar");
    }

    public boolean checkNavbar() throws InterruptedException {
        return Elements.isElementPresent(driver,sliderBtnFixed);
    }

    public void enterInvestmentAmount(String amount) throws InterruptedException {
        Element.waitForVisibility(driver,investment_amount_box);
        Element.clearText(driver, investment_amount_box, "Clear Existing Text");
        Thread.sleep(1000);
        Elements.enterToElement(driver, investment_amount_box, amount, "Enter Investment Amount");
    }

    public String getErrortextMessageOnAmountScreen() throws InterruptedException {
        return Element.getText(driver, errorOnExceedAmount, "Get Error on Amount Screen");
    }



    public void selectNBOnCheckoutScreen() throws InterruptedException {
        Element.selectElement(driver, selectNBOnCheckoutScreen, "Select NetBanking From Checkout Screen");
    }

    public boolean isNBOnCheckoutScreenPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, selectNBOnCheckoutScreen);
    }

    public void selectAxisBankInNB() throws InterruptedException {
        Element.selectElement(driver, selectAxisBankFromBankList, "Select Axis Bank NetBanking option");
    }

    public void tapOutsideBottomSheet() throws InterruptedException {
        Element.selectElement(driver, bottom_sheet_xtra_main_page_remove, "Tap outside bottom sheet");
    }

    public void enterAmount(String amount) {
        Elements.enterToElement(driver, withdrawal_amount_textBox, amount, "Amount");
    }

    public String getWithdrawalAmount() throws InterruptedException {
        return Element.getText(driver, withdrawal_amount, "Get User Earned Amount");
    }

    public String getErrorMainTitle() throws InterruptedException {
        return Element.getText(driver, errorMainTitle, "Get Error Main Title");
    }

    public String getErrorTitle() throws InterruptedException {
        return Element.getText(driver, errorTitle, "Get Error Title");
    }

    public String getErrorAmount() throws InterruptedException {
        return Element.getText(driver, errorAmount, "Get Error Amount");
    }

    public String getWithdrawalStatus() throws InterruptedException {
        return Element.getText(driver, withdrawal_status, "Get User Earned Amount");
    }

    public boolean isBottomSheetPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, bottom_sheet_ad);

    }

    public void removeBottomSheet() throws InterruptedException {
        Element.selectElement(driver, bottom_sheet_ad, "remove bottom sheet");
    }

    public boolean isKYCBottomSheetPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, completeKycBottomsheet);

    }


    public int getIntegerPortfolioValue() throws InterruptedException {
        String portfolioValue = Element.getText(driver, portfolio_value, "Get User Portfolio Value");
        int lengthOfPV = portfolioValue.length();
        if (lengthOfPV >= 3) {
            if (portfolioValue.charAt(lengthOfPV - 3) == '.') {
                portfolioValue = portfolioValue.substring(0, lengthOfPV - 3);
            } else if (portfolioValue.charAt(lengthOfPV - 2) == '.') {
                portfolioValue = portfolioValue.substring(0, lengthOfPV - 2);
            }
        }
        int value = Integer.parseInt(portfolioValue);
        return value;
    }

    public boolean checkWeekendApproachingBottomsheet() throws InterruptedException {
        return Elements.isElementPresent(driver, weekend_approaching);
    }

    public boolean checkOkfromPlusPopUp() throws InterruptedException {
        return Elements.isElementPresent(driver, plus_ok_popup);
    }

    public boolean checkWithdrawCta() throws InterruptedException {
        return Elements.isElementPresent(driver, cta_withdraw);
    }

    public void clickGotItCtaWeekendApproaching() throws InterruptedException {
        Element.selectElement(driver, withdraw_on_withdrawal_amount_page, "Click on Got It Cta");
    }

    public void clickReferAndEarnWidget() throws InterruptedException {
        Element.selectElement(driver, referral_widget, "Click on Refer & Earn Widget");
    }

    public boolean checkReferralWidget() throws InterruptedException {
        return Elements.isElementPresent(driver, referral_widget);
    }

    public void clickEarningsTable() throws InterruptedException {
        Element.selectElement(driver, total_earnings_table, "Click on Earnings Table");
    }

    public void clickReferrals() throws InterruptedException {
        Element.selectElement(driver, referrals_tab, "Click on Referrals on Earning Page");
    }

    public void clickSettings() throws InterruptedException {
        Element.selectElement(driver, settings_option, "Click on Settings Option ");
    }

    public boolean checkSettingsOptn() throws InterruptedException {
        return Elements.isElementPresent(driver, settings_option);
    }

    public void clickDefaultBankAccount() throws InterruptedException {
        Element.selectElement(driver, default_bank_account_option, "Click on Default Bank Account option");
    }

    public void clickNominee() throws InterruptedException {
        Element.selectElement(driver, nominee_option, "Click on Nominee Option");
    }

    public void clickCancelBtn() throws InterruptedException {
        Element.selectElement(driver, cancel_btn, "Click on Cancel Button");
    }

    public boolean checkAddNomineeOptn() throws InterruptedException {
        return Elements.isElementPresent(driver, add_nominee);
    }

    public boolean checkAddBankOptn() throws InterruptedException {
        return Elements.isElementPresent(driver, add_bank);
    }

    public void clickAddNominee() throws InterruptedException {
        Element.selectElement(driver, add_nominee, "Click on Add Nominee Option");
    }

    public void clickBackBtn() throws InterruptedException {
        Element.selectElement(driver, back_btn, "Click on Top Left Back Button");
    }


    public void clickBackBtnOnAmountScreen() throws InterruptedException {
        Element.selectElement(driver, back_btn_amountscreen, "Click on Top Left Back Button on amount screen");
    }

    public void clickAddBankBtn() throws InterruptedException {
        Element.selectElement(driver, add_bank, "Click on Add Bank Option");
    }

    public void click1stFixedInvestment() throws InterruptedException {
        Element.selectElement(driver, first_fixed_investment, "Click on First Fixed Investment");
    }

    public boolean checkReinvestBtn() throws InterruptedException {
        return Elements.isElementPresent(driver, reinvest_btn);
    }

    public void selectReinvestBtn() throws InterruptedException {
        Element.selectElement(driver, reinvest_btn, "Tap on Reinvest Button");
    }

    public void selectTransferToFlexiBtn() throws InterruptedException {
        Element.selectElement(driver, transfer_bank_btn, "Tap on Transfer To Bank Button");
    }

    public void selectReinvestoption() throws InterruptedException {
        Elements.tapByCoordinates(0, 0, driver);
        Elements.tapByCoordinates(0, 0, driver);
        Element.selectElement(driver, select_reinvest, "Change option to Re-invest");
    }

    public void selectTransferToBankOption() throws InterruptedException {
        Elements.tapByCoordinates(0, 0, driver);
        Element.selectElement(driver, select_transfer_to_bank, "Change option to Transfer to Bank");
    }

    public String getNomineeTitle() throws InterruptedException {
        return Elements.getText(driver, add_nominee_page_title, "Get Sub-Heading on Add Nominee Page");
    }

    public String getEmailTitle() throws InterruptedException {
        return Elements.getText(driver, email_title, "Get Sub-Heading on Add Nominee Page");
    }

    public String getDefaultBankAccountTitle() throws InterruptedException {
        return Elements.getText(driver, default_bank_account_option, "Get get fault bamk account");
    }

    public void selectDefaultBankAccountTitle() throws InterruptedException {
        Element.selectElement(driver, default_bank_account_option, "Click on  default bamk account");
    }

    public String getPrimaryBankAccountTitle() throws InterruptedException {
        return Elements.getText(driver, primary_bank_account_title, "Get Primary bank account title");
    }

    public String getInterestCertificate() throws InterruptedException {
        return Elements.getText(driver, interest_certificate, "Get Interest Certificate");
    }

    public void selectInterestCertificate() throws InterruptedException {
        Element.selectElement(driver, interest_certificate, "Click on Interest Certificate");
    }

    public void select22to23InterestCertificate() throws InterruptedException {
        Element.selectElement(driver, firstdate_interest_certificate, "Click on 22 to 23 Interest Certificate");
    }

    public void selectDownload() throws InterruptedException {
        Element.selectElement(driver, download_cta, "Click on downloadcta");
    }

    public String getTransactionStatement() throws InterruptedException {
        return Elements.getText(driver, transaction_ststement_txt, "Get Transaction statements");
    }

    public void selectTransactionStatement() throws InterruptedException {
        Element.selectElement(driver, transaction_ststement_txt, "Click on transaction ststement txt");
    }

    public void selectThisMonthStatement() throws InterruptedException {
        Element.selectElement(driver, this_month, "Click on this month");
    }

    public String getBorrowerListReport() throws InterruptedException {
        return Elements.getText(driver, borrower_list_report_txt, "Get Borrower List Report");
    }

    public String getDefaultBankAccTitle() throws InterruptedException {
        return Elements.getText(driver, dafault_bankAc_bottomsheet_title, "Get Heading on Default Bank Account Bottomsheet");
    }

    public String getNomineeDetails() throws InterruptedException {
        return Elements.getText(driver, nominee_details_page_heading, "Get Heading on Nominee Details Page");
    }

    public String getNomineeName() throws InterruptedException {
        return Elements.getText(driver, nominee_name, "Get Name of Nominee");
    }

    public String getReinvestoption() throws InterruptedException {
        Elements.tapByCoordinates(0, 0, driver);
        return Elements.getText(driver, reinvest_btn, "Check option Re-invest");
    }

    public String getTransferToBankBtn() throws InterruptedException {
        return Element.getText(driver, transfer_bank_btn, "Get Transfer To Bank Button");
    }

    public void selectTransferToPlusBtn() throws InterruptedException {
        Elements.selectElement(driver, transfer_to_plus_btn, "Click on Transfer to Plus Button");
    }

    public void selectConfirmBtn() throws InterruptedException {
        Elements.selectElement(driver, confirm_btn, "Click on Confirm Button");
    }

    public String getTransferAmount() throws InterruptedException {
        return Elements.getText(driver, reinvested_amount_flexi, "Get Amount on Txn Status Screen");
    }

    public void selectViewAllBtn() throws InterruptedException {
        Elements.selectElement(driver, view_all_btn, "Click on View All Button");
    }

    public boolean checkViewAllBtn() throws InterruptedException {
        return Elements.isElementPresent(driver, view_all_btn);
    }

    public void scrollToViewAllBtn() throws InterruptedException {
        Log.info("Scroll to View All Button");
        Elements.scrollToElement(driver, view_all_btn);
    }

    public void selectMaturityOptn() throws InterruptedException {
//        Elements.tapByCoordinates(723,1476, driver);
//        Screen.swipeUp();
        Elements.tapByCoordinates(0, 0, driver);
        Elements.selectElement(driver, click_onMaturity_option, "Click on Maturity Option");

    }

    public void selectFirstInvestment() throws InterruptedException {
        Elements.selectElement(driver, investment_widget, "Click on 1st On Going Investment");
    }

    public boolean checkNotificationAlert() throws InterruptedException {
        return Elements.isElementPresent(driver, notification_alert_widget);
    }

    public String getKycBottomsheetTitle() throws InterruptedException {
        return Elements.getText(driver, complete_kyc_bottomsheet, "Complete KYC bottomsheet");
    }

    public void selectAllowBtn() throws InterruptedException {
        Elements.selectElement(driver, allow_SMS_permission, "Click on Allow");
    }

    public String getBankPageTitle() throws InterruptedException {
        return Elements.getText(driver, bank_page, "Heading on Bank Page");
    }

    public String getConfirmCtaText() throws InterruptedException {
        return Elements.getText(driver, cta_invest, "Get Confirm button text");
    }

    public boolean checkInvestContainer() throws InterruptedException {
        return Elements.isElementPresent(driver, invest_container);
    }

    public void selectBackBtn() throws InterruptedException {
        Elements.selectElement(driver, refer_page_back_btn, "Click on Back Button");
    }

    public String getTitleText() throws InterruptedException {
        return Elements.getText(driver, refer_page_title, "Get Refer Page Title");
    }

    public String getKnowMoreOptn() throws InterruptedException {
        return Elements.getText(driver, know_more_optn, "Get Know More Text");
    }

    public boolean checkInvestMoreCta() throws InterruptedException {
        return Elements.isElementPresent(driver, check_invest_more_cta);
    }

    public boolean checkFixedInvestmentDesc() throws InterruptedException {
        return Elements.isElementPresent(driver, check_fixed_investment_amount);
    }

    public void clickGotItCtaBorrowerMappingReport() {
        Elements.selectElement(driver, got_it_btn_mapping_report, "Click on Got It on Borrower Mapping Report");
    }


    public boolean checkInfoPageHeading() throws InterruptedException {
       return Elements.isElementPresent(driver,info_page_heading);
    }

    public void clickGotIt() {
        Elements.selectElement(driver,got_it_cta,"Click on Got It");
    }

    public void clickReviewPayBtn() {
         Elements.selectElement(driver, review_and_pay_btn, "Click on Review and Pay");
    }

    public String getAmountOnSummaryPage() throws InterruptedException {
        return Elements.getText(driver,investment_amount,"Get the Investment Amount");
    }

    public void clickBorrowerPreferenceOnSummaryPage() {
        Elements.selectElement(driver,borrower_preference,"Click on Borrower Preference");
    }

    public String getAmountOnCTA() throws InterruptedException {
        return Elements.getText(driver,pay_cta,"Get Amount on Pay Button");
    }

    public void clickPayBtn() {
        Elements.selectElement(driver,pay_cta,"Click on Pay");
    }

    public void letterToInvestor() {
        Elements.selectElement(driver,read_again_cta,"Click on Read Again");
    }


    public Boolean IsletterToInvestor() throws InterruptedException {
        return Elements.isElementPresent(driver, read_again_cta);
    }

    public void iUnderstand() {
        Elements.selectElement(driver,i_understand_cta,"Click on I understand");
    }

    public String getPortfoliotxt() throws InterruptedException {
        return Elements.getText(driver,portfolio_txt,"Get Portfolio text");
    }

    public String getnextRepaymenttxt() throws InterruptedException {
        return Elements.getText(driver,nextRepayment_txt,"Get Next Repayment text");
    }

    public String getInvestedAmt() throws InterruptedException {
        return Elements.getText(driver,investeed_amt,"Get investment amount text");
    }

    public void clickOnInvestedAmt() {
        Elements.selectElement(driver,investeed_amt,"Click on Investes amount");
    }

    public String getStatus() throws InterruptedException {
        return Elements.getText(driver,status_txt,"Get status text");
    }

    public String getEstimatedInterest() throws InterruptedException {
        return Elements.getText(driver,estimated_interest_txt,"Get estimated interset text");
    }

    public void scrollToViewAllDisbursedLoan() throws InterruptedException {
        Elements.scrollToElement(driver,viewll_disbursedloan_cta);
    }

    public void clickOnViewAllDisbursedLoan() {
        Elements.selectElement(driver,viewll_disbursedloan_cta,"Click on view all disbursed loan");
    }

    public void scrollToSetting() throws InterruptedException {
        Elements.scrollToElement(driver,setting_cta);
    }

    public void clickonSetting() {
        Elements.selectElement(driver,setting_cta,"Click on setting cta");
    }

    public void scrollToReportAndStatement() throws InterruptedException {
        Elements.scrollToElement(driver,reportstatement_txt);
    }

    public void clickOnReportAndStatement() {
        Elements.selectElement(driver,reportstatement_txt,"Click on report and statement");
    }

}

