package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Course;
import utils.DbConnection;

public class UpdateCourse {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean update(Course course , int id) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "UPDATE Courses SET name=?,description=?,duration=?,price=?,classroom=? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setString(2, course.getDescription());
			preparedStatement.setDouble(3, course.getDuration());
			preparedStatement.setDouble(4, course.getPrice());
			preparedStatement.setInt(5, course.getClassRoom());
			preparedStatement.setInt(6, id);
			result = preparedStatement.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
