package PageObject;

import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PipedGasPage {

    public class ElectricityPage {

        AndroidDriver driver;


        @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Pay Bills']")
        private AndroidElement rechargeAndPayBills;

        @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Recharge & Bill Payments']")
        private AndroidElement swipeLeftBottomRemove;

        @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Home Services']")
        private AndroidElement homeServices;

        @AndroidFindBy(xpath = "//*/android.widget.TextView[@text = 'Piped Gas']")
        private AndroidElement pipedGas;

        @AndroidFindBy(id = "text_input")
        private AndroidElement searchPipedGasProvider;

        @AndroidFindBy(id = "operator_layout")
        private AndroidElement selectBrand;

        //1000236410





        public void clickRechargeAndPayBills() {
            Elements.selectElement(driver, rechargeAndPayBills, "click on Recharge And PayBills");
        }

        public void clickSwipeLeftBottomRemove() {
            Elements.selectElement(driver, swipeLeftBottomRemove, "Tap to remove Swipe Left Bottom Pop Up");
        }

        public void clickHomeServices() {
            Elements.selectElement(driver, homeServices, "Click on Home Services");
        }

        public void clickPipedGas() {
            Elements.selectElement(driver, pipedGas, "Click on Piped Gas");
        }

        public void clickSearchPipedGasProvider(){
            Elements.selectElement(driver, searchPipedGasProvider, "Click on Search Piped Gas Provider");
        }

        public void enterSearchPipedGasProvider(String BrandName){
            Elements.enterToElement(driver, searchPipedGasProvider, BrandName,"Enter Gas Provider Brand Name");
        }

        public void clickSelectBrand(){
            Elements.selectElement(driver, selectBrand, "Click on Brand");
        }





    }
}
