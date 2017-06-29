package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Employees3TagHandler extends SimpleTagSupport {
    private int minSalary;
    
    public void setMinSalary(int minSalary) {
    	this.minSalary = minSalary;
    }
    
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		JspFragment body = this.getJspBody();
		PageContext  ctx = (PageContext) this.getJspContext();

		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select employee_id, first_name || ' ' || last_name name, salary from employees where salary >= ?");
            crs.setInt(1, minSalary);			
			crs.execute();

			while (crs.next()) {
				 ctx.setAttribute("id",  crs.getInt("employee_id"));
				 ctx.setAttribute("name",  crs.getString("name"));
		         ctx.setAttribute("salary",  crs.getInt("salary"));
		         body.invoke(out);  // process body and send result to client 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
