package PageObject;

import Utils.Elements;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class PayRentPage {

    IOSDriver driver;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay Rent\"]")
    private IOSElement payRent;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue with Zip/Cards\"]")
    private IOSElement continueOnZip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add New Property\"]")
    private IOSElement addNewProperty;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Bank Account Number\"]")
    private IOSElement bankAccountNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"IFSC Code\"]")
    private IOSElement ifscCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"IFSC Code\"]")
    private IOSElement findIfscCode;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Account Details\"]")
    private IOSElement accountDetailsText;



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    private IOSElement continueButtonOnAccountPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Landlord Name\"]")
    private IOSElement landlordName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Rent Amount\"]")
    private IOSElement rentAmount;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Landlord PAN\"]")
    private IOSElement landLordPanNumber;


    public IOSElement getRentDetails() {
        return rentDetails;
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rent Details\"]")
    private IOSElement rentDetails;




    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apply coupon\"]")
    private IOSElement applyCouponbutton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    private IOSElement continueButtonOnLandlordPage;

    public PayRentPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickOnpayRent() { Elements.click(driver, payRent, "Click on Pay rent option");   }

    public void clickOnContinueOnZip() { Elements.click(driver, continueOnZip, "Click on Continue on Zip");   }

    public void clickOnAddNewProperty() { Elements.click(driver, addNewProperty, "Click on add new property button");   }

    public void clickOnBankAccountNumber() { Elements.click(driver, bankAccountNumber, "Click on Bank Account Number");   }


    public void enterBankAccountNumber(String accountNumber) {
        Elements.enterToElement(driver, bankAccountNumber, accountNumber,"Entered Bank account number = "+accountNumber);
    }

    public void clickOnIfscCode() { Elements.click(driver, ifscCode, "Click on Ifsc Code");   }

    public void enterIfscCode(String code) {
        Elements.enterToElement(driver, ifscCode, code,"Entered IFSC code number = "+code);
    }

    public void clickOnAcccountDetails() { Elements.click(driver, accountDetailsText, "Click on Account details");   }


    public void clickOnContinuebuttonOnAccountpage() { Elements.click(driver, continueButtonOnAccountPage, "Click on continue button");   }

  //  public void clickOnLandlordName() { Elements.click(driver, landlordName, "Click on landlord name option");   }

    public void enterLandLordName(String landLord) {
        Elements.enterToElement(driver, landlordName, landLord,"Entered landLord name = "+landlordName);
    }

    public void clickOnRentAmount() { Elements.click(driver, rentAmount, "Click on Rent amount");   }

    public void enterRentAmount(String amount) {
        Elements.enterToElement(driver, rentAmount, amount,"Entered rent amount = "+rentAmount);
    }

    public void clickOnLandLordPanNumber() { Elements.click(driver, landLordPanNumber, "Click on landlord pan ");   }

    public void clickOnRentDetails() { Elements.click(driver, landLordPanNumber, "Click on landlord pan ");   }


    public void enterLandLordPanNumber(String panNumber) {
        Elements.enterToElement(driver, landLordPanNumber, panNumber,"Entered landlord pan number amount = "+panNumber);
    }

    public void clickOnApplyCouponbutton() { Elements.click(driver, applyCouponbutton, "Click on apply coupon button");   }

    public void clickOnContinueBUttonOnLandlordPage() { Elements.click(driver, landlordName, "Click on continue button");   }


    public IOSElement getPayRent() {
        return payRent;
    }

    public IOSElement getContinueOnZip() {
        return continueOnZip;
    }

    public IOSElement getAddNewProperty() {
        return addNewProperty;
    }

    public IOSElement getBankAccountNumber() {
        return bankAccountNumber;
    }

    public IOSElement getIfscCode() {
        return ifscCode;
    }

    public IOSElement getFindIfscCode() {
        return findIfscCode;
    }

    public IOSElement getContinueButtonOnAccountPage() {
        return continueButtonOnAccountPage;
    }

    public IOSElement getLandlordName() {
        return landlordName;
    }

    public IOSElement getRentAmount() {
        return rentAmount;
    }

    public IOSElement getApplyCouponbutton() {
        return applyCouponbutton;
    }

    public IOSElement getContinueButtonOnLandlordPage() {
        return continueButtonOnLandlordPage;
    }

    public IOSElement getAccountDetailsText() {
        return accountDetailsText;
    }

    public IOSElement getLandLordPanNumber() {
        return landLordPanNumber;
    }

}
