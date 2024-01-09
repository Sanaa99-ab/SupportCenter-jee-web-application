package models;

import java.util.ArrayList;
import models.Unit;

public class Shedule {

	private int id;
	private int courseId;
	private int teacherId;
	private int roomId;
	private int levelId;
	private int dayOfWeek;
	private String startTime;
	private String endTime;
	private String teacherName;
	private String courseName;
	private String roomName;
	private String level;
	private ArrayList<String> materials = new ArrayList<String>();
	private ArrayList<String> units = new ArrayList<String>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	public void addMaterial(String material) {
		
		if(material!=null) {
			this.materials.add(material);
		}
		
	}
	
	public ArrayList<String> getMaterials(){
		return this.materials;
	}
	
	public void addUnits(String unit) {
		
		if(unit!=null) {
			this.units.add(unit);
		}
		
	}
	
	public ArrayList<String> getUnits(){
		return this.units;
	}
	
	public ArrayList<Unit> getCourseUnits(){
		ArrayList<Unit> courseUnits = new ArrayList<Unit>();
		
		for(int i=0 ; i< materials.size(); i++) {
			Unit unit = new Unit();
			unit.setUnitName(this.units.get(i));
			unit.setFile(this.materials.get(i));
			courseUnits.add(unit);
		}
		

		return courseUnits;
	}
	
}
