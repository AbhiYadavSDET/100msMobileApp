package test.java.AndroidApp.PageObject;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import main.java.utils.Element;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HelpPage {
    IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Add Money']")
    private IOSElement addMoney;

    @iOSXCUITFindBy(xpath = "//android.widget.RelativeLayout/following::android.widget.TextView[@text='Money added to wallet']")
    private IOSElement issue;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='My issue is not listed above ']")
    private IOSElement ques;

    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@text='Type a query']")
    private IOSElement queryTextBox;

    @iOSXCUITFindBy(id = "com.mobikwik_new:id/send_button")
    private IOSElement send;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text='Ticket ID']")
    private IOSElement ticket;

    public HelpPage(IOSDriver driver) throws IOException {
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
