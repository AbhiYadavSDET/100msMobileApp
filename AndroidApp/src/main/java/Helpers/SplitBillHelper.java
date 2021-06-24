package Helpers;

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
        allServicesPage.clickOnSplitBill();

        Thread.sleep(3000);
        splitBillPage.clickOnStart();
        //splitBillPage.clickOnAllow();

        //Entering First Name
        Thread.sleep(3000);
        splitBillPage.clickAndEnterText(name1);
        splitBillPage.clickCheckbox();
        splitBillPage.clearSearchText(name1);

        //Entering Second Name
        Thread.sleep(3000);
        splitBillPage.clickAndEnterText(name2);
        splitBillPage.clickCheckbox();
        splitBillPage.clearSearchText(name2);

        driver.navigate().back();
        splitBillPage.clickContinue();

        //Entering amount
        Thread.sleep(3000);
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

        mbReporter.verifyEqualsWithLogging(successMessage,"Bill Split Request sent" , "SuccessPage | Message", false, false);
        mbReporter.verifyEqualsWithLogging(successAmount, "X50", "SuccessPage | Amount", false, false);
        mbReporter.verifyEqualsWithLogging(firstName, name1, "SuccessPage | FirstName", false, false);
        mbReporter.verifyEqualsWithLogging(secondName, name2, "SuccessPage | SecondName", false, false);
        //ExitonHomePage

        splitBillPage.clickOnClose();
        supercashStatementPage.navigateBackToHome();
        Thread.sleep(3000);


    }
}
