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
}
