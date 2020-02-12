/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Hejer Ghariani
 */
public class EnvoyerMail {
    private String username = "ahmedfachfouch1@gmail.com";
private String password = "19982411998241Ah";
public void envoyer() {
// Etape 1 : Création de la session
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
try {
// Etape 2 : Création de l'objet Message
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("ahmedfachfouch1@gmail.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse("ahmedfachfouch1@gmail.com"));
message.setSubject("Test email");
message.setText("Bonjour, ce message est un test ...");
// Etape 3 : Envoyer le message
Transport.send(message);
System.out.println("Message_envoye");
} catch (MessagingException e) {
throw new RuntimeException(e);
} }
//Etape 4 : Tester la méthode
public static void main(String[] args) {
EnvoyerMail test = new EnvoyerMail();
test.envoyer();
}
}
