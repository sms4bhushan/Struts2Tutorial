<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload Log File</h1>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<s:actionerror />
	<s:form action="upload" method="post" enctype="multipart/form-data">
		<s:file name="myLog" label="User Image" />
		<s:submit value="Upload" align="center" />
	</s:form>
</body>
</html>