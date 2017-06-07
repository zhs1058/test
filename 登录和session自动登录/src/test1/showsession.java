package test1;

import java.io.IOException;




import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServlrtException;
//import javax.servlet.annotation;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpservletResponse;

@WebServlet("/showsession")
public class showsession extends HttpServlet{
	private static final long serialVersionUID=1L;
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response)
					throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String heading = null;
		Integer accessCount =0;
	    accessCount = (Integer)session.getAttribute("accessCount");
		if(accessCount==null){
			accessCount=new Integer(1);
			heading="欢迎你，首次登录该页面!";
		}
		else{
			accessCount=accessCount+1;
			heading ="欢迎你，再次访问该页面！";
		}
		session.setAttribute("accessCount", accessCount);
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>登录状态</title></head>");
		out.println("<body><center>");
		out.println("<h4>"+heading+"</h4>");
		out.println("<table border='0'>");
		out.println("<tr><td>账户：</td><td>"+request.getParameter("account").trim() +"</td>");
		out.println("<tr><td>密码：</td><td>"+request.getParameter("password").trim() +"</td>");
		out.println("<tr><td>已经被访问的次数：</td><td>"+accessCount+"</td>");
		out.println("</table>");
		out.println("</center></body></html>");
	}
}

