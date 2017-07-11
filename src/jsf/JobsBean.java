package jsf;

import javax.faces.bean.ManagedBean;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean 
public class JobsBean {

	public RowSet  getJobs() {
		try (CachedRowSet crs = new OracleCachedRowSet())
		{
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			return crs;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
