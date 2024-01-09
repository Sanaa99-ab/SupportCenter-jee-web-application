package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Teacher;
import utils.DbConnection;

public class AddTeacher {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static boolean addTeacher(Teacher teacher) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO Teachers (name,address,contactNo,email,expertise,registrationDate,password) VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getAddress());
			preparedStatement.setString(3, teacher.getContactNo());
			preparedStatement.setString(4, teacher.getEmail());
			preparedStatement.setString(5, teacher.getExpertise());
			preparedStatement.setString(6, teacher.getRegistrationDate());
			preparedStatement.setString(7, teacher.getPassword());
			
			result = preparedStatement.executeUpdate() > 0;
			
			
		}catch(Exception e) {
			
		}
		
		return result;
	}
}
