package com.demo.persons;

import java.util.UUID;

public class UniqueIDGenerator {

	static long generateUniqueID() {
		UUID uniqueID = UUID.randomUUID();
		long id = Math.abs(uniqueID.getMostSignificantBits());
		return id;

	}

}
