package services.centermanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Level;
import utils.DbConnection;

public class GetAllLevels {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<Level> getAll(){
		ArrayList<Level> levels = new ArrayList<Level>();
		
		try {
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM Levels";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Level level = new Level();
				level.setId(resultSet.getInt("id"));
				level.setName(resultSet.getString("name"));
				levels.add(level);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return levels;
	}
}
