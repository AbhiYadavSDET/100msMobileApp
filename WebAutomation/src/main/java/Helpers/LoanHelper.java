package Helpers;


import PageObject.HomePage;
import PageObject.Loan;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class LoanHelper {
        WebDriver driver;
        HomePage homePage;
        MbkReporter mbkReporter;
        Loan loan;

    public LoanHelper(WebDriver driver) {
            this.driver = driver;
            mbkReporter = new MbkReporter();
            homePage = new HomePage(driver);
            loan = new Loan(driver);
        }
    public void loanHelper(){
        loan.clickOnLoan();
        int noOfIcons = loan.getIcons();
        mbkReporter.verifyEqualsWithLogging(noOfIcons,5,"No of Icons",false);
        int noOfBenefitsOfZip = loan.getBenefitsOfZip();
        mbkReporter.verifyEqualsWithLogging(noOfBenefitsOfZip,4,"No of Zip Benefits",false);
        boolean isActivateNowVisible = loan.isActivateNowVisible();
        mbkReporter.verifyTrueWithLogging(isActivateNowVisible,"Activate Now Button Visibilty : "+isActivateNowVisible,false);
        homePage.clickOnLogoMbk();
    }
}
