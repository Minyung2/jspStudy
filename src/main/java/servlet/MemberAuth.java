package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;


@WebServlet(urlPatterns="/13Servlet/MemberAuth.mvc", initParams = {@WebInitParam(name = "manager", value = "ADMIN")})
public class MemberAuth extends HttpServlet {
	MemberDAO dao;

	@Override
	public void init() throws ServletException {
		// application 내장 객체
		ServletContext application = this.getServletContext();
		String driver = application.getInitParameter("OracleDriver");
		String url = application.getInitParameter("OracleUrl");
		String id = application.getInitParameter("OracleId");
		String pw = application.getInitParameter("OraclePw");

		// db와 연결
		dao = new MemberDAO(driver, url, id, pw);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 인증에 필요한 값
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String manager= this.getInitParameter("manager");
		// 필요한 동작 처리
		MemberDTO dto = dao.getMember(id, pass);
		// 결과값 처리
		String memberName = dto.getName();
		if(memberName!=null) {
			if(memberName.equals("시발롬")) {
				req.setAttribute("authMsg", "오지 말라고 시발롬아");
			}else if(manager.equals(id)) {
				req.setAttribute("authMsg", memberName+"꼴에 관리자노");
			}else {
				req.setAttribute("authMsg", memberName+"회원님 반갑다.");
				}
		}else {
			req.setAttribute("authMsg", "회원이 아님다");
		}
		// 결과에 따른 이동
		req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		dao.close();
	}
}
