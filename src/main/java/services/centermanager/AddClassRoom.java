package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.ClassRoom;
import utils.DbConnection;

public class AddClassRoom {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean add(ClassRoom classRoom) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO Classroom (number,name,capacity) VALUES (?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, classRoom.getNumber());
			preparedStatement.setString(2, classRoom.getName());
			preparedStatement.setInt(3, classRoom.getCapacity());
			result = preparedStatement.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
