package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.ClassRoom;
import utils.DbConnection;

public class GetRoomData {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ClassRoom get(int id) {
		ClassRoom classRoom = null;
		
		try {
			
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Classroom WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				classRoom = new ClassRoom();
				classRoom.setId(resultSet.getInt("id"));
				classRoom.setName(resultSet.getString("name"));
				classRoom.setNumber(resultSet.getString("number"));
				classRoom.setCapacity(resultSet.getInt("capacity"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return classRoom;
	}
}
