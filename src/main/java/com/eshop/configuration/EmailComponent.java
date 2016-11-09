package com.eshop.configuration;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by raks on 07.11.16.
 */
@Component
public class EmailComponent {     // sender email
    String from = "verify@taks.com";       // receiver email
    String host = "127.0.0.1";            // mail server host

    public void sendMessage(String to_whom, String text_body, String text_Subject){
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);
    properties.put("mail.smtp.auth", false);

    Session session = Session.getDefaultInstance(properties); // default session

    try {
        MimeMessage message = new MimeMessage(session); // email message

        message.setFrom(new InternetAddress(from)); // setting header fields

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_whom));

        message.setSubject(text_Subject); // subject line

        // actual mail body
        message.setContent(text_body,"text/html");

        // Send message
        Transport.send(message);
        System.out.println("Email Sent successfully....");
    } catch (MessagingException mex){ mex.printStackTrace(); }

}
}
