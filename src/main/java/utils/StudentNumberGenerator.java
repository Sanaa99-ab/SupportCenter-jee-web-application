package utils;

import java.util.UUID;

public class StudentNumberGenerator {
	
	public static String generateNumber() {
		UUID uuid = UUID.randomUUID();  
	
		return uuid.toString().substring(0,7);
	}
	
}
