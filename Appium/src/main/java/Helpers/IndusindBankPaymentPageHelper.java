package Helpers;

import Logger.Log;
import Utils.Elements;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class IndusindBankPaymentPageHelper {

    AndroidDriver driver;

    public IndusindBankPaymentPageHelper(AndroidDriver driver) throws IOException {
        this.driver = driver;
    }

    public String getOtpDetailsByJsonFile(String userName) {

        String otp = "";
        try {
            // Open the link in the default web browser
            Desktop desktop = Desktop.getDesktop();
            URI uri = new URI("https://firebasestorage.googleapis.com/v0/b/testingsyncotpfirebase.appspot.com/o/otpTesting%2Fotp.json?alt=media");
            desktop.browse(uri);

            // Wait for the file to be downloaded
            Thread.sleep(5000);

            // Read the contents of the JSON file
            String downloadLocation = "file:////Users/"+userName+"/Downloads/otp.json";
            URL fileUrl = new URL(downloadLocation);
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

    public void paymentPageHelper(String deviceId , String userName) throws InterruptedException {
        int device = Integer.parseInt(deviceId);

        switch (device) {
            case 0:
                paymentPageAshishPhone(userName);
                break;

            case 1:
                paymentPageCloudRun(userName);
                break;

            case 2:
                paymentPageLenovo(userName);
                break;

            case 3:
                paymentPagePixel3A(userName);
                break;

        }

    }

    public void paymentPageCloudRun(String userName) throws InterruptedException {

        Log.info("Running on Cloud");

        Dimension dimension = driver.manage().window().getSize();

        int width = dimension.getWidth()/4;
        int height = dimension.getHeight()/20;

        Log.info("WAIT");
        Thread.sleep(20000);


        Log.info("TAP on text box");
        Elements.tapByCoordinates(width*2,height*8, driver);

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("Enter OTP Details");
        String otp = getOtpDetailsByJsonFile(userName);
        //String otp = getOtpDetails();


        for(int i = 0 ; i < otp.length() ; i++){
            char c = otp.charAt(i);

            Log.info("TAP " + c);

            switch (c) {
                case '2':
                    Elements.tapByCoordinates(width*2,height*14, driver);
                    break;

                case '5':
                    Elements.tapByCoordinates(width*2,height*16, driver);
                    break;

                case '8':
                    Elements.tapByCoordinates(width*2,height*18, driver);
                    break;

                case '0':
                    Elements.tapByCoordinates(width*2,height*20, driver);
                    break;

                case '1':
                    Elements.tapByCoordinates(width,height*14, driver);
                    break;

                case '4':
                    Elements.tapByCoordinates(width,height*16, driver);
                    break;

                case '7':
                    Elements.tapByCoordinates(width,height*18, driver);
                    break;

                case '3':
                    Elements.tapByCoordinates(width*3,height*14, driver);
                    break;

                case '6':
                    Elements.tapByCoordinates(width*3,height*16, driver);
                    break;

                case '9':
                    Elements.tapByCoordinates(width*3,height*18, driver);
                    break;
            }
        }

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("TAP on Confirm and Pay");
        Elements.tapByCoordinates(width*2,height*10, driver);


        Log.info("WAIT");
        Thread.sleep(20000);
    }


    public void paymentPageAshishPhone(String userName) throws InterruptedException {

        Log.info("Running on Ashish Phone");

        Dimension dimension = driver.manage().window().getSize();

        int width = dimension.getWidth()/4;
        int height = dimension.getHeight()/20;

        Log.info("WAIT");
        Thread.sleep(20000);


        Log.info("TAP on text box");
        Elements.tapByCoordinates(width*2,height*8, driver);

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("Enter OTP Details");

        String otp = getOtpDetailsByJsonFile(userName);
        //String otp = getOtpDetails();

        // String otp = "258016";


        for(int i = 0 ; i < otp.length() ; i++){
            char c = otp.charAt(i);

            Log.info("TAP " + c);

            switch (c) {
                case '2':
                    Elements.tapByCoordinates(width*2,height*16, driver);
                    break;

                case '5':
                    Elements.tapByCoordinates(width*2,height*17, driver);
                    break;

                case '8':
                    Elements.tapByCoordinates(width*2,height*18, driver);
                    break;

                case '0':
                    Elements.tapByCoordinates(width*2,(height*39)/2, driver);
                    break;

                case '1':
                    Elements.tapByCoordinates(width,height*16, driver);
                    break;

                case '4':
                    Elements.tapByCoordinates(width,height*17, driver);
                    break;

                case '7':
                    Elements.tapByCoordinates(width,height*18, driver);
                    break;

                case '3':
                    Elements.tapByCoordinates(width*3,height*16, driver);
                    break;

                case '6':
                    Elements.tapByCoordinates(width*3,height*17, driver);
                    break;

                case '9':
                    Elements.tapByCoordinates(width*3,height*18, driver);
                    break;
            }
        }

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("TAP on Confirm and Pay");
        Elements.tapByCoordinates(width*2,height*9, driver);


        Log.info("WAIT");
        Thread.sleep(20000);
    }


    public void paymentPageLenovo(String userName) throws InterruptedException {

        Log.info("Running on Lenovo");

        Dimension dimension = driver.manage().window().getSize();

        int width = dimension.getWidth()/4;
        int height = dimension.getHeight()/20;

        Log.info("WAIT");
        Thread.sleep(100000);


        Log.info("TAP on text box");
        Elements.tapByCoordinates(width*2,height*8, driver);

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("Enter OTP Details");
        String otp = getOtpDetailsByJsonFile(userName);
        //String otp = getOtpDetails();
        //String otp = "258013";


        for(int i = 0 ; i < otp.length() ; i++){
            char c = otp.charAt(i);

            Log.info("TAP " + c);

            switch (c) {
                case '2':
                    Elements.tapByCoordinates(width*2,height*14, driver);
                    break;

                case '5':
                    Elements.tapByCoordinates(width*2,height*16, driver);
                    break;

                case '8':
                    Elements.tapByCoordinates(width*2,height*18, driver);
                    break;

                case '0':
                    Elements.tapByCoordinates(width*2,height*20, driver);
                    break;

                case '1':
                    Elements.tapByCoordinates(width,height*14, driver);
                    break;

                case '4':
                    Elements.tapByCoordinates(width,height*16, driver);
                    break;

                case '7':
                    Elements.tapByCoordinates(width,height*18, driver);
                    break;

                case '3':
                    Elements.tapByCoordinates(width*3,height*14, driver);
                    break;

                case '6':
                    Elements.tapByCoordinates(width*3,height*16, driver);
                    break;

                case '9':
                    Elements.tapByCoordinates(width*3,height*18, driver);
                    break;
            }
        }

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("TAP on Confirm and Pay");
        Elements.tapByCoordinates(width*2,height*19, driver);


        Log.info("WAIT");
        Thread.sleep(20000);
    }


    public void paymentPagePixel3A(String userName) throws InterruptedException {

        Log.info("Running on Cloud");

        Dimension dimension = driver.manage().window().getSize();

        int width = dimension.getWidth()/4;
        int height = dimension.getHeight()/20;

        Log.info("WAIT");
        Thread.sleep(20000);


        Log.info("TAP on text box");
        Elements.tapByCoordinates(width*2,height*10, driver);

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("Enter OTP Details");
        String otp = getOtpDetailsByJsonFile(userName);
        //String otp = getOtpDetails();



        for(int i = 0 ; i < otp.length() ; i++){
            char c = otp.charAt(i);

            Log.info("TAP " + c);

            switch (c) {
                case '2':
                    Elements.tapByCoordinates(width*2,height*14, driver);
                    break;

                case '5':
                    Elements.tapByCoordinates(width*2,height*16, driver);
                    break;

                case '8':
                    Elements.tapByCoordinates(width*2,height*18, driver);
                    break;

                case '0':
                    Elements.tapByCoordinates(width*2,height*20, driver);
                    break;

                case '1':
                    Elements.tapByCoordinates(width,height*14, driver);
                    break;

                case '4':
                    Elements.tapByCoordinates(width,height*16, driver);
                    break;

                case '7':
                    Elements.tapByCoordinates(width,height*18, driver);
                    break;

                case '3':
                    Elements.tapByCoordinates(width*3,height*14, driver);
                    break;

                case '6':
                    Elements.tapByCoordinates(width*3,height*16, driver);
                    break;

                case '9':
                    Elements.tapByCoordinates(width*3,height*18, driver);
                    break;
            }
        }

        Log.info("WAIT");
        Thread.sleep(3000);

        Log.info("TAP on Confirm and Pay");
        Elements.tapByCoordinates(width*2,height*12, driver);


        Log.info("WAIT");
        Thread.sleep(20000);
    }
}
