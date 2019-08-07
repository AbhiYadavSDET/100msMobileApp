package PageObject;

import Utils.Browser;
import Utils.Config;
import Utils.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class HelpPage {

    WebDriver driver;


    @FindBy(xpath = "//span[text()= 'Past Issue']")
    private WebElement button_past_issues;

    @FindBy(xpath = "//i[@class= 'mhlp mhlp_icopayment']")
    private WebElement button_add_money_icon;

    @FindBy(xpath = "//a[text()= 'New Issues']/following::span[@class= 'mat-button-wrapper'][1]")
    private WebElement button_report_issue;

    @FindBy(xpath = "//a[text()= 'My issue is not listed above ']")
    private WebElement text_question_link;

    @FindBy(xpath = "//textarea[@placeholder= 'Type a query']")
    private WebElement input_query;//p[text()= 'Ticket ID']/following::p[@class= 'fR fw600']

    //This is a test ticket being raised by automation suite. In case you are reading this , Please close the ticket.-MobiKwik Team

    @FindBy(xpath = "//span[text()= 'Send']")
    private WebElement button_raise_request;


    @FindBy(xpath = "//p[text()= 'Sorry for the inconvenience']")
    private WebElement text_sorry_inconvenience;

    @FindBy(xpath = "//p[text()= 'Ticket ID']/following::p[@class= 'fR fw600']")
    private WebElement ticket_id;


    public HelpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        Browser.waitForPageLoad(driver, button_past_issues);
        Config.logComment("*****On Help-Page*****");
    }



    public void selectAddMoneyIcon(){
        Element.selectElement(driver, button_add_money_icon, "Click on Add Money Icon");
    }

    public void selectIssueToReport(){
        Element.selectElement(driver, button_report_issue, "report the issue");
    }

    public void selectQuestionFromList(){
        Element.selectElement(driver, text_question_link, "Select question :My option not listed above");
    }

    public void enterQuery(String query){
        Element.enterText(driver, input_query, query, "Enter Query");
    }

    public void selectSend(){
        Element.selectElement(driver, button_raise_request, "Raise Request");
    }

    public String getTicketId(){
       return Element.getText(driver, ticket_id, "Get Ticket ID" );
    }

}
