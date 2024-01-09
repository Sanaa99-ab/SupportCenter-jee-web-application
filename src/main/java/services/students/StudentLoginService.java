package services.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Student;
import utils.DbConnection;

public class StudentLoginService {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	
	public static Student login(String email, String password) {
		Student student = null;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Students WHERE email=? AND password=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setName(resultSet.getString("name"));
				student.setDob(resultSet.getString("dob"));
				student.setAddress(resultSet.getString("address"));
				student.setContactNo(resultSet.getString("contactNo"));
				student.setEmail(resultSet.getString("email"));
				student.setStudentNumber(resultSet.getString("studentNumber"));
				student.setRegistrationDate(resultSet.getString("registrationDate"));
				student.setPassword(resultSet.getString("password"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}
}
