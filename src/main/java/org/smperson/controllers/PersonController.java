package org.smperson.controllers;

import java.util.List;

import org.smperson.Iservices.IPersonService;
import org.smperson.dto.PersonDTO;
import org.smperson.froms.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    @Autowired
    IPersonService personService;

    @GetMapping
    public List<PersonDTO> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public PersonDTO savePerson(@RequestBody PersonForm personForm) {
        return personService.savePerson(personForm);
    }

    @GetMapping("/{idPerson}")
    public PersonDTO getPerson(@PathVariable Long idPerson) {
        return personService.getPerson(idPerson);
    }

    @PutMapping("/{idPerson}")
    public PersonDTO updatePerson(@PathVariable Long idPerson, @RequestBody PersonForm personForm) {
        return personService.updatePerson(idPerson, personForm);
    }

    @DeleteMapping("/{idPerson}")
    public boolean deletePerson(@PathVariable Long idPerson) {
        return personService.deletePerson(idPerson);
    }
}
