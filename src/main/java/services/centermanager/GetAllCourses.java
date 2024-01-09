package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Course;
import utils.DbConnection;

public class GetAllCourses {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<Course> getAll(){
		ArrayList<Course> courses = new ArrayList<Course>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Courses";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Course course = new Course();
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
				course.setDescription(resultSet.getString("description"));
				course.setDuration(resultSet.getDouble("duration"));
				course.setPrice(resultSet.getDouble("price"));
				course.setClassRoom(resultSet.getInt("classroom"));
				courses.add(course);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return courses;
	}
}
