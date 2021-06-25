package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class HelpPage {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Money']")
    private AndroidElement addMoney;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Money added to wallet']")
    private AndroidElement issue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My issue is not listed above ']")
    private AndroidElement ques;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Type a query']")
    private AndroidElement queryTextBox;

    @AndroidFindBy(id = "send_button")
    private AndroidElement send;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ticket ID']")
    private AndroidElement ticket;

    public HelpPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void chooseAddMoney() throws InterruptedException {
        Element.selectElement(driver, addMoney, "add money");
    }

    public void clickOnIssue() throws InterruptedException {
        Element.selectElement(driver, issue, "issue");
    }

    public void clickOnQues() throws InterruptedException {
        Element.selectElement(driver, ques, "ques");
    }

    public void typeQuery() throws InterruptedException {
        Element.enterText(driver, queryTextBox, "test test test test automation query", "Type your query");
    }

    public void clickOnSend() throws InterruptedException {
        Element.selectElement(driver, send, "send query");
    }

    public boolean isTicketIDVisible() throws InterruptedException {
        return Element.waitForVisibility(driver, ticket);
    }
}
