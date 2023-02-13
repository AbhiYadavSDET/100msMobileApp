package Helpers;

import PageObject.AddMoneyPage;
import PageObject.HomePage;
import PageObject.SecurityPinPage;
import PageObject.TransactionHistoryPage;
import PageObject.PermissionPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import Utils.Elements;
import Utils.MBReporter;
import Utils.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

public class AddMoneyHelper {

    AndroidDriver driver;
    HomePage homePage;
    AddMoneyPage addMoneyPage;
    SecurityPinPage securityPinPage;
    Screen screen;

    MBKCommonControlsHelper mbkCommonControlsHelper;
    MBReporter mbReporter;
    PermissionPage permissionPage;


    public static HashMap<String, String> map;
    public static HashMap<String, String> balanceBefore;
    public static HashMap<String, String> balanceAfter;
    private Object AndroidElement;


    public AddMoneyHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
        addMoneyPage = new AddMoneyPage(driver);
        homePage = new HomePage(driver);
        screen = new Screen(driver);

        securityPinPage = new SecurityPinPage(driver);
        mbkCommonControlsHelper = new MBKCommonControlsHelper(driver);
        mbReporter = new MBReporter(driver, "testScreenshotDir");
        permissionPage = new PermissionPage(driver);

    }

    /**
     * This method is to Test standalone add money Flow.
     * Flow Can Be "SavedCard" or "NewCard"
     */

    public String getOtpDetailsByJsonFile() {

        String otp = "";
        try {
            // Open the link in the default web browser
            Desktop desktop = Desktop.getDesktop();
            URI uri = new URI("https://firebasestorage.googleapis.com/v0/b/testingsyncotpfirebase.appspot.com/o/otpTesting%2Fotp.json?alt=media");
            desktop.browse(uri);

            // Wait for the file to be downloaded
            Thread.sleep(5000);

            // Read the contents of the JSON file
            URL fileUrl = new URL("file:////Users/ashishkumarpradhan/Downloads/otp.json");
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileUrl.toURI())));
            System.out.println("JSON File Contents:");
            String line = "";
            while ((line = reader.readLine()) != null) {
                otp = line.substring(8,14);
                System.out.println(line);
            }


            reader.close();
            File file = new File(fileUrl.toURI());
            if (file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("File deletion failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return otp;

    }

    public String getOtpDetails() {
        /**
         * Specify the base URL to the Restful web service
         */
        RestAssured.baseURI = "https://firebasestorage.googleapis.com/";
        RestAssured.basePath="v0/b/testingsyncotpfirebase.appspot.com/o";

        /**
         * Get the RequestSpecification of the request to be sent to the server.
         */
        RequestSpecification httpRequest = RestAssured.given().log().all().urlEncodingEnabled(false);

        /**
         * Specify the method type (GET) and the parameters if any.
         * In this case the request does not take any parameters
         */

        Response response = httpRequest.request(Method.GET, "otpTesting%2Fotp.json?alt=media");

        /**
         * Print the status and message body of the response received from the server
         */

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

        String output=response.prettyPrint().replace("{\"otp\":\"","").replace("\"}", "");
        System.out.println("Output Otp=>" + output);
        return output;
    }


    public void enterOtpDetails(int width , int height) {

        String otp = getOtpDetailsByJsonFile();
        //String otp = getOtpDetails();


        for(int i = 0 ; i < otp.length() ; i++){
            char c = otp.charAt(i);

            Log.info("TAP " + c);

            switch (c) {
                case '2':
                    Elements.tapByCoordinates(width*5,height*16, driver);
                    break;

                case '5':
                    Elements.tapByCoordinates(width*5,height*17, driver);
                    break;

                case '8':
                    Elements.tapByCoordinates(width*5,height*18, driver);
                    break;

                case '0':
                    Elements.tapByCoordinates(width*5,(height*39)/2, driver);
                    break;

                case '1':
                    Elements.tapByCoordinates(width*3,height*16, driver);
                    break;

                case '4':
                    Elements.tapByCoordinates(width*3,height*17, driver);
                    break;

                case '7':
                    Elements.tapByCoordinates(width*3,height*18, driver);
                    break;

                case '3':
                    Elements.tapByCoordinates(width*7,height*16, driver);
                    break;

                case '6':
                    Elements.tapByCoordinates(width*7,height*17, driver);
                    break;

                case '9':
                    Elements.tapByCoordinates(width*7,height*18, driver);
                    break;
            }
        }
    }


    public void addMoneyViaCard(String amount, String cvv , String expTitle, String expSubTitle, String expAmount,String expectedHistoryDescription, String expectedHistoryAmount, String expectedHistoryStatus) throws InterruptedException, IOException {

        Log.info("START", "Add Money");
        Log.info("----------- Arguments ---------------");
        Log.info("amount : " + amount);
        Log.info("cvv : " + cvv);
        Log.info("-------------------------------------");

        // Get the Balance if the User Before TRX
        balanceBefore = mbkCommonControlsHelper.getBalance();

        // Click on the profile
        securityPinPage.clickOnProfile();

        // Click on add Money
        addMoneyPage.clickOnAddMoney();

        // Enter amount
        addMoneyPage.enterAmount(amount);

        // Click on Add
        addMoneyPage.clickOnAdd();

        // Select More Payment Options
        addMoneyPage.selectMorePaymentOptions();

        // Click on Indusind Bank
        addMoneyPage.clickOnIndusindBank();

        // Enter CVV
        addMoneyPage.enterCVV(cvv);

        // Click on Pay
        addMoneyPage.clickOnPay();

        Thread.sleep(3000);

        if(permissionPage.isPermissionMessagePresent()){
            permissionPage.allowPermissionMessage();
        }

        Dimension dimension = driver.manage().window().getSize();

        int width = dimension.getWidth()/10;
        int height = dimension.getHeight()/20;

        Log.info("WAIT");
        Thread.sleep(20000);


        Log.info("TAP on text box");
        Elements.tapByCoordinates(width*5,height*8, driver);

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("Enter OTP Details");
        enterOtpDetails(width,height);

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("TAP on Confirm and Pay");
        Elements.tapByCoordinates(width*5,height*9, driver);


        Log.info("WAIT");
        Thread.sleep(20000);

        // Verification on the Success Screen
        String title = addMoneyPage.getTitleOnSuccess();
        String subTitle = addMoneyPage.getSubTitleOnSuccess();
        String amountOnSuccess = addMoneyPage.getAmountOnSuccess();

        // Display the values
        Log.info("Title : " + title);
        Log.info("Sub Title : " + subTitle);
        Log.info("Amount : " + amountOnSuccess);

        // Add the assertions
        mbReporter.verifyEquals(title, expTitle, "Verify Title", false, false);
        mbReporter.verifyEquals(subTitle, expSubTitle, "Verify Sub Title", false, false);
        mbReporter.verifyEquals(amountOnSuccess, expAmount, "Verify Amount", false, false);


        mbkCommonControlsHelper.pressback(3);

        // Click on the back button if the bottom sheet is present
        mbkCommonControlsHelper.handleHomePageLanding();

        // Get the Balance if the User Before TRX
        balanceAfter = mbkCommonControlsHelper.getBalance();


        // Assertions on the balance deducted
        mbkCommonControlsHelper.verifyWalletBalanceAfterTransaction(driver, balanceBefore, balanceAfter, amount, "Add");

        // Verify the History details
        mbkCommonControlsHelper.verifyHistoryDetails(driver ,expectedHistoryDescription,expectedHistoryAmount,expectedHistoryStatus);
    }

}


