import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache=Control","no-cache");
		
		String username=request.getParameter("username");
		String message="用户名可以使用";
		PrintWriter out=response.getWriter();
		if(username.equals("zhang")){
			message="用户名不可以使用";
		}
		out.println("<respinse>");
		out.println("<message>"+message+"</message>");
		out.println("</respinse>");
		
	}

	

}
