package org.smperson.Iservices;

import java.util.List;

import org.smperson.dto.PersonDTO;
import org.smperson.froms.PersonForm;

public interface IPersonService {

	public List<PersonDTO> getPersons();

	public PersonDTO getPerson(Long idPerson);

	public PersonDTO savePerson(PersonForm personForm);

	public boolean deletePerson(Long idPerson);

	public PersonDTO updatePerson(Long idPerson, PersonForm personForm);

}
