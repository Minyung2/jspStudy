package project;

import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientDao extends DBConnector {
	public RecipeIngredientDao() {
		super();
	}
	
	public List<RecipeIngredientDto> detailView(String id) {
		String sql = "select ri.*, i.ingredient_name from recipe_ingredient ri, ingredient i where ri.ingredient_id = i.ingredient_id and recipe_id=?";
		List<RecipeIngredientDto> list= new ArrayList<>();
		try {
			psmt= con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				RecipeIngredientDto dto = new RecipeIngredientDto();
				dto.setRecipe_id(rs.getString("recipe_id"));
				dto.setIngredient_id(rs.getString("ingredient_id"));
				dto.setIngredient_type(rs.getString("ingredient_type"));
				dto.setAmount(rs.getString("amount"));
				dto.setIngredient_name(rs.getString("ingredient_name"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("재료 검색 중 DB 에러");
			e.printStackTrace();
		}
		return list;
	}
	
	public String getIngredientId(String ingredient_name) {
		String result="";
		String sql = "select i.ingredient_id  from recipe_ingredient ri ,ingredient i where i.ingredient_id = ri.ingredient_id and i.ingredient_name = ?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, ingredient_name);
			rs=psmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("ingredient_id");
			}
		} catch (Exception e) {
			System.out.println("Ingredient_Id DB 검색 실패");
			e.printStackTrace();
		}
		return result;
	}
	
	public void insertIngredient(RecipeIngredientDto dto) {
		String sql = "insert into recipe_ingredient(recipe_id,ingredient_id,amount) values(?,?,?)";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, dto.getRecipe_id());
			psmt.setString(2, dto.getIngredient_id());
			psmt.setString(3, dto.getAmount());
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("재료 DB 입력중 에러");
			e.printStackTrace();
		}
	}
}
