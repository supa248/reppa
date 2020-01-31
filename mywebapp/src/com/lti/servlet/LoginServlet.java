package com.lti.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.login.UserService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading form data
		String username= request.getParameter("username");
		String password = request.getParameter("password");
	
	    UserService  userService=new UserService();
		boolean isValid=userService.isValidUser(username,password);
		
		if(isValid){
			//checking if remember me option was selected
			
			String rememberMe=request.getParameter("rememberMe");
			if(rememberMe!=null  && rememberMe.equals("yes")){
				String BasicBase64format = Base64.getEncoder().encodeToString(username.getBytes());

				Cookie c1=new Cookie("uname",BasicBase64format);
				c1.setMaxAge(60*60);
				System.out.println("Encoded String:\n"+ BasicBase64format); 
				Cookie c2=new Cookie("pass",password);
				c2.setMaxAge(60*60);
				response.addCookie(c1);
				response.addCookie(c2);
				
			}
			response.sendRedirect("welcome.html");
			
		}
		else
			response.sendRedirect("login.html");
		}
		
	}


