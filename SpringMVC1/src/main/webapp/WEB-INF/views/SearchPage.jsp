<%@page import="com.qspider.springmvc.DTO.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% StudentDTO student=(StudentDTO)request.getAttribute("student");  %>
<% String msg=(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <fieldset>
   <legend>::: Search Student ID :::</legend>
   <form  method="post" action="./searchStudent">
   <table>
     <tr>
         <td><label>Find Student ID</label> </td>
         <td><input type="text" name="id" ></td>
     </tr>
     <tr>
         <td><input type="submit" value="Search ID"></td>
     </tr>
   </table>
   </form>
   </fieldset>
   
   <% if (student != null){ %>
   <table>
   <tr>
   <td> Id</td>
   <td>Name</td>
   <td>Email</td>
   </tr>
   <tr>
      <td><%= student.getId() %>  </td>
      <td><%=student.getName() %></td>
      <td><%=student.getEmail() %></td>
   </tr>
   </table>
    <%=msg %>
   
   <%} %>
  
</body>
</html>