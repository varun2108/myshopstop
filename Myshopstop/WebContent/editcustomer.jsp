<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.quinnox.basics.DAO.*,com.quinnox.basics.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String sid=request.getParameter("id");
long id=Long.parseLong(sid);
Customer c=CustomerDAO.getCustomerById(id);
%>
<h3>enter the new details</h3>
<form action="EditServ">
	<input type="hidden" name="id" value=<%=id%>>
	      <label for="name"><b>name</b></label>
      <input type="text" placeholder="Enter name" name="name" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>

      <label for="email"><b>Email</b></label>
      <input type="email" placeholder="Enter Email" name="email" required>

      
      <label for="country"><b>Country</b></label>
     	<select name="country" style="width:150px;">
     	<option>India</option>
     	<option>USA</option>
     	<option>UK</option>
     	<option>Others</option>
     	</select>
      <label>
    


        <button type="submit" class="signupbtn">Sign Up</button>
 
</form>
</body>
</html>