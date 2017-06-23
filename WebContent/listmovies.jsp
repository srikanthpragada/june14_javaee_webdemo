<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Movies</title>
</head>
<body>
	<%
		String city = null;
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("city")) {
					city = c.getValue();
					break;
				}
			}
		}

		if (city == null)
			response.sendRedirect("selectcity.html");
	%>

	<h2>
		List of Movies in [<%=city%>]
	</h2>

</body>
</html>