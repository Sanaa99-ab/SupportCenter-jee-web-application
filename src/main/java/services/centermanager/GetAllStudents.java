package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Student;
import utils.DbConnection;

public class GetAllStudents {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<Student> getAll(){
		
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Students";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setStudentNumber(resultSet.getString("studentNumber"));
				student.setName(resultSet.getString("name"));
				student.setDob(resultSet.getString("dob"));
				student.setAddress(resultSet.getString("address"));
				student.setContactNo(resultSet.getString("contactNo"));
				student.setEmail(resultSet.getString("email"));
				student.setRegistrationDate(resultSet.getString("registrationDate"));
				students.add(student);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
}
