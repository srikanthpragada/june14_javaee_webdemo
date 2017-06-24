<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="names2.jsp">
		Name : <input type="text" name="name" /> <input type="submit"
			value="Add" />
	</form>
	
	${applicationScope.names}  

	<ul>
		<%
   		    String name = request.getParameter("name");
 		    if(name == null)
			   return;  // return from JSP
		   
			// add name to list
			ArrayList<String> namesList = (ArrayList<String>) application.getAttribute("names");
			if (namesList == null) {
				namesList = new ArrayList<String>();
				application.setAttribute("names", namesList);
			}

			namesList.add(name);

			for (String n : namesList) {
				out.println("<li>" + n + "</li>");
			}
		%>
	</ul>
	
	

</body>
</html>