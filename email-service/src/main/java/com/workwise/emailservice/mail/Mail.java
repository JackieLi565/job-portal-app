package com.workwise.emailservice.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@"
            + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static void sendSignupEmail(String addr) throws MessagingException, IllegalArgumentException {
        Session session = Session.getInstance(properties(), getAuth());

        Message message = new MimeMessage(session);

        message.setSubject("Thank you for signing up to Workwise");
        message.setText("Thank you for signing up");

        if (validateEmail(addr)) {
            Address address = new InternetAddress(addr);

            message.setRecipient(Message.RecipientType.TO, address);

            Transport.send(message);
        } else {
            throw new IllegalArgumentException("invalid email");
        }
    }

    private static boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static Properties properties() {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");

        return properties;
    }

    private static Authenticator getAuth() {
        return new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(System.getenv("SMTP_MAIL_ADDR"), System.getenv("SMTP_PASSWORD"));
            }
        };
    }

}
