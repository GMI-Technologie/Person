package org.smperson;

import org.smperson.entities.Person;
import org.smperson.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@Autowired
	PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {

		personRepository.save(new Person(null, "fatiha", "lghlida", "lghlida@gmail.com", "09598475959"));
		personRepository.save(new Person(null, "amine", "comissir", "comissir@gmail.com", "09598475959"));
		personRepository.save(new Person(null, "zouhir", "lme3za", "lme3za@gmail.com", "09598475959"));

	}

}
