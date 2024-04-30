package com.demo.persons;

import java.util.UUID;

public class HelperClass {

	static String generateUniqueID() {
		UUID uniqueID = UUID.randomUUID();
		String id = uniqueID.toString();
		
		return id;

	}

}
