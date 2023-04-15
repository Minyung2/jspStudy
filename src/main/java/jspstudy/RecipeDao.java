package jspstudy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao extends DBConnector {
	public RecipeDao() {
		super();
	}

	public List<String> suggestionKeyword(String name) {
		String sql = "select name from recipe where name like concat('%" + name + "%')";
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
