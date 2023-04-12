package fileUpDown;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBConnPool;

public class MyFileDao extends JDBConnPool{
	public int insertFile(MyFileDto dto) {
		int applyResult = 0;
		try {
			String sql = "INSERT INTO MYFILE(IDX,NAME,TITLE,CATE,OFILE,NFILE) VALUES(SEQ_BOARD_NUM.NEXTVAL,?,?,?,?,?)";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getNfile());
			
			applyResult = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DB에 파일 정보 등록 실패");
			e.printStackTrace();
		}
		return applyResult;
	}
	
	public List<MyFileDto> myFileList(){
		List<MyFileDto> fileList = new ArrayList<>();
		String sql = "SELECT * FROM MYFILE ORDER BY IDX DESC";
		try {
			psmt=con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MyFileDto dto = new MyFileDto();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setNfile(rs.getString(6));
				dto.setRegdate(rs.getString(7));
				fileList.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("데이터 조회 중 오류 발생");
			e.printStackTrace();
		}
		return fileList;
	}
}
