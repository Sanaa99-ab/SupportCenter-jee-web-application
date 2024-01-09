package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Course;
import utils.DbConnection;

public class AddCourse {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean add(Course course) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO Courses (name,description,duration,price,classroom) VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setString(2, course.getDescription());
			preparedStatement.setDouble(3, course.getDuration());
			preparedStatement.setDouble(4, course.getPrice());
			preparedStatement.setInt(5, course.getClassRoom());
			result = preparedStatement.executeUpdate() >0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
