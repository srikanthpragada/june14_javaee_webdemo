package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateSalary")
public class UpdateSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<h3>");
		
		// read data from client
		String empid = request.getParameter("empid");
		
		if (empid == null)
		{
			pw.println("Employee id is missing!");
			return; 
		}
		
		String salary = request.getParameter("salary");
		
		if (salary == null)
		{
			pw.println("Salary is missing!");
			return; 
		}
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			try (Connection con =
                   DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				 PreparedStatement ps = 
						 con.prepareStatement("update employees set salary = ? where employee_id = ?"))
			{
				ps.setString(1, salary);
				ps.setString(2, empid);

				int count = ps.executeUpdate();
				if (count == 1)
					pw.println("Salary Updated!");
				else
					pw.println("Employee Id Not Found!");
			} catch (Exception ex) {
				System.out.println(ex.getMessage()); // goes to server console
				pw.println("Sorry! Something went wrong!");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage()); // goes to server console
			pw.println("Sorry! Something went wrong!");
		}
		
		pw.println("</h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
