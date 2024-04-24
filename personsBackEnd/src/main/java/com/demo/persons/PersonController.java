package com.demo.persons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PersonController {

	List<Person> persons = new ArrayList<>();

	public class Console {

		public static void Log(Object obj) {
			System.out.println(obj);
		}
	}

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return persons;
	}

	@GetMapping("/persons/{id}")
	public Person getPersonById(@PathVariable long id) {
		for (Person person : persons) {
			if (person.getId() == id) {
				return person;
			}
		}
		return null;
	}

	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		persons.add(person);
		return person;
	}

	@DeleteMapping("/persons/{id}")
	public void delete(@PathVariable long id) {
		persons.removeIf(person -> person.getId() == id);

	}

}
