<%@page import="com.qspider.springmvc.DTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
StudentDTO student = (StudentDTO) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
form {
	margin-top: 10px;
}
form table {
	margin: auto;
	width: 100%;
}
tr {
	text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}
fieldset {
	margin: 15px 520px;
	text-align: center;
}
legend {
	color: white;
	background-color: #333;
}
body {
	background-image:
		url('https://mcdn.wallpapersafari.com/medium/24/6/EOryRH.jpg');
	background-size: 100%;
}
</style>
</head>
<body>
	<%
	if (student != null) {
	%>
	<h1>
		Welcome
		<%=student.getName()%></h1>
	<%
	}
	%>

</body>
</html>