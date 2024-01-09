package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Course;
import utils.DbConnection;

public class GetCourseData {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static Course get(int id) {
		Course course = null;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Courses WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				course = new Course();
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
				course.setDescription(resultSet.getString("description"));
				course.setDuration(resultSet.getDouble("duration"));
				course.setPrice(resultSet.getDouble("price"));
				course.setClassRoom(resultSet.getInt("classroom"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return course;
	}
}
