package com.vivekcompany.mailappication.jobs;

import com.vivekcompany.mailappication.model.Person;
import com.vivekcompany.mailappication.utils.MailUtils;

/**
 * @author Vivek
 * Thread to send the mails to the person set in the attributed
 *
 */
public class MailerJob implements Runnable{

	private Person person;
	
	public MailerJob(Person person){
		this.person = person;
	}
		public void run() {
			try{
			MailUtils.sendMail(person);
			} catch (Exception e) {
				System.out.println("error sending mail to " + person.getEmail());
			}
		}
}
