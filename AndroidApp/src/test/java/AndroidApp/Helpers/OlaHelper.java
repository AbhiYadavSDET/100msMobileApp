package test.java.AndroidApp.Helpers;

import UITestFramework.MBReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import logger.Log;
import main.java.utils.Element;
import main.java.utils.Screen;
import org.json.JSONException;
import org.openqa.selenium.By;
import test.java.AndroidApp.PageObject.HomePage;
import test.java.AndroidApp.PageObject.OlaPage;
import test.java.AndroidApp.PageObject.P2MPage;

import java.io.IOException;
import java.util.HashMap;

public class OlaHelper {

    AndroidDriver driver;
    HomePage homePage;
    Screen screen;
    Element element;
    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    OlaPage olaPage;
    PermissionHelper permissionHelper;


    public OlaHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;

        homePage = new HomePage(driver);
        screen = new Screen(driver);
        element = new Element(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionHelper = new PermissionHelper(driver);

    }


    public void olaBook(String enterDropLocation, String pin) throws InterruptedException, IOException, JSONException {

        mbkCommonControlsHelper.dismissAllOnHomePage(driver);

        for(int i=0; i<3; i++){
            if ((Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text='Ola Cabs']"))) == false) {

                Screen.swipeUpMore(driver);
            }
            else{break;}
        }


        olaPage=homePage.clickOnOlaIcon();

        permissionHelper.permissionAllow();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/drop_loc_layout"));

        olaPage.clickOnDropLocation();

        olaPage.enterDropLocation(enterDropLocation);

        olaPage. selectAddress();

        Thread.sleep(3000);
        olaPage.selectAuto();

        olaPage.selectRideNow();

        Thread.sleep(200);

        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Estimate Fare']"))==false){

            olaPage.selectMicro();
            Thread.sleep(200);

            olaPage.selectRideNow();

            if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Estimate Fare']"))==false){

                Log.info("No Cabs Available");

            }


        }

        olaPage.selectConfirmPay();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/content_root"));

        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.id("com.mobikwik_new:id/content_root")),olaPage.getPleaseNoteText(), true, false );

        olaPage.ctaConfirmBookPopUp();

        mbkCommonControlsHelper.handleSecurityPin(pin);

        int n=10;

        for (int j=1;j<n;j++) {
        if(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Pickup Arriving']"))==false) {

        Log.info("Attempt no: " +j);

        mbReporter.verifyFalse(j==(n-1), "Test case failed", true, true);

        }else{


        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Pickup Arriving']")),"Cab Booking Succesfull", true, false );

//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Pickup Arriving']")),"Cab Type Booked: "+olaPage.getCabCategory(), true, false );
////
//        mbReporter.verifyTrueWithLogging(Element.isElementPresent(driver, By.xpath("//android.widget.TextView[@text= 'Pickup Arriving']")),"Drive Name: "+olaPage.getDriverName(), true, false );


        olaPage.ctaCancelRide();

        Thread.sleep(200);

        olaPage.selectCancellationReason();

        olaPage.ctaConfirmCancel();

        Element.waitForVisibility(driver, By.id("com.mobikwik_new:id/btn_book_again"));

        mbReporter.verifyEqualsWithLogging(olaPage.getRideCanclled(), "Ride Cancelled", "Ticket is cancelled", true, false);

        olaPage.ctaBackToHome();

        break;

        }

        }

    }


}
