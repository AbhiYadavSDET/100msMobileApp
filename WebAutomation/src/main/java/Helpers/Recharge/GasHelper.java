package Helpers.Recharge;

import PageObject.HomePage;
import PageObject.Recharge.GasPage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GasHelper {
    WebDriver driver;
    MbkReporter mbkReporter;
    GasPage gasPage;
    HomePage homePage;

    public GasHelper(WebDriver driver) {
        this.driver = driver;
        mbkReporter = new MbkReporter();
        homePage = new HomePage(driver);
    }

    public void verifyGasBill(String op, String bpNo, String text, String expectedOperatorText) throws InterruptedException {
        // Click on Gas Page
        gasPage = homePage.clickOnGas();

        // Select the Operator
        gasPage.selectOperator(op);

        // Enter the Bp No
        gasPage.enterBpNo(bpNo);

        // Click on Go
        gasPage.clickGo();

        // Wait for View Bill window to open
        gasPage.waitForViewBillWindow();

        // fetch the values on the window
        WebElement noDuesText = gasPage.getNoDuestext();
        List<WebElement> dateAndAmountElements = gasPage.getDateAndAmountText();
        if(dateAndAmountElements.get(0).isDisplayed()){
            mbkReporter.verifyEqualsWithLogging("Due Date",dateAndAmountElements.get(0),"Due Date : "+dateAndAmountElements.get(1),false);
            mbkReporter.verifyEqualsWithLogging("Bill amount",dateAndAmountElements.get(2),"Bill Amount : "+dateAndAmountElements.get(3),false);
        }
        else{
            String actualStatus = noDuesText.getText();
            mbkReporter.verifyEqualsWithLogging(actualStatus, text, "Verify Message For No Dues", false);
        }
        String actualBpNo = gasPage.getCNo();
        String actualOperator = gasPage.getOperator();

        //Assertions
        mbkReporter.verifyEqualsWithLogging(actualBpNo, bpNo, "Verify Bp No", false);
        mbkReporter.verifyEqualsWithLogging(actualOperator, expectedOperatorText, "Verify Operator", false);

        // Click on the close Icon
        Thread.sleep(3000);
        gasPage.closeBill();

        // return back to the Hom screen
        homePage.clickOnLogoMbk();

    }
}
