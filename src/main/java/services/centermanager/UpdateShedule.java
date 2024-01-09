package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Shedule;
import utils.DbConnection;

public class UpdateShedule {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	
	public static boolean update(Shedule shedule, int id) {
		boolean result = false;

		try {
			connection = DbConnection.getDbConnection();
			String query  = "UPDATE Shedules SET courseId=?,teacherId=?,roomId=?,levelId=?,dayOfWeek=?,startTime=?,endTime=? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, shedule.getCourseId());
			preparedStatement.setInt(2, shedule.getTeacherId());
			preparedStatement.setInt(3, shedule.getRoomId());
			preparedStatement.setInt(4, shedule.getLevelId());
			preparedStatement.setInt(5, shedule.getDayOfWeek());
			preparedStatement.setString(6, shedule.getStartTime());
			preparedStatement.setString(7, shedule.getEndTime());
			preparedStatement.setInt(8, id);
			result = preparedStatement.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
