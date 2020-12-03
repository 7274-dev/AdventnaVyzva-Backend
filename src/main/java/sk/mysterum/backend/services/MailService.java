package sk.mysterum.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.mysterum.backend.exception.FileDoesntExistException;
import sk.mysterum.backend.mail.SMTPAuthentication;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Service
public class MailService {
    private final String FROM = "vianocneulohy@gmail.com";
    private final String HOST = "smtp.gmail.com";


    @Autowired
    LoadPassword pwd;



    private Message createMessage(String to, String locationToFile, String personName, Integer day) throws MessagingException, FileDoesntExistException {

        // Set up mail server and get default session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", HOST);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Authenticator auth = new SMTPAuthentication(FROM, pwd.getPassword(buildPathToFile("pswrd.txt")));
        Session session = Session.getDefaultInstance(properties, auth);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        message.setSubject("Vypracovanie dna " + day + " od ziaka: " + personName);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Vypracovanie: ");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);


        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(locationToFile);
        messageBodyPart.setDataHandler(new DataHandler(source));
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
        return message;
    }

    public void sendMessage(String to, String locationToFile, String personName, Integer day) throws MessagingException, FileDoesntExistException {
       Message message = createMessage(to, locationToFile, personName, day);
       Transport.send(message);
        System.out.println("Message Sent");
    }

    private String buildPathToFile(String filename){
        Path currentRelativePath = Paths.get("");
        String absPath = currentRelativePath.toAbsolutePath().toString();

        String path = absPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator +
                      "sk" + File.separator + "mysterum" + File.separator + "backend" + File.separator + filename;
        return null;
    }

}
