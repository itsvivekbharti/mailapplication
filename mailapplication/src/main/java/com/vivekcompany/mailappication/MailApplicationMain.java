package com.vivekcompany.mailappication;

import java.io.IOException;
import org.apache.log4j.Logger;
import com.vivekcompany.mailappication.property.ApplicationProperties;
import com.vivekcompany.mailappication.service.MailService;
import com.vivekcompany.mailappication.validator.ApplicationValidator;

/**
 * @author Vivek
 * 
 * Main class for the application which needs a path of csv file as an argument
 *
 */
public class MailApplicationMain {
	private static final Logger logger = Logger.getLogger(MailApplicationMain.class);

	public static void main(String[] args) {
		try {
			ApplicationProperties.loadApplicationProperties();
			if (!ApplicationValidator.validateArgument(args)) {
				System.exit(1);
			}
			MailService.getInstance().sendmail(args[0]);
		} catch (IOException e) {
			logger.error("Error reading file", e);
		}
	}
}
