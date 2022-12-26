package com.stud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Student extends HttpServlet {

	@Override
	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    }

	 

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        
	        String id = request.getParameter("userId");
	        String name = request.getParameter("userName");
	        String location = request.getParameter("userLocation");
	        	
	 

	    	
	        PrintWriter out = response.getWriter();
	        out.println(id);
	        out.println(name);
	        out.println(location);
	        
	        try {
	        	Connection con = null;
	        	con = JdbcConn.setConnection();
	        	
	        	String query = "INSERT INTO details (id, name, location)" + "VALUES (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, location);
				
				pstmt.execute();
	        	
	        }catch(Exception e) {
	        	
	        	System.out.println(e);
	        }
       

	    }
}
