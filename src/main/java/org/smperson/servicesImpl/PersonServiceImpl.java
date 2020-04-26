package org.smperson.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.smperson.Iservices.IPersonService;
import org.smperson.dto.PersonDTO;
import org.smperson.entities.Person;
import org.smperson.froms.PersonForm;
import org.smperson.mapper.PersonMapper;
import org.smperson.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<PersonDTO> getPersons() {
        Sort sortByLastName = Sort.by(Sort.Direction.ASC, "LastName");
        List<Person> persons = personRepository.findAll(sortByLastName);
        List<PersonDTO> personsDTO = new ArrayList<>();
        persons.forEach(person -> {
            personsDTO.add(PersonMapper.INSTANCE.persontoPersonDTO(person));
        });
        return personsDTO;
    }

    @Override
    public PersonDTO getPerson(Long idPerson) {
        Optional<Person> option = personRepository.findById(idPerson);
        return PersonMapper.INSTANCE.persontoPersonDTO(option.get());
    }

    @Override
    public PersonDTO savePerson(PersonForm personForm) {
        Person person = PersonMapper.INSTANCE.personFormtoPerson(personForm);
        person = personRepository.save(person);
        return PersonMapper.INSTANCE.persontoPersonDTO(person);
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
        return PersonMapper.INSTANCE.persontoPersonDTO(pers);
    }

}
