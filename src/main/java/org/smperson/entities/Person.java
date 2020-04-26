package org.smperson.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;
import org.smperson.froms.PersonForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    private String firstName;
    private String lastName;
    private String email;
    private String tele;


    public void setData(PersonForm personForm) {
        setFirstName(personForm.getFirstName());
        setLastName(personForm.getLastName());
        setEmail(personForm.getEmail());
        setTele(personForm.getTele());
    }

}
