package com.vivekcompany.mailappication.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Vivek
 * 
 * Person model to be set from the CSV
 *
 */
@Data
@Builder
public class Person {
	private String email;
	private String firstName;
	private String lastName;
}
