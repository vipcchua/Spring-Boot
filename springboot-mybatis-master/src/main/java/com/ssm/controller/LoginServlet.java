package com.ssm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String randomForm = req.getParameter("randomCode");
		String username = req.getParameter("username");
		String randomInSession = (String) session
				.getAttribute("RANDOM_IN_SESSION");
		if (randomForm.equals(randomInSession)) {
			req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
			session.removeAttribute("RANDOM_IN_SESSION");
		} else {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}

}