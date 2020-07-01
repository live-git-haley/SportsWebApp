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


@WebServlet("/DeleteSport")
public class DeleteSport extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got into the servlet");
		//SportRepo sportRepo = new SportRepo();
		System.out.println(req.getServletPath());
		
		int sportid = Integer.parseInt(req.getParameter("sportid"));
		
		SportService service = new SportService();
		service.deleteSport(sportid);
		
		
		}

	}
