package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Employees3TagHandler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();

		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select first_name, salary from employees");
			crs.execute();

			while (crs.next()) {
				// process body 
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
