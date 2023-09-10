package org.Rohit;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedAuth extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(Constants.sendId,Constants.Pass);
    }
}
