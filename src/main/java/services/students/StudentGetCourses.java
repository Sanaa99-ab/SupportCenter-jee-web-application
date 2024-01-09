package services.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Course;
import utils.DbConnection;

public class StudentGetCourses {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<Course> getAll(int id){
		ArrayList<Course> courses = new ArrayList<Course>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT c.id, c.name, c.description, c.duration, c.classroom FROM StudentCourses s, Courses c WHERE c.id=s.courseId AND s.studentId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Course course = new Course();
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
				course.setDescription(resultSet.getString("description"));
				course.setDuration(resultSet.getDouble("duration"));
				course.setClassRoom(resultSet.getInt("classroom"));
				courses.add(course);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return courses;
	}
}
