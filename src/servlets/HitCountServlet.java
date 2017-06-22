package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class HitCountServlet extends HttpServlet {
	int count = 0;
	String title;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.println("<h3>Count : " + count + "</h3>");
        pw.println("<hr>" + title);
	}
	
	@Override 
	public void init(ServletConfig config) {
		title = config.getInitParameter("title");
	}

}
