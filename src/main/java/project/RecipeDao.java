package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao extends DBConnector {
	public RecipeDao() {
		super();
	}

	public RecipeDto detailView(String idx) {
		RecipeDto dto = new RecipeDto();
		String sql = "select * from recipe_test where recipe_id=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setRecipe_id(rs.getString("recipe_id"));
				dto.setRecipe_name(rs.getString("recipe_name"));
				dto.setRecipe_desc(rs.getString("recipe_desc"));
				dto.setAmount_portion(rs.getString("amount_portion"));
				dto.setCooking_time(rs.getString("cooking_time"));
				dto.setDifficulty(rs.getString("difficulty"));
				dto.setImage_url(rs.getString("image_url"));
			}
		} catch (Exception e) {
			System.out.println("상세보기 불러오기 중 DB 오류");
			e.printStackTrace();
		}
		return dto;
	}

	public List<String> suggestionKeyword(String recipe_name) {
		String sql = "select recipe_name from recipe_test where recipe_name like concat('%" + recipe_name + "%')";
		List<String> list = new ArrayList<>();
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		return list;
	}
}
