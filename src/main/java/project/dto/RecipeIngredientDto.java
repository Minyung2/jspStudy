package project.dto;

public class RecipeIngredientDto {
	private String recipe_id;
	private String ingredient_id;
	private String amount;
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(String ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
