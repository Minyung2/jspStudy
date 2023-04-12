package jspstudy;

import java.sql.SQLException;

import common.JDBConnPool;
import membership.MemberDTO;

public class PracticeDao extends JDBConnPool {

	public MemberDTO getMemberById(String id) {
		MemberDTO dto = new MemberDTO();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setId(rs.getString("pw"));
				dto.setId(rs.getString("name"));
				dto.setId(rs.getString("regDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}
