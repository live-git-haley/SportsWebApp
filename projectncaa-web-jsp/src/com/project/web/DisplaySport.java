package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.repo.SportRepo;
import com.project.model.*;

@WebServlet("/DisplaySport")
public class DisplaySport extends HttpServlet{
	
	
	@Override
	///The service method 
	///ACCEPTS REQUEST FROM THE BROWSER
	/// processes the request and SENDS the response 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Access the Repoository to fetch the Sport 
		SportRepo sportRepo = new SportRepo();
		Sport sport = sportRepo.getFirstSport();
		
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Display Sport</title>");
		printWriter.println("</head>");
		printWriter.println("<body>" + sport.toString() + "</body>");
		
	
		printWriter.println("<h1>user details..</h1>");
		
		
	}

}
