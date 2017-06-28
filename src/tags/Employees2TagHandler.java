package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Employees2TagHandler extends SimpleTagSupport {
    private int dept;
    
    // attribute dept 
    public void setDept(int dept) {
    	this.dept = dept;
    }
	@Override
	public void doTag() throws JspException, IOException {
	    JspWriter out = getJspContext().getOut();
	 
	    try (CachedRowSet crs = new OracleCachedRowSet())
		{
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select first_name, salary from employees where department_id =?");
			crs.setInt(1, dept);
			crs.execute();
			
			out.println("<table border='1' cellpadding='5'><tr><th>Name</th><th>Salary </th></tr>");
			while(crs.next()) 
			{
				out.println("<tr><td>" + crs.getString("first_name")
				       + "</td><td>" + crs.getString("salary") + "</td></tr>");
			}
			out.println("</table>");
		}
	    catch(Exception ex) {
	    	System.out.println(ex);
	    }
	}
	
	 

}
