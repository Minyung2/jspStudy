package jspstudy;

import java.sql.Date;

public class RecipeDTO {
	private String id;
	private String name;
	private String category_id;
	private String difficulty;
	private String cookcing_time; 
	private String coocking_method;
	private Date created_date;
	private Date updated_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getCookcing_time() {
		return cookcing_time;
	}
	public void setCookcing_time(String cookcing_time) {
		this.cookcing_time = cookcing_time;
	}
	public String getCoocking_method() {
		return coocking_method;
	}
	public void setCoocking_method(String coocking_method) {
		this.coocking_method = coocking_method;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	
	
}
