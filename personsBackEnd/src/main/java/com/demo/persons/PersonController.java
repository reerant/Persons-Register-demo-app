package com.demo.persons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PersonController {

	List<Person> persons = new ArrayList<>();

	public class ResourceNotFoundException extends RuntimeException {
	    public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}


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
		throw new ResourceNotFoundException("Social security number: " + socialSecurityNumber +  " not found");
		
	}

	@PutMapping("/persons/{id}")
	public Person updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
		int currentIndex = 0;
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				persons.set(currentIndex, updatedPerson);
				return updatedPerson;
			}
			currentIndex++;
		}
		throw new ResourceNotFoundException("Resource with id: " + id +  " not found");
	}

	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		persons.add(person);
		return person;
	}

	@DeleteMapping("/persons/{id}")
	public void delete(@PathVariable String id) {
		persons.removeIf(person -> person.getId().equals(id));

	}
	

}
