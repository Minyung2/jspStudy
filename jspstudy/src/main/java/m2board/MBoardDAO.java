package m2board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import board.BoardDTO;
import common.JDBConnPool;

public class MBoardDAO extends JDBConnPool {
	public MBoardDAO() {
		super();
	}

	public int countAll(Map<String, Object> map) {
		int totalCount = 0;
		String sql = "SELECT count(*) FROM FILEBOARD";
		if (map.get("searchType") != null) {
			sql += " where " + map.get("searchType") + " like '%" + map.get("searchStr") + "%'";
		}
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 카운트 중 에러");
			e.printStackTrace();
		}

		return totalCount;
	}

	public List<MBoardDTO> getListPage(Map<String, Object> map) {
		List<MBoardDTO> bl = new ArrayList<>();
		String sql = "SELECT * from(SELECT rownum pnum, s.* from(SELECT b.* FROM fileboard b";
		if (map.get("searchStr") != null) {
			sql += " where " + map.get("searchType") + " like '%" + map.get("searchStr") + "%'";
		}
		sql += " ORDER BY idx desc) s) WHERE pnum BETWEEN ? AND ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				MBoardDTO dto = new MBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setPass(rs.getString("pass"));
				bl.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	public MBoardDTO getView(String idx) {
		MBoardDTO dto = new MBoardDTO();

		String sql = "SELECT * FROM fileboard b WHERE idx=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setIdx(rs.getString("idx"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setPass(rs.getString("pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void updateVisitCount(String idx) {
		String query = "UPDATE fileboard SET VISITCOUNT = VISITCOUNT +1 WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("조회수 증가 중 오류 발생");
			e.printStackTrace();
		}
	}

	public void updateDowncount(String idx) {
		String query = "UPDATE fileboard SET downcount = downcount +1 WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("다운로드 수 증가 중 오류 발생");
			e.printStackTrace();
		}
	}

	public int insertWrite(MBoardDTO dto) {
		int result = 0;
		String query = "INSERT INTO fileboard(idx,name,title,CONTENT,OFILE,NFILE,PASS) values(seq_board_num.nextval,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getNfile());
			psmt.setString(6, dto.getPass());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 입력 중 에러");
			e.printStackTrace();
		}
		return result;
	}

}
