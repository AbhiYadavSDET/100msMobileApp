package Helpers;

import Logger.Log;
import PageObject.LoanPage;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoanHelper {

    AndroidDriver<AndroidElement> driver;
    Elements elements;
    LoanPage loanPage;
    Screen screen;
    MBReporter mbReporter;


    public LoanHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        elements = new Elements(driver);
        loanPage = new LoanPage(driver);
        screen = new Screen(driver);
        mbReporter = new MBReporter(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyLoan(String expLoanPageText, String expLoanPageCtaText) throws InterruptedException, IOException {
        // Tap on Loan Page
        loanPage.clickLoansIcon();

        // Verification on the Loan screen
        String actualLoanPageText = loanPage.getPageText();
        String actualLoanPageCtaText = loanPage.getCtaText();

        // Display the values
        Log.info("Page Text : " + actualLoanPageText);
        Log.info("Cta Text : " + actualLoanPageCtaText);


        // Add the assertions
        mbReporter.verifyEquals(actualLoanPageText, expLoanPageText, "Verify Loan Page Text", false, false);
        mbReporter.verifyEquals(actualLoanPageCtaText, expLoanPageCtaText, "Verify Loan Page Cta Text", false, false);


    }


}
