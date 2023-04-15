package project.dto;

public class RecipeDto {
	private String recipe_id;
	private String recipe_name;
	private String recipe_desc;
	private String amount_portion;
	private String cooking_time; 
	private String difficulty;
	private String image_url;
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_desc() {
		return recipe_desc;
	}
	public void setRecipe_desc(String recipe_desc) {
		this.recipe_desc = recipe_desc;
	}
	public String getAmount_portion() {
		return amount_portion;
	}
	public void setAmount_portion(String amount_portion) {
		this.amount_portion = amount_portion;
	}
	public String getCooking_time() {
		return cooking_time;
	}
	public void setCooking_time(String cooking_time) {
		this.cooking_time = cooking_time;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
	
}
