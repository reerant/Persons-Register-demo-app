package com.demo.persons;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class PersonsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void getAllPersons() throws Exception {
		mockMvc.perform(get("/persons")).andExpect(status().isOk());
	}

	@Test
	void shouldCreatePerson() throws Exception {
		Address address = new Address("Testikatu 45", "00100", "Testilä");
		Person person = new Person("Testi", "Testinen", "123456-xxxx", "050-181818", address);

		String jsonPerson = objectMapper.writeValueAsString(person);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/persons").contentType(MediaType.APPLICATION_JSON).content(jsonPerson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Testi"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Testinen"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.socialSecurityNumber").value("123456-xxxx"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("050-181818"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address.street").value("Testikatu 45"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address.postalCode").value("00100"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address.city").value("Testilä"));

	}

	@Test
	void shouldGetPersonBySocialSecurityNumber() throws Exception {

		// create and post test person
		Address address = new Address("Testikatu 45", "00100", "Testilä");
		Person person = new Person("Testi", "Testinen", "123456-xxxx", "050-181818", address);

		String jsonPerson = objectMapper.writeValueAsString(person);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/persons").contentType(MediaType.APPLICATION_JSON).content(jsonPerson));

		// get person by socialSecurityNumber
		String socialSecurityNumber = "123456-xxxx";

		mockMvc.perform(MockMvcRequestBuilders.get("/persons/{socialSecurityNumber}", socialSecurityNumber)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Testi"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Testinen"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.socialSecurityNumber").value("123456-xxxx"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("050-181818"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address.street").value("Testikatu 45"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address.postalCode").value("00100"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address.city").value("Testilä"));
	}

}
