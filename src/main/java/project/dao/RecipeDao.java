package project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.DBConnector;
import project.dto.RecipeDto;

public class RecipeDao extends DBConnector {
	public RecipeDao() {
		super();
	}
	
	public RecipeDto detailView(String idx) {
		RecipeDto dto = new RecipeDto();
		String sql = "select * from recipe_test";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			dto.setRecipe_id(rs.getString(1));
			dto.setRecipe_name(rs.getString(2));
			dto.setRecipe_desc(rs.getString(3));
			dto.setAmount_portion(rs.getString(4));
			dto.setCooking_time(rs.getString(5));
			dto.setDifficulty(rs.getString(6));
			dto.setImage_url(rs.getString(7));
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
