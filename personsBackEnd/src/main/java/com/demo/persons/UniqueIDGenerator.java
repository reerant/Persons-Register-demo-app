package com.demo.persons;

import java.util.UUID;

public class UniqueIDGenerator {

	static String generateUniqueID() {
		UUID uniqueID = UUID.randomUUID();
		String id = uniqueID.toString();
		
		return id;

	}

}
