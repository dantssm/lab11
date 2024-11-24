package ua.edu.ucu.com.task2;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailSender {

    public void sendMail(MailInfo mailInfo) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "your.smtp.host");
        props.put("mail.smtp.port", "2525");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username", "pass");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, 
                InternetAddress.parse(mailInfo.getClient().getEmail()));
            message.setSubject("Important Message");
            message.setText(mailInfo.generate());

            Transport.send(message);
            System.out.println("Email sent successfully."
                + mailInfo.getClient().getEmail());

        } catch (MessagingException e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}