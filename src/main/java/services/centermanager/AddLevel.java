package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Level;
import utils.DbConnection;

public class AddLevel {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean add(Level level) {
		boolean result = false;
		
		try {
			
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO Levels (name) VALUES (?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, level.getName());
			result = preparedStatement.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
