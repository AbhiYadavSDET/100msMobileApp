package utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.File;
import java.io.IOException;

public final class Configuration {
    private static PropertyHandler handler;

    public Configuration() {
    }

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("config.properties").getFile());
        handler = PropertyHandler.getInstance();

        try {
            handler.load(file);
        } catch (IOException var3) {
            throw new RuntimeException("-----config.properties file not found------" + var3);
        }
    }

    public static class TestData {
        public static final String TEST_DATA_PATH;
        public static final String TEST_DATA_FILE_NAME;

        public TestData() {
        }

        static {
            TEST_DATA_PATH = Configuration.handler.getValue("path");
            TEST_DATA_FILE_NAME = Configuration.handler.getValue("file.name");
        }
    }

    public static class ReportDefaults {
        public static final String MODULE;
        public static final String BRANCH;
        public static final String USER_NAME;
        public static final String REPORT_DIRECTORY;
        public static final String REPORT_FILE_NAME;
        public static final String REPORT_DOCUMENT_TITLE;
        public static final String REPORT_NAME;
        public static final String REPORT_THEME;
        public static final String CHART_VISIBILITY_ON_OPEN;
        public static final String CHART_VIEW_LOCATION;
        public static final String EXECUTION_ENVIRONMENT;

        public ReportDefaults() {
        }

        static {
            MODULE = Configuration.handler.getValue("module");
            BRANCH = Configuration.handler.getValue("branch");
            USER_NAME = Configuration.handler.getValue("user_name");
            REPORT_DIRECTORY = Configuration.handler.getValue("report.directory");
            REPORT_FILE_NAME = Configuration.handler.getValue("report.file.name");
            REPORT_DOCUMENT_TITLE = Configuration.handler.getValue("report.document.title");
            REPORT_NAME = Configuration.handler.getValue("report.name");
            REPORT_THEME = Configuration.handler.getValue("report.theme");
            CHART_VISIBILITY_ON_OPEN = Configuration.handler.getValue("chart.visibility.on.open");
            CHART_VIEW_LOCATION = Configuration.handler.getValue("chart.view.location");
            EXECUTION_ENVIRONMENT = Configuration.handler.getValue("environment");
        }
    }

    public static class Members {
        public static final String USERNAME;
        public static final String PASSWORD;
        public static final String X_M_CLIENT;
        public static final String KYC_USERNAME;
        public static final String KYC_PASSWORD;
        public static final String KYC_USER_MOBILE;
        public static final String NON_KYC_USERNAME;
        public static final String NON_KYC_PASSWORD;
        public static final String NON_KYC_USER_MOBILE;

        public Members() {
        }

        static {
            USERNAME = Configuration.handler.getValue("username");
            PASSWORD = Configuration.handler.getValue("password");
            X_M_CLIENT = Configuration.handler.getValue("x.mClient");
            KYC_USERNAME = Configuration.handler.getValue("kyc.username");
            KYC_PASSWORD = Configuration.handler.getValue("kyc.password");
            KYC_USER_MOBILE = Configuration.handler.getValue("kyc.user.mobile");
            NON_KYC_USERNAME = Configuration.handler.getValue("non.kyc.username");
            NON_KYC_PASSWORD = Configuration.handler.getValue("non.kyc.password");
            NON_KYC_USER_MOBILE = Configuration.handler.getValue("non.kyc.user.mobile");
        }
    }

    public static class Payment {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;


        public Payment() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("payment.is.https.required"));
            HOST = Configuration.handler.getValue("payment.api.host");
            PORT = Configuration.handler.getValue("payment.api.port");
            X_MCLIENT = Configuration.handler.getValue("payment.xmClient");
            X_App_Version = Configuration.handler.getValue("payment.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("payment.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("payment.deviceId");
            AUTH = Configuration.handler.getValue("payment.auth");

        }
    }


    public static class GiftCard {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;


        public GiftCard() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("giftcard.is.https.required"));
            HOST = Configuration.handler.getValue("giftcard.api.host");
            PORT = Configuration.handler.getValue("giftcard.api.port");
            X_MCLIENT = Configuration.handler.getValue("giftcard.xmClient");
            X_App_Version = Configuration.handler.getValue("giftcard.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("giftcard.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("giftcard.deviceId");
            AUTH = Configuration.handler.getValue("giftcard.auth");

        }
    }

    public static class Insurance {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;


        public Insurance() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("insurance.is.https.required"));
            HOST = Configuration.handler.getValue("insurance.api.host");
            PORT = Configuration.handler.getValue("insurance.api.port");
            X_MCLIENT = Configuration.handler.getValue("insurance.xmClient");
            X_App_Version = Configuration.handler.getValue("insurance.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("insurance.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("insurance.deviceId");
            AUTH = Configuration.handler.getValue("insurance.auth");

        }
    }

    public static class Stargate {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;


        public Stargate() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("stargate.is.https.required"));
            HOST = Configuration.handler.getValue("stargate.api.host");
            PORT = Configuration.handler.getValue("stargate.api.port");
            X_MCLIENT = Configuration.handler.getValue("stargate.xmClient");
            X_App_Version = Configuration.handler.getValue("stargate.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("stargate.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("stargate.deviceId");
            AUTH = Configuration.handler.getValue("stargate.auth");

        }
    }

    public static class Mf {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;


        public Mf() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("mf.is.https.required"));
            HOST = Configuration.handler.getValue("mf.api.host");
            PORT = Configuration.handler.getValue("mf.api.port");
            X_MCLIENT = Configuration.handler.getValue("mf.xmClient");
            X_App_Version = Configuration.handler.getValue("mf.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("mf.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("mf.deviceId");
            AUTH = Configuration.handler.getValue("mf.auth");

        }
    }

    public static class Core {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT_WEB;
        public static final String X_MCLIENT_ANDROID;
        public static final String X_MCLIENT_IOS;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;
        public static final String AUTH_IOS;
        public static final String AUTH_WEB;
        public static final String AUTHWITHNNOCARDS;
        public static final String AUTHWITHNNOCARDS_IOS;
        public static final String AUTHWITHNNOCARDS_WEB;


        public Core() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("core.is.https.required"));
            HOST = Configuration.handler.getValue("core.api.host");
            PORT = Configuration.handler.getValue("core.api.port");
            X_MCLIENT_ANDROID = Configuration.handler.getValue("core.xmClient.Android");
            X_MCLIENT_IOS = Configuration.handler.getValue("core.xmClient.iOS");
            X_MCLIENT_WEB = Configuration.handler.getValue("core.xmClient.Web");
            X_App_Version = Configuration.handler.getValue("core.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("core.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("core.deviceId");
            AUTH = Configuration.handler.getValue("core.auth");
            AUTH_WEB = Configuration.handler.getValue("core.auth.web");
            AUTH_IOS = Configuration.handler.getValue("core.auth.ios");
            AUTHWITHNNOCARDS = Configuration.handler.getValue("core.auth.nocards");
            AUTHWITHNNOCARDS_IOS = Configuration.handler.getValue("core.auth.nocards.ios");
            AUTHWITHNNOCARDS_WEB = Configuration.handler.getValue("core.auth.nocards.web");
        }
    }

    public static class APIDefaults {
        public static final boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String BACKENDHOST;
        public static final String USERNAME;
        public static final String PASSWORD;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String RETRY_FAILURE_CASES_COUNT;

        public APIDefaults() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("is.https.required"));
            HOST = Configuration.handler.getValue("api.host");
            PORT = Configuration.handler.getValue("api.port");
            BACKENDHOST = Configuration.handler.getValue("api.backendhost");
            USERNAME = Configuration.handler.getValue("username");
            PASSWORD = Configuration.handler.getValue("password");
            X_MCLIENT = Configuration.handler.getValue("x.mClient");
            X_App_Version = Configuration.handler.getValue("xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("retry.failure.cases.count");
        }
    }

    public static class kyc {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String RETRY_FAILURE_CASES_COUNT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;
        public static final String AUTH_No_KYC;
        public static final String AUTH_MIN_KYC;
        public static final String AUTH_FULL_KYC_WITH_PAN;
        public static final String AUTH_FULL_KYC_WITHOUT_PAN;
        public static final String OTP_KYC;


        public kyc() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("kyc.is.https.required"));
            HOST = Configuration.handler.getValue("kyc.api.host");
            PORT = Configuration.handler.getValue("kyc.api.port");
            X_MCLIENT = Configuration.handler.getValue("kyc.xmClient");
            X_App_Version = Configuration.handler.getValue("kyc.xAppVersion");
            RETRY_FAILURE_CASES_COUNT = Configuration.handler.getValue("kyc.retry.failure.cases.count");
            DEVICE_ID = Configuration.handler.getValue("kyc.deviceId");
            AUTH = Configuration.handler.getValue("kyc.auth");
            AUTH_No_KYC = Configuration.handler.getValue("kyc.auth.nokyc");
            AUTH_MIN_KYC = Configuration.handler.getValue("kyc.auth.minkyc");
            AUTH_FULL_KYC_WITH_PAN = Configuration.handler.getValue("kyc.auth.fullkycwithpan");
            AUTH_FULL_KYC_WITHOUT_PAN = Configuration.handler.getValue("kyc.auth.fullkycwithoutpan");
            OTP_KYC = Configuration.handler.getValue("kyc.auth.otpkyc");

        }
    }

    public static class ekyc {
        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;
        public static final String X_MCLIENT;
        public static final String X_App_Version;
        public static final String DEVICE_ID;
        public static final String AUTH;
        public static final String AUTH_No_KYC;
        public static final String AUTH_MIN_KYC;
        public static final String AUTH_FULL_KYC_WITH_PAN;
        public static final String AUTH_FULL_KYC_WITHOUT_PAN;
        public static final String OTP_KYC;


        public ekyc() {
        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("ekyc.is.https.required"));
            HOST = Configuration.handler.getValue("ekyc.api.host");
            PORT = Configuration.handler.getValue("ekyc.api.port");
            X_MCLIENT = Configuration.handler.getValue("ekyc.xmClient");
            X_App_Version = Configuration.handler.getValue("ekyc.xAppVersion");
            DEVICE_ID = Configuration.handler.getValue("ekyc.deviceId");
            AUTH = Configuration.handler.getValue("ekyc.auth");
            AUTH_No_KYC = Configuration.handler.getValue("ekyc.auth.nokyc");
            AUTH_MIN_KYC = Configuration.handler.getValue("ekyc.auth.minkyc");
            AUTH_FULL_KYC_WITH_PAN = Configuration.handler.getValue("ekyc.auth.fullkycwithpan");
            AUTH_FULL_KYC_WITHOUT_PAN = Configuration.handler.getValue("ekyc.auth.fullkycwithoutpan");
            OTP_KYC = Configuration.handler.getValue("ekyc.auth.otpkyc");

        }
    }

    public static class mock {

        public static final Boolean IS_HTTPS_REQUIRED;
        public static final String HOST;
        public static final String PORT;

        public mock() {

        }

        static {
            IS_HTTPS_REQUIRED = Boolean.valueOf(Configuration.handler.getValue("mock.is.https.required"));
            HOST = Configuration.handler.getValue("mock.api.host");
            PORT = Configuration.handler.getValue("mock.api.port");
        }

    }

    public static class Email {
        public static final String RECIPIENTS;
        public static final String SUBJECT;
        public static final String MAIL_BODY_TEXT;
        public static final String TEAM;


        public Email() {
        }

        static {
            RECIPIENTS = String.valueOf(Configuration.handler.getValue("mail.recipients.comma.seperated"));
            SUBJECT = String.valueOf(Configuration.handler.getValue("mail.subject"));
            MAIL_BODY_TEXT = String.valueOf(Configuration.handler.getValue("mail.body.text"));
            TEAM = String.valueOf(Configuration.handler.getValue("team"));


        }
    }

}

