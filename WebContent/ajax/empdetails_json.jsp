<%@ page import="java.sql.*, javax.json.*"  contentType="application/json"%>
<%
    String empid = request.getParameter("empid");
    // connect to oracle using thin driver
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select first_name, salary from employees where employee_id = " + empid);
    JsonObjectBuilder builder = Json.createObjectBuilder();
    if (rs.next()) { // found
        builder.add("name", rs.getString("first_name"));
        builder.add("salary", rs.getInt("salary"));
    } else {
        builder.add("error", "Employee Not Found");
    }
    out.println(builder.build().toString());
    rs.close();
    st.close();
    con.close();

%>



