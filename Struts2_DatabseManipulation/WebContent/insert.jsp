<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="s" uri="/struts-tags" %>
	<s:form action="insertActionUrl" method="post">
		<s:textfield key="Username : " name="employee.username"></s:textfield>
		<s:textfield key="Password : " name="employee.password"></s:textfield>
		<s:radio key="Type" list="{'Admin','User'}" name="employee.userType"></s:radio>
		<s:submit value="Register Me"></s:submit>
	</s:form>
</body>
</html>