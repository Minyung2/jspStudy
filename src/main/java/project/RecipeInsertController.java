package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project/recipeWrite.do")
public class RecipeInsertController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_idx="1";
		String recipe_name=req.getParameter("recipe_name");
		String recipe_desc=req.getParameter("recipe_desc");
		String recipe_amount_portion=req.getParameter("recipe_amount");
		String recipe_cooking_time=req.getParameter("recipe_cooking_time");
		String recipe_difficulty=req.getParameter("recipe_difficulty");
		String recipe_image_url="test";
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setUser_idx(user_idx);
		recipeDto.setRecipe_name(recipe_name);
		recipeDto.setRecipe_desc(recipe_desc);
		recipeDto.setAmount_portion(recipe_amount_portion);
		recipeDto.setCooking_time(recipe_cooking_time);
		recipeDto.setImage_url(recipe_image_url);
		recipeDto.setDifficulty(recipe_difficulty);
		RecipeDao recipeDao = new RecipeDao();
		recipeDao.insertRecipe(recipeDto);
		
		String recipe_id=recipeDao.getLastRecipeId();
		String[] ingredient_name=req.getParameterValues("ingredient_name[]");
		String[] ingredient_amount=req.getParameterValues("ingredient_amount[]");
		RecipeIngredientDto ingredientDto= new RecipeIngredientDto();
		ingredientDto.setRecipe_id(recipe_id);
		RecipeIngredientDao ingredientDao = new RecipeIngredientDao();

		for(int i =0 ; i < ingredient_name.length ; i++) {
			if(ingredient_name[i].trim()!="" || ingredient_amount[i].trim()!="") {
				ingredientDto.setIngredient_id(ingredientDao.getIngredientId(ingredient_name[i]));
				ingredientDto.setAmount(ingredient_amount[i]);
				ingredientDao.insertIngredient(ingredientDto);
			}
		}

	}
	
}
