package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Teacher;
import utils.DbConnection;

public class GetTeacherData {
	private static Connection connection;
	private static PreparedStatement preparedStatment;
	private static ResultSet resultSet;
	
	public static Teacher get(int id) {
		Teacher teacher = null;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Teachers WHERE id = ?";
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setInt(1, id);
			resultSet = preparedStatment.executeQuery();
			while(resultSet.next()) {
				teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setAddress(resultSet.getString("address"));
				teacher.setContactNo(resultSet.getString("contactNo"));
				teacher.setEmail(resultSet.getString("email"));
				teacher.setExpertise(resultSet.getString("expertise"));
				teacher.setRegistrationDate(resultSet.getString("registrationDate"));
				teacher.setPassword(resultSet.getString("password"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return teacher;
	}
	
}
