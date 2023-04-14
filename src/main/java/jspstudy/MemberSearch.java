//package jspstudy;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import membership.MemberDTO;
//
//@WebServlet("./MemberSearch.do")
//public class MemberSearch extends HttpServlet{
//	PracticeDao dao = new PracticeDao();
//	@Override
//	public void init() throws ServletException {
//		dao=new PracticeDao();
//	}
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("search");
//		MemberDTO dto= dao.getMemberById(id);
//		
//		req.setAttribute("id", dto.getId());
//		req.setAttribute("pw", dto.getPw());
//		req.setAttribute("name", dto.getName());
//		req.setAttribute("regdate", dto.getRegDate());
//		
//		req.getRequestDispatcher("/ReviewStudy/ResultView.jsp").forward(req, resp);
//	}
//}
