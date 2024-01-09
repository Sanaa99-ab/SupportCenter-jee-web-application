package services.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.CourseMaterial;
import utils.DbConnection;

public class AddCourseMaterial {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean add(CourseMaterial courseMaterial) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO CourseMaterials (sheduleId,unitName,material) VALUES(?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, courseMaterial.getSheduleId());
			preparedStatement.setString(2, courseMaterial.getUnitName());
			preparedStatement.setString(3, courseMaterial.getFile());
			result = preparedStatement.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
