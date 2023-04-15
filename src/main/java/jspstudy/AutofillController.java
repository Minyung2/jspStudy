package jspstudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

@WebServlet("/jspstudy/autoSearch.do")
public class AutofillController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		  RecipeDao dao = new RecipeDao();
		  List<String> list = dao.suggestionKeyword(name);
		  JsonObject jsonObject = new JsonObject();
		  jsonObject.addProperty("name", name);
		  JsonArray jsonArray = new JsonArray();
		  for (String s : list) {
		    jsonArray.add(new JsonPrimitive(s));
		    System.out.println(s);
		  }
		  jsonObject.add("suggestions", jsonArray);
		  resp.setContentType("application/json;charset=utf-8");
		  resp.getWriter().write(jsonObject.toString());
		}
}
