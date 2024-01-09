package models;

public class CourseMaterial {
	
	private int id;
	private int sheduleId;
	private String unitName;
	private String file;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSheduleId() {
		return sheduleId;
	}
	public void setSheduleId(int sheduleId) {
		this.sheduleId = sheduleId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
