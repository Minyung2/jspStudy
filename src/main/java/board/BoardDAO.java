package board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {
	public BoardDAO(ServletContext application) {
		super(application);
	}
	// getlist,find(select *) , insert,

	public int getTotalCount(Map<String, Object> param) {
		int totalCount = 0;
		String sql = "select count(*) from board";
		if (param.get("findWord") != null) {
			sql += " where " + param.get("findCol") + " like '%" + param.get("findWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 카운트 중 에러");
			e.printStackTrace();
		}

		return totalCount;
	}
	
	// 페이지별 게시물 내용 읽기
	public List<BoardDTO> getList(Map<String, Object> param) {
		List<BoardDTO> bl = new ArrayList<>();
		String sql = "SELECT * from(SELECT rownum pnum, s.* from(SELECT b.* FROM board b";
		if (param.get("findWord") != null) {
			sql += " where " + param.get("findCol") + " like '%" + param.get("findWord") + "%'";
		}
		sql+=" ORDER BY num desc) s) WHERE pnum BETWEEN ? AND ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, param.get("start").toString());
			psmt.setString(2, param.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setPosdate(rs.getDate("posdate"));
				dto.setVisitcount(rs.getString("visitcount"));
				bl.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bl;
	}
	
	
	/*
	 * public List<BoardDTO> getList(Map<String, Object> param) { List<BoardDTO> bl
	 * = new ArrayList<>(); String sql = "select * from board"; if
	 * (param.get("findWord") != null) { sql += " where " + param.get("findCol") +
	 * " like '%" + param.get("findWord") + "%'"; } sql += " order by num desc"; try
	 * { stmt = con.createStatement(); rs = stmt.executeQuery(sql); while
	 * (rs.next()) { BoardDTO dto = new BoardDTO(); dto.setNum(rs.getString("num"));
	 * dto.setTitle(rs.getString("title")); dto.setContent(rs.getString("content"));
	 * dto.setId(rs.getString("id")); dto.setPosdate(rs.getDate("posdate"));
	 * dto.setVisitcount(rs.getString("visitcount")); bl.add(dto); } } catch
	 * (SQLException e) { e.printStackTrace(); }
	 * 
	 * return bl; }
	 */

	// 게시물 작성
	public int insertWrite(BoardDTO dto) {
		int res = 0;
		try {
			String sql = "INSERT INTO BOARD(NUM,TITLE,CONTENT,ID,VISITCOUNT) "
					+ "VALUES(SEQ_BOARD_NUM.NEXTVAL,?,?,?,0)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			res = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 입력 중 에러");
			e.printStackTrace();
		}
		return res;
	}

	public BoardDTO getView(String num) {
		BoardDTO dto = new BoardDTO();

		String sql = "SELECT b.*,m.NAME  FROM board b, MEMBER m WHERE num=? AND b.id=m.ID";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1,num);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setPosdate(rs.getDate("posdate"));
				dto.setVisitcount(rs.getString("visitcount"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void updateVisitCount(String num) {
		String sql = "UPDATE board SET VISITCOUNT = VISITCOUNT +1 WHERE num=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, num);
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 에러");
			e.printStackTrace();
		}
	}
	
	//삭제
	public int deletePost(String num) {
		int res=0;
		String sql="DELETE FROM BOARD WHERE NUM=?";
		try {
			psmt=con.prepareStatement(sql);
			psmt.setString(1, num);
			res=psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		}
		return res;
	}
	public int updateEdit(BoardDTO dto) {
		int res=0;
		String sql="UPDATE BOARD SET TITLE=?, CONTENT=? WHERE NUM=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			res=psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시판 글 DB 수정 실패");
			e.printStackTrace();
		}
		return res;	
	}
}	
