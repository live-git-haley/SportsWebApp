package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.repo.SportRepo;
import com.project.model.*;

@WebServlet("/DisplaySport")
public class DisplaySport extends HttpServlet {

	@Override
	///The service method 
	///ACCEPTS REQUEST FROM THE BROWSER
	/// processes the request and SENDS the response 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Access the Repoository to fetch the Sport 
		SportRepo sportRepo = new SportRepo();
		//Sport sport = sportRepo.getFirstSport();
		List<Sport> sportList = sportRepo.getSports();
		System.out.println(sportList.toString());
		
		PrintWriter printWriter = resp.getWriter();
		
		
		
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Display Sport</title>");
		printWriter.println("</head>");
		printWriter.println("<body>" + sportList.toString());
		
		
	
		printWriter.println("<form action='....'>");
		printWriter.println("<br>");
		printWriter.println("<label for='sports'>Please pick a sport</label>");
		printWriter.println("<select required id='sports' name='sports'>");
		printWriter.println("<option value=' ' disabled selected hidden> Please Choose...</option>");
		for (Sport s: sportList) {
			printWriter.println("<option value='name'> " + s.getName() + "</option>");
			
		}
		
		
		printWriter.println("</select>");
		
		
				     
		printWriter.println("</form>");
		printWriter.println("<p> If you do not see your sport click here </p>");
		printWriter.println("</body>");
		printWriter.println("</html>");
		
	
		
		
	}

}
