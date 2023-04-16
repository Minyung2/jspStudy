package project;

import java.util.ArrayList;
import java.util.List;

public class RecipeCommentDao extends DBConnector {
	public RecipeCommentDao() {
		super();
	}

	public int getRatingCount(String recipe_id) {
		int count=0;
		String sql= "select count(*) from recipe_comment where recipe_id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, recipe_id);
			rs = psmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 댓글 Count 조회 중 DB 오류");
			e.printStackTrace();
		}
		return count;
	}
	
	public List<RecipeCommentDto> detailView(String recipe_id) {
		List<RecipeCommentDto> list = new ArrayList<>();
		String sql="select rc.*,u.user_nickname  from recipe_comment rc,users u  where u.user_idx =rc.user_idx and recipe_id=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, recipe_id);
			rs=psmt.executeQuery();
			while(rs.next()) {
				RecipeCommentDto dto = new RecipeCommentDto();
				dto.setComment_id(rs.getString("comment_id"));
				dto.setRecipe_id(rs.getString("recipe_id"));
				dto.setUser_idx(rs.getString("user_idx"));
				dto.setComment_content(rs.getString("comment_content"));
				dto.setComment_date(rs.getDate("comment_date"));
				dto.setUser_nickname(rs.getString("user_nickname"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 댓글 리스트 조회중 DB 에러");
			e.printStackTrace();
		}
		return list;
	}

}
