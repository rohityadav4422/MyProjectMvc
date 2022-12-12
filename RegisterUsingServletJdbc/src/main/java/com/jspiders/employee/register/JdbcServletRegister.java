package com.jspiders.employee.register;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp")
public class JdbcServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Connection connection;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	static FileReader fileReader;
	static Properties properties = new Properties();
	static String query;
	static String filePath = "D:\\Eclipse\\Java Advance\\RegisterUsingServletJdbc\\resources\\db_info.properties";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			 PrintWriter writer=response.getWriter();
			 String	id= request.getParameter("id");
			 String	name= request.getParameter("name");
			 String	address= request.getParameter("address");
			 String	dob= request.getParameter("DOB");
			 String	contact= request.getParameter("contact");
		     String	email= request.getParameter("email");		     
		     String	password= request.getParameter("password");

			fileReader = new FileReader(filePath);

			properties.load(fileReader);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(
					properties.getProperty("dbPath"), 
					properties);

			query = "insert into  employee values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, dob);
			preparedStatement.setString(5, contact);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, password);
			
			int update = preparedStatement.executeUpdate();
			writer.println("<h1>"+name+"'S record added succesfully in database.</h1>");
			System.out.println("Query ok, "+update+" row(s) affected");
			writer.println("Query ok, "+update+" row(s) affected");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
