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
	/// The service method
	/// ACCEPTS REQUEST FROM THE BROWSER
	/// processes the request and SENDS the response
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Access the Repoository to fetch the Sport
		SportRepo sportRepo = new SportRepo();
		// Sport sport = sportRepo.getFirstSport();
		List<Sport> sportList = sportRepo.getSports();

		PrintWriter printWriter = resp.getWriter();

		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Display Sport </title>");
		printWriter.println("<link rel='stylesheet'  type='text/css' href='styles.css'/>");
		printWriter.println(
				"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin=anonymous'>");
		printWriter.println(
				"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>");

		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<br>");
		printWriter.println("<br>");
		printWriter.println("<br>");
		printWriter.println("<h1>Sports Database</h1>");
		printWriter.println("<table class='table'>");
		printWriter.println("<thead class='thead-dark'>");
		printWriter.println("<tr>");
		printWriter.println("<th scope='col'>SportID</th>");
		printWriter.println("<th scope='col'>Name</th>");
		printWriter.println("<th scope='col'>SchoolID</th>");
		printWriter.println("<th scope='col'>SeasonID</th>");
		printWriter.println("</tr>");
		printWriter.println("</thead>");
		printWriter.println("<tbody class='tbody-light'>");
		for (Sport s : sportList) {
			printWriter.println("<tr>");
			printWriter.println("<th scope='row'> " + s.getSportId()  + "</th>");
			printWriter.println("<td>" +s.getName() + "</td>");
			printWriter.println("<td>" +s.getSchoolId() + "</td>");
			printWriter.println("<td>" +s.getSeasonId() + "</td>");
			printWriter.println("</tr>");

		}
		
		printWriter.println("</tbody>");
		printWriter.println("</table>");
		printWriter.println("<p> If you do not see your sport click <a href='add-sport.html'>here</a> </p>");
		printWriter.println(
				"<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js' integrity='sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj' crossorigin='anonymous'></script>");
		printWriter.println(
				"<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js' integrity='sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo' crossorigin='anonymous'></script>");
		printWriter.println(
				"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js' integrity='sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI' crossorigin='anonymous'></script>");
		printWriter.println("</body>");
		printWriter.println("</html>");

		
	}

}
