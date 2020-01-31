package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;


@WebServlet("/search.lti")
public class SearchServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterM rm= new RegisterM();
		String city=	request.getParameter("city");
		
	RegisterDao d=new RegisterDao();
	ResultSet rs = 	d.Search(city);
	PrintWriter out = response.getWriter();
	try {
		while(rs.next()){
		out.println("<h1> "+rs.getString(1)+"</h1>");
		out.println("<h1> "+rs.getString(3)+"</h1>");
		out.println("<h1> "+rs.getString(4)+"</h1>");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	
}
