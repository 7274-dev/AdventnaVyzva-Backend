package sk.mysterum.backend.mail;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;


public class SMTPAuthentication extends Authenticator {
    private PasswordAuthentication auth;

    public SMTPAuthentication(String login, String password) {
        auth = new PasswordAuthentication(login, password);
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return auth;
    }
}
