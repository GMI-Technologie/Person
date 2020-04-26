package org.smperson.froms;

import org.smperson.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForm {

	private String firstName;
	private String lastName;
	private String email;
	private String tele;
	

	
}
