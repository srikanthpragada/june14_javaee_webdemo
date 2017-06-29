<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Dept</title>
</head>
<body>

<form action="empbydept.jsp">
   Department Id : <input type="number" name="dept" value="${param.dept}" />
   <input type="submit" value="Employees" />
</form>

<c:if test="${ !empty param.dept}">
  
    <sql:setDataSource  var="oracle"  
        driver="oracle.jdbc.driver.OracleDriver"
        url="jdbc:oracle:thin:@localhost:1521:xe"
        user="hr"  password="hr"
    /> 
    
    <sql:query var="emps" dataSource="${oracle}">
          select * from employees where department_id = ?
          <sql:param value="${param.dept}"></sql:param>
    </sql:query>
    
    <ul>
    <c:forEach  items="${emps.rows}"  var="emp">
        <li> ${emp.first_name}, ${emp.salary} </li>
    </c:forEach>
    </ul>
</c:if>



</body>
</html>