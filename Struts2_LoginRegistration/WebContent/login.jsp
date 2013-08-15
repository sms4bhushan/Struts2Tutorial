<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login page</h1>
	<%@ taglib prefix="s" uri="/struts-tags" %>
	<s:form action="LoginActionUrl" method="post">
		<s:textfield key="Username : " name="username"></s:textfield>
		<s:textfield key="Password : " name="password"></s:textfield>
		<s:radio key="Type" list="{'Admin','User'}" name="userType"></s:radio>
		<s:submit value="Register Me"></s:submit>
	</s:form>
</body>
</html>