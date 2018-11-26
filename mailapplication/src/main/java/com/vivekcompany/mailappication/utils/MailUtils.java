package com.vivekcompany.mailappication.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.vivekcompany.mailappication.model.Person;
import com.vivekcompany.mailappication.property.ApplicationProperties;

public class MailUtils {
	
	private static final String SPACE = " ";
	private static final String MAIL_SUBJECT = "Mail subject for you";
	private static final String MAIL_BODY = ", \n This is your mail message \n\n Thanks \n Team Vivekcompany";
	private static final String HI = "Hi ";
	private static final Logger logger = Logger.getLogger(Main.class);

	private static final String MAIL_SENDER_EMAIL = "mail.sender.email";
	private static final String MAIL_SENDER_HOST = "mail.sender.host";
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";

	public static void sendMail(Person person) {
		Properties properties = System.getProperties();
		properties.setProperty(MAIL_SMTP_HOST, ApplicationProperties.get(MAIL_SENDER_HOST));
		Session session = Session.getDefaultInstance(properties);
		try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(ApplicationProperties.get(MAIL_SENDER_EMAIL)));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(person.getEmail()));
				message.setSubject(MAIL_SUBJECT);
				message.setText(HI + person.getFirstName() + SPACE + person.getLastName() + MAIL_BODY);
				Transport.send(message);
				logger.info("Mail sent successfully to " + person.getEmail());
		} catch (MessagingException mex) {
			logger.error("Mail sending failed to " + person.getEmail());
		}
	}
}
