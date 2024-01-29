package Utils;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Mailer {
    public static void sendMail() throws MessagingException, IOException {
        String username = "mbkmobile.team@mobikwik.com";
        String pass = "Mobikwik@123456";
        String reportPath = System.getProperty("user.dir") + "/Report/ExtentReport.html";
        String logsPath = System.getProperty("user.dir") + "/LogFile.txt";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pass);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setSubject("App Automation Test Results Report");


        message.addRecipients(Message.RecipientType.TO, "mayank.suneja@mobikwik.com");
        message.addRecipients(Message.RecipientType.CC, "paraj.jain@mobikwik.com");


        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("App Automation Test Results Report & Logs");

        MimeBodyPart attachmentPart_report = new MimeBodyPart();
        attachmentPart_report.attachFile(new File(reportPath));

        MimeBodyPart attachmentPart_logs = new MimeBodyPart();
        attachmentPart_logs.attachFile(new File(logsPath));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart_logs);
        multipart.addBodyPart(attachmentPart_report);

        message.setContent(multipart);
        Transport.send(message);
    }
}