package project;

public class RecipeIngredientDto {
	private String recipe_id;
	private String ingredient_id;
	private String ingredient_type;
	private String amount;
	private String ingredient_name;
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	public String getIngredient_type() {
		return ingredient_type;
	}
	public void setIngredient_type(String ingredient_type) {
		this.ingredient_type = ingredient_type;
	}

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
