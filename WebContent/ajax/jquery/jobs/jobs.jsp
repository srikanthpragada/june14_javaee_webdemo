<%@page import="javax.json.*" contentType="application/json"%>
<%
    javax.sql.rowset.CachedRowSet rs =
            new oracle.jdbc.rowset.OracleCachedRowSet();
    rs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    rs.setUsername("hr");
    rs.setPassword("hr");
    rs.setCommand("select * from jobs");
    rs.execute();

    JsonArrayBuilder jobs = Json.createArrayBuilder();
    while (rs.next()) {
        JsonObjectBuilder job =
                Json.createObjectBuilder();
        job.add("id", rs.getString("job_id"));
        job.add("title", rs.getString("job_title"));
        jobs.add(job.build());
    }


    rs.close();
    out.println(jobs.build().toString());
%>
