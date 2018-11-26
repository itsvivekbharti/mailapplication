package com.vivekcompany.mailappication.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Vivek
 * 
 * Class to initialize and get the application properties
 *
 */
public class ApplicationProperties {

	private static final String APPLICATION_PROPERTIES = "application.properties";
	public static Properties applicationProperties = new Properties();
	
	public static void loadApplicationProperties() throws IOException {
	String rootPath = Thread.currentThread().getContextClassLoader().getResource(StringUtils.EMPTY).getPath();
	String appConfigPath = rootPath + APPLICATION_PROPERTIES;
	try {
		applicationProperties.load(new FileInputStream(appConfigPath));
	} catch (IOException e) {
		throw new IOException("Error reading properties");
	}
	}
	
	public static String get(String key) {
		return applicationProperties.getProperty(key);
		
	}
}
