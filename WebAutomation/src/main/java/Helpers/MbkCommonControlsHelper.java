package Helpers;

import PageObject.HomePage;
import PageObject.Recharge.GasPage;
import Utils.MbkReporter;
import org.openqa.selenium.WebDriver;

public class MbkCommonControlsHelper {
    WebDriver driver;
    MbkReporter mbkReporter;
    GasPage gasPage;
    HomePage homePage;

    public MbkCommonControlsHelper(WebDriver driver) {
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
        String actualStatus = gasPage.getSuccessText();
        String actualBpNo = gasPage.getCNo();
        String actualOperator = gasPage.getOperator();

        //Assertions
        mbkReporter.verifyEqualsWithLogging(actualBpNo, bpNo, "Verify Bp No", false);
        mbkReporter.verifyEqualsWithLogging(actualOperator, expectedOperatorText, "Verify Operator", false);
        mbkReporter.verifyEqualsWithLogging(actualStatus, text, "Verify Message", false);

        // Click on the close Icon
        Thread.sleep(3000);
        gasPage.closeBill();

        // return back to the Hom screen
        homePage.clickOnLogoMbk();

    }
}
