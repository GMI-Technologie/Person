package org.smperson.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.smperson.Iservices.IPersonService;
import org.smperson.dto.PersonDTO;
import org.smperson.entities.Person;
import org.smperson.froms.PersonForm;
import org.smperson.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<PersonDTO> getPersons() {
		Sort sortByLastName = Sort.by(Sort.Direction.ASC, "LastName");
		List<Person> persons = personRepository.findAll(sortByLastName);
		List<PersonDTO> personsDTO = new ArrayList<>();
		persons.forEach(person -> {
			personsDTO.add(PersonDTO.convert(person));
		});
		return personsDTO;
	}

	@Override
	public PersonDTO getPerson(Long idPerson) {
		Optional<Person> option = personRepository.findById(idPerson);
		return PersonDTO.convert(option.get());
	}

	@Override
	public PersonDTO savePerson(PersonForm personForm) {
		Person person = PersonForm.extract(personForm);
		person = personRepository.save(person);
		return PersonDTO.convert(person);
	}

	@Override
	public boolean deletePerson(Long idPerson) {
		if (personRepository.existsById(idPerson)) {
			personRepository.deleteById(idPerson);
			return true;
		}
		return false;
	}

	@Override
	public PersonDTO updatePerson(Long idPerson, PersonForm personForm) {
		Optional<Person> opt = personRepository.findById(idPerson);
		Person pers = opt.get();
		pers.setData(personForm);
		personRepository.save(pers);
		return PersonDTO.convert(pers);
	}

}
