package services.students;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Student;
import utils.DbConnection;

public class StudentRegisterService {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	
	public boolean studentRegister(Student student) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO Students(studentNumber,name,dob,address,contactNo,email,registrationDate,password)values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getStudentNumber());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getDob());
			preparedStatement.setString(4, student.getAddress());
			preparedStatement.setString(5, student.getContactNo());
			preparedStatement.setString(6, student.getEmail());
			preparedStatement.setString(7, student.getRegistrationDate());
			preparedStatement.setString(8, student.getPassword());
			
			result = preparedStatement.executeUpdate() > 0;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
