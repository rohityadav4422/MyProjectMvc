<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String name= request.getParameter("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
<style type="text/css">
fieldset{margin-top: 100px;}
legend{text-align: center;}
label{
color: black;
margin-left: 500px;
}
input{
background-color: white;
border-radius: 10px;
margin: auto;
margin-left: -90px;}
input[type="submit"]{margin-top:10px;
margin-left: 590px}
</style>
</head>
<body>
<fieldset style="border: 10px solid;" >
		<legend style="font-size: 30px">::: Insert Student Details :::</legend>
		<form method="post" action="./addStudent" style="background-color: pink;">
			<table>

				<tr>
					<td><label>Name</label>
					<td>
					<td><input type="text" name="name" placeholder="enter name">
					<td>
				</tr>

				<tr>
					<td><label>Email</label>
					<td>
					<td><input type="text" name="email" placeholder="enter email">
					<td>
				</tr>

				<tr>
					<td><label>UserName</label>
					<td>
					<td><input type="text" name="userName" placeholder="enter username">
					<td>
				</tr>
				<tr>
					<td><label>password</label>
					<td>
					<td><input type="password" name="password" placeholder="enter password">
					<td>
				</tr>
				

				<tr>
					<td><input type="submit" value="Add student"></td>
				</tr>

			</table>
		</form>

	</fieldset>

</body>
</html>