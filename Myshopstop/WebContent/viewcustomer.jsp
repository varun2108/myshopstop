<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.quinnox.basics.DAO.*, com.quinnox.basics.model.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style1.css">
<title>Insert title here</title>
</head>


<body style="color:white">
<% if(session!=null){
	if(session.getAttribute("user")!=null){
	String name=(String)session.getAttribute("user");
	%>
	
	<%
		int timeout = 10;
		session.setMaxInactiveInterval(timeout);
		response.setHeader("Refresh",timeout+"; URL=timeout.jsp");
	%>
<nav>
  <ul>
    <li>
        <a href="#">Home</a>
    </li>
    <li>
        <a href="#">Products</a>
    </li>
    <li>
        <a href="#">Payment</a>
    </li>
    <li>
        <a href="#">Contact Us</a>
    </li>
    <li>
        <a href="LogoutServlet">Logout</a>
    </li>
  </ul>
</nav>
<div style="background-color:red;color:white;padding:5px;fontsize:75%;font-family:verdana;text-align:center;width:50%;margin-left:200px;">
	Welcome <%= name.toUpperCase() %>
	</div>

<h1>Customer list</h1>


	
<div align="center"><img src="images/globe.gif" width="10%" height="10%"></div>
<br><br><br>
<% List<Customer> list=CustomerDAO.getAllEmployees(); %>
<div class="test">
<table>
<tr>
<td>ID</td>
<td>NAMe</td>
<td>Password</td>
<td>Email</td>
<td>Country</td>
<td>EDIT</td>
<td>Delete</td>
</tr>
<% for(Customer i:list){
	System.out.println(i.getId());%>
<TR>
	<td><%=i.getId() %></td>
	<td><%=i.getName()%></td>
	<td><%=i.getPassword()%></td>
	<td><%=i.getEmail()%></td>
	<td><%=i.getCountry()%></td>
	<td><a href='editcustomer.jsp?id=<%=i.getId() %>'>Edit</a></td>
	<td><a href='DeleteServlet?id=<%=i.getId() %>'>Delete</a></td>
	<%} %>
</TR>
</table>

</div>
<%}else{response.sendRedirect("login.html");}}else{response.sendRedirect("LogoutServlet");} %>
</body>
</html>