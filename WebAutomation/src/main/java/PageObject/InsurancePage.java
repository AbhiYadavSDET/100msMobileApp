package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage {

    WebDriver driver;

    @FindBy(xpath = "//p[text() = 'Home Insurance (Gas)']")
    private WebElement label_insurance_gas;

    @FindBy(xpath = "//p[text() = 'Insurance helps you in protecting your financial loss.']")
    private WebElement label_insurance_page_load;

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']")
    private WebElement tick_icon;

    @FindBy(xpath = "//i[@class = 'mg mg_icotick fnlgrp tgreen2']/following::div[1]")
    private WebElement label_trx_status;

    @FindBy(xpath = "//small[text() = 'Policy Number']/following::p[1]")
    private WebElement label_policy_id;

    @FindBy(xpath = "//button[text() = '₹ 25']")
    private WebElement button_price;

    @FindBy(xpath = "//span[text() = 'Make Payment']")
    private WebElement cta_make_payment;


    public InsurancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, label_insurance_page_load);
        Config.logComment("*****On Insurance Page*****");
    }


    public void waitForTickIcon() {
        Element.waitForVisibility(driver, tick_icon, "Tick Icon");
    }

    public String getTrxStatus() {
        return Element.getText(driver, label_trx_status, "TRX Status");
    }

    public String getPolicyId() {
        return Element.getText(driver, label_policy_id, "Policy Id");
    }

    public void clickOnInsuranceGas() {
        Element.selectElement(driver, label_insurance_gas, "Insurance Gas");
    }

    public void clickOnPrice() {
        Element.selectElement(driver, button_price, "Price");
    }

    public void clickOnMakePayment() {
        Element.selectElement(driver, cta_make_payment, "Make Payment");
    }

}








