package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Shedule;
import utils.DbConnection;

public class GetSheduleData {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static Shedule get(int id) {
		Shedule shedule = null;
		
		try {
			
			connection = DbConnection.getDbConnection();
			String query = "SELECT s.id , c.name as 'CourseName', t.name as 'TeacherName', c2.name as 'ClassRoom', l.name  as 'Level' , s.dayOfWeek, s.startTime, s.endTime FROM Shedules s , Courses c , Teachers t , Classroom c2 , Levels l WHERE s.courseId = c.id AND s.teacherId = t.id AND s.roomId = c2.id AND s.levelId = l.id AND s.id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {

				shedule = new Shedule();
				shedule.setId(resultSet.getInt("id"));
				shedule.setCourseName(resultSet.getString("CourseName"));
				shedule.setTeacherName(resultSet.getString("TeacherName"));
				shedule.setRoomName(resultSet.getString("ClassRoom"));
				shedule.setLevel(resultSet.getString("Level"));
				shedule.setDayOfWeek(resultSet.getInt("dayOfWeek"));
				shedule.setStartTime(resultSet.getString("startTime"));
				shedule.setEndTime(resultSet.getString("endTime"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return shedule;
	}
	
}
