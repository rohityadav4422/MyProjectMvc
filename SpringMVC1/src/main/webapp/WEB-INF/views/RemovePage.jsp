<%@page import="com.qspider.springmvc.DTO.StudentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<StudentDTO> students = (List<StudentDTO>) request.getAttribute("students");
%>
<%!int i;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Student</title>
<style type="text/css">
form {
	margin-top: 10px;
}
form table {
	margin: auto;
	width: auto;
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
	width: 300px;
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
	<fieldset>
		<legend>:::Remove Student:::</legend>
		<form method="post" action="./removeStudent"  >
			<table>
				<tr>
					<td><label>Enter Student ID</label></td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Remove"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	
	<%
	if (students != null) {
	%>
	<table style="width: 100%;">
		<tr>
			<td><h3>ID</h3></td>
			<td><h3>Name</h3></td>
			<td><h3>Email</h3></td>
		</tr>
		<%
		for (i = 0; i < students.size(); i++) {
		%>
		<tr>
			<td><%=students.get(i).getId()%></td>
			<td><%=students.get(i).getName()%></td>
			<td><%=students.get(i).getEmail()%></td>
		</tr>

		<%
		}
		%>

	</table>

	<%
	}
	%>

</body>
</html>