package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
//import utils.Element;

import java.io.IOException;

public class HelpAndSupportPage {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Help & Support']")
    private AndroidElement helpAndSupport;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Money Transfer']")
    private AndroidElement moneyTransfer;

    @AndroidFindBy(id = "title")
    private AndroidElement selectTransaction;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My issue is not listed above ']")
    private AndroidElement selectQues;

    @AndroidFindBy(id = "help_edit_text")
    private AndroidElement queryTextBox;

    @AndroidFindBy(id = "primary_button")
    private AndroidElement popUp;

    @AndroidFindBy(id = "tv_title")
    private AndroidElement title;

    @AndroidFindBy(id = "send_button")
    private AndroidElement send;

    public HelpAndSupportPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnHelpAndSupport() throws InterruptedException {
        Elements.selectElement(driver, helpAndSupport, "add money");
    }

    public void clickOnIssue() throws InterruptedException {
        Elements.selectElement(driver, moneyTransfer, "issue");
    }

    public void selectTransaction() throws InterruptedException {
        Elements.selectElement(driver, selectTransaction, "issue");
    }


    public void clickOnQues() throws InterruptedException {
        Elements.selectElement(driver, selectQues, "ques");
    }

    public void tapOnQuery() throws InterruptedException {
        Elements.selectElement(driver, queryTextBox, "ques");
    }

    public void typeQuery(String query) throws InterruptedException {
        Elements.enterToElement(driver, queryTextBox, query, "Type your query");
    }

    public void clickOnSend() throws InterruptedException {
        Elements.selectElement(driver, send, "send query");
    }

    public void clickOnOk() throws InterruptedException {
        Elements.selectElement(driver, popUp, "send query");
    }

    public boolean isPopUpPresent() throws InterruptedException {
        return Elements.isElementPresent(driver, popUp);
    }

    public String getTitle() throws InterruptedException {
        return Elements.getText(driver, title, "Base Title");
    }


}
