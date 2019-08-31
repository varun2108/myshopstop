<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp forword exaple</title>
</head>
<body>
<jsp:forward page="dispaly.jsp"><jsp:param value="Raj" name="name"/>
<jsp:param value="quinnox" name="company"/>
<jsp:param value="jsp" name="technology"/>
<jsp:param value="fwddemo.jsp" name="requestform"/>
</jsp:forward>

</body>
</html>