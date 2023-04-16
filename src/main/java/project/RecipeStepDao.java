package project;

import java.util.ArrayList;
import java.util.List;

public class RecipeStepDao extends DBConnector {
	public RecipeStepDao() {
		super();
	}
	
	public List<RecipeStepDto> detailView(String recipe_id){
		List<RecipeStepDto> list = new ArrayList<>();
		String sql="select * from recipe_step where recipe_id=? order by step_id";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, recipe_id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				RecipeStepDto dto = new RecipeStepDto();
				dto.setStep_id(rs.getString("step_id"));
				dto.setRecipe_id(rs.getString("recipe_id"));
				dto.setStep_desc(rs.getString("step_desc"));
				dto.setStep_image_url(rs.getString("step_image_url"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("조리 과정 조회중 오류 발생");
		}
		return list;
	}
}
