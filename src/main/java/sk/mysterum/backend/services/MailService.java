package sk.mysterum.backend.services;

import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class MailService {
    private final String FROM = "waldowaldasxx@gmail.com";
    private final String HOST = "localhost";



    private Message createMessage(String to, String locationToFile, String personName, Integer day) throws MessagingException{

        // Set up mail server and get default session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        Session session = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        message.setSubject("Vypracovanie dna " + day + " od ziaka: " + personName);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Vypracovanie: ");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);


//        messageBodyPart = new MimeBodyPart();
//        DataSource source = new FileDataSource(locationToFile);
//        messageBodyPart.setDataHandler(new DataHandler(source));
//        messageBodyPart.setFileName(personName+ " " + day + ".png");
//        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
        return message;
    }

    public void sendMessage(String to, String locationToFile, String personName, Integer day) throws MessagingException {
       Message message = createMessage(to, locationToFile, personName, day);
       Transport.send(message);
        System.out.println("Message Sent");
    }
}
