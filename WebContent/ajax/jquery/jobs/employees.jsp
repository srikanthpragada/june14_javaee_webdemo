<%@page import="javax.json.*" contentType="application/json"%>
<%
    // Thread.sleep(5000);
	javax.sql.rowset.CachedRowSet rs = new oracle.jdbc.rowset.OracleCachedRowSet();
	rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	rs.setUsername("hr");
	rs.setPassword("hr");
	rs.setCommand("select first_name || ' ' || last_name fullname from employees where job_id = ?");
	rs.setString(1, request.getParameter("jobid"));
	rs.execute();

	JsonArrayBuilder emps = Json.createArrayBuilder();
	while (rs.next()) {
		JsonObjectBuilder emp = Json.createObjectBuilder();
		emp.add("fullname", rs.getString("fullname"));
		emps.add(emp.build());
	}

	rs.close();
	out.println(emps.build().toString());
%>
