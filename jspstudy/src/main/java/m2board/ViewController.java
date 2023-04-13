package m2board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/m2board/view.do")
public class ViewController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MBoardDAO dao = new MBoardDAO();
		String idx = req.getParameter("idx");
		String pageNum = req.getParameter("pageNum");
		dao.updateVisitCount(idx);
		MBoardDTO dto = dao.getView(idx);
		dao.close();
		
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		req.setAttribute("dto", dto);
		req.setAttribute("pageNum", pageNum);
		req.getRequestDispatcher("/14M2Board/View.jsp").forward(req, resp);	
	}
	
}
