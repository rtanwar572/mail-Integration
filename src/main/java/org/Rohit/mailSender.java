package org.Rohit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailSender {

    private String mess;

    public String getMess() {
        return mess;
    }
public mailSender(String mess){
    System.out.println("sended message is: : "+mess);
        this.mess=mess;
}
    public void setMess(String mess) {
        this.mess = mess;
//        sendmail();

    }

    public void sendmail() {
        System.out.println();
        System.out.println("Printing Starts From here .... ");
        Properties pr = System.getProperties();
        pr.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        pr.put("mail.smtp.port","465"); //server port
        pr.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
        pr.put("mail.smtp.auth","true"); //authentication - auth




//        System.out.println(pr);
        Authenticator authenticator=new CustomizedAuth();

        //session is created ...
        Session session = Session.getInstance(pr,authenticator);

        //need to compose message is an abstract cls o that's why we can use subclass of ii
        MimeMessage message = new MimeMessage(session);


        try {
            message.setFrom(Constants.sendId);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(Constants.Recievr));
            message.setHeader("hello","are u faine ??? ");
            message.setSubject("Related to api Integration !! ");
            message.setText(mess);
            Transport.send(message);
            System.out.println("SuccessFull Mission !!!!! ");
        }
        catch(Exception ex) {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }

    }
}
