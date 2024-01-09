package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DbConnection;

public class GetAllCoursePayments {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static double getTotalPayments() {
		
		double payments = 0;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT SUM(c.price) AS 'Total' FROM StudentCourses sc , Courses c WHERE sc.courseId = c.id ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				payments = resultSet.getDouble("Total");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return payments;
		
	}
}
