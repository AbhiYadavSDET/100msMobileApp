package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'History']")
    private AndroidElement historyTab;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Home']")
    private AndroidElement homeTab;

    @AndroidFindBy(id = "txt_transaction_summary")
    private AndroidElement historyDescription;

    @AndroidFindBy(xpath = "//*/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement historyAmount;

    @AndroidFindBy(id = "txt_status")
    private AndroidElement historyStatus;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'MobiKwik']")
    private AndroidElement mobikwik_header;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Bank A/C']")
    private AndroidElement bankAccount_header;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Credit Card']")
    private AndroidElement creditCard_header;

    @AndroidFindBy(id = "tv_btn")
    private AndroidElement letdoit_cta;

    @AndroidFindBy(id = "iv_title")
    private AndroidElement firsttimeuser_description_on_hisory;

    @AndroidFindBy(id = "txt_aa_not_setup_cta")
    private AndroidElement txt_aa_not_setup_cta;
    @AndroidFindBy(id = "txt_aa_not_setup_title")
    private AndroidElement txt_aa_not_setup_title;

    @AndroidFindBy(id = "txt_amount")
    private AndroidElement totalBalance;

    @AndroidFindBy(id = "txt_categories")
    private AndroidElement txt_categories;

    @AndroidFindBy(id = "txt_help")
    private AndroidElement txt_help;

    @AndroidFindBy(id = "txt_transaction_summary")
    private AndroidElement txt_transaction_summary;
    @AndroidFindBy(id = "mkab_icon_1")
    private AndroidElement back_cta_invoice;
    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Done']")
    private AndroidElement done_cta;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Insights']")
    private AndroidElement insight_cta;

    @AndroidFindBy(id = "ic_arrow_right_without_padding")
    private AndroidElement right_arrow_nexttobank;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Re-Link Bank Accounts']")
    private AndroidElement relink_bankaccount;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'SELECT YOUR BANK']")
    private AndroidElement txt_select_your_bank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='txt_transaction_summary'])[1]]")
    private AndroidElement second_byid_ontx;

    @AndroidFindBy(xpath = "android.widget.Button[@text = 'Enable Now']")
    private AndroidElement secureLoginBottomSheet;

    public HistoryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickHistoryTab() {
        Elements.selectElement(driver, historyTab, "History Tab");
    }

    public void clickHomeTab() {
        Elements.selectElement(driver, homeTab, "Home Tab");
    }

    public boolean isHistoryDesciptionPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, historyDescription);
    }

    public String getDescription() throws InterruptedException {
        return Elements.getText(driver, historyDescription, "History Description");
    }

    public String getAmount() throws InterruptedException {
        return Elements.getText(driver, historyAmount, "History Amount");
    }

    public String getStatus() throws InterruptedException {
        return Elements.getText(driver, historyStatus, "History Status");
    }

    public void clickMobikwikHeaderOnHistory() {
        Elements.selectElement(driver, mobikwik_header, "Mobikwik Tab on History Section");
    }

    public void clickBankAccountOnHistory() {
        Elements.selectElement(driver, bankAccount_header, "Bank Account Tab on History Section");
    }

    public void clickCreditCardOnHistory() {
        Elements.selectElement(driver, creditCard_header, "Credit card Tab on History Section");
    }

    public boolean isLetsDobuttonPresentOnMobiwiktab() throws InterruptedException {
        return Elements.isElementPresent(driver, letdoit_cta);
    }

    public boolean isdescriptionPresentOnMobiwiktab() throws InterruptedException {
        return Elements.isElementPresent(driver, firsttimeuser_description_on_hisory);
    }

    public boolean isNotSetupAACTA() throws InterruptedException {
        return Elements.isElementPresent(driver, txt_aa_not_setup_cta);
    }

    public boolean isNotSetupAAtTitle() throws InterruptedException {
        return Elements.isElementPresent(driver, txt_aa_not_setup_title);
    }

    public boolean isTotalBalancePresent() throws InterruptedException {
        return Elements.isElementPresent(driver, totalBalance);
    }

    public String getCategoriesText() throws InterruptedException {
        return Elements.getText(driver, txt_categories, "Category Text");
    }

    public void clickonAllCategories() {
        Elements.selectElement(driver, txt_categories, "Click on Category Text");
    }

    public String getHelpText() throws InterruptedException {
        return Elements.getText(driver, txt_help, "Help Text");
    }

    public boolean isTxnHistoryDataPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, txt_transaction_summary);
    }

    public void clickonTxnHistoryDataPresent() {
        Elements.selectElement(driver, txt_transaction_summary, "Click on Txn History");
    }

    public void clickonBackCTAOnInvoiceTxn() {
        Elements.selectElement(driver, back_cta_invoice, "Click on Back CTA on Invoice");
    }

    public void clickonDoneCTAOnselectCategoryPage() {
        Elements.selectElement(driver, done_cta, "Click on Done CTA on Select Categories");
    }


    public void clickOnRightArrowNexttobankNo() {
        Elements.selectElement(driver, right_arrow_nexttobank, "Click on right arrow next to bank");
    }

    public void clickOnRelinkBankAccount() {
        Elements.selectElement(driver, relink_bankaccount, "Click on Relink Bank account");
    }

    public String getTxtSelectYourBank() throws InterruptedException {
        return Elements.getText(driver, txt_select_your_bank, "Select your bank txt");
    }


    public String getIsightTxt() throws InterruptedException {
        return Elements.getText(driver, insight_cta, "Get insight txt");
    }

    public void clickonsecondelement()
    {
        Elements.selectElement(driver, second_byid_ontx, "click on second element");
    }

    public boolean isSecureLoginBottomSheetPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, secureLoginBottomSheet);
    }

}




