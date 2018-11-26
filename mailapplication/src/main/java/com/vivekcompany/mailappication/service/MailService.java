package com.vivekcompany.mailappication.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.simpleflatmapper.csv.CsvParser;

import com.vivekcompany.mailappication.jobs.JobExecuter;
import com.vivekcompany.mailappication.model.Person;

public class MailService {
	
	private static MailService mailService = null;

	/**
	 * singleton Service class to read the csv, convert to person object and submit the thread to the thread pool
	 * 
	 */
	private MailService() {
	}

	public static MailService getInstance() {
		if (mailService == null)
			mailService = new MailService();
		return mailService;
	}

	public void sendmail(String path) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(path)); Stream<String[]> stream = CsvParser.separator(';').skip(1).stream(reader)) {
			stream.forEach(row -> {
				JobExecuter.queueJob(
						new com.vivekcompany.mailappication.jobs.MailerJob(Person.builder().firstName(row[1]).lastName(row[2]).email(row[0]).build()));
			});
		}
	}
}
	
