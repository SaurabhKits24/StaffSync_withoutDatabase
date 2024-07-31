import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static void main(String[] args) {
        // SMTP server configuration
        String toEmail = "ssbhatia2957@gmail.com"; // recipient's email
        String fromEmail = "ssbhatia2957@gmail.com"; // your email
        String fromEmailPassword = "eqqm frmd zkfw qquz"; // your app password
        String subject = "Test Subject"; // email subject
        String body = "This is a test email body."; // email body
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromEmailPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
