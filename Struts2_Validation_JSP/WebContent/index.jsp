<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<s:form action="login">
		<s:textfield label="Enter Name : " size="5"></s:textfield>
		<s:textfield label="Enter Age : " requiredLabel="true"></s:textfield>
		<s:submit label="Login" align="center"></s:submit>
	</s:form>
</body>
</html>