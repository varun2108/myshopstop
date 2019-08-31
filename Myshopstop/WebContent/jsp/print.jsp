<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="st" class="com.quinnox.basics.model.EmployeeBeen"/>
	<jsp:setProperty property="*" name="st"/>
	
	Employe ID: <h1><jsp:getProperty property="empno" name="st"/></h1>
	Employe Name: <h1><jsp:getProperty property="empname" name="st"/></h1>
	Employe Designation: <h1><jsp:getProperty property="desig" name="st"/></h1>
	
	<jsp:getProperty property="*" name="st"/>
	</body>
</html>