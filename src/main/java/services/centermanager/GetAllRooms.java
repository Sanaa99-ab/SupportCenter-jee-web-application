package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.ClassRoom;
import utils.DbConnection;

public class GetAllRooms {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<ClassRoom> getAll(){
		ArrayList<ClassRoom> rooms = new ArrayList<ClassRoom>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Classroom";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ClassRoom classRoom = new ClassRoom();
				classRoom.setId(resultSet.getInt("id"));
				classRoom.setName(resultSet.getString("name"));
				classRoom.setNumber(resultSet.getString("number"));
				classRoom.setCapacity(resultSet.getInt("capacity"));
				rooms.add(classRoom);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rooms;
	}
}
