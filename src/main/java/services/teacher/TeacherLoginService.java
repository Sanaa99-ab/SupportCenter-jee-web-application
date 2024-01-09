package services.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Teacher;
import utils.DbConnection;

public class TeacherLoginService {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static Teacher login(String email, String password) {
		
		Teacher teacher = null;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Teachers";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
					teacher = new Teacher();
					teacher.setId(resultSet.getInt("id"));
					teacher.setName(resultSet.getString("name"));
					teacher.setAddress(resultSet.getString("address"));
					teacher.setContactNo(resultSet.getString("contactNo"));
					teacher.setEmail(resultSet.getString("email"));
					teacher.setExpertise(resultSet.getString("expertise"));
					teacher.setRegistrationDate(resultSet.getString("registrationDate"));
					teacher.setPassword(resultSet.getString("password"));
					break;
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return teacher;
	}
}
