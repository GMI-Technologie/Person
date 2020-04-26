package org.smperson.dto;

import org.smperson.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

	private Long idPerson;
	private String firstName;
	private String lastName;
	private String email;
	private String tele;
	

}
