import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDemo {

	public static void send(String username,String password,String to , String sub, String msg) {
	
	
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance
				(props, new javax.mail.Authenticator()
				{protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
					return new javax.mail.PasswordAuthentication(username, password);
				}});
	
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(sub);
			message.setText(msg);
			
			Transport.send(message);
			
			//System.out.println("done...");
			
		} catch (Exception e) {
			System.out.println("error "+e);
		}
	}

}
