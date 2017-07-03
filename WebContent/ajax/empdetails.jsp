<%@ page import="java.sql.*"  contentType="text/xml"%>
<%
    // Thread.sleep(5000);
    String empid = request.getParameter("empid");
    // connect to oracle using thin driver
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(
     "select first_name, salary from employees where employee_id = " + empid);
    if (rs.next()) { // found
    	out.println(String.format("<employee><name>%s</name><salary>%s</salary></employee>",
    			 rs.getString(1), rs.getString(2)));
    } else {
        out.println("<error>Employee ID Not Found</error>");
    }

    rs.close();
    st.close();
    con.close();

%>
