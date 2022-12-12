package com.jspiders.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetflixLogin
 */
@WebServlet("/NetflixLogin")
public class NetflixLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NetflixLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
       PrintWriter writer=response.getWriter();
       writer.println("<!DOCTYPE html>\r\n"
       		+ "<html lang=\"en\">\r\n"
       		+ "<head>\r\n"
       		+ "    <meta charset=\"UTF-8\">\r\n"
       		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
       		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
       		+ "    <title>Document</title>\r\n"
       		+ "    <link rel=\"stylesheet\" href=\"./Netflix.css\">\r\n"
       		+ "    <style>\r\n"
       		+ "        #main{\r\n"
       		+ "    margin: auto;\r\n"
       		+ "    background-color: rgba(22, 21, 21, 0.993);\r\n"
       		+ "    border: 5px solid red;\r\n"
       		+ "    background-size: cover;\r\n"
       		+ "    margin-top: 5%;\r\n"
       		+ "    margin-left: 40%;\r\n"
       		+ "    height: 700px;\r\n"
       		+ "    width: 500px;\r\n"
       		+ "    box-shadow: 12px 10px 15px rgba(0, 0, 0, 0.925);\r\n"
       		+ "    \r\n"
       		+ "}\r\n"
       		+ "h2{margin-top: 15px;\r\n"
       		+ "    margin-left: 26px;\r\n"
       		+ "    color: red;\r\n"
       		+ "    font-size: xx-large;\r\n"
       		+ "    font-family: Netflix Sans,Helvetica Neue,Segoe UI,Roboto,Ubuntu,sans-serif;\r\n"
       		+ "}\r\n"
       		+ ".signin{margin-top: 12px;\r\n"
       		+ "    font-size: 35px;\r\n"
       		+ "    margin-left: 50px;\r\n"
       		+ "    color: white;\r\n"
       		+ "}\r\n"
       		+ ".in1 input{\r\n"
       		+ "    height: 40px;\r\n"
       		+ "    width: 400px;\r\n"
       		+ "}\r\n"
       		+ "#email,#password{\r\n"
       		+ "    margin-top: 25px;\r\n"
       		+ "    margin-left: 50px;\r\n"
       		+ "}\r\n"
       		+ "#submit input{\r\n"
       		+ "    margin-top: 65px;\r\n"
       		+ "background-color: rgb(241, 29, 14);\r\n"
       		+ "height: 40px;\r\n"
       		+ "width: 410px;\r\n"
       		+ "margin-left: 50px;\r\n"
       		+ "font-size: 20px;\r\n"
       		+ "color: white;\r\n"
       		+ "}\r\n"
       		+ "#submit .check{\r\n"
       		+ "    margin-top: 20px;\r\n"
       		+ "    height: 20px;\r\n"
       		+ "width: 400px;\r\n"
       		+ "margin-left: -137px;\r\n"
       		+ "}\r\n"
       		+ "h4{\r\n"
       		+ "    margin-top: -26px;\r\n"
       		+ "    margin-left: 80px;\r\n"
       		+ "    color: white;\r\n"
       		+ "}\r\n"
       		+ "#signup{\r\n"
       		+ "margin-top: 50px;\r\n"
       		+ "margin-left: 50px;\r\n"
       		+ " color: white;\r\n"
       		+ " font-size: 20px;\r\n"
       		+ "}\r\n"
       		+ "a{\r\n"
       		+ "    text-decoration: none;\r\n"
       		+ "}\r\n"
       		+ "\r\n"
       		+ "    </style>    \r\n"
       		+ "</head>\r\n"
       		+ "<body>\r\n"
       		+ "    \r\n"
       		+ "<div id=\"main\">\r\n"
       		+ "    <div class=\"header\">\r\n"
       		+ "        <H2 >NETFLIX</H2>\r\n"
       		+ "    </div>\r\n"
       		+ "    <div class=\"signin\">Sign In</div>\r\n"
       		+ "    <div class=\"in1\">\r\n"
       		+ "        <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Email Or Phone Number\"><br>\r\n"
       		+ "        <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"password\">\r\n"
       		+ "    </div>\r\n"
       		+ "    <div id=\"submit\"><input type=\"submit\" value=\"Sign In\"><br>\r\n"
       		+ "    <input type=\"checkbox\" class=\"check\"><h4> Remember me</h4>\r\n"
       		+ "    </div>\r\n"
       		+ "    <div id=\"signup\">\r\n"
       		+ "        <label for=\"\">New to Netflix?</label>\r\n"
       		+ "        <a href=\"#\">Sign up now.</a>\r\n"
       		+ "    </div>\r\n"
       		+ "</div>\r\n"
       		+ "\r\n"
       		+ "    \r\n"
       		+ "</body>\r\n"
       		+ "</html>");
		
	}
	}


