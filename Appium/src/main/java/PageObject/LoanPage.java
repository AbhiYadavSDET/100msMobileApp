package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoanPage {


    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Loans']")
    private AndroidElement loansButton;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/titleText")
    private AndroidElement loansText;

    @AndroidFindBy(id = "com.mobikwik_new.debug:id/cta")
    private AndroidElement loansCtaText;


    public LoanPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickLoansIcon() {
        Elements.selectElement(driver, loansButton, "Loans Icon");
    }

    public String getPageText() throws InterruptedException {
        return Elements.getText(driver, loansText, "Loan Screen Text");
    }

    public String getCtaText() throws InterruptedException {
        return Elements.getText(driver, loansCtaText, "Loan Screen Cta Text");
    }

}
