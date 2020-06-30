package com.project.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Sport;
import com.project.repo.SportRepo;
import com.project.service.SportService;


@WebServlet("/AddSport")
public class AddSport extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got into the servlet");
		Sport sport = new Sport();
		//SportRepo sportRepo = new SportRepo();
		System.out.println(req.getServletPath());
		String sportName = req.getParameter("name");
		System.out.println(sportName);
		int sportid = Integer.parseInt(req.getParameter("sportid"));
		int schoolid = Integer.parseInt(req.getParameter("schoolid"));
		int seasonid = Integer.parseInt(req.getParameter("seasonid"));
		
		sport.setName(sportName);
		sport.setSchoolId(schoolid);
		sport.setSeasonId(seasonid);
		sport.setSportId(sportid);
		
		SportService service = new SportService();
		boolean saved = service.saveSport(sport);
		
		if (saved) {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("added-sport.html");
			requestDispatcher.forward(req, resp);
			
		}
		else {
			System.out.println("heyyy");
		}
		
		
		

		
		
		
		
		
		// resp.sendRedirect("added-product.jsp");
		}

	}


