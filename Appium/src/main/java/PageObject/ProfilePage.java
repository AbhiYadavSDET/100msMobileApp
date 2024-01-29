package PageObject;

import Utils.Config;
import Utils.Element;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePage {


    AndroidDriver driver;

    @AndroidFindBy(xpath="//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[3]")
    private AndroidElement clickSideDrawer;

    @AndroidFindBy(xpath="//*[@text='Profile']")
    private AndroidElement clickProfile;

    @AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    private AndroidElement checkName;

    @AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    private AndroidElement checkEmail;

    @AndroidFindBy(xpath="//*[@text='Save Changes']")
    private AndroidElement checkSaveChanges;

    @AndroidFindBy(xpath="//*[@text='ę']")
    private AndroidElement clickBackButton;

    @AndroidFindBy(xpath="//*[@text='Save Changes']")
    private AndroidElement saveChangesText;

    @AndroidFindBy(xpath="//*[@text='Yes']")
    private AndroidElement checkYesButton;

    @AndroidFindBy(xpath="//*[@text='No, Thanks']")
    private AndroidElement checkNoThanksButton;

    @AndroidFindBy(xpath="//*[@class='android.widget.ImageView']")
    private AndroidElement clickProfileImage;

    @AndroidFindBy(xpath="//*[@text='Camera']")
    private AndroidElement clickCamera;

    @AndroidFindBy(xpath="//*[@text='Take picture']")
    private AndroidElement takePicture;

    @AndroidFindBy(xpath="//*[@text='OK']")
    private AndroidElement clickOK;

    @AndroidFindBy(xpath="//*[@text='Next']")
    private AndroidElement clickNext;

    @AndroidFindBy(xpath="//*[contains(@text,'Remove')]")
    private AndroidElement clickRemove;

    @AndroidFindBy(xpath="//*[@text='Gallery']")
    private AndroidElement clickGallery;

    @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.ImageView[1]")
    private AndroidElement selectImage;

    @AndroidFindBy(xpath="//*[@text='Allow']")
    private AndroidElement allowText;


    @AndroidFindBy(id = "txt_name")
    private AndroidElement profile_name;

    @AndroidFindBy(id = "txt_email")
    private AndroidElement profile_email;

    @AndroidFindBy(id = "primary_mobile_number")
    private AndroidElement profile_mobile_number;

    @AndroidFindBy(id = "introp_id")
    private AndroidElement interop_id;



    public ProfilePage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

//    public void openSideDrawer() {
//        Elements.selectElement(driver,clickSideDrawer,"Open side drawer");
//    }

//    public void checkNameInSideDrawer(String name) throws InterruptedException {
//        Assert.assertFalse(Elements.isElementPresent(driver,name));
//    }

//    public void clickProfile() {
//        Elements.selectElement(driver,clickProfile,"Click Profile button");
//    }

    public void checkNumber(String number) throws InterruptedException {
        Elements.waitForElementToVisibleOnPageUsingText(driver,number,5);
        Assert.assertTrue(Elements.isElementPresent(driver,number));
    }

    public void checkNameAndEmail(String name, String emailId) throws InterruptedException {
        if(Elements.isElementPresent(driver,name) || Elements.isElementPresent(driver,emailId)){
            Config.info("Name or Email id is different");
        }
    }

    public void enterName(String name) {
        Elements.selectElement(driver,checkName,"Click name field");
        Elements.clearText(driver,checkName,"Name");
        Elements.enterToElement(driver,checkName,name,"Enter name");
    }

    public void enterEmailId(String email) {
        Elements.selectElement(driver,checkEmail,"Click email field");
        Elements.clearText(driver,checkEmail,"Email id");
        Elements.enterToElement(driver,checkEmail,email,"Enter email id");
    }

    public void checkSaveChangesButton() throws InterruptedException {
        if(Elements.isElementEnabled(driver,checkSaveChanges)){
            Config.info("Save changes is clickable");
        }else{
            Config.info("Save changes is not clickable");
        }
    }

    public void clickBackButton() {
        Elements.back(driver,"Back button");
        Elements.back(driver,"Back button");
    }

    public void checkDetailsOnBackClicked() throws InterruptedException {
        if(Elements.isElementPresent(driver,saveChangesText) && Elements.isElementPresent(driver,checkYesButton) &&
                Elements.isElementPresent(driver,checkNoThanksButton)){
            Config.info("Text and buttons are present on clicking back");
        }
    }

    public void clickNoThanksButton() {
        Elements.selectElement(driver, checkNoThanksButton,"Click No Thanks button");
    }

    public void clickProfileIamge() {
        Elements.selectElement(driver, clickProfileImage,"Click on profile image");
    }

    public void clickCamera() {
        Elements.selectElement(driver, clickCamera,"Click on camera");
    }

    public void takePicture() {
        Elements.selectElement(driver, takePicture,"Take picture");
    }

    public void clickOk() {
        Elements.waitForElementToVisibleOnPage(driver,clickOK,10);
        Elements.selectElement(driver,clickOK,"Click OK");
    }

    public void clickNext() {
        Elements.waitForElementToVisibleOnPage(driver,clickNext,5);
        Elements.selectElement(driver,clickNext,"Click Next");
    }

    public void waitForProfileSection() {
        Elements.waitForElementToVisibleOnPage(driver,clickProfile,15);
    }

    public void clickRemove() {
        Elements.waitForElementToVisibleOnPage(driver,clickRemove,5);
        Elements.selectElement(driver,clickRemove,"Click Remove photo");
    }

    public void clickGallery() {
        Elements.waitForElementToVisibleOnPage(driver,clickGallery,5);
        Elements.selectElement(driver,clickGallery,"Click Gallery");
    }

    public void selectImageOrComeBack() throws InterruptedException {
        Elements.waitForElementToVisibleOnPage(driver,selectImage,5);
        if(Elements.isElementPresent(driver,selectImage)) {
            Elements.selectElement(driver, selectImage, "Click Gallery");
        }else{
            Config.info("No photo is present ,Please click a photo");
            Assert.assertTrue(false);
        }
    }

    public void clickAllow() {
        Elements.selectElement(driver,allowText,"Click Allow");
    }


    public String getName() throws InterruptedException {
        return Element.getText(driver, profile_name, "Get the Profile Account : Name");
    }

    public String getEmailId() throws InterruptedException {
        return Elements.getText(driver,profile_email,"Get the Profile Email ID ");
    }

    public String getMobileNumber() throws InterruptedException {
        return Elements.getText(driver,profile_mobile_number,"Get the Profile Mobile Number");
    }

    public String getInteropID() throws InterruptedException {
        return Elements.getText(driver,profile_mobile_number,"Get the Profile Mobile Number");
    }

}
