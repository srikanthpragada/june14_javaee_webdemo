<%@page  contentType="text/plain"%>
<%
   //Thread.sleep(5000);
   int n1, n2;
   n1 = Integer.parseInt( request.getParameter("num1"));
   n2 = Integer.parseInt( request.getParameter("num2"));
   out.println(n1 + n2);
%>
