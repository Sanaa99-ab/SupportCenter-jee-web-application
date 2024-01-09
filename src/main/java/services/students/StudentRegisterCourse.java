package services.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DbConnection;

public class StudentRegisterCourse {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static boolean isRegistered(int studentId, int courseId) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM StudentCourses WHERE studentId=? AND courseId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, courseId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				result = true;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static boolean register(int studentId, int courseId) {
		boolean result = false;
		
		try {
			
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO StudentCourses (studentId, courseId) VALUES(?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setInt(2, courseId);
			result = preparedStatement.executeUpdate() > 0;
			
		}catch(Exception e) {
			
		}
		
		return result;
	}
	
}	
