package jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

@ManagedBean
public class JobsBean {
	private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		System.out.println(job);
		this.job = job;
	}
	
	public List<SelectItem> getJobsOptions() {
		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			
			ArrayList<SelectItem> jobs = new ArrayList<>();
			while (crs.next()) {
				 SelectItem item = new SelectItem
						   (crs.getString("job_id"),
						   crs.getString("job_title"));
				 jobs.add(item);
			}
			crs.close();
			return jobs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public RowSet getJobs() {
		try {
			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			return crs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public List<Job> getAllJobs() {
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (crs.next()) {
				Job j = new Job();
				j.setId(crs.getString("job_id"));
				j.setTitle(crs.getString("job_title"));
				j.setMinSal(crs.getInt("min_salary"));
				j.setMaxSal(crs.getInt("max_salary"));
				jobs.add(j);
			}
			return jobs;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
