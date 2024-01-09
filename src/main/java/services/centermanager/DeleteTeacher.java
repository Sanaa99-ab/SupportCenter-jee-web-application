package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.DbConnection;

public class DeleteTeacher {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static boolean delete(int id) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "DELETE FROM Teachers WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
