package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Teacher;
import utils.DbConnection;

public class UpdateTeacher {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean update(Teacher teacher , int id) {
		boolean result = false;
		
		try {
			
			connection = DbConnection.getDbConnection();
			String query = "UPDATE Teachers SET name=?,address=?,contactNo=?,email=?,expertise=?,password=? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getAddress());
			preparedStatement.setString(3, teacher.getContactNo());
			preparedStatement.setString(4, teacher.getEmail());
			preparedStatement.setString(5, teacher.getExpertise());
			preparedStatement.setString(6, teacher.getPassword());
			preparedStatement.setInt(7, id);
			result = preparedStatement.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
