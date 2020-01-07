package PageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.Log;
import org.openqa.selenium.support.PageFactory;
import utils.Element;

import java.io.IOException;

public class SavedConnectionPage {

    AndroidDriver driver;


    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/add_new_connection_button")
    private AndroidElement cta_add_favourite;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Add Favourite']")
    private AndroidElement add_favourite_details_screen;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Service']/following::android.widget.EditText")
    private AndroidElement select_service_dropdown;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Operator']/following::android.widget.EditText")
    private AndroidElement select_operator_dropdown;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Name']/following::android.widget.EditText")
    private AndroidElement enter_name;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'DTH']")
    private AndroidElement select_dth;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Customer Id']/following::android.widget.EditText")
    private AndroidElement enter_customer_id;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Airtel DTH']")
    private AndroidElement select_airtel_dth;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/btn_savedConn_save")
    private AndroidElement cta_save;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'test']/following::android.widget.TextView")
    private AndroidElement saved_connection_details;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'test']")
    private AndroidElement saved_connection;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/mkab_icon_5")
    private AndroidElement more_hamburger_icon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Delete']")
    private AndroidElement cta_delete;

    @AndroidFindBy(id = "com.mobikwik_new.bajajfinserv:id/mkab_icon_1")
    private AndroidElement back_button;


    public SavedConnectionPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        /*
        To Do
        wait for Page load to be added
         */

        Log.info("*****On Side Drawer Page*****");
    }


    public void clickAddFavouritecta() throws InterruptedException {
        Element.selectElement(driver, cta_add_favourite, "Click Add Favourite");
    }

//1234567891 | Airtel DTH


    public void selectServiceDropdown() throws InterruptedException {
        Element.selectElement(driver, select_service_dropdown, "Select service");
    }

    public void selectDth() throws InterruptedException {
        Element.selectElement(driver, select_dth, "Select dth in services");
    }

    public void selectOperator() throws InterruptedException {
        Element.selectElement(driver, select_operator_dropdown, "select operator Dropdown");
    }

    public void selectAirtelDth() throws InterruptedException {
        Element.selectElement(driver, select_airtel_dth, "select Airtel DTH from Operator list");
    }

    public void enterCustomerId(String customerId) throws InterruptedException {
        Element.enterText(driver, enter_customer_id, customerId, "Enter Customer ID");
    }

    public void enterName(String name) throws InterruptedException {
        Element.enterText(driver, enter_name, name, "Enter Name");
    }

    public void clickSave() throws InterruptedException {
        Element.selectElement(driver, cta_save, "Hit Save");
    }

    public String getSavedDetails() throws InterruptedException {
        return Element.getText(driver, saved_connection_details, "Saved Connection Details");
    }

    public void selectSavedConnection() throws InterruptedException {
        Element.selectElement(driver, saved_connection, "Select Saved Connection");
    }

    public void selectMoreOption() throws InterruptedException {
        Element.selectElement(driver, more_hamburger_icon, "select more option icon");
    }

    public void selectDeleteOption() throws InterruptedException {
        Element.selectElement(driver, cta_delete, "select Delete option");
    }


    public HomePage clickOnBackButton() throws IOException {
        Element.selectElement(driver, back_button, "Click on Back Button");
        return new HomePage(driver);
    }


}
