package com.vivekcompany.mailappication.validator;
import java.io.File;
import org.apache.log4j.Logger;

/**
 * @author Vivek
 * 
 * Generic validator class to handle all the validations in the application
 *
 */
public class ApplicationValidator {
	private static final Logger logger = Logger.getLogger(ApplicationValidator.class);
	
	public static boolean validateArgument(String[] args) {
		if (args==null || args.length != 1) {
			logger.error("Kindly provide the file path for the csv");
			return false;
		}
		File tmpFile = new File(args[0]);
		if (!tmpFile.exists()) {
			logger.error("File does not exists at the given path");
			return false;
		}
		return true;
	}
}
