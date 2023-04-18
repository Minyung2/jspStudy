package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project/recipeview.do")
public class RecipeViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String recipe_id = req.getParameter("recipe_id");
		RecipeDao recipeDao = new RecipeDao();
		RecipeIngredientDao recipeIngredientDao = new RecipeIngredientDao();
		RecipeStepDao stepDao = new RecipeStepDao();
		RecipeRatingDao ratingDao = new RecipeRatingDao();
		RecipeCommentDao commentDao = new RecipeCommentDao();
		
		
		RecipeDto recipeDto = recipeDao.detailView(recipe_id);
		List<RecipeIngredientDto> ingreList = recipeIngredientDao.detailView(recipe_id); 
		List<RecipeStepDto> stepList = stepDao.detailView(recipe_id);
		List<RecipeRatingDto> ratingList = ratingDao.detailView(recipe_id);
		int ratingCount = ratingDao.getRatingCount(recipe_id);
		List<RecipeCommentDto> commentList = commentDao.detailView(recipe_id);
		int commentCount = commentDao.getCommentCount(recipe_id);
		
		req.setAttribute("recipeDto", recipeDto);
		req.setAttribute("ingreList", ingreList);
		req.setAttribute("stepList", stepList);
		req.setAttribute("ratingList", ratingList);
		req.setAttribute("ratingCount", ratingCount);
		req.setAttribute("commentList", commentList);
		req.setAttribute("commentCount", commentCount);
		
		req.getRequestDispatcher("../RecipeProject/RecipeView.jsp").forward(req, resp);
	}
}
