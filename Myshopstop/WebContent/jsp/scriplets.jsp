<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriplets</title>
</head>
<body bgcolor="#fff">
<h1>Welcome to Shop Stop</h1>
<% 
	String firstname=request.getParameter("txtfirstname");
	String lastname=request.getParameter("txtlastname");
	out.println(firstname+" "+lastname);
%>

</body>
</html>