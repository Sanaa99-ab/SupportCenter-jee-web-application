package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.ClassRoom;
import utils.DbConnection;

public class UpdateClassRoom {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean update(ClassRoom classRoom, int id) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "UPDATE Classroom SET number=?,name=?,capacity=? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, classRoom.getNumber());
			preparedStatement.setString(2, classRoom.getName());
			preparedStatement.setInt(3, classRoom.getCapacity());
			preparedStatement.setInt(4, id);
			result = preparedStatement.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
