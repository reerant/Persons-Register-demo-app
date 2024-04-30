package com.demo.persons;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class PersonController {

	List<Person> persons = new ArrayList<>();

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return persons;
	}

	@GetMapping("/persons/{socialSecurityNumber}")
	public Person getPersonBySocialSecurityNumber(@PathVariable String socialSecurityNumber) {
		for (Person person : persons) {
			if (person.getSocialSecurityNumber().equals(socialSecurityNumber)) {
				return person;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		
	}

	@PutMapping("/persons/{id}")
	public Person updatePerson(@PathVariable String id, @RequestBody @Valid Person updatedPerson) {
		int currentIndex = 0;
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				persons.set(currentIndex, updatedPerson);
				return updatedPerson;
			}
			currentIndex++;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
	}

	@PostMapping("/persons")
	public Person createPerson(@RequestBody @Valid Person person) {
		persons.add(person);
		return person;
	}

	@DeleteMapping("/persons/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		if (!persons.removeIf(person -> person.getId().equals(id))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}

	}


}
