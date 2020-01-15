package UITestFramework;

import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Mailer extends Authenticator {
    String user;
    String pw;

    public Mailer(String username, String password) {
        super();
        this.user = username;
        this.pw = password;
    }

    // Test

    // reportFileName = TestExecutionResultFileName
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pw);
    }

    // @AfterSuite(groups = { "mailReport" })
    @Test(groups = {"mailReport"}, priority = 3)
    public static void reportMailer(String filePath, String fileName) throws Exception

    {

        String path = filePath;
        String Name = fileName;
        String[] to = {"Mobitest313@gmail.com"};
        String[] cc = {};
        String[] bcc = {};

        String userName = "mobitest313@gmail.com";

        sendMail(userName, "avicii313", "smtp.gmail.com", "465", "true", "true", false,
                "javax.net.ssl.SSLSocketFactory", "false", to, cc, bcc, "Test Execution report", "Contents", path,
                Name);
    }

    public static boolean sendMail(String userName, String passWord, String host, String port, String starttls,
                                   String auth, boolean debug, String socketFactoryClass, String fallback, String[] to, String[] cc,
                                   String[] bcc, String subject, String text, String attachmentPath, String attachmentName) {

        // Object Instantiation of a properties file.
        Properties props = new Properties();

        props.put("mail.smtp.user", userName);

        props.put("mail.smtp.host", host);

        if (!"".equals(port)) {
            props.put("mail.smtp.port", port);
        }

        if (!"".equals(starttls)) {
            props.put("mail.smtp.starttls.enable", starttls);
            props.put("mail.smtp.auth", auth);
        }

        if (debug) {

            props.put("mail.smtp.debug", "true");

        } else {

            props.put("mail.smtp.debug", "false");

        }

        if (!"".equals(port)) {
            props.put("mail.smtp.socketFactory.port", port);
        }
        if (!"".equals(socketFactoryClass)) {
            props.put("mail.smtp.socketFactory.class", socketFactoryClass);
        }
        if (!"".equals(fallback)) {
            props.put("mail.smtp.socketFactory.fallback", fallback);
        }

        try {

            Session session = Session.getDefaultInstance(props, new Mailer("Mobitest313@gmail.com", "avicii313"));

            session.setDebug(debug);

            MimeMessage msg = new MimeMessage(session);

            msg.setText(text);

            msg.setSubject(subject);

            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentPath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachmentName);
            multipart.addBodyPart(messageBodyPart);

            msg.setContent(multipart);
            msg.setFrom(new InternetAddress(userName));

            for (int i = 0; i < to.length; i++) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
            }

            for (int i = 0; i < cc.length; i++) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
            }

            for (int i = 0; i < bcc.length; i++) {
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
            }

            msg.saveChanges();

            Transport transport = session.getTransport("smtp");

            transport.connect(host, userName, passWord);

            transport.sendMessage(msg, msg.getAllRecipients());

            transport.close();

            return true;

        } catch (Exception mex) {
            mex.printStackTrace();
            return false;
        }
    }
}
