package Helpers;
/*
import PageObject.AllServicesPage;
import PageObject.HomePage;
import PageObject.SplitBillPage;
import PageObject.SupercashStatementPage;
import UITestFramework.MBReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONException;
import utils.Element;
import utils.Screen;

import java.io.IOException;
import java.util.List;

public class SplitBillHelper{

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionHelper permissionHelper;
    AllServicesPage allServicesPage;
    SplitBillPage splitBillPage;
    SupercashStatementPage supercashStatementPage;

    public SplitBillHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver,"testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);
        allServicesPage = new AllServicesPage(driver);
        splitBillPage = new SplitBillPage(driver);
        supercashStatementPage = new SupercashStatementPage(driver);

    }

    public void verifySplitBill(String name1, String name2, String amount) throws InterruptedException, JSONException, IOException{

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);
        homePage.clickAllServices();
        Screen.swipeUpMore(driver);
        Screen.swipeUpMore(driver);
        Screen.swipeUpMore(driver);
        allServicesPage.clickOnSplitBill();

        splitBillPage.clickOnStart();
        //splitBillPage.clickOnAllow();

        //Entering First Name
        splitBillPage.clickAndEnterText(name1);
        splitBillPage.clickCheckbox();
        splitBillPage.clearSearchText(name1);

        //Entering Second Name
        splitBillPage.clickAndEnterText(name2);
        splitBillPage.clickCheckbox();
        splitBillPage.clearSearchText(name2);

        driver.navigate().back();
        splitBillPage.clickContinue();

        //Entering amount
        splitBillPage.clickAndEnterAmount(amount);
        driver.navigate().back();

        splitBillPage.clickConfirm();


        //Assertions

        String successMessage = splitBillPage.getSuccessMsg();
        String successAmount = splitBillPage.getSuccessAmount();
        String firstName = "";
        String secondName = "";

        List<MobileElement> myList = driver.findElementsByClassName("android.widget.TextView");
        for(int i=0;i< myList.size();i++)
        {
            if(myList.get(i).getText().contains(name1)){
                 firstName = myList.get(i).getText();
            }else
                if(myList.get(i).getText().contains(name2)){
                     secondName = myList.get(i).getText();
                }
        }
        //calculate share amounts
        Double amt = Double.parseDouble(amount);
        Long myShare = Math.round(amt/3);
        Long firstShare = myShare;
        Double secondShare = amt - (myShare+firstShare);

        //get share amounts from success screen
        List<MobileElement> amountList = driver.findElementsById("amount");
        String firstShareOnScreen = amountList.get(0).getText();
        String secondShareOnScreen = amountList.get(1).getText();
        String substr = firstShareOnScreen.substring(1);
        String substr2 = secondShareOnScreen.substring(1);
        Long first = Long.parseLong(substr);
        Double second = Double.parseDouble(substr2);

        String myAmount = splitBillPage.myShare();
        String substr3 = myAmount.substring(1);

        mbReporter.verifyEqualsWithLogging(successMessage,"Bill Split Request sent" , "SuccessPage | Message", false, false);
        mbReporter.verifyEqualsWithLogging(successAmount, "X50", "SuccessPage | Amount", false, false);
        mbReporter.verifyEqualsWithLogging(firstName, name1, "SuccessPage | FirstName", false, false);
        mbReporter.verifyEqualsWithLogging(secondName, name2, "SuccessPage | SecondName", false, false);
        mbReporter.verifyEqualsWithLogging(myShare, Long.parseLong(substr3), "Validation of My Share", false, false);
        mbReporter.verifyEqualsWithLogging(firstShare, first, "Validation of First Share Amount", false, false);
        mbReporter.verifyEqualsWithLogging(secondShare, second, "Validation of Second Share Amount", false, false);

        //ExitToHomePage

        splitBillPage.clickOnClose();
        supercashStatementPage.navigateBackToHome();

    }
}


 */