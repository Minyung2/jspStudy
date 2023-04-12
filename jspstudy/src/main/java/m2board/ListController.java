package m2board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.PagingUtil;

@WebServlet("/m2board/list.do")
public class ListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// dao 생성 (JDBConn 기본 생성)
		MBoardDAO dao = new MBoardDAO();
		// 변수 저장할 Map 생성
		Map<String, Object> map = new HashMap<>();
		// 검색
		String searchType=req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");
		if(searchStr!=null) {
			map.put("searchType", searchType);
			map.put("searchStr", searchStr);
		}
		// 전체 게시물 개수 확인
		int totalCount = dao.countAll(map);
		
		ServletContext application = getServletContext();
		int pageSize=Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
		int pageBlock=Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
		int pageNum = 1;
		// 페이지 확인
		String pageTemp = req.getParameter("pageNum");
		if(pageTemp!=null && !pageTemp.equals("")) {
			pageNum=Integer.parseInt(pageTemp);
		}
		// 목록에서 보여줄 게시물 범위 계산
		int start=(pageNum-1)*pageSize+1;
		int end = pageNum*pageSize;
		map.put("start",start);
		map.put("end",end);
		
		// DB에서 게시물 정보 읽기
		List<MBoardDTO> boardList = dao.getListPage(map);
		dao.close();
		
		// view에 값을 전달해 줄 것을 정리
		String pagingStr=PagingUtil.pagingCenter(totalCount, pageSize, pageBlock,pageNum,"../m2board/list.do");
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		// view에 값을 전달해 줄 것을 정리
		req.setAttribute("boardList", boardList);
        req.setAttribute("map", map);
        req.getRequestDispatcher("../14M2Board/List.jsp").forward(req, resp);
        
	}
}
