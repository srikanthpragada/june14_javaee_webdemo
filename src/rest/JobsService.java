package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import com.google.gson.Gson;
import oracle.jdbc.rowset.OracleCachedRowSet;

@Path("/jobs")
public class JobsService {

	@GET
	@Path("{id}")
	public String getOneJob(@PathParam("id") String id) {
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where job_id = ?");
			crs.setString(1, id);
			crs.execute();
			if (crs.next()) {
				Job j = new Job();
				j.setId(crs.getString("JOB_ID"));
				j.setTitle(crs.getString("JOB_TITLE"));
				Gson gson = new Gson();
				return gson.toJson(j);
			} else
				throw new NotFoundException();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			throw new javax.ws.rs.InternalServerErrorException();
		}
	}

	@GET
	public String getJobs() {
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (crs.next()) {
				Job j = new Job();
				j.setId(crs.getString("JOB_ID"));
				j.setTitle(crs.getString("JOB_TITLE"));
				jobs.add(j);
			}

			crs.close();
			Gson gson = new Gson();
			return gson.toJson(jobs);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@DELETE
	@Path("{id}")
	public void deleteJob(@PathParam("id") String id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

				PreparedStatement ps = con.prepareStatement("delete from jobs where job_id = ?");
				ps.setString(1, id);
				int count = ps.executeUpdate();
				if (count == 0)
					throw new NotFoundException();
			}
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			throw new InternalServerErrorException();
		}
	}
	
	@PUT
	@Path("{id}")
	public void updateJob(@PathParam("id") String id,
			  @FormParam("title") String title) {
		System.out.println(title);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
				PreparedStatement ps = con.prepareStatement("update jobs set job_title = ? where job_id = ?");
				ps.setString(1, title);
				ps.setString(2, id);
				int count = ps.executeUpdate();
				if (count == 0)
					throw new NotFoundException();
			}
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			throw new InternalServerErrorException();
		}
	}



}
