package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Shedule;
import utils.DbConnection;

public class AddShedule {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
    public static boolean checkTimeConflict(String startTime1, String endTime1, String startTime2, String endTime2) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date start1 = sdf.parse(startTime1);
            Date end1 = sdf.parse(endTime1);
            Date start2 = sdf.parse(startTime2);
            Date end2 = sdf.parse(endTime2);

            return (start1.before(end2) && end1.after(start2)) || (start2.before(end1) && end2.after(start1));
        
        } catch (ParseException e) {
            e.printStackTrace(); 
            return false; 
        }
    }
	
	public static String checkTeacherAvailability(int teacherId, String startTime, String endTime) {
		String result = "Conflict";
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Shedules WHERE teacherId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, teacherId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()==false) {
				result = "OK";
		
			}else {
				while(resultSet.next()) {
					String sTime = resultSet.getString("startTime");
					String eTime = resultSet.getString("endTime");
					
					if(AddShedule.checkTimeConflict(sTime, eTime, startTime, endTime) == false) {
						result = "OK";
					}else {
						break;
					}
				}
			}
			

			
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static boolean add(Shedule shedule) {
		boolean result = false;
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "INSERT INTO Shedules (courseId,teacherId,roomId,levelId,dayOfWeek,startTime,endTime) VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, shedule.getCourseId());
			preparedStatement.setInt(2, shedule.getTeacherId());
			preparedStatement.setInt(3, shedule.getRoomId());
			preparedStatement.setInt(4, shedule.getLevelId());
			preparedStatement.setInt(5, shedule.getDayOfWeek());
			preparedStatement.setString(6, shedule.getStartTime());
			preparedStatement.setString(7, shedule.getEndTime());
			result = preparedStatement.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
