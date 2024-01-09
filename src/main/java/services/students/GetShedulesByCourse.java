package services.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Shedule;
import utils.DbConnection;

public class GetShedulesByCourse {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<Shedule> getShedules(int studentId){
		
		ArrayList<Shedule> shedules = new ArrayList<Shedule>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT\n"
					+ "    Shedules.id AS scheduleId,\n"
					+ "    Courses.name AS courseName,\n"
					+ "    Teachers.name AS TeacherName,\n"
					+ "    Classroom.name AS ClassName,\n"
					+ "    Levels.name AS Level,\n"
					+ "    Shedules.roomId,\n"
					+ "    Shedules.dayOfWeek,\n"
					+ "    Shedules.startTime,\n"
					+ "    Shedules.endTime,\n"
					+ "    GROUP_CONCAT(CourseMaterials.material SEPARATOR ', ') AS CourseMaterialsList,\n"
					+ "    GROUP_CONCAT(CourseMaterials.unitName SEPARATOR ', ') AS UnitNameList\n"
					+ "FROM\n"
					+ "    StudentCourses\n"
					+ "JOIN\n"
					+ "    Shedules ON StudentCourses.courseId = Shedules.courseId\n"
					+ "JOIN\n"
					+ "    Courses ON Shedules.courseId = Courses.id\n"
					+ "JOIN\n"
					+ "	Teachers ON Shedules.teacherId = Teachers.id\n"
					+ "JOIN\n"
					+ "	Classroom ON Shedules.roomId = Classroom.id\n"
					+ "JOIN\n"
					+ "	CourseMaterials ON CourseMaterials.sheduleId = Shedules.id\n"
					+ "JOIN\n"
					+ "	Levels ON Levels.id = Shedules.levelId \n"
					+ "WHERE\n"
					+ "    StudentCourses.studentId = ?\n"
					+ "GROUP BY\n"
					+ "    Shedules.id, Courses.id, Teachers.name, Classroom.name, Shedules.roomId, Shedules.levelId, Shedules.dayOfWeek, Shedules.startTime, Shedules.endTime;";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Shedule shedule = new Shedule();
				shedule.setId(resultSet.getInt("scheduleId"));
				shedule.setCourseName(resultSet.getString("courseName"));
				shedule.setTeacherName(resultSet.getString("teacherName"));
				shedule.setRoomName(resultSet.getString("className"));
				shedule.setLevel(resultSet.getString("Level"));
				shedule.setDayOfWeek(resultSet.getInt("dayOfWeek"));
				shedule.setStartTime(resultSet.getString("startTime"));
				shedule.setEndTime(resultSet.getString("endTime"));
				
				for(String file:resultSet.getString("CourseMaterialsList").split(",")) {
					shedule.addMaterial(file);
				}
				
				for(String unit:resultSet.getString("UnitNameList").split(",")) {
					shedule.addUnits(unit);
				}
				
				shedules.add(shedule);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return shedules;
		
	}
	
}
