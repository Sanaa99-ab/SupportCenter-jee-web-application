package services.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.CourseMaterial;
import utils.DbConnection;

public class GetMaterialsByShedule {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static ArrayList<CourseMaterial> getAll(int id){
		
		ArrayList<CourseMaterial> materials = new ArrayList<CourseMaterial>();
		
		try {
			
			connection = DbConnection.getDbConnection();
			String query = "SELECT * FROM CourseMaterials WHERE sheduleId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CourseMaterial material = new CourseMaterial();
				material.setId(resultSet.getInt("id"));
				material.setSheduleId(resultSet.getInt("sheduleId"));
				material.setUnitName(resultSet.getString("unitName"));
				material.setFile(resultSet.getString("material"));
				materials.add(material);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return materials;
	}
	
}
