package utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class AlertFunc {
	public static void alertLocation(String msg, String url, JspWriter out) {
		String script = "<script>\r\n"
				+ "		alert('"+msg+"');\r\n"
				+ "		location.href='"+url+"';\r\n"
				+ "	</script>\r\n";
		try {
			out.println(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void alertBack(String msg, JspWriter out) {
		String script = "<script>\r\n"
				+ "		alert('"+msg+"');\r\n"
				+ "		history.back();\r\n"
				+ "	</script>";
		try {
			out.println(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public static void alertLocation(HttpServletResponse resp, String msg, String
	 * url) { try { PrintWriter String script = "<script>\r\n" +
	 * "		alert('"+msg+"');\r\n" + "		location.href='"+url+"';\r\n" +
	 * "	</script>\r\n";
	 * 
	 * out.println(script); } catch (IOException e) { e.printStackTrace(); } }
	 */
	
}	
