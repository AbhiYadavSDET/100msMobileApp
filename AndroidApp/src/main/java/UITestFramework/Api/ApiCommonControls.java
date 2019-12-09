package UITestFramework.Api;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import logger.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class ApiCommonControls {

    public static Properties testDataFile = new Properties();
    File file = new File("");
    FileInputStream configFis;
    Connection connect = null;
    Statement statement = null;

    public ApiCommonControls() throws IOException {

    }

    public HashMap<String, Double> con1(URL url) throws JSONException {

        HashMap<String, Double> apiBalanceMap = new HashMap<>();

        InputStream response = null;
        try {

            HttpURLConnection myURLConnection = (HttpURLConnection) url.openConnection();

            myURLConnection.setRequestMethod("GET");
            myURLConnection.setRequestProperty("Authorization", "1dHBnn/bvplhi9fYJgyf8g==.8fc2ljdqp3gjricjs6657ai02g");
            myURLConnection.setRequestProperty("Content-Type", "application/json");
            myURLConnection.setRequestProperty("X-MClient", "3");

            response = myURLConnection.getInputStream();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(response);
        String responseBody = scanner.useDelimiter("\\A").next();

        JSONObject jo = new JSONObject(responseBody);

        Double balance = jo.getJSONObject("data").getDouble("totalBalance");
        Double addmoney = jo.getJSONObject("data").getJSONArray("wallet").getJSONObject(0).getDouble("amount");
        Double loyaltymoney = jo.getJSONObject("data").getJSONArray("wallet").getJSONObject(1).getDouble("amount");
        Double reimbursementfood = jo.getJSONObject("data").getJSONArray("wallet").getJSONObject(2).getDouble("amount");
        Double cashbackmoney = jo.getJSONObject("data").getJSONArray("wallet").getJSONObject(3).getDouble("amount");
        Double totalSuperCash = jo.getJSONObject("data").getDouble("totalMobiKash");
        Double availableSuperCash = jo.getJSONObject("data").getDouble("availableMobiKash");

        // Setting the values in the Balance Map from Api
        apiBalanceMap.put("balance", balance);
        apiBalanceMap.put("addmoney", addmoney);
        apiBalanceMap.put("loyaltymoney", loyaltymoney);
        apiBalanceMap.put("reimbursementfood", reimbursementfood);
        apiBalanceMap.put("cashbackmoney", cashbackmoney);
        apiBalanceMap.put("totalSuperCash", totalSuperCash);
        apiBalanceMap.put("availableSuperCash", availableSuperCash);

        return apiBalanceMap;

    }

    private static String calculateCheckSumForService(String input, String secretkey) {
        String mykey = secretkey;
        String test = input;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret = new SecretKeySpec(mykey.getBytes(), "HmacSHA256");
            mac.init(secret);
            byte[] digest = mac.doFinal(test.getBytes());
            String ret = "";
            for (byte b : digest) {
                ret = ret + String.format("%02x", b);
            }
            return ret;
        } catch (Exception e) {
            System.out.println("{\"OTP\":\"NA\",\"ErrorMsg\":\"Failed to calculate checksum\"}");
            return "";
        }
    }

    String checksumString;
    String secretKey;
    String checksum;
    StringBuffer response;
    HttpURLConnection con = null;
    String contentType = "application/json";
    String responseData = "";

    public HashMap<String, String> getOTPfromDB(String email, String cell, String mid, String url, String servercode)
            throws IOException, JSONException {
        checksumString = "'getotp'";
        String member = "";
        if (!cell.equals("")) {
            checksumString = checksumString + "'" + cell + "''" + mid + "'";
            member = "cell=" + cell;
        } else {
            checksumString = checksumString + "'" + email + "''" + mid + "'";
            member = "email=" + email;
        }
        //secretKey = "ju6tygh7u7tdg554k098ujd5468o";
        secretKey = "Lu6tygh7u7tdakbyk098ujd5468o";
        checksum = calculateCheckSumForService(checksumString, secretKey);
        String param = "";
        if (servercode.isEmpty())
            param = "?" + member + "&action=getotp&checksum=" + checksum + "&mid=" + mid + "&servercode=5";
        else
            param = "?" + member + "&action=getotp&checksum=" + checksum + "&mid=" + mid + "&" + servercode
                    + "&servercode=5";
        return hitGetRequest(url, param);
    }

    private HashMap<String, String> hitGetRequest(String url, String paramValues) throws IOException, JSONException {

        HashMap<String, String> apiOtpMap = new HashMap<>();

        url = url + paramValues;
        //Log.info(url);

        URL otpUrl;
        otpUrl = new URL(url);

        InputStream otpResponse = null;

        try {
            HttpURLConnection myURLConnection1 = (HttpURLConnection) otpUrl.openConnection();

            myURLConnection1.setRequestMethod("GET");
            otpResponse = myURLConnection1.getInputStream();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(otpResponse);
        String responseBody = scanner.useDelimiter("\\A").next();

        JSONObject otpjo = new JSONObject(responseBody);

        // Setting the values in the Balance Map from Api
        apiOtpMap.put("otp", otpjo.getString("otp"));

        return apiOtpMap;

    }

    public HashMap<String, Double> contotpOtpGenerate(URL url) throws JSONException, SAXException, Exception {

        HashMap<String, Double> apiMap = new HashMap<>();

        InputStream response = null;
        try {

            HttpURLConnection myURLConnection = (HttpURLConnection) url.openConnection();

            myURLConnection.setRequestMethod("GET");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {

                e.printStackTrace();
            }
            Document doc = builder.parse(myURLConnection.getInputStream());

            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer xform = factory1.newTransformer();

            // that’s the default xform; use a stylesheet to get a real one
            Log.info("Response - ");
            xform.transform(new DOMSource(doc), new StreamResult(System.out));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return apiMap;

    }

    public HashMap<String, Double> conTotpDebitWallet(URL url) throws JSONException, SAXException, Exception {

        HashMap<String, Double> apiMap = new HashMap<>();

        InputStream response = null;
        try {

            HttpURLConnection myURLConnection = (HttpURLConnection) url.openConnection();

            myURLConnection.setRequestMethod("GET");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {

                e.printStackTrace();
            }
            Document doc = builder.parse(myURLConnection.getInputStream());

            TransformerFactory factory1 = TransformerFactory.newInstance();
            Transformer xform = factory1.newTransformer();

            // that’s the default xform; use a stylesheet to get a real one
            Log.info("Response - ");

            xform.transform(new DOMSource(doc), new StreamResult(System.out));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return apiMap;

    }

}
