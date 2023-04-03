package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.util.Properties;

public class Mailer {

    static String usernameMail = "mobikwiktest123@gmail.com";
    static String passMail = "njwqiqohpbaqekuq";

    public static void sendMail(String subject, String data , String sentFrom ,String mailTo, String mailCC , String mailBCC){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,

                new Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(usernameMail, passMail);

                    }

                });

        try {
            Message message = new MimeMessage(session);

                message.setFrom(new InternetAddress(sentFrom));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailCC));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailBCC));

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            message.setSubject(subject + timestamp);

            message.setContent(data , "text/html");
            // finally send the email
            Transport.send(message);

            System.out.println("=====Email Sent=====");
        }catch (MessagingException e) {

            throw new RuntimeException(e);

        }
    }
}
