package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.repo.SportRepo;
import com.project.model.*;

@WebServlet("/SearchSportController")
public class SearchSportController extends HttpServlet {

	@Override
	/// The service method
	/// ACCEPTS REQUEST FROM THE BROWSER
	/// processes the request and SENDS the response
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("searchinput");
	
		Sport sportfound = new Sport();
		SportRepo sportrepo = new SportRepo();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "haleykobe2");
			System.out.println("Connected!");
			
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			System.out.println("searching...");
			ResultSet resultSet = statement.executeQuery("select * from sport where name like '%" + input + "%';");
			String s = "select * from sport where name like '% " + input + "%';";
			System.out.println(s);
			ArrayList<Sport> foundlist = new ArrayList<Sport>();
			 while (resultSet.next()) { 
					Sport sport = new Sport();
					sport.setSportId(resultSet.getInt("sportid"));
					sport.setName(resultSet.getString("name")); 
					sport.setSchoolId(resultSet.getInt("schoolid"));
					sport.setSeasonId(resultSet.getInt("sportid"));
					foundlist.add(sport);
				 }
			 
			 System.out.println("after the while list");
			
			 request.setAttribute("foundlist", foundlist);
			 

		
			resultSet.close();
			statement.close();

	}
		catch(SQLException  | ClassNotFoundException e ) {
			System.out.println(e);
		}
		
	
		
		 System.out.println(request.getAttribute("foundlist"));

		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("search-jsp.jsp");
		requestDispatcher.forward(request, response);
	}

}
