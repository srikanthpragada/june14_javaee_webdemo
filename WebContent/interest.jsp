<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interest Calculation</title>
</head>
<body>
<h2>Interest Calculation</h2>

<form action="interest.jsp" method="post">
  Amount <br/>
  <input type="text"  name="amount" value="${param.amount}" />
  <p/>
  Rate <br/>
  <input type="text"  name="rate" value="${param.rate}" />
  <p/>
  <input type="submit" value="Calculate" />
  
</form>

<jsp:useBean id="interestBean"  scope="page" class="beans.InterestBean"></jsp:useBean>
<jsp:setProperty property="*" name="interestBean"/>
<h4>${interestBean.interest}</h4>

</body>
</html>