package com.project.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddSport")
public class AddSport extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sportid = req.getParameter("sportid");
		String sportName = req.getParameter("name");
		System.out.println(sportid);
		System.out.println(sportName);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-sport.html");
		// resp.sendRedirect("added-product.jsp");
		}

	}


