package services.centermanager;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Student;
import models.Teacher;
import utils.DbConnection;

public class GetAllTeachers {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<Teacher> getAll(){
		
		ArrayList<Teacher> teachers = new ArrayList<>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Teachers";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setAddress(resultSet.getString("address"));
				teacher.setContactNo(resultSet.getString("contactNo"));
				teacher.setEmail(resultSet.getString("email"));
				teacher.setExpertise(resultSet.getString("expertise"));
				teacher.setRegistrationDate(resultSet.getString("registrationDate"));
				teacher.setPassword(resultSet.getString("password"));
				teachers.add(teacher);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return teachers;
	}
	
}